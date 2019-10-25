import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GameBoard extends JFrame {
    Utilities utilities = new Utilities();

    ImageIcon logoType = new ImageIcon("src/LOGOTYPE/logotype.png");
    JLabel logotypeLabel= new JLabel(logoType);
    JPanel logotypePanel = new JPanel();
    JPanel tilePanel = new JPanel();

    private List<Tiles> tilesList = new ArrayList<>();
    private int tileID = 1;
    private int width = 600;
    private int height = 600;

    GameBoard() {
        GridLayout brickGridLayout = new GridLayout(4, 4);
        brickGridLayout.setHgap(0);
        brickGridLayout.setVgap(0);

        FlowLayout logoLayout = new FlowLayout();
        logoLayout.setHgap(0);
        logoLayout.setVgap(0);

        add(logotypePanel, BorderLayout.NORTH);
        add(tilePanel, BorderLayout.CENTER);

        logotypePanel.add(logotypeLabel);
        logotypePanel.setLayout(logoLayout);
        tilePanel.setLayout(brickGridLayout);

        for (int i = 0; i < 16 ; i++) {
            Tiles createTiles = new Tiles();
            createTiles.setTiles(new JButton(new ImageIcon("src/GFX/brick" + tileID + ".png")));
            tileID++;
            tilePanel.add(createTiles.getTiles());
            tilesList.add(createTiles);
        }
        utilities.startBackgroundMusic("src/SFX/bgMusic.wav");

        setTitle("15 Puzzle Game by Elias & Valle");
        setSize(width, height);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
