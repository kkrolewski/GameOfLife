package pl.polsl.lab.kkrolewski.gameoflife.model;

import java.util.HashMap;

/**
 * Class which contains board of the game
 *
 * @author KKrolewski
 * @version 1
 */
public class Board {

    /**
     * Store board width
     */
    private int width;
    /**
     * Stores board height
     */
    private int height;
    /**
     * Stores board of game
     */
    public HashMap<Integer, Cell> boardGame;

    /**
     * Board constructor with resolution
     *
     * @param width width of board
     * @param height height of board
     */
    public Board(int height, int width) {
        this.height = height;
        this.width = width;
        this.boardGame = new HashMap<Integer, Cell>();
        for (int i = 1; i <= width * height; i++) {
            boardGame.put(i, new Cell());
        }
    }

    /**
     * Method which return a width of board
     *
     * @return width of board
     */
    public int getBoardWidth() {
        return this.width;
    }

    /**
     * Method which return a height of board
     *
     * @return height of board
     */
    public int getBoardHeight() {
        return this.height;
    }

    /**
     * Method which return a Cell from board
     *
     * @param x width of board
     * @param y height of board
     * @return Cell which is on direct coordinates
     */
    public Cell getBoardElement(int x, int y) {
        return this.boardGame.get((this.width * x) + y);
    }

    /**
     * Method which s Cell status to alive
     *
     * @param x width of board
     * @param y height of board
     */
    public void setAlive(int x, int y) {
        this.boardGame.get((this.width * x) + y).setCellAlive();
    }

    /**
     * Method which changes Cell status to dead
     *
     * @param x width of board
     * @param y height of board
     */
    public void setDead(int x, int y) {
        this.boardGame.get((this.width * x) + y).setCellDead();;
    }
    /**
     * Method which calculates how many neighbouars are alive
     *
     * @param x width of board
     * @param y height of board
     * @return number of alive neighbours
     */
    public int calculateAliveNeighbours(int x, int y) {
        int counter = 0;
        if (this.boardGame.containsKey((this.width * x) + y - width - 1)) {
            counter += this.boardGame.get((this.width * x) + y - width - 1).counterHelper();
        }
       if (this.boardGame.containsKey((this.width * x) + y - width)) {
            counter += this.boardGame.get((this.width * x) + y - width).counterHelper();
        }
        if (this.boardGame.containsKey((this.width * x) + y - width + 1)) {   
            counter += this.boardGame.get((this.width * x) + y - width + 1).counterHelper();
        }
        if (this.boardGame.containsKey((this.width * x) + y - 1)) {
            counter += this.boardGame.get((this.width * x) + y - 1).counterHelper();
        }
        if (this.boardGame.containsKey((this.width * x) + y + 1)) {
            counter += this.boardGame.get((this.width * x) + y + 1).counterHelper();
        }
        if (this.boardGame.containsKey((this.width * x) + y + width - 1)) {
            counter += this.boardGame.get((this.width * x) + y + width - 1).counterHelper();
        }
        if (this.boardGame.containsKey((this.width * x) + y + width)) {
            counter += this.boardGame.get((this.width * x) + y + width).counterHelper();
        }
        if (this.boardGame.containsKey((this.width * x) + y + width + 1)) {
            counter += this.boardGame.get((this.width * x) + y + width + 1).counterHelper();
        }
        return counter;
    }

    /**
     * Method which does one iteration of algorithm on board
     */
    public void oneIteration() {
        
        HashMap<Integer, Cell> temporary = new HashMap<Integer, Cell>();
        for (int i = 1; i <= width*height; i++) {
            temporary.put(i, new Cell());
            }
        for (int y = 0; y < height; y++) {
            for (int x = 1; x <= width; x++) {
                int aliveNeigh = this.calculateAliveNeighbours(x, y);
                if (this.boardGame.get((this.width * y) + x).checkIfAlive()) {
                    if (aliveNeigh < 2) {
                        temporary.get((this.width*y)+x).setCellDead();
                    } else if (aliveNeigh == 2 || aliveNeigh == 3) {
                        temporary.get((this.width*y)+x).setCellAlive();
                    } else if (aliveNeigh > 3) {
                        temporary.get((this.width*y)+x).setCellDead();
                    }
                } else {
                    if (aliveNeigh == 3) {
                        temporary.get((this.width*y)+x).setCellAlive();
                    }
                }
            }
        }
        this.boardGame = temporary;
    }

}
