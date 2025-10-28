import java.util.Scanner;

public class TextAdventure
{
    public static void main(String[] args)
    {
        // Initialize/Create Scanner
        Scanner sc = new Scanner(System.in);

        // Declare Variables
        boolean selectOption = true;
        int gameOption;

        // Welcome Screen
        while (selectOption)
        {
            System.out.println("Welcome to Elf Enchanted");
            System.out.println("Please select an option: ");
            System.out.println("1. Play");
            System.out.println("2. Game Premise");
            System.out.println("3. Exit");
            gameOption = sc.nextInt();
        }

        // Game Mode Selection
        System.out.println("Please Choose a Game Mode: ");
        System.out.println("1. Crystal Mountain");
        System.out.println("2. Magic Forest");
        System.out.println("3. City Quest");
    }
}
