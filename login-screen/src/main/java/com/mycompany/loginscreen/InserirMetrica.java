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
        long l = 0;
        List<Volume> volumes = looca.getGrupoDeDiscos().getVolumes();
        for (Volume volume : volumes) {
            l = volume.getDisponivel();
        }
        Double d = (double)l;
        Double response = Math.floor((( d / (1024 * 1024 * 1024)))* 100)/100;
        return response;
    }
    
        public Double getUsoAtualRam() {
        long ram = looca.getMemoria().getEmUso();
        Double r = (double)ram;
        Double response = Math.floor((( r / (1024 * 1024 * 1024)))* 100)/100;
        return response;
    }
}
