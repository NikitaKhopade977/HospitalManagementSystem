package Hospital.Management.System;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

@SuppressWarnings("CallToPrintStackTrace")
public class All_Patient_Info extends JFrame {

    All_Patient_Info(){
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
            String q= "select * from patient_infos";
            ResultSet resultSet=c.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        }catch (Exception e){
            e.printStackTrace();
        }

        JLabel label=new JLabel("ID");
        label.setBounds(41,9,70,20);
        label.setFont(new Font("Tahoma",Font.BOLD,16));
        panel.add(label);

        JLabel label1=new JLabel("Number");
        label1.setBounds(140,9,70,20);
        label1.setFont(new Font("Tahoma",Font.BOLD,16));
        panel.add(label1);

        JLabel label2=new JLabel("Name");
        label2.setBounds(270,9,70,20);
        label2.setFont(new Font("Tahoma",Font.BOLD,16));
        panel.add(label2);

        JLabel label3=new JLabel("Gender");
        label3.setBounds(380,9,70,20);
        label3.setFont(new Font("Tahoma",Font.BOLD,16));
        panel.add(label3);

        JLabel label4=new JLabel("Disease");
        label4.setBounds(490,9,70,20);
        label4.setFont(new Font("Tahoma",Font.BOLD,16));
        panel.add(label4);

        JLabel label5=new JLabel("Room");
        label5.setBounds(620,9,70,20);
        label5.setFont(new Font("Tahoma",Font.BOLD,16));
        panel.add(label5);

        JLabel label6=new JLabel("Time");
        label6.setBounds(750,9,70,20);
        label6.setFont(new Font("Tahoma",Font.BOLD,16));
        panel.add(label6);

        JLabel label7=new JLabel("Deposit");
        label7.setBounds(890,9,70,20);
        label7.setFont(new Font("Tahoma",Font.BOLD,16));
        panel.add(label7);


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
        new All_Patient_Info();
    }
}
