/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.loginscreen;

/**
 *
 * @author Nathan David
 */
public class Computador {
    private String serialComputador;
    private String sistemaOperacional;
    private String status;
    
    public Computador(String serialComputador, String sistemaOperacional, String status) {
        this.serialComputador = serialComputador;
        this.sistemaOperacional = sistemaOperacional;
        this.status = status;
    }
    
    public Computador() {
        
    }

    public String getSerialComputador() {
        return serialComputador;
    }

    public void setSerialComputador(String serialComputador) {
        this.serialComputador = serialComputador;
    }

    public String getSistemaOperacional() {
        return sistemaOperacional;
    }

    public void setSistemaOperacional(String sistemaOperacional) {
        this.sistemaOperacional = sistemaOperacional;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
            
}
