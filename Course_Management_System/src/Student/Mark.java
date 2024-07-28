package Student;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.Color;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JPanel;

public class Mark extends DataConnection {

	private JFrame frame;
	private JTextField idtext;
	private JTextField nametext;
	private JTextField oopt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Mark window = new Mark();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Mark() {
		initialize();
	}
	PreparedStatement pst;
	private JTextField ait;
	private JTextField nmct;
	public void insertData(String ID, String Name, String Course, String Title, String Marks) {
		
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.GRAY);
		frame.setBounds(100, 100, 500, 350);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setBounds(30, 71, 85, 14);
		frame.getContentPane().add(lblNewLabel);
		
		idtext = new JTextField();
		idtext.setColumns(10);
		idtext.setBounds(124, 65, 192, 20);
		frame.getContentPane().add(idtext);
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setBounds(30, 109, 85, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		nametext = new JTextField();
		nametext.setColumns(10);
		nametext.setBounds(124, 103, 192, 20);
		frame.getContentPane().add(nametext);
		
		JLabel lblNewLabel_2 = new JLabel("Course Name");
		lblNewLabel_2.setBounds(30, 150, 85, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		JComboBox<String> namebox = new JComboBox<String>();
		namebox.setModel(new DefaultComboBoxModel<String>(new String[] {"‍BSc", "BBA", "BIBM"}));
		namebox.setBounds(123, 143, 193, 22);
		frame.getContentPane().add(namebox);
		
		JLabel lblNewLabel_4 = new JLabel("Marks");
		lblNewLabel_4.setBounds(373, 124, 85, 14);
		frame.getContentPane().add(lblNewLabel_4);
		
		JLabel lblMarks = new JLabel("Marks");
		lblMarks.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblMarks.setBounds(30, 21, 70, 14);
		frame.getContentPane().add(lblMarks);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.PINK);
		panel.setForeground(Color.PINK);
		panel.setBounds(0, 177, 484, 134);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		ait = new JTextField();
		ait.setBounds(196, 41, 86, 20);
		panel.add(ait);
		ait.setColumns(10);
		
		JButton btnNewButton = new JButton("Done");
		btnNewButton.setBounds(385, 102, 89, 23);
		panel.add(btnNewButton);
		
		oopt = new JTextField();
		oopt.setBounds(196, 72, 86, 20);
		panel.add(oopt);
		oopt.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Course Title");
		lblNewLabel_3.setBounds(28, 8, 85, 14);
		panel.add(lblNewLabel_3);
		
		nmct = new JTextField();
		nmct.setBounds(196, 103, 83, 20);
		panel.add(nmct);
		nmct.setColumns(10);
		
		JLabel lblNewLabel_4_1 = new JLabel("Marks");
		lblNewLabel_4_1.setBounds(214, 8, 85, 14);
		panel.add(lblNewLabel_4_1);
		
		JLabel lblNewLabel_5 = new JLabel("AI");
		lblNewLabel_5.setBounds(28, 44, 46, 14);
		panel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_5_1 = new JLabel("OOP");
		lblNewLabel_5_1.setBounds(28, 75, 46, 14);
		panel.add(lblNewLabel_5_1);
		
		JLabel lblNewLabel_5_2 = new JLabel("NMC");
		lblNewLabel_5_2.setBounds(28, 106, 46, 14);
		panel.add(lblNewLabel_5_2);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ID  =  idtext.getText();
				String Name  =  nametext.getText();
				String Course  =  namebox.getSelectedItem().toString();
				//String Title  =  titlebox.getSelectedItem().toString();
				String AI  =  ait.getText();
				String OOP  =  oopt.getText();
				String NMC  =  nmct.getText();
				
				//String Marks  =  oopt.getText();
				
	                	try {
	    					
	    					pst = getConnection().prepareStatement("insert into Marks (ID,Name,Course,AI,OOP,NMC) values (?,?,?,?,?,?) " );
	    			        pst.setString(1, ID);
	    					pst.setString(2, Name);
	    					pst.setString(3, Course);
	    					pst.setString(4, AI);
	    				    pst.setString(5, OOP);
	    				    pst.setString(6, NMC);
	    					
				
	    					 pst.executeUpdate();
	    					 JOptionPane.showMessageDialog(btnNewButton,"Marks Added Sucessfully");
	    					 idtext.setText("");
	    					 nametext.setText(" ");
	    					 namebox.setSelectedIndex(-1);
	    					 ait.setText(" ");
	    					 oopt.setText(" ");
	    					 nmct.setText(" ");
	    					 
	    					 //titlebox.setSelectedIndex(-1);
	    					 oopt.setText("");
	    					 
	    				     
	    					 
	    				} catch (SQLException e1) {
	    					//TODO Auto-generated catch block
	    					e1.printStackTrace();
	    				}
	                	frame.setVisible(false);
			}
		});
		frame.setVisible(true);
		
	}
}
