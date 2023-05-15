/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.loginscreen;

import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.memoria.Memoria;
import com.github.britooo.looca.api.group.discos.Volume;
import java.util.List;

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
      
       Double response = Math.floor((( l / (1024 * 1024 * 1024)))* 100)/100;
       Double response1 = Math.floor((( g / (1024 * 1024 * 1024)))* 100)/100;
       
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
        Double r = (double)ram;
        Double response = Math.floor((( r / (1024 * 1024 * 1024)))* 100)/100;
        return response;
    }
}
