
package hod_game;

import java.util.Arrays;


public class Items<E>
{ 
   public String name;
   private int type; //type 1 = weapon, type 2 = armor, type 3 = consumable
   private int ADD_hp, ADD_str, ADD_dex, ADD_con, ADD_int, ADD_wis, ADD_cha, SUB_hp, SUB_str, SUB_dex, SUB_con, SUB_int, SUB_wis, SUB_cha;
   private int[] ADDstats = new int[]{ADD_hp, ADD_str, ADD_dex, ADD_con, ADD_int, ADD_wis, ADD_cha};
   private int[] SUBstats = new int[]{SUB_hp, SUB_str, SUB_dex, SUB_con, SUB_int, SUB_wis, SUB_cha};
  public Items(String Iname, int Ahp, int Astr, int Adex, int Acon, int Aint, int Awis, int Acha, int Shp, int Sstr, int Sdex, int Scon, int Sint, int Swis, int Scha , int Itype)
  {
      name = Iname;
      type = Itype;
      ADD_hp = Ahp;
      ADD_str = Astr;
      ADD_dex = Adex;
      ADD_con = Acon;
      ADD_int = Aint;
      ADD_wis = Awis;
      ADD_cha = Acha;
      SUB_hp = Shp;
      SUB_str = Sstr;
      SUB_dex = Sdex;
      SUB_con = Scon;
      SUB_int = Sint;
      SUB_wis = Swis;
      SUB_cha = Scha;
      
  }   
  public void getName()
  {
      System.out.println(name);
  }
  public void getType()
  {
      if(type == 1)
          System.out.println("weapon");
      if(type == 2)
          System.out.println("ranged weapon");
      if(type == 3)
          System.out.println("armor");
      if(type == 4)
          System.out.println("consumable");
  }
  public int[] ADDstats(int[] stats)
  {
     
     if(type == 1 || type == 2)
     {
        int[] new_stats = new int[]{stats[0], stats[1]+ADD_str-SUB_str, stats[2]+ADD_dex-SUB_dex, stats[3]+ADD_con-SUB_con, stats[4]+ADD_int-SUB_int, stats[5]+ADD_wis-SUB_wis, stats[6]+ADD_cha-SUB_cha};  
        return new_stats;
     }
     else
     {
         int[] new_stats = new int[]{stats[0]+ADD_hp-SUB_hp, stats[1]+ADD_str-SUB_str, stats[2]+ADD_dex-SUB_dex, stats[3]+ADD_con-SUB_con, stats[4]+ADD_int-SUB_int, stats[5]+ADD_wis-SUB_wis, stats[6]+ADD_cha-SUB_cha};
         return new_stats;
     }
  }
  public E[] ADDequipment(E[] equipment) //
  {
      int full_slots = 0;
      E[] new_equipment = (E[]) new Object[equipment.length];   //create new object array to replace old (passed)
      
       System.arraycopy(equipment, 0, new_equipment, 0, new_equipment.length);  //make new array copy of old (passed) array (return passed array if array not null)
       
       for(int y = 0; y<new_equipment.length; y++)  //loop checks to see if equipment is already "full"
       {
           if(new_equipment[y]!=null)
           full_slots++;
       }
       
      if(full_slots==new_equipment.length-1)
      {
          System.out.println("\n\tYour equipment is full! cannot equip any more items!");
          return equipment;
      }
      
      for(int z = 0; z<new_equipment.length; z++)
      {
          if(new_equipment[z] == null)
          {
              new_equipment[z] = (E) this;
              break;
          }
          
      }
      //System.out.println(Arrays.toString(new_equipment));
      return new_equipment;
  }
  public E[] ADDinventory(E[] inventory)//
  {
      int full_slots = 0;
      E[] new_inventory = (E[]) new Items[inventory.length];   //create new object array to replace old (passed)
      
       System.arraycopy(inventory, 0, new_inventory, 0, new_inventory.length);  //make new array copy of old (passed) array (return passed array if array not null)
       
       for(int y = 0; y<new_inventory.length; y++)  //loop checks to see if inventory is already "full"
       {
           if(new_inventory[y]!=null)
           full_slots++;
       }
       
      if(full_slots==new_inventory.length-1)
      {
          System.out.println("\n\tYour inventory is full! You cannot carry any more items!");
          return inventory;
      }
      
      for(int z = 0; z<new_inventory.length; z++)
      {
          if(new_inventory[z] == null)
          {
              new_inventory[z] = (E) this;
              break;
          }
          
      }
      //System.out.println(Arrays.toString(new_inventory));
      return new_inventory;
  }
  public E[] swapInventory(E[] inventory, Items item) //command 
  {
      E[] new_inventory = (E[]) new Items[inventory.length];   //create new object array to replace old (passed)
      
      System.arraycopy(inventory, 0, new_inventory, 0, new_inventory.length);
      int temp = 0;
      for(int i = 0; i < new_inventory.length; i++)
      {
          if(new_inventory[i].equals(item))
          {
              new_inventory[i] = (E) this;
              break;
          }
      }
      return new_inventory;
    }
  public E[] dropInventory(E[] inventory) //command "drop"
  {
      E[] new_inventory = (E[]) new Items[inventory.length];   //create new object array to replace old (passed)
      
      System.arraycopy(inventory, 0, new_inventory, 0, new_inventory.length);
      
      for(int i = 0; i < new_inventory.length; i++)
      {
          if(new_inventory[i].equals(this))
          {
              new_inventory[i] = null;
              break;
          }
          
      }
      return new_inventory;
  }
  public E[] dropEquipment(E[] equipment) //command "drop"
  {
      E[] new_equipment = (E[]) new Items[equipment.length];   //create new object array to replace old (passed)
      
      System.arraycopy(equipment, 0, new_equipment, 0, new_equipment.length);
      
      for(int i = 0; i < new_equipment.length; i++)
      {
          if(new_equipment[i].equals(this))
          {
              new_equipment[i] = null;
              break;
          }
          
      }
      return new_equipment;
  }
  public Object[][] equip(E[] inventory, E[] equipment) //command "equip (item name)"
  {
      int temp = 0;
      E[] new_inventory = (E[]) new Items[inventory.length];
      System.arraycopy(inventory, 0, new_inventory, 0, new_inventory.length);
      E[] new_equipment = (E[]) new Object[equipment.length];
      System.arraycopy(equipment, 0, new_equipment, 0, new_equipment.length);
       for(int i = 0; i < new_inventory.length; i++){
          if(new_inventory[i].equals(this)) {
               temp++;
               break;
           }
       }
      if(temp > 0){
          new_inventory = this.dropInventory(inventory);
          new_equipment = this.ADDequipment(equipment);
          return new Object[][]{new_inventory, new_equipment};
      }
      else{
          return new Object[][]{inventory, equipment};
      }
  }
  public Object[][] unequip(E[] inventory, E[] equipment) //command "unequip (item name)"
  {
      int temp = 0;
      E[] new_inventory = (E[]) new Items[inventory.length];
      System.arraycopy(inventory, 0, new_inventory, 0, new_inventory.length);
      E[] new_equipment = (E[]) new Object[equipment.length];
      System.arraycopy(equipment, 0, new_equipment, 0, new_equipment.length);
       for(int i = 0; i < new_equipment.length; i++){
          if(new_equipment[i].equals(this)) {
               temp++;
               break;
           }
       }
      if(temp > 0){
          new_equipment = this.dropEquipment(equipment);
          new_inventory = this.ADDinventory(inventory);
          return new Object[][]{new_inventory, new_equipment};
      }
      else{
          return new Object[][]{inventory, equipment};
      }
  }
  public boolean containedIn(E[] array) //
  {
    for(int i = 0; i < array.length; i++){
        if(array[i].equals(this)) {
            return true;
        }
    }
    return false;
  }
    @Override
    public boolean equals(Object object) 
    {
        if(object instanceof Items) {
            Items i = (Items) object;
            return this.name.equals(i.name);
        }
        return false;
    }
    @Override
   public String toString() 
   {
       if (this != null)
           return (this.name);
       else
           return "Empty";
   }
   public boolean typeCheckRanged(int itemType)
   {
       if(itemType == 2)
           return true;
       else
       {
           System.out.println("this isn't a ranged weapon... dummy");
           return false;
       }
   }
   public boolean typeCheckComsumable(int itemType)
   {
       if(itemType == 3)
           return true;
       else
       {
           System.out.println("this isn't a consumable... dummy");
           return false;
       }
   }
}