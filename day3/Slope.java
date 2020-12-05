public class Slope {
    private AdventGrid<Character> grid;

    public Slope(AdventGrid<Character> grid) {
        this.grid = grid;
    }

    public void set(int x, int y, Character c) {
        grid.set(x, y, c);
    }

    public char get(int x, int y) {
        x = x % (grid.getWidth());
        return (grid.get(x, y) == null) ? 'N' : grid.get(x, y);
    }

    public void printGrid() {
        grid.printGrid();
    }
}
