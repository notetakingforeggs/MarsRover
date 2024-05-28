import ParsingLayer.Position;

public class UpdatePlateauPosition {
    public static void updatePlateauPosition(Plateau plateau, Rover rover, int x, int y){
        plateau.getPlateauArray()
                [rover.getPosition().getX()]
                [rover.getPosition().getY()]
                = rover;
        plateau.getPlateauArray()
                [x]
                [y]
                = null;
    }
}
