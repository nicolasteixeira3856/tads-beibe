/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.beibe.tads.facade;

import com.br.beibe.tads.bean.Produto;
import com.br.beibe.tads.dao.ProdutoDAO;
import com.br.beibe.tads.exception.CONException;
import com.br.beibe.tads.exception.DAOException;
import com.br.beibe.tads.factory.ConnectionFactory;
import java.util.List;

/**
 *
 * @author nicol
 */
public class ProdutoFacade {
    
    public static Produto buscarPorId(int id) throws DAOException, CONException {
        try (ConnectionFactory con = new ConnectionFactory()) {
            ProdutoDAO produtoDAO = new ProdutoDAO(con.getConnection());
            return produtoDAO.buscarPorId(id);
        } catch (DAOException e) {
            throw new DAOException("Não foi possível encontrar o produto de id: " + "/ " + id, e);
        } catch (CONException e) {
            throw new CONException("Não foi possível se conectar ao sistema! Tente novamente mais tarde. ", e);
        }
    }
    
     public static List<Produto> buscarTodosApenasIdNome() throws DAOException, CONException {
        try (ConnectionFactory con = new ConnectionFactory()) {
            ProdutoDAO produtoDAO = new ProdutoDAO(con.getConnection());
            return produtoDAO.buscarTodosApenasIdNome();
        } catch (DAOException e) {
            throw new DAOException("Não foi possível encontrar todos os produtos: ", e);
        } catch (CONException e) {
            throw new CONException("Não foi possível se conectar ao sistema! Tente novamente mais tarde. ", e);
        }
    }
}
