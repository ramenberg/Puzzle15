import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Movement {

    //mouselistener som utför nedstående movement
    MouseAdapter mouseClick = new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            super.mouseClicked(e);
        }
    };

    public Movement(int position) {
        //Get the indexes where the block is, e.g. getPositions() and hold them on some vars, e.g. row, col
        boolean moved = false;

        if (row - 1 > 0 && board[row - 1][col] == 0) {  // Move block up
            board[row - 1][col] = position;
            moved = true;
        } else if (row + 1 < boardLength - 1 && board[row + 1][col] == 0) { // Move block down
            board[row + 1][col] = position;
            moved = true;
        } else if (col - 1 > 0 && board[row][col - 1] == 0) {  // Move block left
            board[row][col - 1] = position;
            moved = true;
        } else if (col + 1 < boardLength - 1 && board[row][col + 1] == 0) { // Move block right
            board[row][col + 1] = position;
            moved = true;
        }

        if moved
        board[row][col] = 0 // Delete the piece from old position
    }
}
