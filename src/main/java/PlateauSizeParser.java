import java.util.ArrayList;
import java.util.List;

public class PlateauSizeParser implements InstructionParser<String, PlateauSize>{
    @Override
    public PlateauSize parseInput(String input) {

        PlateauSize plateauSize = new PlateauSize();
        String[] dims = input.split(" ");
        plateauSize.setWidth(Integer.parseInt(dims[0]));
        plateauSize.setLength(Integer.parseInt(dims[1]));

        return plateauSize;
    }
}
