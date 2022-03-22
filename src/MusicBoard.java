
import javax.swing.*;
import java.awt.*;

public class MusicBoard extends JFrame {

    private MusicPanel musicPanel;
    private ControlPanel controlPanel;

    public MusicBoard(){

        musicPanel = new MusicPanel();
        controlPanel = new ControlPanel();

        //getContentPane().setLayout(new GridLayout(2,1));
        add(musicPanel, BorderLayout.NORTH);
        add(controlPanel, BorderLayout.SOUTH);

        setTitle("Music Player");
        setSize(450, 400);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
