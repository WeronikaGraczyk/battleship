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
        int shipsLength = 3;
        board.view();
        while (shipsLength >= 2) {
            System.out.println("Ship length " + shipsLength);
            System.out.println("enter the first coordinates: ");
            Point p1 = new Point(scanner1.nextLine());
            System.out.println("enter the second coordinates: ");
            Point p2 = new Point(scanner2.nextLine());
            if (board.addShip(shipsLength, p1, p2)) {
                shipsLength--;
            }
            board.view();
        }
        System.out.println("Start game ");
        OpponentBoard opponentBoard = new OpponentBoard(board.numberOfShips);
        System.out.println("Opponent board");
        opponentBoard.view();
        while (board.getNumberOfShips() > 0 || opponentBoard.numberOfShips > 0) {
            System.out.println("enter coordinates on your board: ");
            Point point = new Point(scanner1.nextLine());
            board.play(point);
            System.out.println("Your board");
            board.view();
            if (board.numberOfShips == 0) {
                System.out.println("You lost!");
                break;
            }
            System.out.println("enter coordinates to opponent board: ");
            Point opponentPoint = new Point(scanner1.nextLine());
            System.out.println("""
                    Choose the option:\s
                    1. Hit\s
                    2.Miss""");
            int number = scanner2.nextInt();
            while (!opponentBoard.update(opponentPoint, number)) {
                System.out.println("""
                        Choose the option:\s
                        1. Hit\s
                        2.Miss""");
                number = scanner2.nextInt();
            }
            System.out.println("Opponent board");
            opponentBoard.view();
            if (opponentBoard.numberOfShips == 0) {
                System.out.println("You win!");
                break;
            }
        }
    }
}
