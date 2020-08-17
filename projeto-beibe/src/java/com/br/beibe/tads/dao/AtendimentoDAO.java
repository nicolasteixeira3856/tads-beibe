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
import com.br.beibe.tads.exception.CONException;
import com.br.beibe.tads.bean.AtendimentoStatus;
import com.br.beibe.tads.facade.AtendimentoStatusFacade;
import com.br.beibe.tads.bean.Produto;
import com.br.beibe.tads.facade.ProdutoFacade;
import com.br.beibe.tads.bean.TipoAtendimento;
import com.br.beibe.tads.facade.TipoAtendimentoFacade;
import com.br.beibe.tads.bean.Usuario;
import com.br.beibe.tads.facade.UsuarioFacade;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.br.beibe.tads.bean.Usuario;

/**
 *
 * @author nicol
 */
public class AtendimentoDAO {
    
    private static final String QUERY_NOVO_ATENDIMENTO = "INSERT INTO atendimento (idfk_usuario, idfk_status, idfk_produto, idfk_tipo_atendimento, descricao) VALUES (?, ?, ?, ?, ?)";
    private static final String QUERY_BUSCA_TODOS_POR_ID_USUARIO = "SELECT id, data_criacao, idfk_usuario, idfk_status, idfk_produto, idfk_tipo_atendimento FROM atendimento WHERE idfk_usuario = ? ORDER BY data_criacao DESC";
    private static final String QUERY_BUSCA_ATENDIMENTO_POR_ID = "SELECT id, data_criacao, idfk_usuario, idfk_status, idfk_produto, idfk_tipo_atendimento, descricao, solucao_apresentada FROM atendimento WHERE id = ?";
    private static final String QUERY_DELETA_ATENDIMENTO_POR_ID = "DELETE FROM atendimento WHERE id = ?";
    private Connection con = null;
    
    public AtendimentoDAO(Connection con) throws DAOException {
        if (con == null) {
            throw new DAOException("Conexão nula ao criar AtendimentoDAO.");
        }
        this.con = con;
    }
    
    public List<Atendimento> buscarTodosPorIdUsuario(Usuario usuario) throws DAOException, CONException {
        try (PreparedStatement st = con.prepareStatement(QUERY_BUSCA_TODOS_POR_ID_USUARIO)) {
            st.setInt(1, usuario.getId());
            ResultSet rs = st.executeQuery();
            List<Atendimento> listaAtendimento = new ArrayList<>();
            
            while (rs.next()) {
                Atendimento atendimento = new Atendimento();
                atendimento.setId(Integer.valueOf(rs.getString("id")));
                atendimento.setDataCriacao(rs.getDate("data_criacao"));
                atendimento.setUsuario(usuario);
                AtendimentoStatus atendimentoStatus = AtendimentoStatusFacade.buscarPorId(Integer.valueOf(rs.getString("idfk_status")));
                atendimento.setStatus(atendimentoStatus);
                Produto produto = ProdutoFacade.buscarPorId(Integer.valueOf(rs.getString("idfk_produto")));
                atendimento.setProduto(produto); 
                TipoAtendimento tipoAtendimento = TipoAtendimentoFacade.buscarPorId(Integer.valueOf(rs.getString("idfk_tipo_atendimento")));
                atendimento.setTipoAtendimento(tipoAtendimento);
                listaAtendimento.add(atendimento);
            }
            
            return listaAtendimento;
        }
        catch(SQLException e) {
            throw new DAOException("Erro ao listar atendimento ao usuário" + QUERY_BUSCA_TODOS_POR_ID_USUARIO, e);
        }
    }
    
    /**
     *
     * @param id
     * @return
     * @throws DAOException
     * @throws CONException
     */
    public Atendimento buscarAtendimentoPorId(int id) throws DAOException, CONException {
        try (PreparedStatement st = con.prepareStatement(QUERY_BUSCA_ATENDIMENTO_POR_ID)) {
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            
            Atendimento atendimento = new Atendimento();
            if (rs.next()) {
                atendimento.setId(Integer.valueOf(rs.getString("id")));
                atendimento.setDataCriacao(rs.getDate("data_criacao"));
                Usuario usuario = UsuarioFacade.buscarPorId(rs.getInt("idfk_usuario"));
                atendimento.setUsuario(usuario);
                AtendimentoStatus atendimentoStatus = AtendimentoStatusFacade.buscarPorId(Integer.valueOf(rs.getString("idfk_status")));
                atendimento.setStatus(atendimentoStatus);
                Produto produto = ProdutoFacade.buscarPorId(Integer.valueOf(rs.getString("idfk_produto")));
                atendimento.setProduto(produto); 
                TipoAtendimento tipoAtendimento = TipoAtendimentoFacade.buscarPorId(Integer.valueOf(rs.getString("idfk_tipo_atendimento")));
                atendimento.setTipoAtendimento(tipoAtendimento);    
                atendimento.setDescricao(rs.getString("descricao"));
            }
            
            return atendimento;
        }
        catch(SQLException e) {
            throw new DAOException("Erro ao buscar atendimento por ID" + QUERY_BUSCA_ATENDIMENTO_POR_ID, e);
        }
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
    
    public void deletarAtendimentoPorId(int id) throws DAOException {
        try (PreparedStatement st = con.prepareStatement(QUERY_DELETA_ATENDIMENTO_POR_ID)) {
            st.setInt(1, id);
            st.executeUpdate();
        }
        catch(SQLException e) {
            throw new DAOException("Erro deletando o atendimento: " +
            QUERY_DELETA_ATENDIMENTO_POR_ID , e);
        }
    }
}
