/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.loginscreen;

import java.time.LocalDateTime;

/**
 *
 * @author Rainha Katarine I
 */
public class Metrica {
    private Integer idMetrica;
    private Double valor;
    private String unidade;
    private LocalDateTime dtCaptura;
    private Integer fkConfig ;

    public Metrica(Integer idMetrica, Double valor, String unidade, LocalDateTime dtCaptura, Integer fkConfig) {
        this.idMetrica = idMetrica;
        this.valor = valor;
        this.unidade = unidade;
        this.dtCaptura = dtCaptura;
        this.fkConfig = fkConfig;
    }

    public Metrica() {
    }

    public Integer getIdMetrica() {
        return idMetrica;
    }

    public void setIdMetrica(Integer idMetrica) {
        this.idMetrica = idMetrica;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

    public LocalDateTime getDtCaptura() {
        return dtCaptura;
    }

    public void setDtCaptura(LocalDateTime dtCaptura) {
        this.dtCaptura = dtCaptura;
    }

    public Integer getFkConfig() {
        return fkConfig;
    }

    public void setFkConfig(Integer fkConfig) {
        this.fkConfig = fkConfig;
    }

    @Override
    public String toString() {
        return "Metrica{" + "idMetrica=" + idMetrica + ", valor=" + valor + ", unidade=" + unidade + ", dtCaptura=" + dtCaptura + ", fkConfig=" + fkConfig + '}';
    }
    
    
    
}
