package TerminalLayer;

import Models.Plateau;
import Models.Rover;
import ParsingLayer.MovementParser;
import ParsingLayer.PlateauSizeParser;
import ParsingLayer.Position;
import ParsingLayer.PositionParser;

import java.sql.SQLOutput;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TerminalProgram {

    public void terminalProgram() {
        System.out.println("Welcome to Mars Rover");


        boolean ended = false;
        Plateau plateau = null;
        Scanner scanner = new Scanner(System.in);
        while (!ended) {

            new Menu().getMenu();
            int choice = 0;
            try {
                choice = scanner.nextInt();
                scanner.nextLine();

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
                        if (plateau == null) {
                            System.out.println("You must initiate a plateau before initiating a rover");
                            continue;
                        }
                        GetNewRoverCoords getNewRoverCoords = new GetNewRoverCoords();
                        Position position = (getNewRoverCoords.getInput(scanner, plateau));
                        System.out.println("Please input a name for this rover");
                        String name = scanner.nextLine();
                        plateau.GenerateRover(position, name);
                        System.out.println("new rover initialised: " + name);
                        PrintPlateau.printPlateau(plateau, 2000);

                    }
                    case 3 -> {
                        // move rover
                        if (plateau == null) {
                            System.out.println("You must initiate a plateau before initiating and 3moving a rover");
                            continue;
                        } else if (plateau.rovers.get(0) == null) {
                            System.out.println("You must initate a rover before trying to move it");
                            continue;
                        }
                        TerminalRoverMover terminalRoverMover = new TerminalRoverMover();
                        terminalRoverMover.roverMove(scanner, plateau);

                    }
                    case 4 -> {
                        if (plateau == null) {
                            System.out.println("There are no rovers on the plateau");
                            continue;
                        }
                        new ViewRovers().viewRover(plateau);
                    }
                    case 5 -> {
                        // quit
                        System.out.println("Exiting program. Goodbye and thank-you for your time.");
                        scanner.close();
                        ended = true;
                    }
                    default ->
                            System.out.println("Please enter one of the options as its corresponding integer value");
                }

            } catch (InputMismatchException e) {
                System.out.println("Please enter one of the options as its corresponding integer value.");
                scanner.nextLine();
            }
        }
    }
}

