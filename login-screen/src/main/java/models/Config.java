/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author faculdade
 */
public class Config {
    private Integer idConfig;
    private String fkComputador;
    private Integer fkComponente;

    public Config(Integer idConfig, String fkComputador, Integer fkComponente) {
        this.idConfig = idConfig;
        this.fkComputador = fkComputador;
        this.fkComponente = fkComponente;
    }

    public Config() {
    }

    public Integer getIdConfig() {
        return idConfig;
    }

    public void setIdConfig(Integer idConfig) {
        this.idConfig = idConfig;
    }

    public String getFkComputador() {
        return fkComputador;
    }

    public void setFkComputador(String fkComputador) {
        this.fkComputador = fkComputador;
    }

    public Integer getFkComponente() {
        return fkComponente;
    }

    public void setFkComponente(Integer fkComponente) {
        this.fkComponente = fkComponente;
    }
    
    
}
