import java.util.Scanner;

public class TextAdventure
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to Galaxy Village Adventure");
        boolean run = true;
        while (run)
        {
            System.out.print("Are you ready (Y/N)?: ");
            String ready = sc.nextLine();
            if (ready.equals("Y")) {
                System.out.println("Choose an option: ");
                System.out.println("1. Play");
                System.out.println("2. Game Premise");
                System.out.println("3. Exit Game");
                int choice = sc.nextInt();
                switch (choice) {
                    case 1:
                    case 2:
                    case 3:
                    default:
                }
            }
            else if (ready.equals("N"))
            {
                System.out.println("Come on!  It'll be fun!");
            }
            else
            {
                System.out.println("Please enter a valid choice");
            }
        }
    }
}
