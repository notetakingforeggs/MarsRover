package TerminalLayer;

import Models.Plateau;

public class PrintPlateau {
    public static void printPlateau(Plateau plateau) {
        int plateauLength = plateau.getPlateauArray().length;

        for (int x = plateauLength - 1; x >= 0; x--) {
            for (int y = 0; y < plateauLength; y++) {
                if (plateau.getPlateauArray()[y][x] == null) {
                    System.out.print("|~~");
                    //System.out.print(y +","+ x +"|");
                } else {
                    System.out.print("|⦿");
                }
            }
            System.out.print("|");
            System.out.println();
        }
        //System.out.println("\n---------------------------\n");
    }
}
