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
        String wantSidekick;
        String animalSidekick;
        int health;
        int power;

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
                    System.out.println("\nGame Modes:");
                    System.out.println("1. Crystal Mountain");
                    System.out.println("2. Magic Forest");
                    System.out.println("3. City Quest");
                    System.out.print("Please choose a game mode: ");
                    gameMode = sc.nextLine();

                    health = 100;
                    power = 200;

                    if (gameMode.equals("1"))
                    {
                        System.out.println("\nWelcome to Crystal Mountain");
                        System.out.println("\nYou have been sent on a mission to collect various crystals around the");
                        System.out.println("mountain. These crystals hold varying powers that can be used for evil if");
                        System.out.println("they are put in the wrong hands. Unfortunately, there is a villainous group");
                        System.out.println("also racing to try to find some of the crystals before you get to them.");
                        System.out.print("\nWould you like to choose an animal sidekick? (Y/N): ");
                        wantSidekick = sc.nextLine();
                        if (wantSidekick.equals("Y"))
                        {
                            System.out.println("These are the different animal sidekicks you can have: ");
                            System.out.println("1. Katniss the Kitty");
                            System.out.println("2. Patti the Poodle");
                            System.out.println("3. Leah the Lioness");
                            System.out.print("Which sidekick do you want?: ");
                            animalSidekick = sc.nextLine();
                            if (animalSidekick.equals("1"))
                            {
                                power += 30;
                            }
                            else if (animalSidekick.equals("2"))
                            {
                                power += 20;
                            }
                            else if (animalSidekick.equals("3"))
                            {
                                power += 50;
                            }
                            else
                            {
                                System.out.println("Please enter a valid input");
                            }
                        }
                        else if (wantSidekick.equals("N"))
                        {
                            System.out.println("You should probably have picked one...but it's okay...");
                        }
                        else
                        {
                            System.out.println("Please enter a valid input");
                        }

                        System.out.print("\nWould you like to choose an item? (Y/N): ");

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