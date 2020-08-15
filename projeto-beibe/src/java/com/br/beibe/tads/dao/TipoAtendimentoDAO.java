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
import com.br.beibe.tads.bean.TipoAtendimento;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author nicol
 */
public class TipoAtendimentoDAO {
    private static final String QUERY_BUSCAR_TODOS = "SELECT id, nome FROM tipo_atendimento";
    private Connection con = null;
    
    public TipoAtendimentoDAO(Connection con) throws DAOException {
        if (con == null) {
            throw new DAOException("Conexão nula ao criar TipoAtendimentoDAO.");
        }
        this.con = con;
    }
    
    public List<TipoAtendimento> buscarTodos() throws DAOException {
        try (PreparedStatement st = con.prepareStatement(QUERY_BUSCAR_TODOS)) {
            
            ResultSet rs = st.executeQuery();
            List<TipoAtendimento> listAtendimento = new ArrayList<>();
            
            if (rs.next()) {
                TipoAtendimento tipoAtendimento = new TipoAtendimento();
                tipoAtendimento.setId(Integer.valueOf(rs.getString("id")));
                tipoAtendimento.setNome((rs.getString("nome")));
                listAtendimento.add(tipoAtendimento);
            }
            
            return listAtendimento;
        }
        catch(SQLException e) {
            throw new DAOException("Erro ao listar todos os tipos de atendimento: " + QUERY_BUSCAR_TODOS, e);
        }
    }
}
