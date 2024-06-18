/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.playcar.jdbc;


import javax.swing.JOptionPane;

/**
 *
 * @author freddy
 */
public class Connection {
    public static void main(String[] args) {
        try {
            new ConnectionFactory().getConection();
            JOptionPane.showMessageDialog(null, "Conectado com sucesso");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"deu erro" + e);
        }
    }

   
}
