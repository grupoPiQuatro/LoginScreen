/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.loginscreen;

import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.memoria.Memoria;
import com.github.britooo.looca.api.group.discos.Volume;
import com.github.britooo.looca.api.group.processador.ProcessadorCacheLoader;
import java.io.IOException;
import java.util.List;
import java.net.InetAddress;
import java.util.GregorianCalendar;

/**
 *
 * @author Rainha Katarine I
 */
public class InserirMetrica {

    private Looca looca;

    public InserirMetrica() {
        this.looca = new Looca();
    }

    public Double getUsoAtualDisco() {
        List<Volume> volumes = looca.getGrupoDeDiscos().getVolumes();

        long l = volumes.get(0).getDisponivel();
        long g = volumes.get(0).getTotal();

        Double response = Math.floor(((l / (1024 * 1024 * 1024))) * 100) / 100;
        Double response1 = Math.floor(((g / (1024 * 1024 * 1024))) * 100) / 100;

        if (response1 < 256) {
            response1 = 256.0;
        } else if (response1 < 512) {
            response1 = 512.0;
        } else {
            response1 = 1024.0;
        }

        Double emUso = response1 - response;
        return emUso;
    }

    public Double getUsoAtualRam() {
        long ram = looca.getMemoria().getEmUso();
        Double r = (double) ram;
        Double usoRam = Math.floor(((r / (1024 * 1024 * 1024))) * 100) / 100;
        return usoRam;
    }

    public Double getUsoAtualCpu() {
        Double usoCpuCheio = looca.getProcessador().getUso();
        Double usoCpu = Math.floor(usoCpuCheio * 100)/100;
        return usoCpu;
    }

    public Long ping() {
        String host = "www.google.com"; // Especifique o host que você deseja pingar
        Long ping = null;
        try {
            InetAddress inetAddress = InetAddress.getByName(host);
            long startTime = System.currentTimeMillis();
            if (inetAddress.isReachable(5000)) { // Timeout de 5 segundos
                long endTime = System.currentTimeMillis();
                long pingTime = endTime - startTime;
                ping = pingTime;
            } else {
                System.out.println("Ping para " + host + " falhou.");
            }
        } catch (IOException e) {
            System.out.println("Ocorreu um erro durante o ping: " + e.getMessage());
        }
        
        return ping;
    }
    
    
   
}
