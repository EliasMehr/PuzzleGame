import javax.sound.sampled.*;
import javax.swing.*;
import java.io.File;

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

}
