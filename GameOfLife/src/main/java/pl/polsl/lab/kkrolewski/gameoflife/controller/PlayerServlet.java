package pl.polsl.lab.kkrolewski.gameoflife.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import pl.polsl.lab.kkrolewski.gameoflife.model.Player;
import pl.polsl.lab.kkrolewski.gameoflife.exceptions.MyException;
import pl.polsl.lab.kkrolewski.gameoflife.model.PlayerEntity;
import pl.polsl.lab.kkrolewski.gameoflife.view.Printer;

/**
 * Class which contains player servlet
 *
 * @author KKrolewski
 * @version 1
 */
@WebServlet(name = "PlayerServlet", urlPatterns = {"/PlayerServlet"})
public class PlayerServlet extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            HttpSession session = request.getSession(true);
            Printer printer = new Printer();
            Player player = new Player();
            try {
                player.setPlayerName(request.getParameter("playerName"));
                PlayerEntity person = new PlayerEntity();
                person.setName(player.getPlayerName());
                EntityController main = new EntityController();
                main.persist(person);
            } catch (MyException e) {
                response.sendError(response.SC_BAD_REQUEST, "niewlasciwa nazwa");
            }

            session.setAttribute("player", player);
            printer.printStartOfPlayerServlet(out);
            out.println("<p>Witaj " + player.getPlayerName() + ". Nacisnij przycisk aby rozpoczac symulacje</p>");
            printer.printEndOfPlayerServlet(out);
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
