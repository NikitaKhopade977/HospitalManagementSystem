package Hospital.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.Time;

public class Update_Patient_Details extends JFrame {
    Update_Patient_Details(){

        JPanel panel=new JPanel();
        panel.setBounds(5,5,980,590);
        panel.setBackground(new Color(90,156,163));
        panel.setLayout(null);
        add(panel);

        ImageIcon imageIcon=new ImageIcon(ClassLoader.getSystemResource("Icon/update.jpg"));
        Image image= imageIcon.getImage().getScaledInstance(400,300,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1=new ImageIcon(image);
        JLabel label1=new JLabel(imageIcon1);
        label1.setBounds(500,80,300,300);
        panel.add(label1);

        JLabel label=new JLabel("Update Patient Details");
        label.setBounds(124,11,300,25);
        label.setFont(new Font("Tahoma",Font.BOLD,20));
        label.setForeground(Color.WHITE);
        panel.add(label);

        JLabel label2=new JLabel("Name :");
        label2.setBounds(25,88,200,16);
        label2.setFont(new Font("Tahoma",Font.BOLD,16));
        label2.setForeground(Color.WHITE);
        panel.add(label2);

        Choice choice=new Choice();
        choice.setBounds(248,85,100,25);
        panel.add(choice);

        try{
            conn c=new conn();
            ResultSet resultSet= c.statement.executeQuery("select * from patient_infos");
            while (resultSet.next()){
                choice.add(resultSet.getString("Name"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        JLabel label3=new JLabel("Room Number :");
        label3.setBounds(25,130,200,16);
        label3.setFont(new Font("Tahoma",Font.BOLD,16));
        label3.setForeground(Color.WHITE);
        panel.add(label3);

        JTextField textFieldR=new JTextField();
        textFieldR.setBounds(248,129,150,20);
        panel.add(textFieldR);

        JLabel label4=new JLabel("In - Time :");
        label4.setBounds(25,174,150,16);
        label4.setFont(new Font("Tahoma",Font.BOLD,16));
        label4.setForeground(Color.WHITE);
        panel.add(label4);

        JTextField textFieldINTime=new JTextField();
        textFieldINTime.setBounds(248,174,150,20);
        panel.add(textFieldINTime);

        JLabel label5=new JLabel("Amount Paid (Rs):");
        label5.setBounds(25,216,150,16);
        label5.setFont(new Font("Tahoma",Font.BOLD,16));
        label5.setForeground(Color.WHITE);
        panel.add(label5);

        JTextField textFieldAmount=new JTextField();
        textFieldAmount.setBounds(248,216,150,20);
        panel.add(textFieldAmount);

        JLabel label6=new JLabel("Pending Amount (Rs) :");
        label6.setBounds(25,261,150,18);
        label6.setFont(new Font("Tahoma",Font.BOLD,16));
        label6.setForeground(Color.WHITE);
        panel.add(label6);

        JTextField textFieldpending=new JTextField();
        textFieldpending.setBounds(248,261,150,20);
        panel.add(textFieldpending);

        JButton check =new JButton("Check");
        check.setBounds(281,378,89,23);
        check.setBackground(Color.BLACK);
        check.setForeground(Color.WHITE);
        panel.add(check);
        check.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id =choice.getSelectedItem();
                String q="select * from patient_infos where Name ='"+id+"'";
                try{
                    conn c=new conn();
                    ResultSet resultSet=c.statement.executeQuery(q);
                    while (resultSet.next()){
                        textFieldR.setText(resultSet.getString("Room_number"));
                        textFieldINTime.setText(resultSet.getString("Time"));
                        textFieldAmount.setText(resultSet.getString("Deposit"));


                    }
                    ResultSet resultSet1=c.statement.executeQuery("select * from Room where room_no ='"+textFieldR.getText()+"'");
                    while (resultSet1.next()){
                        String price =resultSet1.getString("price");
                        int amountpaid =Integer.parseInt(price)-Integer.parseInt(textFieldAmount.getText());
                        textFieldpending.setText(""+amountpaid);
                    }
                }catch (Exception E){
                    E.printStackTrace();
                }
            }
        });

        JButton Update=new JButton("Update");
        Update.setBounds(56,378,89,23);
        Update.setBackground(Color.BLACK);
        Update.setForeground(Color.WHITE);
        panel.add(Update);
        Update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    conn c= new conn();
                    String q=choice.getSelectedItem();
                    String room =textFieldR.getText();
                    String time=textFieldINTime.getText();
                    String amount=textFieldAmount.getText();
                    c.statement.executeUpdate("update patient_infos set Room_number='"+room+"',Time='"+time+"',Deposit='"+amount+"' where Name='"+q+"'");
                    JOptionPane.showMessageDialog(null,"Updated Successfully");
                    setVisible(false);


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
        new Update_Patient_Details();
    }
}
