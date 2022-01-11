import java.util.Arrays;

public class OpponentBoard {
    private final String[][] board;
    private final String[] ABC = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};
    public int numberOfShips;

    public OpponentBoard(int numberOfShips) {
        this.numberOfShips = numberOfShips;
        this.board = new String[10][10];
        for (String[] strings : board) {
            Arrays.fill(strings, constValue.WATER);
        }
    }

    public boolean update(Point point, int value) {
        int pointX = point.getX();
        int pointY = point.getY();

        if (value == 1) {
            board[pointY][pointX] = constValue.SHIP;
            numberOfShips--;
            return true;
        } else if (value == 2) {
            board[pointY][pointX] = constValue.MISS;
            return true;
        }
        return false;
    }

    public void view() {
        System.out.print("  ");
        for (int i = 1; i <= 10; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < board.length; i++) {
            System.out.print(ABC[i] + " ");
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}
