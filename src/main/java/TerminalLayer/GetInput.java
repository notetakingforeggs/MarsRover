package TerminalLayer;

import Models.Plateau;

public interface GetInput<Scanner ,T> {
   T getInput(Scanner scanner, Plateau plateau);
}
