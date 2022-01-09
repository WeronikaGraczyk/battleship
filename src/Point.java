public class Point {
    private final int x;
    private final int y;

    public Point(String point) {
        this.x = whatsSecondNumber(point);
        this.y = whatsFirstNumber(point);
    }

    private int whatsFirstNumber(String place) {
        return (place.charAt(0) - 64) - 1;
    }

    private int whatsSecondNumber(String place) {
        String j = place.substring(1);
        return (Integer.parseInt(j)) - 1;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
