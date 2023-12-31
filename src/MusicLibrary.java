import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;

public class MusicLibrary implements DisplayItem {
	private ArrayList<AudioFile> tracks = new ArrayList<AudioFile>();
	private ArrayList<Playlist> playlists = new ArrayList<Playlist>();
	Scanner scanner = new Scanner(System.in);

	// вспомогательная функция
	private ArrayList<AudioFile> GetTracksFromPlaylists(ArrayList<Playlist> playlists) {
		ArrayList<AudioFile> tracks = new ArrayList<AudioFile>();

		for (Playlist playlist : playlists) {
			for (AudioFile track : playlist.GetTrackList()) {
				tracks.add(track);
			}
		}

		return tracks;
	}

	// конструкторы
	public MusicLibrary() { }

	public MusicLibrary(ArrayList<AudioFile> tracks) {
		this.tracks = tracks;
	}

	public MusicLibrary(ArrayList<AudioFile> tracks, ArrayList<Playlist> playlists) {
		this.tracks = tracks;
		this.playlists = playlists;
	}

	public MusicLibrary(AudioFile... tracks) {
		for (AudioFile track : tracks) {
			this.tracks.add(track);
		}
	}

	public MusicLibrary(Playlist... playlists) {
		for (Playlist playlist : playlists) {
			this.playlists.add(playlist);
		}
		this.tracks = GetTracksFromPlaylists(this.playlists);
	}

	// сеттеры
	public void SetTracks(AudioFile... tracks) {
		this.tracks = new ArrayList<AudioFile>(); // очистить массив
		for (AudioFile track : tracks) {
			this.tracks.add(track);
		}
	}

	public void SetTracks(ArrayList<AudioFile> tracks) {
		this.tracks = tracks;
	}

	public void SetPlaylists(Playlist... playlists) {
		this.playlists = new ArrayList<Playlist>();
		for (Playlist playlist : playlists) {
			this.playlists.add(playlist);
		}
	}

	public void SetPlaylists(ArrayList<Playlist> playlists) {
		this.playlists = playlists;
	}

	// геттеры
	public int GetTracksCount() {
		return tracks.size();
	}

	public int GetPlaylistsCount() {
		return playlists.size();
	}

	public AudioFile GetTrackByIndex(int index) {
		return tracks.get(index);
	}

	public Playlist GetPlaylistByIndex(int index) {
		return playlists.get(index);
	}

	// методы
	public void AddTrack(AudioFile track) {
		tracks.add(track);
	}

	public void AddPlaylist(Playlist playlist) {
		playlists.add(playlist);
	}

	public AudioFile CreateTrack() {
		System.out.println("Создание трека");
		System.out.print("Введите наименование файла: ");
		String fileName = scanner.nextLine();

		System.out.print("Введите имя артиста: ");
		String artistName = scanner.nextLine();

		System.out.print("Введите название трека: ");
		String trackName = scanner.nextLine();

		int duration = EnterHelper.EnterInt(scanner, "Введите длительность трека: ");

		int releaseYear = EnterHelper.EnterInt(scanner, "Введите год выхода трека: ");
		scanner.nextLine();

		AudioFile track = new AudioFile(fileName, artistName, trackName, duration, releaseYear);
		AddTrack(track);
		System.out.println("Трек создан");

		return track;
	}

	public Playlist CreatePlaylist() {
		System.out.print("Введите название плейлиста: ");
		String playlistName = scanner.nextLine();

		ArrayList<AudioFile> tracks = new ArrayList<AudioFile>();
		boolean toContinue = true;
		do {
			System.out.println("Откуда взять трек: ");
			System.out.println("1. Из библиотеки");
			System.out.println("2. Создать новый");

			int answer;
			do {
				answer = EnterHelper.EnterInt(scanner, "Ваш выбор: ");
			} while (answer < 1 || answer > 2);

			if (answer == 1) { // из библиотеки
				if (GetTracksCount() == 0) {
					System.out.println("Нет треков в библиотеке");
				} 
				else {
					DisplayTracks();

					int trackNumber;
					do {
						trackNumber = EnterHelper.EnterInt(scanner, "Выберите номер трека для добавления в плейлист: ");
					} while (trackNumber < 1 || trackNumber > this.tracks.size());

					AudioFile chosenTrack = this.tracks.get(trackNumber - 1);

					if (tracks.contains(chosenTrack)) {
						System.out.println("Выбранный трек уже добавлен в плейлист");
					}
					else {
						tracks.add(chosenTrack);
					}
				}
			}
			else if (answer == 2) { // создать новый
				tracks.add(CreateTrack());
			}

			do {
				System.out.println("Продолжить добавление треков?");
				System.out.println("1. Да");
				System.out.println("0. Нет");

				answer = EnterHelper.EnterInt(scanner, "Ваш выбор: ");
			} while (answer < 0 || answer > 1);

			toContinue = answer > 0; // int >> boolean
		} while (toContinue);

		Playlist playlist = new Playlist(playlistName, tracks);
		playlists.add(playlist);
		System.out.println("Плейлист создан");		

		return playlist;
	} 

	public void Display() {
		System.out.println("В музыкальной бибилотеке такие треки: ");
		if (tracks.isEmpty())
			System.out.println("Треков не обнаружено");
		else
			DisplayTracks();

		System.out.println("В музыкальной бибилотеке такие плейлисты: ");
		if (playlists.isEmpty())
			System.out.println("Плейлистов не обнаружено");
		else
			DisplayPlaylists();
	}

	public void DisplayTracks() {
		AudioFile.PrintArray(tracks, true);
	}

	public void DisplayPlaylists() {
		Playlist.DisplayArray(playlists);
	}

	public void CloseScanner() {
		scanner.close();
	}
}