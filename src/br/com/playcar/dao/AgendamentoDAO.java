/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.playcar.dao;

import br.com.playcar.jdbc.ConnectionFactory;
import br.com.playcar.model.Agendamento;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.util.List;

/**
 *
 * @author freddy
 */
public class AgendamentoDAO {

    private final Connection con;

    public AgendamentoDAO() {
        this.con = new ConnectionFactory().getConection();
    }

    public void cadastrarAgendamento(Agendamento obj) {
        try {
            String sql = "insert into agendamentos(data_agendamento,tipo,cliente_id,carro_id,buscar,endereco_id,responsavel_id,nomeCliente) values(?,?,?,?,?,?,?,?);";
            try (PreparedStatement stmt = con.prepareStatement(sql)) {
                
                stmt.setString(1, obj.getData_agendamento());
                stmt.setString(2, obj.getTipo());
                stmt.setInt(3, obj.getCliente_id());
                stmt.setString(4, obj.getCarro_id());
                stmt.setString(5, obj.getBuscar());
                stmt.setString(6, obj.getEndereco_id());
                stmt.setString(7, obj.getResponsavel_id());
                stmt.setString(8, obj.getNomeCliente());
                
                stmt.execute();
            }
            JOptionPane.showMessageDialog(null, "Agendamento cadastrado com sucesso");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar agendamento");
        }
    }
    
    public List<Agendamento> buscarPordata(String data){
        try {
            List<Agendamento> lista = new ArrayList<>();
            
            String sql= "select * from agendamentos where data_agendamento like ?;";
          
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, data);
            
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                Agendamento obj = new Agendamento();
                
                obj.setNomeCliente(rs.getString("nomecliente"));
                obj.setId(rs.getInt("id"));
                obj.setCarro_id(rs.getString("carro_id"));
                obj.setBuscar(rs.getString("buscar"));
                obj.setEndereco_id(rs.getString("endereco_id"));
                obj.setResponsavel_id(rs.getString("responsavel_id"));
                obj.setTipo(rs.getString("tipo"));
                obj.setCliente_id(rs.getInt("cliente_id"));
                lista.add(obj);
            }
            return lista;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }
    
    public List<Agendamento> buscarPorNome(int nome){
        try {
            List<Agendamento> lista = new ArrayList<>();
            
            String sql= "select * from agendamentos where cliente_id = ?;";
          
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, nome);
            
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                Agendamento obj = new Agendamento();
                
                obj.setData_agendamento(rs.getString("data_agendamento"));
                obj.setCliente_id(rs.getInt("cliente_id"));
                obj.setCarro_id(rs.getString("carro_id"));
                obj.setBuscar(rs.getString("buscar"));
                obj.setEndereco_id(rs.getString("endereco_id"));
                obj.setResponsavel_id(rs.getString("responsavel_id"));
                obj.setTipo(rs.getString("tipo"));
                lista.add(obj);
            }
            return lista;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }
    public void excluirAgendamento(int id){
        try {
            String sql = "delete from agendamentos where id=?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.execute();
            stmt.close();
            JOptionPane.showMessageDialog(null, "Agendamento excluido com sucesso");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir agendamento");
        }
    }
    
}
