import PlayList.PlayList;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class MusicPanel extends JPanel {

    private PlayList playList;
    private JLabel currentSongLabel, songLabel, durationLabel;
    private JLabel[] songName, currentSong;
    private Font font;
    private Icon currentSongIcon;
    private GridBagConstraints gbc;

    public MusicPanel(){

        playList = new PlayList();

        initializeUI();
        addSongLabels();
    }

    public void initializeUI(){

        setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();
        Border border = BorderFactory.createLineBorder(Color.BLACK);
        font = new Font("Courier", Font.BOLD,16);
        //setBorder(border);

        currentSongIcon = new ImageIcon("C:\\Users\\Claudiu\\Desktop\\Programare\\Java\\.PROJECTS\\Music_Player\\Img\\tri.png");

        currentSongLabel = new JLabel("C ");
        currentSongLabel.setFont(font);
        currentSongLabel.setBorder(border);

        songLabel = new JLabel(" Song");
        songLabel.setFont(font);
        songLabel.setBorder(border);

        durationLabel = new JLabel(" Duration");
        durationLabel.setFont(font);
        durationLabel.setBorder(border);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        //gbc.weightx = 0.5; pentru cand maresti fereastra
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(currentSongLabel, gbc);

        gbc.gridx = 1;
        add(songLabel, gbc);

        gbc.gridx = 2;
        add(durationLabel, gbc);

    }

    public void addSongLabels(){

        songName = new JLabel[playList.getListSize()];
        currentSong = new JLabel[playList.getListSize()];

        for (int i = 0; i < playList.getListSize(); i++) {

            songName[i] = new JLabel(i + 1 + "." + playList.getSong(i).getTitle());
            currentSong[i] = new JLabel("");

            //songName.setBorder(border);
            //currentSong.setBorder(border);

            gbc.gridx = 0;
            gbc.gridy = i + 1;
            add(currentSong[i], gbc);

            gbc.gridx = 1;
            //gbc.gridy = GridBagConstraints.VERTICAL;
            add(songName[i], gbc);
        }
    }

    public JLabel[] getCurrentSong() {
        return currentSong;
    }

//    public void setCurrentSong(int i){
//
//        SwingUtilities.invokeLater(new Runnable() {
//            @Override
//            public void run() {
//                currentSong[i].setIcon(currentSongIcon);
//                currentSong[i].setText("=>>");
//            }
//        });
//
//    }
}
