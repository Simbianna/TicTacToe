package tictactoe;

import java.util.Scanner;

import static tictactoe.State.*;

public class TicTacToe {

    public static void startGame(Scanner scanner, Field field) {
        int counter = 1;
        boolean xTurn;
        boolean isFinished = false;
        State currentState;
        while (!isFinished) {
            xTurn = counter % 2 == 1;
            doMove(scanner, field, xTurn);
            field.printMatrix();
            currentState = checkState(field);
            field.setState(currentState);
            if (currentState == O_WINS || currentState == X_WINS) {
                isFinished = true;
                printState(currentState);
            } else if (currentState == CONTINUE) {
                counter++;
            } else {
                System.out.println("Nobody wins");
                isFinished = true;
            }
        }
    }

    private static void doMove(Scanner scanner, Field field, boolean xTurn) {
        String coordinates = getMoveCoordinates(scanner);
        boolean isDone = false;
        while (!isDone) {
            if (coordinates.matches(" *[123] [123] *")) {
                String[] coords = coordinates.split(" ");
                int j = Integer.parseInt(coords[0]);
                int i = Integer.parseInt(coords[1]);
                if (field.isCellOccupied(3 - i, j - 1)) {
                    System.out.println("This cell is occupied! Choose another one!");
                    coordinates = getMoveCoordinates(scanner);
                } else {
                    updateFieldCell(field, xTurn, i, j);
                    isDone = true;
                }
            } else if (coordinates.matches("[0-9 ]+")) {
                System.out.println("Coordinates should be from 1 to 3!");
                coordinates = getMoveCoordinates(scanner);
            } else {
                System.out.println("You should enter numbers!");
                coordinates = getMoveCoordinates(scanner);
            }
        }
    }

    private static String getMoveCoordinates(Scanner scanner) {
        System.out.print("Enter the coordinates : ");
        return scanner.nextLine();
    }

    private static State checkState(Field field) {
        int winsCounter = 0;
        int xCounter = 0;
        int oCounter = 0;
        int noValueCounter = 0;
        char currentCellValue;
        char currentWinner = 0;
        String[][] matrix = field.getMatrix();
        for (int i = 0; i < field.getSize(); ) {
            for (int j = 0; j < field.getSize(); ) {
                currentCellValue = matrix[i][j].charAt(0);
                if (currentCellValue == 'X') {
                    xCounter++;
                } else if (currentCellValue == 'O') {
                    oCounter++;
                } else noValueCounter++;
                if (currentCellValue == 'X' || currentCellValue == 'O') {
                    if (i == 0) {
                        if (j == 0) {
                            if (matrix[i][j + 1].charAt(0) == currentCellValue && matrix[i][j + 2].charAt(0) == currentCellValue ||
                                    matrix[i + 1][j].charAt(0) == currentCellValue && matrix[i + 2][j].charAt(0) == currentCellValue ||
                                    matrix[i + 1][j + 1].charAt(0) == currentCellValue && matrix[i + 2][j + 2].charAt(0) == currentCellValue) {
                                currentWinner = currentCellValue;
                                winsCounter++;

                            }
                        } else if (j == 1) {
                            if (matrix[i + 1][j].charAt(0) == currentCellValue && matrix[i + 2][j].charAt(0) == currentCellValue) {
                                currentWinner = currentCellValue;
                                winsCounter++;

                            }
                        } else if (j == 2) {
                            if (matrix[i + 1][j].charAt(0) == currentCellValue && matrix[i + 2][j].charAt(0) == currentCellValue ||
                                    matrix[i + 1][j - 1].charAt(0) == currentCellValue && matrix[i + 2][j - 2].charAt(0) == currentCellValue) {
                                currentWinner = currentCellValue;
                                winsCounter++;
                            }
                        }
                    } else if (i == 1 && j == 0 || i == 2 && j == 0) {
                        if (matrix[i][j + 1].charAt(0) == currentCellValue && matrix[i][j + 2].charAt(0) == currentCellValue) {
                            currentWinner = currentCellValue;
                            winsCounter++;
                        }
                    }
                }
                j++;
            }
            i++;
        }
        return getState(winsCounter, xCounter, oCounter, noValueCounter, currentWinner);
    }


    private static State getState(int winsCounter, int xCounter, int oCounter, int noValueCounter, char winner) {
        if (Math.abs(xCounter - oCounter) > 1 || winsCounter > 1) {
            return IMPOSSIBLE;
        } else if (winsCounter > 0) {
            return winner == 'X' ? X_WINS : O_WINS;
        } else if (noValueCounter == 0)
            return NEW;
        else return CONTINUE;
    }

    private static void updateFieldCell(Field field, boolean xTurn, int i, int j) {
        field.updateCell(3 - i, j - 1, getValueForUpdate(xTurn));
    }

    private static String getValueForUpdate(boolean xTurn) {
        return xTurn ? "X" : "O";
    }
}
