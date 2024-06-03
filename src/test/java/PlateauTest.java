import Models.Plateau;
import Models.Rover;
import ParsingLayer.*;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PlateauTest {


    @Test
    void generateRover() {
        Plateau testPlateau = new Plateau(new PlateauSizeParser().parseInput("6 6"));
        testPlateau.GenerateRover(new PositionParser().parseInput("4 4 N"));

        Rover testRover = new Rover(new PositionParser().parseInput(("4 4 N")));

        //assertEquals(testRover.getPosition(), testPlateau.getRover().getPosition());
        //assertThat(testRover).usingRecursiveComparison().isEqualTo(testPlateau.getRover());

        assertThat(testRover).usingRecursiveComparison().isEqualTo(testPlateau.getPlateauArray()[4][4]);
        testPlateau.GenerateRover(new PositionParser().parseInput("8 4 N"));

    }

    @Test
    void moveRTest() {
        Position testposition = new PositionParser().parseInput("2 2 S");
        Plateau testPlateau = new Plateau(new PlateauSizeParser().parseInput("4 4"));

        testPlateau.GenerateRover(testposition);

        testPlateau.moveRover(Instruction.R, 0);
        assertEquals(CompassDirection.W, testPlateau.getRover(0).getOrientation());

        testPlateau.moveRover(Instruction.R, 0);
        assertEquals(CompassDirection.N, testPlateau.getRover(0).getOrientation());

        testPlateau.moveRover(Instruction.R, 0);
        assertEquals(CompassDirection.E, testPlateau.getRover(0).getOrientation());
    }

    @Test
    void moveLTest() {
        Position testposition = new PositionParser().parseInput("2 2 S");
        Plateau testPlateau = new Plateau(new PlateauSizeParser().parseInput("4 4"));

        testPlateau.GenerateRover(testposition);

        testPlateau.moveRover(Instruction.L, 0);
        assertEquals(CompassDirection.E, testPlateau.getRover(0).getOrientation());

        testPlateau.moveRover(Instruction.L, 0);
        assertEquals(CompassDirection.N, testPlateau.getRover(0).getOrientation());

        testPlateau.moveRover(Instruction.L, 0);
        assertEquals(CompassDirection.W, testPlateau.getRover(0).getOrientation());
    }


    @Test
    void moveTest() {
        Position testPosition = new PositionParser().parseInput(("2 2 S"));
        Plateau testPlateau = new Plateau(new PlateauSizeParser().parseInput("4 4"));
        testPlateau.GenerateRover(testPosition);

        testPlateau.moveRover(Instruction.M, 0);
        assertEquals(1, testPlateau.getRover(0).getPosition().getY());
        testPlateau.moveRover(Instruction.L, 0);
        testPlateau.moveRover(Instruction.M, 0);
        testPlateau.moveRover(Instruction.M, 0);

        assertEquals(4, testPlateau.getRover(0).getPosition().getX());
        testPlateau.moveRover(Instruction.M, 0);
        testPlateau.moveRover(Instruction.M, 0);
        assertEquals(4, testPlateau.getRover(0).getPosition().getX());


    }
}