package re.forestier.edu;
import re.forestier.edu.rpg.Player;
import re.forestier.edu.rpg.UpdatePlayer;
import re.forestier.edu.rpg.utils.Affichage;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {


        // ICHOU Abdelali's repository for his project => https://github.com/abdelaliichou/TP1-Genie-logiciel

        Player firstPlayer = new Player("Florian", "Ruzberg de Rivehaute", "DWARF", 200, new ArrayList<>(),5);
        UpdatePlayer.addMoney(firstPlayer, 600);
        UpdatePlayer.addXp(firstPlayer, 40);

        UpdatePlayer.addXp(firstPlayer, 10);
        System.out.println(Affichage.printPlayer(firstPlayer));
        System.out.println(Affichage.printPlayerInMarkDown(firstPlayer));
    }
}