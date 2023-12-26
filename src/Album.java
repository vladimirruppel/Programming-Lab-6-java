import java.util.ArrayList;

public class Album extends TrackList {
    private String albumName;
    private String artistName;

    // конструкторы
    public Album(String artistName, String albumName, ArrayList<AudioFile> trackList) {
        super(trackList);

        if (trackList.isEmpty()) {
            throw new IllegalArgumentException("Список треков в альбоме не должен быть пустым");
        }

        this.artistName = artistName;
        this.albumName = albumName;
    }


}