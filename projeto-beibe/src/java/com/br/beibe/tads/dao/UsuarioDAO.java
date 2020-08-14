/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.beibe.tads.dao;

import java.sql.Connection;
import com.br.beibe.tads.exception.DAOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.br.beibe.tads.bean.Usuario;

/**
 *
 * @author nicol
 */
public class UsuarioDAO {
    private static final String QUERY_BUSCAR_LOGIN = "SELECT id, nome, cpf, email, endereco, senha, nivel FROM usuario WHERE email = ?";
    private Connection con = null;
    
    public UsuarioDAO(Connection con) throws DAOException {
        if (con == null) {
            throw new DAOException("Conexão nula ao criar PessoaDAO.");
        }
        this.con = con;
    }
    
    public Usuario buscarPorEmail(String email) throws DAOException {
        try (PreparedStatement st = con.prepareStatement(QUERY_BUSCAR_LOGIN)) {
            st.setString(1, email);
            ResultSet rs = st.executeQuery();
            Usuario u = new Usuario();
            if (rs.next()) {
                u.setId(Integer.valueOf(rs.getString("id")));
                u.setEmail(rs.getString("email"));
                u.setSenha(rs.getString("senha"));
                u.setNivel(Integer.valueOf(rs.getString("nivel")));
            }
            return u;
        }
        catch(SQLException e) {
            throw new DAOException("Erro ao buscar usuario: " +
            QUERY_BUSCAR_LOGIN +
            "/ " + email, e);
        }
    }
}
