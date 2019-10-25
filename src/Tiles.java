import javax.swing.*;

public class Tiles {
    private JButton tiles;
    private ImageIcon icon;

    public Tiles() {}

    public Tiles(JButton tiles, ImageIcon icon) {
        this.tiles = tiles;
        this.icon = icon;
    }

    public JButton getTiles() {
        return tiles;
    }

    public void setTiles(JButton tiles) {
        this.tiles = tiles;
    }

    public ImageIcon getIcon() {
        return icon;
    }

    public void setIcon(ImageIcon icon) {
        this.icon = icon;
    }
}
