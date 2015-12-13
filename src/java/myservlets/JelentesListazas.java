/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package myservlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import myentities.Jelentes;

/**
 *
 * @author Balázs
 */
public class JelentesListazas extends HttpServlet {
    
    @PersistenceUnit
    private EntityManagerFactory emf;

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
            
            List<Jelentes> jelentesek = em.createNamedQuery("Jelentes.findAll").getResultList();
            Iterator<Jelentes> iterator = jelentesek.iterator();
            
                    
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Jelentes</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h2>Jelentés</h2></br>");
            out.println("<table id=\"jelentesTable\" border=\"3\">");
            out.println("<tr >");
                out.println("<th>Sorszám</th>");
                out.println("<th>Dátum</th>");
                out.println("<th>Művelet</th>");
                out.println("<th>Termékkód</th>");
                out.println("<th>Terméknév</th>");
                out.println("<th>Mennyiség</th>");
            out.println("</tr>");
            while(iterator.hasNext()) {
                Jelentes jelentes = iterator.next();
                out.println("<tr>");
                    out.println("<td>" + jelentes.getSorszam() + "</td>");
                    out.println("<td>" + jelentes.getDatum() + "</td>"); 
                    out.println("<td>" + jelentes.getMuvelet() + "</td>"); 
                    out.println("<td>" + jelentes.getTermekKod() + "</td>");
                    out.println("<td>" + jelentes.getTermekNev() + "</td>");
                    out.println("<td>" + jelentes.getMennyiseg() + "</td>"); 
                out.println("</tr>");
            }
            out.println("</table>");
            out.println("</body>");
            out.println("</html>");
            
        } catch (Exception ex) {
            throw new ServletException(ex);
        } finally {
            //close the em to release any resources held up by the persistebce provider
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
