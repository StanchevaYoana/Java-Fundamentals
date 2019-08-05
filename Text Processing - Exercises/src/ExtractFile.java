import java.util.Scanner;

public class ExtractFile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String  first =  scanner.nextLine();

        int firstIndex = first.lastIndexOf("\\");
        first = first.substring(firstIndex + 1, first.length());
        int secondIndex = first.lastIndexOf(".");
        String name = first.substring(0, secondIndex);
        String extension = first.substring(secondIndex + 1, first.length());

        System.out.println("File name: "+name);
        System.out.println("File extension: "+extension);

    }
}