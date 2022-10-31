import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class Game implements GameInterface {

    // Global variables
    public int boardLength = 4;
    int[][] board = new int[boardLength][boardLength];

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
}
