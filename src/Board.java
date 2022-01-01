public class Board {
    private String tablica[][];
    private static String ship = "o";
    private static String hit = "x";
    private static String miss = "M";
    private static String WATER = "~";

    class Error {
        private static final String COORDINATES = "Wrong coordinates";
    }

    public Board() {
        this.tablica = new String[11][11];
        for (int i = 1; i < tablica.length; i++) {
            for (int j = 1; j < tablica[i].length; j++) {
                tablica[i][j] = WATER;
            }
        }
        tablica[0][0] = " ";
        tablica[0][1] = "1";
        tablica[0][2] = "2";
        tablica[0][3] = "3";
        tablica[0][4] = "4";
        tablica[0][5] = "5";
        tablica[0][6] = "6";
        tablica[0][7] = "7";
        tablica[0][8] = "8";
        tablica[0][9] = "9";
        tablica[0][10] = "10";
        tablica[1][0] = "A";
        tablica[2][0] = "B";
        tablica[3][0] = "C";
        tablica[4][0] = "D";
        tablica[5][0] = "E";
        tablica[6][0] = "F";
        tablica[7][0] = "G";
        tablica[8][0] = "H";
        tablica[9][0] = "I";
        tablica[10][0] = "J";
    }

    public void addShip(int length, String first, String second) {
        int startX = whatsSecondNumber(first);
        int startY = whatsFirstNumber(first);
        int endX = whatsSecondNumber(second);
        int endY = whatsFirstNumber(second);
        if (checkOtherShips(length, first, second)) {
            if (length == endX - startX + 1 && startY == endY) {
                for (int i = startX; i <= endX; i++) {
                    tablica[startY][i] = ship;
                }
            } else if (length == endY - startY + 1 && startX == endX) {
                for (int i = startY; i <= endY; i++) {
                    tablica[i][startX] = ship;
                }
            } else {
                System.out.println("Wrong cordinats! ");
            }
        } else {
            System.out.println("Wrong! The ship is too close to another ship ");
        }
    }

    private boolean checkOtherShips(int length, String first, String second) {
        int startX = whatsSecondNumber(first);
        int startY = whatsFirstNumber(first);
        int endX = whatsSecondNumber(second);
        int endY = whatsFirstNumber(second);
        boolean result = true;
        if (length == endX - startX + 1 && startY == endY) {
            if (startX == 1) {
                startX++;
            }
            if (endX == 10) {
                endX--;
            }
            if (startY == 1) {
                for (int i = startX - 1; i <= endX + 1; i++) {
                    if (tablica[startY][i].equals(ship) || tablica[startY + 1][i].equals(ship)) {
                        result = false;
                    }
                }
            } else if (endY == 10) {
                for (int i = startX - 1; i <= endX + 1; i++) {
                    if (tablica[startY][i].equals(ship) || tablica[startY - 1][i].equals(ship)) {
                        result = false;
                    }
                }
            } else {
                for (int i = startX - 1; i <= endX + 1; i++) {
                    if (tablica[startY][i].equals(ship) || tablica[startY - 1][i].equals(ship) || tablica[startY + 1][i].equals(ship)) {
                        result = false;
                    }
                }
            }
        } else if (length == endY - startY + 1 && startX == endX) {
            if (startY == 1) {
                startY++;
            }
            if (endY == 10) {
                endY--;
            }
            if (startX == 1) {
                for (int i = startY - 1; i <= endY + 1; i++) {
                    if (tablica[i][startX].equals(ship) || tablica[i][startX + 1].equals(ship)) {
                        result = false;
                    }
                }
            } else if (endX == 10) {
                for (int i = startY - 1; i <= endY + 1; i++) {
                    if (tablica[i][startX].equals(ship) || tablica[i][startX + 1].equals(ship)) {
                        result = false;
                    }
                }
            } else {
                for (int i = startY - 1; i <= endY + 1; i++) {
                    if (tablica[i][startX].equals(ship) || tablica[i][startX + 1].equals(ship) || tablica[i][startX - 1].equals(ship)) {
                        result = false;
                    }
                }
            }
        }
        return result;
    }

    private int whatsFirstNumber(String place) {
        String i = place.substring(0);
        return i.charAt(0) - 64;
    }

    private int whatsSecondNumber(String place) {
        String j = place.substring(1);
        return Integer.parseInt(j);
    }

    public void view() {
        for (int i = 0; i < tablica.length; i++) {
            for (int j = 0; j < tablica[i].length; j++) {
                System.out.print(tablica[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void bl() {
//        int startRow = whatsFisrtNumber(first);
//        int start = whatsSecondNumber(first);
//        int endRow = whatsFisrtNumber(second);
//        int end = whatsSecondNumber(second);
//        if (checkCoordinates(length, first, second)) {
//            if (length == end - start + 1 && startRow == endRow) {
//                for (int i = start; i <= end; i++) {
//                    tablica[start][i] = ship;
//                }
//
//            } else if (length == endRow - startRow + 1 && start == end) {
//                for (int i = startRow; i <= endRow; i++) {
//                    tablica[i][startRow] = ship;
//                }
//            }
//            else {
//                System.out.println("Error! Wrong length! Try again: ");
//            }
//        } else {
//            System.out.println("Error! You placed it too close to another one. Try again:");
//        }
//        int startY = whatsFisrtNumber(first);
//        int startX = whatsSecondNumber(first);
//        int endY = whatsFisrtNumber(second);
//        int endX = whatsSecondNumber(second);
//        if(checkCoordinates(length,first,second)){
//            if (length == endX - startX + 1 && endY == startY) {
//                for (int i = startX; i <= endX; i++) {
//                    tablica[startX][i] = ship;
//                }
//            } else if (length == endY - startY + 1 && endX == startX) {
//                for (int i = startY; i <= endY; i++) {
//                    tablica[i][startY] = ship;
//                }
//            }else {
//                System.out.println("Error! Wrong length! Try again: ");
//            }
//        }
    }
}
