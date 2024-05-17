public class Rover {
    private Position position;
    private CompassDirection orientation;

    public Rover(Position initialPosition) {
        this.position = initialPosition;
        this.orientation = initialPosition.getFacing();
    }


    public void move(Instruction instruction) {

        if(instruction == Instruction.L){
                switch (orientation) {
                    case N -> orientation = CompassDirection.W;
                    case W -> orientation = CompassDirection.S;
                    case S -> orientation = CompassDirection.E;
                    case E -> orientation = CompassDirection.N;
                    default -> throw new IllegalStateException("Unexpected value: " + orientation);
                }
            }
        else if(instruction == instruction.R){
                switch (orientation) {
                    case N -> orientation = CompassDirection.E;
                    case E -> orientation = CompassDirection.S;
                    case S -> orientation = CompassDirection.W;
                    case W -> orientation = CompassDirection.N;
                    default -> throw new IllegalStateException("Unexpected value: " + orientation);
                }
            }
        else if (instruction == instruction.M){
            switch (orientation){
                case N -> position.setY(position.getY()+1);
                case E ->position.setX(position.getX()+1);
                case S ->position.setY(position.getY()-1);
                case W ->position.setX(position.getX()-1);
                default -> throw new IllegalStateException("Unexpected value: " + orientation);

            }

        }

        }


    public CompassDirection getOrientation() {
        return orientation;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
}
