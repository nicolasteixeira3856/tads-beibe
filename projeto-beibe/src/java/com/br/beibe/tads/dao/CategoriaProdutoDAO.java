/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.beibe.tads.dao;

import com.br.beibe.tads.exception.DAOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import com.br.beibe.tads.bean.CategoriaProduto;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author nicol
 */
public class CategoriaProdutoDAO {
    private static final String QUERY_BUSCAR_POR_ID = "SELECT id, nome FROM categoria_produto WHERE id = ?";
    private Connection con = null;
    
    public CategoriaProdutoDAO(Connection con) throws DAOException {
        if (con == null) {
            throw new DAOException("Conexão nula ao criar CategoriaProdutoDAO.");
        }
        this.con = con;
    }
    
    public CategoriaProduto buscarPorId(int id) throws DAOException {
        try (PreparedStatement st = con.prepareStatement(QUERY_BUSCAR_POR_ID)) {
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            CategoriaProduto cp = new CategoriaProduto();
            if (rs.next()) {
                cp.setId(Integer.valueOf(rs.getString("id")));
                cp.setNome(rs.getString("nome"));
            }
            return cp;
        }
        catch(SQLException e) {
            throw new DAOException("Erro ao buscar categoria de produto: " +
            QUERY_BUSCAR_POR_ID +
            "/ " + id, e);
        }
    }
}
