package Hotel.Management.System;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.util.Date;
@SuppressWarnings("serial")
public class NewCustomer extends JFrame implements ActionListener {

	
	@SuppressWarnings("rawtypes")
	JComboBox comboid,gendercomboid;
	JTextField tfnumber,tfname,tfcountry,tfdeposit;
	JLabel tfcheckintime;
	Choice croom;
	JButton addcustomer,back,exit;
	@SuppressWarnings({ "unchecked", "rawtypes" })
	NewCustomer(){
		setIconImage(Toolkit.getDefaultToolkit().getImage(NewCustomer.class.getResource("/Gallery/hotelicon.png")));
		
		setLayout(null);
		setTitle("New Customer Form");
		setResizable(false);
		getContentPane().setBackground(Color.black);
		
		JLabel custform=new JLabel("New Customer Form");
		custform.setBounds(100,20,300,30);
		custform.setFont(new Font("BERLIN SANS FB DEMI",Font.BOLD,20));
		custform.setForeground(Color.white);
		add(custform);
		
		
		JLabel id=new JLabel("Id");
		id.setBounds(35,80,100,20);
		id.setFont(new Font("Tahoma",Font.PLAIN,18));
		id.setForeground(Color.white);
		add(id);
		
		String option[]= {"Passport","Driving License","Aadhar Card","Pan Card","Voter ID Card"};
		comboid=new JComboBox(option);
		comboid.setBounds(200,80,150,25);
		add(comboid);
		
		JLabel number=new JLabel("Document Number");
		number.setBounds(35,120,150,20);
		number.setFont(new Font("Tahoma",Font.PLAIN,18));
		number.setForeground(Color.white);
		add(number);
		
		tfnumber=new JTextField();
		tfnumber.setBounds(200,120,150,25);
		tfnumber.setBorder(BorderFactory.createEmptyBorder());
		add(tfnumber);
		
		JLabel name=new JLabel("Name");
		name.setBounds(35,160,100,20);
		name.setFont(new Font("Tahoma",Font.PLAIN,18));
		name.setForeground(Color.white);
		add(name);
		
		tfname=new JTextField();
		tfname.setBounds(200,160,150,25);
		tfname.setBorder(BorderFactory.createEmptyBorder());
		add(tfname);
		
		JLabel gender=new JLabel("Gender");
		gender.setBounds(35,200,100,20);
		gender.setFont(new Font("Tahoma",Font.PLAIN,18));
		gender.setForeground(Color.white);
		add(gender);
		
		String genderoption[]= {"Male","Female","Other","Not Specified"};
		gendercomboid=new JComboBox(genderoption);
		gendercomboid.setBounds(200,200,150,25);
		add(gendercomboid);
		
		JLabel Country=new JLabel("Country");
		Country.setBounds(35,240,100,20);
		Country.setFont(new Font("Tahoma",Font.PLAIN,18));
		Country.setForeground(Color.white);
		add(Country);
		
		tfcountry=new JTextField();
		tfcountry.setBounds(200,240,150,25);
		tfcountry.setBorder(BorderFactory.createEmptyBorder());
		add(tfcountry);
		
		JLabel roomnumber=new JLabel("Room Number");
		roomnumber.setBounds(35,280,150,20);
		roomnumber.setFont(new Font("Tahoma",Font.PLAIN,18));
		roomnumber.setForeground(Color.white);
		add(roomnumber);
		
		croom=new Choice();
		try {
			Conn c=new Conn();
			String query="select * from room where available='Available'";
			ResultSet rs=c.s.executeQuery(query);
			while(rs.next()) {
				croom.add(rs.getString("roomnumber"));
			}
		}
			catch(Exception e) {
				e.printStackTrace();
			}
		
		croom.setBounds(200,280,150,25);
		add(croom);
		
		JLabel checkintime=new JLabel("Check in Time");
		checkintime.setBounds(35,320,150,20);
		checkintime.setFont(new Font("Tahoma",Font.PLAIN,18));
		checkintime.setForeground(Color.white);
		add(checkintime);
		
		Date dates=new Date();
		tfcheckintime =new JLabel(" "+dates);
		tfcheckintime.setBounds(200,320,150,20);
		tfcheckintime.setForeground(Color.white);
		add(tfcheckintime);
		

		JLabel deposit=new JLabel("Deposit");
		deposit.setBounds(35,360,150,20);
		deposit.setFont(new Font("Tahoma",Font.PLAIN,18));
		deposit.setForeground(Color.white);
		add(deposit);
	
		
		tfdeposit =new JTextField();
		tfdeposit.setBounds(200,360,150,20);
		tfdeposit.setBorder(BorderFactory.createEmptyBorder());
		add(tfdeposit);
		
		addcustomer=new JButton("Add Customer");
		addcustomer.setBounds(50,410,120,40);
		addcustomer.setBackground(Color.red);
		addcustomer.setForeground(Color.white);
		addcustomer.addActionListener(this);
		add(addcustomer);
		
		
		back=new JButton("Back");
		back.setBounds(210,410,120,40);
		back.setBackground(Color.red);
		back.setForeground(Color.white);
		back.addActionListener(this);
		add(back);
		
		exit=new JButton("Exit");
		exit.setBounds(650,410,120,40);
		exit.setFont(new Font("Tahoma",Font.PLAIN,18));
		exit.setBackground(Color.black);
		exit.setForeground(Color.white);
		exit.addActionListener(this);
		add(exit);
		
		
		
		ImageIcon i1 = new ImageIcon(NewCustomer.class.getResource("/Gallery/newcust.png"));
		Image i2=i1.getImage().getScaledInstance(300,300,Image.SCALE_DEFAULT);
		ImageIcon i3=new ImageIcon(i2);
		JLabel image=new JLabel(i3);
		image.setBounds(400,100,300,300);
		add(image);
		
		
		
		
		setBounds(350,200,800,500);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new NewCustomer();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==addcustomer) {
			String id=(String) comboid.getSelectedItem();
			String contact=tfnumber.getText();
			String name=tfname.getText();
			String gender=(String)gendercomboid.getSelectedItem();
			String country=tfcountry.getText();
		    String room=croom.getSelectedItem();
		    String time=tfcheckintime.getText();
		    String deposit=tfdeposit.getText();
		  	if(contact.equals("")) {
				JOptionPane.showMessageDialog(null,"Document Number Should not be Empty");
				return;
			}  
			if(name.equals("")) {
				JOptionPane.showMessageDialog(null,"Name Should not be Empty");
				return;
			}  
			if(country.equals("")) {
				JOptionPane.showMessageDialog(null,"Country Should not be Empty");
				return;
			}  
			if(deposit.equals("")) {
				JOptionPane.showMessageDialog(null,"Deposit Should not be Empty");
				return;
			}  
		try {
			String query="insert into newcustomer values ('"+id+"','"+contact+"','"+name+"','"+gender+"','"+country+"','"+room+"','"+time+"','"+deposit+"')";
			String query2="update room set available='Occupied' where roomnumber='"+room+"'";
			Conn c=new Conn();
			c.s.executeUpdate(query);
			c.s.executeUpdate(query2);
			JOptionPane.showMessageDialog(null,"New Customer Added Sucessfully");
			setVisible(false);
			 new Reception();
		}
		catch(Exception e1) {
			e1.printStackTrace();
		}
		}
		else if(e.getSource()==back) {
			setVisible(false);
			 new Reception();
		}
		else if(e.getSource()==exit) {
			setVisible(false);
			
		}
		    
		    
		    
		}
	}


