import java.util.*;
import java.util.stream.Collectors;

public class OpinionPoll {

    static class PersonalInfo {

        String name;
        int age;

        public PersonalInfo(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return String.format("%s - %s",
                    this.name,
                    this.age);
        }

    }

    private static boolean isOlder(List<PersonalInfo> infoList, int requiredAge) {
        for (PersonalInfo person : infoList) {
            if (person.getAge() >= requiredAge) {
                return true;
            }

        }
        return false;
    }

    private static PersonalInfo getPerson(List<PersonalInfo> infoList, int requiredAge) {

        PersonalInfo olderPerson = null;
        for (PersonalInfo person : infoList) {
            if (person.getAge() >= requiredAge) {
                olderPerson = person;

            }
        }
        return olderPerson;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = Integer.parseInt(scanner.nextLine());
        List<PersonalInfo> infoList = new ArrayList<>();

        for (int i = 0; i < number; i++) {

            String[] data = scanner.nextLine().split(" ");

            String name = data[0];
            int age = Integer.parseInt(data[1]);

            PersonalInfo person = new PersonalInfo(name, age);

            infoList.add(person);

        }

        List<PersonalInfo> olderThan30 = infoList
                .stream()
                .filter(c -> c.getAge() > 30)
                .sorted((p1, p2) -> p1.getName().compareTo(p2.getName()))
                .collect(Collectors.toList());

        for (PersonalInfo people: olderThan30) {
            System.out.println(people.toString());

        }
    }
}