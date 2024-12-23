package re.forestier.edu.rpg.avatar.role;

import re.forestier.edu.rpg.Constants;
import re.forestier.edu.rpg.Player;
import re.forestier.edu.rpg.avatar.AvatarInterface;

import java.util.Map;

public class Archer implements AvatarInterface {

    @Override
    public String getName() {
        return Constants.ARCHER;
    }

    @Override
    public Map<Integer, Map<String, Integer>> getAbilitiesPerLevel() {
        return Map.of(
            1, Map.of("INT", 1, "ATK", 3, "CHA", 1, "VIS", 3),
            2, Map.of("DEF", 1, "CHA", 2),
            3, Map.of("ATK", 3),
            4, Map.of("DEF", 2),
            5, Map.of("ATK", 4)
        );
    }

    @Override
    public  void applyHealthBonus(Player player) {
        int points = player.getCurrentHealthPoints();
        points += 1;
        if(player.getInventory().contains(Constants.MAGIC_BOW)) points += (points / 8) - 1;
        player.setCurrentHealthPoints(points);
    }
}
