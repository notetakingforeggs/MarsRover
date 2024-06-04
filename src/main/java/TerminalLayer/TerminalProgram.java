package TerminalLayer;
import Models.Plateau;
import Models.Rover;
import ParsingLayer.MovementParser;
import ParsingLayer.PlateauSizeParser;
import ParsingLayer.Position;
import ParsingLayer.PositionParser;

import java.util.Scanner;
public class TerminalProgram {

    public void terminalProgram(){
        System.out.println("Welcome to mars rover");
        Scanner scanner = new Scanner(System.in);

        // initiate plateau
        GetPlateauDims getPlateauDims = new GetPlateauDims();
        Plateau plateau = new Plateau(getPlateauDims.getInput(scanner));
        System.out.println("PLATEAU INITIALISED");
        PrintPlateau.printPlateau(plateau, 2000);


        // initiate rover and place on plateau
        GetNewRoverCoords getNewRoverCoords = new GetNewRoverCoords();
        Position position = (getNewRoverCoords.getInput(scanner, plateau));
        System.out.println("Please input a name for this rover");
        String name = scanner.nextLine();
        plateau.GenerateRover(position, name);
        System.out.println("new rover initialised: " + name);
        PrintPlateau.printPlateau(plateau, 1000);




     // move rover
     TerminalRoverMover terminalRoverMover = new TerminalRoverMover();
     terminalRoverMover.roverMove(scanner, plateau);


    }
}
