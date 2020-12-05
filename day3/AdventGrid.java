public class AdventGrid<E> {
    private E[][] grid;
    private int width;
    private int height;

    public AdventGrid(E[][] grid) {
        this.grid = grid;
        height = grid.length;
        width = grid[0].length;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public void set(int x, int y, E data) {
        grid[y][x] = data;
    }

    public E get(int x, int y) {
        if (x > width || x < 0 || y > height - 1 || y < 0)
            return null;

        return grid[y][x];
    }

    public void printGrid() {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                System.out.print(grid[i][j]);
            }
            System.out.println();
        }
    }
}
