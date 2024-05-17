import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PlateauTest {

    @Test
    void generateArrayTest() {
        int[][] testArray = new int[2][2];


        assertAll(()->{

            assertArrayEquals(testArray, (new Plateau(new PlateauSizeParser().parseInput("2 2"))).getPlateauArray());

            assertArrayEquals(testArray, (new Plateau(new PlateauSizeParser().parseInput("2 2 2"))).getPlateauArray());
            //( passes but ignores y axis for now)
        });

    }

    @Test
    void generateRover() {
        Plateau testPlateau = new Plateau(new PlateauSizeParser().parseInput("6 6"));
        testPlateau.GenerateRover(new PositionParser().parseInput("4 4 N"));

        Rover testRover = new Rover(new PositionParser().parseInput(("4 4 N")));

        //assertEquals(testRover.getPosition(), testPlateau.getRover().getPosition());
        assertThat(testRover).usingRecursiveComparison().isEqualTo(testPlateau.getRover());
    }
}