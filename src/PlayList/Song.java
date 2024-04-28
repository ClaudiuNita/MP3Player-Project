package PlayList;

public class Song {

    private String path;
    private String title;
    private String duration;

    public Song(String path, String title, String duration) {
        this.path = path;
        this.title = title;
        this.duration = duration;
    }

    public String getTitle() { return title; }

    public String getDuration() { return duration; }

    public String getPath() { return path; }
}
