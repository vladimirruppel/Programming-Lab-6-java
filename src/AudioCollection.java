import java.util.ArrayList;

class AudioCollection extends TrackList {
	// конструкторы
	public AudioCollection(ArrayList<AudioFile> trackList) {
		super(trackList);
	}

	public AudioCollection(AudioFile... trackList) {
		super();
		for (AudioFile track : trackList) {
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

	public void DisplaySearchResults(ArrayList<AudioFile> results) {
		System.out.println("Результаты по запросу: ");
		for (AudioFile track : results) {
			track.PrintInfoShort();
		}
	}

	public void SearchAndPrintByArtistName(String artistName) {
		DisplaySearchResults(SearchByArtistName(artistName));
	}

	public void SearchAndPrintByReleaseYear(int releaseYear) {
		DisplaySearchResults(SearchByReleaseYear(releaseYear));
	}

	public void DisplayStats() {
		int tracksCount = trackList.size(); // кол-во треков в массиве
		if (tracksCount == 0) {
			System.out.println("Количество треков в коллекции равно 0");
			return;
		}	

		int fullDuration = 0; // длительность всех треков в коллекции
		for (AudioFile track : trackList) {
			fullDuration += track.GetDuration();
		}

		double averageDuration = (double) fullDuration / tracksCount; // средняя длительность

		System.out.println("Статистика коллекции: ");
		System.out.println("Количество треков: " + tracksCount);
		System.out.println("Длительность всех треков: " + fullDuration + "с");
		System.out.println("Средняя длительность: " + averageDuration + "с");
	}
}