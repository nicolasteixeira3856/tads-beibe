/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.beibe.tads.facade;

import java.util.List;
import com.br.beibe.tads.dao.TipoAtendimentoDAO;
import com.br.beibe.tads.bean.TipoAtendimento;
import com.br.beibe.tads.exception.CONException;
import com.br.beibe.tads.exception.DAOException;
import com.br.beibe.tads.factory.ConnectionFactory;

/**
 *
 * @author nicol
 */
public class TipoAtendimentoFacade { 
    public static List<TipoAtendimento> buscaTodos() throws DAOException, CONException {
        try {
            ConnectionFactory con = new ConnectionFactory();
            TipoAtendimentoDAO tipoAtendimentoDAO = new TipoAtendimentoDAO(con.getConnection());
            return tipoAtendimentoDAO.buscarTodos();
        } catch (DAOException e) {
            throw new DAOException("Não foi possível encontrar todos os tipos de atendimento: ", e);
        } catch (CONException e) {
            throw new CONException("Não foi possível se conectar ao sistema! Tente novamente mais tarde. ", e);
        }
    }
}
