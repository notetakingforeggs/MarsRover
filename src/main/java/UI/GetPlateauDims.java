package UI;

import ParsingLayer.PlateauSize;
import ParsingLayer.PlateauSizeParser;

import java.util.InputMismatchException;
import java.util.Scanner;

public class GetPlateauDims {

    public PlateauSize getInput(Scanner scanner) {

        PlateauSizeParser plateauSizeParser = new PlateauSizeParser();
        System.out.println("Please input plateau dimensions in format: x,y");
        while (true) {

            try {
                String input = scanner.nextLine();
                if(plateauSizeParser.parseInput(input) == null){
                    continue;
                }
                return plateauSizeParser.parseInput(input);
            } catch (InputMismatchException e) {
                System.out.println("Integers only");
                scanner.next();
            }
       }
    }
}
