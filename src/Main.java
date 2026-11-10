
import view.MainWindow;

import com.unpri.charactermanager.model.Character;
import com.unpri.charactermanager.model.CharacterManager;
import com.unpri.charactermanager.model.CharacterType;

import javax.swing.SwingUtilities;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            CharacterManager manager = new CharacterManager();

            manager.addCharacter(new Character("Arjuna", CharacterType.WARRIOR, 5, 150, 40));
            manager.addCharacter(new Character("Merlin", CharacterType.MAGE, 3, 130, 35));
            manager.addCharacter(new Character("Athena", CharacterType.ARCHER, 4, 140, 38));
            manager.addCharacter(new Character("Gatotkaca", CharacterType.WARRIOR, 7, 170, 50));
            manager.addCharacter(new Character("Morgana", CharacterType.MAGE, 1, 100, 20));
            manager.addCharacter(new Character("Artemis", CharacterType.ARCHER, 6, 160, 45));
            manager.addCharacter(new Character("Bima", CharacterType.WARRIOR, 8, 180, 55));
            manager.addCharacter(new Character("Circe", CharacterType.MAGE, 2, 120, 30));

            ArrayList<Character> characters =
                    new ArrayList<>(manager.getCharacters());

            MainWindow window = new MainWindow(characters);
            window.setVisible(true);
        });
    }
}
