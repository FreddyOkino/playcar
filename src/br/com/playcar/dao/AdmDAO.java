/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.playcar.dao;

import br.com.playcar.jdbc.ConnectionFactory;
import br.com.playcar.view.FRMenu;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author freddy
 */
public class AdmDAO {

    private final Connection con;

    public AdmDAO() {
        this.con = new ConnectionFactory().getConection();
    }

    //metodo para fazer login
    public void efetuarLogin(String email, String senha) {
        try {
            // comando sql
            String sql = "select * from administrador where email=? and senha=?;";

            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, email);
            stmt.setString(2, senha);

            ResultSet rs = stmt.executeQuery();
            //usuario logou
            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "Seja bem vindo ao sistema");
                FRMenu tela =  new FRMenu(); 
                tela.setVisible(true);
                
            } else {
                JOptionPane.showMessageDialog(null, "Erro ao realizar o login: verifique o usuário e senha");

            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e);

        }

    }
}
