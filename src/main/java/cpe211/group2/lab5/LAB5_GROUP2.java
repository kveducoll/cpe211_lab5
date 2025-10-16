package cpe211.group2.lab5;

import javax.swing.SwingUtilities;

// main
public class LAB5_GROUP2 
{
    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(() -> {
            LinkedListGUI gui = new LinkedListGUI();
            gui.setVisible(true);
        });
    }
}
