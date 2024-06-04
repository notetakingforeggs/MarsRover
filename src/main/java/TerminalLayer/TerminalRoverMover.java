package TerminalLayer;

import Models.Plateau;
import ParsingLayer.InstructionParser;
import ParsingLayer.MovementParser;

import java.util.Scanner;

public class TerminalRoverMover {
    public void roverMove(Scanner scanner, Plateau plateau) {
        System.out.println("input directions to move rover, R = turn 90degrees right, L = turn 90 degrees left, M = move one step forwards.");
        System.out.println("example input: MMMMMRMMMLMM");
        String instructions = scanner.nextLine();


        for (Character ch : instructions.toCharArray()) {
            // TODO here you need to ask for rover number
            plateau.moveRover(new MovementParser().parseInput(ch), 0);
            PrintPlateau.printPlateau(plateau, 700);

        }
    }
}
