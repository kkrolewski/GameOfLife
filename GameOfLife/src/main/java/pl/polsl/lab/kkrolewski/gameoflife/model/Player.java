package pl.polsl.lab.kkrolewski.gameoflife.model;

import pl.polsl.lab.kkrolewski.gameoflife.exceptions.MyException;
import java.util.regex.Pattern;

/**
 * Class that stores information about player
 *
 * @author KKrolewski
 * @version 1
 */
public class Player {

    /**
     * Stores name of player
     */
    private String name;

    /**
     * Method which changes player name
     *
     * @param name name of player
     *
     *
     */
    public void setPlayerName(String name) throws MyException {
        boolean inputValidation = Pattern.matches("[a-zA-Z]+", name);
        if (inputValidation) {
            this.name = name;
        } else {
            throw new MyException("Niewłaściwa nazwa");
        }
    }
    /**
     * Method which return player name
     */
    public String getPlayerName() {
        return this.name;
    }
}
