/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.beibe.tads.dao;

import com.br.beibe.tads.exception.DAOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.br.beibe.tads.bean.Atendimento;

/**
 *
 * @author nicol
 */
public class AtendimentoDAO {
    
    private static final String QUERY_NOVO_ATENDIMENTO = "INSERT INTO atendimento (idfk_usuario, idfk_status, idfk_produto, idfk_tipo_atendimento, descricaoo) VALUES (?, ?, ?, ?, ?)";
    private Connection con = null;
    
    public AtendimentoDAO(Connection con) throws DAOException {
        if (con == null) {
            throw new DAOException("Conexão nula ao criar AtendimentoDAO.");
        }
        this.con = con;
    }
    
    public void inserir(Atendimento atendimento) throws DAOException {
        try (PreparedStatement st = con.prepareStatement(QUERY_NOVO_ATENDIMENTO)) {
            st.setInt(1, atendimento.getUsuario().getId());
            st.setInt(2, atendimento.getStatus().getId());
            st.setInt(3, atendimento.getProduto().getId());
            st.setInt(4, atendimento.getTipoAtendimento().getId());
            st.setString(5, atendimento.getDescricao());
            st.executeUpdate();
        }
        catch(SQLException e) {
            throw new DAOException("Erro inserindo novo atendimento: " +
            QUERY_NOVO_ATENDIMENTO , e);
        }
    }
}
