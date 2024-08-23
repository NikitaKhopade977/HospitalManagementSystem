package Hospital.Management.System;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Ambulance extends JFrame{

    Ambulance(){
        JPanel panel=new JPanel();
        panel.setBounds(5,5,990,590);
        panel.setBackground(new Color(90,156,163));
        panel.setLayout(null);
        add(panel);

        JTable table=new JTable();
        table.setBounds(15,50,990,450);
        table.setBackground(new Color(90,156,163));
        table.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(table);

        try {
            conn c=new conn();
            String q= "select * from Ambulancee";
            ResultSet resultSet=c.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        }catch (Exception e){
            e.printStackTrace();
        }

        JLabel label=new JLabel("Name");
        label.setBounds(5,9,70,20);
        label.setFont(new Font("Tahoma",Font.BOLD,16));
        panel.add(label);

        JLabel label1=new JLabel("Gender");
        label1.setBounds(220,9,70,20);
        label1.setFont(new Font("Tahoma",Font.BOLD,16));
        panel.add(label1);

        JLabel label2=new JLabel("Car_name");
        label2.setBounds(400,9,100,20);
        label2.setFont(new Font("Tahoma",Font.BOLD,16));
        panel.add(label2);

        JLabel label3=new JLabel("Available");
        label3.setBounds(620,9,100,20);
        label3.setFont(new Font("Tahoma",Font.BOLD,16));
        panel.add(label3);

        JLabel label4=new JLabel("Location");
        label4.setBounds(800,9,70,20);
        label4.setFont(new Font("Tahoma",Font.BOLD,16));
        panel.add(label4);

        JButton button=new JButton("BACK");
        button.setBounds(250,500,450,40);
        button.setForeground(Color.WHITE);
        button.setBackground(Color.BLACK);
        panel.add(button);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);



            }
        });




        setSize(1000,600);
        setLayout(null);
        setLocation(350,250);
        setVisible(true);



    }
    public static void main(String[]args){
        new Ambulance();

    }
}
