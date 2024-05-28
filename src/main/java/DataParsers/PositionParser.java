package DataParsers;

public class PositionParser implements InstructionParser<String, Position> {
    @Override
    public Position parseInput(String input) {
        Position position = new Position();
        String[] positionArray = input.split(" ");

        if (positionArray.length < 3){
            System.out.println("input must be three characters separated by spaces");
            return null;
        }

        // set compass direction value to enum
        CompassDirection compassDirection = getCompassDirection(positionArray);

        try {
            position.setX(Math.abs(Integer.parseInt(positionArray[0])));
            position.setY(Math.abs(Integer.parseInt(positionArray[1])));
            position.setFacing(compassDirection);

        } catch (NumberFormatException e) {
            System.out.println("X and Y coordinates takes input of only numbers");
            return null;
        }

        return position;
    }

    private static CompassDirection getCompassDirection(String[] positionArray) {
        String direction = positionArray[2];
        CompassDirection compassDirection;
        switch (direction){
            case "N" ->compassDirection = CompassDirection.N;
            case "E" -> compassDirection = CompassDirection.E;
            case "S" -> compassDirection = CompassDirection.S;
            case "W" -> compassDirection = CompassDirection.W;
            default -> throw new IllegalStateException("Unexpected value: " + direction);
             }
        return compassDirection;
    }
}
