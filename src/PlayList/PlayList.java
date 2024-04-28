package PlayList;

import java.util.*;

public class PlayList {

    private LinkedList<Song> songList;
    private ListIterator<Song> songListIterator;
    private Scanner scanner;
    private PlayerControl playerControl;

    private boolean quit = false,
                    goingForward = true,
                    isFirstPlay = true;
    private int     option, index;

    public PlayList(){

        songList = new LinkedList<>();

        Song song1 = new Song("D:\\Programare\\Java\\.PROJECTS\\Music_Player\\Playlist\\Harry Styles - Watermelon Sugar (Official Audio).mp3","Harry Styles - Watermelon Sugar", "2.53");
        Song song2 = new Song("D:\\Programare\\Java\\.PROJECTS\\Music_Player\\Playlist\\Swedish House Mafia and The Weeknd - Moth To A Flame (Official Video).mp3", "Swedish House Mafia and The Weeknd - Moth To A Flame", "4.13");
        Song song3 = new Song("D:\\Programare\\Java\\.PROJECTS\\Music_Player\\Playlist\\The Weeknd - Take My Breath (Official Music Video).mp3", "The Weeknd - Take My Breath", "3.44");

        songList.add(song1);
        songList.add(song2);
        songList.add(song3);
        songListIterator = songList.listIterator();

        playerControl = new PlayerControl();
        scanner = new Scanner(System.in);
    }

    public void menu() {

        printMenu();

        while (!quit) {

            System.out.print("Choose option: ");
            option = scanner.nextInt();
            System.out.println();

            switch (option){

                case 0:

                    quit();
                    break;
                case 1:
                    //play/repeta

                    repeat();
                    break;

                case 2:

                    stopMusic();
                    break;
                case 3:
                    //inainte

                    goingForwards();
                    break;
                case 4:
                    //inapoi

                    goingBackwards();
                    break;

                case 5:
                    //afiseaza lista

                    System.out.println("Songs in the playlist:");
                    System.out.println(printPlaylist());
                    break;
                case 6:
                    //afiseaza meniu

                    printMenu();
            }
        }
    }


    public void printMenu() {

        System.out.println("Options:");
        System.out.println("1. Play/Replay \n2. Stop \n3. Skip forwards" +
                           "\n4. Skip backwards \n5. Songs \n6. Menu \n0. Quit");
        System.out.println("---------------------------");
    }

    public void addSongToPlaylist(Song song) {

        songList.add(song);
        songListIterator = songList.listIterator(index);
    }

    public void stopMusic() {
        System.out.println("Stopping the song!");
        playerControl.stopPlayer();
    }

    public void quit() {

        stopMusic();
        scanner.close();
        quit = true;
    }

    public Song getSong(int i) { return songList.get(i); }

    public int getListSize(){
        return songList.size();
    }

    public String printPlaylist() {

        String playList = "";

        for (int i = 0; i < songList.size(); i++){
            playList += (i + 1 + ". " + songList.get(i).getTitle() + "\n");
        }
        return playList;
    }

    public void goingBackwards() {

        if (goingForward) {
            if (songListIterator.hasPrevious()) {
                songListIterator.previous();
            }
            goingForward = false;
        }

        if (songListIterator.hasPrevious()) {

            index = songListIterator.previousIndex();
            System.out.println("Now playing: " + songListIterator.previous().getTitle());

            playerControl.playSong(songList.get(index).getPath());

        } else {
            System.out.println("Start of the list!");
            System.out.println("Press 6 to show the menu!");
            goingForward = true;
        }
    }

    public void goingForwards() {

        if (!goingForward) {
            if (songListIterator.hasNext()) {
                songListIterator.next();
            }
            goingForward = true;
        }

        if (songListIterator.hasNext()) {

            index = songListIterator.nextIndex();
            System.out.println("Now playing: " + songListIterator.next().getTitle());

            playerControl.playSong(songList.get(index).getPath());

        } else {
            System.out.println("End of the list!");
            System.out.println("Press 6 to show the menu!");
            goingForward = false;
        }

        isFirstPlay = false;
    }

    public void repeat() {

        if (isFirstPlay) {
            goingForwards();
            isFirstPlay = false;
        } else {
            if (goingForward) {
                if (songListIterator.hasPrevious()) {

                    index = songListIterator.previousIndex();
                    System.out.println("Replaying the song: " + songListIterator.previous().getTitle());

                    playerControl.playSong(songList.get(index).getPath());

                }
                goingForward = false;
            } else {
                if (songListIterator.hasNext()) {

                    index = songListIterator.nextIndex();
                    System.out.println("Replaying the song: " + songListIterator.next().getTitle());

                    playerControl.playSong(songList.get(index).getPath());

                }
                goingForward = true;
            }
        }
    }

    public int getCurrentSong() {
        return index;
    }
}