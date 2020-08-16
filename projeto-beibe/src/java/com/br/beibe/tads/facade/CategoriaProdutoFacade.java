/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.beibe.tads.facade;

import com.br.beibe.tads.bean.CategoriaProduto;
import com.br.beibe.tads.dao.CategoriaProdutoDAO;
import com.br.beibe.tads.exception.CONException;
import com.br.beibe.tads.exception.DAOException;
import com.br.beibe.tads.factory.ConnectionFactory;

/**
 *
 * @author nicol
 */
public class CategoriaProdutoFacade {
    public static CategoriaProduto buscarPorId(int id) throws DAOException, CONException {
        try (ConnectionFactory con = new ConnectionFactory()) {
            CategoriaProdutoDAO categoriaProdutoDAO = new CategoriaProdutoDAO(con.getConnection());
            return categoriaProdutoDAO.buscarPorId(id);
        } catch (DAOException e) {
            throw new DAOException("Não foi possível encontrar o estado para o id: " + "/ " + id, e);
        } catch (CONException e) {
            throw new CONException("Não foi possível se conectar ao sistema! Tente novamente mais tarde. ", e);
        }
    }
}
