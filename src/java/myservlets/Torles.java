/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package myservlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.UserTransaction;
import myentities.Keszlet;

/**
 *
 * @author Balázs
 */
public class Torles extends HttpServlet {
    
    @PersistenceUnit
    private EntityManagerFactory emf;
    
    @Resource
    private UserTransaction utx;

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        EntityManager em = null;
        
        try {
            em = emf.createEntityManager();
            utx.begin();
            
            Integer termekKod = Integer.parseInt(request.getParameter("termekKod"));
            List<Keszlet> termekek = em.createNamedQuery("Keszlet.findByTermekKod").setParameter("termekKod", termekKod).getResultList();
            Iterator<Keszlet> iterator = termekek.iterator();
            while(iterator.hasNext()) {
                Keszlet termek = iterator.next();
                em.remove(termek);
            }
            
            utx.commit();
            
            request.getRequestDispatcher("index.jsp").forward(request, response);
        } catch (Exception ex) {
            out.println("Hibás adat!<br><br>");
            out.println("Termékkód: egész szám<br><br>");
            out.println("<form action=\"index.jsp\">");
            out.println("<input type=\"submit\" value=\"Vissza a főoldalra\"/>");
            out.println("</form>");
        } finally {
            if(out != null) {
                out.close();
            }
            if(em != null) {
                em.close();
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
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
     * Handles the HTTP
     * <code>POST</code> method.
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
