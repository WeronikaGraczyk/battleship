import java.util.Arrays;

public class Board {
    private final String[][] board;
    private final String[] ABC = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};
    public int numberOfShips = 0;

    public Board() {
        this.board = new String[10][10];
        for (String[] strings : board) {
            Arrays.fill(strings, constValue.WATER);
        }
    }

    public boolean addShip(int length, Point first, Point second) {
        int startX = first.getX();
        int startY = first.getY();
        int endX = second.getX();
        int endY = second.getY();
        if (checkOtherShips(length, first, second)) {
            if (length == endX - startX + 1 && startY == endY) {
                for (int i = startX; i <= endX; i++) {
                    board[startY][i] = constValue.SHIP;
                }
                numberOfShips += length;
                return true;
            } else if (length == endY - startY + 1 && startX == endX) {
                for (int i = startY; i <= endY; i++) {
                    board[i][startX] = constValue.SHIP;
                }
                numberOfShips += length;
                return true;
            } else {
                System.out.println("Wrong cordinats! ");
            }
        } else {
            System.out.println("Wrong! The ship is too close to another ship ");
        }
        return false;
    }

    public void play(Point point) {
        int pointX = point.getX();
        int pointY = point.getY();
        if (board[pointY][pointX].equals(constValue.SHIP)) {
            board[pointY][pointX] = constValue.HIT;
            numberOfShips--;
        } else if (board[pointY][pointX].equals(constValue.WATER)) {
            board[pointY][pointX] = constValue.MISS;
        }
    }

    private boolean checkOtherShips(int length, Point first, Point second) {
        int startX = first.getX();
        int startY = first.getY();
        int endX = second.getX();
        int endY = second.getY();
        boolean result = true;
        if (length == endX - startX + 1 && startY == endY) {
            if (startX == 0) {
                startX++;
            }
            if (endX == 9) {
                endX--;
            }
            if (startY == 0) {
                for (int i = startX - 1; i <= endX + 1; i++) {
                    if (board[startY][i].equals(constValue.SHIP) || board[startY + 1][i].equals(constValue.SHIP)) {
                        result = false;
                        break;
                    }
                }
            } else if (endY == 9) {
                for (int i = startX - 1; i <= endX + 1; i++) {
                    if (board[startY][i].equals(constValue.SHIP) || board[startY - 1][i].equals(constValue.SHIP)) {
                        result = false;
                        break;
                    }
                }
            } else {
                for (int i = startX - 1; i <= endX + 1; i++) {
                    if (board[startY][i].equals(constValue.SHIP) || board[startY - 1][i].equals(constValue.SHIP) || board[startY + 1][i].equals(constValue.SHIP)) {
                        result = false;
                        break;
                    }
                }
            }
        } else if (length == endY - startY + 1 && startX == endX) {
            if (startY == 0) {
                startY++;
            }
            if (endY == 9) {
                endY--;
            }
            if (startX == 0) {
                for (int i = startY - 1; i <= endY + 1; i++) {
                    if (board[i][startX].equals(constValue.SHIP) || board[i][startX + 1].equals(constValue.SHIP)) {
                        result = false;
                        break;
                    }
                }
            } else if (endX == 9) {
                for (int i = startY - 1; i <= endY + 1; i++) {
                    if (board[i][startX].equals(constValue.SHIP) || board[i][startX - 1].equals(constValue.SHIP)) {
                        result = false;
                        break;
                    }
                }
            } else {
                for (int i = startY - 1; i <= endY + 1; i++) {
                    if (board[i][startX].equals(constValue.SHIP) || board[i][startX + 1].equals(constValue.SHIP) || board[i][startX - 1].equals(constValue.SHIP)) {
                        result = false;
                        break;
                    }
                }
            }
        }
        return result;
    }

    public int getNumberOfShips() {
        return numberOfShips;
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
