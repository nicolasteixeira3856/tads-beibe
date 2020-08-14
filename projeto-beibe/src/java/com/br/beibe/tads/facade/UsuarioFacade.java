/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.beibe.tads.facade;

import com.br.beibe.tads.bean.Usuario;
import com.br.beibe.tads.dao.UsuarioDAO;
import com.br.beibe.tads.exception.CONException;
import com.br.beibe.tads.exception.DAOException;
import com.br.beibe.tads.factory.ConnectionFactory;

/**
 *
 * @author nicol
 */
public class UsuarioFacade {
    public static Usuario buscarPorEmail(String email) throws DAOException, CONException {
        ConnectionFactory con = new ConnectionFactory();
        UsuarioDAO usuarioDAO = new UsuarioDAO(con.getConnection());
        return usuarioDAO.buscarPorEmail(email);
    }
}
