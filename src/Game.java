import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Random;

public class Game extends JFrame implements GameInterface {

    // Demo code variable
    public static boolean isTest = false;

    // Global variables
    public static int boardSize = 4;
    public static int boardDimension = boardSize * boardSize;
    static int[][] board = new int[boardSize][boardSize];

    // GUI global initiation
    JFrame gameFrame = new JFrame("15 Pussel");
    static JPanel gameBoard = new JPanel(); // panel for all tiles
    JPanel menuPanel = new JPanel(); // panel for new game button
    JButton newGameButton = new JButton("Nytt spel");
    static ButtonListener buttonClicked;

    {
        buttonClicked = new ButtonListener();
    }

    public void GUI() {
        // GUI setup
        gameFrame.setLayout(new BorderLayout());
        gameFrame.add(gameBoard, BorderLayout.NORTH);
        gameFrame.add(menuPanel, BorderLayout.SOUTH);
        gameFrame.setBackground(gameColorWhite);

        gameBoard.setBackground(gameColorWhite);
        gameBoard.setLayout(new GridLayout(boardSize, boardSize));
        gameBoard.setBorder(mainGameBorder);
        gameBoard.setPreferredSize(new Dimension(500, 450));

        menuPanel.add(newGameButton);
        menuPanel.setBackground(gameColorWhite);
        menuPanel.setPreferredSize(new Dimension(500, 50));

        newGameButton.setPreferredSize(new Dimension(150, 30));
        newGameButton.setFont(newGameButtonFont);
        newGameButton.setBackground(gameColorWhite);
        newGameButton.setBorder(newGameButtonBorder);
        newGameButton.addActionListener(buttonClicked);

        // GUI Frame
        gameFrame.setVisible(true);
        gameFrame.setLocationRelativeTo(null);
        gameFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        gameFrame.pack();
        gameFrame.repaint();
    }
    public Game() {

        newBoard();
        GUI();

    }

    // Shuffle
    public static int[] ShuffledList() {
        Random rand = new Random();

        int[] list = new int[boardDimension];
        Arrays.setAll(list, i -> i);

        for (int i = 0; i < list.length; i++) {
            int randomIndexToSwap = rand.nextInt(list.length);
            int temp = list[randomIndexToSwap];
            list[randomIndexToSwap] = list[i];
            list[i] = temp;
        }
        return list;
    }

    // New render board
    public static void renderBoard() {
        int row;
        int col;
        int tile;
        gameBoard.removeAll();
        gameBoard.revalidate();
        gameBoard.repaint();

        for (row = 0; row < boardSize; row++) {
            for (col = 0; col < boardSize; col++) {
                if (board[row][col] != (boardDimension +1)) {
                    tile = board[row][col];
                    JButton newTile = new JButton(String.valueOf(tile));
                    newTile.setFont(tileButtonFont);
                    newTile.setBackground(tileButtonBgColor);
                    newTile.addActionListener(buttonClicked);
                    // så att 0-tile inte syns men fortfarande räknas som där för updates
                    if(board[row][col] == 0){
                        newTile.setVisible(false);
                    }
                    gameBoard.add(newTile);
                }
            }
        }
    }

    public static void newBoard() {
        int row;
        int col;
        int[] list;

        if (isTest) {
            list = DemoCode.TestList();
        } else {
            list = ShuffledList();
        }
        for (row = 0; row < boardSize; row++) {
            for (col = 0; col < boardSize; col++) {
                board[row][col] = list[(col * boardSize) + row];
            }
        }
        renderBoard();
        }


    // Movement
    class ButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == newGameButton) {
                newBoard();
            }
            else{
                JButton clickedButton = (JButton) e.getSource();
                if (clickedButton != null){
                    Movement.Moves(clickedButton.getX(),clickedButton.getY());
                }
            }
        }

    }
    // Win game
    public static boolean gameWon(int[][] board) {
        int[][] winArray = new int[][]{
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12},
                {13,14,15,0}
        };
        return Arrays.deepEquals(board, winArray);
    }
}
