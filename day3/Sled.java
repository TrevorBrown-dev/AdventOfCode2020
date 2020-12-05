public class Sled {
    private int x;
    private int y;

    public Sled(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Sled() {
        this(0, 0);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void moveRelative(int dx, int dy) {
        x += dx;
        x = x % 31;
        y += dy;
    }

}
