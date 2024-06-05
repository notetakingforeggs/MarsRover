package MovementLayer;

import Models.Plateau;
import Models.Rover;
import ParsingLayer.Instruction;


// could you use generics? pass in N/E/S/W as classes to pass in.

import static ParsingLayer.CompassDirection.*;

public class RoverMover {

    private Instruction instruction;
    private int roverID;

    public void move(Plateau plateau, Instruction instruction, int roverID) {
        this.instruction = instruction;
        this.roverID = roverID;

        if (instruction == Instruction.L) {
            // depending on orientation, access value of rover
            switch (plateau.getRover(roverID).getOrientation()) {
                case N -> plateau.getRover(roverID).setOrientation(W);
                case W -> plateau.getRover(roverID).setOrientation(S);
                case S -> plateau.getRover(roverID).setOrientation(E);
                case E -> plateau.getRover(roverID).setOrientation(N);
                default ->
                        throw new IllegalStateException("Unexpected value: " + plateau.getRover(roverID).getOrientation());
            }
        } else if (instruction == instruction.R) {
            switch (plateau.getRover(roverID).getOrientation()) {
                case N -> plateau.getRover(roverID).setOrientation(E);
                case E -> plateau.getRover(roverID).setOrientation(S);
                case S -> plateau.getRover(roverID).setOrientation(W);
                case W -> plateau.getRover(roverID).setOrientation(N);
                default ->
                        throw new IllegalStateException("Unexpected value: " + plateau.getRover(roverID).getOrientation());
            }
        } else if (instruction == instruction.M) {

            int initialX = plateau.getRover(roverID).getPosition().getX();
            int initialY = plateau.getRover(roverID).getPosition().getY();
            switch (plateau.getRover(roverID).getOrientation()) {
                case N -> {
                    // if the Y value of the current rover is equal to the length of the plateau you cannot move
                    if (initialY == plateau.getPlateauSize().getLength()-1) {
                        System.out.println("you are at the edge of the plateau.");
                        // if it is trying to move into an obstacle
                    } else if (!(plateau.getPlateauArray()[plateau.getRover(roverID).getPosition().getX()][plateau.getRover(roverID).getPosition().getY() + 1] == null)) {
                        System.out.println("encountered an obstacle");
                    } else {
                        //update rover internal position
                        plateau.getRover(roverID).getPosition().setY(initialY + 1);

                        //update plateaus awareness of rover position
                        updatePosition(plateau, plateau.getRover(roverID), initialX, initialY);

                    }
                }
                case E -> {
                    if (plateau.getRover(roverID).getPosition().getX() == plateau.getPlateauSize().getWidth()-1) {
                        System.out.println("you are at the edge of the plateau.");
                    } else if (!(plateau.getPlateauArray()[plateau.getRover(roverID).getPosition().getX() + 1][plateau.getRover(roverID).getPosition().getY()] == null)) {
                        System.out.println("encountered an obstacle");
                    } else {
                        plateau.getRover(roverID).getPosition().setX(initialX + 1);
                        updatePosition(plateau, plateau.getRover(roverID), initialX, initialY);
                    }
                }
                case S -> {
                    if (plateau.getRover(roverID).getPosition().getY() == 0) {
                        System.out.println("you are at the edge of the plateau");
                    } else if (!(plateau.getPlateauArray()[plateau.getRover(roverID).getPosition().getX()][plateau.getRover(roverID).getPosition().getY() - 1] == null)) {
                        System.out.println("encountered an obstacle");
                    } else {
                        plateau.getRover(roverID).getPosition().setY(initialY - 1);
                        updatePosition(plateau, plateau.getRover(roverID), initialX, initialY);
                    }
                }

                case W -> {
                    if (plateau.getRover(roverID).getPosition().getY() == 0) {
                        System.out.println("you are at the edge of the plateau");
                    } else if (!(plateau.getPlateauArray()[plateau.getRover(roverID).getPosition().getX() - 1][plateau.getRover(roverID).getPosition().getY()] == null)) {
                        System.out.println("encountered an obstacle");
                    } else {
                        plateau.getRover(roverID).getPosition().setX(initialX - 1);
                        updatePosition(plateau, plateau.getRover(roverID), initialX, initialY);
                    }
                }
                default ->
                        throw new IllegalStateException("Unexpected value: " + plateau.getRover(roverID).getOrientation());
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


