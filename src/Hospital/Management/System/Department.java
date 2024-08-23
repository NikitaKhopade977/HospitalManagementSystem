package Hospital.Management.System;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Department extends JFrame {

    Department(){

        JPanel panel=new JPanel();
        panel.setBounds(10,10,700,450);
        panel.setLayout(null);
        panel.setBackground(new Color(90,156,163));
        add(panel);

        JTable table=new JTable();
        table.setBounds(10,55,900,350);
        table.setBackground(new Color(90,156,163));
        table.setFont(new Font("Tahoma",Font.BOLD,16));
        panel.add(table);


        try{
            conn c=new conn();
            String q="Select * from department";
            ResultSet resultSet=c.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        }catch (Exception e){
            e.printStackTrace();

        }

        JLabel label1=new JLabel("Department");
        label1.setBounds(145,11,105,20);
        label1.setFont(new Font("Tahoma",Font.BOLD,16));
        panel.add(label1);



        JLabel label2=new JLabel("Phone Number");
        label2.setBounds(431,11,150,20);
        label2.setFont(new Font("Tahoma",Font.BOLD,16));
        panel.add(label2);



        JButton button=new JButton("BACK");
        button.setBounds(250,380,200,40);
        button.setForeground(Color.WHITE);
        button.setBackground(Color.BLACK);
        panel.add(button);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);



            }
        });








        setUndecorated(false);
        setSize(700,500);
        setLayout(null);
        setLocation(350,250);
        setVisible(true);


    }


    public static void main(String[]args){
        new Department();

    }
}
