import java.util.ArrayList;

class AudioCollection extends TrackList {
	// конструкторы
	public AudioCollection(ArrayList<AudioFile> tracks) {
		super(tracks);
	}

	public AudioCollection(AudioFile... tracks) {
		super();
		for (AudioFile track : tracks) {
			super.AddTrack(track);
		}
	}

	// методы

	public ArrayList<AudioFile> SearchByArtistName(String artistName) {
		ArrayList<AudioFile> results = new ArrayList<AudioFile>();

		for (AudioFile track : trackList) {
			if (track.GetArtistName() == artistName)
				results.add(track);
		}

		return results;
	}

	public ArrayList<AudioFile> SearchByReleaseYear(int releaseYear) {
		ArrayList<AudioFile> results = new ArrayList<AudioFile>();

		for (AudioFile track : trackList) {
			if (track.GetReleaseYear() == releaseYear)
				results.add(track);
		}

		return results;
	}

	public void PrintSearchResults(ArrayList<AudioFile> results) {
		System.out.println("Результаты по запросу: ");
		for (AudioFile track : results) {
			track.PrintInfoShort();
		}
	}

	public void SearchAndPrintByArtistName(String artistName) {
		PrintSearchResults(SearchByArtistName(artistName));
	}

	public void SearchAndPrintByReleaseYear(int releaseYear) {
		PrintSearchResults(SearchByReleaseYear(releaseYear));
	}

	public void PrintStats() {
		int tracksCount = trackList.size(); // кол-во треков в массиве
		if (tracksCount == 0) {
			System.out.println("Количество треков в коллекции равно 0");
			return;
		}	

		int fullDuration = 0; // длительность всех треков в коллекции
		for (AudioFile track : trackList) {
			fullDuration += track.GetDuration();
		}

		double averageDuration = fullDuration / tracksCount; // средняя длительность

		System.out.println("Статистика коллекции: ");
		System.out.println("Количество треков: " + tracksCount);
		System.out.println("Длительность всех треков: " + fullDuration + "с");
		System.out.println("Средняя длительность: " + averageDuration + "с");
	}
}