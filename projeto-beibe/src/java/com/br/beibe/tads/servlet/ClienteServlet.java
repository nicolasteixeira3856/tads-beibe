/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.beibe.tads.servlet;

import com.br.beibe.tads.bean.Atendimento;
import com.br.beibe.tads.bean.Cidade;
import com.br.beibe.tads.bean.Estado;
import com.br.beibe.tads.bean.Produto;
import com.br.beibe.tads.bean.TipoAtendimento;
import com.br.beibe.tads.bean.Usuario;
import com.br.beibe.tads.exception.CONException;
import com.br.beibe.tads.exception.DAOException;
import com.br.beibe.tads.facade.AtendimentoFacade;
import com.br.beibe.tads.facade.CidadeFacade;
import com.br.beibe.tads.facade.EstadoFacade;
import com.br.beibe.tads.facade.ProdutoFacade;
import com.br.beibe.tads.facade.TipoAtendimentoFacade;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author nicol
 */
@WebServlet(name = "ClienteServlet", urlPatterns = {"/ClienteServlet"})
public class ClienteServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String action = request.getParameter("action");
        
        if (action == null) {
            request.setAttribute("mensagem", "Invocação inválida: action é nulo");
            RequestDispatcher rd = request.getRequestDispatcher("/erro.jsp");
            rd.forward(request, response);
            return;
        }
        
        switch (action) {
            case "listarAtendimentos":
            {
                try{
                    HttpSession session = request.getSession();
                    Usuario usuario = (Usuario) session.getAttribute("usuario");
                    List<Atendimento> listaAtendimento = AtendimentoFacade.buscarTodosPorIdUsuario(usuario);
                    request.setAttribute("listaAtendimento", listaAtendimento);  
                    RequestDispatcher rd = request.getRequestDispatcher("modules/cliente/listarAtendimentos.jsp");
                    rd.forward(request, response);
                    return;
                } catch (DAOException | CONException e) {
                    request.setAttribute("mensagemErro", e.getMessage());
                    RequestDispatcher rd = request.getRequestDispatcher("modules/cliente/portalClienteMsg.jsp");
                    rd.forward(request, response);
                    return;
                }
            }
            case "novoAtendimento":
            {
                try {
                    List<TipoAtendimento> listaTipoAtendimento = TipoAtendimentoFacade.buscaTodos();
                    List<Produto> listaProduto = ProdutoFacade.buscarTodosApenasIdNome();
                    request.setAttribute("listaTipoAtendimento", listaTipoAtendimento);
                    request.setAttribute("listaProduto", listaProduto);
                    RequestDispatcher rd = request.getRequestDispatcher("modules/cliente/novoAtendimento.jsp");
                    rd.forward(request, response);
                    return;
                } catch (DAOException | CONException e) {
                    request.setAttribute("mensagemErro", e.getMessage());
                    RequestDispatcher rd = request.getRequestDispatcher("modules/cliente/portalClienteMsg.jsp");
                    rd.forward(request, response);
                    return;
                }
            }
            case "alterarDados":
            {
                try {
                    List<Estado> listaEstado = EstadoFacade.buscarTodos();
                    List<Cidade> listaCidade = CidadeFacade.buscarTodos();
                    request.setAttribute("listaEstado", listaEstado);
                    request.setAttribute("listaCidade", listaCidade);
                    RequestDispatcher rd = request.getRequestDispatcher("modules/cliente/alterarDados.jsp");
                    rd.forward(request, response);
                    return;
                } catch (DAOException | CONException e) {
                    request.setAttribute("mensagemErro", e.getMessage());
                    RequestDispatcher rd = request.getRequestDispatcher("modules/cliente/portalClienteMsg.jsp");
                    rd.forward(request, response);
                    return;
                }
            }
            default:
            {
                request.setAttribute("mensagemErro", "Erro ao encontrar a action: " + action);
                request.setAttribute("pagina", "modules/cliente/portalCliente.jsp");
                RequestDispatcher rd = request.getRequestDispatcher("erro.jsp");
                rd.forward(request, response);
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
