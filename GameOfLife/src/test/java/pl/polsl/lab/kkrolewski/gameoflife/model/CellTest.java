/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.polsl.lab.kkrolewski.gameoflife.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests for Cell class methods
 *
 * @author KKrolewski
 * @version 1
 */
public class CellTest {

    public CellTest() {
    }

    /**
     * Test of checkIfAlive method on alive cell.
     */
    @Test
    public void testCheckIfAliveOnAliveCell() {
        //given
        Cell cell = new Cell();
        cell.setCellAlive();
        //when
        boolean checker = cell.checkIfAlive();
        //then
        assertEquals(true, checker);
    }

    /**
     * Test of checkIfAlive method on dead cell.
     */
    @Test
    public void testCheckIfAliveOnDeadCell() {
        //given
        Cell cell = new Cell();
        //when
        boolean checker = cell.checkIfAlive();
        //then
        assertEquals(false, checker);
    }

    /**
     * Test of counterHelper method on alive cell.
     */
    @Test
    public void testCounterHelperOnAliveCell() {
        //given
        Cell cell = new Cell();
        cell.setCellAlive();
        //when
        int value = cell.counterHelper();
        //then
        assertEquals(1, value);
    }

    /**
     * Test of counterHelper method on dead cell.
     */
    @Test
    public void testCounterHelperOnDeadCell() {
        //given
        Cell cell = new Cell();
        //when
        int value = cell.counterHelper();
        //then
        assertEquals(0, value);
    }

}
