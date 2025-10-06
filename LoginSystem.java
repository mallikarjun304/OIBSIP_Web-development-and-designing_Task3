import java.util.HashMap;
import java.util.Scanner;

public class LoginSystem {

   
    private static HashMap<String, String> users = new HashMap<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n===== LOGIN AUTHENTICATION SYSTEM =====");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); 

            switch (choice) {
                case 1:
                    register();
                    break;
                case 2:
                    login();
                    break;
                case 3:
                    System.out.println("Exiting... Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 3);
    }

  
    private static void register() {
        System.out.print("Enter a username: ");
        String username = sc.nextLine();

        if (users.containsKey(username)) {
            System.out.println("Username already exists! Try a different one.");
            return;
        }

        System.out.print("Enter a password: ");
        String password = sc.nextLine();

        users.put(username, password);
        System.out.println("Registration successful! You can now log in.");
    }


    private static void login() {
        System.out.print("Enter username: ");
        String username = sc.nextLine();

        System.out.print("Enter password: ");
        String password = sc.nextLine();

        if (users.containsKey(username) && users.get(username).equals(password)) {
            System.out.println("Login successful! Welcome, " + username + ".");
            securedPage(username);
        } else {
            System.out.println("Invalid username or password.");
        }
    }


    private static void securedPage(String username) {
        System.out.println("\n---  Secured Page ---");
        System.out.println("Hello " + username + ", you now have access to this secure section!");
        System.out.println("-----------------------\n");
    }
}
