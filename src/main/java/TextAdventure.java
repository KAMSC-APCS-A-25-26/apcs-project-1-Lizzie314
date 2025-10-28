import java.util.Scanner;

public class TextAdventure
{
    public static void main(String[] args)
    {
        // Initialize/Create Scanner
        Scanner sc = new Scanner(System.in);

        // Declare Variables
        boolean playing = true;
        String gameOption;
        String gameMode;

        // Game
        while (playing)
        {
            // Welcome Screen
            System.out.println("Welcome to Elf Enchanted");
            System.out.println("Please select an option: ");
            System.out.println("1. Play");
            System.out.println("2. Game Premise");
            System.out.println("3. Exit");
            gameOption = sc.nextLine();

            if (gameOption.equals("1"))
            {
                // Game Mode Selection
                System.out.println("Please Choose a Game Mode: ");
                System.out.println("1. Crystal Mountain");
                System.out.println("2. Magic Forest");
                System.out.println("3. City Quest");
                gameMode = sc.nextLine();
            }

            else if (gameOption.equals("2"))
            {

            }

            else if (gameOption.equals("3"))
            {
                System.out.println("Goodbye! Hope you had fun today!");
                playing = false;
            }

            else
            {
                System.out.println("Please enter a valid choice");
            }
        }
    }
}
