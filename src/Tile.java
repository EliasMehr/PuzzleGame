import javax.swing.*;

public class Tile {
    private JButton tiles;


    private int tileID;

    public Tile(JButton tiles, int tileId) {
        this.tiles = tiles;
        this.tileID = tileId;
    }

    public JButton getTiles() {
        return tiles;
    }

    public void setTiles(JButton tiles) {
        this.tiles = tiles;
    }

    public int getTileID() {
        return tileID;
    }

}
