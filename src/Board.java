public class Board {
    private String tablica[][];
    public int numberOfShips = 0;

    class Error {
        private static final String COORDINATES = "Wrong coordinates";
    }

    public Board() {
        this.tablica = new String[11][11];
        for (int i = 1; i < tablica.length; i++) {
            for (int j = 1; j < tablica[i].length; j++) {
                tablica[i][j] = constValue.WATER;
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

    public void addShip(int length, Point first, Point second) {
        int startX = first.getX();
        int startY = first.getY();
        int endX = second.getX();
        int endY = second.getY();
        if (checkOtherShips(length, first, second)) {
            if (length == endX - startX + 1 && startY == endY) {
                for (int i = startX; i <= endX; i++) {
                    tablica[startY][i] = constValue.SHIP;
                }
                numberOfShips += length;
            } else if (length == endY - startY + 1 && startX == endX) {
                for (int i = startY; i <= endY; i++) {
                    tablica[i][startX] = constValue.SHIP;
                }
                numberOfShips += length;
            } else {
                System.out.println("Wrong cordinats! ");
            }
        } else {
            System.out.println("Wrong! The ship is too close to another ship ");
        }
    }

    public void play(Point point) {
        int pointX = point.getX();
        int pointY = point.getY();
        if(tablica[pointY][pointX]== constValue.SHIP){
            tablica[pointY][pointX]= constValue.HIT;
        }else if (tablica[pointY][pointX]== constValue.WATER){
            tablica[pointY][pointX]= constValue.MISS;
        }


    }

    private boolean checkOtherShips(int length, Point first, Point second) {
        int startX = first.getX();
        int startY = first.getY();
        int endX = second.getX();
        int endY = second.getY();
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
                    if (tablica[startY][i].equals(constValue.SHIP) || tablica[startY + 1][i].equals(constValue.SHIP)) {
                        result = false;
                    }
                }
            } else if (endY == 10) {
                for (int i = startX - 1; i <= endX + 1; i++) {
                    if (tablica[startY][i].equals(constValue.SHIP) || tablica[startY - 1][i].equals(constValue.SHIP)) {
                        result = false;
                    }
                }
            } else {
                for (int i = startX - 1; i <= endX + 1; i++) {
                    if (tablica[startY][i].equals(constValue.SHIP) || tablica[startY - 1][i].equals(constValue.SHIP) || tablica[startY + 1][i].equals(constValue.SHIP)) {
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
                    if (tablica[i][startX].equals(constValue.SHIP) || tablica[i][startX + 1].equals(constValue.SHIP)) {
                        result = false;
                    }
                }
            } else if (endX == 10) {
                for (int i = startY - 1; i <= endY + 1; i++) {
                    if (tablica[i][startX].equals(constValue.SHIP) || tablica[i][startX + 1].equals(constValue.SHIP)) {
                        result = false;
                    }
                }
            } else {
                for (int i = startY - 1; i <= endY + 1; i++) {
                    if (tablica[i][startX].equals(constValue.SHIP) || tablica[i][startX + 1].equals(constValue.SHIP) || tablica[i][startX - 1].equals(constValue.SHIP)) {
                        result = false;
                    }
                }
            }
        }
        return result;
    }


    public void view() {
        for (int i = 0; i < tablica.length; i++) {
            for (int j = 0; j < tablica[i].length; j++) {
                System.out.print(tablica[i][j] + " ");
            }
            System.out.println();
        }
    }
}
