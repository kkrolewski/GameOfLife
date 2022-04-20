/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.polsl.lab.kkrolewski.gameoflife.model;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


/**
 * Tests for Board class methods
 *
 * @author KKrolewski
 * @version 1
 */
public class BoardTest {

    public BoardTest() {
    }

    /**
     * Test of calculateAliveNeighbours when all cells around are dead.
     */
    @Test
    public void testCalculateAliveNeighboursWhenAllAreDead() {
        //given
        Board board = new Board(20, 20);
        //when
        int value = board.calculateAliveNeighbours(10, 10);
        //then
        assertEquals(0, value);
    }
    /**
     * Test of calculateAliveNeighbours when all cells around all alive.
     */
    @Test
    public void testCalculateAliveNeighboursWhenAllAreAlive() {
        //given
        Board board = new Board(20, 20);
        board.setAlive(10, 10);
        board.setAlive(11, 10);
        board.setAlive(12, 10);
        board.setAlive(10, 11);
        board.setAlive(11, 11);
        board.setAlive(12, 11);
        board.setAlive(10, 12);
        board.setAlive(11, 12);
        board.setAlive(12, 12);
        //when
        int value = board.calculateAliveNeighbours(11, 11);
        //then
        assertEquals(8, value);
    }

    /**
     * Test of oneIteration method where some Cells should be alive.
     */
    @Test
    public void testOneIterationWhenThereShouldBeCellsAlive() {
        //given
        Board board = new Board(20, 20);
        board.setAlive(11, 10);
        board.setAlive(10, 11);
        board.setAlive(11, 11);
        board.setAlive(12, 11);
        board.setAlive(11, 12);

        Board boardNew = new Board(20, 20);
        boardNew.setAlive(10, 10);
        boardNew.setAlive(11, 10);
        boardNew.setAlive(12, 10);
        boardNew.setAlive(10, 11);
        boardNew.setAlive(11, 11);
        boardNew.setAlive(12, 11);
        boardNew.setAlive(10, 12);
        boardNew.setAlive(11, 12);
        boardNew.setAlive(12, 12);
        //when
        board.oneIteration();
        //then
        for (int i = 1; i <= 400; i++) {
            assertEquals(boardNew.boardGame.get(1).getCellStatus(), board.boardGame.get(1).getCellStatus());
        }
    }
    /**
     * Test of oneIteration method where all cells should be dead.
     */
     @Test
    public void testOneIterationWhenThereShouldBeCellsDead() {
        //given
        Board board = new Board(20, 20);
        board.setAlive(11, 10);    

        Board boardNew = new Board(20, 20);
        //when
        board.oneIteration();
        //then
        for (int i = 1; i <= 400; i++) {
            assertEquals(boardNew.boardGame.get(1).getCellStatus(), board.boardGame.get(1).getCellStatus());
        }
    }
}
