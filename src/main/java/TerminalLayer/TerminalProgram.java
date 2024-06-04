package TerminalLayer;
import Models.Plateau;
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
        plateau.GenerateRover(getNewRoverCoords.getInput(scanner, plateau));

        System.out.println("FIRST ROVER INITIALISED");
        PrintPlateau.printPlateau(plateau, 1000);

        // do like an options menu. see menu. switch statemnt.
        // new plateau
        // move
        // new rover
        //

    }
}
