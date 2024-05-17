import java.util.ArrayList;
import java.util.HashMap;

public class Plateau {
    private PlateauSize plateauSize;
    private Rover[][] plateauArray;
    private ArrayList<Rover> rovers = new ArrayList<>();
    private int numberOfRovers = 0;

    public Plateau(PlateauSize plateauSize) {
        this.plateauSize = plateauSize;
        plateauArray = new Rover[plateauSize.getWidth()][plateauSize.getLength()];

    }

    public void GenerateRover(Position initialPosition) {

        Rover rover = new Rover(initialPosition);
        if (plateauSize.getLength() < initialPosition.getY() || plateauSize.getWidth() < initialPosition.getX()) {
            System.out.println("initial rover position is not within plateau, try again");
            return;
        }
        this.plateauArray[initialPosition.getX()][initialPosition.getY()] = rover;

        this.rovers.add(numberOfRovers, rover);
        numberOfRovers++;
        // TODO multi rovers without repeating laods of code?
    }

    public void moveRover(Instruction instruction, int roverNumber) {

        if (instruction == Instruction.L) {
            switch (rovers.get(roverNumber).getOrientation()) {
                case N -> rovers.get(roverNumber).setOrientation(CompassDirection.W);
                case W -> rovers.get(roverNumber).setOrientation(CompassDirection.S);
                case S -> rovers.get(roverNumber).setOrientation(CompassDirection.E);
                case E -> rovers.get(roverNumber).setOrientation(CompassDirection.N);
                default -> throw new IllegalStateException("Unexpected value: " + rovers.get(roverNumber).getOrientation());
            }
        } else if (instruction == instruction.R) {
            switch (rovers.get(roverNumber).getOrientation()) {
                case N -> rovers.get(roverNumber).setOrientation(CompassDirection.E);
                case E -> rovers.get(roverNumber).setOrientation(CompassDirection.S);
                case S -> rovers.get(roverNumber).setOrientation(CompassDirection.W);
                case W -> rovers.get(roverNumber).setOrientation(CompassDirection.N);
                default ->
                        throw new IllegalStateException("Unexpected value: " + rovers.get(roverNumber).getOrientation());
            }
        } else if (instruction == instruction.M) {
            switch (rovers.get(roverNumber).getOrientation()) {
                case N -> {
                    if (rovers.get(roverNumber).getPosition().getY() == plateauSize.getLength()) {
                        System.out.println("you are at the edge of the plateau.");
                    }else if(plateauArray[rovers.get(roverNumber).getPosition().getX()][rovers.get(roverNumber).getPosition().getY()+1]){

                    }
                    else {
                        rovers.get(roverNumber).getPosition().setY(rovers.get(roverNumber).getPosition().getY() + 1);
                    }
                }
                case E -> {
                    if (rovers.get(roverNumber).getPosition().getX() == plateauSize.getWidth()) {
                        System.out.println("you are at the edge of the plateau.");
                        return;
                    } else {
                        rovers.get(roverNumber).getPosition().setX(rovers.get(roverNumber).getPosition().getX() + 1);
                    }
                }
                case S -> {
                    if (rovers.get(roverNumber).getPosition().getY() == 0) {
                        System.out.println("you are at the edge of the plateau");
                        return;
                    } else {
                        rovers.get(roverNumber).getPosition().setY(rovers.get(roverNumber).getPosition().getY() - 1);
                    }
                }

                case W -> {
                    if (rovers.get(roverNumber).getPosition().getY() == 0) {
                        System.out.println("you are at the edge of the plateau");
                        return;
                    } else {
                        rovers.get(roverNumber).getPosition().setX(rovers.get(roverNumber).getPosition().getX() - 1);
                    }
                }
                default -> throw new IllegalStateException("Unexpected value: " + rovers.get(roverNumber).getOrientation());
            }
        }
    }

    public PlateauSize getPlateauSize() {
        return plateauSize;
    }

    public Rover[][] getPlateauArray() {
        return plateauArray;
    }

    public Rover getRover(int roverNumber) {
        return rovers.get(roverNumber);
    }
}
