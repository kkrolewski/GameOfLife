package pl.polsl.lab.kkrolewski.gameoflife.controller;


import pl.polsl.lab.kkrolewski.gameoflife.view.Printer;
import pl.polsl.lab.kkrolewski.gameoflife.model.Board;
/**
 * Main function of program, the first and only parameter is the number of
 * iteration
 *
 * @author KKrolewski
 * @version 1
 */
public class Main {

    public static void main(String[] args) {   
        int iterations = 5;
        Board board = new Board(20, 20);
        Printer printer = new Printer();
        board.setAlive(10, 10);
        board.setAlive(11, 10);
        board.setAlive(12, 10);
        board.setAlive(10, 11);
        board.setAlive(11, 11);
        board.setAlive(12, 11);
        board.setAlive(10, 12);
        board.setAlive(11, 12);
        board.setAlive(12, 12);
        for (int i = 0; i < iterations; i++) {
            //printer.printBoard(board, board.getBoardHeight(), board.getBoardWidth());
            board.oneIteration();
        }
    }
}
