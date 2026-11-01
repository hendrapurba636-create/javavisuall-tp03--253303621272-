
package view;

import com.unpri.charactermanager.model.Character;
import com.unpri.charactermanager.model.CharacterManager;
import com.unpri.charactermanager.model.CharacterType;

import javax.swing.*;
import java.awt.*;
import java.util.Locale;

public class MainWindow extends JFrame {

    private final CharacterManager manager;

    public MainWindow() {
        setTitle("Character Manager v0.4");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        manager = new CharacterManager();

        // Data karakter
        manager.addCharacter(
                new Character("Arjuna", CharacterType.WARRIOR, 5, 150, 40));

        manager.addCharacter(
                new Character("Merlin", CharacterType.MAGE, 3, 130, 35));

        manager.addCharacter(
                new Character("Athena", CharacterType.ARCHER, 4, 140, 38));

        manager.addCharacter(
                new Character("Bima", CharacterType.WARRIOR, 7, 170, 50));

        manager.addCharacter(
                new Character("Luna", CharacterType.MAGE, 6, 160, 45));

        manager.addCharacter(
                new Character("Thor", CharacterType.HEALER, 1, 100, 20));

        initComponents();

        pack();
        setLocationRelativeTo(null);
    }

    private void initComponents() {

        setLayout(new BorderLayout(10, 10));
        getContentPane().setBackground(AppTheme.BACKGROUND);

        // Judul aplikasi
        JLabel titleLabel = new JLabel(
                "=== DAFTAR KARAKTER ===",
                JLabel.CENTER
        );

        titleLabel.setFont(AppTheme.TITLE_FONT);
        titleLabel.setForeground(AppTheme.PRIMARY);
        titleLabel.setBorder(
                BorderFactory.createEmptyBorder(20, 10, 15, 10)
        );

        add(titleLabel, BorderLayout.NORTH);

        // Panel daftar karakter
        JPanel listPanel = new JPanel();
        listPanel.setLayout(
                new BoxLayout(listPanel, BoxLayout.Y_AXIS)
        );
        listPanel.setBackground(AppTheme.BACKGROUND);
        listPanel.setBorder(
                BorderFactory.createEmptyBorder(10, 20, 10, 20)
        );

        // Membuat kartu setiap karakter
        for (Character c : manager.getCharacters()) {

            JPanel characterCard = new JPanel();
            characterCard.setLayout(new BorderLayout());
            characterCard.setBackground(
                    AppTheme.colorFor(c.getType())
            );
            characterCard.setOpaque(true);
            characterCard.setBorder(AppTheme.CARD_BORDER);
            characterCard.setAlignmentX(Component.LEFT_ALIGNMENT);

            // Nama dan role
            JLabel nameLabel = new JLabel(
                    c.getName() + " - " + c.getType()
            );

            nameLabel.setFont(AppTheme.BOLD_FONT);
            nameLabel.setForeground(AppTheme.TEXT);

            // Level karakter
            JLabel levelLabel = new JLabel(
                    "Level: " + c.getLevel()
            );

            if (c.getLevel() >= AppTheme.GOLD_LEVEL_LIMIT) {
                levelLabel.setForeground(AppTheme.GOLD);
                levelLabel.setFont(AppTheme.BOLD_FONT);
            } else {
                levelLabel.setForeground(AppTheme.TEXT);
                levelLabel.setFont(AppTheme.NORMAL_FONT);
            }

            // Informasi HP dan ATK
            JLabel detailLabel = new JLabel(
                    "HP: " + c.getHitPoints()
                    + " | ATK: " + c.getAttackPower()
            );

            detailLabel.setFont(AppTheme.NORMAL_FONT);
            detailLabel.setForeground(AppTheme.TEXT);

            // Panel informasi
            JPanel infoPanel = new JPanel();
            infoPanel.setLayout(new GridLayout(3, 1, 0, 5));
            infoPanel.setBackground(
                    AppTheme.colorFor(c.getType())
            );
            infoPanel.setOpaque(true);

            infoPanel.add(nameLabel);
            infoPanel.add(levelLabel);
            infoPanel.add(detailLabel);

            characterCard.add(infoPanel, BorderLayout.CENTER);

            // Properti tambahan 1: Tooltip HP dan ATK
            characterCard.setToolTipText(
                    "Detail " + c.getName()
                    + " | HP: " + c.getHitPoints()
                    + " | ATK: " + c.getAttackPower()
            );

            // Properti tambahan 2: Level 1 tidak aktif
            if (c.getLevel() == 1) {
                characterCard.setEnabled(false);
            }

            listPanel.add(characterCard);
            listPanel.add(Box.createRigidArea(
                    new Dimension(0, 12)
            ));
        }

        // Scroll pane
        JScrollPane scrollPane = new JScrollPane(listPanel);
        scrollPane.setBorder(AppTheme.CARD_BORDER);
        scrollPane.setPreferredSize(new Dimension(480, 350));

        add(scrollPane, BorderLayout.CENTER);

        // Rata-rata level
        JLabel avgLabel = new JLabel(
                "Rata-rata Level: "
                + String.format(
                        Locale.US,
                        "%.1f",
                        manager.getAverageLevel()
                ),
                JLabel.CENTER
        );

        avgLabel.setFont(AppTheme.BOLD_FONT);
        avgLabel.setForeground(AppTheme.PRIMARY);
        avgLabel.setBorder(
                BorderFactory.createEmptyBorder(15, 10, 20, 10)
        );

        add(avgLabel, BorderLayout.SOUTH);
    }
}
