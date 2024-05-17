import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PositionParserTest {

    @Test
    void parseInputTest() {

        PositionParser positionParser = new PositionParser();
        Position testPosition = new Position();
        testPosition.setY(2);
        testPosition.setX(3);
        testPosition.setFacing(CompassDirection.N);

        assertAll(() -> {

            assertInstanceOf(Position.class, positionParser.parseInput("3 2 N"));

            assertEquals(null, positionParser.parseInput("m"));
            assertEquals(null, positionParser.parseInput("11"));
            assertEquals(null, positionParser.parseInput("? ?"));
            assertEquals(null, positionParser.parseInput(""));

            assertEquals(3, positionParser.parseInput(("3 2 N")).getX());
            assertEquals(2, positionParser.parseInput(("-3 -2 N")).getY());
            assertThat(testPosition).usingRecursiveComparison().isEqualTo(positionParser.parseInput(("3 2 N")));

        });
    }
}