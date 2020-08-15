/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.beibe.tads.dao;

import com.br.beibe.tads.bean.Estado;
import com.br.beibe.tads.exception.DAOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author nicol
 */
public class EstadoDAO {
    private static final String QUERY_BUSCAR_POR_ID = "SELECT id, nome FROM estado WHERE id = ?";
    private Connection con = null;
    
    public EstadoDAO(Connection con) throws DAOException {
        if (con == null) {
            throw new DAOException("Conexão nula ao criar CidadeDAO.");
        }
        this.con = con;
    }
    
    public Estado buscaPorId(int id) throws DAOException {
        try (PreparedStatement st = con.prepareStatement(QUERY_BUSCAR_POR_ID)) {
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            Estado e = new Estado();
            if (rs.next()) {
                e.setId(Integer.valueOf(rs.getString("id")));
                e.setNome(rs.getString("nome"));
            }
            return e;
        }
        catch(SQLException e) {
            throw new DAOException("Erro ao buscar estado: " +
            QUERY_BUSCAR_POR_ID +
            "/ " + id, e);
        }
    }
}
