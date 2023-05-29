/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.time.LocalDateTime;

/**
 *
 * @author Rainha Katarine I
 */
public class HistoricoReiniciar {
    private Integer id;
    private Integer tempoReiniciar;
    private LocalDateTime dtCaptura ;
    private String fkComputador ;

    public HistoricoReiniciar(Integer id, Integer tempoReiniciar, LocalDateTime dtCaptura, String fkComputador) {
        this.id = id;
        this.tempoReiniciar = tempoReiniciar;
        this.dtCaptura = dtCaptura;
        this.fkComputador = fkComputador;
    }

    public HistoricoReiniciar() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTempoReiniciar() {
        return tempoReiniciar;
    }

    public void setTempoReiniciar(Integer tempoReiniciar) {
        this.tempoReiniciar = tempoReiniciar;
    }

    public LocalDateTime getDtCaptura() {
        return dtCaptura;
    }

    public void setDtCaptura(LocalDateTime dtCaptura) {
        this.dtCaptura = dtCaptura;
    }

    public String getFkComputador() {
        return fkComputador;
    }

    public void setFkComputador(String fkComputador) {
        this.fkComputador = fkComputador;
    }

    @Override
    public String toString() {
        return "HistoricoReiniciar{" + "id=" + id + ", tempoReiniciar=" + tempoReiniciar + ", dtCaptura=" + dtCaptura + ", fkComputador=" + fkComputador + '}';
    }
    
    
}
