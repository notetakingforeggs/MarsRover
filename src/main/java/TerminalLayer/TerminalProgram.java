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
        plateau.GenerateRover(getNewRoverCoords.getInput(scanner, plateau, name));


        PrintPlateau.printPlateau(plateau, 1000);
        System.out.println(plateau.rovers);


        // move rover
     TerminalRoverMover terminalRoverMover = new TerminalRoverMover();
     terminalRoverMover.roverMove(scanner, plateau);


    }
}
