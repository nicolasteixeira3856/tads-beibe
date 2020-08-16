/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.beibe.tads.dao;

import com.br.beibe.tads.exception.DAOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.br.beibe.tads.bean.Produto;
import com.br.beibe.tads.facade.CategoriaProdutoFacade;
import com.br.beibe.tads.bean.CategoriaProduto;
import com.br.beibe.tads.exception.CONException;

/**
 *
 * @author nicol
 */
public class ProdutoDAO {
    private static final String QUERY_BUSCAR_TODOS_APENAS_ID_NOME = "SELECT id, nome FROM produto";
    private static final String QUERY_BUSCAR_POR_ID = "SELECT id, nome, idfk_categoria, descricao, peso FROM produto WHERE id = ?";
    private static final String QUERY_INSERIR = "INSERT INTO produto (nome, idfk_categoria, descricao, peso) VALUES (?, ?, ?)";
    
    private Connection con = null;
    
    public ProdutoDAO(Connection con) throws DAOException {
        if (con == null) {
            throw new DAOException("Conexão nula ao criar ProdutoDAO.");
        }
        this.con = con;
    }
    
    public Produto buscarPorId(int id) throws DAOException, CONException {
        try (PreparedStatement st = con.prepareStatement(QUERY_BUSCAR_POR_ID)) {
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            Produto p = new Produto();
            if (rs.next()) {
                p.setId(Integer.valueOf(rs.getString("id")));
                p.setNome(rs.getString("nome"));
                CategoriaProduto categoriaProduto = CategoriaProdutoFacade.buscarPorId(rs.getInt("idfk_categoria"));
                p.setCategoria(categoriaProduto);
                p.setDescricao(rs.getString("descricao"));
                p.setPeso(rs.getString("peso"));
            }
            return p;
        }
        catch(SQLException e) {
            throw new DAOException("Erro ao buscar cidade: " +
            QUERY_BUSCAR_POR_ID +
            "/ " + id, e);
        }
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
