package hod_game;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;


public class HOD_GAME {

   
    public static void main(String[] args) 
    {
        boolean running = true;
        boolean selection = true;
        String input;
        Scanner scan = new Scanner(System.in);
        Random rand = new Random();
        Character player = new Character(); 
        //player.getDifficulty();
        //player.getName();
        player.getCharClass();
        player.getStats();      //depending on class, give starting inventory
          
            if(player.gameClass.equalsIgnoreCase("Knight"))
            {
                Items longsword = new Items("longsword",0,3,0,0,0,0,0,0,0,0,0,0,0,0,1); //gives +3 str
                Items chainmail = new Items("Chainmail",0,0,0,3,0,0,0,0,0,0,0,0,0,0,3); // gives +3 con
                player.equipment = longsword.ADDequipment(player.equipment);
                player.equipment = chainmail.ADDequipment(player.equipment);
                player.stats = longsword.ADDstats(player.stats);
                player.stats = chainmail.ADDstats(player.stats);
            }
             if(player.gameClass.equalsIgnoreCase("Cleric"))
            {
            
                Items mace = new Items("mace",0,2,0,0,0,0,0,0,0,0,0,0,0,0,1); //gives +2 str
                Items robes = new Items("Chainmail",0,0,0,2,0,0,0,0,0,0,0,0,0,0,3); // gives +2 con
                player.equipment=mace.ADDequipment(player.equipment);
                player.equipment=robes.ADDequipment(player.equipment);
                player.stats=mace.ADDstats(player.stats);
                player.stats=robes.ADDstats(player.stats);
            } 
              if(player.gameClass.equalsIgnoreCase("Ranger"))
            {
           
                Items bow = new Items("bow",0,0,3,0,0,0,0,0,0,0,0,0,0,0,2); //gives +3 dex
                Items BLK_leather = new Items("BLK_leather",0,0,0,3,0,0,0,0,0,0,0,0,0,0,3); // gives +3 con
                player.equipment=bow.ADDequipment(player.equipment);
                player.equipment=BLK_leather.ADDequipment(player.equipment);
                player.stats=bow.ADDstats(player.stats);
                player.stats=BLK_leather.ADDstats(player.stats);
            }
               if(player.gameClass.equalsIgnoreCase("Sorcerer"))
            {
            
                Items staff = new Items("staff",0,0,0,0,3,0,0,0,0,0,0,0,0,0,2); //gives +3 int
                Items BLK_robes = new Items("BLK_robes",0,0,0,3,0,0,0,0,0,0,0,0,0,0,3); // gives +3 con
                player.equipment=staff.ADDequipment(player.equipment);
                player.equipment=BLK_robes.ADDequipment(player.equipment);
                player.stats=staff.ADDstats(player.stats);
                player.stats=BLK_robes.ADDstats(player.stats);
            }
               int MAX_HEALTH = player.stats[0];
            ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////   
            /////////////////////////////AREA 1 CREATION/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// 
               Area area1 = new Area(0, null, null);
               int area1_L = rand.nextInt(3) + 5;
               System.out.println(area1_L);
               area1.ensureExit();
               area1.ensureBoss();
               for(int i = 0; i<area1_L-1; i++)
               {
                   area1.addNode(rand.nextInt(3));
               }
               Area.listLength(area1);
               Area area1_pp = area1;
               Chest area1_chest = new Chest();
               Enemy a1_enemy = new Enemy(1, 1, 1, 1, 1, 1, 1, 1);
               a1_enemy.newEnemy();
               /////////////////////////////AREA 1 CREATION////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
               ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
               ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
      while(running)
      {
       
          boolean area1_cleared = false;
          boolean area2_cleared = false;
          boolean area3_cleared = false;
          boolean area4_cleared = false;
          
           System.out.println("\n\t\tAt any time, type \"help\" for a list of basic commands");
           System.out.println("\n\n\t\tYou wake up and you have no clue where you are. It's dark, smells bad, and you feel evil prescenses all around. "
                      + "\n\t\tAll you can remember is who you are, and what you are good at... mostly");
              
            
            while (area1_cleared == false) {
                System.out.println("\n\t\tWhat would you like to do?");
                input = scan.nextLine();
                switch (input) {
                    case "help":
                        player.help();
                        break;
                    case "forward":
                        area1_pp = area1_pp.getForeLink();
                        System.out.println(area1_pp.getData());
                switch (area1_pp.getData()) {
                    case 0:
                        System.out.println("you move on, nothing eventful happens.");
                        break;
                    case 1:
                        a1_enemy.getEnemy();
                        System.out.println("\n\n----------------------------F I G H T !!!----------------------------");
                        System.out.println("combat commands can be pulled up at any time by typing \"combat help\"");
                        OUTER:
                        while (true) {
                            System.out.println("\nWhat will you do " + player.name + "?");
                            input = scan.nextLine();
                            switch (input) {
                                //if(input.equals("ranged attack"))
                                //{
                                //
                                //}
                                case "attack":
                                    if (player.stats[2]>=a1_enemy.enemyStats[3]) {
                                        int dmgDealt = rand.nextInt(player.stats[1]);
                                        int EdmgDealt = rand.nextInt(a1_enemy.enemyStats[2]);
                                        System.out.println("The enemy has taken " + dmgDealt + " damage!");
                                        a1_enemy.enemyStats[1] -= dmgDealt;
                                        if (a1_enemy.enemyStats[1]<0) {
                                            System.out.println("ENEMY DEFEATED!!!");
                                            System.out.println("\n\n----------------------------ENEMY HAS BEEN Y E E T E D----------------------------\n\n");
                                            a1_enemy.newEnemy();
                                            player.stats[0] = MAX_HEALTH;
                                            break OUTER;
                                        }
                                        System.out.println("The enemy does " + EdmgDealt + " damage back at you!");
                                        player.stats[0] -= EdmgDealt;
                                        if (player.stats[0]<0) {
                                            System.out.println("YOU DIED");
                                            System.out.println("\n\n----------------------------G A M E   O V E R----------------------------\n\n");
                                            area1_cleared = true;
                                            area2_cleared = true;
                                            area3_cleared = true;
                                            area4_cleared = true;
                                            running = false;
                                            break OUTER;
                                        }
                                    }
                                    if (player.stats[2]<a1_enemy.enemyStats[3]) {
                                        int dmgDealt = rand.nextInt(player.stats[1]);
                                        int EdmgDealt = rand.nextInt(a1_enemy.enemyStats[2]);
                                        System.out.println("The enemy deals " + EdmgDealt + " damage to you!");
                                        player.stats[0] -= EdmgDealt;
                                        if (player.stats[0]<0) {
                                            System.out.println("YOU DIED");
                                            System.out.println("\n\n----------------------------G A M E   O V E R----------------------------\n\n");
                                            area1_cleared = true;
                                            area2_cleared = true;
                                            area3_cleared = true;
                                            area4_cleared = true;
                                            running = false;
                                            break OUTER;
                                        }
                                        System.out.println("The enemy has taken " + dmgDealt + " damage!");
                                        a1_enemy.enemyStats[1] -= dmgDealt;
                                        if (a1_enemy.enemyStats[1]<0) {
                                            System.out.println("ENEMY DEFEATED!!!");
                                            System.out.println("\n\n----------------------------ENEMY HAS BEEN Y E E T E D----------------------------\n\n");
                                            a1_enemy.newEnemy();
                                            player.stats[0] = MAX_HEALTH;
                                            break OUTER;
                                        }
                                    }
                                    break;
                                case "identify":
                                    if(player.stats[5]>=7)
                                    {
                                        System.out.println("\n\tyou take time to analyze your enemy\n\t...\n\tyou were able to identify their stats!");
                                        a1_enemy.showEnemyStats();
                                    }
                                    else
                                    {
                                        System.out.println("\n\tyou take time to analyze your enemy\n\t...\n\tyou fail to accurately tell their stats...");
                                    }
                                    break;
                                case "equipment":
                                    System.out.println(Arrays.toString(player.equipment));
                                    break;
                                case "bag":
                                    System.out.println(Arrays.toString(player.inventory));
                                    break;
                                case "stats":
                                    player.showStats();
                                    break;
                                case "combat help":
                                    player.combatHelp();
                                    break;
                                default:
                                    System.out.println("enter a valid command (use \"combat help\" for a list of basic combat commands");
                                    break;
                            }//SWITCH INPUT - NORMAL COMBAT END
                        }//NORMAL COMBAT END
                        break;
                    case 2:
                        System.out.println("You found a chest! It contained: " + area1_chest.open());
                OUTER:
                while (true) {
                    System.out.println("\n\tWould you like to keep the item?");
                    System.out.println("\t\t 1. Yes");
                    System.out.println("\t\t 2. No");
                    input = scan.nextLine();
                    switch (input) {
                        case "1":
                            System.out.println("You yank the item from the chest!\nYou gained: " + area1_chest.open());
                            player.inventory = area1_chest.open().ADDinventory(player.inventory);
                            System.out.println(Arrays.toString(player.inventory));
                            area1_chest.newItem();
                            break OUTER;
                        case "2":
                            System.out.println("You decided to leave the item behind.");
                            area1_chest.newItem();
                            break OUTER;
                        default:
                            System.out.println("Please enter a valid option.");
                            break;
                    }
                } //CHEST END
                        break;
                    case 3:
                        Enemy bigBoi = new Enemy(100, 100, 100, 1, 1, 1, 1, 1);
                        System.out.println("\n\n----------------------------I T ' S   B O S S   T I M E   B O i S----------------------------");
                        System.out.println("combat commands can be pulled up at any time by typing \"combat help\"");
                OUTER:
                while (true) {
                    System.out.println("\nWhat will you do " + player.name + "?");
                    input = scan.nextLine();
                    switch (input) {
                        case "attack":
                            if (player.stats[2]>=bigBoi.enemyStats[3]) {
                                int dmgDealt = rand.nextInt(player.stats[1]);
                                int EdmgDealt = rand.nextInt(bigBoi.enemyStats[2]);
                                System.out.println("The enemy has taken " + dmgDealt + " damage!");
                                bigBoi.enemyStats[1] -= dmgDealt;
                                if (bigBoi.enemyStats[1]<0) {
                                    System.out.println("ENEMY DEFEATED!!!");
                                    System.out.println("\n\n----------------------------BOSS HAS BEEN Y E E T E D----------------------------\n\n");
                                    bigBoi.enemyStats[1] = 100;
                                    player.stats[0] = MAX_HEALTH;
                                    break OUTER;
                                }
                                System.out.println("The enemy does " + EdmgDealt + " damage back at you!");
                                player.stats[0] -= EdmgDealt;
                                if (player.stats[0]<0) {
                                    System.out.println("YOU DIED");
                                    System.out.println("\n\n----------------------------G A M E   O V E R----------------------------\n\n");
                                    area1_cleared = true;
                                    area2_cleared = true;
                                    area3_cleared = true;
                                    area4_cleared = true;
                                    running = false;
                                    break OUTER;
                                }
                            }
                            if (player.stats[2]<bigBoi.enemyStats[3]) {
                                int dmgDealt = rand.nextInt(player.stats[1]);
                                int EdmgDealt = rand.nextInt(bigBoi.enemyStats[2]);
                                System.out.println("The enemy deals " + EdmgDealt + " damage to you!");
                                player.stats[0] -= EdmgDealt;
                                if (player.stats[0]<0) {
                                    System.out.println("YOU DIED");
                                    System.out.println("\n\n----------------------------G A M E   O V E R----------------------------\n\n");
                                    area1_cleared = true;
                                    area2_cleared = true;
                                    area3_cleared = true;
                                    area4_cleared = true;
                                    running = false;
                                    break OUTER;
                                }
                                System.out.println("The enemy has taken " + dmgDealt + " damage!");
                                bigBoi.enemyStats[1] -= dmgDealt;
                                if (bigBoi.enemyStats[1]<0) {
                                    System.out.println("ENEMY DEFEATED!!!");
                                    System.out.println("\n\n----------------------------BOSS HAS BEEN Y E E T E D----------------------------\n\n");
                                    bigBoi.enemyStats[1] = 100;
                                    player.stats[0] = MAX_HEALTH;
                                    break OUTER;
                                }
                            }
                            break;
                        case "identify":
                            if(player.stats[5]>=7)
                            {
                                System.out.println("\n\tyou take time to analyze your enemy\n\t...\n\tyou were able to identify their stats!");
                                bigBoi.showEnemyStats();
                            }
                            else
                            {
                                System.out.println("\n\tyou take time to analyze your enemy\n\t...\n\tyou fail to accurately tell their stats...");
                            }
                            break;
                        case "equipment":
                            System.out.println(Arrays.toString(player.equipment));
                            break;
                        case "bag":
                            System.out.println(Arrays.toString(player.inventory));
                            break;
                        case "stats":
                            player.showStats();
                            break;
                        case "combat help":
                            player.combatHelp();
                            break;
                        case "help":
                            player.help();
                            break;
                        default:
                            System.out.println("enter a valid command (use \"combat help\" for a list of basic combat commands");
                            break;
                    } //SWITCH INPUT - BOSS FIGHT END
                } // BOSS FIGHT END
                        break;
                    case 4:
                        System.out.println("You have found the exit to the area! But alas... you only get deeper into this hell hole instead of having freedom");
                        area1_cleared = true;
                        break;
                    default:
                        break;
                } // AREA GET DATA END
                        break;
                    case "equipment":
                        System.out.println(Arrays.toString(player.equipment));
                        break;
                    case "bag":
                        System.out.println(Arrays.toString(player.inventory));
                        break;
                    case "stats":
                        player.showStats();
                        break;
                    default:
                        System.out.println("enter a valid command (use \"help\" for a list of basic commands)");
                        break;
                } //SWITCH INPUT - AREA TRAVERSAL END
            } //WHILE AREA_1 CLEARED END
          ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
          ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////   
          /////////////////////////////AREA 2 CREATION///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
               int area2_L;
               Area area2 = new Area(0, null, null);
               area2_L = rand.nextInt(3) + 5;
               System.out.println(area2_L);
               area2.ensureExit();
               area2.ensureBoss();
               for(int i = 0; i<area2_L-1; i++)
               {
                   area2.addNode(rand.nextInt(3));
               }
               Area.listLength(area2);
               Area area2_pp = area2;
               Chest area2_chest = new Chest();
               Enemy a2_enemy = new Enemy(1, 1, 1, 1, 1, 1, 1, 1);
               a2_enemy.newEnemy2();
          /////////////////////////////AREA 2 CREATION////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
          ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
          ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
          
          while(area2_cleared == false)
          {
             System.out.println("\n\n\tYou some how find yourself in a forest like area. Massive vegatation and gigantic forest creatures are visable everywhere around you."
                     + "\n\tYou decide there really is no going back now, and continue to press on.");
             System.out.println("\n\t\tWhat would you like to do?");
                input = scan.nextLine();
                switch (input) {
                    case "help":
                        player.help();
                        break;
                    case "forward":
                        area2_pp = area2_pp.getForeLink();
                        System.out.println(area2_pp.getData());
                switch (area2_pp.getData()) {
                    case 0:
                        System.out.println("you move on, nothing eventful happens.");
                        break;
                    case 1:
                        a2_enemy.getEnemy2();
                        System.out.println("\n\n----------------------------F I G H T !!!----------------------------");
                        System.out.println("combat commands can be pulled up at any time by typing \"combat help\"");
                        OUTER:
                        while (true) {
                            System.out.println("\nWhat will you do " + player.name + "?");
                            input = scan.nextLine();
                            switch (input) {
                                //if(input.equals("ranged attack"))
                                //{
                                //
                                //}
                                case "attack":
                                    if (player.stats[2]>=a2_enemy.enemyStats[3]) {
                                        int dmgDealt = rand.nextInt(player.stats[1]);
                                        int EdmgDealt = rand.nextInt(a2_enemy.enemyStats[2]);
                                        System.out.println("The enemy has taken " + dmgDealt + " damage!");
                                        a2_enemy.enemyStats[1] -= dmgDealt;
                                        if (a2_enemy.enemyStats[1]<0) {
                                            System.out.println("ENEMY DEFEATED!!!");
                                            System.out.println("\n\n----------------------------ENEMY HAS BEEN Y E E T E D----------------------------\n\n");
                                            a2_enemy.newEnemy2();
                                            player.stats[0] = MAX_HEALTH;
                                            break OUTER;
                                        }
                                        System.out.println("The enemy does " + EdmgDealt + " damage back at you!");
                                        player.stats[0] -= EdmgDealt;
                                        if (player.stats[0]<0) {
                                            System.out.println("YOU DIED");
                                            System.out.println("\n\n----------------------------G A M E   O V E R----------------------------\n\n");
                                            area2_cleared = true;
                                            area3_cleared = true;
                                            area4_cleared = true;
                                            running = false;
                                            break OUTER;
                                        }
                                    }
                                    if (player.stats[2]<a2_enemy.enemyStats[3]) {
                                        int dmgDealt = rand.nextInt(player.stats[1]);
                                        int EdmgDealt = rand.nextInt(a2_enemy.enemyStats[2]);
                                        System.out.println("The enemy deals " + EdmgDealt + " damage to you!");
                                        player.stats[0] -= EdmgDealt;
                                        if (player.stats[0]<0) {
                                            System.out.println("YOU DIED");
                                            System.out.println("\n\n----------------------------G A M E   O V E R----------------------------\n\n");
                                            area2_cleared = true;
                                            area3_cleared = true;
                                            area4_cleared = true;
                                            running = false;
                                            break OUTER;
                                        }
                                        System.out.println("The enemy has taken " + dmgDealt + " damage!");
                                        a2_enemy.enemyStats[1] -= dmgDealt;
                                        if (a2_enemy.enemyStats[1]<0) {
                                            System.out.println("ENEMY DEFEATED!!!");
                                            System.out.println("\n\n----------------------------ENEMY HAS BEEN Y E E T E D----------------------------\n\n");
                                            a2_enemy.newEnemy2();
                                            player.stats[0] = MAX_HEALTH;
                                            break OUTER;
                                        }
                                    }
                                    break;
                                case "identify":
                                    if(player.stats[5]>=7)
                                    {
                                        System.out.println("\n\tyou take time to analyze your enemy\n\t...\n\tyou were able to identify their stats!");
                                        a2_enemy.showEnemyStats();
                                    }
                                    else
                                    {
                                        System.out.println("\n\tyou take time to analyze your enemy\n\t...\n\tyou fail to accurately tell their stats...");
                                    }
                                    break;
                                case "equipment":
                                    System.out.println(Arrays.toString(player.equipment));
                                    break;
                                case "bag":
                                    System.out.println(Arrays.toString(player.inventory));
                                    break;
                                case "stats":
                                    player.showStats();
                                    break;
                                case "combat help":
                                    player.combatHelp();
                                    break;
                                case "help":
                                    player.help();
                                    break;
                                default:
                                    System.out.println("enter a valid command (use \"combat help\" for a list of basic combat commands");
                                    break;
                            }//SWITCH INPUT - NORMAL COMBAT END
                        }//NORMAL COMBAT END
                        break;
                    case 2:
                        System.out.println("You found a chest! It contained: " + area1_chest.open());
                OUTER:
                while (true) {
                    System.out.println("\n\tWould you like to keep the item?");
                    System.out.println("\t\t 1. Yes");
                    System.out.println("\t\t 2. No");
                    input = scan.nextLine();
                    switch (input) {
                        case "1":
                            System.out.println("You yank the item from the chest!\nYou gained: " + area1_chest.open());
                            player.inventory = area1_chest.open().ADDinventory(player.inventory);
                            System.out.println(Arrays.toString(player.inventory));
                            area1_chest.newItem();
                            break OUTER;
                        case "2":
                            System.out.println("You decided to leave the item behind.");
                            area1_chest.newItem();
                            break OUTER;
                        default:
                            System.out.println("Please enter a valid option.");
                            break;
                    }
                } //CHEST END
                        break;
                    case 3:
                        Enemy bigBoi = new Enemy(100, 100, 100, 1, 1, 1, 1, 1);
                        System.out.println("\n\n----------------------------I T ' S   B O S S   T I M E   B O i S----------------------------");
                        System.out.println("combat commands can be pulled up at any time by typing \"combat help\"");
                OUTER:
                while (true) {
                    System.out.println("\nWhat will you do " + player.name + "?");
                    input = scan.nextLine();
                    switch (input) {
                        case "attack":
                            if (player.stats[2]>=bigBoi.enemyStats[3]) {
                                int dmgDealt = rand.nextInt(player.stats[1]);
                                int EdmgDealt = rand.nextInt(bigBoi.enemyStats[2]);
                                System.out.println("The enemy has taken " + dmgDealt + " damage!");
                                bigBoi.enemyStats[1] -= dmgDealt;
                                if (bigBoi.enemyStats[1]<0) {
                                    System.out.println("ENEMY DEFEATED!!!");
                                    System.out.println("\n\n----------------------------BOSS HAS BEEN Y E E T E D----------------------------\n\n");
                                    bigBoi.enemyStats[1] = 100;
                                    player.stats[0] = MAX_HEALTH;
                                    break OUTER;
                                }
                                System.out.println("The enemy does " + EdmgDealt + " damage back at you!");
                                player.stats[0] -= EdmgDealt;
                                if (player.stats[0]<0) {
                                    System.out.println("YOU DIED");
                                    System.out.println("\n\n----------------------------G A M E   O V E R----------------------------\n\n");
                                    area2_cleared = true;
                                    area3_cleared = true;
                                    area4_cleared = true;
                                    running = false;
                                    break OUTER;
                                }
                            }
                            if (player.stats[2]<bigBoi.enemyStats[3]) {
                                int dmgDealt = rand.nextInt(player.stats[1]);
                                int EdmgDealt = rand.nextInt(bigBoi.enemyStats[2]);
                                System.out.println("The enemy deals " + EdmgDealt + " damage to you!");
                                player.stats[0] -= EdmgDealt;
                                if (player.stats[0]<0) {
                                    System.out.println("YOU DIED");
                                    System.out.println("\n\n----------------------------G A M E   O V E R----------------------------\n\n");
                                    area2_cleared = true;
                                    area3_cleared = true;
                                    area4_cleared = true;
                                    running = false;
                                    break OUTER;
                                }
                                System.out.println("The enemy has taken " + dmgDealt + " damage!");
                                bigBoi.enemyStats[1] -= dmgDealt;
                                if (bigBoi.enemyStats[1]<0) {
                                    System.out.println("ENEMY DEFEATED!!!");
                                    System.out.println("\n\n----------------------------BOSS HAS BEEN Y E E T E D----------------------------\n\n");
                                    bigBoi.enemyStats[1] = 100;
                                    player.stats[0] = MAX_HEALTH;
                                    break OUTER;
                                }
                            }
                            break;
                        case "identify":
                            if(player.stats[5]>=7)
                            {
                                System.out.println("\n\tyou take time to analyze your enemy\n\t...\n\tyou were able to identify their stats!");
                                bigBoi.showEnemyStats();
                            }
                            else
                            {
                                System.out.println("\n\tyou take time to analyze your enemy\n\t...\n\tyou fail to accurately tell their stats...");
                            }
                            break;
                        case "equipment":
                            System.out.println(Arrays.toString(player.equipment));
                            break;
                        case "bag":
                            System.out.println(Arrays.toString(player.inventory));
                            break;
                        case "stats":
                            player.showStats();
                            break;
                        case "combat help":
                            player.combatHelp();
                            break;
                        case "help":
                            player.help();
                            break;
                        default:
                            System.out.println("enter a valid command (use \"combat help\" for a list of basic combat commands");
                            break;
                    } //SWITCH INPUT - BOSS FIGHT END
                } // BOSS FIGHT END
                        break;
                    case 4:
                        System.out.println("You have found the exit to the area! But alas... you only get deeper into this hell hole instead of having freedom");
                        area2_cleared = true;
                        break;
                    default:
                        break;
                } // AREA GET DATA END
                        break;
                    case "equipment":
                        System.out.println(Arrays.toString(player.equipment));
                        break;
                    case "bag":
                        System.out.println(Arrays.toString(player.inventory));
                        break;
                    case "stats":
                        player.showStats();
                        break;
                    default:
                        System.out.println("enter a valid command (use \"help\" for a list of basic commands)");
                        break;
                } //SWITCH INPUT - AREA TRAVERSAL END
          }//WHILE AREA_2 CLEARED END
          ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
          ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////   
          /////////////////////////////AREA 3 CREATION///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
               int area3_L;
               Area area3 = new Area(0, null, null);
               area3_L = rand.nextInt(3) + 5;
               System.out.println(area3_L);
               area3.ensureExit();
               area3.ensureBoss();
               for(int i = 0; i<area3_L-1; i++)
               {
                   area3.addNode(rand.nextInt(3));
               }
               Area.listLength(area3);
               Area area13_pp = area3;
               Chest area3_chest = new Chest();
               Enemy a3_enemy = new Enemy(1, 1, 1, 1, 1, 1, 1, 1);
               a3_enemy.newEnemy3();
          /////////////////////////////AREA 3 CREATION////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
          ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
          ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
          
          while(area3_cleared == false)
          {
             System.out.println("\n\n\tIt's very dark in these catacombs, and very sp00ky. This place smells worse than the first. Nonetheless, you continue"
                     + "\n\tto press forward, driven by what could possibly be at the end of all this devistation");
             System.out.println("\n\t\tWhat would you like to do?");
                input = scan.nextLine();
                switch (input) {
                    case "help":
                        player.help();
                        break;
                    case "forward":
                        area1_pp = area1_pp.getForeLink();
                        System.out.println(area1_pp.getData());
                switch (area1_pp.getData()) {
                    case 0:
                        System.out.println("you move on, nothing eventful happens.");
                        break;
                    case 1:
                        a3_enemy.getEnemy3();
                        System.out.println("\n\n----------------------------F I G H T !!!----------------------------");
                        System.out.println("combat commands can be pulled up at any time by typing \"combat help\"");
                        OUTER:
                        while (true) {
                            System.out.println("\nWhat will you do " + player.name + "?");
                            input = scan.nextLine();
                            switch (input) {
                                //if(input.equals("ranged attack"))
                                //{
                                //
                                //}
                                case "attack":
                                    if (player.stats[2]>=a3_enemy.enemyStats[3]) {
                                        int dmgDealt = rand.nextInt(player.stats[1]);
                                        int EdmgDealt = rand.nextInt(a3_enemy.enemyStats[2]);
                                        System.out.println("The enemy has taken " + dmgDealt + " damage!");
                                        a3_enemy.enemyStats[1] -= dmgDealt;
                                        if (a3_enemy.enemyStats[1]<0) {
                                            System.out.println("ENEMY DEFEATED!!!");
                                            System.out.println("\n\n----------------------------ENEMY HAS BEEN Y E E T E D----------------------------\n\n");
                                            a3_enemy.newEnemy3();
                                            player.stats[0] = MAX_HEALTH;
                                            break OUTER;
                                        }
                                        System.out.println("The enemy does " + EdmgDealt + " damage back at you!");
                                        player.stats[0] -= EdmgDealt;
                                        if (player.stats[0]<0) {
                                            System.out.println("YOU DIED");
                                            System.out.println("\n\n----------------------------G A M E   O V E R----------------------------\n\n");
                                            area3_cleared = true;
                                            area4_cleared = true;
                                            running = false;
                                            break OUTER;
                                        }
                                    }
                                    if (player.stats[2]<a3_enemy.enemyStats[3]) {
                                        int dmgDealt = rand.nextInt(player.stats[1]);
                                        int EdmgDealt = rand.nextInt(a3_enemy.enemyStats[2]);
                                        System.out.println("The enemy deals " + EdmgDealt + " damage to you!");
                                        player.stats[0] -= EdmgDealt;
                                        if (player.stats[0]<0) {
                                            System.out.println("YOU DIED");
                                            System.out.println("\n\n----------------------------G A M E   O V E R----------------------------\n\n");
                                            area3_cleared = true;
                                            area4_cleared = true;
                                            running = false;
                                            break OUTER;
                                        }
                                        System.out.println("The enemy has taken " + dmgDealt + " damage!");
                                        a3_enemy.enemyStats[1] -= dmgDealt;
                                        if (a3_enemy.enemyStats[1]<0) {
                                            System.out.println("ENEMY DEFEATED!!!");
                                            System.out.println("\n\n----------------------------ENEMY HAS BEEN Y E E T E D----------------------------\n\n");
                                            a3_enemy.newEnemy3();
                                            player.stats[0] = MAX_HEALTH;
                                            break OUTER;
                                        }
                                    }
                                    break;
                                case "identify":
                                    if(player.stats[5]>=7)
                                    {
                                        System.out.println("\n\tyou take time to analyze your enemy\n\t...\n\tyou were able to identify their stats!");
                                        a3_enemy.showEnemyStats();
                                    }
                                    else
                                    {
                                        System.out.println("\n\tyou take time to analyze your enemy\n\t...\n\tyou fail to accurately tell their stats...");
                                    }
                                    break;
                                case "equipment":
                                    System.out.println(Arrays.toString(player.equipment));
                                    break;
                                case "bag":
                                    System.out.println(Arrays.toString(player.inventory));
                                    break;
                                case "stats":
                                    player.showStats();
                                    break;
                                case "combat help":
                                    player.combatHelp();
                                    break;
                                case "help":
                                    player.help();
                                    break;
                                default:
                                    System.out.println("enter a valid command (use \"combat help\" for a list of basic combat commands");
                                    break;
                            }//SWITCH INPUT - NORMAL COMBAT END
                        }//NORMAL COMBAT END
                        break;
                    case 2:
                        System.out.println("You found a chest! It contained: " + area1_chest.open());
                OUTER:
                while (true) {
                    System.out.println("\n\tWould you like to keep the item?");
                    System.out.println("\t\t 1. Yes");
                    System.out.println("\t\t 2. No");
                    input = scan.nextLine();
                    switch (input) {
                        case "1":
                            System.out.println("You yank the item from the chest!\nYou gained: " + area1_chest.open());
                            player.inventory = area1_chest.open().ADDinventory(player.inventory);
                            System.out.println(Arrays.toString(player.inventory));
                            area1_chest.newItem();
                            break OUTER;
                        case "2":
                            System.out.println("You decided to leave the item behind.");
                            area1_chest.newItem();
                            break OUTER;
                        default:
                            System.out.println("Please enter a valid option.");
                            break;
                    }
                } //CHEST END
                        break;
                    case 3:
                        Enemy bigBoi = new Enemy(100, 100, 100, 1, 1, 1, 1, 1);
                        System.out.println("\n\n----------------------------I T ' S   B O S S   T I M E   B O i S----------------------------");
                        System.out.println("combat commands can be pulled up at any time by typing \"combat help\"");
                OUTER:
                while (true) {
                    System.out.println("\nWhat will you do " + player.name + "?");
                    input = scan.nextLine();
                    switch (input) {
                        case "attack":
                            if (player.stats[2]>=bigBoi.enemyStats[3]) {
                                int dmgDealt = rand.nextInt(player.stats[1]);
                                int EdmgDealt = rand.nextInt(bigBoi.enemyStats[2]);
                                System.out.println("The enemy has taken " + dmgDealt + " damage!");
                                bigBoi.enemyStats[1] -= dmgDealt;
                                if (bigBoi.enemyStats[1]<0) {
                                    System.out.println("ENEMY DEFEATED!!!");
                                    System.out.println("\n\n----------------------------BOSS HAS BEEN Y E E T E D----------------------------\n\n");
                                    bigBoi.enemyStats[1] = 100;
                                    player.stats[0] = MAX_HEALTH;
                                    break OUTER;
                                }
                                System.out.println("The enemy does " + EdmgDealt + " damage back at you!");
                                player.stats[0] -= EdmgDealt;
                                if (player.stats[0]<0) {
                                    System.out.println("YOU DIED");
                                    System.out.println("\n\n----------------------------G A M E   O V E R----------------------------\n\n");
                                    area3_cleared = true;
                                    area4_cleared = true;
                                    running = false;
                                    break OUTER;
                                }
                            }
                            if (player.stats[2]<bigBoi.enemyStats[3]) {
                                int dmgDealt = rand.nextInt(player.stats[1]);
                                int EdmgDealt = rand.nextInt(bigBoi.enemyStats[2]);
                                System.out.println("The enemy deals " + EdmgDealt + " damage to you!");
                                player.stats[0] -= EdmgDealt;
                                if (player.stats[0]<0) {
                                    System.out.println("YOU DIED");
                                    System.out.println("\n\n----------------------------G A M E   O V E R----------------------------\n\n");
                                    area3_cleared = true;
                                    area4_cleared = true;
                                    running = false;
                                    break OUTER;
                                }
                                System.out.println("The enemy has taken " + dmgDealt + " damage!");
                                bigBoi.enemyStats[1] -= dmgDealt;
                                if (bigBoi.enemyStats[1]<0) {
                                    System.out.println("ENEMY DEFEATED!!!");
                                    System.out.println("\n\n----------------------------BOSS HAS BEEN Y E E T E D----------------------------\n\n");
                                    bigBoi.enemyStats[1] = 100;
                                    player.stats[0] = MAX_HEALTH;
                                    break OUTER;
                                }
                            }
                            break;
                        case "identify":
                            if(player.stats[5]>=7)
                            {
                                System.out.println("\n\tyou take time to analyze your enemy\n\t...\n\tyou were able to identify their stats!");
                                bigBoi.showEnemyStats();
                            }
                            else
                            {
                                System.out.println("\n\tyou take time to analyze your enemy\n\t...\n\tyou fail to accurately tell their stats...");
                            }
                            break;
                        case "equipment":
                            System.out.println(Arrays.toString(player.equipment));
                            break;
                        case "bag":
                            System.out.println(Arrays.toString(player.inventory));
                            break;
                        case "stats":
                            player.showStats();
                            break;
                        case "combat help":
                            player.combatHelp();
                            break;
                        case "help":
                            player.help();
                            break;
                        default:
                            System.out.println("enter a valid command (use \"combat help\" for a list of basic combat commands");
                            break;
                    } //SWITCH INPUT - BOSS FIGHT END
                } // BOSS FIGHT END
                        break;
                    case 4:
                        System.out.println("You have found the exit to the area! But alas... you only get deeper into this hell hole instead of having freedom");
                        area3_cleared = true;
                        break;
                    default:
                        break;
                } // AREA GET DATA END
                        break;
                    case "equipment":
                        System.out.println(Arrays.toString(player.equipment));
                        break;
                    case "bag":
                        System.out.println(Arrays.toString(player.inventory));
                        break;
                    case "stats":
                        player.showStats();
                        break;
                    default:
                        System.out.println("enter a valid command (use \"help\" for a list of basic commands)");
                        break;
                } //SWITCH INPUT - AREA TRAVERSAL END
          }//WHILE AREA_3 CLEARED END
          ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
          ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////   
          /////////////////////////////AREA 4 CREATION///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
               int area4_L;
               Area area4 = new Area(0, null, null);
               area4_L = rand.nextInt(3) + 5;
               System.out.println(area4_L);
               area4.ensureExit();
               area4.ensureBoss();
               for(int i = 0; i<area4_L-1; i++)
               {
                   area4.addNode(rand.nextInt(3));
               }
               Area.listLength(area4);
               Area area14_pp = area4;
               Chest area4_chest = new Chest();
               Enemy a4_enemy = new Enemy(1, 1, 1, 1, 1, 1, 1, 1);
               a4_enemy.newEnemy4();
          /////////////////////////////AREA 4 CREATION////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
          ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
          ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
          
          while(area4_cleared == false)
          {
             System.out.println("\n\n\tYou've never seen anything like this place before. Massive floating landscapes amongst what seems like a never ending horizon"
                     + "\n\tVery dangerous looking enemies appear to roam these parts, each establishing its territory on the more bigger floating landscapes"
                     + "\n\tYou notice at the end of this floating trail there is a ginormous... very rediculos looking figure that appears to be... "
                     + "\n\twaiting for you(?) you'll just have to find out! You've made it this far (surprisingly), no giving up now!");
             System.out.println("\n\t\tWhat would you like to do?");
                input = scan.nextLine();
                switch (input) {
                    case "help":
                        player.help();
                        break;
                    case "forward":
                        area1_pp = area1_pp.getForeLink();
                        System.out.println(area1_pp.getData());
                switch (area1_pp.getData()) {
                    case 0:
                        System.out.println("you move on, nothing eventful happens.");
                        break;
                    case 1:
                        a4_enemy.getEnemy4();
                        System.out.println("\n\n----------------------------F I G H T !!!----------------------------");
                        System.out.println("combat commands can be pulled up at any time by typing \"combat help\"");
                        OUTER:
                        while (true) {
                            System.out.println("\nWhat will you do " + player.name + "?");
                            input = scan.nextLine();
                            switch (input) {
                                //if(input.equals("ranged attack"))
                                //{
                                //
                                //}
                                case "attack":
                                    if (player.stats[2]>=a4_enemy.enemyStats[3]) {
                                        int dmgDealt = rand.nextInt(player.stats[1]);
                                        int EdmgDealt = rand.nextInt(a4_enemy.enemyStats[2]);
                                        System.out.println("The enemy has taken " + dmgDealt + " damage!");
                                        a4_enemy.enemyStats[1] -= dmgDealt;
                                        if (a4_enemy.enemyStats[1]<0) {
                                            System.out.println("ENEMY DEFEATED!!!");
                                            System.out.println("\n\n----------------------------ENEMY HAS BEEN Y E E T E D----------------------------\n\n");
                                            a4_enemy.newEnemy4();
                                            player.stats[0] = MAX_HEALTH;
                                            break OUTER;
                                        }
                                        System.out.println("The enemy does " + EdmgDealt + " damage back at you!");
                                        player.stats[0] -= EdmgDealt;
                                        if (player.stats[0]<0) {
                                            System.out.println("YOU DIED");
                                            System.out.println("\n\n----------------------------G A M E   O V E R----------------------------\n\n");
                                            area4_cleared = true;
                                            running = false;
                                            break OUTER;
                                        }
                                    }
                                    if (player.stats[2]<a4_enemy.enemyStats[3]) {
                                        int dmgDealt = rand.nextInt(player.stats[1]);
                                        int EdmgDealt = rand.nextInt(a4_enemy.enemyStats[2]);
                                        System.out.println("The enemy deals " + EdmgDealt + " damage to you!");
                                        player.stats[0] -= EdmgDealt;
                                        if (player.stats[0]<0) {
                                            System.out.println("YOU DIED");
                                            System.out.println("\n\n----------------------------G A M E   O V E R----------------------------\n\n");
                                            area4_cleared = true;
                                            running = false;
                                            break OUTER;
                                        }
                                        System.out.println("The enemy has taken " + dmgDealt + " damage!");
                                        a4_enemy.enemyStats[1] -= dmgDealt;
                                        if (a4_enemy.enemyStats[1]<0) {
                                            System.out.println("ENEMY DEFEATED!!!");
                                            System.out.println("\n\n----------------------------ENEMY HAS BEEN Y E E T E D----------------------------\n\n");
                                            a4_enemy.newEnemy4();
                                            player.stats[0] = MAX_HEALTH;
                                            break OUTER;
                                        }
                                    }
                                    break;
                                case "identify":
                                    if(player.stats[5]>=7)
                                    {
                                        System.out.println("\n\tyou take time to analyze your enemy\n\t...\n\tyou were able to identify their stats!");
                                        a4_enemy.showEnemyStats();
                                    }
                                    else
                                    {
                                        System.out.println("\n\tyou take time to analyze your enemy\n\t...\n\tyou fail to accurately tell their stats...");
                                    }
                                    break;
                                case "equipment":
                                    System.out.println(Arrays.toString(player.equipment));
                                    break;
                                case "bag":
                                    System.out.println(Arrays.toString(player.inventory));
                                    break;
                                case "stats":
                                    player.showStats();
                                    break;
                                case "combat help":
                                    player.combatHelp();
                                    break;
                                case "help":
                                    player.help();
                                    break;
                                default:
                                    System.out.println("enter a valid command (use \"combat help\" for a list of basic combat commands");
                                    break;
                            }//SWITCH INPUT - NORMAL COMBAT END
                        }//NORMAL COMBAT END
                        break;
                    case 2:
                        System.out.println("You found a chest! It contained: " + area1_chest.open());
                OUTER:
                while (true) {
                    System.out.println("\n\tWould you like to keep the item?");
                    System.out.println("\t\t 1. Yes");
                    System.out.println("\t\t 2. No");
                    input = scan.nextLine();
                    switch (input) {
                        case "1":
                            System.out.println("You yank the item from the chest!\nYou gained: " + area1_chest.open());
                            player.inventory = area1_chest.open().ADDinventory(player.inventory);
                            System.out.println(Arrays.toString(player.inventory));
                            area1_chest.newItem();
                            break OUTER;
                        case "2":
                            System.out.println("You decided to leave the item behind.");
                            area1_chest.newItem();
                            break OUTER;
                        default:
                            System.out.println("Please enter a valid option.");
                            break;
                    }
                } //CHEST END
                        break;
                    case 3:
                        Enemy bigBoi = new Enemy(100, 100, 100, 1, 1, 1, 1, 1);
                        System.out.println("\n\n----------------------------I T ' S   B O S S   T I M E   B O i S----------------------------");
                        System.out.println("combat commands can be pulled up at any time by typing \"combat help\"");
                OUTER:
                while (true) {
                    System.out.println("\nWhat will you do " + player.name + "?");
                    input = scan.nextLine();
                    switch (input) {
                        case "attack":
                            if (player.stats[2]>=bigBoi.enemyStats[3]) {
                                int dmgDealt = rand.nextInt(player.stats[1]);
                                int EdmgDealt = rand.nextInt(bigBoi.enemyStats[2]);
                                System.out.println("The enemy has taken " + dmgDealt + " damage!");
                                bigBoi.enemyStats[1] -= dmgDealt;
                                if (bigBoi.enemyStats[1]<0) {
                                    System.out.println("ENEMY DEFEATED!!!");
                                    System.out.println("\n\n----------------------------BOSS HAS BEEN Y E E T E D----------------------------\n\n");
                                    bigBoi.enemyStats[1] = 100;
                                    player.stats[0] = MAX_HEALTH;
                                    break OUTER;
                                }
                                System.out.println("The enemy does " + EdmgDealt + " damage back at you!");
                                player.stats[0] -= EdmgDealt;
                                if (player.stats[0]<0) {
                                    System.out.println("YOU DIED");
                                    System.out.println("\n\n----------------------------G A M E   O V E R----------------------------\n\n");
                                    area4_cleared = true;
                                    running = false;
                                    break OUTER;
                                }
                            }
                            if (player.stats[2]<bigBoi.enemyStats[3]) {
                                int dmgDealt = rand.nextInt(player.stats[1]);
                                int EdmgDealt = rand.nextInt(bigBoi.enemyStats[2]);
                                System.out.println("The enemy deals " + EdmgDealt + " damage to you!");
                                player.stats[0] -= EdmgDealt;
                                if (player.stats[0]<0) {
                                    System.out.println("YOU DIED");
                                    System.out.println("\n\n----------------------------G A M E   O V E R----------------------------\n\n");
                                    area4_cleared = true;
                                    running = false;
                                    break OUTER;
                                }
                                System.out.println("The enemy has taken " + dmgDealt + " damage!");
                                bigBoi.enemyStats[1] -= dmgDealt;
                                if (bigBoi.enemyStats[1]<0) {
                                    System.out.println("ENEMY DEFEATED!!!");
                                    System.out.println("\n\n----------------------------BOSS HAS BEEN Y E E T E D----------------------------\n\n");
                                    bigBoi.enemyStats[1] = 100;
                                    player.stats[0] = MAX_HEALTH;
                                    break OUTER;
                                }
                            }
                            break;
                        case "identify":
                            if(player.stats[5]>=7)
                            {
                                System.out.println("\n\tyou take time to analyze your enemy\n\t...\n\tyou were able to identify their stats!");
                                bigBoi.showEnemyStats();
                            }
                            else
                            {
                                System.out.println("\n\tyou take time to analyze your enemy\n\t...\n\tyou fail to accurately tell their stats...");
                            }
                            break;
                        case "equipment":
                            System.out.println(Arrays.toString(player.equipment));
                            break;
                        case "bag":
                            System.out.println(Arrays.toString(player.inventory));
                            break;
                        case "stats":
                            player.showStats();
                            break;
                        case "combat help":
                            player.combatHelp();
                            break;
                        case "help":
                            player.help();
                            break;
                        default:
                            System.out.println("enter a valid command (use \"combat help\" for a list of basic combat commands");
                            break;
                    } //SWITCH INPUT - BOSS FIGHT END
                } // BOSS FIGHT END
                        break;
                    case 4:
                        System.out.println("You have found the exit to the area! But alas... you only get deeper into this hell hole instead of having freedom");
                        area4_cleared = true;
                        break;
                    default:
                        break;
                } // AREA GET DATA END
                        break;
                    case "equipment":
                        System.out.println(Arrays.toString(player.equipment));
                        break;
                    case "bag":
                        System.out.println(Arrays.toString(player.inventory));
                        break;
                    case "stats":
                        player.showStats();
                        break;
                    default:
                        System.out.println("enter a valid command (use \"help\" for a list of basic commands)");
                        break;
                } //SWITCH INPUT - AREA TRAVERSAL END
          }//WHILE AREA_4 CLEARED END 
          
      }//WHILE RUNNING LOOP END       

        
    }//MAIN END    
}//CLASS (HOD_GAME) END