package PlayList;

import javazoom.jl.player.Player;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;

public class PlayerControl {

    private String musicPath;

    private File myFile = null;
    private FileInputStream fileInputStream;
    private BufferedInputStream bufferedInputStream;
    private Player player;

    private Thread playerThread;

    public PlayerControl() {

        playerThread = new Thread(runnablePlayer);
    }

    public void stopPlayer() {
        if (playerThread.isAlive()) {
            player.close();
            this.musicPath = "";
            playerThread = new Thread(runnablePlayer);
        }
    }

    public void playSong(String musicPath) {

        this.musicPath = musicPath;

        if (playerThread.isAlive()){
            player.close();
            playerThread = new Thread(runnablePlayer);
            playerThread.start();
        } else {
            playerThread.start();
        }
    }

    private Runnable runnablePlayer = new Runnable() {
            @Override
            public void run() {
                try {
                    myFile = new File(musicPath);
                    fileInputStream = new FileInputStream(myFile);
                    bufferedInputStream = new BufferedInputStream(fileInputStream);
                    player = new Player(bufferedInputStream);
                    player.play();
                } catch (Exception e) {}
            }
    };
}
