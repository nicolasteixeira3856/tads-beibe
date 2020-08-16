/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.beibe.tads.facade;

import com.br.beibe.tads.bean.AtendimentoStatus;
import com.br.beibe.tads.dao.AtendimentoStatusDAO;
import com.br.beibe.tads.exception.CONException;
import com.br.beibe.tads.exception.DAOException;
import com.br.beibe.tads.factory.ConnectionFactory;

/**
 *
 * @author nicol
 */
public class AtendimentoStatusFacade {
    public static AtendimentoStatus buscarPorId(int id) throws DAOException, CONException {
        try (ConnectionFactory con = new ConnectionFactory()) {
            AtendimentoStatusDAO atendimentoStatusDAO = new AtendimentoStatusDAO(con.getConnection());
            return atendimentoStatusDAO.buscarPorId(id);
        } catch (DAOException e) {
            throw new DAOException("Não foi possível encontrar o status de atendimento para o id: " + "/ " + id, e);
        } catch (CONException e) {
            throw new CONException("Não foi possível se conectar ao sistema! Tente novamente mais tarde. ", e);
        }
    }
}
