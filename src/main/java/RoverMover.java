import ParsingLayer.CompassDirection;
import ParsingLayer.Instruction;
import ParsingLayer.Position;


// could you use generics? pass in N/E/S/W as classes to pass in.
// TODO separate this off into movement layer package at some point.


import static ParsingLayer.CompassDirection.*;

public class RoverMover {

    private Instruction instruction;
    private int roverNumber;

    public void move(Plateau plateau, Instruction instruction, int roverNumber) {
        this.instruction = instruction;
        this.roverNumber = roverNumber;

        if (instruction == Instruction.L) {
            // depending on orientation, access value of rover
            switch (plateau.getRover(roverNumber).getOrientation()) {
                case N -> plateau.getRover(roverNumber).setOrientation(W);
                case W -> plateau.getRover(roverNumber).setOrientation(S);
                case S -> plateau.getRover(roverNumber).setOrientation(E);
                case E -> plateau.getRover(roverNumber).setOrientation(N);
                default ->
                        throw new IllegalStateException("Unexpected value: " + plateau.getRover(roverNumber).getOrientation());
            }
        } else if (instruction == instruction.R) {
            switch (plateau.getRover(roverNumber).getOrientation()) {
                case N -> plateau.getRover(roverNumber).setOrientation(E);
                case E -> plateau.getRover(roverNumber).setOrientation(S);
                case S -> plateau.getRover(roverNumber).setOrientation(W);
                case W -> plateau.getRover(roverNumber).setOrientation(N);
                default ->
                        throw new IllegalStateException("Unexpected value: " + plateau.getRover(roverNumber).getOrientation());
            }
        } else if (instruction == instruction.M) {

            int initialX = plateau.getRover(roverNumber).getPosition().getX();
            int initialY = plateau.getRover(roverNumber).getPosition().getY();

            switch (plateau.getRover(roverNumber).getOrientation()) {
                case N -> {
                    // if the Y value of the current rover is equal to the length of the plateau you cannot move
                    if (initialY == plateau.getPlateauSize().getLength()-1) {
                        System.out.println("you are at the edge of the plateau.");
                        // if it is trying to move into an obstacle
                    } else if (!(plateau.getPlateauArray()[plateau.getRover(roverNumber).getPosition().getX()][plateau.getRover(roverNumber).getPosition().getY() + 1] == null)) {
                        System.out.println("encountered an obstacle");
                    } else {
                        //update rover internal position
                        plateau.getRover(roverNumber).getPosition().setY(initialY + 1);

                        //update plateaus awareness of rover position
                        updatePosition(plateau, plateau.getRover(roverNumber), initialX, initialY);

                    }
                }
                case E -> {
                    if (plateau.getRover(roverNumber).getPosition().getX() == plateau.getPlateauSize().getWidth()-1) {
                        System.out.println("you are at the edge of the plateau.");
                    } else if (!(plateau.getPlateauArray()[plateau.getRover(roverNumber).getPosition().getX() + 1][plateau.getRover(roverNumber).getPosition().getY()] == null)) {
                        System.out.println("encountered an obstacle");
                    } else {
                        plateau.getRover(roverNumber).getPosition().setX(initialX + 1);
                        updatePosition(plateau, plateau.getRover(roverNumber), initialX, initialY);
                    }
                }
                case S -> {
                    if (plateau.getRover(roverNumber).getPosition().getY() == 0) {
                        System.out.println("you are at the edge of the plateau");
                    } else if (!(plateau.getPlateauArray()[plateau.getRover(roverNumber).getPosition().getX()][plateau.getRover(roverNumber).getPosition().getY() - 1] == null)) {
                        System.out.println("encountered an obstacle");
                    } else {
                        plateau.getRover(roverNumber).getPosition().setY(initialY - 1);
                        updatePosition(plateau, plateau.getRover(roverNumber), initialX, initialY);
                    }
                }

                case W -> {
                    if (plateau.getRover(roverNumber).getPosition().getY() == 0) {
                        System.out.println("you are at the edge of the plateau");
                    } else if (!(plateau.getPlateauArray()[plateau.getRover(roverNumber).getPosition().getX() - 1][plateau.getRover(roverNumber).getPosition().getY()] == null)) {
                        System.out.println("encountered an obstacle");
                    } else {
                        plateau.getRover(roverNumber).getPosition().setX(initialX - 1);
                        updatePosition(plateau, plateau.getRover(roverNumber), initialX, initialY);
                    }
                }
                default ->
                        throw new IllegalStateException("Unexpected value: " + plateau.getRover(roverNumber).getOrientation());
            }

        }
//TODO some fuckery happening with the x vs y axis... was working before?
    }

    // helper function to update position in plateau array
    public void updatePosition(Plateau plateau, Rover rover, int initialX, int initialY) {
        plateau.getPlateauArray()
                [rover.getPosition().getX()]
                [rover.getPosition().getY()]
                = rover;
        plateau.getPlateauArray()
                [initialX]
                [initialY]
                = null;

    }
}


