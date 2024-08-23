package Hospital.Management.System;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class SearchRoom extends JFrame {

    Choice choice;
    JTable table;
    SearchRoom(){


        JPanel panel=new JPanel();
        panel.setBounds(5,5,990,590);
        panel.setBackground(new Color(90,156,163));
        panel.setLayout(null);
        add(panel);

        JLabel For =new JLabel("Search For Room");
        For.setBounds(250,11,300,31);
        For.setForeground(Color.WHITE);
        For.setFont(new Font("Tahoma",Font.BOLD,24));
        panel.add(For);

        JLabel label2=new JLabel("STATUS :");
        label2.setBounds(40,80,200,16);
        label2.setFont(new Font("Tahoma",Font.BOLD,16));
        label2.setForeground(Color.WHITE);
        panel.add(label2);

        Choice choice=new Choice();
        choice.setBounds(250,80,100,30);
        choice.add("Available");
        choice.add("Occupied");
        panel.add(choice);

        table=new JTable();
        table.setBounds(0,187,700,210);
        table.setBackground(new Color(90,156,163));
        table.setForeground(Color.WHITE);
        panel.add(table);

        try{
            conn c=new conn();
            String q="select * from room";
            ResultSet resultSet=c.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));


        }catch (Exception e){
            e.printStackTrace();
        }

        JLabel Roomno=new JLabel("Room Number :");
        Roomno.setBounds(5,160,450,16);
        Roomno.setFont(new Font("Tahoma",Font.BOLD,16));
        Roomno.setForeground(Color.WHITE);
        panel.add(Roomno);

        JLabel Available=new JLabel("Avalabillity :");
        Available.setBounds(180,160,400,16);
        Available.setFont(new Font("Tahoma",Font.BOLD,16));
        Available.setForeground(Color.WHITE);
        panel.add(Available);


        JLabel price=new JLabel("Price :");
        price.setBounds(350,160,400,16);
        price.setFont(new Font("Tahoma",Font.BOLD,16));
        price.setForeground(Color.WHITE);
        panel.add(price);


        JLabel Bed=new JLabel("Bed Type :");
        Bed.setBounds(530,160,400,16);
        Bed.setFont(new Font("Tahoma",Font.BOLD,16));
        Bed.setForeground(Color.WHITE);
        panel.add(Bed);

        JButton search=new JButton("Search");
        search.setBounds(200,420,120,25);
        search.setBackground(Color.BLACK);
        search.setForeground(Color.WHITE);
        panel.add(search);
        search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String q="select * from room where Availabillity ='"+choice.getSelectedItem()+"'";
                try{
                    conn c=new conn();
                    ResultSet resultSet=c.statement.executeQuery(q);
                    table.setModel(DbUtils.resultSetToTableModel(resultSet));
                }catch (Exception E){
                    E.printStackTrace();
                }
            }
        });


        JButton back=new JButton("Back");
        back.setBounds(350,420,120,25);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        panel.add(back);
        back.addActionListener(new ActionListener() {
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
        new SearchRoom();

    }
}
