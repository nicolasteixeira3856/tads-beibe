/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.beibe.tads.dao;

import com.br.beibe.tads.bean.Cidade;
import com.br.beibe.tads.exception.DAOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.br.beibe.tads.facade.EstadoFacade;
import com.br.beibe.tads.bean.Estado;
import com.br.beibe.tads.exception.CONException;

/**
 *
 * @author nicol
 */
public class CidadeDAO {
    private static final String QUERY_BUSCAR_POR_ID = "SELECT id, idfk_estado, nome FROM cidade WHERE id = ?";
    private Connection con = null;
    
    public CidadeDAO(Connection con) throws DAOException {
        if (con == null) {
            throw new DAOException("Conexão nula ao criar CidadeDAO.");
        }
        this.con = con;
    }
    
    public Cidade buscaPorId(int id) throws DAOException, CONException {
        try (PreparedStatement st = con.prepareStatement(QUERY_BUSCAR_POR_ID)) {
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            Cidade c = new Cidade();
            if (rs.next()) {
                c.setId(Integer.valueOf(rs.getString("id")));
                c.setNome(rs.getString("nome"));
                Estado estado = EstadoFacade.buscarPorId(rs.getInt("idfk_estado"));
                c.setEstado(estado);
            }
            return c;
        }
        catch(SQLException e) {
            throw new DAOException("Erro ao buscar cidade: " +
            QUERY_BUSCAR_POR_ID +
            "/ " + id, e);
        }
    }
}
