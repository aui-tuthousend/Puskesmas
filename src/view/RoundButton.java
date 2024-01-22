package view;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

public class RoundButton extends JButton {
    public RoundButton(String judul) {
        super(judul);
        setContentAreaFilled(false);
        setFocusPainted(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        if (getModel().isArmed()) {
            g.setColor(Color.lightGray);
        } else {
            g.setColor(getBackground());
        }

        Graphics2D graphics2D = (Graphics2D) g;
        graphics2D.fill(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 20, 20));

        super.paintComponent(g);
    }

    @Override
    protected void paintBorder(Graphics g) {
        g.setColor(getForeground());
        Graphics2D graphics2D = (Graphics2D) g;
        graphics2D.draw(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 20, 20));
    }
}

