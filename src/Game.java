import java.util.Scanner;

public class Game {
    Board board;

    public Game() {
        this.board = new Board();
        playGame();
    }

    public void playGame() {
        Scanner scanner1 = new Scanner(System.in);
        Scanner scanner2 = new Scanner(System.in);
        int shipsLength = 5;
        board.view();
        while (shipsLength >= 2) {
            System.out.println("Długość statku " + shipsLength);
            System.out.println("Podaj pierwsze kordynaty: ");
            Point p1 = new Point(scanner1.nextLine());
            System.out.println("Podaj drugie kordynaty: ");
            Point p2 = new Point(scanner2.nextLine());
            if (board.addShip(shipsLength, p1, p2)) {
                shipsLength--;
            }
            board.view();
        }
        while (board.getNumberOfShips() > 0) {
            System.out.println("Podaj kordynaty statku: ");
            Point point = new Point(scanner1.nextLine());
            board.play(point);
            board.view();
        }
        System.out.println("congratulations, you win");
    }
}
