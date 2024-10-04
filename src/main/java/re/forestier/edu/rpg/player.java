package re.forestier.edu.rpg;

import java.util.ArrayList;
import java.util.HashMap;

public class player {
    public String playerName;
    public String Avatar_name;
    private String AvatarClass;

    public Integer money;

    public int healthpoints;
    public int currenthealthpoints;
    protected int xp;

    private final int LEVEL1 = 10;
    private final int LEVEL2 = 27;
    private final int LEVEL3 = 57;
    private final int LEVEL4 = 111;

    protected HashMap<Integer, Integer> levels = new HashMap<>();
    public HashMap<String, Integer> abilities;
    public ArrayList<String> inventory;


    public player(String playerName, String avatar_name, String avatarClass, int money, ArrayList<String> inventory) {
        if (!avatarClass.equals("ARCHER") && !avatarClass.equals("ADVENTURER") && !avatarClass.equals("DWARF") ) {
            return;
        }

        this.playerName = playerName;
        Avatar_name = avatar_name;
        AvatarClass = avatarClass;
        this.money = Integer.valueOf(money);
        this.inventory = inventory;
        this.abilities = UpdatePlayer.abilitiesPerTypeAndLevel().get(AvatarClass).get(1);

        // setting levels her instead of inside the retrieveLevel function
        settingLevels();

    }

    public void removeMoney(int amount) throws IllegalArgumentException {
        if (amount > money) throw new IllegalArgumentException("Player can't have a negative money!");
        money = money - amount;
    }

    public void addMoney(int amount) {
        if (Integer.valueOf(amount) != null) money += amount;
    }

    private void settingLevels(){
        // (lvl-1) * 10 + round((lvl * xplvl-1)/4)
        levels.put(2,10); // 1*10 + ((2*0)/4)
        levels.put(3,27); // 2*10 + ((3*10)/4)
        levels.put(4,57); // 3*10 + ((4*27)/4)
        levels.put(5,111); // 4*10 + ((5*57)/4)
    }

    public int retrieveLevel() {
        return niveau();
    }

    private int niveau(){
        if (xp < LEVEL1) return 1;
        if (xp < LEVEL2) return 2;
        if (xp < LEVEL3) return 3;
        if (xp < LEVEL4) return 4;
        return 5;
    }

    public String getAvatarClass () {
        return AvatarClass;
    }

    public int getXp() {
        return this.xp;
    }

    /*
    Ингредиенты:
        Для теста:

            250 г муки
            125 г сливочного масла (холодное)
            70 г сахара
            1 яйцо
            1 щепотка соли
     */

}