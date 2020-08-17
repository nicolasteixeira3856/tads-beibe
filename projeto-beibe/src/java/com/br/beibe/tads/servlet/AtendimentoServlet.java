/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.beibe.tads.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletResponse;
import com.br.beibe.tads.bean.Atendimento;
import com.br.beibe.tads.bean.AtendimentoStatus;
import com.br.beibe.tads.bean.Produto;
import com.br.beibe.tads.bean.TipoAtendimento;
import com.br.beibe.tads.facade.AtendimentoFacade;
import com.br.beibe.tads.facade.AtendimentoStatusFacade;
import com.br.beibe.tads.facade.ProdutoFacade;
import com.br.beibe.tads.facade.TipoAtendimentoFacade;
import com.br.beibe.tads.bean.Usuario;
import com.br.beibe.tads.exception.CONException;
import com.br.beibe.tads.exception.DAOException;
import java.util.List;
import javax.servlet.http.HttpSession;

/**
 *
 * @author nicol
 */
@WebServlet(name = "AtendimentoServlet", urlPatterns = {"/AtendimentoServlet"})
public class AtendimentoServlet extends HttpServlet {

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
            case "novoAtendimento": 
                {
                    HttpSession session = request.getSession();
                    
                    try {
                       String tipoAtendimentoJsp = request.getParameter("tipoAtendimento");
                       String produtoJsp = request.getParameter("produto");
                       String descricao = request.getParameter("descricao");

                        if (tipoAtendimentoJsp.isEmpty() || produtoJsp.isEmpty() || descricao.isEmpty()) {
                            request.setAttribute("mensagem", "Nenhum campo pode estar vazio");
                            RequestDispatcher rd = request.getRequestDispatcher("modules/cliente/portalClienteMsg.jsp");
                            rd.forward(request, response);
                            return;
                        }

                       
                       Usuario usuario = (Usuario) session.getAttribute("usuario");
                       int idTipoAtendimento = Integer.parseInt(tipoAtendimentoJsp);
                       int idProduto = Integer.parseInt(produtoJsp);
                       int idStatus = 1;

                       TipoAtendimento tipoAtendimento = TipoAtendimentoFacade.buscarPorId(idTipoAtendimento);
                       Produto produto = ProdutoFacade.buscarPorId(idProduto);
                       AtendimentoStatus atendimentoStatus = AtendimentoStatusFacade.buscarPorId(idStatus);
                       Atendimento atendimento = new Atendimento();
                       atendimento.setProduto(produto);
                       atendimento.setStatus(atendimentoStatus);
                       atendimento.setTipoAtendimento(tipoAtendimento);
                       atendimento.setUsuario(usuario);
                       atendimento.setDescricao(descricao);
                       AtendimentoFacade.criarNovoAtendimento(atendimento);

                       session.setAttribute("mensagemSucesso", "Novo atendimento cadastrado com sucesso");
                       session.setAttribute("pagina", "modules/cliente/listarAtendimentos.jsp");
                       response.sendRedirect("modules/cliente/portalClienteMsg.jsp");
                       return;
                   } catch (NumberFormatException | DAOException | CONException ex) {
                       session.setAttribute("mensagemErro", ex.getMessage());
                       response.sendRedirect("modules/cliente/portalClienteMsg.jsp");
                       return;
                   }
                }
            case ("maisInformacoes"):
                {
                    try {
                        String id = request.getParameter("id");

                        if (id == null) {
                            request.setAttribute("mensagem", "Invocação inválida: ID é nulo");
                            RequestDispatcher rd = request.getRequestDispatcher("/erro.jsp");
                            rd.forward(request, response);
                            return;
                        }

                        int idAtendimento = Integer.parseInt(id);
                        Atendimento atendimento = AtendimentoFacade.buscarPorId(idAtendimento);

                        request.setAttribute("atendimento", atendimento);  
                        RequestDispatcher rd = request.getRequestDispatcher("modules/cliente/atendimentoMaisInformacoes.jsp");
                        rd.forward(request, response);
                        return;
                    } catch (NumberFormatException | DAOException | CONException ex) {
                        request.setAttribute("mensagemErro", ex.getMessage());
                        RequestDispatcher rd = request.getRequestDispatcher("modules/cliente/portalClienteMsg.jsp");
                        rd.forward(request, response);
                        return;
                    }
                }
            case ("removerAtendimento"):
                {
                    try {
                        String id = request.getParameter("id");

                        if (id == null) {
                            request.setAttribute("mensagem", "Invocação inválida: ID é nulo");
                            RequestDispatcher rd = request.getRequestDispatcher("/erro.jsp");
                            rd.forward(request, response);
                            return;
                        }

                        int idAtendimento = Integer.parseInt(id);
                        AtendimentoFacade.deletarAtendimentoPorId(idAtendimento);

                        HttpSession session = request.getSession();    
                        session.setAttribute("mensagemSucesso", "Atendimento removido com sucesso - ID: " + id );
                        session.setAttribute("pagina", "modules/cliente/listarAtendimentos.jsp");
                        response.sendRedirect("modules/cliente/portalClienteMsg.jsp");
                        return;
                    } catch (NumberFormatException | DAOException | CONException ex) {
                        request.setAttribute("mensagemErro", ex.getMessage());
                        RequestDispatcher rd = request.getRequestDispatcher("modules/cliente/portalClienteMsg.jsp");
                        rd.forward(request, response);
                        return;
                    }
                }
            
            default:
                {
                    request.setAttribute("mensagem", "Erro ao encontrar a action: " + action);
                    request.setAttribute("pagina", "index.jsp");
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
