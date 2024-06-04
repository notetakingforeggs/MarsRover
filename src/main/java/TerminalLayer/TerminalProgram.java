package TerminalLayer;
import Models.Plateau;
import Models.Rover;
import ParsingLayer.MovementParser;
import ParsingLayer.PlateauSizeParser;
import ParsingLayer.Position;
import ParsingLayer.PositionParser;

import java.sql.SQLOutput;
import java.util.Scanner;
public class TerminalProgram {

    public void terminalProgram(){
        System.out.println("Welcome to Mars Rover");
        Scanner scanner = new Scanner(System.in);
        new Menu().getMenu();
        int choice = scanner.nextInt();
        Plateau plateau = null;

        boolean ended = false;

        while(ended = false) {
            switch (choice) {
                case 1 -> {
                    // initiate plateau
                    GetPlateauDims getPlateauDims = new GetPlateauDims();
                    plateau = new Plateau(getPlateauDims.getInput(scanner));
                    System.out.println("PLATEAU INITIALISED");
                    PrintPlateau.printPlateau(plateau, 2000);

                }
                case 2 -> {
                    // initiate rover and place on plateau
                    GetNewRoverCoords getNewRoverCoords = new GetNewRoverCoords();
                    Position position = (getNewRoverCoords.getInput(scanner, plateau));
                    System.out.println("Please input a name for this rover");
                    String name = scanner.nextLine();
                    plateau.GenerateRover(position, name);
                    System.out.println("new rover initialised: " + name);
                    PrintPlateau.printPlateau(plateau, 1000);

                }
                case 3 -> {
                    // move rover
                    TerminalRoverMover terminalRoverMover = new TerminalRoverMover();
                    terminalRoverMover.roverMove(scanner, plateau);

                }
                case 4 -> {
                    // quit
                    System.out.println("Exiting program. Goodbye and thank-you for your time.");
                    scanner.close();
                    ended = true;
                }
            }
        }
    }
}
