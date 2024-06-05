package TerminalLayer;

import Models.Plateau;
import Models.Rover;

public class PrintPlateau {
    public static void printPlateau(Plateau plateau, int pause) {
        int plateauLength = plateau.getPlateauArray().length;
        int plateauWidth = plateau.getPlateauArray()[0].length;

        for (int x = plateauWidth - 1; x >= 0; x--) {
            for (int y = 0; y < plateauLength; y++) {
                if (plateau.getPlateauArray()[y][x] == null) {
                    System.out.print(ANSIColours.ANSI_RED_BACKGROUND + "|~~" + ANSIColours.ANSI_RESET);
                    //System.out.print(y +","+ x +"|");
                } else {
                    Rover currentRover = plateau.getPlateauArray()[y][x];
                    IDColour colour = currentRover.getColour();

                    String symbolColour = ANSIColours.ANSI_COLOUR_MAP.get(colour.toString());
                    System.out.print(ANSIColours.ANSI_RED_BACKGROUND + "|");
                    System.out.print(ANSIColours.ANSI_RED_BACKGROUND + symbolColour + "⦿" + ANSIColours.ANSI_RESET);
                }
            }
            System.out.print(ANSIColours.ANSI_RED_BACKGROUND + "|" + ANSIColours.ANSI_RESET);
            System.out.println();
        }
        //System.out.println("\n---------------------------\n");
        try {
            Thread.sleep(pause);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("\n\n\n\n\n\n");
    }
}
