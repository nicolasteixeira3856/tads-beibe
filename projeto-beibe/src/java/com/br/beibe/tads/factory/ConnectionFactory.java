/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.beibe.tads.factory;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import com.br.beibe.tads.exception.CONException;

/**
 *
 * @author nicol
 */
public class ConnectionFactory implements AutoCloseable {
    
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/beibe?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false";
    private static final String LOGIN = "root";
    private static final String SENHA = "naruto21";

    private Connection con = null;

    public Connection getConnection() throws CONException {
        if (con == null) {
            try {
                Class.forName(DRIVER);
                con = DriverManager.getConnection(URL, LOGIN, SENHA);
            }
            catch(SQLException e) {
                throw new CONException("Erro conectando ao BD: " + URL + "/" + LOGIN + "/" + SENHA, e);
            } catch (ClassNotFoundException ex) {
                throw new CONException("Driver do banco não encontrado: " + DRIVER, ex);
            }
        }
        return con;
    }

    @Override
    public void close() {
        if (con!=null) {
            try {
                con.close();
                con = null;
            }
            catch(Exception e) {
                System.out.println("Erro fechando a conexão. IGNORADO");
                e.printStackTrace();
            }
        }
    }
}
