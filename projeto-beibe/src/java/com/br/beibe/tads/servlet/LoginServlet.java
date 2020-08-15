/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.beibe.tads.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.br.beibe.tads.util.MD5;
import com.br.beibe.tads.facade.UsuarioFacade;
import com.br.beibe.tads.bean.Usuario;
import com.br.beibe.tads.exception.CONException;
import com.br.beibe.tads.exception.DAOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;

/**
 *
 * @author nicol
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {

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
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
        if (email.isEmpty() || senha.isEmpty()) {
            request.setAttribute("mensagem", "Nenhum campo pode estar vazio");
            RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
            rd.forward(request, response);
            return;
        }
        try {
            Usuario usuario = new Usuario();
            usuario = UsuarioFacade.buscarPorEmail(email);
            senha = MD5.MD5Transformed(senha);
            
            if (senha.equals(usuario.getSenha())) {
                HttpSession session = request.getSession(true);
                session.setAttribute("usuarioId", usuario.getId());
                session.setAttribute("usuarioNivel", usuario.getNivel());
                switch (usuario.getNivel()) {
                    case 1:
                        {
                            response.sendRedirect("portalGerente.jsp");
                            break;
                        }
                    case 2:
                        {
                            response.sendRedirect("portalFuncionario.jsp");
                            break;
                        }
                    default:
                        {
                            response.sendRedirect("portalUsuario.jsp");
                            break;
                        }
                }
            }
        } catch (DAOException | CONException ex) {
            request.setAttribute("mensagem", ex.getMessage());
            RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
            rd.forward(request, response);
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
