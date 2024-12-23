package re.forestier.edu.rpg.avatar;

import re.forestier.edu.rpg.Constants;
import re.forestier.edu.rpg.avatar.role.Adventurer;
import re.forestier.edu.rpg.avatar.role.Archer;
import re.forestier.edu.rpg.avatar.role.Dwarf;
import re.forestier.edu.rpg.avatar.role.Goblin;
import re.forestier.edu.rpg.exception.UnknownAvatarException;

import java.util.Map;

public class AvatarFactory {
    
    private static final Map<String, AvatarInterface> classMap = Map.of(
            Constants.ADVENTURER, new Adventurer(),
            Constants.ARCHER, new Archer(),
            Constants.DWARF, new Dwarf(),
            Constants.GOBLIN, new Goblin()
    );

    public static AvatarInterface getAvatarClass(String className) {
        if (!classMap.containsKey(className))
            throw new UnknownAvatarException("Avatar class '" + className +"' is unknown");
        return classMap.get(className);
    }
}