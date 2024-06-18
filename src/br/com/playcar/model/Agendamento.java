/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.playcar.model;

import java.util.Date;

/**
 *
 * @author freddy
 */
public class Agendamento {
    private int id;
    private String data_agendamento ;
    private String tipo;
    private int cliente_id ;
    private String carro_id ;
    private String buscar ;
    private String endereco_id ;
    private String responsavel_id ;
    private String nomeCliente;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    
    public String getData_agendamento() {
        return data_agendamento;
    }

    public void setData_agendamento(String data_agendamento) {
        this.data_agendamento = data_agendamento;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getCliente_id() {
        return cliente_id;
    }

    public void setCliente_id(int cliente_id) {
        this.cliente_id = cliente_id;
    }

    public String getCarro_id() {
        return carro_id;
    }

    public void setCarro_id(String carro_id) {
        this.carro_id = carro_id;
    }

    public String getBuscar() {
        return buscar;
    }

    public void setBuscar(String buscar) {
        this.buscar = buscar;
    }

    public String getEndereco_id() {
        return endereco_id;
    }

    public void setEndereco_id(String endereco_id) {
        this.endereco_id = endereco_id;
    }

    public String getResponsavel_id() {
        return responsavel_id;
    }

    public void setResponsavel_id(String responsavel_id) {
        this.responsavel_id = responsavel_id;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

   
    
    
}
