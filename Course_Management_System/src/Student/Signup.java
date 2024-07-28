package Student;

import java.awt.EventQueue;
import java.awt.Font;
import java.sql.PreparedStatement;
import java.sql.SQLException;

//import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

//import Database.CreateTable;

import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
//import Student.DataConnection............................
public class Signup extends DataConnection {

	private JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;
	private JTextField textField_3;
	private JTextField textField_2;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					Signup window = new Signup();
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
	public Signup() {
		initialize();
		
	}
	
	//Connection connect;
	PreparedStatement pst;
	

	

	/**
	 * Initialize the contents of the frame.
	 */
	
	/**
	 * 
	 * @author Dell
	 * 
	 *
	 */
	class UserData {
	    private String username;
	    private String email;
	    private String password;
	    private String phoneNumber;
	    private String selectUsermode;

	    public UserData(String username, String email, String password, String phoneNumber, String selectUsermode) {
	        this.username = username;
	        this.email = email;
	        this.password = password;
	        this.phoneNumber = phoneNumber;
	        this.selectUsermode = selectUsermode;
	    }

	    public String getUsername() {
	        return username;
	    }

	    public String getEmail() {
	        return email;
	    }

	    public String getPassword() {
	        return password;
	    }

	    public String getPhoneNumber() {
	        return phoneNumber;
	    }

	    public String getSelectUsermode() {
	        return selectUsermode;
	    }
	}
	@SuppressWarnings("serial")
	public class EmptyFieldException extends Exception {
	    public EmptyFieldException(String message) {
	        super(message);
	    }
	}
	private void initialize() {
		
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.CYAN);
		frame.getContentPane().setForeground(Color.CYAN);
		frame.setForeground(Color.CYAN);
		frame.setBackground(Color.WHITE);
		frame.setResizable(false);
		frame.setBounds(100, 100, 503, 393);
		//frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblNewLabel = new JLabel("👤 User name ");
		
		JLabel lblNewLabel_1 = new JLabel("🔐 Password ");
		
		textField = new JTextField();
		textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		
		JComboBox<String> t_Box = new JComboBox<String>();
		t_Box.setModel(new DefaultComboBoxModel<String>(new String[] {"‍Student", "Admin", "Instructor"}));

		JLabel lblNewLabel_2 = new JLabel("Welcome to Sign up ");
		lblNewLabel_2.setBackground(Color.PINK);
		lblNewLabel_2.setForeground(new Color(255, 128, 0));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Arial Black", Font.BOLD, 22));
		
		JLabel lblNewLabel_3 = new JLabel("☎ Phone Number ");
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("📧 Email ");
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("👥 Select User mode");
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);	
				new login();
			     
			
			}
		});
		
		JButton btnNewButton_1 = new JButton("Create");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				   String username = textField.getText();
			        String email = textField_2.getText();
			        String password = String.valueOf(passwordField.getPassword());
			        String phoneNumber = textField_3.getText();
			        String selectUsermode = t_Box.getSelectedItem().toString();

			        try {
			        	
			            if (username.isEmpty() || email.isEmpty() || password.isEmpty() || phoneNumber.isEmpty()) {
			              throw new EmptyFieldException("Fields cannot be empty");
			            }
			          } catch (EmptyFieldException ex) {
			            JOptionPane.showMessageDialog(btnNewButton, ex.getMessage());
			            return;
			          }

			        UserData userData = new UserData(username, email, password, phoneNumber, selectUsermode);
			      
			        
			        try {
			            pst = getConnection().prepareStatement("insert into data (Username,Email,Password,PhoneNumber , SelectUsermode) values (?,?,?,?,?) ");
			            pst.setString(1, userData.getUsername());
			            pst.setString(2, userData.getEmail());
			            pst.setString(3, userData.getPassword());
			            pst.setString(4, userData.getPhoneNumber());
			            pst.setString(5, userData.getSelectUsermode());
			            pst.executeUpdate();
			            System.out.println("OK");
			            JOptionPane.showMessageDialog(btnNewButton, "User Added");
			        } catch (SQLException e1) {
			            e1.printStackTrace();
			        }
			    }
			});
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(109)
					.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 368, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(109)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_4, GroupLayout.DEFAULT_SIZE, 368, Short.MAX_VALUE))
					.addContainerGap())
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(109)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(lblNewLabel_3, GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
										.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE)
										.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
											.addComponent(textField_2, Alignment.LEADING)
											.addComponent(passwordField, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)))
									.addGap(60))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)))
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(lblNewLabel_5)
										.addComponent(t_Box, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addGap(63))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
									.addGap(76))))))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(98)
					.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 279, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(110, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addGap(35)
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblNewLabel_4)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel_5)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(t_Box, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(4)
							.addComponent(lblNewLabel_1)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblNewLabel_3)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(17)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
					.addGap(41))
		);
		frame.getContentPane().setLayout(groupLayout);
		
	}

	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}
}
