public class PrintPlateau {
    public static void printPlateau(Plateau plateau){
        int plateauLength = plateau.getPlateauArray().length;

        for (int i = plateauLength-1; i >= 0; i--) {
            for (int j = 0; j < plateauLength; j++) {
                if(plateau.getPlateauArray()[i][j] == null) {
                    System.out.print("|~~");
                }
                else{
                    System.out.print("|⦿");
                }
            }
            System.out.print("|");
            System.out.println();
        }
        System.out.println("\n---------------------------\n" );
    }
}
