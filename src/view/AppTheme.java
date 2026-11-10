
package view;

import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.border.Border;

import com.unpri.charactermanager.model.CharacterType;

public class AppTheme {

    // Warna utama aplikasi (versi TP10)
    public static final Color BACKGROUND = new Color(240, 246, 252);
    public static final Color PRIMARY = new Color(25, 75, 115);
    public static final Color TEXT = new Color(35, 45, 60);
    public static final Color WHITE = Color.WHITE;
    public static final Color GOLD = new Color(190, 130, 15);
    public static final Color BORDER_COLOR = new Color(190, 205, 220);

    // Warna berdasarkan role
    public static final Color WARRIOR_COLOR = new Color(255, 225, 215);
    public static final Color MAGE_COLOR = new Color(220, 235, 255);
    public static final Color ARCHER_COLOR = new Color(220, 245, 230);
    public static final Color HEALER_COLOR = new Color(255, 240, 210);

    // Batas level untuk warna emas
    public static final int GOLD_LEVEL_LIMIT = 5;

    // Font aplikasi
    public static final Font TITLE_FONT =
            new Font(Font.SANS_SERIF, Font.BOLD, 22);

    public static final Font NORMAL_FONT =
            new Font(Font.SANS_SERIF, Font.PLAIN, 14);

    public static final Font BOLD_FONT =
            new Font(Font.SANS_SERIF, Font.BOLD, 14);

    // Border aplikasi
    public static final Border CARD_BORDER =
            BorderFactory.createCompoundBorder(
                    BorderFactory.createLineBorder(BORDER_COLOR),
                    BorderFactory.createEmptyBorder(12, 15, 12, 15)
            );

    // Menentukan warna berdasarkan role
    public static Color colorFor(CharacterType role) {
        switch (role) {
            case WARRIOR:
                return WARRIOR_COLOR;
            case MAGE:
                return MAGE_COLOR;
            case ARCHER:
                return ARCHER_COLOR;
            case HEALER:
                return HEALER_COLOR;
            default:
                return BACKGROUND;
        }
    }
}
