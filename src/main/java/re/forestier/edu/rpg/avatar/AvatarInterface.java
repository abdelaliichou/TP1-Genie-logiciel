package re.forestier.edu.rpg.avatar;

import re.forestier.edu.rpg.Player;

import java.util.Map;

public interface AvatarInterface {
    String getName();
    Map <Integer, Map<String, Integer>> getAbilitiesPerLevel();
    default void applyHealthBonus(Player player){};
}
