import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class Game extends JFrame implements GameInterface {

    // Global variables
    public int boardLength = 4;
    int[][] board = new int[boardLength][boardLength];

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
        gameBoard.setLayout(new GridLayout(boardLength, boardLength));
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

        int[] list = new int[16];
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
    public void newBoard() {
        int row;
        int col;
        int tile;

        int[] list = ShuffledList();
        gameBoard.removeAll();
        gameBoard.revalidate();
        gameBoard.repaint();

        for (row = 0; row < boardLength; row++) {
            for (col = 0; col < boardLength; col++) {
                board[row][col] = list[(col * boardLength) + row];


                if (board[row][col] != 17) {


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
        }
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
        }



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
    }
