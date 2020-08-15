/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.beibe.tads.facade;

import com.br.beibe.tads.bean.Cidade;
import com.br.beibe.tads.dao.CidadeDAO;
import com.br.beibe.tads.exception.CONException;
import com.br.beibe.tads.exception.DAOException;
import com.br.beibe.tads.factory.ConnectionFactory;
import java.util.List;

/**
 *
 * @author nicol
 */
public class CidadeFacade {
    public static Cidade buscarPorId(int id) throws DAOException, CONException {
        try {
            ConnectionFactory con = new ConnectionFactory();
            CidadeDAO cidadeDAO = new CidadeDAO(con.getConnection());
            return cidadeDAO.buscaPorId(id);
        } catch (DAOException e) {
            throw new DAOException("Não foi possível encontrar a cidade para o id: " + "/ " + id, e);
        } catch (CONException e) {
            throw new CONException("Não foi possível se conectar ao sistema! Tente novamente mais tarde. ", e);
        }
    }
    
    public static List<Cidade> buscarTodos() throws DAOException, CONException {
        try {
            ConnectionFactory con = new ConnectionFactory();
            CidadeDAO cidadeDAO = new CidadeDAO(con.getConnection());
            return cidadeDAO.buscarTodos();
        } catch (DAOException e) {
            throw new DAOException("Não foi possível encontrar todas as cidades: ", e);
        } catch (CONException e) {
            throw new CONException("Não foi possível se conectar ao sistema! Tente novamente mais tarde. ", e);
        }
    }
}
