import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class Game extends JFrame implements GameInterface{

    // Global variables
    public int boardLength = 4;
    int[][] board = new int[boardLength][boardLength];

      // GUI global initiation
    JFrame gameFrame = new JFrame("15 Pussel");
    JPanel gameBoard = new JPanel(); // panel for all tiles
    JPanel menuPanel = new JPanel(); // panel for new game button
    JButton newGameButton = new JButton("Nytt spel");
    public Game() {

        // calls action listener method
        ButtonListener tileClicked = new ButtonListener();

        int tile = 1;
        int row;
        int col;

        Random random = new Random();
//
//        boolean[] usedNum = new boolean[16];
//        for (int i = 0; i < board.length; i++) {
//            for (int j = 0; j < board[i].length; j++) {
//                int num = random.nextInt(16);
//                while(usedNum[num]) {
//                    num = random.nextInt(16);
//                }
//                usedNum[num] = true;
//                if (num != 0) {
//                    JButton newTile = new JButton(String.valueOf(tile));
//                    board[i][j] = tile;
//                    newTile.setFont(tileButtonFont);
//                    newTile.setBackground(tileButtonBgColor);
//                    newTile.addActionListener(tileClicked);
//                    gameBoard.add(newTile);
//                } else {
//                    JButton newTile = new JButton(String.valueOf(tile));
//                    row = i;
//                    col = j;
//
//
//
//                }
//            }
//        }
        System.out.println(Arrays.deepToString(board));

        for (row = 0; row < boardLength; row++) {
            for (col = 0; col < boardLength; col++) {
                if (tile == 16) { // sista rutan får värdet 0
                    break;
                } else {
                    JButton newTile = new JButton(String.valueOf(tile));
                    board[row][col] = tile;
//                    Shuffle(board);
                    newTile.setFont(tileButtonFont);
                    newTile.setBackground(tileButtonBgColor);
                    newTile.addActionListener(tileClicked);
                    gameBoard.add(newTile);
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

        // Movement
    class ButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }

    // Shuffle
//    public void shuffleTiles() {
//        if(tiles != null){
//            Collections.shuffle(Arrays.asList(tiles));
//            layoutTiles();
//        }
//    }
    public void Shuffle(int[][] list) {
        Random random = new Random();

        for (int i = list.length - 1; i > 0; i--) {
            for (int j = list[i].length - 1; j > 0; j--) {
                int m = random.nextInt(i + 1);
                int n = random.nextInt(j + 1);

                int temp = list[i][j];
                list[i][j] = list[m][n];
                list[m][n] = temp;
            }
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
