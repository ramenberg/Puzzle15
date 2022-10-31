import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;

public interface GameInterface {

    // TODO ändra färger osv.
    Color gameColorWhite = Color.WHITE;
    Color gameColorBlack = Color.BLACK;
    Font tileButtonFont = new Font("Arial", Font.BOLD, 30); // TODO change appearance?
    Color tileButtonBgColor = new Color(176,196,222); // TODO change to better color?
    Font newGameButtonFont = new Font("Arial", Font.BOLD, 15); // TODO change appearance?
    LineBorder newGameButtonBorder = new LineBorder(gameColorBlack, 3);
    EmptyBorder mainGameBorder = new EmptyBorder(5,5,5,5);
}
