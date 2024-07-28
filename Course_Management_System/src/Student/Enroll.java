package Student;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Enroll extends DataConnection {

	private JFrame frame;
	private JTextField idtxt;
	private JTextField fnametext;
	private JTextField lnametext;
	private JTextField addresstext;
	private JTextField dobtext;
	private JTextField emailtext;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Enroll window = new Enroll();
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
	public Enroll() {
		initialize();
	}
	PreparedStatement pst;
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Enroll ");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(25, 28, 70, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1_3_1 = new JLabel("ID");
		lblNewLabel_1_3_1.setBounds(25, 72, 128, 14);
		frame.getContentPane().add(lblNewLabel_1_3_1);
		
		JLabel lblNewLabel_1_3 = new JLabel("First Name");
		lblNewLabel_1_3.setBounds(25, 100, 128, 14);
		frame.getContentPane().add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_2_1 = new JLabel("Last Name");
		lblNewLabel_2_1.setBounds(25, 126, 128, 14);
		frame.getContentPane().add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_3_1 = new JLabel("Gender");
		lblNewLabel_3_1.setBounds(25, 151, 128, 46);
		frame.getContentPane().add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_4_2 = new JLabel("Address ");
		lblNewLabel_4_2.setBounds(25, 208, 128, 14);
		frame.getContentPane().add(lblNewLabel_4_2);
		
		JLabel lblNewLabel_5_2 = new JLabel("DOB");
		lblNewLabel_5_2.setBounds(25, 233, 128, 14);
		frame.getContentPane().add(lblNewLabel_5_2);
		
		JLabel lblNewLabel_6_1 = new JLabel("Email");
		lblNewLabel_6_1.setBounds(25, 258, 128, 14);
		frame.getContentPane().add(lblNewLabel_6_1);
		
		JLabel lblNewLabel_7_1 = new JLabel("Courses ");
		lblNewLabel_7_1.setBounds(25, 283, 128, 14);
		frame.getContentPane().add(lblNewLabel_7_1);
		
		idtxt = new JTextField();
		idtxt.setColumns(10);
		idtxt.setBounds(269, 66, 152, 20);
		frame.getContentPane().add(idtxt);
		
		fnametext = new JTextField();
		fnametext.setColumns(10);
		fnametext.setBounds(269, 94, 152, 20);
		frame.getContentPane().add(fnametext);
		
		lnametext = new JTextField();
		lnametext.setColumns(10);
		lnametext.setBounds(269, 117, 152, 20);
		frame.getContentPane().add(lnametext);
		
		JRadioButton maletext = new JRadioButton("Male");
		maletext.setBounds(269, 144, 152, 23);
		frame.getContentPane().add(maletext);
		
		JRadioButton femaletext = new JRadioButton("Female ");
		femaletext.setBounds(269, 173, 152, 23);
		frame.getContentPane().add(femaletext);
		
		addresstext = new JTextField();
		addresstext.setColumns(10);
		addresstext.setBounds(269, 203, 152, 20);
		frame.getContentPane().add(addresstext);
		
		dobtext = new JTextField();
		dobtext.setColumns(10);
		dobtext.setBounds(269, 227, 152, 20);
		frame.getContentPane().add(dobtext);
		
		emailtext = new JTextField();
		emailtext.setColumns(10);
		emailtext.setBounds(269, 252, 152, 20);
		frame.getContentPane().add(emailtext);
		
		JComboBox<String> t_Box = new JComboBox<String>();
		t_Box.setModel(new DefaultComboBoxModel<String>(new String[] {"‍BSc", "BBA", "BIBM"}));
		t_Box.setToolTipText("nnnn");
		t_Box.setBounds(269, 277, 152, 20);
		frame.getContentPane().add(t_Box);
		
		JButton btnNewButton = new JButton("Done");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ID  =  idtxt.getText();
				String Name  =  fnametext.getText () + lnametext.getText();
				String Gender ;
			      if(maletext.isSelected())
			      {
			    	  Gender = "Male";
			      }else
			      {
			    	  Gender = "Female";
			      }
				String Address  = addresstext.getText();
				String DOB  =  dobtext.getText();
				String Email  =  emailtext.getText();
				String Course  =  t_Box.getSelectedItem().toString();

			    try {
			        pst = getConnection().prepareStatement("insert into Studentinfo (ID,Name,Sex,Address,DOB,Email,Course) values (?,?,?,?,?,?,?) ");
			        pst.setString(1, ID);
					    pst.setString(2, Name);
			        pst.setString(3, Gender);
		                pst.setString(4, Address);
					    pst.setString(5, DOB);
					    pst.setString(6, Email);
					    pst.setString(7, Course);
					

			        int i = pst.executeUpdate();
			        if (i > 0) {
			            JOptionPane.showMessageDialog(btnNewButton, "Record updated successfully");
			             idtxt.setText("");
    					 fnametext.setText("");
    					 lnametext.setText("");
    					 addresstext.setText("");
    					 dobtext.setText("");
    					 emailtext.setText("");
    				     t_Box.setSelectedIndex(-1);
			        } else {
			            JOptionPane.showMessageDialog(btnNewButton, "Record not found");
			        }
			    } catch (SQLException ex) {
			        ex.printStackTrace();
			    }
			   // Load();
			}
			
		});
		btnNewButton.setBounds(332, 327, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
			}
		});
		btnExit.setBounds(445, 327, 89, 23);
		frame.getContentPane().add(btnExit);
		frame.setBounds(100, 100, 550, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}
