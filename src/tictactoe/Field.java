package tictactoe;

public class Field {
    private String[][] matrix;
    private final int size = 3;
    private State state;

    private Field() {
    }

    public static Field initEmptyField() {
        Field field = new Field();
        field.setMatrix(getEmptyMatrix());
        return field;
    }

    private static String[][] getEmptyMatrix() {
        return new String[][]{{" ", " ", " "}, {" ", " ", " "}, {" ", " ", " "}};
    }

    public void setAllCellsEmpty() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = " ";
            }
        }
    }

    public boolean isCellOccupied(int i, int j) {
        return matrix[i][j].equals("X") || matrix[i][j].equals("O");
    }

    public void updateCell(int i, int j, String value) {
        matrix[i][j] = value;
    }

    public String[][] getMatrix() {
        return matrix;
    }

    private void setMatrix(String[][] matrix) {
        this.matrix = matrix;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public int getSize() {
        return size;
    }

    public void printMatrix() {
        System.out.println("---------");
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (j == 0) {
                    System.out.print("| ");
                }
                System.out.print(matrix[i][j] + " ");
                if (j == 2) {
                    System.out.print("|");
                }
            }
            System.out.println();
        }
        System.out.println("---------");
    }
}
