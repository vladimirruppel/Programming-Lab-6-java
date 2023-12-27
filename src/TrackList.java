import javax.sound.midi.Track;
import java.util.ArrayList;

public class TrackList implements DisplayItem, Cloneable {
    protected ArrayList<AudioFile> trackList = new ArrayList<>();

    // конструкторы
    public TrackList() { }

    public TrackList(ArrayList<AudioFile> trackList) {
        this.trackList = trackList;
    }

    public TrackList(AudioFile... tracks) {
        for (AudioFile track : tracks) {
            trackList.add(track);
        }
    }

    // сеттеры
    public void SetTrackList(ArrayList<AudioFile> trackList) {
        this.trackList = trackList;
    }

    public void SetTrackList(AudioFile... tracks) {
        for (AudioFile track : tracks) {
            trackList.add(track);
        }
    }

    // геттеры
    public ArrayList<AudioFile> GetTrackList() {
        return trackList;
    }

    public int GetSize() {
        return trackList.size();
    }

    public AudioFile GetTrackByIndex(int index) {
        return trackList.get(index);
    }

    // методы
    public void AddTrack(AudioFile track) {
        trackList.add(track);
    }

    public void RemoveTrackByIndex(int index) {
        trackList.remove(index);
    }

    public boolean Contains(AudioFile track) {
        return trackList.contains(track);
    }

    public void Display() {
        for (AudioFile track : trackList) {
            track.PrintInfoShort();
        }
    }

    @Override
    public TrackList clone() throws CloneNotSupportedException {
        return (TrackList)super.clone();
    }
}