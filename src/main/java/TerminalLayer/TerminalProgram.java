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
        PrintPlateau.printPlateau(plateau);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("\n\n\n\n\n\n");

        // initiate rover and place on plateau
        GetNewRoverCoords getNewRoverCoords = new GetNewRoverCoords();
        getNewRoverCoords.getInput(scanner);


            if (plateau.GenerateRover(getNewRoverCoords.getInput(scanner)){

        }

                // some error i choose){ put this in a loop here so you have to put the appropriate dims for the rover within the plateau)

        System.out.println("FIRST ROVER INITIALISED");
        PrintPlateau.printPlateau(plateau);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


        // do like an options menu. see menu. switch statemnt.
        // new plateau
        // move
        // new rover
        //

    }
}
