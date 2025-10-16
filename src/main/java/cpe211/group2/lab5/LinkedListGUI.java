package cpe211.group2.lab5;

import javax.swing.*;
import java.awt.*;

public class LinkedListGUI extends JFrame {
    
    private SinglyLinkedList list;
    private JTextField inputField;
    private JTextArea displayArea;
    private JButton insertStartBtn;
    private JButton insertEndBtn;
    private JButton deleteBtn;
    private JButton displayBtn;
    private JButton clearBtn;
    private JLabel statusLabel;
    
    public LinkedListGUI() {
        list = new SinglyLinkedList();
        initializeGUI();
    }

    private void initializeGUI() {

        setTitle("CPE211 Lab 5 - Singly Linked List Operations");
        setSize(700, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        add(createControlPanel(), BorderLayout.NORTH);
        add(createDisplayPanel(), BorderLayout.CENTER);
        add(createStatusPanel(), BorderLayout.SOUTH);
        
        updateDisplay();
    }

    private JPanel createControlPanel() {
        JPanel controlContainer = new JPanel();
        controlContainer.setLayout(new BoxLayout(controlContainer, BoxLayout.Y_AXIS));
        controlContainer.setBorder(BorderFactory.createEmptyBorder(10, 10, 0, 10));

        JPanel firstRow = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 5));
        JLabel inputLabel = new JLabel("Enter Value:");
        inputLabel.setFont(new Font("Arial", Font.BOLD, 14));

        inputField = new JTextField(10);
        inputField.setFont(new Font("Arial", Font.PLAIN, 14));

    insertStartBtn = createStyledButton("Insert at Start");
    insertEndBtn = createStyledButton("Insert at End");
    deleteBtn = createStyledButton("Delete");

        insertStartBtn.addActionListener(e -> insertAtStart());
        insertEndBtn.addActionListener(e -> insertAtEnd());
        deleteBtn.addActionListener(e -> deleteValue());
        inputField.addActionListener(e -> insertAtEnd());

        firstRow.add(inputLabel);
        firstRow.add(inputField);
        firstRow.add(insertStartBtn);
        firstRow.add(insertEndBtn);
        firstRow.add(deleteBtn);

        JPanel secondRow = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 5));
    displayBtn = createStyledButton("Refresh List");
    clearBtn = createStyledButton("Clear List");

        displayBtn.addActionListener(e -> updateDisplay());
        clearBtn.addActionListener(e -> clearList());

        secondRow.add(displayBtn);
        secondRow.add(clearBtn);

        controlContainer.add(firstRow);
        controlContainer.add(secondRow);

        return controlContainer;
    }

    private JPanel createDisplayPanel() {
        JPanel displayPanel = new JPanel(new BorderLayout());
        displayPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        displayArea = new JTextArea();
        displayArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
        displayArea.setEditable(false);
        displayArea.setLineWrap(true);
        displayArea.setWrapStyleWord(true);
        displayArea.setMargin(new Insets(10, 10, 10, 10));
        
        JScrollPane scrollPane = new JScrollPane(displayArea);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        displayPanel.add(scrollPane, BorderLayout.CENTER);
        
        return displayPanel;
    }
    
    private JPanel createStatusPanel() {
        JPanel statusPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        statusPanel.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        statusPanel.setBackground(new Color(240, 240, 240));
        
        statusLabel = new JLabel("Ready");
        statusLabel.setFont(new Font("Arial", Font.PLAIN, 12));
        statusPanel.add(statusLabel);
        
        return statusPanel;
    }
    
    private JButton createStyledButton(String text) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.BOLD, 12));
        button.setFocusPainted(false);
        button.setPreferredSize(new Dimension(130, 32));
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        return button;
    }
    
    private void insertAtStart() {
        try {
            int value = Integer.parseInt(inputField.getText().trim());
            list.insertAtStart(value);
            updateDisplay();
            setStatus("Inserted " + value + " at start", false);
            inputField.setText("");
            inputField.requestFocus();
        } catch (NumberFormatException ex) {
            setStatus("Error: Please enter a valid integer", true);
        }
    }

    private void insertAtEnd() {
        try {
            int value = Integer.parseInt(inputField.getText().trim());
            list.insertAtEnd(value);
            updateDisplay();
            setStatus("Inserted " + value + " at end", false);
            inputField.setText("");
            inputField.requestFocus();
        } catch (NumberFormatException ex) {
            setStatus("Error: Please enter a valid integer", true);
        }
    }
    
    private void deleteValue() {
        try {
            int value = Integer.parseInt(inputField.getText().trim());
            boolean deleted = list.delete(value);
            updateDisplay();
            if (deleted) {
                setStatus("Deleted " + value + " from list", false);
            } else {
                setStatus("Value " + value + " not found in list", true);
            }
            inputField.setText("");
            inputField.requestFocus();
        } catch (NumberFormatException ex) {
            setStatus("Error: Please enter a valid integer", true);
        }
    }
    
    private void updateDisplay() {
        String listContent = list.display();
        int size = list.size();
        
        displayArea.setText("");
        displayArea.append("List size: " + size + " node(s)\n");

        if (list.isEmpty()) {
            displayArea.append("Contents: (empty)\n");
            displayArea.append("\nUse Insert at Start or Insert at End to add values.\n");
        } else {
            displayArea.append("Contents: " + listContent + "\n");
        }
        
        setStatus("List refreshed", false);
    }
    
    private void clearList() {
        int confirm = JOptionPane.showConfirmDialog(
            this,
            "Are you sure you want to clear the entire list?",
            "Confirm Clear",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE
        );
        
        if (confirm == JOptionPane.YES_OPTION) {
            list = new SinglyLinkedList();
            updateDisplay();
            setStatus("List cleared successfully", false);
            inputField.setText("");
            inputField.requestFocus();
        }
    }

    private void setStatus(String message, boolean isError) {
        statusLabel.setText(message);
    }
}
