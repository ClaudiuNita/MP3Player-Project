import GUI.MusicBoard;

import javax.swing.*;

public class Music_Player{
    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {

                MusicBoard musicBoard = new MusicBoard();
            }
        });

    }
}
