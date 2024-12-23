package re.forestier.edu.rpg;

import re.forestier.edu.rpg.avatar.AvatarInterface;
import re.forestier.edu.rpg.avatar.AvatarFactory;
import re.forestier.edu.rpg.exception.NoFreeWeightException;
import re.forestier.edu.rpg.exception.NoMoneyException;
import re.forestier.edu.rpg.exception.ObjectNotFoundException;
import re.forestier.edu.rpg.object.Inventory;
import re.forestier.edu.rpg.object.ObjectList;
import re.forestier.edu.rpg.object.RPG;

import java.util.ArrayList;
import java.util.HashMap;

public class Player {
    protected String playerName;
    protected String avatarName;
    protected AvatarInterface avatarClass;

    protected Integer money;

    protected int maxWeight;
    protected int healthPoints;
    protected int currentHealthPoints;
    protected int xp;

    protected HashMap<String, Integer> abilities;
    protected Inventory inventory;

    public Player(String playerName, String avatarName, String avatarClassName, int money, ArrayList<String> inventory, int maxWeight) {

        this.playerName = playerName;
        this.avatarName = avatarName;
        this.avatarClass = AvatarFactory.getAvatarClass(avatarClassName);
        this.money = money;
        this.maxWeight = maxWeight;
        this.inventory = new Inventory(inventory, maxWeight);
        this.abilities = new HashMap<>(avatarClass.getAbilitiesPerLevel().get(1));
        this.healthPoints = 0;
        this.currentHealthPoints = 0;
    }
    
    public int retrieveLevel() {
        int level = 2;      
        int previousLvlXp = 0;

        while (true) {
            previousLvlXp = (level - 1) * 10 + (level * previousLvlXp) / 4;

            if (xp < previousLvlXp) {
                return level-1;  
            }
            level++;
        }
    }

    public AvatarInterface getAvatarClassObject() {
        return avatarClass;
    }

    public String getAvatarClass() {
        return avatarClass.getName();
    }

    public String getAvatarName() {
        return avatarName;
    }

    public int getXp() {
        return this.xp;
    }

    public String getPlayerName() {
        return playerName;
    }

    public Integer getMoney() {
        return money;
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public void setHealthPoints(int points) {
        healthPoints = points;
    }

    public int getCurrentHealthPoints() {
        return currentHealthPoints;
    }

    public void setCurrentHealthPoints(int points) {
        currentHealthPoints = points > healthPoints ? healthPoints : points;
    }

    public HashMap<String, Integer> getAbilities() {
        return abilities;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public int getMaxWeight() {
        return maxWeight;
    }

    public int getFreeWeight(){
        return maxWeight - inventory.getTotalWeight();
    }

    public void addObject(String name) {
        inventory.addObject(name, getFreeWeight());
    }

    public void clearInventory(){
        inventory.clear();
    }

    public void sellObject(String name, Player buyer) {

        RPG objectToSell = getSellingObject(name,buyer);

        UpdatePlayer.removeMoney(buyer, objectToSell.getValue());
        money+=objectToSell.getValue();
        buyer.addObject(name);
        inventory.remove(name);
    }

    private RPG getSellingObject(String name, Player buyer){
        if (!inventory.contains(name))
            throw new ObjectNotFoundException("Player doesn't own '" + name + "'");

        RPG objectToSell = ObjectList.getObject(name);
        if (buyer.getMoney() < objectToSell.getValue()) 
            throw new NoMoneyException(Constants.MONEY_EXCEPTION);

        if (buyer.getFreeWeight() < objectToSell.getWeight()) 
            throw new NoFreeWeightException(Constants.WEIGHT_EXCEPTION);

        return objectToSell;
    }
}