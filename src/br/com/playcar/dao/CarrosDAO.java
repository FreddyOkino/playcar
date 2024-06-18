/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.playcar.dao;

import br.com.playcar.jdbc.ConnectionFactory;
import br.com.playcar.model.Carros;
import java.sql.Connection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author freddy
 */
public class CarrosDAO {
    
    private final Connection con;

    public CarrosDAO() {
        this.con = new ConnectionFactory().getConection();
    }
    
    //metodo cadastrar carro
    public void cadastrarCarro(Carros obj){
        try {
            String sql = "insert into carros(cliente_id,marca,modelo,cor,placa) values(?,?,?,?,?);";
            PreparedStatement stmt = con.prepareStatement(sql);
            
            stmt.setInt(1, obj.getCliente_id());
            stmt.setString(2, obj.getMarca());
            stmt.setString(3, obj.getModelo());
            stmt.setString(4, obj.getCor());
            stmt.setString(5, obj.getPlaca());
            
            stmt.execute();
            stmt.close();
            JOptionPane.showMessageDialog(null, "Carro cadastrado com sucesso");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"erro: " + e);
        }
    }
    
    public List<Carros> buscarPorCarros(int t){
        try {
            List<Carros> lista = new ArrayList<>();
            String sql = "select * from carros where cliente_id = ?;";
            PreparedStatement stmt = con.prepareStatement(sql);
            
            stmt.setInt(1, t);
                   
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                Carros obj = new Carros();
                obj.setId(rs.getInt("id"));
                obj.setMarca(rs.getString("marca"));
                obj.setModelo(rs.getString("modelo"));
                obj.setCor(rs.getString("cor"));
                obj.setPlaca(rs.getString("placa"));
                lista.add(obj);
            }
            return lista;
        } catch (SQLException e) {
            return null;
        }
    }
    public void excluirCarro(int id){
        try {
            String sql = "delete from carros where id=?";
            PreparedStatement stmt= con.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.execute();
            stmt.close();
            JOptionPane.showMessageDialog(null, "Carro excluido com sucesso");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir carro");
        }
    }
    
    public void editarCarro(Carros obj){
        try {
            String sql = "update carros set marca=?,modelo=?,cor=?, placa=? where id=?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, obj.getMarca());
            stmt.setString(2, obj.getModelo());
            stmt.setString(3, obj.getCor());
            stmt.setString(4, obj.getPlaca());
            stmt.setInt(5, obj.getId());
            stmt.execute();
            stmt.close();
            JOptionPane.showMessageDialog(null, "Carro editado com sucesso");
              
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao editar carro");
        }
    }
}
