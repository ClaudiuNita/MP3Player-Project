package GUI;

import PlayList.PlayList;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControlPanel extends JPanel implements ActionListener {

    private Icon iconForward, iconBackward, iconRepeat, iconStop;
    private JButton forwardButton, backwardButton, repeatButton, stopButton;
    private PlayList playList;
    private MusicPanel musicPanel;

    public ControlPanel(MusicPanel musicPanel, PlayList playList) {

        this.playList = playList;
        this.musicPanel = musicPanel;

        initializeUI();
        addActionListener();
    }

    public void initializeUI() {

        setPreferredSize(new Dimension(450, 50));

        iconForward = new ImageIcon("D:\\Programare\\Java\\.PROJECTS\\Music_Player\\icons\\forward.png");
        iconBackward = new ImageIcon("D:\\Programare\\Java\\.PROJECTS\\Music_Player\\icons\\back.png");
        iconRepeat = new ImageIcon("D:\\Programare\\Java\\.PROJECTS\\Music_Player\\icons\\repeat.png");
        iconStop = new ImageIcon("D:\\Programare\\Java\\.PROJECTS\\Music_Player\\icons\\stop.png");

        forwardButton = new JButton(iconForward);
        backwardButton = new JButton(iconBackward);
        repeatButton = new JButton(iconRepeat);
        stopButton = new JButton(iconStop);

        setLayout(new GridLayout(1, 4));
        add(backwardButton);
        add(repeatButton);
        add(stopButton);
        add(forwardButton);

        backwardButton.setBackground(Color.WHITE);
        repeatButton.setBackground(Color.WHITE);
        forwardButton.setBackground(Color.WHITE);
        stopButton.setBackground(Color.WHITE);
    }

    public void addActionListener() {

        backwardButton.addActionListener(this);
        forwardButton.addActionListener(this);
        repeatButton.addActionListener(this);
        stopButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource().equals(backwardButton)) {

            playList.goingBackwards();
            musicPanel.setCurrentSong(playList.getCurrentSong());
        }
        if (e.getSource().equals(forwardButton)) {

            playList.goingForwards();
            musicPanel.setCurrentSong(playList.getCurrentSong());

        }
        if (e.getSource().equals(stopButton)) {

            playList.stopMusic();
        }
        if (e.getSource().equals(repeatButton)) {

            playList.repeat();
            musicPanel.setCurrentSong(playList.getCurrentSong());
        }

        musicPanel.revalidate();
        musicPanel.repaint();
    }
}
