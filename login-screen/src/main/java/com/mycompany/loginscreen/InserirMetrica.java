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
        long teste = looca.getGrupoDeDiscos().getTamanhoTotal();
//        long l = 0;
        long s = 0;
        List<Volume> volumes = looca.getGrupoDeDiscos().getVolumes();
        
        long l = volumes.get(0).getDisponivel();
        long g = volumes.get(0).getTotal();
        //volumes.get(0).getTotal();
//        for (Volume volume : volumes) {
//            s = volume.getTotal();
//            l = volume.getDisponivel();
//        }
       Double response = Math.floor((( l / (1024 * 1024 * 1024)))* 100)/100;
       Double response1 = Math.floor((( g / (1024 * 1024 * 1024)))* 100)/100;
        //Double response1 = Math.floor((( r1 / (1024 * 1024 * 1024)))* 100)/100;
        return response;
    }
    
        public Double getUsoAtualRam() {
        long ram = looca.getMemoria().getEmUso();
        Double r = (double)ram;
        Double response = Math.floor((( r / (1024 * 1024 * 1024)))* 100)/100;
        return response;
    }
}
