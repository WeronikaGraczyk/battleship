public class Point {
    private int x;
    private int y;

    public Point(String point) {
        this.x = whatsSecondNumber(point);
        this.y = whatsFirstNumber(point);
    }

    private int whatsFirstNumber(String place) {
        return place.charAt(0) - 64;
    }

    private int whatsSecondNumber(String place) {
        String j = place.substring(1);
        return Integer.parseInt(j);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
