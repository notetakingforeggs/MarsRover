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

    public void GenerateRover(Position initialPosition, String name) {

        Rover rover = new Rover(initialPosition, name);
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

    public void moveRover(Instruction instruction, int roverID) {
        //System.out.println("Move rover called, id currently:" + roverID);
        new RoverMover().move(this, instruction, roverID);
    }

    public PlateauSize getPlateauSize() {
        return plateauSize;
    }

    public Rover[][] getPlateauArray() {
        return plateauArray;
    }

    public Rover getRover(int roverID) {
        //System.out.println("get rover called - ID is currently:" + roverID);

        //or here is the error? somewhere there must be another doing the minus one?
        return rovers.get(roverID -1);
    }
}
