import PlayList.PlayList;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class ControlPanel extends JPanel implements ActionListener {

    private Icon iconForward, iconBackward, iconRepeat;
    private JButton forward, backward, repeat, select;
    private PlayList playList;
    private MusicPanel musicPanel;
    private JFileChooser fileChooser;

    public ControlPanel(){

        playList = new PlayList();
        musicPanel = new MusicPanel();

        initializeUI();
        addActionListener();
    }

    public void initializeUI(){

        setPreferredSize(new Dimension(400, 50));

        iconForward = new ImageIcon("C:\\Users\\Claudiu\\Desktop\\Programare\\Java\\.PROJECTS\\Music_Player\\Img\\forward.png");
        iconBackward = new ImageIcon("C:\\Users\\Claudiu\\Desktop\\Programare\\Java\\.PROJECTS\\Music_Player\\Img\\back.png");
        iconRepeat = new ImageIcon("C:\\Users\\Claudiu\\Desktop\\Programare\\Java\\.PROJECTS\\Music_Player\\Img\\repeat.png");

        forward = new JButton(iconForward);
        backward = new JButton(iconBackward);
        repeat = new JButton(iconRepeat);
        select = new JButton("Select");


        setLayout(new GridLayout(1, 3));
        add(backward);
        add(repeat);
        add(forward);
        add(select);

        backward.setBackground(Color.WHITE);
        repeat.setBackground(Color.WHITE);
        forward.setBackground(Color.WHITE);
    }

    public void addActionListener(){

        backward.addActionListener(this);
        forward.addActionListener(this);
        repeat.addActionListener(this);
        select.addActionListener(this);
    }

    int i;
    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource().equals(select)) {

            fileChooser = new JFileChooser();
            fileChooser.setCurrentDirectory(new File("C:\\Users"));
            fileChooser.setDialogTitle("Select Mp3");
            fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
            fileChooser.setFileFilter(new FileNameExtensionFilter("Mp3 files", "mp3"));
            if (fileChooser.showOpenDialog(select) == JFileChooser.APPROVE_OPTION) {
                File myFile = fileChooser.getSelectedFile();
            }
        }

        if (e.getSource().equals(backward)){

            playList.goingBackwards();
        }
        if (e.getSource().equals(forward)){

            playList.goingForwards();
//            musicPanel.getCurrentSong()[1].setText("dwa");
//            musicPanel.setCurrentSong(i);
//            i+=1;

        }
        if (e.getSource().equals(repeat)){

            playList.repeta();
        }
    }

}
