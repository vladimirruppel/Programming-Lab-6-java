import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        try {
            Album album = new Album("Kanye West", "Graduation", new ArrayList<>());
        }
        catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}