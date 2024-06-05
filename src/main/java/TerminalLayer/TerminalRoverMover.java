package TerminalLayer;

import Models.Plateau;
import ParsingLayer.InstructionParser;
import ParsingLayer.MovementParser;

import java.util.Scanner;

public class TerminalRoverMover {
    public void roverMove(Scanner scanner, Plateau plateau) {
        Integer roverID;
        while (true) {
            System.out.println("Please input the ID of the rover you wish to move");
            roverID = scanner.nextInt();
            scanner.nextLine();

            if (plateau.getRover(roverID) == null) {
                System.out.println("invalid rover ID");
                continue;
            }


//  id:0 prints here?

            System.out.println("input directions to move rover, R = turn 90degrees right, L = turn 90 degrees left, M = move one step forwards.");
            System.out.println("example input: MMMMMRMMMLMM");
            String instructions = scanner.nextLine();
            MovementParser movementParser = new MovementParser();
            char[] instructionCharArray = instructions
                    .strip()
                    .replace(" ", "")
                    .replace(",", "")
                    .toUpperCase()
                    .toCharArray();
            for (Character ch : instructionCharArray) {
                //TODO breakingin here
                plateau.moveRover(movementParser.parseInput(ch), roverID);
                PrintPlateau.printPlateau(plateau, 700);

            }
            break;
        }
    }
}
