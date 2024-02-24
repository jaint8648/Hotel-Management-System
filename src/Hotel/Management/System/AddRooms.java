package Hotel.Management.System;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
@SuppressWarnings("serial")
public class AddRooms extends JFrame implements ActionListener {

	JTextField tfroomnumber,tfprice;
	JButton addroo,cancel;
	@SuppressWarnings("rawtypes")
	JComboBox availablecombo,cleancombo,bedcombo;
	@SuppressWarnings({ "unchecked", "rawtypes" })
	AddRooms(){
		setIconImage(Toolkit.getDefaultToolkit().getImage(AddRooms.class.getResource("/Gallery/hotelicon.png")));
		setTitle("Add Rooms");
		getContentPane().setBackground(Color.black);
		setBounds(210,190,940,450);
		setResizable(false);
		setLayout(null);
		
		JLabel addrooms=new JLabel("Add Rooms");
		addrooms.setBounds(150, 35, 200, 20);
		addrooms.setFont(new Font("Century Schoolbook",Font.BOLD,20));
		addrooms.setForeground(Color.white);
		add(addrooms);
		
		JLabel roomnumber=new JLabel("Room Number");
		roomnumber.setBounds(60, 80, 200, 30);
		roomnumber.setFont(new Font("Tahoma",Font.PLAIN,16));
		roomnumber.setForeground(Color.white);
		add(roomnumber);
		
		tfroomnumber=new JTextField();
		tfroomnumber.setBounds(200,80,150,30);
		tfroomnumber.setBorder(BorderFactory.createEmptyBorder());
		add(tfroomnumber);
		
		JLabel available=new JLabel("Available");
		available.setBounds(60, 130, 120, 30);
		available.setFont(new Font("Tahoma",Font.PLAIN,16));
		available.setForeground(Color.white);
		add(available);
		
		String availableoption[]= {"Available","Occupied"};
		availablecombo=new JComboBox(availableoption);
		availablecombo.setBounds(200, 130, 150, 30);
		availablecombo.setBackground(Color.white);
		availablecombo.setBorder(BorderFactory.createEmptyBorder());
		add(availablecombo);
		
		JLabel cleaningstatus=new JLabel("Cleaning Status");
		cleaningstatus.setForeground(Color.white);
		cleaningstatus.setBounds(60, 180, 120, 30);
		cleaningstatus.setFont(new Font("Tahoma",Font.PLAIN,16));
		add(cleaningstatus);
		
		String cleanoption[]= {"Cleaned","Dirty"};
		cleancombo=new JComboBox(cleanoption);
		cleancombo.setBounds(200, 180, 150, 30);
		cleancombo.setBackground(Color.white);
		cleancombo.setBorder(BorderFactory.createEmptyBorder());
		add(cleancombo);	
		
		JLabel price=new JLabel("Price");
		price.setBounds(60, 230,120,30);
		price.setForeground(Color.white);
		price.setFont(new Font("Tahoma",Font.PLAIN,16));
		add(price);
		
		tfprice=new JTextField();
		tfprice.setBounds(200,230,150,30);
		tfprice.setBorder(BorderFactory.createEmptyBorder());
		add(tfprice);
		
		JLabel bedtype=new JLabel("Bed Type");
		bedtype.setBounds(60, 280, 120, 30);
		bedtype.setForeground(Color.white);
		bedtype.setFont(new Font("Tahoma",Font.PLAIN,16));
		add(bedtype);
		
		String bedoption[]= {"Single Bed","Double Bed"};
		bedcombo=new JComboBox(bedoption);
		bedcombo.setBounds(200, 280, 150, 30);
		bedcombo.setBackground(Color.white);
		add(bedcombo);	
		
		addroo=new JButton("Add Rooms");
		addroo.setBounds(60,350,130,30);
		addroo.setBackground(Color.red);
		addroo.setBorder(BorderFactory.createEmptyBorder());
		addroo.setForeground(Color.white);
		addroo.setFont(new Font("Tahoma",Font.PLAIN,16));
		addroo.addActionListener(this);
		add(addroo);
		
		cancel=new JButton("Back");
		cancel.setBounds(220,350,130,30);
		cancel.addActionListener(this);
		cancel.setBackground(Color.red);
		cancel.setBorder(BorderFactory.createEmptyBorder());
		cancel.setForeground(Color.white);
		cancel.setFont(new Font("Tahoma",Font.PLAIN,16));
		add(cancel);
		
		ImageIcon i1 = new ImageIcon(AddRooms.class.getResource("/Gallery/rooming.jpg"));
	    Image i2=i1.getImage().getScaledInstance(500,300,Image.SCALE_DEFAULT);
		ImageIcon i3=new ImageIcon(i2);
		JLabel image=new JLabel(i3);
		image.setBounds(400,60,500,300);
	    add(image);
		
		
		
		
		
		
		setVisible(true);
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new AddRooms();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==addroo) {
			String roomnumber=tfroomnumber.getText();
		      String available=(String)availablecombo.getSelectedItem();
		       String clean=(String)cleancombo.getSelectedItem(); 
		      String price=tfprice.getText();
		      String bed=(String)bedcombo.getSelectedItem();
		  	if(roomnumber.equals("")) {
				JOptionPane.showMessageDialog(null,"Room Number Should not be Empty");
				return;
			}  
		  	if(price.equals("")) {
				JOptionPane.showMessageDialog(null,"Price Should not be Empty");
				return;
			}  
		      try {
		    	  Conn c=new Conn();
		    	  String str="insert into room values('"+roomnumber+"','"+available+"','"+clean+"','"+price+"','"+bed+"')";
		    	  c.s.executeUpdate(str);
		    	  JOptionPane.showMessageDialog(null,"New Room Added Sucesfully");

		      }
		      catch(Exception e1) {
		    	  e1.printStackTrace();
		      }
		}
		else if(e.getSource()==cancel) {
                 setVisible(false);		
                
	}

}
}




