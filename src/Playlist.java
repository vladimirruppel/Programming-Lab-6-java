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

	public String GetPlaylistInfo() {
		return "Плейлист \"" + playlistName + "\", " + trackList.size() + " треков";
	}

	// методы
	@Override
	public void Display() {
		System.out.println(GetPlaylistInfo() + ": ");
		for (AudioFile track : trackList) {
			track.PrintInfoShort();
		}
	}
	public void DisplayInfo() {
		System.out.println("Название плейлиста: " + playlistName + ", количество треков: " + trackList.size());
	}

	public static void DisplayArray(ArrayList<Playlist> playlists) {
		System.out.println("Список плейлистов: ");
		for (Playlist playlist : playlists) {
			playlist.DisplayInfo();
		}
	}
}