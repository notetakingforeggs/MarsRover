package TerminalLayer;

import Models.Plateau;
import ParsingLayer.Position;
import ParsingLayer.PositionParser;

import java.util.InputMismatchException;
import java.util.Scanner;

public class GetNewRoverCoords {

    public Position getInput(Scanner scanner, Plateau plateau) {

        while (true) {
            System.out.println("Please input the position you would like to place the new rover, in the format: x, y, orientation");
            PositionParser positionParser = new PositionParser();
            String coords = scanner.nextLine();
            if (positionParser.parseInput(coords) == null) {
                continue;
            }

            int xValue = positionParser.parseInput(coords).getY();
            int yValue = positionParser.parseInput(coords).getX();

            if (yValue > plateau.getPlateauSize().getLength() || xValue > plateau.getPlateauSize().getWidth() || yValue < 0 || xValue < 0) {
                System.out.println("chosen position is out of bounds");
                continue;
            } else if (plateau.getPlateauArray()[xValue][yValue] != null) {
                System.out.println("chosen position is not empty");
                continue;
            } else {
                return positionParser.parseInput(coords);
            }

        }
    }
}

// TODO thinking i can pass in the plateau to access the dims so i can do the conditional to make sure i cant put a rover on top of a rover, or outside of the area.


//                    if(coords
//                            .strip()
//                            .toUpperCase()
//                            .matches("[0-9],[0-9],(N|S|E|W)"))
//                    coords = coords.strip().replace(",", "");

//
//
//                    return coords;
