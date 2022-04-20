package pl.polsl.lab.kkrolewski.gameoflife.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import pl.polsl.lab.kkrolewski.gameoflife.model.Board;
import pl.polsl.lab.kkrolewski.gameoflife.model.BoardEntity;
import pl.polsl.lab.kkrolewski.gameoflife.model.PlayerEntity;
import pl.polsl.lab.kkrolewski.gameoflife.view.Printer;

/**
 * Class which contains game servlet
 *
 * @author KKrolewski
 * @version 1
 */
@WebServlet(name = "GameServlet", urlPatterns = {"/GameServlet"})
public class GameServlet extends HttpServlet {

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
        Board board;
        Printer printer = new Printer();
        HttpSession session = request.getSession(true);
        Object obj = session.getAttribute("board");
        if (obj == null) {
            board = new Board(20, 20);
            board.setAlive(10, 10);
            board.setAlive(11, 10);
            board.setAlive(12, 10);
            board.setAlive(10, 11);
            board.setAlive(11, 11);
            board.setAlive(12, 11);
            board.setAlive(10, 12);
            board.setAlive(11, 12);
            board.setAlive(12, 12);
        } else {
            board = (Board) obj;
        }
        int iteration = 0;
        try {
            iteration = Integer.parseInt(request.getParameter("iterations"));
        } catch (NumberFormatException e) {
            iteration = 0;
        }

        for (int i = 0; i < iteration; i++) {
            board.oneIteration();
        }
        session.setAttribute("board", board);

        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */

            printer.printStartOfGameServlet(out);
            printer.printBoard(board, board.getBoardHeight(), board.getBoardWidth(), out);
            BoardEntity person = new BoardEntity();
            person.setName("board");
            BoardController main = new BoardController();
            main.persist(person);
            printer.printEndOfGameServlet(out);

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
