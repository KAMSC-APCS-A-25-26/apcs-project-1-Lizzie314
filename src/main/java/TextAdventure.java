/*
    Name: Lizzie Bippley
    Date: November 3, 2025
    Period: AP CS A 6th Hour
    Brief Description: You are an elf in the world of Enchanted. There is havoc being wrecked on your world in regards
        to some crystals and gems that give your people powers. You can help out the people of your world by taking on a
        mission from the leaders in power. One mission is going to Crystal Mountain and collecting three crystals hidden
        around the mountain while battling a villainous group. The other mission is to go on a quest around the city to
        find two gems hidden.
    How to Play: The game will prompt you to make different decisions regarding what you choices you want to make in
        response to specific scenarios. Choose your decision and enter the corresponding input. Attempt to complete
        your mission to help the elvin world.
 */
// Import libraries
import javax.swing.*;
import java.util.Scanner;
import java.util.Random;

public class TextAdventure
{
    public static void main(String[] args)
    {
        // Initialize/create scanner
        Scanner sc = new Scanner(System.in);

        // Initialize/Create Random Object
        Random random = new Random();


        // Declare variables that have scope of multiple parts of program
        boolean playing = true;
        String gameOption;
        String gameMode;
        boolean selecting = true;
        String wantSidekick;
        String animalSidekick;
        String wantItem;
        String item;
        String replay;
        int health;
        int power;
        boolean replayOptions = false;
        String shinyObjectInvestigate;
        boolean key = false;
        boolean townSquare = false;
        boolean well = false;


        // Welcome screen
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
            // Select game option
            System.out.println("\nPlease select an option: ");
            System.out.println("1. Play");
            System.out.println("2. Game Premise");
            System.out.println("3. Exit");
            gameOption = sc.nextLine();

            // Game option of play
            // If loop 1
            if (gameOption.equals("1"))
            {
                // Loops until valid input is given
                while (selecting)
                {
                    // Game mode selection
                    System.out.println("\nGame Modes:");
                    System.out.println("1. Crystal Mountain (Long Game)");
                    System.out.println("2. City Quest (Short Game)");
                    System.out.print("Please choose a game mode: ");
                    gameMode = sc.nextLine();

                    // Set health and power starting values
                    health = 100;
                    power = 200;

                    // Game mode of crystal mountain
                    // If loop 2
                    if (gameMode.equals("1"))
                    {
                        // Create crystals collected variable
                        int crystalsCollected = 0;

                        // Start crystal mountain game
                        System.out.println("\nWelcome to Crystal Mountain");
                        boolean input1 = true;

                        // Loops until valid input is given
                        while (input1)
                        {
                            // Set premise
                            System.out.println("\nYou have been sent on a mission to collect various crystals around the");
                            System.out.println("mountain. These crystals hold varying powers that can be used for evil if");
                            System.out.println("they are put in the wrong hands. Unfortunately, there is a villainous group");
                            System.out.println("also racing to try to find some of the crystals before you get to them.");

                            // Choose animal sidekick
                            System.out.print("\nWould you like to choose an animal sidekick? (Y/N): ");
                            wantSidekick = sc.nextLine();
                            // If loop 3
                            if (wantSidekick.equals("Y"))
                            {
                                input1 = false;
                                boolean input2 = true;
                                // Loops until valid input is given
                                while (input2)
                                {
                                    System.out.println("These are the different animal sidekicks you can have: ");
                                    System.out.println("1. Katniss the Kitty");
                                    System.out.println("2. Patti the Poodle");
                                    System.out.println("3. Leah the Lioness");
                                    System.out.print("Which sidekick do you want?: ");
                                    animalSidekick = sc.nextLine();
                                    // If loop 4
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
                        // Loops until valid input is given
                        // Choose item
                        while (input3)
                        {
                            System.out.print("\nWould you like to choose an item? (Y/N): ");
                            wantItem = sc.nextLine();
                            // If loop 5
                            if (wantItem.equals("Y"))
                            {
                                input3 = false;
                                boolean input4 = true;
                                // Loops until valid input is given
                                while(input4)
                                {
                                    System.out.println("\nThese are the different items you can have: ");
                                    System.out.println("1. Wand");
                                    System.out.println("2. Potion");
                                    System.out.println("3. Spellbook");
                                    System.out.print("Which item do you want?: ");
                                    item = sc.nextLine();
                                    // If loop 6
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

                        // Scene 1: Base of mountain
                        // Loops until valid input is given
                        while (input4)
                        {
                            System.out.println("\nYou begin to walk around the base of the mountain searching for a crystal.");
                            System.out.println("You see something shiny out of the corner of your eye. What do you do?");
                            System.out.println("1. Stop and take a closer look");
                            System.out.println("2. Hide behind a bush and scope out the situation");
                            System.out.println("3. Move on and ignore it");
                            shinyObjectInvestigate = sc.nextLine();
                            // If loop 7
                            if (shinyObjectInvestigate.equals("1"))
                            {
                                input4 = false;

                                // Scene 2: Closer look
                                System.out.println("\nUpon deciding to take a closer look, you lean over. While you are");
                                System.out.println("leaning over, you notice a shadow approaching.");
                                // If loop 8
                                if (power > 210)
                                {
                                    boolean input5 = true;

                                    // Loops until valid input is given
                                    while (input5)
                                    {
                                        System.out.println("You have two options: ");
                                        System.out.println("1. Look over your shoulder to see what it is");
                                        System.out.println("2. Grab the crystal and try to make a dash for it");
                                        String leaningDecision = sc.nextLine();
                                        // If loop 9
                                        if (leaningDecision.equals("1"))
                                        {
                                            input5 = false;
                                            boolean input6 = true;
                                            // Loops until valid input is given
                                            while (input6)
                                            {
                                                // Scene 3: See something hiding
                                                System.out.println("\nWhen you look over your shoulder, you see someone hiding in black");
                                                System.out.println("robes. It is one of the villains. What do you choose to do?");
                                                System.out.println("1. Attack them first");
                                                System.out.println("2. Wait for them to attack you");
                                                String attackChoice = sc.nextLine();
                                                // If loop 10
                                                if (attackChoice.equals("1"))
                                                {
                                                    input6 = false;
                                                    for (int i = 1; i <= 6; i++)
                                                    {
                                                        // If loop 11
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
                                                        // If loop 12
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
                                            // If loop 13
                                            if (health > 0 && power > 0)
                                            {
                                                System.out.println("You have successfully collected your first crystal.");
                                                crystalsCollected += 1;
                                                System.out.println("Crystals: " + crystalsCollected);
                                                System.out.println("Power: " + power);
                                                System.out.println("Health: " + health);
                                                boolean input7 = true;

                                                // Loops until valid input is given
                                                while (input7)
                                                {
                                                    // Major Decision 1
                                                    // Scene 4: Break in path
                                                    System.out.println("\nYou walk along the path that starts going up the mountain");
                                                    System.out.println("some more. You come up to a break in the path that leads two");
                                                    System.out.println("separate ways.  What do you do?");
                                                    System.out.println("1. Take the path that goes into a cave to the right.");
                                                    System.out.println("2. Continue on the path that you are already on.");
                                                    String pathChoice = sc.nextLine();
                                                    // If loop 14
                                                    if (pathChoice.equals("1"))
                                                    {
                                                        input7 = false;
                                                        boolean input8 = true;

                                                        // Loops until valid input is given
                                                        while (input8)
                                                        {
                                                            // Scene 5: Cave light
                                                            System.out.println("Upon entering the cave, you see a light at the end of the");
                                                            System.out.println("cave. Do you: ");
                                                            System.out.println("1. Follow the light");
                                                            System.out.println("2. Turn around and exit the cave");
                                                            String lightChoice = sc.nextLine();
                                                            // If loop 15
                                                            if (lightChoice.equals("1"))
                                                            {
                                                                input8 = false;
                                                                boolean input9 = true;

                                                                // Loops until valid input is given
                                                                while (input9)
                                                                {
                                                                    // Scene 6: Door
                                                                    System.out.println("\nWhen you follow the light, you come to a door.");
                                                                    System.out.println("You try to turn the door handle, but are unsuccessful");
                                                                    System.out.println("Upon further examination of the door, you notice a keypad");
                                                                    System.out.println("What do you do?");
                                                                    System.out.println("1. Figure out the combination");
                                                                    System.out.println("2. Turn around");
                                                                    String tryDoor = sc.nextLine();
                                                                    // If loop 16
                                                                    if (tryDoor.equals("1"))
                                                                    {
                                                                        input9 = false;

                                                                        // Scene 7: Combination lock
                                                                        System.out.println("\nThe combination consists of two digits between 0");
                                                                        System.out.println("and 9. Try different combinations until you get it");
                                                                        System.out.println("correct and the door opens");
                                                                        int firstDigit = random.nextInt(10);
                                                                        int secondDigit = random.nextInt(10);
                                                                        int m;
                                                                        // Mini challenge
                                                                        for (m = 0; m < 101; m++)
                                                                        {
                                                                            System.out.println("Try a combination with digits separated by a space: ");
                                                                            int firstNum = sc.nextInt();
                                                                            int secondNum = sc.nextInt();
                                                                            // If loop 17
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
                                                                        // If loop 18
                                                                        if (m < 101)
                                                                        {
                                                                            health -= m / 4;
                                                                            power -= m;
                                                                            // If loop 19
                                                                            if (health > 0 && power > 0)
                                                                            {
                                                                                // Scene 8: Note and crystal
                                                                                System.out.println(health);
                                                                                System.out.println(power);
                                                                                System.out.println("\nYou walk into the room and find a note.");
                                                                                System.out.println("You bend over to read it and it reads that");
                                                                                System.out.println("the villains put the lock on the door, but");
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

                                                                                // Loops until valid input is given
                                                                                while (input10)
                                                                                {
                                                                                    // Scene 9: Other path up mountain
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
                                                                                    // If loop 20
                                                                                    if (looking.equals("1"))
                                                                                    {
                                                                                        input10 = false;
                                                                                        boolean input11 = true;

                                                                                        // Loops until valid input is given
                                                                                        while (input11)
                                                                                        {
                                                                                            // Major Decision 2
                                                                                            // Scene 10: Squirrel with crystal
                                                                                            System.out.println("\nUpon looking closer, you discover it");
                                                                                            System.out.println("is a squirrel holding a crystal");
                                                                                            System.out.println("The squirrel goes running. Do you: ");
                                                                                            System.out.println("1. Chase after it");
                                                                                            System.out.println("2. Let it go");
                                                                                            String chase = sc.nextLine();
                                                                                            // If loop 21
                                                                                            if (chase.equals("1"))
                                                                                            {
                                                                                                input11 = false;
                                                                                                boolean input12 = true;

                                                                                                // Loops until valid input is given
                                                                                                while (input12)
                                                                                                {
                                                                                                    // Scene 11: Squirrel runs
                                                                                                    System.out.println("\nThe squirrel goes running back");
                                                                                                    System.out.println("down the mountain. When it hits");
                                                                                                    System.out.println("the fork in the path on the mountain,");
                                                                                                    System.out.println("it enters the cave. What do you choose?");
                                                                                                    System.out.println("1. Enter it");
                                                                                                    System.out.println("2. Forget it");
                                                                                                    String enter = sc.nextLine();
                                                                                                    // If loop 22
                                                                                                    if (enter.equals("1"))
                                                                                                    {
                                                                                                        input12 = false;
                                                                                                        boolean input13 = true;

                                                                                                        // Loops until valid input is given
                                                                                                        while (input13)
                                                                                                        {
                                                                                                            // Scene 12: Squirrel to villain
                                                                                                            System.out.println("\nUpon entering it, the squirrel");
                                                                                                            System.out.println("transforms into a villain. In");
                                                                                                            System.out.println("addition, since you have already");
                                                                                                            System.out.println("opened the lock the villains");
                                                                                                            System.out.println("placed, there is another backup");
                                                                                                            System.out.println("waiting. What do you choose?");
                                                                                                            System.out.println("1. Attack them first");
                                                                                                            System.out.println("2. Wait for them to attack you");
                                                                                                            String attackChoice = sc.nextLine();
                                                                                                            // If loop 23
                                                                                                            if (attackChoice.equals("1"))
                                                                                                            {
                                                                                                                input13 = false;
                                                                                                                for (int i = 1; i <= 6; i++)
                                                                                                                {
                                                                                                                    // If loop 24
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
                                                                                                                    // If loop 25
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
                                                                                                            // Scene 13: Collected third crystal?
                                                                                                            System.out.println("You have successfully ");
                                                                                                            System.out.println("collected the third crystal.");
                                                                                                            crystalsCollected += 1;
                                                                                                            System.out.println("Crystals: " + crystalsCollected);
                                                                                                            System.out.println("Power: " + power);
                                                                                                            System.out.println("Health: " + health);
                                                                                                            // If loop 26
                                                                                                            if (crystalsCollected == 3)
                                                                                                            {
                                                                                                                // Ending 1
                                                                                                                System.out.println("You have successfully completed");
                                                                                                                System.out.println("your mission.");
                                                                                                                replayOptions = true;
                                                                                                            }
                                                                                                            else
                                                                                                            {
                                                                                                                // Ending 2
                                                                                                                System.out.println("You didn't complete your mission");
                                                                                                                replayOptions = false;
                                                                                                            }
                                                                                                        }
                                                                                                        else
                                                                                                        {
                                                                                                            // Ending 3
                                                                                                            System.out.println("Unfortunately, you were not able to collect");
                                                                                                            System.out.println("the third crystal.");
                                                                                                            System.out.println("You failed your mission.");
                                                                                                            replayOptions = true;
                                                                                                        }
                                                                                                    }
                                                                                                    else if (enter.equals("2"))
                                                                                                    {
                                                                                                        input12 = false;
                                                                                                        // Ending 4
                                                                                                        // Scene 14: Unable to collect the third crystal
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
                                                                                                // Ending 5
                                                                                                // Scene 15: Can't find other crystal
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
                                                                                        // Ending 6
                                                                                        // Scene 16: Unable to find other crystal because villain got away with one
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
                                                                                // Ending 7
                                                                                // Scene 17: Ran out of health and power
                                                                                System.out.println("You ran out of health and power.");
                                                                                replayOptions = true;
                                                                            }
                                                                        }
                                                                        else
                                                                        {
                                                                            // Ending 8
                                                                            // Scene 18: Failed to open door
                                                                            System.out.println("You have failed to open the door. You can't");
                                                                            System.out.println("continue your mission");
                                                                            replayOptions = true;
                                                                        }
                                                                    }
                                                                    else if (tryDoor.equals("2"))
                                                                    {
                                                                        input9 = false;
                                                                        boolean input10 = true;

                                                                        // Loops until valid input is given
                                                                        while (input10)
                                                                        {
                                                                            // Scene 19: Investigate bush
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
                                                                            // If loop 27
                                                                            if (looking.equals("1"))
                                                                            {
                                                                                input10 = false;
                                                                                boolean input11 = true;

                                                                                // Loops until valid input is given
                                                                                while (input11)
                                                                                {
                                                                                    // Scene 20: Find squirrel
                                                                                    System.out.println("\nUpon looking closer, you discover it");
                                                                                    System.out.println("is a squirrel holding a crystal");
                                                                                    System.out.println("The squirrel goes running. Do you: ");
                                                                                    System.out.println("1. Chase after it");
                                                                                    System.out.println("2. Let it go");
                                                                                    String chase = sc.nextLine();
                                                                                    // If loop 28
                                                                                    if (chase.equals("1"))
                                                                                    {
                                                                                        input11 = false;
                                                                                        boolean input12 = true;

                                                                                        // Loops until valid input is given
                                                                                        while (input12)
                                                                                        {
                                                                                            // Scene 21: Squirrel runs
                                                                                            System.out.println("\nThe squirrel goes running back");
                                                                                            System.out.println("down the mountain. When it hits");
                                                                                            System.out.println("the fork in the path on the mountain,");
                                                                                            System.out.println("it enters the cave. What do you choose?");
                                                                                            System.out.println("1. Enter it");
                                                                                            System.out.println("2. Forget it");
                                                                                            String enter = sc.nextLine();
                                                                                            // If loop 29
                                                                                            if (enter.equals("1"))
                                                                                            {
                                                                                                input12 = false;
                                                                                                boolean input13 = true;

                                                                                                // Loops until valid input is given
                                                                                                while (input13)
                                                                                                {
                                                                                                    // Scene 22: Squirrel to villain
                                                                                                    System.out.println("\nUpon entering it, the squirrel");
                                                                                                    System.out.println("transforms into a villain. In");
                                                                                                    System.out.println("addition, since you have already");
                                                                                                    System.out.println("opened the lock the villains");
                                                                                                    System.out.println("placed, there is another backup");
                                                                                                    System.out.println("waiting. What do you choose?");
                                                                                                    System.out.println("1. Attack them first");
                                                                                                    System.out.println("2. Wait for them to attack you");
                                                                                                    String attackChoice = sc.nextLine();
                                                                                                    // If loop 30
                                                                                                    if (attackChoice.equals("1"))
                                                                                                    {
                                                                                                        input13 = false;
                                                                                                        for (int i = 1; i <= 6; i++)
                                                                                                        {
                                                                                                            // If loop 31
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
                                                                                                            // If loop 32
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
                                                                                                // If loop 33
                                                                                                if (health > 0 && power > 0)
                                                                                                {
                                                                                                    // Scene 23: Collected third crystal
                                                                                                    System.out.println("You have successfully ");
                                                                                                    System.out.println("collected the third crystal.");
                                                                                                    crystalsCollected += 1;
                                                                                                    System.out.println("Crystals: " + crystalsCollected);
                                                                                                    System.out.println("Power: " + power);
                                                                                                    System.out.println("Health: " + health);
                                                                                                    // If loop 34
                                                                                                    if (crystalsCollected == 3)
                                                                                                    {
                                                                                                        // Ending 9
                                                                                                        System.out.println("You have successfully completed");
                                                                                                        System.out.println("your mission.");
                                                                                                        replayOptions = true;
                                                                                                    }
                                                                                                    else
                                                                                                    {
                                                                                                        // Ending 10
                                                                                                        System.out.println("You didn't complete your mission");
                                                                                                        replayOptions = false;
                                                                                                    }
                                                                                                }
                                                                                                else
                                                                                                {
                                                                                                    // Ending 11
                                                                                                    // Scene 24: Not able to collect third crystal
                                                                                                    System.out.println("Unfortunately, you were not able to collect");
                                                                                                    System.out.println("the third crystal.");
                                                                                                    System.out.println("You failed your mission.");
                                                                                                    replayOptions = true;
                                                                                                }
                                                                                            }
                                                                                            else if (enter.equals("2"))
                                                                                            {
                                                                                                // Ending 12
                                                                                                // Scene 25: Squirrel got away
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
                                                                                        // Ending 13
                                                                                        // Scene 26: Kept searching
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
                                                                                // Ending 14
                                                                                // Scene 27: Kept searching but didn't find
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

                                                                // Loops until valid input is given
                                                                while (input10)
                                                                {
                                                                    // Scene 28: Walk out of cave
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
                                                                    // If loop 35
                                                                    if (looking.equals("1"))
                                                                    {
                                                                        input10 = false;
                                                                        boolean input11 = true;

                                                                        // Loops until valid input is given
                                                                        while (input11)
                                                                        {
                                                                            // Scene 29: Squirrel investigate
                                                                            System.out.println("\nUpon looking closer, you discover it");
                                                                            System.out.println("is a squirrel holding a crystal");
                                                                            System.out.println("The squirrel goes running. Do you: ");
                                                                            System.out.println("1. Chase after it");
                                                                            System.out.println("2. Let it go");
                                                                            String chase = sc.nextLine();
                                                                            // If loop 36
                                                                            if (chase.equals("1"))
                                                                            {
                                                                                input11 = false;
                                                                                boolean input12 = true;

                                                                                // Loops until valid input is given
                                                                                while (input12)
                                                                                {
                                                                                    // Scene 30: Squirrel runs
                                                                                    System.out.println("\nThe squirrel goes running back");
                                                                                    System.out.println("down the mountain. When it hits");
                                                                                    System.out.println("the fork in the path on the mountain,");
                                                                                    System.out.println("it enters the cave. What do you choose?");
                                                                                    System.out.println("1. Enter it");
                                                                                    System.out.println("2. Forget it");
                                                                                    String enter = sc.nextLine();
                                                                                    // If loop 37
                                                                                    if (enter.equals("1"))
                                                                                    {
                                                                                        input12 = false;
                                                                                        boolean input13 = true;

                                                                                        // Loops until valid input is given
                                                                                        while (input13)
                                                                                        {
                                                                                            // Scene 31: Squirrel becomes villain
                                                                                            System.out.println("\nUpon entering it, the squirrel");
                                                                                            System.out.println("transforms into a villain. In");
                                                                                            System.out.println("addition, since you have already");
                                                                                            System.out.println("opened the lock the villains");
                                                                                            System.out.println("placed, there is another backup");
                                                                                            System.out.println("waiting. What do you choose?");
                                                                                            System.out.println("1. Attack them first");
                                                                                            System.out.println("2. Wait for them to attack you");
                                                                                            String attackChoice = sc.nextLine();
                                                                                            // If loop 38
                                                                                            if (attackChoice.equals("1"))
                                                                                            {
                                                                                                input13 = false;
                                                                                                for (int i = 1; i <= 6; i++)
                                                                                                {
                                                                                                    // If loop 39
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
                                                                                                    // If loop 40
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
                                                                                        // If loop 41
                                                                                        if (health > 0 && power > 0)
                                                                                        {
                                                                                            // Scene 32: Collected crystal
                                                                                            System.out.println("You have successfully ");
                                                                                            System.out.println("collected the third crystal.");
                                                                                            crystalsCollected += 1;
                                                                                            System.out.println("Crystals: " + crystalsCollected);
                                                                                            System.out.println("Power: " + power);
                                                                                            System.out.println("Health: " + health);
                                                                                            // If loop 42
                                                                                            if (crystalsCollected == 3)
                                                                                            {
                                                                                                // Ending 15
                                                                                                System.out.println("You have successfully completed");
                                                                                                System.out.println("your mission.");
                                                                                                replayOptions = true;
                                                                                            }
                                                                                            else
                                                                                            {
                                                                                                // Ending 16
                                                                                                System.out.println("You didn't complete your mission");
                                                                                                replayOptions = false;
                                                                                            }
                                                                                        }
                                                                                        else
                                                                                        {
                                                                                            // Ending 17
                                                                                            // Scene 33: Didn't collect crystal
                                                                                            System.out.println("Unfortunately, you were not able to collect");
                                                                                            System.out.println("the third crystal.");
                                                                                            System.out.println("You failed your mission.");
                                                                                            replayOptions = true;
                                                                                        }
                                                                                    }
                                                                                    else if (enter.equals("2"))
                                                                                    {
                                                                                        // Ending 18
                                                                                        // Scene 34: Didn't collect third
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
                                                                                // Ending 19
                                                                                // Scene 35: Continue to search unsuccessful
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
                                                                        // Ending 20
                                                                        // Scene 36: Continue to search unsuccessful
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

                                                        // Loops until valid input is given
                                                        while (input10)
                                                        {
                                                            // Scene 37: Investigate squirrel
                                                            System.out.println("Upon reaching the end of the path near");
                                                            System.out.println("the top of the mountain, which you now");
                                                            System.out.println("realize is a decently short mountain,");
                                                            System.out.println("you see something move out of the corner");
                                                            System.out.println("of your eye in a bush. What do you do?");
                                                            System.out.println("1. Look closer");
                                                            System.out.println("2. Ignore it");
                                                            String looking = sc.nextLine();
                                                            // If loop 43
                                                            if (looking.equals("1"))
                                                            {
                                                                input10 = false;
                                                                boolean input11 = true;

                                                                // Loops until valid input is given
                                                                while (input11)
                                                                {
                                                                    // Scene 38: Squirrel with crystal
                                                                    System.out.println("\nUpon looking closer, you discover it");
                                                                    System.out.println("is a squirrel holding a crystal");
                                                                    System.out.println("The squirrel goes running. Do you: ");
                                                                    System.out.println("1. Chase after it");
                                                                    System.out.println("2. Let it go");
                                                                    String chase = sc.nextLine();
                                                                    // If loop 44
                                                                    if (chase.equals("1"))
                                                                    {
                                                                        input11 = false;
                                                                        boolean input12 = true;

                                                                        // Loops until valid input is given
                                                                        while (input12)
                                                                        {
                                                                            // Scene 39: Squirrel runs
                                                                            System.out.println("\nThe squirrel goes running back");
                                                                            System.out.println("down the mountain. When it hits");
                                                                            System.out.println("the fork in the path on the mountain,");
                                                                            System.out.println("it enters the cave. What do you choose?");
                                                                            System.out.println("1. Enter it");
                                                                            System.out.println("2. Forget it");
                                                                            String enter = sc.nextLine();
                                                                            // If loop 45
                                                                            if (enter.equals("1"))
                                                                            {
                                                                                input12 = false;
                                                                                boolean input13 = true;

                                                                                // Loops until valid input is given
                                                                                while (input13)
                                                                                {
                                                                                    // Scene 40: Squirrel becomes villain
                                                                                    System.out.println("\nUpon entering it, the squirrel");
                                                                                    System.out.println("transforms into a villain. In");
                                                                                    System.out.println("addition, since you have already");
                                                                                    System.out.println("opened the lock the villains");
                                                                                    System.out.println("placed, there is another backup");
                                                                                    System.out.println("waiting. What do you choose?");
                                                                                    System.out.println("1. Attack them first");
                                                                                    System.out.println("2. Wait for them to attack you");
                                                                                    String attackChoice = sc.nextLine();
                                                                                    // If loop 46
                                                                                    if (attackChoice.equals("1"))
                                                                                    {
                                                                                        input13 = false;
                                                                                        for (int i = 1; i <= 6; i++)
                                                                                        {
                                                                                            // If loop 47
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
                                                                                            // If loop 48
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
                                                                                // If loop 49
                                                                                if (health > 0 && power > 0)
                                                                                {
                                                                                    // Scene 41: Collect third crystal
                                                                                    System.out.println("You have successfully ");
                                                                                    System.out.println("collected the third crystal.");
                                                                                    crystalsCollected += 1;
                                                                                    System.out.println("Crystals: " + crystalsCollected);
                                                                                    System.out.println("Power: " + power);
                                                                                    System.out.println("Health: " + health);
                                                                                    // If loop 50
                                                                                    if (crystalsCollected == 3)
                                                                                    {
                                                                                        // Ending 21
                                                                                        System.out.println("You have successfully completed");
                                                                                        System.out.println("your mission.");
                                                                                        replayOptions = true;
                                                                                    }
                                                                                    else
                                                                                    {
                                                                                        // Ending 22
                                                                                        System.out.println("You didn't complete your mission");
                                                                                        replayOptions = false;
                                                                                    }
                                                                                }
                                                                                else
                                                                                {
                                                                                    // Ending 23
                                                                                    // Scene 42: Unable to collect third crystal
                                                                                    System.out.println("Unfortunately, you were not able to collect");
                                                                                    System.out.println("the third crystal.");
                                                                                    System.out.println("You failed your mission.");
                                                                                    replayOptions = true;
                                                                                }
                                                                            }
                                                                            else if (enter.equals("2"))
                                                                            {
                                                                                // Ending 24
                                                                                // Scene 43: Squirrel got away
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
                                                                        // Ending 25
                                                                        // Scene 44: Continue to search unsuccessful
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
                                                                // Ending 26
                                                                // Scene 45: Continue to search unsuccessful
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
                                            else
                                            {
                                                // Ending 27
                                                // Scene 46: Fail
                                                System.out.println("Unfortunately, you were not able to collect your first crystal.");
                                                System.out.println("You failed your mission.");
                                                replayOptions = true;
                                            }
                                        }
                                        else if (leaningDecision.equals("2"))
                                        {
                                            // Ending 28
                                            // Scene 47: Fail
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
                                    // Ending 29
                                    // Scene 48: Fail
                                    System.out.println("You don't have enough power to continue");
                                    replayOptions = true;
                                }
                            }
                            else if (shinyObjectInvestigate.equals("2"))
                            {
                                // Ending 30
                                // Scene 49: Fail
                                input4 = false;
                                System.out.println("You decide the mission is going to be too dangerous.");
                                System.out.println("You abandon the mission");
                                replayOptions = false;
                            }
                            else if (shinyObjectInvestigate.equals("3"))
                            {
                                // Ending 31
                                // Scene 50: Fail
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

                        // Loops until valid input is given
                        // Replay options
                        while (replayOptions)
                        {
                            System.out.println("\nPlease choose an option: ");
                            System.out.println("1. Restart");
                            System.out.println("2. Exit Game");
                            replay = sc.nextLine();
                            // If loop 51
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

                    // Game mode of city quest
                    else if (gameMode.equals("2"))
                    {
                        System.out.println("\nThere are two magical gems hidden around town. It's your job to find them");
                        boolean input20 = true;

                        // Loops until valid input is given
                        while (input20)
                        {
                            // Scene 51: City quest
                            System.out.println("\nWhere do you choose to go first?");
                            System.out.println("1. Town Square");
                            System.out.println("2. Well");
                            String chosePlace = sc.nextLine();
                            // If loop 52
                            if (chosePlace.equals("1"))
                            {
                                input20 = false;
                                boolean input21 = true;

                                // Loops until valid input is given
                                while (input21)
                                {
                                    // Scene 52: Square
                                    System.out.println("\nUpon entering the square, you have two choices.");
                                    System.out.println("1. Go to the market");
                                    System.out.println("2. Go to the center of the square where you see something shining");
                                    String makeChoice = sc.nextLine();
                                    // If loop 53
                                    if (makeChoice.equals("1"))
                                    {
                                        input21 = false;
                                        boolean input22 = true;

                                        // Loops until valid input is given
                                        while (input22)
                                        {
                                            // Scene 53: Market
                                            System.out.println("\nUpon going to the market, you find empty stalls everywhere.");
                                            System.out.println("The market is closed today. What do you choose to do?");
                                            System.out.println("1. Search the stalls in case there is something hidden");
                                            System.out.println("2. Go back to the center of the square");
                                            String stalls = sc.nextLine();
                                            // If loop 54
                                            if (stalls.equals("1"))
                                            {
                                                input22 = false;
                                                boolean input23 = true;

                                                // Loops until valid input is given
                                                while (input23)
                                                {
                                                    // Scene 54: Key
                                                    System.out.println("\nUpon further examination of the stalls, you find a");
                                                    System.out.println("shining gold key hidden. What do you do?");
                                                    System.out.println("1. Pick it up");
                                                    System.out.println("2. Leave it");
                                                    String pickUpKey = sc.nextLine();
                                                    // If loop 55
                                                    if (pickUpKey.equals("1"))
                                                    {
                                                        input23 = false;
                                                        key = true;
                                                    }
                                                    else if (pickUpKey.equals("2"))
                                                    {
                                                        input23 = false;
                                                        key = false;
                                                    }
                                                    else
                                                    {
                                                        System.out.println("Please enter a valid input");
                                                    }
                                                }
                                            }
                                            else if (stalls.equals("2"))
                                            {
                                                input22 = false;
                                                key = false;
                                            }
                                            else
                                            {
                                                System.out.println("Please enter a valid input");
                                            }
                                        }
                                    }
                                    else if (makeChoice.equals("2"))
                                    {
                                        input21 = false;
                                    }
                                    else
                                    {
                                        System.out.println("Please enter a valid input");
                                    }
                                    // Scene 55: Shiny spot and test lock
                                    System.out.println("\nOnce you enter the center of the town square, you spot what");
                                    System.out.println("is shining. It's a special keyhole in the middle of the town");
                                    System.out.println("square");
                                    // If loop 56
                                    if (key)
                                    {
                                        townSquare = true;
                                        System.out.println("\nYour key from earlier is able to fit in the keyhole and open it.");
                                        System.out.println("A gem pops out. You have successfully collected a gem.");
                                        System.out.println("Congratulations!");
                                        // If loop 57
                                        if (well)
                                        {
                                            // Ending 32
                                            // Scene 56: End game
                                            System.out.println("\nCongratulations for collecting both gems.");
                                            replayOptions = true;
                                        }
                                        else
                                        {
                                            boolean input24 = true;

                                            // Loops until valid input is given
                                            while (input24)
                                            {
                                                // Scene 57: Well
                                                System.out.println("\nUpon approaching the well, you see a bucket. What do you do?");
                                                System.out.println("1. Pick it up");
                                                System.out.println("2. Leave it");
                                                String bucket = sc.nextLine();
                                                // If loop 58
                                                if (bucket.equals("1"))
                                                {
                                                    input24 = false;
                                                    boolean input25 = true;

                                                    // Loops until valid input is given
                                                    while (input25)
                                                    {
                                                        // Scene 58: Well and gem
                                                        System.out.println("\nWhen you come to the well and look down, you see a gem floating");
                                                        System.out.println("in the water. The gem is within reach using the bucket");
                                                        System.out.println("You begin to wonder if it's a trap. What do you do?");
                                                        System.out.println("1. Pick it up");
                                                        System.out.println("2. Decide it's a trap");
                                                        String pick = sc.nextLine();
                                                        // If loop 59
                                                        if (pick.equals("1"))
                                                        {
                                                            // Ending 33
                                                            // Scene 59: Pick it up
                                                            input25 = false;
                                                            well = true;
                                                            System.out.println("\nYou were right. It wasn't a trap. You collect it successfully.");
                                                            System.out.println("Congratulations for collecting both gems.");
                                                            replayOptions = true;
                                                        }
                                                        else if (pick.equals("2"))
                                                        {
                                                            // Ending 34
                                                            // Scene 60: Over
                                                            input25 = false;
                                                            System.out.println("\nGood job for being careful, but you were wrong. It isn't");
                                                            System.out.println("a trap. You are unable to collect the gem.");
                                                            replayOptions = true;
                                                        }
                                                        else
                                                        {
                                                            System.out.println("Please enter a valid input");
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    else
                                    {
                                        // Ending 35
                                        // Scene 61: End game
                                        System.out.println("\nYou can't open the lock. You needed to in order to complete your");
                                        System.out.println("mission though.");
                                        replayOptions = true;
                                    }
                                }

                            }
                            else if (chosePlace.equals("2"))
                            {
                                input20 = false;
                                boolean input24 = true;

                                // Loops until valid input is given
                                while (input24)
                                {
                                    // Scene 62: Bucket
                                    System.out.println("\nUpon approaching the well, you see a bucket. What do you do?");
                                    System.out.println("1. Pick it up");
                                    System.out.println("2. Leave it");
                                    String bucket = sc.nextLine();
                                    // If loop 60
                                    if (bucket.equals("1"))
                                    {
                                        input24 = false;
                                        boolean input25 = true;

                                        // Loops until valid input is given
                                        while (input25)
                                        {
                                            // Scene 63: Gem in well
                                            System.out.println("\nWhen you come to the well and look down, you see a gem floating");
                                            System.out.println("in the water. The gem is within reach using the bucket");
                                            System.out.println("You begin to wonder if it's a trap. What do you do?");
                                            System.out.println("1. Pick it up");
                                            System.out.println("2. Decide it's a trap");
                                            String pick = sc.nextLine();
                                            // If loop 61
                                            if (pick.equals("1"))
                                            {
                                                // Scene 64: Collect it
                                                input25 = false;
                                                well = true;
                                                System.out.println("\nYou were right. It wasn't a trap. You collect it successfully.");
                                                // If loop 62
                                                if (townSquare)
                                                {
                                                    // Ending 36
                                                    System.out.println("\nCongratulations for collecting both gems.");
                                                    replayOptions = true;
                                                }
                                                else
                                                {
                                                    boolean input21 = true;

                                                    // Loops until valid input is given
                                                    while (input21)
                                                    {
                                                        // Scene 65: Town square
                                                        System.out.println("\nUpon entering the square, you have two choices.");
                                                        System.out.println("1. Go to the market");
                                                        System.out.println("2. Go to the center of the square where you see something shining");
                                                        String makeChoice = sc.nextLine();
                                                        // If loop 63
                                                        if (makeChoice.equals("1"))
                                                        {
                                                            input21 = false;
                                                            boolean input22 = true;

                                                            // Loops until valid input is given
                                                            while (input22)
                                                            {
                                                                // Scene 66: Market
                                                                System.out.println("\nUpon going to the market, you find empty stalls everywhere.");
                                                                System.out.println("The market is closed today. What do you choose to do?");
                                                                System.out.println("1. Search the stalls in case there is something hidden");
                                                                System.out.println("2. Go back to the center of the square");
                                                                String stalls = sc.nextLine();
                                                                // If loop 64
                                                                if (stalls.equals("1"))
                                                                {
                                                                    input22 = false;
                                                                    boolean input23 = true;

                                                                    // Loops until valid input is given
                                                                    while (input23)
                                                                    {
                                                                        // Scene 67: Key
                                                                        System.out.println("\nUpon further examination of the stalls, you find a");
                                                                        System.out.println("shining gold key hidden. What do you do?");
                                                                        System.out.println("1. Pick it up");
                                                                        System.out.println("2. Leave it");
                                                                        String pickUpKey = sc.nextLine();
                                                                        // If loop 65
                                                                        if (pickUpKey.equals("1"))
                                                                        {
                                                                            input23 = false;
                                                                            key = true;
                                                                        }
                                                                        else if (pickUpKey.equals("2"))
                                                                        {
                                                                            input23 = false;
                                                                            key = false;
                                                                        }
                                                                        else
                                                                        {
                                                                            System.out.println("Please enter a valid input");
                                                                        }
                                                                    }
                                                                }
                                                                else if (stalls.equals("2"))
                                                                {
                                                                    input22 = false;
                                                                    key = false;
                                                                }
                                                                else
                                                                {
                                                                    System.out.println("Please enter a valid input");
                                                                }
                                                            }
                                                        }
                                                        else if (makeChoice.equals("2"))
                                                        {
                                                            input21 = false;
                                                        }
                                                        else
                                                        {
                                                            System.out.println("Please enter a valid input");
                                                        }
                                                        // Scene 68: Shiny lock and try to open
                                                        System.out.println("\nOnce you enter the center of the town square, you spot what");
                                                        System.out.println("is shining. It's a special keyhole in the middle of the town");
                                                        System.out.println("square");
                                                        // If loop 66
                                                        if (key)
                                                        {
                                                            // Ending 37
                                                            // Scene 69: Open lock
                                                            townSquare = true;
                                                            System.out.println("\nYour key from earlier is able to fit in the keyhole and open it.");
                                                            System.out.println("A gem pops out. You have successfully collected a gem.");
                                                            System.out.println("Congratulations!");
                                                            System.out.println("Congratulations! You have successfully collected both gems!");
                                                            replayOptions = true;
                                                        }
                                                        else
                                                        {
                                                            // Ending 38
                                                            // Scene 70: No opening lock
                                                            System.out.println("\nYou can't open the lock. You needed to in order to complete your");
                                                            System.out.println("mission though.");
                                                            replayOptions = true;
                                                        }
                                                    }
                                                }


                                            }
                                            else if (pick.equals("2"))
                                            {
                                                // Ending 39
                                                // Scene 71: Game over
                                                input25 = false;
                                                System.out.println("\nGood job for being careful, but you were wrong. It isn't");
                                                System.out.println("a trap. You are unable to collect the gem.");
                                                replayOptions = true;
                                            }
                                            else
                                            {
                                                System.out.println("Please enter a valid input");
                                            }
                                        }
                                    }
                                    else if (bucket.equals("2"))
                                    {
                                        // Ending 40
                                        // Scene 72: Game over
                                        input24 = false;
                                        System.out.println("\nUnfortunately, you needed it to collect the gem.");
                                        System.out.println("You are unable to collect the gem.");
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

                        // Loops until valid input is given
                        // Replay loop
                        while (replayOptions)
                        {
                            System.out.println("\nPlease choose an option: ");
                            System.out.println("1. Restart");
                            System.out.println("2. Exit Game");
                            replay = sc.nextLine();
                            // If loop 67
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

                    // Prompt for valid input
                    else
                    {
                        System.out.println("Please enter a valid input");
                    }
                }
            }
            
            // Game option of premise
            else if (gameOption.equals("2"))
            {
                System.out.println("You are an elf in the world of Enchanted. There is havoc being wrecked on your world");
                System.out.println("in regards to some crystals and gems that give your people powers. You can help out the");
                System.out.println("people of your world by taking on a mission from the leaders in power. One mission is");
                System.out.println("going to Crystal Mountain and collecting three crystals hidden around the mountain");
                System.out.println("while battling a villainous group. The other mission is to go on a quest around the");
                System.out.println("city to find two gems hidden. Good luck elf!");
            }

            // Game Option of Exit
            else if (gameOption.equals("3"))
            {
                System.out.println("Goodbye!");
                playing = false;
            }

            // Prompt for valid input
            else
            {
                System.out.println("Please enter a valid input");
            }
        }
    }
}