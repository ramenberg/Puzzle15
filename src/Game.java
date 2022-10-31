import java.util.Arrays;

public class Game {

    // TODO global variables
    int[][] board = new int[4][4];
    int tile = 0;

    // TODO GUI at the top

    public Game() {

    // TODO board: fixa att inte nr 16 skrivs ut

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                    board[i][j] = tile;
                    tile++;
            }
        }
        System.out.println(Arrays.deepToString(board)); // test för att skriva ut 2d array
    }
}
