/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Adrian
 */
import java.util.*;

/**
 *
 * @author Connor Solu
 */
public class Character {
    int lvl, health, exp, inv;
    String name, gameClass;
    int[] stats;
    public Character(){
        this.lvl = 0;
        this.health = 100;
        this.exp = 0;
        this.inv = 8;
    }
    public int getCurrLevel(){
        return this.lvl;
    }
    public int getCurrHealth(){
        return this.health;
    }
    public int getCurrExp(){
        return this.exp;
    }
    public int getCurrInv(){
        return this.inv;
    }
    public void loseHealth(int loss){
        this.health = health - loss;
        if (this.health <= 0){   //Checking if character is dead
            System.out.println("You Have Died.");
            System.exit(0);
        }
    }
    public void gainHealth(int gain){
        this.health = health + gain;
        if (this.health > 100)   //Limiting health to 100
            this.health = 100;
    }
    public void gainExp(int gain){
        this.exp = exp + gain;
        if (this.exp >= 100){   //Checking if a level up is in order
            this.exp = exp - 100;
            this.lvl++;
        }
    }
    public void useInvSlot(){
        this.inv = inv - 1;
        if (inv == 0)
            System.out.println("Inventory is full.");
    }
    public void getDifficulty(){
        Scanner sc = new Scanner(System.in);
        //Choosing difficulty
        System.out.println("What difficulty would you like to play?");
        System.out.println("  Easy, Normal, Hard, or Very Hard?");
        System.out.println("  (This just changes your character's starting level)");
        System.out.println("Type Below:");
        while (lvl == 0){   //Ensuring that a correct choice is entered
            String dif = sc.nextLine();
            if (dif.equalsIgnoreCase("Easy"))
                lvl = 15;
            else if (dif.equalsIgnoreCase("Normal"))
                lvl = 10;
            else if (dif.equalsIgnoreCase("Hard"))
                lvl = 5;
            else if (dif.equalsIgnoreCase("Very Hard"))
                lvl = 1;
            else
                System.out.println("Please enter a valid difficulty:");
        }
    }
    public void getName(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the name of your character: ");
        this.name = sc.nextLine();
    }
    public void getCharClass(){
        String c;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter which class you would like to play: ");
        System.out.println("  Knight, Cleric, Ranger, Sorcerer");
        c = sc.nextLine();
        while(true){
            if (c.equalsIgnoreCase("Knight")){
                System.out.println();
                System.out.println("You chose to be a Knight!");
                break;
            }
            if (c.equalsIgnoreCase("Cleric")){
                System.out.println();
                System.out.println("You chose to be a Cleric!");
                break;
            }
            if (c.equalsIgnoreCase("Ranger")){
                System.out.println();
                System.out.println("You chose to be a Ranger!");
                break;
            }
            if (c.equalsIgnoreCase("Sorcerer")){
                System.out.println();
                System.out.println("You chose to be a Sorcerer!");
                break;
            }
            else{
                System.out.println("Please choose a valid class: ");
                c = sc.nextLine();
            }
        }
        this.gameClass = c;
    }
    public void getStats(){
        Scanner sc = new Scanner(System.in);
        int str, dex, con, intel, wis, cha;
        int one = new Random().nextInt(14) + 7;
        int two = new Random().nextInt(14) + 7;
        if (two == one){
            while (two == one)
                two = new Random().nextInt(14) + 7;
        }    
        int three = new Random().nextInt(14) + 7;
        if (three == two || three == one){
            while (three == two || three == one)
                three = new Random().nextInt(14) + 7;
        }    
        int four = new Random().nextInt(14) + 7;
        if (four == three || four == two || four == one){
            while (four == three || four == two || four == one)
                four = new Random().nextInt(14) + 7;
        }   
        int five = new Random().nextInt(14) + 7;
        if (five == four || five == three || five == two || five == one){
            while (five == four || five == three || five == two || five == one)
                five = new Random().nextInt(14) + 7;
        }
        int six = new Random().nextInt(14) + 7;
        if (six == five || six == four || six == three || six == two || six == one){
            while (six == five || six == four || six == three || six == two || six == one)
                six = new Random().nextInt(14) + 7;
        }
        System.out.println("Please assign the following randomly generated numbers to the following stats:");
        System.out.println(one + ", " + two + ", " + three + ", " + four + ", " + five + ", " + six);
        System.out.println();
        System.out.println("Choose the number you want your Strength stat to be:");
        str = sc.nextInt();
        while(true){
            if(str == one){
                System.out.println("Strength: " + one);
                break;
            }
            if(str == two){
                System.out.println("Strength: " + two);
                break;
            }
            if(str == three){
                System.out.println("Strength: " + three);
                break;
            }
            if(str == four){
                System.out.println("Strength: " + four);
                break;
            }
            if(str == five){
                System.out.println("Strength: " + five);
                break;
            }
            if(str == six){
                System.out.println("Strength: " + six);
                break;
            }
            else{
                System.out.println("Please choose a valid number: ");
                str = sc.nextInt();
            }
        }
        System.out.println("Choose the number you want your Dexterity stat to be:");
        dex = sc.nextInt();
        if(dex == str){
            System.out.println("You already chose that number.");
            while(dex == str){
                System.out.println("Please choose another number: ");
                dex = sc.nextInt();
            }
        }
        while(true){
            if(dex == one){
                System.out.println("Dexterity: " + one);
                break;
            }
            if(dex == two){
                System.out.println("Dexterity: " + two);
                break;
            }
            if(dex == three){
                System.out.println("Dexterity: " + three);
                break;
            }
            if(dex == four){
                System.out.println("Dexterity: " + four);
                break;
            }
            if(dex == five){
                System.out.println("Dexterity: " + five);
                break;
            }
            if(dex == six){
                System.out.println("Dexterity: " + six);
                break;
            }
            else{
                System.out.println("Please choose a valid number: ");
                dex = sc.nextInt();
            }
        }
        System.out.println("Choose the number you want your Constitution stat to be:");
        con = sc.nextInt();
        if(con == dex || con == str){
            System.out.println("You already chose that number.");
            while(con == dex || con == str){
                System.out.println("Please choose another number: ");
                con = sc.nextInt();
            }
        }
        while(true){
            if(con == one){
                System.out.println("Constitution: " + one);
                break;
            }
            if(con == two){
                System.out.println("Constitution: " + two);
                break;
            }
            if(con == three){
                System.out.println("Constitution: " + three);
                break;
            }
            if(con == four){
                System.out.println("Constitution: " + four);
                break;
            }
            if(con == five){
                System.out.println("Constitution: " + five);
                break;
            }
            if(con == six){
                System.out.println("Constitution: " + six);
                break;
            }
            else{
                System.out.println("Please choose a valid number: ");
                con = sc.nextInt();
            }
        }
        System.out.println("Choose the number you want your Intelligence stat to be:");
        intel = sc.nextInt();
        if(intel == con || intel == dex || intel == str){
            System.out.println("You already chose that number.");
            while(intel == con || intel == dex || intel == str){
                System.out.println("Please choose another number: ");
                intel = sc.nextInt();
            }
        }
        while(true){
            if(intel == one){
                System.out.println("Intelligence: " + one);
                break;
            }
            if(intel == two){
                System.out.println("Intelligence: " + two);
                break;
            }
            if(intel == three){
                System.out.println("Intelligence: " + three);
                break;
            }
            if(intel == four){
                System.out.println("Intelligence: " + four);
                break;
            }
            if(intel == five){
                System.out.println("Intelligence: " + five);
                break;
            }
            if(intel == six){
                System.out.println("Intelligence: " + six);
                break;
            }
            else{
                System.out.println("Please choose a valid number: ");
                intel = sc.nextInt();
            }
        }
        System.out.println("Choose the number you want your Wisdom stat to be:");
        wis = sc.nextInt();
        if(wis == intel || wis == con || wis == dex || wis == str){
            System.out.println("You already chose that number.");
            while(wis == intel || wis == con || wis == dex || wis == str){
                System.out.println("Please choose another number: ");
                wis = sc.nextInt();
            }
        }
        while(true){
            if(wis == one){
                System.out.println("Wisdom: " + one);
                break;
            }
            if(wis == two){
                System.out.println("Wisdom: " + two);
                break;
            }
            if(wis == three){
                System.out.println("Wisdom: " + three);
                break;
            }
            if(wis == four){
                System.out.println("Wisdom: " + four);
                break;
            }
            if(wis == five){
                System.out.println("Wisdom: " + five);
                break;
            }
            if(wis == six){
                System.out.println("Wisdom: " + six);
                break;
            }
            else{
                System.out.println("Please choose a valid number: ");
                wis = sc.nextInt();
            }
        }
        if (str != one && dex != one && con != one && intel != one && wis != one)
            cha = one;
        else if (str != two && dex != two && con != two && intel != two && wis != two)
            cha = two;
        else if (str != three && dex != three && con != three && intel != three && wis != three)
            cha = three;
        else if (str != four && dex != four && con != four && intel != four && wis != four)
            cha = four;
        else if (str != five && dex != five && con != five && intel != five && wis != five)
            cha = five;
        else
            cha = six;
        System.out.println("Therefore, Charisma is assigned the last number.");
        System.out.println("Charisma: " + cha);
        this.stats = new int[]{str, dex, con, intel, wis, cha};
    }
}
