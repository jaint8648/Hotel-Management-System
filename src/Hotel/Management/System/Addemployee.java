package Hotel.Management.System;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
@SuppressWarnings("serial")
public class Addemployee extends JFrame implements ActionListener {

	
	JTextField tfname,tfage,tfsalary,tfphone,tfemail,tfaadhar;
	JRadioButton male,female;
	@SuppressWarnings("rawtypes")
	JComboBox cbjob; 
	JButton submit;
	ButtonGroup bg;
	@SuppressWarnings({ "unchecked", "rawtypes" })
	Addemployee(){
		setIconImage(Toolkit.getDefaultToolkit().getImage(Addemployee.class.getResource("/Gallery/hotelicon.png")));
		setTitle("Add Employee");
		setLayout(null);
		getContentPane().setBackground(Color.black);
	    setResizable(false);
		setBounds(300,180,850,510);
		
		
		JLabel name=new JLabel("Name");
		name.setBounds(60,30,120,30);
		name.setForeground(Color.white);
		name.setFont(new Font("Tahoma",Font.BOLD,17));
		add(name);
		
	    tfname=new JTextField();
		tfname.setBounds(200, 30, 150, 30);
		tfname.setBorder(BorderFactory.createEmptyBorder());
		add(tfname);
		
		JLabel age=new JLabel("Age");
		age.setForeground(Color.white);
		age.setBounds(60,80,120,30);
		age.setFont(new Font("Tahoma",Font.BOLD,17));
		add(age);
		
	    tfage=new JTextField();
		tfage.setBounds(200, 80, 150, 30);
		tfage.setBorder(BorderFactory.createEmptyBorder());
		add(tfage);
		

		JLabel gender=new JLabel("Gender");
		gender.setForeground(Color.white);
		gender.setBounds(60,130,120,30);
		gender.setFont(new Font("Tahoma",Font.BOLD,17));
		add(gender);
		
		
		male=new JRadioButton("Male");
		male.setBounds(200,130,70,30);
		male.setForeground(Color.white);
		male.setBorder(BorderFactory.createEmptyBorder());
		male.setBackground(Color.black);
		add(male);
		
		female=new JRadioButton("Female");
		female.setBounds(280,130,70,30);
		female.setForeground(Color.white);
		female.setBackground(Color.black);
		add(female);
		
		bg=new ButtonGroup();
		bg.add(male);
		bg.add(female);
		
		JLabel job=new JLabel("Job");
		job.setForeground(Color.white);
		job.setBounds(60,180,120,30);
		job.setFont(new Font("Tahoma",Font.BOLD,17));
		add(job);
		
		String job1[]= {"Front Desk","Porters","HouseKeeping Staff","Kitchen Staff","Room Service","Chef","Manager","IT Executive","Receptionist","Telecaller","Bell Boy","Bartender","Security Officer"};
        cbjob=new JComboBox(job1);		
        cbjob.setBorder(BorderFactory.createEmptyBorder());
		cbjob.setBounds(200,180,150,30);
		add(cbjob);
		
		JLabel salary=new JLabel("Salary");
		salary.setForeground(Color.white);
		salary.setBounds(60,230,120,30);
		salary.setFont(new Font("Tahoma",Font.BOLD,17));
		add(salary);
		
	    tfsalary=new JTextField();
	    tfsalary.setBounds(200, 230, 150, 30);
	    tfsalary.setBorder(BorderFactory.createEmptyBorder());
		add(tfsalary);
	
		JLabel phone=new JLabel("Contact");
		phone.setForeground(Color.white);
		phone.setBounds(60,280,120,30);
		phone.setFont(new Font("Tahoma",Font.BOLD,17));
		add(phone);
		
	    tfphone=new JTextField();
	    tfphone.setBounds(200, 280, 150, 30);
	    tfphone.setBorder(BorderFactory.createEmptyBorder());
		add(tfphone);
		
		JLabel email=new JLabel("Email");
		email.setForeground(Color.white);
		email.setBounds(60,330,120,30);
		email.setFont(new Font("Tahoma",Font.BOLD,17));
		add(email);
		
	    tfemail=new JTextField();
	    tfemail.setBounds(200, 330, 150, 30);
	    tfemail.setBorder(BorderFactory.createEmptyBorder());
	    add(tfemail);
	
		JLabel aadhar=new JLabel("Aadhar Card");
		aadhar.setForeground(Color.white);
		aadhar.setBounds(60,380,120,30);
		aadhar.setFont(new Font("Tahoma",Font.BOLD,17));
		add(aadhar);
		
	    tfaadhar=new JTextField();
	    tfaadhar.setBounds(200,380, 150, 30);
	    tfaadhar.setBorder(BorderFactory.createEmptyBorder());
	    add(tfaadhar);
	
	    JButton submit=new JButton("Submit");
	    submit.setBackground(Color.red);
	    submit.setForeground(Color.white);
	    submit.setFont(new Font("Tahoma",Font.BOLD,17));
	    submit.setBounds(200,430,150,30);
	    submit.addActionListener(this);
	    submit.setBorder(BorderFactory.createEmptyBorder());
	    add(submit);
	      

		ImageIcon i1 = new ImageIcon(Addemployee.class.getResource("/Gallery/hotelstaff.jpg"));
	    Image i2=i1.getImage().getScaledInstance(400,400,Image.SCALE_DEFAULT);
		ImageIcon i3=new ImageIcon(i2);
		JLabel image=new JLabel(i3);
		image.setBounds(390,30,400,400);
	    add(image);
		
		
		
		
		
		
		
		setVisible(true);
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
             new Addemployee();
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	
		String name=tfname.getText();
		String age=tfage.getText();
		String salary=tfsalary.getText();
		String phone=tfphone.getText();
		String email=tfemail.getText();
		String aadhar=tfaadhar.getText();

		if(name.equals("")) {
			JOptionPane.showMessageDialog(null,"Name Should not be Empty");
			return;
		}
		if(age.equals("")) {
			JOptionPane.showMessageDialog(null,"Age Should not be Empty");
			return;
		}
	     if (bg.getSelection() == null) {
	            JOptionPane.showMessageDialog(null, "Gender is not selected");
	            return;
	        }
	 	if(salary.equals("")) {
			JOptionPane.showMessageDialog(null,"Salary Should not be Empty");
			return;
		}
	 	if(phone.equals("")) {
			JOptionPane.showMessageDialog(null,"Contact Number Should not be Empty");
			return;
		}
		if(email.equals("")) {
			JOptionPane.showMessageDialog(null,"Email Should not be Empty");
			return;
		}
		if(aadhar.equals("")) {
			JOptionPane.showMessageDialog(null,"Aadhar Card Should not be Empty");
			return;
		}
		String gender=null;
		if(male.isSelected()) {
			gender="Male";
		}
		else if(female.isSelected()) {
			gender="female";
		}
		String job= (String) cbjob.getSelectedItem();
		try {
			Conn conn=new Conn();
			String query="insert into employee values('"+name+"','"+age+"','"+gender+"','"+job+"','"+salary+"','"+phone+"','"+email+"','"+aadhar+"')";
			conn.s.executeUpdate(query);
			JOptionPane.showMessageDialog(null,"Employee Added Sucessfully");
			setVisible(false);
			
		}
		catch(Exception e1) {
			e1.printStackTrace();
		}
		
		
	}

}
