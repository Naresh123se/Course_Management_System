package Student;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.DefaultComboBoxModel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class login extends DataConnection {

	private JFrame frame;
	private JTextField textField_1;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login window = new login();
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
	public login() {
		initialize();
	
	
;}
	
	PreparedStatement pst;
	ResultSet res;
	


	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.CYAN);
		frame.setBounds(100, 100, 440, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"👥 Select "}));
		comboBox.setToolTipText("");
		comboBox.addItem("‍Student");
		comboBox.addItem("Admin");
		comboBox.addItem("Instructor");
		
		JLabel lblNewLabel = new JLabel("📧 Email ");
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		passwordField = new JPasswordField();
		
		JLabel lblNewLabel_1 = new JLabel("🔐 Password ");
		
		JLabel lblNewLabel_2 = new JLabel("Welcome to Login");
		lblNewLabel_2.setForeground(new Color(255, 128, 0));
		lblNewLabel_2.setFont(new Font("Arial Black", Font.BOLD, 22));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		
		JButton btnNewButton = new JButton("Logins");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				 String SelectUsermode = comboBox.getSelectedItem().toString();
		            String Email = textField_1.getText();
		            String Password = String.valueOf(passwordField.getPassword());
		            
		            try {
		                pst = getConnection().prepareStatement("Select * from data where SelectUsermode = ? and Email = ? and Password = ?");
		                pst.setString(1, SelectUsermode);
		                pst.setString(2, Email);
		                pst.setString(3, Password);

		                res = pst.executeQuery();

		                if (res.next()) {
		                    JOptionPane.showMessageDialog(null, "Welcome");
		                    
		                    frame.setVisible(false);
		             
		                    Dashboard dc = new Dashboard (SelectUsermode);
		                    dc.Load();
		                    dc.Load1();
		                    dc.Load3();
		                    dc.Load5()  ;
		                  
		                } else {
		                    JOptionPane.showMessageDialog(null, "Wrong User");
		                }
		            } catch (SQLException ex) {
		                ex.printStackTrace();
		            }
		        }
		    
			
		});
		
		JLabel lblNewLabel_3 = new JLabel("👥 Select User mode");
		
		JButton btnNewButton_1 = new JButton("Cancel ");
		btnNewButton_1.setForeground(Color.RED);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				
			}
		});
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(100)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel_3)
							.addGap(245))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(lblNewLabel_2, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(lblNewLabel)
										.addComponent(lblNewLabel_1))
									.addGap(53)
									.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
										.addComponent(passwordField)
										.addComponent(textField_1, GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
										.addComponent(comboBox, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
							.addContainerGap(118, Short.MAX_VALUE))))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addGap(110)
					.addComponent(btnNewButton)
					.addPreferredGap(ComponentPlacement.RELATED, 146, Short.MAX_VALUE)
					.addComponent(btnNewButton_1)
					.addGap(47))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel_2)
					.addGap(44)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_3)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(37)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblNewLabel_1)
						.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton_1)
						.addComponent(btnNewButton))
					.addContainerGap())
		);
		frame.getContentPane().setLayout(groupLayout);
		frame.setVisible(true);
	}
}
