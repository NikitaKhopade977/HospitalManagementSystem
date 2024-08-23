package Hospital.Management.System;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Employee_info  extends JFrame {
    Employee_info(){

        JPanel panel=new JPanel();
        panel.setBounds(5,5,990,590);
        panel.setBackground(new Color(109,164,170));
        panel.setLayout(null);
        add(panel);


        JTable table=new JTable();
        table.setBounds(10,55,980,450);
        table.setBackground(new Color(109,164,170));
        table.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(table);



        try{
            conn c=new conn();
            String q="Select * from EMP_INFOS";
            ResultSet resultSet=c.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));

        }catch (Exception e){
            e.printStackTrace();
        }

        JLabel label=new JLabel("Name");
        label.setBounds(41,9,70,20);
        label.setFont(new Font("Tahoma",Font.BOLD,16));
        panel.add(label);

        JLabel label1=new JLabel("Age");
        label1.setBounds(180,9,70,20);
        label1.setFont(new Font("Tahoma",Font.BOLD,16));
        panel.add(label1);

        JLabel label2=new JLabel("Phone_Number");
        label2.setBounds(340,9,140,20);
        label2.setFont(new Font("Tahoma",Font.BOLD,16));
        panel.add(label2);

        JLabel label3=new JLabel("Salary");
        label3.setBounds(550,9,70,20);
        label3.setFont(new Font("Tahoma",Font.BOLD,16));
        panel.add(label3);

        JLabel lable4=new JLabel("Gmail");
        lable4.setBounds(730,9,70,20);
        lable4.setFont(new Font("Tahoma",Font.BOLD,16));
        panel.add(lable4);

        JLabel label5=new JLabel("Aadhar Number");
        label5.setBounds(820,9,130,20);
        label5.setFont(new Font("Tahoma",Font.BOLD,16));
        panel.add(label5);

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



        setUndecorated(true);
        setSize(1000,600);
        setLayout(null);
        setLocation(350,250);
        setVisible(true);




    }

    public static void main(String[]args){
        new Employee_info();

    }
}
