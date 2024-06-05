package ParsingLayer;


import Models.Plateau;

public class PositionParser implements InstructionParser<String, Position> {
    @Override
    public Position parseInput(String input) {
        Position position = new Position();
        String[] positionArray = input.toUpperCase().split(",");

        if (positionArray.length != 3) {
            System.out.println("input must be: position on X axis, position on Y axis, Orientation as a letter (eg. 4,3,N) ");
            return null;
        }

        // set compass direction value to enum
        CompassDirection compassDirection = getCompassDirection(positionArray);

        try {
            position.setX(Math.abs(Integer.parseInt(positionArray[0]) - 1));
            position.setY(Math.abs(Integer.parseInt(positionArray[1]) - 1));
            position.setFacing(compassDirection);
            return position;

        } catch (NumberFormatException e) {
            System.out.println("X and Y coordinates takes input of only numbers");
            return null;
        }
    }

    private static CompassDirection getCompassDirection(String[] positionArray) {
        String direction = positionArray[2].strip();

        CompassDirection compassDirection;
        switch (direction) {
            case "N" -> compassDirection = CompassDirection.N;
            case "E" -> compassDirection = CompassDirection.E;
            case "S" -> compassDirection = CompassDirection.S;
            case "W" -> compassDirection = CompassDirection.W;
            default -> throw new IllegalStateException("Unexpected value: " + direction);
        }
        return compassDirection;
    }
}
