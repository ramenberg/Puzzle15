import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;
import java.util.Collections;

public class Game implements GameInterface {

    // Global variables
    public int boardLength = 4;
    int[][] board = new int[boardLength][boardLength];

    // Movement
    //mouselistener som utför nedstående movement
    MouseAdapter mouseClick = new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            super.mouseClicked(e);
        }
    };

    public Game() {

        // GUI initiation
        JFrame gameFrame = new JFrame("15 Pussel");
        JPanel gameBoard = new JPanel(); // panel for all tiles
        JPanel menuPanel = new JPanel(); // panel for new game button
        JButton newGameButton = new JButton("Nytt spel");

        int tile = 1;
        int row;
        int col;

        // TODO add mouse listener pushed reference

        for (row = 0; row < boardLength; row++) {
            for (col = 0; col < boardLength; col++) {
                if(tile == 16) { // sista rutan får värdet 0
                    break;
                } else {
                    JButton newTile = new JButton(String.valueOf(tile));
                    newTile.setFont(tileButtonFont);
                    newTile.setBackground(tileButtonBgColor);
                    gameBoard.add(newTile);
                    board[row][col] = tile;
                    tile++;
                }
            }
        }
        // GUI setup
        gameFrame.setLayout(new BorderLayout());
        gameFrame.add(gameBoard, BorderLayout.NORTH);
        gameFrame.add(menuPanel, BorderLayout.SOUTH);
        gameFrame.setBackground(gameColorWhite);

        gameBoard.setBackground(gameColorWhite);
        gameBoard.setLayout(new GridLayout(boardLength, boardLength));
        gameBoard.setBorder(mainGameBorder);
        gameBoard.setPreferredSize(new Dimension(500, 450));

        menuPanel.add(newGameButton);
        menuPanel.setBackground(gameColorWhite);
        menuPanel.setPreferredSize(new Dimension(500, 50));

        newGameButton.setPreferredSize(new Dimension(150,30));
        newGameButton.setFont(newGameButtonFont);
        newGameButton.setBackground(gameColorWhite);
        newGameButton.setBorder(newGameButtonBorder);

        // GUI Frame
        gameFrame.setVisible(true);
        gameFrame.setLocationRelativeTo(null);
        gameFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        gameFrame.pack();

        // test för att skriva ut 2d array - TODO ta bort innan FINAL
        System.out.println(Arrays.deepToString(board));
    }

    // Shuffle
    public void shuffleTiles() {
        if(tiles != null){
            Collections.shuffle(Arrays.asList(tiles));
            layoutTiles();
        }
    }

    // Movement
    public void Movement(int position) {
        //Get the indexes where the block is, e.g. getPositions() and hold them on some vars, e.g. row, col
        boolean moved = false;

//        if (row - 1 > 0 && board[row - 1][col] == 0) {  // Move block up
//            board[row - 1][col] = position;
//            moved = true;
//        } else if (row + 1 < boardLength - 1 && board[row + 1][col] == 0) { // Move block down
//            board[row + 1][col] = position;
//            moved = true;
//        } else if (col - 1 > 0 && board[row][col - 1] == 0) {  // Move block left
//            board[row][col - 1] = position;
//            moved = true;
//        } else if (col + 1 < boardLength - 1 && board[row][col + 1] == 0) { // Move block right
//            board[row][col + 1] = position;
//            moved = true;
//        }
//
//        if (moved = true)
//            board[row][col] = 0; // Delete the piece from old position
    }
}
