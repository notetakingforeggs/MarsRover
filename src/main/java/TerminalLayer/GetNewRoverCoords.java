package TerminalLayer;

import java.util.InputMismatchException;
import java.util.Scanner;

public class GetNewRoverCoords implements GetInput<Scanner, String> {
    @Override
    public String getInput(Scanner scanner) {
            while (true) {

                    String coords = scanner.nextLine();
                    if(coords.matches())

                    return coords;

            }
        return "";
    }
}
