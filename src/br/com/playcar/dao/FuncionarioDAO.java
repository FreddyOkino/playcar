/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.playcar.dao;

import br.com.playcar.jdbc.ConnectionFactory;
import br.com.playcar.model.Funcionario;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import java.sql.*;

/**
 *
 * @author freddy
 */
public class FuncionarioDAO {

    private final Connection con;

    public FuncionarioDAO() {
        this.con = new ConnectionFactory().getConection();
    }

    //Metodo cadastrarFuncionario
    public void cadastrarFuncionario(Funcionario obj) {
        try {
            //Criar o comando sql
            String sql = "insert into funcionarios(nome,cpf,email,celular,pix) values(?,?,?,?,?);";
            //conectar  o banco de dados
            try (PreparedStatement stmt = con.prepareStatement(sql)) {
                stmt.setString(1, obj.getNome());
                stmt.setString(2, obj.getCpf());
                stmt.setString(3, obj.getEmail());
                stmt.setString(4, obj.getCelular());
                stmt.setString(5, obj.getPix());
                stmt.execute();
                stmt.close();
            }
            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso");
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro" + e);
        }
    }

    //Metdo ALterarFuncionario
    public void alterarFuncionario(Funcionario obj) {
        try {
            //Criar o comando sql
            String sql = "update funcionarios set nome=?,cpf=?,email=?,celular=?,pix=? where id=? ;";
            //conectar  o banco de dados
            try (PreparedStatement stmt = con.prepareStatement(sql)) {
                stmt.setString(1, obj.getNome());
                stmt.setString(2, obj.getCpf());
                stmt.setString(3, obj.getEmail());
                stmt.setString(4, obj.getCelular());
                stmt.setString(5, obj.getPix());
                stmt.setInt(6, obj.getId());
                stmt.execute();
                stmt.close();
            }
            JOptionPane.showMessageDialog(null, "Alterado com sucesso");
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro" + e);
        }
    }

    //Metodo exluirFuncionario
    public void excluirFuncionario(Funcionario obj) {
        try {
            //Criar o comando sql
            String sql = "delete from funcionarios where id = ?;";
            //conectar  o banco de dados
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, obj.getId());

            stmt.execute();
            stmt.close();

            JOptionPane.showMessageDialog(null, "Excuildo com sucesso");
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro" + e);
        }
    }

    //Metodo buscar todos Funcionario
    public List<Funcionario> buscarFuncionarios() {
        try {
            // criar a lista
            List<Funcionario> lista = new ArrayList<>();
            // criar sql
            String sql = "select * from funcionarios;";

            PreparedStatement stmt = con.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Funcionario obj = new Funcionario();

                obj.setId(rs.getInt("id"));
                obj.setNome(rs.getString("nome"));
                obj.setCpf(rs.getString("cpf"));
                obj.setEmail(rs.getString("email"));
                obj.setCelular(rs.getString("celular"));
                obj.setPix(rs.getString("pix"));

                lista.add(obj);

            }
            return lista;
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro" + e);
            return null;
        }
    }
    //metodo buscar por nome
     public List<Funcionario> buscarFuncionariosPorNome(String nome) {
        try {
            // criar a lista
            List<Funcionario> lista = new ArrayList<>();
            // criar sql
            String sql = "select * from funcionarios where nome like ?;";
            
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, nome);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Funcionario obj = new Funcionario();

                obj.setId(rs.getInt("id"));
                obj.setNome(rs.getString("nome"));
                obj.setCpf(rs.getString("cpf"));
                obj.setEmail(rs.getString("email"));
                obj.setCelular(rs.getString("celular"));
                obj.setPix(rs.getString("pix"));

                lista.add(obj);

            }
            return lista;
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro" + e);
            return null;
        }
    }
}
