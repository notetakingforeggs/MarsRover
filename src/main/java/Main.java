import Models.Plateau;
import ParsingLayer.MovementParser;
import ParsingLayer.PlateauSizeParser;
import ParsingLayer.Position;
import ParsingLayer.PositionParser;
import TerminalLayer.PrintPlateau;
import TerminalLayer.TerminalProgram;

import java.util.ArrayList;
// TODO array of zero zero does not handle well

public class Main {
    public static void main(String[] args) throws InterruptedException {
//        String filepath = "/home/ludic/northcoders/fundamentals/MarsRover/src/main/resources/input.csv";
//        ArrayList<String> test = FileInputReader.readFile(filepath);
////        System.out.println("TEST" + testString);
//        System.out.println(test.get(1));

        TerminalProgram terminalProgram = new TerminalProgram();
        terminalProgram.terminalProgram();

        //String[] test = new String[]{"10 10", "0 0 N", "MMMRMMMMLMMMMMMMLMMM", "1 1 N", "MMMRMMMMMMMMMLMMMMMMMMMMMLLMMMMMMMMMMMM"};

//        // initiate plateau
//        Plateau testPlateau = new Plateau(new PlateauSizeParser().parseInput(test.get(0)));
//        System.out.println("PLATEAU INITIALISED");
//        PrintPlateau.printPlateau(testPlateau);
//        Thread.sleep(2000);
//        System.out.println("\n\n\n\n\n\n");
//
//        // initiate rover and place on plateau
//        Position testPosition = new PositionParser().parseInput((test.get(1)));
//        testPlateau.GenerateRover(testPosition);
//        System.out.println("FIRST ROVER INITIALISED");
//        PrintPlateau.printPlateau(testPlateau);
//        Thread.sleep(1000);
//
//
//        // rover move
//        for (Character ch : test.get(2).toCharArray()) {
//            testPlateau.moveRover(new MovementParser().parseInput(ch), 0);
//            System.out.println("\n\n\n\n\n\n");
//
//            PrintPlateau.printPlateau(testPlateau);
//            Thread.sleep(700);
//        }
//        //Thread.sleep(1000);
//        System.out.println("\n\n\n\n\n\n");
//
//
//        //System.out.println(testPlateau.getRover(0).getPosition().getX() + " " + testPlateau.getRover(0).getPosition().getY() + " " + testPlateau.getRover(0).getOrientation().toString());
//
//        // initiate second rover
//      /*  Position testPosition2 = new PositionParser().parseInput((test[3]));
//        testPlateau.GenerateRover(testPosition2);
//        System.out.println("SECOND ROVER INITIALISED");
//        TerminalLayer.PrintPlateau.printPlateau(testPlateau);
//        Thread.sleep(2000);
//
//
//        // Move second rover
//        for (Character ch : test[4].toCharArray()) {
//            testPlateau.moveRover(new MovementParser().parseInput(ch), 1);
//            System.out.println("\n\n\n\n\n\n");
//
//            TerminalLayer.PrintPlateau.printPlateau(testPlateau);
//            Thread.sleep(700);
//        }
//        Thread.sleep(1000);
//
//        System.out.println(testPlateau.getRover(1).getPosition().getX() + " " + testPlateau.getRover(1).getPosition().getY() + " " + testPlateau.getRover(1).getOrientation());
//
//        TerminalLayer.PrintPlateau.printPlateau(testPlateau);
//    }



    }
}