package re.forestier.edu.rpg.object;

import re.forestier.edu.rpg.Constants;

import java.util.*;

public class ObjectList {

    private static final Map<String, RPG> objectMap = new HashMap<>();

    static {
        objectMap.put(Constants.LOOKOUT_RING, new RPG( Constants.LOOKOUT_RING, "Prevents surprise attacks", 1, 50));
        objectMap.put(Constants.SCROLL_STUPIDITY, new RPG( Constants.SCROLL_STUPIDITY, "INT-2 when applied to an enemy", 0, 10));
        objectMap.put(Constants.DRAUPNIR, new RPG( Constants.DRAUPNIR, "Increases XP gained by 100%", 2, 100));
        objectMap.put(Constants.MAGIC_CHARM, new RPG( Constants.MAGIC_CHARM, "Magic +10 for 5 rounds", 3, 150));
        objectMap.put(Constants.STAFF_CURSE, new RPG( Constants.STAFF_CURSE, "May burn your enemies... Or yourself. Who knows?", 3, 200));
        objectMap.put(Constants.COMBAT_EDGE, new RPG( Constants.COMBAT_EDGE, "Well, that's an edge", 1, 30));
        objectMap.put(Constants.HOLY_ELIXIR, new RPG( Constants.HOLY_ELIXIR, "Recover your HP", 2, 75));
        objectMap.put(Constants.MAGIC_BOW, new RPG( Constants.MAGIC_BOW, "Attack very far enemies", 2, 75));

    }

    public static RPG getObject(String name) {
        return objectMap.get(name);
    }

    public static Map<String, RPG> getObjectList() {
        return objectMap;
    }

    public static boolean contains(String name) {
        return objectMap.containsKey(name);
    }

    private static final Random RANDOM = new Random();

    public static RPG getRandomObject(int maxWeight) {

        List<RPG> availableObjects = new ArrayList<>();
        for (RPG obj : objectMap.values()) { if (obj.getWeight() < maxWeight) availableObjects.add(obj); }
        if (availableObjects.isEmpty()) { return null; }

        return availableObjects.get(RANDOM.nextInt(availableObjects.size()));
    }
}
