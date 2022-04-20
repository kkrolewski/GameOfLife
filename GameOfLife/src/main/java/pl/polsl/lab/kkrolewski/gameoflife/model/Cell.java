package pl.polsl.lab.kkrolewski.gameoflife.model;

/**
 * Class containing information about cell
 *
 * @author KKrolewski
 * @version 1
 */
public class Cell {

    /**
     * Stores information about Cell status
     */
    private boolean isAlive = false;

    /**
     * Default constructor of cell
     */
    Cell() {
        this.isAlive = false;
    }
     /**
     * Constructor of cell with boolean
     */
    Cell(boolean x){
    if(x){
    this.setCellAlive();
    }
    else{
    this.setCellDead();}
    }
    /**
     * Method which checks if a cell is alive
     *
     * @return true, if alive, false, if dead
     */
    public boolean checkIfAlive() {
        if (this.isAlive == true) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Method which helps in counting alive neighbours
     *
     * @return 1 - if a cell is alive, 0 if cell is dead
     */
    public int counterHelper() {
        if (this.isAlive == true) {
            return 1;
        } else {
            return 0;
        }
    }

    /**
     * Method which changes Cell status to alive
     */
    public void setCellAlive() {

        this.isAlive = true;

    }

    /**
     * Method which changes Cell status to dead
     */
    public void setCellDead() {

        this.isAlive = false;

    }
     /**
     * Method which return Cell status 
     * @return cell status
     */
    public boolean getCellStatus(){
    return this.isAlive;
    }
}
