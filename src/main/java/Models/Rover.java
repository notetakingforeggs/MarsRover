package Models;

import ParsingLayer.CompassDirection;
import ParsingLayer.Position;

public class Rover {
    private Position position;
    private CompassDirection orientation;

    public Rover(Position initialPosition) {
        this.position = initialPosition;
        this.orientation = initialPosition.getFacing();
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
}
