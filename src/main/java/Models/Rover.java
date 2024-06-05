package Models;

import ParsingLayer.CompassDirection;
import ParsingLayer.Position;
import UI.IDColour;

import java.util.concurrent.atomic.AtomicInteger;

// TODO make an enum for Rover Symbol end give it a symbol
public class Rover {
    private static final AtomicInteger counter = new AtomicInteger();
    private final int id;
    private final IDColour colour;
    private String name;
    private Position position;
    private CompassDirection orientation;

    public Rover(Position initialPosition, String name) {
        this.name = name;
        this.id = counter.incrementAndGet();
        this.position = initialPosition;
        this.orientation = initialPosition.getFacing();
        this.colour = setColour(this.id);
    }


    public void setOrientation(CompassDirection orientation) {
        this.orientation = orientation;
    }

    public CompassDirection getOrientation() {
        return orientation;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public IDColour getColour() {
        return colour;
    }

    public IDColour setColour(int ID) {
        switch (id) {
            case 1 -> {
                return IDColour.BLACK;
            }
            case 2 -> {
                return IDColour.GREEN;
            }
            case 3 -> {
                return IDColour.YELLOW;
            }
            case 4 -> {
                return IDColour.PURPLE;
            }
            case 5 -> {
                return IDColour.BLUE;
            }
            case 6 -> {
                return IDColour.CYAN;
            }
            default -> {
                return IDColour.WHITE;
            }
        }

    }
}

