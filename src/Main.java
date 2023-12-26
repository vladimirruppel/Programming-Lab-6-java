public class Main {
    public static void main(String[] args) {
        MusicLibrary lib = new MusicLibrary();
        lib.CreateTrack();

        AuditionsNumber an = new AuditionsNumber();
        try {
            an.setCount(-1);
        }
        catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.toString());
        }

        System.out.println("Количество прослушиваний: " + an.getCount());
        an.addCount(1);
        System.out.println("Количество прослушиваний: " + an.getCount());

        // работа с двумерным массивом объектов класса AudioFile

        AudioFile[][] mas = new AudioFile[3][3];
        mas[0][0] = new AudioFile("file1.mp3", "Drake", "God's Plan", 234, 2017);
        mas[0][1] = new AudioFile("file2.mp3", "Kanye West", "Ni**as in Paris", 243, 2011);
        mas[0][2] = new AudioFile("file3.mp3", "ALBLAK52", "+7(952)812", 107, 2023);
        mas[1][0] = new AudioFile("file4.mp3", "OG Buda", "Печеньки", 152, 2019);
        mas[1][1] = new AudioFile("file5.mp3", "lil krystalll", "Тик так", 104, 2019);
        mas[1][2] = new AudioFile("file6.mp3", "PHARAOH", "Взглянем В Глаза Правде", 142, 2023);
        mas[2][0] = new AudioFile("file7.mp3", "Kanye West", "Good Morning", 195, 2007);
        mas[2][1] = new AudioFile("file8.mp3", "SALUKI", "WILD EA$T",  266, 2023);
        mas[2][2] = new AudioFile("file9.mp3", "FRIENDLY THUG 52 NGG", "Two Thousand Nineteen", 105, 2022);

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                mas[i][j].PrintInfoShort();
            }
        }
    }
}