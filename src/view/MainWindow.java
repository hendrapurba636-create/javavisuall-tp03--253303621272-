
package view;

import com.unpri.charactermanager.model.Character;
import com.unpri.charactermanager.model.CharacterType;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MainWindow extends JFrame {

    private final ArrayList<Character> characterList;

    public MainWindow(ArrayList<Character> characterList) {
        super("Character Manager v0.5");

        this.characterList = characterList;

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        initComponents();

        pack();
        setMinimumSize(new Dimension(560, 380));
        setLocationRelativeTo(null);
    }

    private void initComponents() {

        setLayout(new BorderLayout(10, 10));
        getContentPane().setBackground(AppTheme.BG_MAIN);

        add(createHeaderPanel(), BorderLayout.NORTH);
        add(createListArea(), BorderLayout.CENTER);
        add(createLegendPanel(), BorderLayout.EAST);
        add(createStatusPanel(), BorderLayout.SOUTH);
    }

    // HEADER
    private JPanel createHeaderPanel() {

        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(AppTheme.PRIMARY);
        panel.setBorder(
                BorderFactory.createEmptyBorder(15, 20, 15, 20)
        );

        JLabel title = new JLabel("CHARACTER MANAGER");
        title.setFont(AppTheme.FONT_TITLE);
        title.setForeground(AppTheme.WHITE);

        JLabel count = new JLabel(
                characterList.size() + " karakter"
        );
        count.setFont(AppTheme.FONT_MONO);
        count.setForeground(AppTheme.GOLD);

        panel.add(title, BorderLayout.WEST);
        panel.add(count, BorderLayout.EAST);

        return panel;
    }

    // DAFTAR KARAKTER
    private JScrollPane createListArea() {

        JPanel cards = new JPanel(
                new GridLayout(0, 1, 0, 8)
        );

        cards.setBackground(AppTheme.BG_MAIN);
        cards.setBorder(
                BorderFactory.createEmptyBorder(10, 15, 10, 15)
        );

        for (Character c : characterList) {

            JLabel card = new JLabel(
                    "<html><b>" + c.getName()
                    + "</b> | " + c.getType()
                    + "<br>Level: " + c.getLevel()
                    + " | HP: " + c.getHitPoints()
                    + " | ATK: " + c.getAttackPower()
                    + "</html>"
            );

            card.setFont(AppTheme.FONT_BODY);
            card.setForeground(AppTheme.TEXT_LIGHT);
            card.setBackground(
                    AppTheme.colorFor(c.getType())
            );
            card.setOpaque(true);
            card.setBorder(AppTheme.CARD_BORDER);

            card.setToolTipText(
                    AppTheme.describe(c.getType())
            );

            card.setCursor(
                    new Cursor(Cursor.HAND_CURSOR)
            );

            cards.add(card);
        }

        JPanel holder = new JPanel(new BorderLayout());
        holder.setBackground(AppTheme.BG_MAIN);
        holder.add(cards, BorderLayout.NORTH);

        JScrollPane scrollPane = new JScrollPane(holder);
        scrollPane.setBorder(null);
        scrollPane.getViewport().setBackground(AppTheme.BG_MAIN);
        scrollPane.setPreferredSize(new Dimension(460, 280));

        return scrollPane;
    }

    // LEGEND ROLE
    private JPanel createLegendPanel() {

        JPanel panel = new JPanel();
        panel.setLayout(
                new BoxLayout(panel, BoxLayout.Y_AXIS)
        );

        panel.setBackground(AppTheme.BACKGROUND);
        panel.setBorder(
                BorderFactory.createEmptyBorder(15, 10, 15, 15)
        );

        JLabel heading = new JLabel("ROLE");
        heading.setFont(AppTheme.BOLD_FONT);
        heading.setForeground(AppTheme.TEXT);

        panel.add(heading);
        panel.add(Box.createVerticalStrut(12));

        for (CharacterType type : CharacterType.values()) {

            JLabel chip = new JLabel("  " + type.name() + "  ");
            chip.setFont(AppTheme.FONT_MONO);
            chip.setOpaque(true);
            chip.setBackground(AppTheme.colorFor(type));
            chip.setForeground(AppTheme.TEXT);
            chip.setBorder(
                    BorderFactory.createEmptyBorder(6, 5, 6, 5)
            );
            chip.setToolTipText(AppTheme.describe(type));

            panel.add(chip);
            panel.add(Box.createVerticalStrut(8));
        }

        panel.add(Box.createVerticalGlue());

        return panel;
    }

    // STATUS BAR
    private JPanel createStatusPanel() {

        JPanel panel = new JPanel(
                new BorderLayout()
        );

        panel.setBackground(AppTheme.BG_STATUS);
        panel.setBorder(
                BorderFactory.createEmptyBorder(8, 15, 8, 15)
        );

        JLabel status = new JLabel(
                "Total: " + characterList.size() + " karakter | Siap"
        );

        status.setFont(AppTheme.FONT_MONO);
        status.setForeground(AppTheme.TEXT_MUTED);

        JLabel version = new JLabel("v0.5");
        version.setFont(AppTheme.FONT_MONO);
        version.setForeground(AppTheme.TEXT_MUTED);

        panel.add(status, BorderLayout.WEST);
        panel.add(version, BorderLayout.EAST);

        return panel;
    }
}
