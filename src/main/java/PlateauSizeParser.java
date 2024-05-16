public class PlateauSizeParser implements InstructionParser<String, PlateauSize> {
    @Override
    public PlateauSize parseInput(String input) {

        PlateauSize plateauSize = new PlateauSize();


        String[] dims = input.split(" ");


        try {
            plateauSize.setWidth(Integer.parseInt(dims[0]));
            plateauSize.setLength(Integer.parseInt(dims[1]));

        } catch (NumberFormatException e) {
            System.out.println("plateau size takes input of only numbers");
        }

        return plateauSize;
    }
}
