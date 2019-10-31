import javax.sound.sampled.*;
import javax.swing.*;
import java.io.File;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class Utilities extends Thread {

    private long timerSeconds;
    private long timerMinutes;
    private java.util.Timer timer;

    public void setTimerSeconds(long timerSeconds) {
        this.timerSeconds = timerSeconds;
    }

    public void setTimerMinutes(long timerMinutes) {
        this.timerMinutes = timerMinutes;
    }


    // Initiates background game music.
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

    // Initiates onHoverMouse sound SFX.
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


    // Game timer that updates the time every second by using TimerTask.
    public void initiateGameTimer(JLabel timeInput) {
        TimerTask timerTask = new TimerTask() {

            @Override
            public void run() {
                String secondZero = "";
                if (timerSeconds < 59) {
                    timerSeconds++;
                    if (timerSeconds < 10)
                        secondZero = "0";
                } else {
                    secondZero = "";
                    timerSeconds = 0;
                    timerMinutes++;
                }
                timeInput.setText("Tid: " + timerMinutes + ':' + secondZero + timerSeconds);
            }
        };
        this.timer = new Timer();
        this.timer.schedule(timerTask, new Date(), 1000);

    }

    // Removes the timer. (DOES NOT PAUSE)
    public void stopGameTimer() {
//        this.timer.cancel();

        getTimer().cancel();


    }

    public Timer getTimer() {
        return timer;
    }
}

