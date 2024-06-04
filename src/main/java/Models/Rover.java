package Models;

import ParsingLayer.CompassDirection;
import ParsingLayer.Position;

public class Rover {
    private Position position;
    private CompassDirection orientation;
    private String name;
    public Rover(Position initialPosition, String name) {
        this.position = initialPosition;
        this.orientation = initialPosition.getFacing();
        this.name = name;
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
