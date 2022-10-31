import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.plaf.basic.BasicBorders;
import java.awt.*;
import java.util.Arrays;

public class Game {

    // Global variables
    public int boardLength = 4;
    int[][] board = new int[boardLength][boardLength];

    // TODO GUI at the top

    public Game() {

        // GUI initiation
        JFrame gameFrame = new JFrame("15 Pussel");
        JPanel gameBoard = new JPanel();
        JPanel menu = new JPanel();
        JButton newGameButton = new JButton("Nytt spel");

        // GUI interface TODO ändra färger osv.
        Font buttonFont = new Font("Arial", Font.BOLD, 30); // TODO change to other?
        Font buttonFontSmall = new Font("Arial", Font.BOLD, 15); // TODO change to other?
        Color buttonBgColor = new Color(176,196,222); // TODO change to better color
        Color bgColor = Color.WHITE;
        Color lineBorderColor = Color.BLACK;
        EmptyBorder gameBorder = new EmptyBorder(5,5,5,5);
        LineBorder buttonBorder = new LineBorder(lineBorderColor, 3);

        // TODO fontsize etc.

        int tile = 1;
        int row;
        int col;

        // TODO add mouselisterner pushed

        for (row = 0; row < boardLength; row++) {
            for (col = 0; col < boardLength; col++) {
                if(tile == 16) { // sista rutan får värdet 0
                    break;
                } else {
                    JButton newTile = new JButton(String.valueOf(tile));
                    newTile.setFont(buttonFont);
                    newTile.setBackground(buttonBgColor);
                    gameBoard.add(newTile);
                    board[row][col] = tile;
                    tile++;
                }
            }
        }
        // GUI setup
        gameFrame.setLayout(new BorderLayout());
        gameFrame.add(gameBoard, BorderLayout.NORTH);
        gameFrame.add(menu, BorderLayout.SOUTH);
        gameFrame.setBackground(bgColor);

        gameBoard.setBackground(bgColor);
        gameBoard.setLayout(new GridLayout(boardLength, boardLength));
        gameBoard.setBorder(gameBorder);
        gameBoard.setPreferredSize(new Dimension(500, 450));

        menu.add(newGameButton);
        menu.setBackground(bgColor);
        menu.setPreferredSize(new Dimension(500, 50));

        newGameButton.setPreferredSize(new Dimension(150,30));
        newGameButton.setFont(buttonFontSmall);
        newGameButton.setBackground(Color.WHITE);
        newGameButton.setBorder(buttonBorder);

        // GUI Frame final
        gameFrame.setVisible(true);
        gameFrame.setLocationRelativeTo(null);
        gameFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        gameFrame.pack();

        System.out.println(Arrays.deepToString(board)); // test för att skriva ut 2d array
    }
}
