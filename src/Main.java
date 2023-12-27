import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        try {
            Album album = new Album("Kanye West", "Graduation", new ArrayList<>());
        }
        catch (Exception e) {
            System.out.println(e.toString());
        }

        AudioFile audioFile = new AudioFile("file1.mp3", "Kanye West", "Good Morning", 240, 2007);
        ArrayList<AudioFile> arrayList = new ArrayList<AudioFile>();
        arrayList.add(audioFile);
        Album album = new Album("Kanye West", "Graduation", arrayList);

        MusicLibrary musicLibrary = new MusicLibrary(audioFile);

        System.out.println("Использование шаблона класса: ");
        DisplayParent<Album> albumDisplayParent = new DisplayParent<>();
        albumDisplayParent.Display(album);
        DisplayParent<MusicLibrary> musicLibraryDisplayParent = new DisplayParent<>();
        musicLibraryDisplayParent.Display(musicLibrary);

        try {
            System.out.println("Мелкое и глубокое копирование: ");
            AudioFile audioFileClone = audioFile.clone();
            audioFileClone.PrintInfoShort();

            Album albumClone = album.clone();
            albumClone.DisplayShort();
        }
        catch (CloneNotSupportedException e) {
            System.out.println(e.toString());
        }

    }
}