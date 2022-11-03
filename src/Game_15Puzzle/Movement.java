package Game_15Puzzle;

import javax.swing.*;

public class Movement extends Game {
    public static void Moves(int x, int y) {

        boolean moved = false;
        int row = y / (gameBoardWidth/4);
        int col = x / (gameBoardHeight/4);
        int position = board[row][col];

        if (row > 0 && board[row - 1][col] == 0) {  // Move UP
            board[row - 1][col] = position;
            moved = true;
        } else if (row < boardSize - 1 && board[row + 1][col] == 0) { // Move DOWN
            board[row + 1][col] = position;
            moved = true;
        } else if (col > 0 && board[row][col - 1] == 0) {  // Move LEFT
            board[row][col - 1] = position;
            moved = true;
        } else if (col < boardSize - 1 && board[row][col + 1] == 0) { // Move RIGHT
            board[row][col + 1] = position;
            moved = true;
        }
        if (moved)
            board[row][col] = 0; // Delete from old position

        renderBoard();
        if (Game.gameWon(board)) {
            JOptionPane.showMessageDialog(null, "Du har vunnit!\nTryck Ok för att spela igen");
            newBoard();
        }
    }

}
