/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.beibe.tads.facade;

import com.br.beibe.tads.dao.AtendimentoDAO;
import com.br.beibe.tads.bean.Atendimento;
import com.br.beibe.tads.bean.Usuario;
import com.br.beibe.tads.exception.CONException;
import com.br.beibe.tads.exception.DAOException;
import com.br.beibe.tads.factory.ConnectionFactory;
import java.util.List;

/**
 *
 * @author nicol
 */
public class AtendimentoFacade {
    
    public static List<Atendimento> buscarTodosPorIdUsuario(Usuario usuario) throws DAOException, CONException {
        try {
            ConnectionFactory con = new ConnectionFactory();
            AtendimentoDAO atendimentoDAO = new AtendimentoDAO(con.getConnection());
            return atendimentoDAO.buscarTodosPorIdUsuario(usuario);
        } catch (DAOException e) {
            throw new DAOException("Não foi possível encontrar os atendimentos do usuário", e);
        } catch (CONException e) {
            throw new CONException("Não foi possível se conectar ao sistema! Tente novamente mais tarde. ", e);
        }
    }
    public static void criarNovoAtendimento(Atendimento atendimento) throws DAOException, CONException {
        try {
            ConnectionFactory con = new ConnectionFactory();
            AtendimentoDAO atendimentoDAO = new AtendimentoDAO(con.getConnection());
            atendimentoDAO.inserir(atendimento);
        } catch (DAOException e) {
            throw new DAOException("Não foi possível criar novo atendimento!", e);
        }
    }
}
