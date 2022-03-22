package PlayList;

import java.util.*;

public class PlayList {

    private LinkedList<Song> list;
    private ListIterator<Song> listIterator;
    private Scanner scanner;
    private PlayerControl controale;

    private boolean quit = false,
                    goingForward = true;
    private int     option, index;

    public PlayList(){

        list = new LinkedList<>();

        Song song1 = new Song("C:\\Users\\Claudiu\\Desktop\\Programare\\Java\\.PROJECTS\\Music_Player\\Playlist\\Harry Styles - Watermelon Sugar (Official Audio).mp3","Harry Styles - Watermelon Sugar", "3.08");
        Song song2 = new Song("C:\\Users\\Claudiu\\Desktop\\Programare\\Java\\.PROJECTS\\Music_Player\\Playlist\\Swedish House Mafia and The Weeknd - Moth To A Flame (Official Video).mp3", "The Weeknd - Take My Breath", "3.44");
        Song song3 = new Song("C:\\Users\\Claudiu\\Desktop\\Programare\\Java\\.PROJECTS\\Music_Player\\Playlist\\The Weeknd - Take My Breath (Official Music Video).mp3", "Swedish House Mafia and The Weeknd - Moth To A Flame", "4.13");

        list.add(song1);
        list.add(song2);
        list.add(song3);
        listIterator = list.listIterator();

        controale = new PlayerControl();
        scanner = new Scanner(System.in);
    }

    public void menu() {

        printMeniu();

        while (!quit) {

            System.out.print("Choose option:");
            option = scanner.nextInt();
            System.out.println();

            switch (option){

                case 1:

                    quit = true;
                    controale.stopPlayer();
                    scanner.close();
                    break;
                case 2:
                    //inainte

                    goingForwards();
                    break;
                case 3:
                    //inapoi

                    goingBackwards();
                    break;
                case 4:
                    //repeta

                    repeta();
                    break;
                case 5:
                    //afiseaza lista

                    System.out.println("Songs in the playlist:");
                    System.out.println(printPlaylist());
                    break;
                case 6:
                    //afiseaza meniu

                    printMeniu();
            }
        }

    }

    public Song getSong(int i){
        return list.get(i);
    }

    public int getListSize(){
        return list.size();
    }

    public String printPlaylist(){

        String playList = "";

        for (int i = 0; i < list.size(); i++){
            playList += (i + 1 + "." + list.get(i).getTitle() + "\n");
        }
        return playList;
    }

    public void printMeniu(){

        System.out.println("Options:");
        System.out.println("1. Quit \n2. Skip forward \n3. Skip backwards" +
                "\n4. Replay \n5. Songs \n6. Meniu");
        System.out.println("---------------------------");
    }

    public void goingBackwards(){
        if (goingForward){
            if (listIterator.hasPrevious()){
                listIterator.previous();
            }
            goingForward = false;
        }

        if (listIterator.hasPrevious()){

            index = listIterator.previousIndex();
            System.out.println("Now playing: " + listIterator.previous().getTitle());

            controale.playSong(list.get(index).getPath());

        } else {
            System.out.println("Start of the list!");
            goingForward = true;
        }
    }

    public void goingForwards(){
        if (!goingForward){
            if (listIterator.hasNext()){
                listIterator.next();
            }
            goingForward = true;
        }

        if (listIterator.hasNext()){

            index = listIterator.nextIndex();
            System.out.println("Now playing: " + listIterator.next().getTitle());

            controale.playSong(list.get(index).getPath());

        } else {
            System.out.println("End of the list!");
            goingForward = false;
        }
    }

    public void repeta(){

        if (goingForward){
            if (listIterator.hasPrevious()){

                index = listIterator.previousIndex();
                System.out.println("Replaying the song: " + listIterator.previous().getTitle());

                controale.playSong(list.get(index).getPath());

            }
            goingForward = false;
        } else {
            if (listIterator.hasNext()){

                index = listIterator.nextIndex();
                System.out.println("Replaying the song: " + listIterator.next().getTitle());

                controale.playSong(list.get(index).getPath());

            }
            goingForward = true;
        }

    }

}