package Basic;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.*;

public class SwingTest {
    public static void main(String[] args) {

        /* task 1
        File file = new File("./Location.txt");
        if (!file.getParentFile().exists() || !file.getParentFile().isDirectory())
            file.getParentFile().mkdirs();
        try {
            if (!file.exists() || !file.isFile()) file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        int x = 200, y = 200;
        if (file.length() != 0) {
            try (FileInputStrea m fis = new FileInputStream(file); DataInputStream dis = new DataInputStream(fis)) {
                x = dis.readInt();
                y = dis.readInt();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        JFrame f = new JFrame("test");
        f.setSize(400,300);
        f.setLocation(x, y);
        f.setLayout(null);
        JButton b = new JButton("Nothing would be done.");
        b.setBounds(50, 50, 280, 30);
        f.add(b);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JDialog d = new JDialog(f);
        d.setModal(true);

        d.setTitle("modal");
        d.setSize(400, 300);
        d.setLocation(200, 200);
        d.setLayout(null);
        f.setVisible(true);
        d.setVisible(true);

        Thread t = new Thread() {
            public void run() {
                while (true) {
                    int curx = f.getX(), cury = f.getY();
                    try (FileOutputStream fos = new FileOutputStream(file); DataOutputStream dos = new DataOutputStream(fos)) {
                        dos.writeInt(curx);
                        dos.writeInt(cury);
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }


                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        t.setDaemon(true);
        t.start();
        */


        //task 2
        JFrame f = new JFrame();
        f.setSize(400,300);
        f.setLocation(960,540);
        JTextField textBar = new JTextField(8);
        JButton button = new JButton("test");
         button.setToolTipText("test");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String tmp = textBar.getText();
                if (tmp.isEmpty()) {
                    JOptionPane.showMessageDialog(f, "Empty!");
                }
            }
        });

        JPanel upPanel = new JPanel(new FlowLayout());
        upPanel.add(textBar);
        upPanel.add(button);
        f.add(upPanel, BorderLayout.NORTH);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
        upPanel.setVisible(true);
        JTable t = new JTable();

    }
}
