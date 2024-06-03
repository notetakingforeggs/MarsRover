package TerminalLayer;

import ParsingLayer.Position;
import ParsingLayer.PositionParser;

import java.util.InputMismatchException;
import java.util.Scanner;

public class GetNewRoverCoords implements GetInput<Scanner, Position> {
    @Override
    public Position getInput(Scanner scanner) {

            while (true) {
                System.out.println("Please input the position you would like to place the new rover, in the format: x, y, orientation");
                PositionParser positionParser = new PositionParser();

                String coords = scanner.nextLine();
                if (positionParser.parseInput(coords) != null){
                    return positionParser.parseInput(coords);
                }



//                    if(coords
//                            .strip()
//                            .toUpperCase()
//                            .matches("[0-9],[0-9],(N|S|E|W)"))
//                    coords = coords.strip().replace(",", "");

//
//
//                    return coords;

            }
    }
}
