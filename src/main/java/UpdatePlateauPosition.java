import ParsingLayer.Position;

public class UpdatePlateauPosition {
    public static void updatePlateauPosition(Plateau plateau, Rover rover, Position initialPosition){
        plateau.getPlateauArray()
                [rover.getPosition().getX()]
                [rover.getPosition().getY()]
                = rover;
        plateau.getPlateauArray()
                [initialPosition.getX()]
                [initialPosition.getY()]
                = null;
    }
}
