/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.beibe.tads.facade;

import com.br.beibe.tads.bean.Estado;
import com.br.beibe.tads.dao.EstadoDAO;
import com.br.beibe.tads.exception.CONException;
import com.br.beibe.tads.exception.DAOException;
import com.br.beibe.tads.factory.ConnectionFactory;

/**
 *
 * @author nicol
 */
public class EstadoFacade {
    public static Estado buscarPorId(int id) throws DAOException, CONException {
        try {
            ConnectionFactory con = new ConnectionFactory();
            EstadoDAO estadoDAO = new EstadoDAO(con.getConnection());
            return estadoDAO.buscaPorId(id);
        } catch (DAOException e) {
            throw new DAOException("Não foi possível encontrar o estado para o id: " + "/ " + id, e);
        } catch (CONException e) {
            throw new CONException("Não foi possível se conectar ao sistema! Tente novamente mais tarde. ", e);
        }
    }
}
