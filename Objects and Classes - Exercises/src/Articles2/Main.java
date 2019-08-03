package Articles2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    static void print(List<Articles> articles) {
        for (Articles article : articles) {
            System.out.println(article.toString());

        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        List<Articles> articles = new ArrayList<>();

        while (n-- > 0) {
            String[] data = scanner.nextLine().split(", ");
            Articles article = new Articles(data[0], data[1], data[2]);
            articles.add(article);

        }

        switch (scanner.nextLine()) {
            case "title":
                articles = articles
                        .stream()
                        .sorted((p1, p2) -> p1.getTitle().compareTo(p2.getTitle()))
                        .collect(Collectors.toList());
                break;

            case "content":
                articles = articles
                        .stream()
                        .sorted((p1, p2) -> p1.getContent().compareTo(p2.getContent()))
                        .collect(Collectors.toList());
                break;

            case "author":
                articles = articles
                        .stream()
                        .sorted((p1, p2) -> p1.getAuthor().compareTo(p2.getAuthor()))
                        .collect(Collectors.toList());
                break;
        }

        print(articles);
    }
}

