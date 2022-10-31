import java.util.Arrays;

public class Game {

    // TODO global variables

    public int boardLength = 4;
    int[][] board = new int[boardLength][boardLength];
    int tile = 0;
    public int row;
    public int col;

    // TODO GUI at the top

    public Game() {

    // TODO board: fixa att inte nr 16 skrivs ut

        for (row = 0; row < boardLength; row++) {
            for (col = 0; col < boardLength; col++) {
                    board[row][col] = tile;
                    tile++;
            }
        }
        System.out.println(Arrays.deepToString(board)); // test för att skriva ut 2d array
    }
}
