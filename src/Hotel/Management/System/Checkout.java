package Hotel.Management.System;
import javax.swing.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.util.Date;
import java.awt.*;
@SuppressWarnings("serial")
public class Checkout extends JFrame implements ActionListener {

	Choice tfcustomer;
	JLabel tfroomnumber,tfcheckin;
	JLabel tfcheckout;
	JButton back,check,checkout;
	Checkout(){
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(Checkout.class.getResource("/Gallery/hotelicon.png")));
		setLayout(null);
		setResizable(false);
		setTitle("Check Out");
		getContentPane().setBackground(Color.white);
		
		
		JLabel text=new JLabel("Check Out");
		text.setBounds(130, 20, 200, 30);
		text.setFont(new Font("Tahoma",Font.BOLD,18));
		text.setForeground(Color.black);
		add(text);
		
		
		JLabel custid=new JLabel("Customer ID");
		custid.setBounds(30, 80, 100, 20);
		custid.setForeground(Color.black);
		add(custid);
		
		
		tfcustomer=new Choice();
		tfcustomer.setBounds(200,80,150,25);
		add(tfcustomer);
		

		try {
			Conn c=new Conn();
			ResultSet rs=c.s.executeQuery("Select * from newcustomer");
			while(rs.next()) {
				tfcustomer.add(rs.getString("contact"));
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	    JLabel roomnumber=new JLabel("Room Number");
		roomnumber.setBounds(30,130, 100, 20);
		roomnumber.setForeground(Color.black);
		add(roomnumber);
		
		tfroomnumber=new JLabel();
		tfroomnumber.setBounds(200,130,150,25);
		add(tfroomnumber);
		
		JLabel checkin=new JLabel("Check in Time");
		checkin.setBounds(30,180, 100, 20);
		checkin.setForeground(Color.black);
		add(checkin);
		
		tfcheckin=new JLabel();
		tfcheckin.setBounds(195,180,150,25);
		add(tfcheckin);
		
		JLabel checkout1=new JLabel("Check Out Time");
		checkout1.setBounds(30,230, 100, 20);
		checkout1.setForeground(Color.black);
		add(checkout1);
		
		Date date=new Date();
		tfcheckout=new JLabel(" "+date);
		tfcheckout.setBounds(195,230,150,25);
		add(tfcheckout);
		
		ImageIcon i4 = new ImageIcon(Checkout.class.getResource("/Gallery/checkout.jpg"));
	    Image i5=i4.getImage().getScaledInstance(400,250,Image.SCALE_DEFAULT);
		ImageIcon i6=new ImageIcon(i5);
		JLabel image=new JLabel(i6);
		image.setBounds(380,50,400,250);
	    add(image);
	        
	    check=new JButton("Check");
		check.setBounds(30,300,100,30);
		check.setBackground(Color.red);
		check.setForeground(Color.white);
		check.addActionListener(this);
		add(check);
		
		checkout=new JButton("Check Out");
		checkout.setBounds(150,300,100,30);
		checkout.setBackground(Color.red);
		checkout.setForeground(Color.white);
		checkout.addActionListener(this);
		add(checkout);
		
		back=new JButton("Back");
		back.setBounds(270,300,100,30);
		back.setBackground(Color.red);
		back.setForeground(Color.white);
		back.addActionListener(this);
		add(back);
	    	
		setBounds(300,220,800,400);
		setVisible(true);
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
               new Checkout();
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==checkout) {
			String query1="delete from newcustomer where contact='"+tfcustomer.getSelectedItem()+"'";
			String query2="update room set available='Available' where roomnumber='"+tfroomnumber.getText()+"'";
      try {
    	  Conn c=new Conn();
    	  c.s.executeUpdate(query1);
    	  c.s.executeUpdate(query2);
    	  JOptionPane.showMessageDialog(null,"Check Out is Done");
    	  setVisible(false);
      }
		catch(Exception e1) {
			e1.printStackTrace();
		}
		}
		else if(e.getSource()==back) {
			setVisible(false);
			 new Reception();
		}
	
	else if(e.getSource()==check) {
		String id=tfcustomer.getSelectedItem();
		String query="Select * from newcustomer where contact='"+id+"'";
		try {
			Conn c=new Conn();
			ResultSet rs=c.s.executeQuery(query);
			while(rs.next()) {
				tfroomnumber.setText(rs.getString("room"));
				tfcheckin.setText(rs.getString("time"));
			}
			ResultSet rs2=c.s.executeQuery("Select * from room where roomnumber='"+tfroomnumber.getText()+"'");
			while(rs2.next()) {
			
			}
		}
		catch(Exception e1) {
			e1.printStackTrace();
		}
	}
	}

}
