import javax.swing.*;
import java.util.Scanner;

public class TextAdventure
{
    static void invalidInput()
    {
        System.out.println("Please enter a valid input");
    }
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
        String wantItem;
        String item;
        String replay;
        int crystals;
        int health;
        int power;
        boolean replayOptions = true;
        String shinyObjectInvestigate;


        // Welcome Screen
        System.out.println("Welcome to Elf Enchanted");
        System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀   ⢀⣠⣤⠴⠶⠶⠒⠒⠒⠒⠒⠶⠶⣤⣄⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                        "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⣤⠶⠛⠉⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠉⠛⢶⣄⠀⣠⠴⠚⠛⠳⣦⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                        "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣴⠛⠉⠛⣶⠞⠉⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠦⣄⠀⠀⠀⠀⠀⠀⠈⠻⡅⠀⠀⠀⠀⠈⢷⡀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                        "⠀⠀⠀⠀⠀⠀⠀⠀⠀⢠⡟⠁⠈⣹⠞⠁⠀⢀⣴⠞⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠙⢦⡀⠀⠀⠀⠀⠀⠈⢶⣄⠀⠀⠀⠀⢷⡄⠀⠀⠀⠀⠀⠀⠀\n" +
                        "⠀⠀⠀⠀⠀⠀⠀⠀⣠⠏⠀⢀⠞⠁⠀⠀⣠⠟⠁⠀⠀⠀⠀⠀⠀⣦⠀⠀⡀⠀⠀⠀⠀⠀⠀⡙⢄⠀⠀⠀⠀⠀⢢⢫⠳⡀⠀⠀⠈⣷⠀⠀⠀⠀⠀⠀⠀\n" +
                        "⠀⠀⠀⠀⠀⠀⠀⢠⡏⠀⢠⠏⠀⠀⠀⣴⠋⠀⠀⢀⠆⠀⠀⠀⣼⠋⠳⡄⠙⣦⡀⠀⠀⠀⠀⠈⠈⢣⠀⠀⠀⠀⠀⠀⢧⡱⡀⠀⠀⢸⡇⠀⠀⠀⠀⠀⠀\n" +
                        "⠀⠀⠀⠀⠀⠀⠀⡾⠀⢀⠏⠀⠀⠀⢠⠇⠀⠀⢀⡞⠀⡴⢁⣼⠏⠀⠀⠈⠲⣌⠻⣦⣄⠀⠀⠀⠀⠀⢧⠀⠀⠀⠀⠀⠘⣷⢡⠀⠀⠀⣷⠀⠀⠀⠀⠀⠀\n" +
                        "⠀⠀⠀⠀⠀⠀⢸⠇⠀⡜⠀⠀⠀⠀⡼⠀⠀⣠⡟⣠⠎⣠⠞⠁⠀⠀⠀⠀⠀⠀⣙⡪⢵⡷⣤⣀⠀⠀⢘⡄⠀⠀⠀⠀⠀⠇⢇⡆⠀⠀⢹⡄⠀⠀⠀⠀⠀\n" +
                        "⠀⠀⠀⠀⠀⠀⣼⠀⢀⠃⠀⠀⠀⠀⡇⢀⢴⣯⣞⠷⠛⢳⡄⠀⠀⠀⠀⠀⠀⠘⠤⠤⠤⠚⠋⠛⠻⠴⢆⡇⠀⠀⠀⠀⠀⢸⢸⢰⠀⠀⢸⡇⠀⠀⠀⠀⠀\n" +
                        "⠀⠀⠀⠀⠀⠀⣿⠀⢸⠀⠀⠀⠀⠀⣯⠵⠛⠉⠉⠀⠉⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠁⠀⢀⡇⠀⢠⢸⣿⠸⠀⠀⠸⡇⠀⠀⠀⠀⠀\n" +
                        "⠀⠀⠀⠀⠀⠀⡇⠀⢸⠀⡀⠀⡆⠀⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣀⣀⣀⣀⡀⠀⡀⠀⠸⡇⠀⢸⡸⠯⠐⠒⠒⠒⠓⠒⠒⠒⠲⡄\n" +
                        "⠀⢀⣀⣀⣤⣤⡇⠠⢼⠀⡇⠀⣷⠀⢹⠀⢀⣤⣤⣤⣴⣶⣦⠀⠀⠀⠀⠀⠀⠀⠸⠿⠿⠿⠟⠛⠛⠃⠀⡇⢀⠇⠇⠀⡇⡧⠔⢖⢩⠉⠉⠓⠤⠋⣠⠞⠁\n" +
                        "⠐⣯⡉⢠⡔⣒⣢⠤⡬⡆⣿⠀⢣⢇⠘⡄⠈⠋⠉⠉⠉⠉⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡴⡠⠀⢠⢃⠎⡸⠀⡸⣿⠀⠀⣸⡜⠀⠀⣀⡴⠛⠁⠀⠀\n" +
                        "⠀⠀⠙⠲⣌⡀⠀⠱⣣⢣⡏⢧⠈⡎⣆⢣⠰⠡⠂⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⡮⠋⢸⠁⣰⣻⣛⡠⠤⠛⣀⠤⠚⣿⠁⠀⠀⠀⠀\n" +
                        "⠀⠀⠀⠀⠀⢹⡗⢤⣉⠫⠧⠼⢧⠘⣟⡿⣆⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠀⠀⣸⡔⢱⡎⣳⡠⠔⠊⠁⠀⠀⢿⠀⠀⠀⠀⠀\n" +
                        "⠀⠀⠀⠀⠀⢸⡇⠀⠈⢹⠒⠴⣅⣱⣽⣧⠀⠀⠀⠀⠀⠀⠀⠀⠦⠤⠔⠤⠤⠖⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣿⣶⠒⢉⠁⠀⠀⠀⠀⠀⠀⢸⡀⠀⠀⠀⠀\n" +
                        "⠀⠀⠀⠀⠀⣿⠀⠀⠀⢸⠀⢠⢄⠀⠀⠈⢆⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣠⠟⠁⣿⠀⡇⡇⠀⠀⠀⠀⠀⠀⢸⡇⠀⠀⠀⠀\n" +
                        "⠀⠀⠀⠀⢸⡇⠀⠀⠀⠀⠀⡞⣾⠀⠀⠀⢸⣷⣄⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⣴⣟⠁⠀⠀⣿⠀⣟⡇⠀⠀⠀⠀⠀⠀⢸⡇⠀⠀⠀⠀\n" +
                        "⠀⠀⠀⠀⡿⢀⡆⠀⠀⠀⠀⡏⢹⠀⠀⠀⢸⠇⠈⣻⢶⠦⢄⣀⣀⠀⠀⠀⠀⠀⣀⣠⣤⡶⠿⠒⢋⣿⠀⠀⠀⣿⠀⡏⡇⠀⠀⠀⠀⢠⡆⠸⡇⠀⠀⠀⠀\n" +
                        "⠀⠀⠀⣸⠇⣼⠀⠀⠀⠀⠀⠸⠜⠀⠀⠀⣿⣀⣀⣻⡤⡽⢛⡉⠛⠛⠛⠛⠉⣉⣉⣉⠤⠤⠒⠊⡡⣿⡴⠶⢚⠛⠢⡕⠁⠀⠀⢠⠀⢸⢡⠀⣿⠀⠀⠀⠀\n" +
                        "⠀⠀⠀⣿⢰⣿⠀⠀⢀⢀⠀⠀⠀⠀⠀⢠⡿⠋⢉⡙⡧⡇⢸⣴⢶⣯⡉⠉⠀⠀⠀⠀⠀⢀⠤⠊⡠⠟⡦⠖⠁⠀⠀⠘⢆⡀⠀⡈⠀⡌⣸⠀⣿⠀⠀⠀⠀\n" +
                        "⠀⠀⢨⡇⣾⣿⠀⠀⣿⢸⠀⠀⣠⠔⠒⠉⠀⠀⠈⢿⡳⡏⢸⣧⣋⣼⠇⠀⠀⢀⣀⠤⢊⡡⢔⡫⠔⠉⠀⠀⠀⠀⠀⠀⠀⠉⠓⢧⣠⠃⣿⡇⡇⠀⠀⠀⠀\n" +
                        "⠀⠀⢸⡇⣿⣿⠀⠀⠇⡞⡤⠺⡁⠀⠀⠀⠀⠀⠀⠀⠙⠣⢌⡚⠭⠵⠦⠤⢬⣕⡲⠭⠓⠊⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⠠⠤⠽⣤⣿⡇⣷⠀⠀⠀⠀\n" +
                        "⠀⠀⢸⡇⣇⢿⡄⠀⢠⣼⠾⣦⡙⢦⡀⠀⠀⠀⢀⡤⣤⠤⠌⠚⠛⠓⠊⠉⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⠤⢒⣩⡴⠶⠛⠙⢿⣿⢱⡏⠀⠀⠀⠀\n" +
                        "⠀⠀⠘⣇⣿⠘⢧⣠⡞⠁⠀⠈⠛⢦⣉⠲⠤⣀⡜⢠⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⠤⠒⣩⡴⠞⠉⠀⠀⠀⠀⠀⠀⠹⣿⡀⠀⠀⠀⠀\n" +
                        "⠀⠀⠀⠹⣼⣇⣾⠋⠀⠀⠀⠀⠀⠀⠙⠷⡒⠤⢇⡈⠒⠤⢄⣀⡀⠀⠀⠀⠀⠀⠀⢀⣀⡠⠤⠒⣉⣤⠶⠋⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠹⣷⠀⠀⠀⠀\n" +
                        "⠀⠀⠀⠀⢈⣿⠃⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⢱⡞⢼⠗⢶⣤⣤⣀⣉⣉⣉⣉⣉⣉⡥⢤⡲⣺⠛⠉⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠸⣧⠀⠀⠀\n" +
                        "⠀⠀⠀⠀⠾⠃⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⡇⣸⠓⢦⢻⡏⠉⠉⠀⠀⠀⠐⠈⠉⣹⠀⢸⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠙⠃⠀⠀\n" +
                        "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡀⠀⠀⠀⠀⣾⠀⣿⠀⠀⠱⣽⣆⠀⠀⠀⠀⠀⠀⠀⢹⠀⢻⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⢀⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                        "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠸⠿⢾⣶⣤⣤⡿⢀⡏⢀⣀⠀⠙⠛⠀⠀⠀⠀⠀⠀⠀⢸⠀⠈⠀⢀⣀⣄⣀⣤⡄⣤⣶⡯⠟⠋⠉⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                        "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠉⠙⠚⠓⠛⠿⠿⠿⠯⠿⠷⠿⠶⠾⠾⠿⠿⠤⠾⠭⠿⠛⠓⠛⠋⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀  ");
        // Game
        while (playing)
        {
            System.out.println("\nPlease select an option: ");
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
                    System.out.println("2. City Quest");
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
                                invalidInput();
                            }
                        }
                        else if (wantSidekick.equals("N"))
                        {
                            System.out.println("You should probably have picked one...but it's okay...");
                        }
                        else
                        {
                            invalidInput();
                        }

                        System.out.print("\nWould you like to choose an item? (Y/N): ");
                        wantItem = sc.nextLine();
                        if (wantItem.equals("Y"))
                        {
                            System.out.println("These are the different items you can have: ");
                            System.out.println("1. Wand");
                            System.out.println("2. Potion");
                            System.out.println("3. Spellbook");
                            System.out.print("Which item do you want?: ");
                            item = sc.nextLine();
                            if (item.equals("1"))
                            {
                                power += 60;
                            }
                            else if (item.equals("2"))
                            {
                                power += 30;
                            }
                            else if (item.equals("3"))
                            {
                                power += 50;
                            }
                            else
                            {
                                invalidInput();
                            }
                        }
                        else if (wantItem.equals("N"))
                        {
                            System.out.println("You should probably have picked one...but too late now...");
                        }
                        else
                        {
                            invalidInput();
                        }

                        System.out.println("\nYou begin to walk around the base of the mountain searching for a crystal.");
                        System.out.println("You see something shiny out of the corner of your eye. What do you do?");
                        System.out.println("1. Stop and take a closer look");
                        System.out.println("2. Hide behind a bush and scope out the situation");
                        System.out.println("3. Move on and ignore it");
                        shinyObjectInvestigate = sc.nextLine();
                        if (shinyObjectInvestigate.equals("1"))
                        {
                            System.out.println("\nUpon deciding to take a closer look, you lean over. While you are");
                            System.out.println("leaning over, you notice a shadow approaching.");
                            if (power > 210)
                            {
                                System.out.println("You have two options: ");
                                System.out.println("1. Look over your shoulder to see what it is");
                                System.out.println("2. Grab the crystal and try to make a dash for it");
                                String leaningDecision = sc.nextLine();
                                if (leaningDecision.equals("1"))
                                {
                                    System.out.println("\nWhen you look over your shoulder, you see someone hiding in black");
                                    System.out.println("robes. It is one of the villains. What do you choose to do?");
                                    System.out.println("1. Attack them first");
                                    System.out.println("2. Wait for them to attack you");
                                    String attackChoice = sc.nextLine();
                                    if (attackChoice.equals("1"))
                                    {
                                        for (int i = 1; i <= 6; i++)
                                        {
                                            if (i%2 == 0)
                                            {
                                                health -= 5;
                                            }
                                            else
                                            {
                                                power -= 5;
                                            }
                                        }
                                    }
                                    else if (attackChoice.equals("2"))
                                    {
                                        for (int j = 1; j <= 6; j++)
                                        {
                                            if (j%2 != 0)
                                            {
                                                health -= 6;
                                            }
                                            else
                                            {
                                                power -= 5;
                                            }
                                        }
                                    }
                                    else
                                    {
                                        invalidInput();
                                    }
                                    System.out.println("\n");
                                }
                                else if (leaningDecision.equals("2"))
                                {

                                }
                                else
                                {
                                    invalidInput();
                                }
                            }
                            else
                            {
                                System.out.println("You have two options: ");
                                System.out.println("1. Abort the mission");
                                System.out.println("2. Make a run for it");
                            }
                        }
                        else if (shinyObjectInvestigate.equals("2"))
                        {

                        }
                        else if (shinyObjectInvestigate.equals("3"))
                        {

                        }
                        else
                        {
                            invalidInput();
                        }

                        replayOptions = true;
                        while (replayOptions)
                        {
                            System.out.println("\nPlease choose an option: ");
                            System.out.println("1. Restart");
                            System.out.println("2. Exit Game");
                            replay = sc.nextLine();
                            if (replay.equals("1"))
                            {
                                replayOptions = false;
                            }
                            else if (replay.equals("2"))
                            {
                                System.out.println("\nGoodbye!  Hope you had fun today!");
                                replayOptions = false;
                                playing = false;
                                selecting = false;
                            }
                            else
                            {
                                invalidInput();
                            }
                        }
                    }












                    else if (gameMode.equals("2"))
                    {

                    }



                    else
                    {
                        invalidInput();
                    }
                }
            }

            else if (gameOption.equals("2"))
            {

            }

            else if (gameOption.equals("3"))
            {
                System.out.println("Goodbye!");
                playing = false;
            }

            else
            {
                invalidInput();
            }
        }
    }
}