/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.loginscreen;

import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author Rainha Katarine I
 */
public class Teste {

    public static void main(String[] args) {
        InserirMetrica im = new InserirMetrica();
        InfoPc infoPc = new InfoPc();

        
//            im.inserirMetrica();
//        String hostname = infoPc.hostName();
            
//        System.out.println(im.fkConfigRam());
//        System.out.println(im.fkConfigRede());
//        System.out.println(im.fkConfigCpu());
        System.out.println(im.fkConfigArmazenamento());
        System.out.println("*******************************");
//        System.out.println(im.fkConfigRam2());
//        System.out.println(im.fkConfigRede2());
//        System.out.println(im.fkConfigCpu2());
        System.out.println(im.fkConfigArmazenamento2());
//        System.out.println(im.ping() + "MS");
//        System.out.println(im.teste());
//        new Timer().scheduleAtFixedRate(new TimerTask() {
//
//            public void run() {
//                System.out.println(im.getUsoAtualDisco() + " Disco");
//                System.out.println(im.getUsoAtualRam() + " RAM");
//                System.out.println(im.getUsoAtualCpu() + " CPU");
//                System.out.println(im.ping() + "MS");
//            }
//        }, 0, 5000);
    }
}
