/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.beibe.tads.dao;

import com.br.beibe.tads.bean.Produto;
import com.br.beibe.tads.exception.DAOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author nicol
 */
public class ProdutoDAO {
    private static final String QUERY_BUSCAR_TODOS_APENAS_ID_NOME = "SELECT id, nome FROM produto";
    private Connection con = null;
    
    public ProdutoDAO(Connection con) throws DAOException {
        if (con == null) {
            throw new DAOException("Conexão nula ao criar TipoAtendimentoDAO.");
        }
        this.con = con;
    }
    
    public List<Produto> buscarTodosApenasIdNome() throws DAOException {
        try (PreparedStatement st = con.prepareStatement(QUERY_BUSCAR_TODOS_APENAS_ID_NOME)) {
            
            ResultSet rs = st.executeQuery();
            List<Produto> listProduto = new ArrayList<>();
            
            if (rs.next()) {
                Produto produto = new Produto();
                produto.setId(Integer.valueOf(rs.getString("id")));
                produto.setNome((rs.getString("nome")));
                listProduto.add(produto);
            }
            
            return listProduto;
        }
        catch(SQLException e) {
            throw new DAOException("Erro ao listar todos os produtos por nome e id: " + QUERY_BUSCAR_TODOS_APENAS_ID_NOME, e);
        }
    }
}
