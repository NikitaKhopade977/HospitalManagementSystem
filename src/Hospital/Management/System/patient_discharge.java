package Hospital.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class patient_discharge extends JFrame {
    patient_discharge(){

        JPanel panel=new JPanel();
        panel.setBounds(5,5,990,590);
        panel.setBackground(new Color(90,156,163));
        panel.setLayout(null);
        add(panel);

        JLabel label=new JLabel("CHECK-OUT");
        label.setBounds(100,20,200,20);
        label.setFont(new Font("Tahoma",Font.BOLD,20));
        panel.add(label);

        JLabel label1=new JLabel("Customer ID");
        label1.setBounds(30,80,150,20);
        label1.setFont(new Font("Tahoma",Font.BOLD,16));
        panel.add(label1);

        Choice choice=new Choice();
        choice.setBounds(200,80,150,25);
        panel.add(choice);

        try {
            conn c=new conn();
            ResultSet resultSet=c.statement.executeQuery("select * from patient_infos");
            while (resultSet.next()){
                choice.add(resultSet.getString("Number"));
            }

        }catch (Exception e){
            e.printStackTrace();

        }

        JLabel label2=new JLabel("Room Number");
        label2.setBounds(30,130,150,20);
        label2.setFont(new Font("Tahoma",Font.BOLD,16));
        panel.add(label2);

        JLabel RNO=new JLabel("");
        RNO.setBounds(200,130,150,20);
        RNO.setFont(new Font("Tahoma",Font.BOLD,16));
        panel.add(RNO);

        JLabel label3=new JLabel("In Time ");
        label3.setBounds(30,180,300,20);
        label3.setFont(new Font("Tahoma",Font.BOLD,16));
        panel.add(label3);

        JLabel InTime=new JLabel("");
        InTime.setBounds(200,180,150,20);
        InTime.setFont(new Font("Tahoma",Font.BOLD,16));
        panel.add(InTime);

        JLabel label4=new JLabel("Out Time ");
        label4.setBounds(30,230,150,20);
        label4.setFont(new Font("Tahoma",Font.BOLD,16));
        panel.add(label4);

        Date date=new Date();

        JLabel OUTTime=new JLabel(""+date);
        OUTTime.setBounds(200,230,300,20);
        OUTTime.setFont(new Font("Tahoma",Font.BOLD,16));
        panel.add(OUTTime);

        JButton discharge=new JButton("Discharge");
        discharge.setBounds(30,300,120,30);
        discharge.setBackground(Color.BLACK);
        discharge.setForeground(Color.WHITE);
        panel.add(discharge);
        discharge.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                conn c=new conn();
                try {
                    c.statement.executeUpdate("delete from patient_infos where number ='"+choice.getSelectedItem()+"'");
                    c.statement.executeUpdate("Update room set Availabillity ='Available' where room_no='"+RNO.getText()+"'");
                    JOptionPane.showMessageDialog(null,"Done");
                    setVisible(false);


                }catch (Exception E){
                    E.printStackTrace();
                }


            }
        });

        JButton Check=new JButton("Check");
        Check.setBounds(220,300,150,30);
        Check.setBackground(Color.BLACK);
        Check.setForeground(Color.WHITE);
        panel.add(Check);
        Check.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                conn c=new conn();
                try{

                    ResultSet resultSet=c.statement.executeQuery("select * from patient_infos where Number ='"+choice.getSelectedItem()+"'");
                    while (resultSet.next()){
                        RNO.setText(resultSet.getString("Room_NUmber"));
                        InTime.setText(resultSet.getString("Time"));

                    }

                }catch (Exception E){
                    E.printStackTrace();
                }
            }
        });


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
        new patient_discharge();
    }
}
