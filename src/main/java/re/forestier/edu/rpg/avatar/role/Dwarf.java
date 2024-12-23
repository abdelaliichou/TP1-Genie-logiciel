package re.forestier.edu.rpg.avatar.role;

import re.forestier.edu.rpg.Constants;
import re.forestier.edu.rpg.Player;
import re.forestier.edu.rpg.avatar.AvatarInterface;
import java.util.Map;
public class Dwarf implements AvatarInterface {

    @Override
    public String getName() {
        return Constants.DWARF;
    }

    @Override
    public Map<Integer, Map<String, Integer>> getAbilitiesPerLevel() {
        return Map.of(
            1, Map.of("ALC", 4, "INT", 1, "ATK", 3),
            2, Map.of("DEF", 1, "ALC", 5),
            3, Map.of("ATK", 4),
            4, Map.of("DEF", 2),
            5, Map.of("CHA", 1)
        );
    }

    @Override
    public void applyHealthBonus(Player player) {
        int points = player.getCurrentHealthPoints();
        if(player.getInventory().contains(Constants.HOLY_ELIXIR)) points += 1;
        points += 1;
        player.setCurrentHealthPoints(points);
    }
}
