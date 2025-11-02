import javax.swing.*;
import java.util.Scanner;
import java.util.Random;

public class TextAdventure
{
    public static void main(String[] args)
    {
        // Initialize/Create Scanner
        Scanner sc = new Scanner(System.in);
        Random random = new Random();


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
        boolean replayOptions = false;
        String shinyObjectInvestigate;
        int crystalsCollected = 0;


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
                    System.out.println("1. Crystal Mountain (Long Game)");
                    System.out.println("2. City Quest (Short Game)");
                    System.out.print("Please choose a game mode: ");
                    gameMode = sc.nextLine();

                    health = 100;
                    power = 200;

                    if (gameMode.equals("1"))
                    {
                        crystals = 0;
                        System.out.println("\nWelcome to Crystal Mountain");
                        boolean input1 = true;
                        while (input1)
                        {
                            System.out.println("\nYou have been sent on a mission to collect various crystals around the");
                            System.out.println("mountain. These crystals hold varying powers that can be used for evil if");
                            System.out.println("they are put in the wrong hands. Unfortunately, there is a villainous group");
                            System.out.println("also racing to try to find some of the crystals before you get to them.");
                            System.out.print("\nWould you like to choose an animal sidekick? (Y/N): ");
                            wantSidekick = sc.nextLine();
                            if (wantSidekick.equals("Y"))
                            {
                                input1 = false;
                                boolean input2 = true;
                                while (input2)
                                {
                                    System.out.println("These are the different animal sidekicks you can have: ");
                                    System.out.println("1. Katniss the Kitty");
                                    System.out.println("2. Patti the Poodle");
                                    System.out.println("3. Leah the Lioness");
                                    System.out.print("Which sidekick do you want?: ");
                                    animalSidekick = sc.nextLine();
                                    if (animalSidekick.equals("1"))
                                    {
                                        input2 = false;
                                        power += 30;
                                    }
                                    else if (animalSidekick.equals("2"))
                                    {
                                        input2 = false;
                                        power += 20;
                                    }
                                    else if (animalSidekick.equals("3"))
                                    {
                                        input2 = false;
                                        power += 50;
                                    }
                                    else
                                    {
                                        System.out.println("Please enter a valid input");
                                    }
                                }
                            }
                            else if (wantSidekick.equals("N"))
                            {
                                input1 = false;
                                System.out.println("You should probably have picked one...but it's okay...");
                            }
                            else
                            {
                                System.out.println("Please enter a valid input");
                            }
                        }
                        boolean input3 = true;
                        while (input3)
                        {
                            System.out.print("\nWould you like to choose an item? (Y/N): ");
                            wantItem = sc.nextLine();
                            if (wantItem.equals("Y"))
                            {
                                input3 = false;
                                boolean input4 = true;
                                while(input4)
                                {
                                    System.out.println("\nThese are the different items you can have: ");
                                    System.out.println("1. Wand");
                                    System.out.println("2. Potion");
                                    System.out.println("3. Spellbook");
                                    System.out.print("Which item do you want?: ");
                                    item = sc.nextLine();
                                    if (item.equals("1"))
                                    {
                                        input4 = false;
                                        power += 60;
                                    }
                                    else if (item.equals("2"))
                                    {
                                        input4 = false;
                                        power += 30;
                                    }
                                    else if (item.equals("3"))
                                    {
                                        input4 = false;
                                        power += 50;
                                    }
                                    else
                                    {
                                        System.out.println("Please enter a valid input");
                                    }
                                }
                            }
                            else if (wantItem.equals("N"))
                            {
                                input3 = false;
                                System.out.println("You should probably have picked one...but too late now...");
                            }
                            else
                            {
                                System.out.println("Please enter a valid input");
                            }
                        }
                        boolean input4 = true;
                        while (input4)
                        {
                            System.out.println("\nYou begin to walk around the base of the mountain searching for a crystal.");
                            System.out.println("You see something shiny out of the corner of your eye. What do you do?");
                            System.out.println("1. Stop and take a closer look");
                            System.out.println("2. Hide behind a bush and scope out the situation");
                            System.out.println("3. Move on and ignore it");
                            shinyObjectInvestigate = sc.nextLine();
                            if (shinyObjectInvestigate.equals("1"))
                            {
                                input4 = false;
                                System.out.println("\nUpon deciding to take a closer look, you lean over. While you are");
                                System.out.println("leaning over, you notice a shadow approaching.");
                                if (power > 210)
                                {
                                    boolean input5 = true;
                                    while (input5)
                                    {
                                        System.out.println("You have two options: ");
                                        System.out.println("1. Look over your shoulder to see what it is");
                                        System.out.println("2. Grab the crystal and try to make a dash for it");
                                        String leaningDecision = sc.nextLine();
                                        if (leaningDecision.equals("1"))
                                        {
                                            input5 = false;
                                            boolean input6 = true;
                                            while (input6)
                                            {
                                                System.out.println("\nWhen you look over your shoulder, you see someone hiding in black");
                                                System.out.println("robes. It is one of the villains. What do you choose to do?");
                                                System.out.println("1. Attack them first");
                                                System.out.println("2. Wait for them to attack you");
                                                String attackChoice = sc.nextLine();
                                                if (attackChoice.equals("1"))
                                                {
                                                    input6 = false;
                                                    for (int i = 1; i <= 6; i++)
                                                    {
                                                        if (i % 2 == 0)
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
                                                    input6 = false;
                                                    for (int j = 1; j <= 6; j++)
                                                    {
                                                        if (j % 2 != 0)
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
                                                    System.out.println("Please enter a valid input");
                                                }
                                            }
                                            if (health > 0 && power > 0)
                                            {
                                                System.out.println("You have successfully collected your first crystal.");
                                                crystalsCollected += 1;
                                                System.out.println("Crystals: " + crystalsCollected);
                                                System.out.println("Power: " + power);
                                                System.out.println("Health: " + health);
                                                boolean input7 = true;
                                                while (input7)
                                                {
                                                    System.out.println("\nYou walk along the path that starts going up the mountain");
                                                    System.out.println("some more. You come up to a break in the path that leads two");
                                                    System.out.println("separate ways.  What do you do?");
                                                    System.out.println("1. Take the path that goes into a cave to the right.");
                                                    System.out.println("2. Continue on the path that you are already on.");
                                                    String pathChoice = sc.nextLine();
                                                    if (pathChoice.equals("1"))
                                                    {
                                                        input7 = false;
                                                        boolean input8 = true;
                                                        while (input8)
                                                        {
                                                            System.out.println("Upon entering the cave, you see a light at the end of the");
                                                            System.out.println("cave. Do you: ");
                                                            System.out.println("1. Follow the light");
                                                            System.out.println("2. Turn around and exit the cave");
                                                            String lightChoice = sc.nextLine();
                                                            if (lightChoice.equals("1"))
                                                            {
                                                                input8 = false;
                                                                boolean input9 = true;
                                                                while (input9)
                                                                {
                                                                    System.out.println("\nWhen you follow the light, you come to a door.");
                                                                    System.out.println("You try to turn the door handle, but are unsuccessful");
                                                                    System.out.println("Upon further examination of the door, you notice a keypad");
                                                                    System.out.println("What do you do?");
                                                                    System.out.println("1. Figure out the combination");
                                                                    System.out.println("2. Turn around");
                                                                    String tryDoor = sc.nextLine();
                                                                    if (tryDoor.equals("1"))
                                                                    {
                                                                        input9 = false;
                                                                        System.out.println("\nThe combination consists of two digits between 0");
                                                                        System.out.println("and 9. Try different combinations until you get it");
                                                                        System.out.println("correct and the door opens");
                                                                        int firstDigit = random.nextInt(10);
                                                                        int secondDigit = random.nextInt(10);
                                                                        int m = 0;
                                                                        for (m = 0; m < 101; m++)
                                                                        {
                                                                            System.out.println("Try a combination with digits separated by a space: ");
                                                                            int firstNum = sc.nextInt();
                                                                            int secondNum = sc.nextInt();
                                                                            if (firstNum == firstDigit && secondNum == secondDigit)
                                                                            {
                                                                                System.out.println("You have successfully opened the door");
                                                                                break;
                                                                            }
                                                                            else
                                                                            {
                                                                                System.out.println("Try again");
                                                                            }
                                                                        }
                                                                        if (m < 101)
                                                                        {
                                                                            health -= m / 4;
                                                                            power -= m;
                                                                            if (health > 0 && power > 0)
                                                                            {
                                                                                System.out.println(health);
                                                                                System.out.println(power);
                                                                                System.out.println("\nYou walk into the room and find a note.");
                                                                                System.out.println("You bend over to read it and it reads that");
                                                                                System.out.println("the villians put the lock on the door, but");
                                                                                System.out.println("the crystal is still in the room");
                                                                                System.out.println("You look around and spot the crystal, which");
                                                                                System.out.println("you then collect.");
                                                                                System.out.println("\nYou have successfully collected your second");
                                                                                System.out.println("crystal.");
                                                                                crystalsCollected += 1;
                                                                                System.out.println("Crystals: " + crystalsCollected);
                                                                                System.out.println("Power: " + power);
                                                                                System.out.println("Health: " + health);
                                                                                boolean input10 = true;
                                                                                while (input10)
                                                                                {
                                                                                    System.out.println("\nYou walk out of the cave the way you");
                                                                                    System.out.println("came and continue down the other path");
                                                                                    System.out.println("Upon reaching the end of the path near");
                                                                                    System.out.println("the top of the mountain, which you now");
                                                                                    System.out.println("realize is a decently short mountain,");
                                                                                    System.out.println("you see something move out of the corner");
                                                                                    System.out.println("of your eye in a bush. What do you do?");
                                                                                    System.out.println("1. Look closer");
                                                                                    System.out.println("2. Ignore it");
                                                                                    String looking = sc.nextLine();
                                                                                    if (looking.equals("1"))
                                                                                    {
                                                                                        input10 = false;
                                                                                        boolean input11 = true;
                                                                                        while (input11)
                                                                                        {
                                                                                            System.out.println("\nUpon looking closer, you discover it");
                                                                                            System.out.println("is a squirrel holding a crystal");
                                                                                            System.out.println("The squirrel goes running. Do you: ");
                                                                                            System.out.println("1. Chase after it");
                                                                                            System.out.println("2. Let it go");
                                                                                            String chase = sc.nextLine();
                                                                                            if (chase.equals("1"))
                                                                                            {
                                                                                                input11 = false;
                                                                                                boolean input12 = true;
                                                                                                while (input12)
                                                                                                {
                                                                                                    System.out.println("\nThe squirrel goes running back");
                                                                                                    System.out.println("down the mountain. When it hits");
                                                                                                    System.out.println("the fork in the path on the mountain,");
                                                                                                    System.out.println("it enters the cave. What do you choose?");
                                                                                                    System.out.println("1. Enter it");
                                                                                                    System.out.println("2. Forget it");
                                                                                                    String enter = sc.nextLine();
                                                                                                    if (enter.equals("1"))
                                                                                                    {
                                                                                                        input12 = false;
                                                                                                        boolean input13 = true;
                                                                                                        while (input13)
                                                                                                        {
                                                                                                            System.out.println("\nUpon entering it, the squirrel");
                                                                                                            System.out.println("transforms into a villain. In");
                                                                                                            System.out.println("addition, since you have already");
                                                                                                            System.out.println("opened the lock the villians");
                                                                                                            System.out.println("placed, there is another backup");
                                                                                                            System.out.println("waiting. What do you choose?");
                                                                                                            System.out.println("1. Attack them first");
                                                                                                            System.out.println("2. Wait for them to attack you");
                                                                                                            String attackChoice = sc.nextLine();
                                                                                                            if (attackChoice.equals("1"))
                                                                                                            {
                                                                                                                input13 = false;
                                                                                                                for (int i = 1; i <= 6; i++)
                                                                                                                {
                                                                                                                    if (i % 2 == 0)
                                                                                                                    {
                                                                                                                        health -= 10;
                                                                                                                    }
                                                                                                                    else
                                                                                                                    {
                                                                                                                        power -= 10;
                                                                                                                    }
                                                                                                                }
                                                                                                            }
                                                                                                            else if (attackChoice.equals("2"))
                                                                                                            {
                                                                                                                input13 = false;
                                                                                                                for (int j = 1; j <= 6; j++)
                                                                                                                {
                                                                                                                    if (j % 2 != 0)
                                                                                                                    {
                                                                                                                        health -= 12;
                                                                                                                    }
                                                                                                                    else
                                                                                                                    {
                                                                                                                        power -= 10;
                                                                                                                    }
                                                                                                                }
                                                                                                            }
                                                                                                            else
                                                                                                            {
                                                                                                                System.out.println("Please enter a valid input");
                                                                                                            }
                                                                                                        }
                                                                                                        if (health > 0 && power > 0)
                                                                                                        {
                                                                                                            System.out.println("You have successfully ");
                                                                                                            System.out.println("collected the third crystal.");
                                                                                                            crystalsCollected += 1;
                                                                                                            System.out.println("Crystals: " + crystalsCollected);
                                                                                                            System.out.println("Power: " + power);
                                                                                                            System.out.println("Health: " + health);
                                                                                                            if (crystals == 3)
                                                                                                            {
                                                                                                                System.out.println("You have successfully completed");
                                                                                                                System.out.println("your mission.");
                                                                                                                replayOptions = true;
                                                                                                            }
                                                                                                            else
                                                                                                            {
                                                                                                                System.out.println("You didn't complete your mission");
                                                                                                                replayOptions = false;
                                                                                                            }
                                                                                                        }
                                                                                                        else
                                                                                                        {
                                                                                                            System.out.println("Unfortunately, you were not able to collect");
                                                                                                            System.out.println("the third crystal.");
                                                                                                            System.out.println("You failed your mission.");
                                                                                                            replayOptions = true;
                                                                                                        }
                                                                                                    }
                                                                                                    else if (enter.equals("2"))
                                                                                                    {
                                                                                                        input12 = false;
                                                                                                        System.out.println("You are unable to collect the third crystal");
                                                                                                        System.out.println("without getting it from the squirrel. You");
                                                                                                        System.out.println("decide to just abandon your mission and");
                                                                                                        System.out.println("take what you do have with you.");
                                                                                                        System.out.println("Crystals: " + crystalsCollected);
                                                                                                        System.out.println("Power: " + power);
                                                                                                        System.out.println("Health: " + health);
                                                                                                        replayOptions = true;
                                                                                                    }
                                                                                                    else
                                                                                                    {
                                                                                                        System.out.println("Please enter a valid input");
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                            else if (chase.equals("2"))
                                                                                            {
                                                                                                input11 = false;
                                                                                                System.out.println("You continue to search the mountain");
                                                                                                System.out.println("but are unable to find any other crystal");
                                                                                                System.out.println("before you receive word that the villains");
                                                                                                System.out.println("got away with one of the crystals.");
                                                                                                System.out.println("Crystals: " + crystalsCollected);
                                                                                                System.out.println("Power: " + power);
                                                                                                System.out.println("Health: " + health);
                                                                                                replayOptions = true;
                                                                                            }
                                                                                            else
                                                                                            {
                                                                                                System.out.println("Please enter a valid input");
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                    else if (looking.equals("2"))
                                                                                    {
                                                                                        input10 = false;
                                                                                        System.out.println("You continue to search the mountain");
                                                                                        System.out.println("but are unable to find any other crystal");
                                                                                        System.out.println("before you receive word that the villains");
                                                                                        System.out.println("got away with one of the crystals.");
                                                                                        System.out.println("Crystals: " + crystalsCollected);
                                                                                        System.out.println("Power: " + power);
                                                                                        System.out.println("Health: " + health);
                                                                                        replayOptions = true;
                                                                                    }
                                                                                    else
                                                                                    {
                                                                                        System.out.println("Please enter a valid input");
                                                                                    }
                                                                                }
                                                                            }
                                                                            else
                                                                            {
                                                                                System.out.println("You ran out of health and power.");
                                                                                replayOptions = true;
                                                                            }
                                                                        }
                                                                        else
                                                                        {
                                                                            System.out.println("You have failed to open the door. You can't");
                                                                            System.out.println("continue your mission");
                                                                            replayOptions = true;
                                                                        }

                                                                    }
                                                                    else if (tryDoor.equals("2"))
                                                                    {
                                                                        input9 = false;
                                                                        boolean input10 = true;
                                                                        while (input10)
                                                                        {
                                                                            System.out.println("\nYou walk out of the cave the way you");
                                                                            System.out.println("came and continue down the other path");
                                                                            System.out.println("Upon reaching the end of the path near");
                                                                            System.out.println("the top of the mountain, which you now");
                                                                            System.out.println("realize is a decently short mountain,");
                                                                            System.out.println("you see something move out of the corner");
                                                                            System.out.println("of your eye in a bush. What do you do?");
                                                                            System.out.println("1. Look closer");
                                                                            System.out.println("2. Ignore it");
                                                                            String looking = sc.nextLine();
                                                                            if (looking.equals("1"))
                                                                            {
                                                                                input10 = false;
                                                                                boolean input11 = true;
                                                                                while (input11)
                                                                                {
                                                                                    System.out.println("\nUpon looking closer, you discover it");
                                                                                    System.out.println("is a squirrel holding a crystal");
                                                                                    System.out.println("The squirrel goes running. Do you: ");
                                                                                    System.out.println("1. Chase after it");
                                                                                    System.out.println("2. Let it go");
                                                                                    String chase = sc.nextLine();
                                                                                    if (chase.equals("1"))
                                                                                    {
                                                                                        input11 = false;
                                                                                        boolean input12 = true;
                                                                                        while (input12)
                                                                                        {
                                                                                            System.out.println("\nThe squirrel goes running back");
                                                                                            System.out.println("down the mountain. When it hits");
                                                                                            System.out.println("the fork in the path on the mountain,");
                                                                                            System.out.println("it enters the cave. What do you choose?");
                                                                                            System.out.println("1. Enter it");
                                                                                            System.out.println("2. Forget it");
                                                                                            String enter = sc.nextLine();
                                                                                            if (enter.equals("1"))
                                                                                            {
                                                                                                input12 = false;
                                                                                                boolean input13 = true;
                                                                                                while (input13)
                                                                                                {
                                                                                                    System.out.println("\nUpon entering it, the squirrel");
                                                                                                    System.out.println("transforms into a villain. In");
                                                                                                    System.out.println("addition, since you have already");
                                                                                                    System.out.println("opened the lock the villians");
                                                                                                    System.out.println("placed, there is another backup");
                                                                                                    System.out.println("waiting. What do you choose?");
                                                                                                    System.out.println("1. Attack them first");
                                                                                                    System.out.println("2. Wait for them to attack you");
                                                                                                    String attackChoice = sc.nextLine();
                                                                                                    if (attackChoice.equals("1"))
                                                                                                    {
                                                                                                        input13 = false;
                                                                                                        for (int i = 1; i <= 6; i++)
                                                                                                        {
                                                                                                            if (i % 2 == 0)
                                                                                                            {
                                                                                                                health -= 10;
                                                                                                            }
                                                                                                            else
                                                                                                            {
                                                                                                                power -= 10;
                                                                                                            }
                                                                                                        }
                                                                                                    }
                                                                                                    else if (attackChoice.equals("2"))
                                                                                                    {
                                                                                                        input13 = false;
                                                                                                        for (int j = 1; j <= 6; j++)
                                                                                                        {
                                                                                                            if (j % 2 != 0)
                                                                                                            {
                                                                                                                health -= 12;
                                                                                                            }
                                                                                                            else
                                                                                                            {
                                                                                                                power -= 10;
                                                                                                            }
                                                                                                        }
                                                                                                    }
                                                                                                    else
                                                                                                    {
                                                                                                        System.out.println("Please enter a valid input");
                                                                                                    }
                                                                                                }
                                                                                                if (health > 0 && power > 0)
                                                                                                {
                                                                                                    System.out.println("You have successfully ");
                                                                                                    System.out.println("collected the third crystal.");
                                                                                                    crystalsCollected += 1;
                                                                                                    System.out.println("Crystals: " + crystalsCollected);
                                                                                                    System.out.println("Power: " + power);
                                                                                                    System.out.println("Health: " + health);
                                                                                                    if (crystals == 3)
                                                                                                    {
                                                                                                        System.out.println("You have successfully completed");
                                                                                                        System.out.println("your mission.");
                                                                                                        replayOptions = true;
                                                                                                    }
                                                                                                    else
                                                                                                    {
                                                                                                        System.out.println("You didn't complete your mission");
                                                                                                        replayOptions = false;
                                                                                                    }
                                                                                                }
                                                                                                else
                                                                                                {
                                                                                                    System.out.println("Unfortunately, you were not able to collect");
                                                                                                    System.out.println("the third crystal.");
                                                                                                    System.out.println("You failed your mission.");
                                                                                                    replayOptions = true;
                                                                                                }
                                                                                            }
                                                                                            else if (enter.equals("2"))
                                                                                            {
                                                                                                input12 = false;
                                                                                                System.out.println("You are unable to collect the third crystal");
                                                                                                System.out.println("without getting it from the squirrel. You");
                                                                                                System.out.println("decide to just abandon your mission and");
                                                                                                System.out.println("take what you do have with you.");
                                                                                                System.out.println("Crystals: " + crystalsCollected);
                                                                                                System.out.println("Power: " + power);
                                                                                                System.out.println("Health: " + health);
                                                                                                replayOptions = true;
                                                                                            }
                                                                                            else
                                                                                            {
                                                                                                System.out.println("Please enter a valid input");
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                    else if (chase.equals("2"))
                                                                                    {
                                                                                        input11 = false;
                                                                                        System.out.println("You continue to search the mountain");
                                                                                        System.out.println("but are unable to find any other crystal");
                                                                                        System.out.println("before you receive word that the villains");
                                                                                        System.out.println("got away with one of the crystals.");
                                                                                        System.out.println("Crystals: " + crystalsCollected);
                                                                                        System.out.println("Power: " + power);
                                                                                        System.out.println("Health: " + health);
                                                                                        replayOptions = true;
                                                                                    }
                                                                                    else
                                                                                    {
                                                                                        System.out.println("Please enter a valid input");
                                                                                    }
                                                                                }
                                                                            }
                                                                            else if (looking.equals("2"))
                                                                            {
                                                                                input10 = false;
                                                                                System.out.println("You continue to search the mountain");
                                                                                System.out.println("but are unable to find any other crystal");
                                                                                System.out.println("before you receive word that the villains");
                                                                                System.out.println("got away with one of the crystals.");
                                                                                System.out.println("Crystals: " + crystalsCollected);
                                                                                System.out.println("Power: " + power);
                                                                                System.out.println("Health: " + health);
                                                                                replayOptions = true;
                                                                            }
                                                                            else
                                                                            {
                                                                                System.out.println("Please enter a valid input");
                                                                            }
                                                                        }
                                                                    }
                                                                    else
                                                                    {
                                                                        System.out.println("Please enter a valid input");
                                                                    }
                                                                }
                                                            }
                                                            else if (lightChoice.equals("2"))
                                                            {
                                                                input8 = false;
                                                                boolean input10 = true;
                                                                while (input10)
                                                                {
                                                                    System.out.println("\nYou walk out of the cave the way you");
                                                                    System.out.println("came and continue down the other path");
                                                                    System.out.println("Upon reaching the end of the path near");
                                                                    System.out.println("the top of the mountain, which you now");
                                                                    System.out.println("realize is a decently short mountain,");
                                                                    System.out.println("you see something move out of the corner");
                                                                    System.out.println("of your eye in a bush. What do you do?");
                                                                    System.out.println("1. Look closer");
                                                                    System.out.println("2. Ignore it");
                                                                    String looking = sc.nextLine();
                                                                    if (looking.equals("1"))
                                                                    {
                                                                        input10 = false;
                                                                        boolean input11 = true;
                                                                        while (input11)
                                                                        {
                                                                            System.out.println("\nUpon looking closer, you discover it");
                                                                            System.out.println("is a squirrel holding a crystal");
                                                                            System.out.println("The squirrel goes running. Do you: ");
                                                                            System.out.println("1. Chase after it");
                                                                            System.out.println("2. Let it go");
                                                                            String chase = sc.nextLine();
                                                                            if (chase.equals("1"))
                                                                            {
                                                                                input11 = false;
                                                                                boolean input12 = true;
                                                                                while (input12)
                                                                                {
                                                                                    System.out.println("\nThe squirrel goes running back");
                                                                                    System.out.println("down the mountain. When it hits");
                                                                                    System.out.println("the fork in the path on the mountain,");
                                                                                    System.out.println("it enters the cave. What do you choose?");
                                                                                    System.out.println("1. Enter it");
                                                                                    System.out.println("2. Forget it");
                                                                                    String enter = sc.nextLine();
                                                                                    if (enter.equals("1"))
                                                                                    {
                                                                                        input12 = false;
                                                                                        boolean input13 = true;
                                                                                        while (input13)
                                                                                        {
                                                                                            System.out.println("\nUpon entering it, the squirrel");
                                                                                            System.out.println("transforms into a villain. In");
                                                                                            System.out.println("addition, since you have already");
                                                                                            System.out.println("opened the lock the villians");
                                                                                            System.out.println("placed, there is another backup");
                                                                                            System.out.println("waiting. What do you choose?");
                                                                                            System.out.println("1. Attack them first");
                                                                                            System.out.println("2. Wait for them to attack you");
                                                                                            String attackChoice = sc.nextLine();
                                                                                            if (attackChoice.equals("1"))
                                                                                            {
                                                                                                input13 = false;
                                                                                                for (int i = 1; i <= 6; i++)
                                                                                                {
                                                                                                    if (i % 2 == 0)
                                                                                                    {
                                                                                                        health -= 10;
                                                                                                    }
                                                                                                    else
                                                                                                    {
                                                                                                        power -= 10;
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                            else if (attackChoice.equals("2"))
                                                                                            {
                                                                                                input13 = false;
                                                                                                for (int j = 1; j <= 6; j++)
                                                                                                {
                                                                                                    if (j % 2 != 0)
                                                                                                    {
                                                                                                        health -= 12;
                                                                                                    }
                                                                                                    else
                                                                                                    {
                                                                                                        power -= 10;
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                            else
                                                                                            {
                                                                                                System.out.println("Please enter a valid input");
                                                                                            }
                                                                                        }
                                                                                        if (health > 0 && power > 0)
                                                                                        {
                                                                                            System.out.println("You have successfully ");
                                                                                            System.out.println("collected the third crystal.");
                                                                                            crystalsCollected += 1;
                                                                                            System.out.println("Crystals: " + crystalsCollected);
                                                                                            System.out.println("Power: " + power);
                                                                                            System.out.println("Health: " + health);
                                                                                            if (crystals == 3)
                                                                                            {
                                                                                                System.out.println("You have successfully completed");
                                                                                                System.out.println("your mission.");
                                                                                                replayOptions = true;
                                                                                            }
                                                                                            else
                                                                                            {
                                                                                                System.out.println("You didn't complete your mission");
                                                                                                replayOptions = false;
                                                                                            }
                                                                                        }
                                                                                        else
                                                                                        {
                                                                                            System.out.println("Unfortunately, you were not able to collect");
                                                                                            System.out.println("the third crystal.");
                                                                                            System.out.println("You failed your mission.");
                                                                                            replayOptions = true;
                                                                                        }
                                                                                    }
                                                                                    else if (enter.equals("2"))
                                                                                    {
                                                                                        input12 = false;
                                                                                        System.out.println("You are unable to collect the third crystal");
                                                                                        System.out.println("without getting it from the squirrel. You");
                                                                                        System.out.println("decide to just abandon your mission and");
                                                                                        System.out.println("take what you do have with you.");
                                                                                        System.out.println("Crystals: " + crystalsCollected);
                                                                                        System.out.println("Power: " + power);
                                                                                        System.out.println("Health: " + health);
                                                                                        replayOptions = true;
                                                                                    }
                                                                                    else
                                                                                    {
                                                                                        System.out.println("Please enter a valid input");
                                                                                    }
                                                                                }
                                                                            }
                                                                            else if (chase.equals("2"))
                                                                            {
                                                                                input11 = false;
                                                                                System.out.println("You continue to search the mountain");
                                                                                System.out.println("but are unable to find any other crystal");
                                                                                System.out.println("before you receive word that the villains");
                                                                                System.out.println("got away with one of the crystals.");
                                                                                System.out.println("Crystals: " + crystalsCollected);
                                                                                System.out.println("Power: " + power);
                                                                                System.out.println("Health: " + health);
                                                                                replayOptions = true;
                                                                            }
                                                                            else
                                                                            {
                                                                                System.out.println("Please enter a valid input");
                                                                            }
                                                                        }
                                                                    }
                                                                    else if (looking.equals("2"))
                                                                    {
                                                                        input10 = false;
                                                                        System.out.println("You continue to search the mountain");
                                                                        System.out.println("but are unable to find any other crystal");
                                                                        System.out.println("before you receive word that the villains");
                                                                        System.out.println("got away with one of the crystals.");
                                                                        System.out.println("Crystals: " + crystalsCollected);
                                                                        System.out.println("Power: " + power);
                                                                        System.out.println("Health: " + health);
                                                                        replayOptions = true;
                                                                    }
                                                                    else
                                                                    {
                                                                        System.out.println("Please enter a valid input");
                                                                    }
                                                                }
                                                            }
                                                            else
                                                            {
                                                                System.out.println("PLease enter a valid input");
                                                            }
                                                        }
                                                    }
                                                    else if (pathChoice.equals("2"))
                                                    {
                                                        input7 = false;
                                                        boolean input10 = true;
                                                        while (input10)
                                                        {
                                                            System.out.println("Upon reaching the end of the path near");
                                                            System.out.println("the top of the mountain, which you now");
                                                            System.out.println("realize is a decently short mountain,");
                                                            System.out.println("you see something move out of the corner");
                                                            System.out.println("of your eye in a bush. What do you do?");
                                                            System.out.println("1. Look closer");
                                                            System.out.println("2. Ignore it");
                                                            String looking = sc.nextLine();
                                                            if (looking.equals("1"))
                                                            {
                                                                input10 = false;
                                                                boolean input11 = true;
                                                                while (input11)
                                                                {
                                                                    System.out.println("\nUpon looking closer, you discover it");
                                                                    System.out.println("is a squirrel holding a crystal");
                                                                    System.out.println("The squirrel goes running. Do you: ");
                                                                    System.out.println("1. Chase after it");
                                                                    System.out.println("2. Let it go");
                                                                    String chase = sc.nextLine();
                                                                    if (chase.equals("1"))
                                                                    {
                                                                        input11 = false;
                                                                        boolean input12 = true;
                                                                        while (input12)
                                                                        {
                                                                            System.out.println("\nThe squirrel goes running back");
                                                                            System.out.println("down the mountain. When it hits");
                                                                            System.out.println("the fork in the path on the mountain,");
                                                                            System.out.println("it enters the cave. What do you choose?");
                                                                            System.out.println("1. Enter it");
                                                                            System.out.println("2. Forget it");
                                                                            String enter = sc.nextLine();
                                                                            if (enter.equals("1"))
                                                                            {
                                                                                input12 = false;
                                                                                boolean input13 = true;
                                                                                while (input13)
                                                                                {
                                                                                    System.out.println("\nUpon entering it, the squirrel");
                                                                                    System.out.println("transforms into a villain. In");
                                                                                    System.out.println("addition, since you have already");
                                                                                    System.out.println("opened the lock the villians");
                                                                                    System.out.println("placed, there is another backup");
                                                                                    System.out.println("waiting. What do you choose?");
                                                                                    System.out.println("1. Attack them first");
                                                                                    System.out.println("2. Wait for them to attack you");
                                                                                    String attackChoice = sc.nextLine();
                                                                                    if (attackChoice.equals("1"))
                                                                                    {
                                                                                        input13 = false;
                                                                                        for (int i = 1; i <= 6; i++)
                                                                                        {
                                                                                            if (i % 2 == 0)
                                                                                            {
                                                                                                health -= 10;
                                                                                            }
                                                                                            else
                                                                                            {
                                                                                                power -= 10;
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                    else if (attackChoice.equals("2"))
                                                                                    {
                                                                                        input13 = false;
                                                                                        for (int j = 1; j <= 6; j++)
                                                                                        {
                                                                                            if (j % 2 != 0)
                                                                                            {
                                                                                                health -= 12;
                                                                                            }
                                                                                            else
                                                                                            {
                                                                                                power -= 10;
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                    else
                                                                                    {
                                                                                        System.out.println("Please enter a valid input");
                                                                                    }
                                                                                }
                                                                                if (health > 0 && power > 0)
                                                                                {
                                                                                    System.out.println("You have successfully ");
                                                                                    System.out.println("collected the third crystal.");
                                                                                    crystalsCollected += 1;
                                                                                    System.out.println("Crystals: " + crystalsCollected);
                                                                                    System.out.println("Power: " + power);
                                                                                    System.out.println("Health: " + health);
                                                                                    if (crystals == 3)
                                                                                    {
                                                                                        System.out.println("You have successfully completed");
                                                                                        System.out.println("your mission.");
                                                                                        replayOptions = true;
                                                                                    }
                                                                                    else
                                                                                    {
                                                                                        System.out.println("You didn't complete your mission");
                                                                                        replayOptions = false;
                                                                                    }
                                                                                }
                                                                                else
                                                                                {
                                                                                    System.out.println("Unfortunately, you were not able to collect");
                                                                                    System.out.println("the third crystal.");
                                                                                    System.out.println("You failed your mission.");
                                                                                    replayOptions = true;
                                                                                }
                                                                            }
                                                                            else if (enter.equals("2"))
                                                                            {
                                                                                input12 = false;
                                                                                System.out.println("You are unable to collect the third crystal");
                                                                                System.out.println("without getting it from the squirrel. You");
                                                                                System.out.println("decide to just abandon your mission and");
                                                                                System.out.println("take what you do have with you.");
                                                                                System.out.println("Crystals: " + crystalsCollected);
                                                                                System.out.println("Power: " + power);
                                                                                System.out.println("Health: " + health);
                                                                                replayOptions = true;
                                                                            }
                                                                            else
                                                                            {
                                                                                System.out.println("Please enter a valid input");
                                                                            }
                                                                        }
                                                                    }
                                                                    else if (chase.equals("2"))
                                                                    {
                                                                        input11 = false;
                                                                        System.out.println("You continue to search the mountain");
                                                                        System.out.println("but are unable to find any other crystal");
                                                                        System.out.println("before you receive word that the villains");
                                                                        System.out.println("got away with one of the crystals.");
                                                                        System.out.println("Crystals: " + crystalsCollected);
                                                                        System.out.println("Power: " + power);
                                                                        System.out.println("Health: " + health);
                                                                        replayOptions = true;
                                                                    }
                                                                    else
                                                                    {
                                                                        System.out.println("Please enter a valid input");
                                                                    }
                                                                }
                                                            }
                                                            else if (looking.equals("2"))
                                                            {
                                                                input10 = false;
                                                                System.out.println("You continue to search the mountain");
                                                                System.out.println("but are unable to find any other crystal");
                                                                System.out.println("before you receive word that the villains");
                                                                System.out.println("got away with one of the crystals.");
                                                                System.out.println("Crystals: " + crystalsCollected);
                                                                System.out.println("Power: " + power);
                                                                System.out.println("Health: " + health);
                                                                replayOptions = true;
                                                            }
                                                            else
                                                            {
                                                                System.out.println("Please enter a valid input");
                                                            }
                                                        }
                                                    }
                                                    else
                                                    {
                                                        System.out.println("Please enter a valid input");
                                                    }
                                                }
                                            } else {
                                                System.out.println("Unfortunately, you were not able to collect your first crystal.");
                                                System.out.println("You failed your mission.");
                                                replayOptions = true;
                                            }
                                        }
                                        else if (leaningDecision.equals("2"))
                                        {
                                            input5 = false;
                                            System.out.println("The figure grabs you and the crystal.");
                                            System.out.println("You are captured and your mission ends");
                                            replayOptions = true;
                                        }
                                        else
                                        {
                                            input5 = false;
                                            System.out.println("Please enter a valid input");
                                        }
                                    }
                                }
                                else
                                {
                                    System.out.println("You don't have enough power to continue");
                                    replayOptions = true;
                                }
                            }
                            else if (shinyObjectInvestigate.equals("2"))
                            {
                                input4 = false;
                                System.out.println("You decide the mission is going to be too dangerous.");
                                replayOptions = false;
                            }
                            else if (shinyObjectInvestigate.equals("3"))
                            {
                                input4 = false;
                                System.out.println("You fail to collect the first crystal.");
                                System.out.println("Mission over");
                                replayOptions = true;
                            }
                            else
                            {
                                System.out.println("Please enter a valid input");
                            }
                        }
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
                                System.out.println("Please enter a valid input");
                            }
                        }
                    }

                    else if (gameMode.equals("2"))
                    {
                        
                    }



                    else
                    {
                        System.out.println("Please enter a valid input");
                    }
                }
            }




            else if (gameOption.equals("2"))
            {
                // Game Premise
            }

            else if (gameOption.equals("3"))
            {
                System.out.println("Goodbye!");
                playing = false;
            }

            else
            {
                System.out.println("Please enter a valid input");
            }
        }
    }
}