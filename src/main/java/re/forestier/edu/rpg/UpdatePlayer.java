package re.forestier.edu.rpg;

import re.forestier.edu.rpg.object.ObjectList;
import re.forestier.edu.rpg.object.RPG;

import java.util.Map;
public class UpdatePlayer {

    private static void giveRandomObject(Player player) {
        RPG object = ObjectList.getRandomObject(player.getFreeWeight());
        player.addObject(object.getName());
    }
    
    public static boolean addXp(Player player, int xp) {
        int currentLevel = player.retrieveLevel();
        player.xp += xp;
        int newLevel = player.retrieveLevel();

        if (newLevel != currentLevel) {
            giveRandomObject(player);
            updateAbilities(player, newLevel); 

            return true;
        }
        return false;
    }

    private static void updateAbilities(Player player, int level) {
        Map<String, Integer> newAbilities = player.avatarClass.getAbilitiesPerLevel().get(level);
        newAbilities.forEach(player.abilities::put);
    }

    public static void majFinDeTour(Player player) {

        if (player.currentHealthPoints == 0) {
            System.out.println(Constants.PLAYER_KO);
            return;
        }
    
        if (player.currentHealthPoints < player.healthPoints / 2) {
            player.getAvatarClassObject().applyHealthBonus(player);
        }
    }

    public static void removeMoney(Player player, int amount) {
        if (player.money < amount) {
            throw new IllegalArgumentException(Constants.NEGATIVE_MONEY_EXCEPTION);
        }
        player.money -= amount;
    }

    public static void addMoney(Player player,int amount) {
        player.money += amount;
    }
}