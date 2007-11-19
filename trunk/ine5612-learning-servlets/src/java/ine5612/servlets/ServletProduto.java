/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ine5612.servlets;

import ine5612.persistence.Produto;
import ine5612.persistence.Produto;
import ine5612.utils.HibernateUtil;
import java.io.*;
import java.net.*;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.servlet.*;
import javax.servlet.http.*;

/**
 *
 * @author brodock
 */
public class ServletProduto extends HttpServlet {



    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
        /* TODO output your page here
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet ServletProduto</title>");  
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Servlet ServletProduto at " + request.getContextPath () + "</h1>");
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
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Returns a short description of the servlet.
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }

    public List<Produto> getProducts() {
        return this.produtos;
    }
    // </editor-fold>
}
