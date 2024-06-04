package Models;

import ParsingLayer.CompassDirection;
import ParsingLayer.Position;

import java.util.concurrent.atomic.AtomicInteger;
// TODO make an enum for Rover Symbol end give it a symbol
public class Rover {
    private static final AtomicInteger counter = new AtomicInteger();
    private final int id;
    private Position position;
    private CompassDirection orientation;
    private String name;
    public Rover(Position initialPosition, String name) {
        this.position = initialPosition;
        this.orientation = initialPosition.getFacing();
        this.name = name;
        this.id = counter.incrementAndGet();

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
}
