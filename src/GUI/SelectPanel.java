package GUI;

import PlayList.PlayList;
import PlayList.Song;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class SelectPanel extends JPanel implements ActionListener {

    private JFileChooser fileChooser;
    private JButton selectButton;
    private PlayList playList;
    private MusicPanel musicPanel;

    public SelectPanel(MusicPanel musicPanel, PlayList playList) {

        this.musicPanel = musicPanel;
        this.playList = playList;

        setLayout(new GridLayout());

        selectButton = new JButton("Select");
        add(selectButton);
        selectButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File("C:\\Users"));
        fileChooser.setDialogTitle("Select Mp3");
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fileChooser.setFileFilter(new FileNameExtensionFilter("Mp3 files", "mp3"));

        if (fileChooser.showOpenDialog(selectButton) == JFileChooser.APPROVE_OPTION) {

            File newFile = fileChooser.getSelectedFile();
            Song newSong = new Song(newFile.getPath(), newFile.getName().replaceAll(".mp3", ""), String.valueOf(newFile.length()));

            playList.addSongToPlaylist(newSong);
            musicPanel.addSongLabels(newSong.getTitle(), newSong.getDuration());
            musicPanel.revalidate();
            musicPanel.repaint();
        }
    }
}
