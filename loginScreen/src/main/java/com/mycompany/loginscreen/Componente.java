/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.loginscreen;

/**
 *
 * @author Nathan David
 */
public class Componente {
    private Integer idComponente;
    private String tipo;
    private Double numeroChave;
    private String unidadeMedida;

    public Componente(Integer idComponente, String tipo, Double numeroChave, String unidadeMedida) {
        this.idComponente = idComponente;
        this.tipo = tipo;
        this.numeroChave = numeroChave;
        this.unidadeMedida = unidadeMedida;
    }

    public Componente() {
    }

    public Integer getIdComponente() {
        return idComponente;
    }

    public void setIdComponente(Integer idComponente) {
        this.idComponente = idComponente;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Double getNumeroChave() {
        return numeroChave;
    }

    public void setNumeroChave(Double numeroChave) {
        this.numeroChave = numeroChave;
    }

    public String getUnidadeMedida() {
        return unidadeMedida;
    }

    public void setUnidadeMedida(String unidadeMedida) {
        this.unidadeMedida = unidadeMedida;
    }
    
    
}
