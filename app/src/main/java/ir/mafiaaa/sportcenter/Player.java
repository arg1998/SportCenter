package ir.mafiaaa.sportcenter;

/**
 * Created by ARG on 9/14/2017 - 10:26 PM
 */

public class Player
{
    private String name;
    private String number;
    private String nation;
    private Position position;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
}
