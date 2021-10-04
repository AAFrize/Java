package com.jd;
//Приложение для расчёта бонус шопа в игре Jade Dynasty в зависимости от начального и конечного уровня реферала
import javax.swing.*;
public class GUI {
    public static void main(String[] args) {
    GUI gui = new GUI();
    gui.go();
    }
    public void go() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        JButton button = new JButton("Рассчитать");
        JTextField field1 = new JTextField();
        JTextField field2 = new JTextField();
        JTextField field3 = new JTextField();
        JTextField field4 = new JTextField();
        JTextPane pane1 = new JTextPane();
        JTextPane pane2 = new JTextPane();
        JLabel label1 = new JLabel("Начальное значение БШ");
        JLabel label2 = new JLabel("Количество рефералов");
        JLabel label3 = new JLabel("Начальный уровень реферала");
        JLabel label4 = new JLabel("Конечный уровень реферала");
        JCheckBox checkBox1 = new JCheckBox("Рб");
        pane1.add(checkBox1);
        JCheckBox checkBox2 = new JCheckBox("Рб");
        pane2.add(checkBox2);

        label1.setBounds(10, 35, 190,20);
        label2.setBounds(10, 105, 190, 20);
        label3.setBounds(200, 35, 190, 20);
        label4.setBounds(200, 105, 190, 20);
        field1.setBounds(10, 10,100, 20);
        field2.setBounds(10,80,100, 20);
        field3.setBounds(200,10,100, 20);
        field4.setBounds(200,80,100, 20);
        button.setBounds(110, 150,150, 20);
        checkBox1.setBounds(310, 10,40,20);
        checkBox2.setBounds(310, 80,40,20);
        panel.add(button);
        panel.add(field1);
        panel.add(field2);
        panel.add(field3);
        panel.add(field4);
        panel.add(checkBox1);
        panel.add(checkBox2);
        panel.add(label1);
        panel.add(label2);
        panel.add(label3);
        panel.add(label4);
        frame.getContentPane().add(panel);
        frame.setSize(450, 220);
        //field2.setLocation(10, 100);
        frame.setVisible(true);
        button.addActionListener(e -> {
            float initial;
            int count;
            if (field1.getText().length() > 0) initial = Float.parseFloat(field1.getText());
            else {
                initial = 0;
            }
            if (field2.getText().length() > 0) count = Integer.parseInt(field2.getText());
            else {
                count = 1;
            }
            int level = Integer.parseInt(field3.getText());
            int toLevel = Integer.parseInt(field4.getText());
            Referals ref;
            Float result;
            if (initial <= 0) initial = 0;
            if (count < 0 ) count = 0;
            if (checkBox1.isSelected()) {
                ref = new Reborn();
                result = ref.bSh(level, toLevel);
            }
            else {
                ref = new NotReborn();
                result = ref.bSh(level, toLevel, checkBox2.isSelected());
            }
            result = result * count + initial;
            field1.setText(String.valueOf(result));
            JDialog dialog = new JDialog();
            dialog.add(new JLabel(result.toString() + " бш"));
            dialog.setSize(50, 70);
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
        });
    }
}
