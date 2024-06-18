/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.playcar.jdbc;
import java.sql.DriverManager;

/**
 *
 * @author freddy
 */
public class ConnectionFactory {
    public java.sql.Connection getConection(){
        try {
            return DriverManager.getConnection("jdbc:postgresql://localhost:5433/dbplaycar", "postgres", "123");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
