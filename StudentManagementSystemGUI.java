package org.sms;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class StudentManagementSystemGUI extends JFrame {
    ArrayList<Student> list = new ArrayList<>();
    JTextField nameField, rollField, gradeField;
    JTextArea display;

    public StudentManagementSystemGUI() {
        setTitle("Student Management");
        setSize(450, 350);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setBackground(new Color(230, 245, 255));
        setLayout(new BorderLayout());

        JPanel panel = new JPanel(new GridLayout(4, 2, 5, 5));
        panel.setBackground(new Color(230, 245, 255));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        nameField = new JTextField(); rollField = new JTextField(); gradeField = new JTextField();
        panel.add(new JLabel("Name:")); panel.add(nameField);
        panel.add(new JLabel("Roll No:")); panel.add(rollField);
        panel.add(new JLabel("Grade:")); panel.add(gradeField);

        JButton add = new JButton("Add");
        add.setBackground(Color.GREEN);
        JButton show = new JButton("Show");
        show.setBackground(Color.CYAN);

        panel.add(add); panel.add(show);
        add(panel, BorderLayout.NORTH);

        display = new JTextArea();
        display.setEditable(false);
        display.setBackground(new Color(255, 255, 204));
        add(new JScrollPane(display), BorderLayout.CENTER);

        add.addActionListener(e -> {
            String n = nameField.getText().trim();
            String r = rollField.getText().trim();
            String g = gradeField.getText().trim();
            if (n.isEmpty() || r.isEmpty() || g.isEmpty()) {
                JOptionPane.showMessageDialog(this, "All fields required");
            } else {
                list.add(new Student(n, r, g));
                JOptionPane.showMessageDialog(this, "Student Added");
                nameField.setText(""); rollField.setText(""); gradeField.setText("");
            }
        });

        show.addActionListener(e -> {
            display.setText("");
            if (list.isEmpty()) display.setText("No students.");
            else list.forEach(s -> display.append(s.toString()));
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new StudentManagementSystemGUI();
    }
}