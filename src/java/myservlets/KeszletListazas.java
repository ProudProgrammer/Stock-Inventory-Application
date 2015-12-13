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
import myentities.Keszlet;

/**
 *
 * @author Balázs
 */
public class KeszletListazas extends HttpServlet {
    
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
            
            List<Keszlet> termekek = em.createNamedQuery("Keszlet.findAll").getResultList();
            Iterator<Keszlet> iterator = termekek.iterator();
            
                    
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Eladas</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h2>Készletlista</h2></br>");
            out.println("<table id=\"keszletListTable\" border=\"3\">");
            out.println("<tr >");
                out.println("<th>Termékkód</th>");
                out.println("<th>Terméknév</th>");
                out.println("<th>Beszerzési ár</th>");
                out.println("<th>Eladási ár</th>");
                out.println("<th>Mennyiség egysége</th>");
                out.println("<th>Mennyiség</th>");
            out.println("</tr>");
            while(iterator.hasNext()) {
                Keszlet termek = iterator.next();
                out.println("<tr>");
                    out.println("<td>" + termek.getTermekKod() + "</td>");
                    out.println("<td>" + termek.getTermekNev() + "</td>"); 
                    out.println("<td>" + termek.getBeszerzesiAr() + "</td>"); 
                    out.println("<td>" + termek.getEladasiAr() + "</td>");
                    out.println("<td>" + termek.getMennyisegEgysege() + "</td>");
                    out.println("<td>" + termek.getMennyiseg() + "</td>"); 
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
