package Hotel.Management.System;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.awt.*;

@SuppressWarnings("serial")
public class SearchRoom extends JFrame implements ActionListener {
    JCheckBox available;
	@SuppressWarnings("rawtypes")
	JComboBox combobed;
	JTable table;
	JButton submit,back;
	@SuppressWarnings({ "unchecked", "rawtypes" })
	SearchRoom(){
		setIconImage(Toolkit.getDefaultToolkit().getImage(SearchRoom.class.getResource("/Gallery/hotelicon.png")));
		setLayout(null);
		setTitle("Search Room");
		setResizable(false);
		getContentPane().setBackground(Color.black);
	    
		JLabel text=new JLabel("Search Rooms");
		text.setBounds(400,30,200,30);
		text.setForeground(Color.blue);
		text.setFont(new Font("Tahoma",Font.BOLD,25));
	    add(text);
	
	    JLabel bedtype=new JLabel("Bed Type");
	    bedtype.setBounds(50,100,100,20);
	    bedtype.setForeground(Color.white);
	    bedtype.setFont(new Font("Tahoma",Font.PLAIN,18));
		add(bedtype);
		
		combobed=new JComboBox(new String[]{"Single Bed","Double Bed"});		
		combobed.setBounds(150,100,150,25);
		combobed.setFont(new Font("Tahoma",Font.PLAIN,15));
		combobed.setForeground(Color.white);
		combobed.setBackground(Color.black);
		add(combobed);
		
		
		available=new JCheckBox("Only Display Available");
		available.setBounds(650,100,200,25);
		available.setFont(new Font("Tahoma",Font.PLAIN,18));
		available.setBackground(Color.black);
		available.setForeground(Color.white);
		add(available);
		
		table=new JTable();
		 table.setBounds(0,200,1000,300);
		 table.setForeground(Color.white);
		 table.setBackground(Color.black);
		 add(table);

		 try {
			 Conn c=new Conn();
			 String query="Select * from room";
			 ResultSet rs=c.s.executeQuery(query);
			 ResultSetMetaData rsmd=rs.getMetaData();
			 DefaultTableModel model=  (DefaultTableModel) table.getModel();
			 int cols=rsmd.getColumnCount();
			 String [] colName=new String[cols];
			 for(int i=0;i<cols;i++)
			 colName[i]=rsmd.getColumnName(i+1);
			 model.setColumnIdentifiers(colName);
			 

			 String roomnumber,available,clean,price,bed;
			 while(rs.next()) {
				roomnumber=rs.getString(1);
				available=rs.getString(2);
				clean=rs.getString(3);
				price=rs.getString(4);
				bed=rs.getString(5);
				String[] row= {roomnumber,available,clean,price,bed};
				model.addRow(row);
			 }
		 }
		 catch(Exception e) {
			 e.printStackTrace();
		 }
		 JLabel roomnumber=new JLabel("Room Number");
		 roomnumber.setBounds(50,160,100,20);
		 roomnumber.setForeground(Color.white);
		 add(roomnumber);
		 
		 JLabel available=new JLabel("Availability");
		 available.setBounds(270,160,100,20);
		 available.setForeground(Color.white);
		 add(available);
		 
		 JLabel status=new JLabel("Cleaning Status");
		 status.setBounds(450,160,100,20);
		 status.setForeground(Color.white);
		 add(status);
		 
		 JLabel price=new JLabel("Price");
		 price.setForeground(Color.white);
		 price.setBounds(670,160,100,20);
		 add(price);
		 
		 JLabel bedtype1=new JLabel("Bed Type");
		 bedtype1.setBounds(870,160,100,20);
		 bedtype1.setForeground(Color.white);
		 add(bedtype1);
		 
		setBounds(150,100,1050,600);
		setVisible(true);
		
		submit=new JButton("Submit");
		submit.setBounds(300,520,120,30);
		submit.setBackground(Color.red);
		submit.setForeground(Color.white);

		submit.addActionListener(this);
		add(submit);
	
					
		back=new JButton("Back");
		back.setBounds(500,520,120,30);
		back.setBackground(Color.red);
		back.setForeground(Color.white);

		back.addActionListener(this);
		add(back);
		
		
		
		setBounds(150,100,1000,600);
		setVisible(true);
	}
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
new SearchRoom();
	}

	
	
	
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==submit) {
			try {
				String query1="Select * from room where bed='"+combobed.getSelectedItem()+"'";
				String query2="Select * from room where available='Available'and bed='"+combobed.getSelectedItem()+"'";
			Conn c=new Conn();
			ResultSet rs;
			if(available.isSelected()) {
				rs=c.s.executeQuery(query2);
			}
			else {
				rs=c.s.executeQuery(query1);
			}
			 DefaultTableModel model = (DefaultTableModel) table.getModel();
	            model.setRowCount(0); 

	            while (rs.next()) {
	                String roomnumber = rs.getString(1);
	                String availability = rs.getString(2);
	                String clean = rs.getString(3);
	                String price = rs.getString(4);
	                String bed = rs.getString(5);
	                String[] row = { roomnumber, availability, clean, price, bed };
	                model.addRow(row);
	            }
	        } catch (Exception e1) {
	            e1.printStackTrace();
	        } finally {
	            // Close ResultSet and other resources if needed
	        }
			 }

			
		
		else if(e.getSource()==back) {
			setVisible(false);
			new Reception();
		}
	}

}
