package view;

import com.unpri.charactermanager.model.Character;
import com.unpri.charactermanager.model.CharacterManager;
import com.unpri.charactermanager.model.CharacterType;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {
    private CharacterManager manager;

    public MainWindow() {
        setTitle("Character Manager v0.3");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        manager = new CharacterManager();
        
        manager.addCharacter(new Character("Arjuna", CharacterType.WARRIOR, 5, 150, 40));
        manager.addCharacter(new Character("Merlin", CharacterType.MAGE, 3, 130, 35));
        manager.addCharacter(new Character("Athena", CharacterType.ARCHER, 4, 140, 38));
        manager.addCharacter(new Character("Bima", CharacterType.WARRIOR, 7, 170, 50));
        manager.addCharacter(new Character("Luna", CharacterType.MAGE, 6, 160, 45));

        initComponents();
    }

    private void initComponents() {
        setLayout(new BorderLayout());

        JLabel titleLabel = new JLabel("=== Daftar Karakter ===", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        titleLabel.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
        add(titleLabel, BorderLayout.NORTH);

        JPanel listPanel = new JPanel();
        listPanel.setLayout(new BoxLayout(listPanel, BoxLayout.Y_AXIS));
        listPanel.setBorder(BorderFactory.createEmptyBorder(10, 40, 10, 40));

        for (Character c : manager.getCharacters()) {
            JLabel charLabel = new JLabel(c.toString());
            charLabel.setFont(new Font("Arial", Font.PLAIN, 14));
            charLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
            listPanel.add(charLabel);
            listPanel.add(Box.createRigidArea(new Dimension(0, 12)));
        }

        JScrollPane scrollPane = new JScrollPane(listPanel);
        scrollPane.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        
        JPanel centerWrapper = new JPanel(new BorderLayout());
        centerWrapper.setBorder(BorderFactory.createEmptyBorder(0, 30, 0, 30));
        centerWrapper.add(scrollPane, BorderLayout.CENTER);
        add(centerWrapper, BorderLayout.CENTER);

        JLabel avgLabel = new JLabel("Rata-rata Level: " + manager.getAverageLevel(), JLabel.CENTER);
        avgLabel.setFont(new Font("Arial", Font.BOLD, 14));
        avgLabel.setBorder(BorderFactory.createEmptyBorder(20, 0, 25, 0));
        add(avgLabel, BorderLayout.SOUTH);
    }
}