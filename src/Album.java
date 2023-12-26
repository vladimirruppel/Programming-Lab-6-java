import java.util.ArrayList;

public class Album extends TrackList {
    private String albumName;
    private String artistName;

    // конструкторы
    public Album(String artistName, String albumName, ArrayList<AudioFile> trackList) throws IllegalArgumentException {
        super(trackList);

        if (trackList.isEmpty()) {
            throw new IllegalArgumentException("Список треков в альбоме не должен быть пустым");
        }

        this.artistName = artistName;
        this.albumName = albumName;
    }

    // сеттеры
    public void SetAlbumName(String albumName) throws IllegalArgumentException {
        if (albumName.isEmpty()) throw new IllegalArgumentException("Пустое название альбома недопустимо");
        this.albumName = albumName;
    }

    public void SetArtistName(String artistName) throws IllegalArgumentException {
        if (artistName.isEmpty()) throw new IllegalArgumentException("Пустое имя артиста недопустимо");
        this.artistName = artistName;
    }

    // геттеры
    public String GetAlbumName() {
        return albumName;
    }

    public String GetArtistName() {
        return artistName;
    }

    public String GetAlbumInfo() {
        return artistName + " - " + albumName + ", " + trackList.size() + " треков";
    }

    // методы
    public void PrintInfoShort() {
        System.out.println(GetAlbumInfo());
    }

    public void PrintInfoLong() {
        System.out.println(GetAlbumInfo() + ": ");
        super.PrintTrackList();
    }
}