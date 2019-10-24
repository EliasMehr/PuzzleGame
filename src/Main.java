import javax.swing.*;
import java.awt.*;

public class Main extends JFrame {
    JPanel panelOfBricks = new JPanel();
    JButton brick01 = new JButton(new ImageIcon("src/GFX/brick01.png"));
    JButton brick02 = new JButton(new ImageIcon("src/GFX/brick02.png"));
    JButton brick03 = new JButton(new ImageIcon("src/GFX/brick03.png"));
    JButton brick04 = new JButton(new ImageIcon("src/GFX/brick04.png"));
    JButton brick05 = new JButton(new ImageIcon("src/GFX/brick05.png"));
    JButton brick06 = new JButton(new ImageIcon("src/GFX/brick06.png"));
    JButton brick07 = new JButton(new ImageIcon("src/GFX/brick07.png"));
    JButton brick08 = new JButton(new ImageIcon("src/GFX/brick08.png"));
    JButton brick09 = new JButton(new ImageIcon("src/GFX/brick09.png"));
    JButton brick10 = new JButton(new ImageIcon("src/GFX/brick10.png"));
    JButton brick11 = new JButton(new ImageIcon("src/GFX/brick11.png"));
    JButton brick12 = new JButton(new ImageIcon("src/GFX/brick12.png"));
    JButton brick13 = new JButton(new ImageIcon("src/GFX/brick13.png"));
    JButton brick14 = new JButton(new ImageIcon("src/GFX/brick14.png"));
    JButton brick15 = new JButton(new ImageIcon("src/GFX/brick15.png"));
    JButton emptyBrick = new JButton(new ImageIcon("src/GFX/emptyBrick.png"));


    Main() {

        add(panelOfBricks);

        panelOfBricks.setLayout(new GridLayout(4, 4));
        panelOfBricks.add(brick01);
        panelOfBricks.add(brick02);
        panelOfBricks.add(brick03);
        panelOfBricks.add(brick04);
        panelOfBricks.add(brick05);
        panelOfBricks.add(brick06);
        panelOfBricks.add(brick07);
        panelOfBricks.add(brick08);
        panelOfBricks.add(brick09);
        panelOfBricks.add(brick10);
        panelOfBricks.add(brick11);
        panelOfBricks.add(brick12);
        panelOfBricks.add(brick13);
        panelOfBricks.add(brick14);
        panelOfBricks.add(brick15);
        panelOfBricks.add(emptyBrick);
        emptyBrick.setBorderPainted(false);

        setSize(600, 600);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);


    }

    public static void main(String[] args) {
        Main runApplication = new Main();


    }
}
