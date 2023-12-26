import java.util.ArrayList;

public class Playlist extends TrackList {
	private String playlistName;

	// конструкторы
	public Playlist(String playlistName) {
		super();
		this.playlistName = playlistName;
	}

	public Playlist(String playlistName, ArrayList<AudioFile> trackList) {
		super(trackList);
		this.playlistName = playlistName;
	}

	public Playlist(String playlistName, AudioFile... tracks) {
		super();
		for (AudioFile track : tracks) {
			super.AddTrack(track);
		}
		this.playlistName = playlistName;
	}

	// сеттеры
	public void SetPlaylistName(String playlistName) {
		this.playlistName = playlistName;
	}

	// геттеры
	public String GetPlaylistName() {
		return playlistName;
	}

	// методы
	public void PrintInfo() {
		System.out.println("Название плейлиста: " + playlistName + ", количество треков: " + super.GetSize());
	}

	public static void PrintArray(ArrayList<Playlist> playlists) {
		System.out.println("Список плейлистов: ");
		for (Playlist playlist : playlists) {
			playlist.PrintInfo();
		}
	}
}