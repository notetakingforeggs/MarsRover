package TerminalLayer;
import java.util.InputMismatchException;
import java.util.Scanner;
public class TerminalProgram {

    public void terminalProgram(){
        System.out.println("Welcome to mars rover");
        Scanner scanner = new Scanner(System.in);

    GetPlateauLength getPlateauLength = new GetPlateauLength();
    getPlateauLength.getInput(scanner);


    // do like an options menu. see menu. switch statemnt.
        // new plateau
        // move
        // new rover
        //

    }
}
