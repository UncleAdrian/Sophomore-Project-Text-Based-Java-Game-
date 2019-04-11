package hod_game;

import java.util.*;

public class Skills {
    public String name;
    public int hp, dmg;
    public boolean uses;
    public Skills(String iname, int idmg, int ihp, boolean iuses){
        name = iname;
        dmg = idmg;
        hp = ihp;
        uses = iuses;
    }
    public String getName(){
      return name;
    }
    public boolean getUses(){
        return uses;
    }
    public int use(int[] stats){
        if(uses == true){
            if(name.equalsIgnoreCase("Dash Attack")){  //For Knight
                int totaldmg = (new Random().nextInt(dmg) + 1) + (new Random().nextInt(dmg) + 1) + (new Random().nextInt(dmg) + 1) + (new Random().nextInt(stats[1] + 1));
                this.uses = false;
                return totaldmg;  //Does a random amount of damage = 3 * Random numbers (0 < random <= dmg)
            }
            if(name.equalsIgnoreCase("Rapid Fire")){  //For Ranger
                int totaldmg = (new Random().nextInt(dmg) + 1) + (new Random().nextInt(dmg) + 1) + (new Random().nextInt(dmg) + 1) + (new Random().nextInt(dmg) + 1) + (new Random().nextInt(dmg) + 1) + (new Random().nextInt(stats[2] + 1));
                this.uses = false;
                return totaldmg;  //Does a random amount of damage = 5 * Random numbers (0 < random <= dmg)
            }
            if (name.equalsIgnoreCase("Blessing")){  //For Cleric
                int totalHP = hp + (new Random().nextInt(stats[3] + 1));
                this.uses = false;
                return totalHP;  //Allows PC to heal self htlh amount
            }
            if(name.equalsIgnoreCase("Firebolt")){  //For Sorcerer
                int totaldmg = dmg + (new Random().nextInt(dmg) + 1) + (new Random().nextInt(stats[4] + 1));
                this.uses = false;
                return totaldmg;  //Does dmg + Random number (0 < random <= dmg) damage
            }
            else
                return 0;
        }
        else
            return 0;
    }
    public void recharge(){  //Need to do this after every encounter to be able to use the skill again
        this.uses = true;
    }
    public String getSkillInfo(){
        if(name.equalsIgnoreCase("Dash Attack")){  //For Knight
                String s = "DASH ATTACK - Does a random amount of damage to the target. It is calculated by adding three randomly generated numbers that range from 1 to 15 and one randomly generated number capped by your Strength stat.";
                return s;
            }
            if(name.equalsIgnoreCase("Rapid Fire")){  //For Ranger
                String s = "RAPID FIRE - Does a random amount of damage to the target. It is calculated by adding five randomly generated numbers that range from 1 to 10 and one randomly generated number capped by your Dexterity stat.";
                return s;
            }
            if (name.equalsIgnoreCase("Blessing")){  //For Cleric
                String s = "BLESSING - Heals the player character for a random amount. It is calulated by adding 25 to one randomly generated number capped by your Constituation stat.";
                return s;
            }
            if(name.equalsIgnoreCase("Firebolt")){  //For Sorcerer
                String s = "FIREBOLT - Does a random amount of damage to the target. It is calculated by adding 20 to a randomly generated number that ranges from 1 to 20 and a randomly generated number capped by your Intelligence stat.";
                return s;
            }
            else
                return "Not a valid skill.";
    }
}