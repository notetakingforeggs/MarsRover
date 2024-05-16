import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlateauSizeParserTest {

    @Test
    void parseInputTest() {
        PlateauSizeParser plateauSizeParser = new PlateauSizeParser();

        assertAll(()-> {

            assertInstanceOf( PlateauSize.class, plateauSizeParser.parseInput("1 1"));

        });


    }
}