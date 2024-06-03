package Models;

import MovementLayer.RoverMover;
import ParsingLayer.Instruction;
import ParsingLayer.PlateauSize;
import ParsingLayer.Position;

import java.util.ArrayList;

public class Plateau {
    private PlateauSize plateauSize;
    private Rover[][] plateauArray;
    public ArrayList<Rover> rovers = new ArrayList<>();
    private int numberOfRovers = 0;

    public Plateau(PlateauSize plateauSize) {
        this.plateauSize = plateauSize;
        plateauArray = new Rover[plateauSize.getWidth()][plateauSize.getLength()];
    }

    public void GenerateRover(Position initialPosition) {

        Rover rover = new Rover(initialPosition);
        if (plateauSize.getLength() < initialPosition.getY() || plateauSize.getWidth() < initialPosition.getX()) {
            System.out.println("initial rover position is not within plateau, try again");
            //throw an error here?

            return;
        }
        this.plateauArray[initialPosition.getX()][initialPosition.getY()] = rover;

        this.rovers.add(numberOfRovers, rover);
        numberOfRovers++;
        // TODO multi rovers without repeating laods of code?
    }

    public void moveRover(Instruction instruction, int roverNumber) {
        new RoverMover().move(this, instruction, roverNumber);
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
