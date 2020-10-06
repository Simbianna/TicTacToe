package tictactoe;

import java.util.Scanner;

import static tictactoe.TicTacToe.startGame;

/**
 * JetBrains Academy. Project: Tic-Tac-Toe
 * Description
 * Tic-tac-toe is a game played by two players on a 3x3 field.
 * <p>
 * One of the players plays as 'X', and the other player is 'O'. 'X' plays first, then the 'O' side plays, and so on.
 * <p>
 * The players write 'X' and 'O' on a 3x3 field.
 * <p>
 * The first player that writes 3 'X' or 3 'O' in a straight line (including diagonals) wins.
 * <p>
 * Suppose the bottom left cell has the coordinates (1, 1) and the top right cell has the coordinates (3, 3) like in this table:
 * <p>
 * (1, 3) (2, 3) (3, 3)
 * (1, 2) (2, 2) (3, 2)
 * (1, 1) (2, 1) (3, 1)
 */

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Field field = Field.initEmptyField();
        field.printMatrix();
        startGame(scanner, field);
    }
}