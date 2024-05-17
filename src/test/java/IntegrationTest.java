import org.junit.jupiter.api.Test;

public class IntegrationTest {
    @Test
    void basicIntegrationTest(){
        String[] test = new String[]{"5 5","1 2 N","LMLMLMLMM","3 3 E","MMRMMRMRRM"};

        // second rover "3 3 E","MMRMMRMRRM"

        // initiate plateau
        Plateau testPlateau = new Plateau(new PlateauSizeParser().parseInput(test[0]));


        // initiate rover and place on plateau
        Position testPosition = new PositionParser().parseInput((test[1]));
        testPlateau.GenerateRover(testPosition);

        // rover move
        for(Character ch : test[2].toCharArray()){
            testPlateau.moveRover(new MovementParser().parseInput(ch), 0);
        }
        System.out.println(testPlateau.getRover(0).getPosition().getX()+ " " + testPlateau.getRover(0).getPosition().getY()+ " " + testPlateau.getRover(0).getPosition().getFacing().toString());

        // initiate second rover
        Position testPosition2 = new PositionParser().parseInput((test[3]));
        testPlateau.GenerateRover(testPosition2);

        // Move second rover
        for(Character ch : test[4].toCharArray()){
            testPlateau.moveRover(new MovementParser().parseInput(ch), 1);
        }
        System.out.println(testPlateau.getRover(1).getPosition().getX()+ " " + testPlateau.getRover(1).getPosition().getY()+ " " + testPlateau.getRover(1).getPosition().getFacing().toString());

    }
}
