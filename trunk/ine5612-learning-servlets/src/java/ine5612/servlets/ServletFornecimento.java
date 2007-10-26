/*
 * cad_fornecedor.java
 *
 * Created on 15/10/2007, 19:40:53
 *
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ine5612.servlets;

import ine5612.persistence.Fornecedor;
import ine5612.utils.HibernateUtil;
import java.io.*;
import java.net.*;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.servlet.*;
import javax.servlet.http.*;

/**
 *
 * @author brodock
 */
public class ServletFornecimento extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws javax.servlet.ServletException
     * @throws java.io.IOException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet cad_fornecedor</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet cad_fornecedor at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
             */
        } finally {
            out.close();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet cad_fornecedor</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet cad_fornecedor at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
             */
        } finally {
            out.close();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        EntityManager em = (EntityManager)HibernateUtil.getEntityManagerFactory().createEntityManager(); //Criando um Entity Manager
        EntityTransaction tx = em.getTransaction(); //Recuperando uma transação
        tx.begin(); //Iniciando a transação

        Fornecedor forn = new Fornecedor();
        
        
        String nomeFantasia = request.getParameter("nome");
        String endereco = request.getParameter("endereco");
        String cidade = request.getParameter("cidade");
        String estado = request.getParameter("estado");
        String pais = request.getParameter("pais");
        String email = request.getParameter("email");
        String telefone = request.getParameter("telefone");
        String contato = request.getParameter("contato");
        
        forn.setNomeFantasia(nomeFantasia);
        forn.setEndereco(endereco);
        forn.setCidade(cidade);
        forn.setEstado(estado);
        forn.setPais(pais);
        forn.setEmail(email);
        forn.setTelefone(telefone);
        forn.setContato(contato);
        
        em.persist(forn);
        tx.commit();
        
        em.close();
        
        try {
            /* TODO output your page here
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet cad_fornecedor</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet cad_fornecedor at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
             */
        } finally {
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws javax.servlet.ServletException
     * @throws java.io.IOException
     */
    /**
     * Returns a short description of the servlet.
     * @return
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }
    // </editor-fold>
}