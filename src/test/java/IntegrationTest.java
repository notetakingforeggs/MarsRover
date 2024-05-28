import ParsingLayer.MovementParser;
import ParsingLayer.PlateauSizeParser;
import ParsingLayer.Position;
import ParsingLayer.PositionParser;
import org.junit.jupiter.api.Test;

import java.util.Arrays;


public class IntegrationTest {
    @Test
    void basicIntegrationTest(){
        String[] test = new String[]{"5 5","1 2 N","MMRMM","1 1 N","MMMRMMM"};


        // initiate plateau
        Plateau testPlateau = new Plateau(new PlateauSizeParser().parseInput(test[0]));
        System.out.println(Arrays.deepToString(testPlateau.getPlateauArray()));
        // initiate rover and place on plateau
        Position testPosition = new PositionParser().parseInput((test[1]));
        testPlateau.GenerateRover(testPosition);
        System.out.println(Arrays.deepToString(testPlateau.getPlateauArray()));

        // rover move
        for(Character ch : test[2].toCharArray()){// second rover "3 3 E","MMRMMRMRRM"
            testPlateau.moveRover(new MovementParser().parseInput(ch), 0);
        }
        System.out.println(Arrays.deepToString(testPlateau.getPlateauArray()));



        System.out.println(testPlateau.getRover(0).getPosition().getX()+ " " + testPlateau.getRover(0).getPosition().getY()+ " " + testPlateau.getRover(0).getOrientation().toString());

        // initiate second rover
        Position testPosition2 = new PositionParser().parseInput((test[3]));
        testPlateau.GenerateRover(testPosition2);

        // Move second rover
        for(Character ch : test[4].toCharArray()){
            testPlateau.moveRover(new MovementParser().parseInput(ch), 1);
        }
        System.out.println(testPlateau.getRover(1).getPosition().getX()+ " " + testPlateau.getRover(1).getPosition().getY()+ " " + testPlateau.getRover(1).getOrientation());

    }
}
