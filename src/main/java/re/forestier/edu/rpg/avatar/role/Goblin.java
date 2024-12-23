package re.forestier.edu.rpg.avatar.role;

import re.forestier.edu.rpg.Constants;
import re.forestier.edu.rpg.Player;
import re.forestier.edu.rpg.avatar.AvatarInterface;

import java.util.Map;

public class Goblin implements AvatarInterface {

    @Override
    public String getName() {
        return Constants.GOBLIN;
    }

    @Override
    public Map<Integer, Map<String, Integer>> getAbilitiesPerLevel() {
        return Map.of(
            1, Map.of("ALC", 1, "INT", 2, "ATK", 2),
            2, Map.of("ATK", 3, "ALC", 4),
            3, Map.of("VIS", 1),
            4, Map.of("DEF", 1),
            5, Map.of("DEF", 2, "ATK", 4)
        );
    }

    @Override
    public void applyHealthBonus(Player player) {
        // nothing for the moment by ICHOU Abdelali
        AvatarInterface.super.applyHealthBonus(player);
    }
}
