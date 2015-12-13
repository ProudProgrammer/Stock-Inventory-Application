/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package myservlets;

import java.io.IOException;
import java.io.PrintWriter;
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
public class UjTermek extends HttpServlet {

    @PersistenceUnit
    //The emf corresponding to 
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
             assert emf != null;  //Make sure injection went through correctly.
        EntityManager em = null;
        try {
            
            //Get the data from user's form
            String termekNev  = (String)request.getParameter("termekNev");
            Double beszerzesiAr   = Double.parseDouble(request.getParameter("beszerzesiAr"));
            Double eladasiAr   = Double.parseDouble(request.getParameter("eladasiAr"));
            String mennyisegEgysege  = (String)request.getParameter("mennyisegEgysege");
            
            //Create a person instance out of it
            Keszlet keszlet = new Keszlet(1, termekNev, beszerzesiAr, eladasiAr, mennyisegEgysege, 0);
            
            //begin a transaction
            utx.begin();
            //create an em. 
            //Since the em is created inside a transaction, it is associsated with 
            //the transaction
            em = emf.createEntityManager();
            //persist the person entity
            em.persist(keszlet);
            //commit transaction which will trigger the em to 
            //commit newly created entity into database
            utx.commit();
            
            //Forward to ListPerson servlet to list persons along with the newly
            //created person above
            request.getRequestDispatcher("index.jsp").forward(request, response);
        } catch (Exception ex) {
            out.println("Hibás adatok!<br><br>");
            out.println("Terméknév: tetszőleges szöveg<br>");
            out.println("Beszerzési ár: valós szám<br>");
            out.println("Eladási ár: valós szám<br>");
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
