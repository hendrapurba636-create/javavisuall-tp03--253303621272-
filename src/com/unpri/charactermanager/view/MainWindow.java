
package com.unpri.charactermanager.view;

import com.unpri.charactermanager.model.Character;
import com.unpri.charactermanager.model.CharacterManager;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {

    private CharacterManager manager;
    private JPanel characterPanel;
    private JLabel averageLabel;

    public MainWindow(CharacterManager manager) {

        super("Character Manager v0.5");

        this.manager = manager;

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 450);
        setLocationRelativeTo(null);

        setLayout(new BorderLayout(10, 10));

        // Judul aplikasi
        JLabel title = new JLabel(
            "CHARACTER MANAGER",
            SwingConstants.CENTER
        );

        title.setFont(new Font("Arial", Font.BOLD, 22));
        title.setBorder(BorderFactory.createEmptyBorder(15, 10, 15, 10));

        add(title, BorderLayout.NORTH);

        // Panel daftar karakter
        characterPanel = new JPanel();
        characterPanel.setLayout(
            new BoxLayout(characterPanel, BoxLayout.Y_AXIS)
        );

        characterPanel.setBorder(
            BorderFactory.createEmptyBorder(10, 15, 10, 15)
        );

        JScrollPane scrollPane = new JScrollPane(characterPanel);

        add(scrollPane, BorderLayout.CENTER);

        // Panel bawah
        averageLabel = new JLabel("", SwingConstants.CENTER);
        averageLabel.setFont(new Font("Arial", Font.BOLD, 14));

        averageLabel.setBorder(
            BorderFactory.createEmptyBorder(15, 10, 15, 10)
        );

        add(averageLabel, BorderLayout.SOUTH);

        refreshCharacters();
    }

    private void refreshCharacters() {

        characterPanel.removeAll();

        for (Character character : manager.getAllCharacters()) {

            JLabel label = new JLabel(
                character.getName()
                + " | " + character.getType()
                + " | Level " + character.getLevel()
            );

            label.setFont(new Font("Arial", Font.PLAIN, 15));

            label.setBorder(
                BorderFactory.createEmptyBorder(8, 5, 8, 5)
            );

            characterPanel.add(label);
        }

        averageLabel.setText(
            String.format(
                "Rata-rata Level: %.1f",
                manager.getAverageLevel()
            )
        );

        characterPanel.revalidate();
        characterPanel.repaint();
    }
}
