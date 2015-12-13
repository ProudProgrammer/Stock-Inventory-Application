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
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.UserTransaction;
import myentities.Keszlet;

/**
 *
 * @author Balázs
 */
@WebServlet(name = "Modositas", urlPatterns = {"/Modositas"})
public class Modositas extends HttpServlet {
    
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
            String termekNev = (String)request.getParameter("termekNev");
            Double beszerzesiAr = 0.0;
            Double eladasiAr = 0.0;
            String mennyisegEgysege = (String)request.getParameter("mennyisegEgysege");
            List<Keszlet> termekek = em.createNamedQuery("Keszlet.findByTermekKod").setParameter("termekKod", termekKod).getResultList();
            Iterator<Keszlet> iterator = termekek.iterator();
            while(iterator.hasNext()) {
                Keszlet termek = iterator.next();
                em.remove(termek);
                if(termekNev.equals(""))
                    termekNev = termek.getTermekNev();
                try {
                    beszerzesiAr = Double.parseDouble(request.getParameter("beszerzesiAr"));
                } catch (NumberFormatException ex) {
                    beszerzesiAr = termek.getBeszerzesiAr();
                }
                try {
                    eladasiAr = Double.parseDouble(request.getParameter("eladasiAr"));
                } catch (NumberFormatException ex) {
                    eladasiAr = termek.getEladasiAr();
                }
                if(mennyisegEgysege.equals(""))
                    mennyisegEgysege = termek.getMennyisegEgysege();
                termek.setTermekNev(termekNev);
                termek.setBeszerzesiAr(beszerzesiAr);
                termek.setEladasiAr(eladasiAr);
                termek.setMennyisegEgysege(mennyisegEgysege);
                em.persist(termek);
            }
            
            utx.commit();
            //out.println("Termékkkód: " + termekKod + "; Terméknév: " + termekNev + "; Beszerzési ár: " + beszerzesiAr +
            //        "; Eladásiár: " + eladasiAr + "; Mennyiség egysége: " + mennyisegEgysege);
            request.getRequestDispatcher("index.jsp").forward(request, response);
        } catch (Exception ex) {
            out.println("Hibás adat!<br><br>");
            out.println("Termékkód: egész szám<br>");
            out.println("Terméknév: tetszőleges szöveg<br>");
            out.println("Beszerzési ár: egész szám<br>");
            out.println("Eladási ár: egész szám<br>");
            out.println("Mennyiség egysége: tetszőleges szöveg<br><br>");
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
