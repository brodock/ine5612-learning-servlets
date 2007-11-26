package ine5612.servlets;

import ine5612.persistence.Fornecedor;
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
public class ServletFornecimento extends HttpServlet {

    private ArrayList<Produto> produtos;
    
    // Caralhada de coisas pro Hibernate Funcionar
    private EntityManagerFactory emf = HibernateUtil.getEntityManagerFactory(); // Factory
    private EntityManager em = emf.createEntityManager(); //Criando um Entity Manager

    @Override
    public void init() {

        EntityTransaction tx = em.getTransaction(); //Recuperando uma transação
        tx.begin(); //Iniciando a transação


        ArrayList<Produto> prods = null;
        // Carregar a lista de produtos disponível no banco
        prods = (ArrayList<Produto>) em.createNativeQuery("SELECT * FROM Produto p").getResultList();

        tx.commit();

        this.produtos = prods;
    }

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

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws javax.servlet.ServletException
     * @throws java.io.IOException
     */

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

        String action = request.getParameter("action");

        if (action != null) {
            if (action.equals("save")) {
                saveFornecedor(request, response);
            } else if (action.equals("search")) {
                searchFornecedor(request, response);
            } else {
                //Se a action não for encontrada
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Servlet Fornecimento</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>Action inexistente: " + action + "</h1>");
                out.println("</body>");
                out.println("</html>");
            }
        } else {
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Fornecimento</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Action não definida!</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    
    /**
     * Returns a short description of the servlet.
     * @return
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }

    /**
     * Generate HTML listing of fornecedor
     * @param fornecedores ArrayList of Fornecedor
     * @return String with html output
     */
    private String listFornecedor(ArrayList<Fornecedor> fornecedores) {

        StringBuilder sb = new StringBuilder();
        sb.append("<ul>\n");
        for (Fornecedor f : fornecedores) {
            sb.append("<li>");
            sb.append(f.getNomeFantasia());
            sb.append("</li>\n");
        }
        sb.append("</ul>\n");

        return sb.toString();
    }

    @SuppressWarnings(value = "unchecked")
    private void searchFornecedor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        EntityTransaction tx = em.getTransaction(); //Recuperando uma transação
        tx.begin(); //Iniciando a transação


        ArrayList<Fornecedor> fornecedores = null;
        String texto = request.getParameter("texto");
        String tipo = request.getParameter("param_busca");

        if (tipo.equals("nome")) {
            fornecedores = (ArrayList<Fornecedor>) em.createNamedQuery("Fornecedor.findByNomeFantasia").setParameter("nomeFantasia", texto).getResultList();
        } else if (tipo.equals("produto")) {
            String produto = request.getParameter("listaproduto");
            fornecedores = (ArrayList<Fornecedor>) em.createNamedQuery("Fornecedor.findByNomeFantasia").setParameter("nomeFantasia", produto).getResultList();
        }

        tx.commit();


        //
        // Imprime o resultado da pesquisa
        //

        try {
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Resultado da Pesquisa</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Listagem de fornecedores</h1>");
            out.println(this.listFornecedor(fornecedores));
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
    }

    private void saveFornecedor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        boolean persist = false;

        EntityManager em = emf.createEntityManager(); //Criando um Entity Manager

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
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Fornecimento</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Fornecedor Salvo com Sucesso!</h1>");
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
    }

    public List<Produto> getProducts() {
        return this.produtos;
    }
    // </editor-fold>
}
