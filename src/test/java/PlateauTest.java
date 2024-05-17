import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlateauTest {

    @Test
    void generateArrayTest() {
        int[][] testArray = new int[2][2];


        assertAll(()->{

            assertArrayEquals(testArray, (new Plateau(new PlateauSizeParser().parseInput("2 2"))).getPlateauArray());

            assertArrayEquals(testArray, (new Plateau(new PlateauSizeParser().parseInput("2 2 2"))).getPlateauArray());

        });

    }
}