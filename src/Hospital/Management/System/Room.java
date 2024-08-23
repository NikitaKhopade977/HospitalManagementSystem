package Hospital.Management.System;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Room extends JFrame {
    private JPanel mainPanel;

    JTable table;
    Room() {
        JPanel panel=new JPanel();
        panel.setBounds(5,5,890,590);
        panel.setBackground(new Color(90,156,163));
        panel.setLayout(null);
        add(panel);

        ImageIcon imageIcon=new ImageIcon(ClassLoader.getSystemResource("icon/bed.jpg"));
        Image image=imageIcon.getImage().getScaledInstance(370,700,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1=new ImageIcon(image);
        JLabel label=new JLabel(imageIcon1);
        label.setBounds(550,55,400,300);
        panel.add(label);

        table=new JTable();
        table.setBounds(10,40,500,700);
        table.setBackground(new Color(90,156,163));
        panel.add(table);


        try{
            conn c=new conn();
            String q="select * from room";
            ResultSet resultSet=c.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        }catch (Exception e) {
            e.printStackTrace();

        }
        JLabel label1=new JLabel("Room NO :");
        label1.setBounds(12,15,80,15);
        label1.setFont(new Font("Tahoma",Font.BOLD,12));
        panel.add(label1);

        JLabel label2=new JLabel("Availabillity :");
        label2.setBounds(140,15,80,15);
        label2.setFont(new Font("Tahoma",Font.BOLD,12));
        panel.add(label2);

        JLabel label3=new JLabel("Price:");
        label3.setBounds(260,15,80,15);
        label3.setFont(new Font("Tahoma",Font.BOLD,12));
        panel.add(label3);

        JLabel label4=new JLabel("Bed Type :");
        label4.setBounds(390,15,80,15);
        label4.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label4);

        JButton back=new JButton("Back");
        back.setBounds(150,450,520,40);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        panel.add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
        setUndecorated(false);
        setSize(900,600);
        setLayout(null);
        setLocation(300,230);
        setVisible(true);

    }



    public static void main(String[] args) {
        new Room();


    }
}

