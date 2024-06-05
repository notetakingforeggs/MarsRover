package ParsingLayer;


public class PlateauSizeParser implements InstructionParser<String, PlateauSize> {
    @Override
    public PlateauSize parseInput(String input) {

        PlateauSize plateauSize = new PlateauSize();
        String[] dims = input
                .replace(" ", "")
                .split(",");

        if (dims.length != 2) {
            System.out.println("input must be two numbers separated by a comma");
            return null;
        }
        else if(Integer.valueOf(dims[0]) < 1 || Integer.valueOf(dims[1]) < 1){
            System.out.println("Plateau cannot be less than 1 unit in either dimension");
            return null;
        }
        try {
            plateauSize.setWidth(Math.abs(Integer.parseInt(dims[0])));
            plateauSize.setLength(Math.abs(Integer.parseInt(dims[1])));

        } catch (NumberFormatException | NullPointerException e) {
            System.out.println("plateau size takes input of only numbers");
            return null;
        }

        return plateauSize;
    }
}
