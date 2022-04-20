package pl.polsl.lab.kkrolewski.gameoflife.view;

import pl.polsl.lab.kkrolewski.gameoflife.model.Board;
import java.io.PrintWriter;

/**
 * Class which contains method to show result in console
 *
 * @author KKrolewski
 * @version 1
 */
public class Printer {

    /**
     * Method which print board in console
     *
     * @param board board of game
     * @param height height of board
     * @param width width of board
     */
    public void printBoard(Board board, int height, int width, PrintWriter out) {
        out.println("------------------------------------------------------------<br>");
        for (int y = 0; y < height; y++) {
            out.print("| ");
            for (int x = 1; x <= width; x++) {
                if (board.boardGame.get((width * y) + x).checkIfAlive()) {
                    out.print("<b>0 </b>");
                } else {
                    out.print("8 ");
                }
            }
            out.print("|<br>");
        }
        out.println("------------------------------------------------------------<br>");
    }

    /**
     * Method which print top of HTML game page
     *
     * @param out stream to writer of HTML
     *
     */
    public void printStartOfGameServlet(PrintWriter out) {
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet GameServlet</title>");
        out.println("<link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3\" crossorigin=\"anonymous\">");
        out.println("</head>");
        out.println("<body>");
        out.println("<div class=\"text-center\">");
        out.println("<h1>GAME OF LIFE SIMULATOR</h1>");
    }

    /**
     * Method which print bottom of HTML game page
     *
     * @param out stream to writer of HTML
     *
     */
    public void printEndOfGameServlet(PrintWriter out) {
        out.println("<form action=\"GameServlet\" method=\"GET\">");
        out.println("<p>Podaj liczbe iteracji:<input type=\"text\" name=\"iterations\" size=\"15\"></p>");
        out.println("<input type=\"submit\" value=\"zatwierdz\" />");
        out.println(" </form>");
        out.println("lub wykonaj tylko 1 iteracje:");
        out.println("<form action=\"GameServlet\" method=\"GET\">");
        out.println("<button type=\"submit\" formmethod=\"post\" value=\"1\" name=\"iterations\"/> 1 iteracja ");
        out.println(" </form>");
        out.println("<script src=\"https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js\" integrity=\"sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB\" crossorigin=\"anonymous\"></script>");
        out.println("<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js\" integrity=\"sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13\" crossorigin=\"anonymous\"></script>");
        out.println("</div>");
        out.println("</body>");
        out.println("</html>");
    }

    /**
     * Method which print top of HTML player page
     *
     * @param out stream to writer of HTML
     *
     */
    public void printStartOfPlayerServlet(PrintWriter out) {
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet PlayerServlet</title>");
        out.println("<link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3\" crossorigin=\"anonymous\">");
        out.println("</head>");
        out.println("<body>");
        out.println("<div class=\"text-center\">");
        out.println("<form action=\"GameServlet\" method=\"GET\">");
    }

    /**
     * Method which print bottom of HTML player page
     *
     * @param out stream to writer of HTML
     *
     */
    public void printEndOfPlayerServlet(PrintWriter out) {
        out.println("<input type=\"submit\" value=\"zatwierdz\" />");
        out.println(" </form>");
        out.println("<script src=\"https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js\" integrity=\"sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB\" crossorigin=\"anonymous\"></script>");
        out.println("<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js\" integrity=\"sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13\" crossorigin=\"anonymous\"></script>");
        out.println("</div>");
        out.println("</body>");
        out.println("</html>");
    }
}
