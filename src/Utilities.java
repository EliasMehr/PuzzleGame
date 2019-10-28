import javax.sound.sampled.*;
import javax.swing.*;
import java.io.File;
import java.util.concurrent.TimeUnit;

public class Utilities {

    public void startBackgroundMusic(String musicPath) {
        try {
            File music = new File(musicPath);

            if (music.exists()) {
                AudioInputStream readMusic = AudioSystem.getAudioInputStream(music);
                Clip runSound = AudioSystem.getClip();
                runSound.open(readMusic);
                runSound.start();
                runSound.loop(Clip.LOOP_CONTINUOUSLY);

            } else {
                JOptionPane.showMessageDialog(null, "Can't find background music file");
            }
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void startSoundOnTileClick(String musicPath) {
        try {
            File music = new File(musicPath);

            if (music.exists()) {
                AudioInputStream readMusic = AudioSystem.getAudioInputStream(music);
                Clip runSound = AudioSystem.getClip();
                runSound.open(readMusic);
                runSound.start();
            } else {
                JOptionPane.showMessageDialog(null, "Can't find background music file");
            }
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void initiateGameTimer() throws InterruptedException {
        boolean x = true;
        long displayMinutes = 0;
        long starttime = System.currentTimeMillis();
        while (x) {
            TimeUnit.SECONDS.sleep(1);
            long timepassed = System.currentTimeMillis() - starttime;
            long secondspassed = timepassed / 1000;
            if (secondspassed == 60) {
                secondspassed = 0;
                starttime = System.currentTimeMillis();
            }
            if ((secondspassed % 60) == 0)
                displayMinutes++;

            System.out.println(displayMinutes + "::" + secondspassed);
        }

    }
}

