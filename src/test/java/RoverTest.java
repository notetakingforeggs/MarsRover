import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoverTest {



    @Test
    void moveRTest() {
        Position testposition = new PositionParser().parseInput("2 2 S");
        Rover testRover = new Rover(testposition);

        testRover.move(Instruction.R);
        assertEquals(CompassDirection.W , testRover.getOrientation());

        testRover.move(Instruction.R);
        assertEquals(CompassDirection.N , testRover.getOrientation());

        testRover.move(Instruction.R);
        assertEquals(CompassDirection.E , testRover.getOrientation());

    }

    @Test
    void moveLTest() {
        Position testposition = new PositionParser().parseInput("2 2 S");
        Rover testRover = new Rover(testposition);

        testRover.move(Instruction.L);
        assertEquals(CompassDirection.E, testRover.getOrientation());

        testRover.move(Instruction.L);
        assertEquals(CompassDirection.N , testRover.getOrientation());

        testRover.move(Instruction.L);
        assertEquals(CompassDirection.W , testRover.getOrientation());

    }

    @Test
    void moveTest(){
        Position testPosition = new PositionParser().parseInput(("2 2 S"));
        Rover testRover = new Rover((testPosition));

        testRover.move(Instruction.M);
        assertEquals(1, testRover.getPosition().getY());
        testRover.move(Instruction.L);
        testRover.move(Instruction.M);
        testRover.move(Instruction.M);
        assertEquals(4, testRover.getPosition().getX());



    }
}