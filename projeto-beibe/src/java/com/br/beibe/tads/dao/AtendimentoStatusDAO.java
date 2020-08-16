/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.beibe.tads.dao;

import com.br.beibe.tads.bean.AtendimentoStatus;
import com.br.beibe.tads.exception.DAOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author nicol
 */
public class AtendimentoStatusDAO {
    
    private static final String QUERY_BUSCAR_POR_ID = "SELECT id, nome FROM atendimento_status WHERE id = ?";
    private Connection con = null;
    
    public AtendimentoStatusDAO(Connection con) throws DAOException {
        if (con == null) {
            throw new DAOException("Conexão nula ao criar AtendimentoStatusDAO.");
        }
        this.con = con;
    }
    
    public AtendimentoStatus buscarPorId(int id) throws DAOException {
        try (PreparedStatement st = con.prepareStatement(QUERY_BUSCAR_POR_ID)) {
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            AtendimentoStatus as = new AtendimentoStatus();
            if (rs.next()) {
                as.setId(Integer.valueOf(rs.getString("id")));
                as.setNome(rs.getString("nome"));
            }
            return as;
        }
        catch(SQLException e) {
            throw new DAOException("Erro ao buscar atendimento status: " +
            QUERY_BUSCAR_POR_ID +
            "/ " + id, e);
        }
    }
}
