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
import javax.persistence.Query;
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
        prods = (ArrayList<Produto>) em.createNativeQuery("SELECT * FROM Produto p WHERE true", Produto.class).getResultList();

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

        String action = request.getParameter("action");

        if (action != null) {
            if (action.equals("new")) {

                request.setAttribute("produtos", this.produtos);
                this.dispatch(request, response, "/cad_fornecedor.jsp");
            } else if (action.equals("search")) {
                request.setAttribute("produtos", this.produtos);
                this.dispatch(request, response, "/busca_fornecedor.jsp");
            } else if (action.equals("edit")) {
                request.setAttribute("produtos", this.produtos);
                this.edit(request, response);
            } else {
            //Se a action não for encontrada - não fazer nada!                
            }
        }


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
            sb.append("<a href=\"ServletFornecimento?action=edit&id=" + f.getIdFornecedor() + "\">" + f.getNomeFantasia() + "</a>");
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
            if (texto.isEmpty()) {
                fornecedores = (ArrayList<Fornecedor>) em.createNativeQuery("SELECT * FROM Fornecedor WHERE true", Fornecedor.class).getResultList();
            } else {
                fornecedores = (ArrayList<Fornecedor>) em.createNamedQuery("Fornecedor.findByNomeFantasia").setParameter("nomeFantasia", texto).getResultList();
            }
        } else if (tipo.equals("produto")) {
            Integer prod = Integer.parseInt(request.getParameter("listaproduto"));
            Produto produto = (Produto) em.createNamedQuery("Produto.findByIdProduto").setParameter("idProduto", prod).getSingleResult();
            fornecedores = new ArrayList<Fornecedor>(produto.getFornecedorCollection());
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

        // Recupera o Produto
        Query q_produto = em.createNamedQuery("Produto.findByIdProduto");
        q_produto.setParameter("idProduto", Integer.parseInt(request.getParameter("produto")));
        Produto produto = (Produto) q_produto.getSingleResult();

        forn.setNomeFantasia(nomeFantasia);
        forn.setEndereco(endereco);
        forn.setCidade(cidade);
        forn.setEstado(estado);
        forn.setPais(pais);
        forn.setEmail(email);
        forn.setTelefone(telefone);
        forn.setContato(contato);
        forn.setIdProduto(produto);

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

    protected void dispatch(HttpServletRequest request, HttpServletResponse response, String page) throws javax.servlet.ServletException, java.io.IOException {
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(page);
        dispatcher.forward(request, response);
    }

    private void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Id do fornecedor a ser editado
        int id = Integer.parseInt(request.getParameter("id"));

        EntityTransaction tx = em.getTransaction(); //Recuperando uma transação
        tx.begin(); //Iniciando a transação


        Fornecedor forn = null;
        // Carregar o fornecedor
        forn = (Fornecedor) em.createNativeQuery("SELECT * FROM Fornecedor p WHERE idFornecedor="+id, Fornecedor.class).getSingleResult();

        tx.commit();

        // Recupera os valores do banco
        String nomeFantasia = forn.getNomeFantasia();
        String endereco = forn.getEndereco();
        String cidade = forn.getCidade();
        String estado = forn.getEstado();
        String pais = forn.getPais();
        String email = forn.getEmail();
        String telefone = forn.getTelefone();
        String contato = forn.getContato();
        
        // Repassa pro Servlet (para ser transmitido pro JSP)
        request.setAttribute("nome", nomeFantasia);
        request.setAttribute("endereco", endereco);
        request.setAttribute("cidade", cidade);
        request.setAttribute("estado", estado);
        request.setAttribute("pais", pais);
        request.setAttribute("email", email);
        request.setAttribute("telefone", telefone);
        request.setAttribute("contato", contato);

        this.dispatch(request, response, "/cad_fornecedor.jsp");
    }
    // </editor-fold>
}
