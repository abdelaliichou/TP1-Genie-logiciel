package re.forestier.edu;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import re.forestier.edu.rpg.Affichage;
import re.forestier.edu.rpg.UpdatePlayer;
import re.forestier.edu.rpg.player;

import java.util.ArrayList;

import static org.approvaltests.Approvals.verify;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.fail;

public class GlobalTest {

    @Test
    void testAffichageBase() {
        player player = new player("Florian", "Gnognak le Barbare", "ADVENTURER", 200, new ArrayList<>());
        player.currenthealthpoints = player.healthpoints/2 -1 ;
        UpdatePlayer.addXp(player, 20);
        UpdatePlayer.majFinDeTour(player);

        player.currenthealthpoints = player.healthpoints/2 +1;

        player.inventory = new ArrayList<>();

        verify(Affichage.afficherJoueur(player));
    }

    @Test
    void testAffichageBase2() {
        player player = new player("Florian", "Gnognak le Barbare", "ADVENTURER", 200, new ArrayList<>());
        UpdatePlayer.addXp(player, 30);
        UpdatePlayer.addXp(player, 55);
        UpdatePlayer.addXp(player, 70);
        player.getXp();
        player.inventory = new ArrayList<>();

        verify(Affichage.afficherJoueur(player));
    }

    @Test
    void testAffichageBase3() {
        player player = new player("Florian", "Gnognak le Barbare", "ADVENTURER", 200, new ArrayList<>());
        UpdatePlayer.addXp(player, 20);
        player.inventory = new ArrayList<>();
        player.inventory.add("abdelali ichou"); // add element to the list so the for each can be reached in the Affichage class

        verify(Affichage.afficherJoueur(player));
    }
}
