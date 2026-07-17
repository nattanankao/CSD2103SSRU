import java.util.Scanner;

public class CheckName {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String[] name = {
            "Somchai",
            "Somsri",
            "Anan",
            "Malee",
            "Nida"
        };

        System.out.print("Enter name to search: ");
        String searchName = sc.nextLine();

        boolean found = false;

        for (int i = 0; i < name.length; i++) {
            if (name[i].equalsIgnoreCase(searchName)) {
                found = true;
                break;
            }
        }

        if (found) {
            System.out.println("Found");
        } else {
            System.out.println("Not Found");
        }

        sc.close();
    }
}
