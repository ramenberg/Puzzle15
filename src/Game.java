import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Random;

public class Game extends JFrame implements GameInterface {

    // Demo code variable
    public boolean isTest = true;

    // Global variables
    public int boardSize = 4;
    public int boardDimension = boardSize * boardSize;
    int[][] board = new int[boardSize][boardSize];

    // GUI global initiation
    JFrame gameFrame = new JFrame("15 Pussel");
    JPanel gameBoard = new JPanel(); // panel for all tiles
    JPanel menuPanel = new JPanel(); // panel for new game button
    JButton newGameButton = new JButton("Nytt spel");
    ButtonListener buttonClicked = new ButtonListener();

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

        // test för att skriva ut 2d array - TODO ta bort innan FINAL
        System.out.println(Arrays.deepToString(board));
    }

    // Shuffle
    public int[] ShuffledList() {
        Random rand = new Random();

        int[] list = new int[boardDimension];
        Arrays.setAll(list, i -> i);

        for (int i = 0; i < list.length; i++) {
            int randomIndexToSwap = rand.nextInt(list.length);
            int temp = list[randomIndexToSwap];
            list[randomIndexToSwap] = list[i];
            list[i] = temp;
        }
        System.out.println(Arrays.toString(list));
        return list;
    }

    // New render board
    public void renderBoard() {
        int row;
        int col;
        int tile;
        gameBoard.removeAll();
        gameBoard.revalidate();
        gameBoard.repaint();

        for (row = 0; row < boardSize; row++) {
//            System.out.println(row);
            for (col = 0; col < boardSize; col++) {
//                System.out.println(col);
                if (board[row][col] != (boardDimension +1)) {
                    tile = board[row][col];
                    JButton newTile = new JButton(String.valueOf(tile));
                    newTile.setFont(tileButtonFont);
                    newTile.setBackground(tileButtonBgColor);
                    newTile.addActionListener(buttonClicked);
                    // så att 0-tilen inte syns men fortfarande räknas som där för updates
                    if(board[row][col] == 0){
                        newTile.setVisible(false);
                    }
                    gameBoard.add(newTile);
                }
            }
        } System.out.println(Arrays.deepToString(board));
    }
    public void newBoard() {
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

        // för att testa vad som funkar
        /*for (row = 0; row < boardLength; row++) {
            for (col = 0; col < boardLength; col++) {
                System.out.print(board[row][col]);
                }
            System.out.print("\n");
            }*/
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
                    Movement(clickedButton.getX(),clickedButton.getY());
                }
            }
        }

//            public void Shuffle(int[][] list) { TODO obsolet - ta bort
//                Random random = new Random();
//
//                for (int i = list.length - 1; i > 0; i--) {
//                    for (int j = list[i].length - 1; j > 0; j--) {
//                        int m = random.nextInt(i + 1);
//                        int n = random.nextInt(j + 1);
//
//                        int temp = list[i][j];
//                        list[i][j] = list[m][n];
//                        list[m][n] = temp;
//                    }
//                }
//            }

    // Movement
    public void Movement(int x,int y) {

        boolean moved = false;
        int row = y/110;
        int col = x/122;
        int position = board[row][col];
        System.out.println((row) + " " + (col)); // TODO ta bort innan final

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
        if (gameWon(board)) {
            JOptionPane.showMessageDialog(null, "Du har vunnit!\nTryck Ok för att spela igen");
            newBoard();
            }
        }
    }
    public boolean gameWon(int[][] board) {
        int[][] winArray = new int[][]{
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12},
                {13,14,15,0}
        };
        return Arrays.deepEquals(board, winArray);
    }
}
