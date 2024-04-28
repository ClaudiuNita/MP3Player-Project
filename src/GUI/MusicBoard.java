package GUI;

import PlayList.PlayList;

import javax.swing.*;
import java.awt.*;

public class MusicBoard extends JFrame {

    private MusicPanel musicPanel;
    private ControlPanel controlPanel;
    private SelectPanel selectPanel;
    private PlayList playList;

    public MusicBoard() {

        playList = new PlayList();
        musicPanel = new MusicPanel(playList);
        selectPanel = new SelectPanel(musicPanel, playList);
        controlPanel = new ControlPanel(musicPanel, playList);

        add(musicPanel, BorderLayout.NORTH);
        add(selectPanel);
        add(controlPanel, BorderLayout.SOUTH);

        setTitle("Music Player");
        setSize(450, 440);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
