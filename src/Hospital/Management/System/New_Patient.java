package Hospital.Management.System;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.Expression;
import java.sql.ResultSet;
import java.util.Date;

public class New_Patient extends JFrame implements ActionListener {

    JComboBox comboBox;
    JTextField textFieldNumber,textName,textfieldDisease,textfieldDeposit;
    JRadioButton r1,r2;
    Choice c1;
    JLabel date;
    JButton b1,b2;
    New_Patient(){
        JPanel panel=new JPanel();
        panel.setBounds(5,5,840,540);
        panel.setBackground(new Color(90,156,163));
        panel.setLayout(null);
        add(panel);

        ImageIcon imageIcon=new ImageIcon(ClassLoader.getSystemResource("Icon/patient.jpg"));
        Image image= imageIcon.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1=new ImageIcon(image);
        JLabel label=new JLabel(imageIcon1);
        label.setBounds(550,150,200,200);
        panel.add(label);


        JLabel labelName= new JLabel("NEW PATIENT FORM");
        labelName.setBounds(118,11,260,53);
        labelName.setFont(new Font("Tahoma",Font.BOLD,20));
        panel.add(labelName);

        JLabel labelID= new JLabel("ID :");
        labelID.setBounds(35,76,200,14);
        labelID.setFont(new Font("Tahoma",Font.BOLD,18));
        labelID.setForeground(Color.WHITE);
        panel.add(labelID);

        comboBox =new JComboBox(new String[]{"Aadhar Card","Voter ID","Driving Licence"});
        comboBox.setBounds(271,73,150,20);
        comboBox.setBackground(new Color(3,45,48));
        comboBox.setForeground(Color.WHITE);
        comboBox.setFont(new Font("Tahoma",Font.BOLD,18));
        panel.add(comboBox);

        JLabel labelNumber= new JLabel("Number :");
        labelNumber.setBounds(35,111,200,14);
        labelNumber.setFont(new Font("Tahoma",Font.BOLD,18));
        labelNumber.setForeground(Color.WHITE);
        panel.add(labelNumber);

        textFieldNumber=new JTextField();
        textFieldNumber.setBounds(271,111,150,20);
        panel.add(textFieldNumber);

        JLabel labelName1= new JLabel("Name :");
        labelName1.setBounds(35,151,200,14);
        labelName1.setFont(new Font("Tahoma",Font.BOLD,18));
        labelName1.setForeground(Color.WHITE);
        panel.add(labelName1);

        textName=new JTextField();
        textName.setBounds(271,151,150,20);
        panel.add(textName);

        JLabel labelGender= new JLabel("Gender :");
        labelGender.setBounds(35,191,200,14);
        labelGender.setFont(new Font("Tahoma",Font.BOLD,18));
        labelGender.setForeground(Color.WHITE);
        panel.add(labelGender);
        r1=new JRadioButton("Male");
        r1.setFont(new Font("Tahoma",Font.BOLD,18));
        r1.setForeground(Color.WHITE);
        r1.setBackground(new Color(169,164,170));
        r1.setBounds(271,191,80,16);
        panel.add(r1);

        r2=new JRadioButton("Female");
        r2.setFont(new Font("Tahoma",Font.BOLD,18));
        r2.setForeground(Color.WHITE);
        r2.setBackground(new Color(169,164,170));
        r2.setBounds(350,191,100,16);
        panel.add(r2);


        JLabel labelDisease= new JLabel("Disease :");
        labelDisease.setBounds(35,231,200,14);
        labelDisease.setFont(new Font("Tahoma",Font.BOLD,18));
        labelDisease.setForeground(Color.WHITE);
        panel.add(labelDisease);

        textfieldDisease=new JTextField();
        textfieldDisease.setBounds(271,231,150,20);
        panel.add(textfieldDisease);

        JLabel labelRoom= new JLabel("Room :");
        labelRoom.setBounds(35,274,200,14);
        labelRoom.setFont(new Font("Tahoma",Font.BOLD,18));
        labelRoom.setForeground(Color.WHITE);
        panel.add(labelRoom);


        c1=new Choice();
        try{
            conn c=new conn();
            ResultSet resultSet=c.statement.executeQuery("select * from Room");
            while (resultSet.next()){
                c1.add(resultSet.getString("room_no"));
            }


        }catch (Exception e){
            e.printStackTrace();
        }
        c1.setBounds(271,274,150,20);
        c1.setFont(new Font("Tahoma",Font.BOLD,14));
        c1.setForeground(Color.white);
        c1.setBackground(new Color(3,45,48));
        panel.add(c1);

        JLabel labelDate= new JLabel("Time :");
        labelDate.setBounds(35,316,200,14);
        labelDate.setFont(new Font("Tahoma",Font.BOLD,18));
        labelDate.setForeground(Color.WHITE);
        panel.add(labelDate);
        Date date1=new Date();
        date =new JLabel(""+date1);
        date.setBounds(271,316,300,14);
        date.setForeground(Color.WHITE);
        date.setFont(new Font("Tahoma",Font.BOLD,18));
        panel.add(date);

        JLabel labelDeposite= new JLabel("Deposite :");
        labelDeposite.setBounds(35,359,200,14);
        labelDeposite.setFont(new Font("Tahoma",Font.BOLD,18));
        labelDeposite.setForeground(Color.WHITE);
        panel.add(labelDeposite);

        textfieldDeposit=new JTextField();
        textfieldDeposit.setBounds(271,359,150,20);
        panel.add(textfieldDeposit);


        b1=new JButton("Add");
        b1.setBounds(100,430,120,30);
        b1.setForeground(Color.WHITE);
        b1.setBackground(Color.BLACK);
        b1.addActionListener(this);
        panel.add(b1);

        b2=new JButton("Back");
        b2.setBounds(260,430,120,30);
        b2.setForeground(Color.WHITE);
        b2.setBackground(Color.BLACK);
        b2.addActionListener(this);
        panel.add(b2);







        setSize(850,550);
        setLayout(null);
        setLocation(300,250);
        setVisible(true);


    }
    public static void main(String[]args){
        new New_Patient();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==b1){
            conn c=new conn();
            String radioBTN =null;
            if(r1.isSelected()){
                radioBTN="Male";

            }else if(r2.isSelected()){
                radioBTN="Female";
            }
            String s1=(String)comboBox.getSelectedItem();
            String s2=textFieldNumber.getText();
            String s3=textName.getText();
            String s4=radioBTN;
            String s5=textfieldDisease.getText();
            String s6=c1.getSelectedItem();
            String s7=date.getText();
            String s8=textfieldDeposit.getText();
            try{
                String q="insert into patient_infos values('"+s1+"','"+s2+"','"+s3+"','"+s4+"','"+s5+"','"+s6+"','"+s7+"','"+s8+"')";
                String q1="update room set Availabillity ='Occupied' where room_no="+s6;
                c.statement.executeUpdate(q);
                c.statement.executeUpdate(q1);
                JOptionPane.showMessageDialog(null,"Added Successfully");
                setVisible(false);

            }catch (Exception E){
                E.printStackTrace();
            }


        }else{
            setVisible(false);
        }

    }
}
