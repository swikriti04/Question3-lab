package javaproglab;

import net.proteanit.sql.DbUtils;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class Teacher_Info extends JFrame{  //Second Frame

    private JTable table;
    private JTextField textField;
    
    public static void main(String[] args){		 
	new Teacher_Info().setVisible(true);    
    }
    
    public Teacher_Info(){
        
        getContentPane().setBackground(Color.WHITE);
        getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 13));
		
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setSize(860,523);
	setLayout(null);
	setVisible(true);
		
	JLabel Fcode = new JLabel("Teacher Id");
	Fcode.setFont(new Font("Tahoma", Font.PLAIN, 17));
        Fcode.setBounds(50, 100, 200, 30);
	add(Fcode);
	
		
	JLabel FlightDetails = new JLabel("TEACHER INFORMATION");
	FlightDetails.setFont(new Font("Tahoma", Font.PLAIN, 31));
	FlightDetails.setForeground(new Color(100, 149, 237));
	FlightDetails.setBounds(50, 20, 570, 35);
	add(FlightDetails);
		
	JButton btnShow = new JButton("SHOW");
	btnShow.setFont(new Font("Tahoma", Font.PLAIN, 20));
	
        btnShow.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
	
                String code = textField.getText();
                
                try {
                    conn c = new conn();
                    String str = "select name,fname,age,dob,address,phone,student_id from student where student_id = '"+code+"'";
      
                    ResultSet rs = c.s.executeQuery(str);
                    table.setModel(DbUtils.resultSetToTableModel(rs));	
                    
                }catch(SQLException e){
                    e.printStackTrace();
                }
            }
        });

        btnShow.setBounds(220, 150, 120, 30);
	add(btnShow);
		
        table = new JTable();
        table.setBackground(Color.WHITE);
	table.setBounds(23, 250, 800, 300);
        
        JScrollPane pane = new JScrollPane(table);
	pane.setBounds(23, 250, 800, 300);
        pane.setBackground(Color.WHITE);
        add(pane);
		
	textField = new JTextField();
        textField.setBounds(220, 100, 200, 30);
	add(textField);
		
	JLabel FlightCode = new JLabel("NAME");
	FlightCode.setFont(new Font("Tahoma", Font.PLAIN, 13));
        FlightCode.setBounds(60, 220, 126, 14);
	add(FlightCode);
		
	JLabel FlightName = new JLabel("FATHER'S NAME");
        FlightName.setFont(new Font("Tahoma", Font.PLAIN, 13));
	FlightName.setBounds(145, 220, 120, 14);
	add(FlightName);
		
	JLabel Source = new JLabel("AGE");
	Source.setFont(new Font("Tahoma", Font.PLAIN, 13));
	Source.setBounds(295, 220, 104, 14);
	add(Source);
		
	JLabel Destination = new JLabel("D.O.B");
	Destination.setFont(new Font("Tahoma", Font.PLAIN, 13));
	Destination.setBounds(397, 220, 120, 14);
	add(Destination);
		
		
	JLabel Capacity = new JLabel("ADDRESS");
	Capacity.setFont(new Font("Tahoma", Font.PLAIN, 13));
	Capacity.setBounds(497, 220, 111, 14);
	add(Capacity);
		
	JLabel ClassCode = new JLabel("PHONE");
	ClassCode.setFont(new Font("Tahoma", Font.PLAIN, 13));
	ClassCode.setBounds(607, 220, 120, 14);
	add(ClassCode);
		
	JLabel ClassName = new JLabel("TEACHER ID");
	ClassName.setFont(new Font("Tahoma", Font.PLAIN, 13));
	ClassName.setBounds(720, 220, 111, 14);
	add(ClassName);
		
	
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	setSize(900,650);
        setVisible(true);
        setLocation(400,200);
		
    }
}