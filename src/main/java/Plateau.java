import java.util.HashMap;

public class Plateau {
    private PlateauSize plateauSize;
    private int[][] plateauArray;
    private Rover rover;

    public Plateau(PlateauSize plateauSize) {
        this.plateauSize = plateauSize;
        plateauArray = new int[plateauSize.getWidth()][plateauSize.getLength()];
    }

    public void GenerateRover(Position initialPosition){
        Rover rover = new Rover(initialPosition);
        this.rover =rover;
    }

    public PlateauSize getPlateauSize() {
        return plateauSize;
    }
    public int[][] getPlateauArray(){
        return plateauArray;
    }

    public Rover getRover() {
        return rover;
    }
}
