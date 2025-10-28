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
        boolean selecting = true;

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
                while (selecting)
                {
                    // Game Mode Selection
                    System.out.println("Please Choose a Game Mode: ");
                    System.out.println("1. Crystal Mountain");
                    System.out.println("2. Magic Forest");
                    System.out.println("3. City Quest");
                    gameMode = sc.nextLine();

                    if (gameMode.equals("1"))
                    {
                        System.out.println("Welcome to Crystal Mountain");
                        System.out.println("You have been sent on a mission to collect various crystals around the");
                        System.out.println("mountain.  These crystals hold varying powers that can be used for evil if");
                        System.out.println("they are put in the wrong hands.  Unfortunately, there is a villianous group");
                        System.out.println("also racing to try to find some of the crystals before you get to them.");
                        playing = false;
                        selecting = false;
                    }

                    else if (gameMode.equals("2"))
                    {

                    }

                    else if (gameMode.equals("3"))
                    {

                    }

                    else
                    {
                        System.out.println("Please enter a valid choice");
                    }
                }
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