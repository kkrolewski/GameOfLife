package pl.polsl.lab.kkrolewski.gameoflife.exceptions;

/**
 * Class with my own exception
 *
 * @author KKrolewski
 * @version 1
 */
public class MyException extends Exception {

    /**
     * Default constructor of exception
     */
    public MyException() {
    }

    /**
     * Constructor of exception with additional message
     *
     * @param message message of exception
     */
    public MyException(String message) {
        super(message);
    }
}
