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
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author nicol
 */
public class CidadeDAO {
    private static final String QUERY_BUSCAR_POR_ID = "SELECT id, idfk_estado, nome FROM cidade WHERE id = ?";
    private static final String QUERY_BUSCAR_TODOS = "SELECT id, idfk_estado, nome FROM cidade";
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
    
    public List<Cidade> buscarTodos() throws DAOException, CONException {
        try (PreparedStatement st = con.prepareStatement(QUERY_BUSCAR_TODOS)) {
            
            ResultSet rs = st.executeQuery();
            List<Cidade> listaCidade = new ArrayList<>();
            
            if (rs.next()) {
                Cidade cidade = new Cidade();
                cidade.setId(Integer.valueOf(rs.getString("id")));
                cidade.setNome((rs.getString("nome")));
                Estado estado = EstadoFacade.buscarPorId(rs.getInt("idfk_estado"));
                cidade.setEstado(estado);
                listaCidade.add(cidade);
            }
            
            return listaCidade;
        }
        catch(SQLException e) {
            throw new DAOException("Erro ao listar todos os estados: " + QUERY_BUSCAR_TODOS, e);
        }
    }
}
