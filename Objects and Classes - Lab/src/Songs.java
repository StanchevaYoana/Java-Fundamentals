import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Songs {

    static class Song {
        String typeList;
        String name;
        String time;

        public String getTypeList() {
            return typeList;
        }

        public void setTypeList(String typeList) {
            this.typeList = typeList;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public void set(String type) {
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfSongs = Integer.parseInt(scanner.nextLine());
        List<Song> songs = new ArrayList<>();
        for (int i = 0; i < numberOfSongs; i++) {
            String[] data = scanner.nextLine().split("_");

            String type = data[0];
            String name = data[1];
            String time = data[2];

            Song song = new Song();
            song.setTypeList(type);
            song.setName(name);
            song.setTime(time);

            songs.add(song);

        }

        String typeList = scanner.nextLine();

        if (typeList.equals("all")) {
            for (Song song : songs) {
                System.out.println(song.getName());
            }
        } else {
            for (Song song : songs) {
                if (typeList.equals(song.getTypeList())) {
                    System.out.println(song.getName());
                }
            }
        }
    }
}
