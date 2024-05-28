import DataParsers.PlateauSizeParser;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PlateauSizeParserTest {

    @Test
    void parseInputTest() {
        PlateauSizeParser plateauSizeParser = new PlateauSizeParser();
        PlateauSize testPlateau = new PlateauSize();
        testPlateau.setWidth(4);
        testPlateau.setLength(3);

        assertAll(() -> {

            assertInstanceOf(PlateauSize.class, plateauSizeParser.parseInput("1 1"));

            assertEquals(null, plateauSizeParser.parseInput("m"));
            assertEquals(null, plateauSizeParser.parseInput("11"));
            assertEquals(null, plateauSizeParser.parseInput("? ?"));
            assertEquals(null, plateauSizeParser.parseInput(""));

            assertEquals(4, plateauSizeParser.parseInput(("4 3")).getWidth());
            assertEquals(4, plateauSizeParser.parseInput(("-4 -3")).getWidth());
            assertThat(testPlateau).usingRecursiveComparison().isEqualTo(plateauSizeParser.parseInput(("4 3")));

        });


    }
}