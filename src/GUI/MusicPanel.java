package GUI;

import PlayList.PlayList;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class MusicPanel extends JPanel {

    private PlayList playList;
    private JLabel currentSongLabel, songLabel, durationLabel;
    private List<JLabel> songName, currentSong, duration;
    private Font font;
    private Icon currentSongIcon;
    private GridBagConstraints gbc;
    private Border border;

    public MusicPanel(PlayList playList) {

        this.playList = playList;

        initializeUI();
        addSongLabels();
    }

    public void initializeUI() {

        setLayout(new GridBagLayout());
        setPreferredSize(new Dimension(450, 300));
        gbc = new GridBagConstraints();
        border = BorderFactory.createLineBorder(Color.BLACK);
        font = new Font("Courier", Font.BOLD,16);
        setBorder(border);

        currentSongIcon = new ImageIcon("D:\\Programare\\Java\\.PROJECTS\\Music_Player\\icons\\tri.png");

        currentSongLabel = new JLabel("C ");
        currentSongLabel.setFont(font);
        currentSongLabel.setBorder(border);

        songLabel = new JLabel(" Song");
        songLabel.setFont(font);
        songLabel.setBorder(border);

        durationLabel = new JLabel(" Duration");
        durationLabel.setFont(font);
        durationLabel.setBorder(border);

        gbc.anchor = GridBagConstraints.NORTH;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(currentSongLabel, gbc);

        gbc.gridx = 1;
        add(songLabel, gbc);

        gbc.gridx = 2;
        add(durationLabel, gbc);

    }

    public void addSongLabels() {

        songName = new ArrayList<JLabel>();
        currentSong = new ArrayList<JLabel>();
        duration = new ArrayList<JLabel>();

        for (int i = 0; i < playList.getListSize(); i++) {

            songName.add(new JLabel(i + 1 + ". " + playList.getSong(i).getTitle()));
            currentSong.add(new JLabel());
            duration.add(new JLabel(playList.getSong(i).getDuration(), SwingConstants.CENTER));

            gbc.gridx = 0;
            gbc.gridy = i + 1;
            add(currentSong.get(i), gbc);

            gbc.gridx = 1;
            add(songName.get(i), gbc);

            gbc.gridx = 2;
            add(duration.get(i), gbc);
        }
    }

    public void addSongLabels(String songTitle, String songDuration) {
        int index = playList.getListSize();
        songName.add(new JLabel( index + ". " + songTitle));
        currentSong.add(new JLabel());
        duration.add(new JLabel(songDuration, SwingConstants.CENTER));

        gbc.gridy++;
        gbc.gridx = 0;
        add(currentSong.get(index - 1), gbc);

        gbc.gridx = 1;
        add(songName.get(index - 1), gbc);

        gbc.gridx = 2;
        add(duration.get(index - 1), gbc);
    }

    public void setCurrentSong(int songIndex){
        for (int i = 0; i < currentSong.size(); i++) {
            currentSong.get(i).setIcon(new ImageIcon());
        }
        currentSong.get(songIndex).setIcon(currentSongIcon);
    }
}
