package ParsingLayer;

public class MovementParser implements InstructionParser<Character, Instruction> {
    @Override
    public Instruction parseInput(Character input) {

        while (true) {
            if (input == 'L') {
                return Instruction.L;
            } else if (input == 'R') {
                return Instruction.R;
            } else if (input == 'M') {
                return Instruction.M;
            } else {
                System.out.println("Sorry, " + input + " is not a valid instruction. ");
                return null;
            }
        }
    }
}
