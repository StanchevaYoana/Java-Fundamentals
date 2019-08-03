import java.util.Random;
import java.util.Scanner;

public class AdvertisementMessage {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String[] phrases = {"Excellent product.", "Such a great product.", "I always use that product.",
                "Best product of its category.", "Exceptional product.", "I can’t live without this product."};
        String[] events = {"Now I feel good.", "I have succeeded with this product.", "Makes miracles. I am happy of the results!", "I cannot believe but now I feel awesome.",
                "Try it yourself, I am very satisfied.", "I feel great!"};
        String[] author = {"Diana", "Petya", "Stella", "Elena", "Katya", "Iva", "Annie", "Eva"};
        String[] city = {"Burgas", "Sofia", "Plovdiv", "Varna", "Ruse"};


        Random random = new Random(phrases.length);

        int num = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < num; i++) {
            int phrase = random.nextInt(phrases.length);
            int event = random.nextInt(events.length);
            int authorR = random.nextInt(author.length);
            int cityY = random.nextInt(city.length);

            System.out.printf("%s %s %s - %s%n", phrases[phrase], events[event], author[authorR], city[cityY]);

        }
    }
}
