import java.util.ArrayList;

public class Album extends TrackList {
    private String albumName;
    private String artistName;

    // конструкторы
    public Album(String artistName, String albumName, ArrayList<AudioFile> trackList) throws IllegalArgumentException {
        super(trackList);

        if (albumName.isEmpty())
            throw new IllegalArgumentException("Название альбома не должно быть пустым");
        if (artistName.isEmpty())
            throw new IllegalArgumentException("Имя артиста не должно быть пустым");
        if (trackList.isEmpty())
            throw new IllegalArgumentException("Список треков в альбоме не должен быть пустым");

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
    @Override
    public void Display() {
        System.out.println(GetAlbumInfo() + ": ");
        super.Display();
    }
    public void DisplayShort() {
        System.out.println(GetAlbumInfo());
    }

    @Override
    public Album clone() throws CloneNotSupportedException {
        Album album = (Album)super.clone();
        album.trackList = new ArrayList<>();
        for (AudioFile track : trackList) {
            album.trackList.add((AudioFile)track.clone());
        }
        return album;
    }
}