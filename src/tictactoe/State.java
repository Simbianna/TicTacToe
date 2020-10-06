package tictactoe;

public enum State {
    X_WINS,
    O_WINS,
    IMPOSSIBLE,
    NEW,
    CONTINUE;

    public static void printState(State state) {
        if (state == State.CONTINUE) System.out.println("Game not finished");
        else if (state == State.X_WINS) System.out.println("X wins");
        else if (state == State.O_WINS) System.out.println("O wins");
        else if (state == State.NEW) System.out.println("Draw");
        else System.out.println("Impossible");
    }
}
