import java.util.Collections;

public class Shuffle {
public void shuffleTiles() {
    if(tiles != null){
        Collections.shuffle(Arrays.asList(tiles));
        layoutTiles();
    }
}
}
