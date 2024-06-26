import Models.Plateau;
import ParsingLayer.MovementParser;
import ParsingLayer.PlateauSizeParser;
import ParsingLayer.Position;
import ParsingLayer.PositionParser;
import UI.PrintPlateau;
import org.junit.jupiter.api.Test;


public class IntegrationTest {
    @Test
    void basicIntegrationTest() throws InterruptedException {
        String[] test = new String[]{"10 10", "0 0 N", "MMMRMMMMLMMMMMMMLMMM", "1 1 N", "MMMRMMMMMMMMMLMMMMMMMMMMMLLMMMMMMMMMMMM"};

        // initiate plateau
        Plateau testPlateau = new Plateau(new PlateauSizeParser().parseInput(test[0]));
        System.out.println("PLATEAU INITIALISED");
        PrintPlateau.printPlateau(testPlateau, 1);
        Thread.sleep(2000);
        System.out.println("\n\n\n\n\n\n");

        // initiate rover and place on plateau
        Position testPosition = new PositionParser().parseInput((test[1]));
        testPlateau.GenerateRover(testPosition, "steve");
        System.out.println("FIRST ROVER INITIALISED");
        PrintPlateau.printPlateau(testPlateau, 1);
        Thread.sleep(1000);


        // rover move
        for (Character ch : test[2].toCharArray()) {
            testPlateau.moveRover(new MovementParser().parseInput(ch), 0);
            System.out.println("\n\n\n\n\n\n");

            PrintPlateau.printPlateau(testPlateau, 1);
            Thread.sleep(700);
        }
        //Thread.sleep(1000);
        System.out.println("\n\n\n\n\n\n");



        //System.out.println(testPlateau.getRover(0).getPosition().getX() + " " + testPlateau.getRover(0).getPosition().getY() + " " + testPlateau.getRover(0).getOrientation().toString());

        // initiate second rover
        Position testPosition2 = new PositionParser().parseInput((test[3]));
        testPlateau.GenerateRover(testPosition2, "steve");
        System.out.println("SECOND ROVER INITIALISED");
        PrintPlateau.printPlateau(testPlateau, 1);
        Thread.sleep(2000);


        // Move second rover
        for (Character ch : test[4].toCharArray()) {
            testPlateau.moveRover(new MovementParser().parseInput(ch), 1);
            System.out.println("\n\n\n\n\n\n");

            PrintPlateau.printPlateau(testPlateau, 1);
            Thread.sleep(700);
        }
        Thread.sleep(1000);

        System.out.println(testPlateau.getRover(1).getPosition().getX() + " " + testPlateau.getRover(1).getPosition().getY() + " " + testPlateau.getRover(1).getOrientation());

        PrintPlateau.printPlateau(testPlateau, 1);
    }
}
