import java.util.HashMap;

public class Plateau {
    private PlateauSize plateauSize;
    private int[][] plateauArray;

    public Plateau(PlateauSize plateauSize) {
        this.plateauSize = plateauSize;
        plateauArray = new int[plateauSize.getWidth()][plateauSize.getLength()];
    }

    public void generateArray(PlateauSize plateauSize) {

        // generating a grid of size x by y, indexes of each dimension of the array are like the axes.
        // the value in each cell is the same on each row, and is distinguished by index
        // each row starts at 1 and ends at whatever the size is
       /*for(int row = 0; row < plateauSize.getWidth(); row++){
           for (int col = 0; col < plateauSize.getLength(); col++){
               plateauArray[row][col] = col ;
           }*/


    }

    public PlateauSize getPlateauSize() {
        return plateauSize;
    }
    public int[][] getPlateauArray(){
        return plateauArray;
    }

}
