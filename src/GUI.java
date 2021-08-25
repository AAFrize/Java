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
        JTextPane pane1 = new JTextPane();
        JTextPane pane2 = new JTextPane();
        JLabel label1 = new JLabel("Начальный уровень");
        JLabel label2 = new JLabel("Конечный уровень");
        JCheckBox checkBox1 = new JCheckBox("Рб");
        pane1.add(checkBox1);
        JCheckBox checkBox2 = new JCheckBox("Рб");
        pane2.add(checkBox2);

        label1.setBounds(10, 35, 140,20);
        label2.setBounds(10, 105, 140, 20);
        field1.setBounds(10, 10,100, 20);
        field2.setBounds(10,80,100, 20);
        button.setBounds(17, 150,150, 20);
        checkBox1.setBounds(120, 10,40,20);
        checkBox2.setBounds(120, 80,40,20);
        panel.add(button);
        panel.add(field1);
        panel.add(field2);
        panel.add(checkBox1);
        panel.add(checkBox2);
        panel.add(label1);
        panel.add(label2);
        frame.getContentPane().add(panel);
        frame.setSize(200, 250);
        //field2.setLocation(10, 100);
        frame.setVisible(true);
        button.addActionListener(e -> {
            int level = Integer.parseInt(field1.getText());
            int toLevel = Integer.parseInt(field2.getText());
            Referals ref;
            Float result;
            if (checkBox1.isSelected()) {
                ref = new Reborn();
                result = ref.bSh(level, toLevel);
            }
            else {
                ref = new NotReborn();
                result = ref.bSh(level, toLevel, checkBox2.isSelected());
            }
            JDialog dialog = new JDialog();
            dialog.add(new JLabel(result.toString() + " бш"));
            dialog.setSize(50, 70);
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
        });
    }
}
