import ParsingLayer.CompassDirection;
import ParsingLayer.Instruction;

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
            switch (plateau.getRover(roverNumber).getOrientation()) {
                case N -> {
                    // if the Y value of the current rover is equal to the length of the plateau you cannot move
                    if (plateau.getRover(roverNumber).getPosition().getY() == plateau.getPlateauSize().getLength()) {
                        System.out.println("you are at the edge of the plateau.");
                    } else if (!(plateau.getPlateauArray()[plateau.getRover(roverNumber).getPosition().getX()][plateau.getRover(roverNumber).getPosition().getY() + 1] == null)) {
                        System.out.println("encountered an obstacle");
                    } else {
                        plateau.getRover(roverNumber).getPosition().setY(plateau.getRover(roverNumber).getPosition().getY() + 1);
                        // TODO here i am not sure if i have fucked up, i have edited a lot of the code and changing where i had previously been accessing the rover position via the rover in the rovers array...
                        // but maybe it is not an issue as i am only accessing one rover at a time in this method, and that is defined by the rover number, in the plateau.getRover thing?
                        // Actually maybe its ok because the getRover method actually accesses the rovers array! leaving this comment here until i check if it works
                        plateau.getPlateauArray()[plateau.getRover(roverNumber).getPosition().getX()][plateau.getRover(roverNumber).getPosition().getY()] = plateau.getRover(roverNumber);
                        plateau.getPlateauArray()[plateau.getRover(roverNumber).getPosition().getX()][plateau.getRover(roverNumber).getPosition().getY() - 1] = null;

                        // maybe make a method that updates the rover array based on the rovers position rather than accessing the old one
                        // could you use generics? pass in N/E/S/W as classes to pass in.
                    }
                }
                case E -> {
                    if (plateau.getRover(roverNumber).getPosition().getX() == plateau.getPlateauSize().getWidth()) {
                        System.out.println("you are at the edge of the plateau.");
                    } else if (!(plateau.getPlateauArray()[plateau.getRover(roverNumber).getPosition().getX() + 1][plateau.getRover(roverNumber).getPosition().getY()] == null)) {
                        System.out.println("encountered an obstacle");
                    } else {
                        plateau.getRover(roverNumber).getPosition().setX(plateau.getRover(roverNumber).getPosition().getX() + 1);
                        plateau.getPlateauArray()[plateau.getRover(roverNumber).getPosition().getX()][plateau.getRover(roverNumber).getPosition().getY()] = plateau.getRover(roverNumber);
                        plateau.getPlateauArray()[plateau.getRover(roverNumber).getPosition().getX() - 1][plateau.getRover(roverNumber).getPosition().getY()] = null;
                    }
                }
                case S -> {
                    if (plateau.getRover(roverNumber).getPosition().getY() == 0) {
                        System.out.println("you are at the edge of the plateau");
                    } else if (!(plateau.getPlateauArray()[plateau.getRover(roverNumber).getPosition().getX()][plateau.getRover(roverNumber).getPosition().getY() - 1] == null)) {
                        System.out.println("encountered an obstacle");
                    } else {
                        plateau.getRover(roverNumber).getPosition().setY(plateau.getRover(roverNumber).getPosition().getY() - 1);
                        plateau.getPlateauArray()[plateau.getRover(roverNumber).getPosition().getX()][plateau.getRover(roverNumber).getPosition().getY()] = plateau.getRover(roverNumber);
                        plateau.getPlateauArray()[plateau.getRover(roverNumber).getPosition().getX()][plateau.getRover(roverNumber).getPosition().getY() + 1] = null;
                    }
                }

                case W -> {
                    if (plateau.getRover(roverNumber).getPosition().getY() == 0) {
                        System.out.println("you are at the edge of the plateau");
                    } else if (!(plateau.getPlateauArray()[plateau.getRover(roverNumber).getPosition().getX() - 1][plateau.getRover(roverNumber).getPosition().getY()] == null)) {
                        System.out.println("encountered an obstacle");
                    } else {
                        plateau.getRover(roverNumber).getPosition().setX(plateau.getRover(roverNumber).getPosition().getX() - 1);
                        plateau.getPlateauArray()[plateau.getRover(roverNumber).getPosition().getX()][plateau.getRover(roverNumber).getPosition().getY()] = plateau.getRover(roverNumber);
                        plateau.getPlateauArray()[plateau.getRover(roverNumber).getPosition().getX() + 1][plateau.getRover(roverNumber).getPosition().getY()] = null;
                    }
                }
                default ->
                        throw new IllegalStateException("Unexpected value: " + plateau.getRover(roverNumber).getOrientation());
            }
        }
    }
}
