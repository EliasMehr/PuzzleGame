import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PuzzleGame extends JFrame implements ActionListener {
    private int width = 390;
    private int height = 220;

    Utilities music = new Utilities();

    JPanel menuPanel = new JPanel();

    JButton initiateGame = new JButton(new ImageIcon("src/GFX/MENU/start_btn.png"));
    JButton terminateGame = new JButton(new ImageIcon("src/GFX/MENU/end_btn.png"));

    PuzzleGame() {
        GridLayout menuLayout = new GridLayout(1, 2);

        add(menuPanel);

        menuPanel.setLayout(menuLayout);
        menuPanel.add(initiateGame);
        menuPanel.add(terminateGame);
        music.startBackgroundMusic("src/SFX/bgMusic.wav");

        initiateGame.addMouseListener(mouseEvent);
        terminateGame.addMouseListener(mouseEvent);

        initiateGame.addActionListener(e -> {
            music.startSoundOnTileClick("src/SFX/tileSound.wav");
            try {
                GameBoard initiateGameBoard = new GameBoard();
                setVisible(false);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }

        });

        terminateGame.addActionListener(e -> {
            music.startSoundOnTileClick("src/SFX/tileSound.wav");
            System.exit(0);
        });

        setTitle("15 Puzzle Game by Elias & Valle");
        setSize(width, height);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    MouseAdapter mouseEvent = new MouseAdapter() {
        @Override
        public void mouseEntered(MouseEvent e) {
            music.startSoundOnTileClick("src/SFX/rollover.wav");
        }
    };

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
