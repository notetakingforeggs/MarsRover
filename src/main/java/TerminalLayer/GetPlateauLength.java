package TerminalLayer;

import java.util.InputMismatchException;
import java.util.Scanner;

public class GetPlateauLength implements GetInput<Scanner, Integer> {

    @Override
    public Integer getInput(Scanner s) {
        while (true) {
            try {
                Integer length = s.nextInt();
                return length;
            } catch (InputMismatchException e) {
                System.out.println("Integers only");
                s.next();
                continue;
            }
        }

    }
}
