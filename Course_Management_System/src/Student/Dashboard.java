package Student;

import CourseTitle.Ai;
import CourseTitle.Nmc;
import CourseTitle.Oop;
import Result.Result;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;




import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JRadioButton;
import java.awt.Panel;
import java.awt.SystemColor;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SpringLayout;

public class Dashboard extends DataConnection{

	private JFrame frame;
	private JTable table_2;
	private JTextField look;
	private JTextField textField_2;
	private JPanel Cont;
	private JTextField idtext;
	private JTextField stname;
	private JPanel Students;
	private JTable table_1;
	String ID1;

	  public String look() {
	        return look.getText();
	    }

	    public String stname() {
	        return stname.getText();
	    }

	    public String idtext() {
	        return idtext.getText();
	    }

	    public String textField_2() {
	        return textField_2.getText();
	    }

	    

	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Dashboard window = new Dashboard();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}}
		});
	}

	/**
	 * Create the application.
	 */
	public Dashboard() {
		initialize();
		//Load1();
		
	}
	public void IDsetter(String ID) {
		this.ID1 = ID;
	}
	/**
	 * 
	 * @param str
	 */
	/*SEARCHING **********************************************************************************/
	public void Search( String str) {
    	DefaultTableModel model = (DefaultTableModel) table_2.getModel();
    	TableRowSorter<DefaultTableModel> trs = new TableRowSorter <>(model);
    	table_2.setRowSorter(trs);
    	trs.setRowFilter(RowFilter.regexFilter(str));
    }
	public void Search1( String str) {
    	DefaultTableModel model = (DefaultTableModel) table_1.getModel();
    	TableRowSorter<DefaultTableModel> trs = new TableRowSorter <>(model);
    	table_1.setRowSorter(trs);
    	trs.setRowFilter(RowFilter.regexFilter(str));
    }
	
	public void Search2( String str) {
    	DefaultTableModel model = (DefaultTableModel) table_3.getModel();
    	TableRowSorter<DefaultTableModel> trs = new TableRowSorter <>(model);
    	table_3.setRowSorter(trs);
    	trs.setRowFilter(RowFilter.regexFilter(str));
    }
	/*****TUTOR  INFO *************************************************************************/
	public void Search3( String str) {
    	DefaultTableModel model = (DefaultTableModel) tutortable.getModel();
    	TableRowSorter<DefaultTableModel> trs = new TableRowSorter <>(model);
    	tutortable.setRowSorter(trs);
    	trs.setRowFilter(RowFilter.regexFilter(str));
	
	}
	/*************************COURSE SEARCHING *****************************************************/
	public void Search5( String str) {
    	DefaultTableModel model = (DefaultTableModel) coursetable.getModel();
    	TableRowSorter<DefaultTableModel> trs = new TableRowSorter <>(model);
    	coursetable.setRowSorter(trs);
    	trs.setRowFilter(RowFilter.regexFilter(str));
    	
	}
	/*****ADMIN  result INFO *************************************************************************/
	public void Search4( String str) {
    	DefaultTableModel model = (DefaultTableModel) admintable.getModel();
    	TableRowSorter<DefaultTableModel> trs = new TableRowSorter <>(model);
    	admintable.setRowSorter(trs);
    	trs.setRowFilter(RowFilter.regexFilter(str));
	
	}
	
	
	/*************SHOW FOR STUDENTS******************************/
	PreparedStatement pst;
	ResultSet res;
	DefaultTableModel se;
	DefaultTableModel se6;
	
	
	@SuppressWarnings("unchecked")
	/**
	 * 
	 */
	/************************************STUSENT*************************/
	public void Load()
	{
		
		int na;
		try  {
			pst = getConnection().prepareStatement("Select * from study");
			res = pst.executeQuery();
			ResultSetMetaData rsmd = res.getMetaData();
			na = rsmd.getColumnCount();
			se6 =(DefaultTableModel)table_1.getModel();
			se =(DefaultTableModel)table_4.getModel();
			
			se.setRowCount(0);
			se6.setRowCount(0);
			
			while(res.next())
			 {
				@SuppressWarnings("rawtypes")
				Vector v2 = new Vector();
				for(int i = 1; i<=na; i++)
				{
					v2.add(res.getString("ID"));
					v2.add(res.getString("Name"));
					v2.add(res.getString("Sex"));
					v2.add(res.getString("Address")); 
					v2.add(res.getString("DOB")); 
					v2.add(res.getString("Email")); 
					v2.add(res.getString("Course")); 
					
				}
				se.addRow(v2);
				se6.addRow(v2);
			 }
		} catch (SQLException e1) {
			//TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		}
	/***************************SHOW FOR COURSE***********************************************/
	PreparedStatement pst1;
	ResultSet res1;
	DefaultTableModel se1;
	DefaultTableModel se17;
	
	@SuppressWarnings("unchecked")
	public void Load1()
	{
		
		int na;
		try  {
			pst1 = getConnection().prepareStatement("Select * from Course");
			res1 = pst1.executeQuery();
			ResultSetMetaData rsmd = res1.getMetaData();
			na = rsmd.getColumnCount();
			se1 =(DefaultTableModel)table_2.getModel();
			se17 =(DefaultTableModel)coursetable.getModel();
			
			se1.setRowCount(0);
			se17.setRowCount(0);
			
			while(res1.next())
			 {
				@SuppressWarnings("rawtypes")
				Vector v2 = new Vector();
				for(int i = 1; i<=na; i++)
				{
					v2.add(res1.getString("ID"));  
					v2.add(res1.getString("Name"));
					v2.add(res1.getString("Title"));
					v2.add(res1.getString("Module"));
					v2.add(res1.getString("Year"));
					
					
					
				}
				se1.addRow(v2);
				se17.addRow(v2);
			 }
		} catch (SQLException e1) {
			//TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		}
	/********************************************************************/
	PreparedStatement pst3;
	ResultSet res3;
	DefaultTableModel se3;
	
	@SuppressWarnings("unchecked")
	public void Load3()                            
	{
		
		int na;
		try  {
			pst3 = getConnection().prepareStatement("Select * from Tutor");
			res3 = pst3.executeQuery();
			ResultSetMetaData rsmd = res3.getMetaData();
			na = rsmd.getColumnCount();
			se3 =(DefaultTableModel)table_3.getModel();
			
			se3.setRowCount(0);
			
			while(res3.next())
			 {
				@SuppressWarnings("rawtypes")
				Vector v2 = new Vector();
				for(int i = 1; i<=na; i++)
				{
					v2.add(res3.getString("ID"));
					v2.add(res3.getString("Name"));
					v2.add(res3.getString("Email"));
					v2.add(res3.getString("Phone"));
					v2.add(res3.getString("Date"));
					
					
				}
				se3.addRow(v2);
			 }
		} catch (SQLException e1) {
			//TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		}
	/**************************************************************************************************/
	PreparedStatement pst4;
	ResultSet res4;
	DefaultTableModel se4;
	
	@SuppressWarnings("unchecked")
	public void Load4()                            
	{
		
		int na;
		try  {
			pst4 = getConnection().prepareStatement("Select * from study");
			res4 = pst4.executeQuery();
			ResultSetMetaData rsmd = res4.getMetaData();
			na = rsmd.getColumnCount();
			se4 =(DefaultTableModel)table_3.getModel();
			
			se4.setRowCount(0);
			
			while(res4.next())
			 {
				@SuppressWarnings("rawtypes")
				Vector v2 = new Vector();
				for(int i = 1; i<=na; i++)
				{
					v2.add(res4.getString("ID"));
					v2.add(res4.getString("Name"));
					v2.add(res4.getString("Email"));
					v2.add(res4.getString("Phone"));
					v2.add(res4.getString("Date"));
					
					
				}
				se4.addRow(v2);
			 }
			
			
			

		} catch (SQLException e1) {
			//TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		}
	/******************************************ADMIN RESULT show *///////////////////////////////
	PreparedStatement pst5;
	ResultSet res5;
	DefaultTableModel se5;
	
	@SuppressWarnings("unchecked")
	public void Load5()                            
	{
		
		int na;
		try  {
			pst5 = getConnection().prepareStatement("Select * from Marks");
			res5 = pst5.executeQuery();
			ResultSetMetaData rsmd = res5.getMetaData();
			na = rsmd.getColumnCount();
			se5 =(DefaultTableModel)admintable.getModel();
			
			se5.setRowCount(0);
			
			while(res5.next())
			 {
				@SuppressWarnings("rawtypes")
				Vector v2 = new Vector();
				for(int i = 1; i<=na; i++)
				{
					v2.add(res5.getString("ID"));
					v2.add(res5.getString("Name"));
					
					
					
				}
				se5.addRow(v2);
			 }
			
			
			

		} catch (SQLException e1) {
			//TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		}
	
	/*********************************ASSISTEMT TABLE SHOW *//////////////////////////////

PreparedStatement pst10;
ResultSet res10;
DefaultTableModel se10;

@SuppressWarnings("unchecked")
public void Load6()                            
{
	
	int na;
	try  {
		pst10 = getConnection().prepareStatement("Select * from Marks");
		res10 = pst10.executeQuery();
		ResultSetMetaData rsmd = res10.getMetaData();
		na = rsmd.getColumnCount();
		se10 =(DefaultTableModel)admintable.getModel();
		
		se10.setRowCount(0);
		
		while(res10.next())
		 {
			@SuppressWarnings("rawtypes")
			Vector v2 = new Vector();
			for(int i = 1; i<=na; i++)
			{
				v2.add(res10.getString("ID"));
				v2.add(res10.getString("Name"));
				v2.add(res10.getString("Title"));
				v2.add(res10.getString("Assistment"));
				
				
				
			}
			se10.addRow(v2);
		 }
		
		
		

	} catch (SQLException e1) {
		//TODO Auto-generated catch block
		e1.printStackTrace();
	}
	
	}


	
	
	
	
	
	
	
	
	String comboBox;
	String mail;
	String psw;
	private JButton ADD;
	private JButton stuadd;
	private JScrollPane Scroll;
	private JTextField loginastxt;
	private JTextField idtex;
	private JTextField nametext;
	private JTextField emailtext;
	private JTextField phonetext;
	private JTextField datetext;
	private JTable table_3;
	private JTextField fnametext;
	private JTextField lnametext;
	private JTextField addresstext;
	private JTextField dobtext;
	private JTextField email1text;
	private JTable table_4;
	private JTextField idtxt;
	private JPanel StudentDetails;
	private JButton B_4;
	private JTextField courseid;
	private JTextField coursetitle;
	private JTextField coursemodule;
	private JTable coursetable;
	private JTextField coursesearch;
	private JTextField setutor;
	private JTable tutortable;
	private JTextField seradmin;
	private JTextField name;
	private JTextField email;
	private JTable admintable;
	private JTextField id_text;
	private JButton button;
	private JPanel ctitle;
	private JComboBox<String> t11_Box;
	private Panel Tutors_info;
	private JButton jButton1_2;
	private JButton btnNewButton_3;
	private JButton btnNewButton_2;
	private JButton btnNewButton_1;
	private JButton btnNewButton_4;
	private JButton btnNewButton_4_1;
	private JButton btnDelete;
	private JButton btnExit_1;
	private JButton btnExit;
	private JButton stuadd_2;
	private JButton stuadd_1;
	private JButton B_3_1;
	private JButton B_7;
	
	 public String seradmin() {
	        return seradmin.getText();
	    }

	    public String id_text() {
	        return id_text.getText();
	    }

	    public String email() {
	        return email.getText();
	    }

	    public String addresstext() {
	        return addresstext.getText();
	    }
	    public String courseid() {
	        return courseid.getText();
	    }
	    public String coursetitle() {
	        return coursetitle.getText();
	    }

	
	
	
	
	
	
	
	/*********************************ROLE FOR 3 ( STUDENT ,TEACHER AND ADMIN***************************************************/ 
	/**
	 * 
	 * @param SelectUsermode
	 */
	public Dashboard( String SelectUsermode )
	{
		initialize();
		this.comboBox = SelectUsermode;
		loginastxt.setText(comboBox);
	
		String utype = loginastxt.getText();
		
		if(utype.equals("‍Student")) {
		
		
		stuadd.setEnabled(false);
		stuadd_1.setEnabled(false);
		stuadd_2.setEnabled(false);
		btnExit.setEnabled(false);
		
		/*ADMIN BUTTON*/
		B_4.setEnabled(false);
		//Tutors_info.setEnabled(false);
		//jButton1_2.setEnabled(false);
		btnNewButton_1.setEnabled(false);
		btnNewButton_2.setEnabled(false);
		ADD.setEnabled(false);
		btnNewButton_3.setEnabled(false);
		//B_4.setVisible(false);
		
		btnNewButton_4.setEnabled(false);
		btnNewButton_4_1.setEnabled(false);
		btnDelete.setEnabled(false);
		btnExit_1.setEnabled(false);
		/*****/
		B_3_1.setEnabled(false);
		/**********************/
		B_7.setEnabled(false);
		
		}
		
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
	
		JPanel Dash = new JPanel();
		Dash.setBackground(SystemColor.activeCaption);
		JPanel CourseDetails = new JPanel();
		CourseDetails.setBackground(SystemColor.activeCaptionBorder);
		JPanel Course = new JPanel();
		Course.setBackground(SystemColor.activeCaption);
		Course.setForeground(Color.CYAN);
		frame = new JFrame();
		frame.getContentPane().setForeground(Color.CYAN);
		frame.setBounds(270, 240, 700, 420);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
		Scroll = new JScrollPane();
		Scroll.setBounds(181, 47, 318, 312);
		Course.add(Scroll);
		
		table_2 = new JTable();
		table_2.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
					"ID","Name","Modules","Title","Year"
			}
		));
		table_2.setToolTipText("");
		table_2.setEnabled(false);
		table_2.setBackground(Color.PINK);
		Scroll.setViewportView(table_2);
		
		look = new JTextField();
		look.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String Searching = look.getText();
				Search(Searching);
			}
		});
		look.setColumns(10);
		look.setBounds(10, 79, 116, 20);
		Course.add(look);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(66, 116, 58, 20);
		Course.add(textField_2);
		
		JLabel lblSearch = new JLabel("Search ");
		lblSearch.setBounds(10, 54, 46, 14);
		Course.add(lblSearch);
		
		JLabel lblId = new JLabel("ID");
		lblId.setBounds(20, 119, 46, 14);
		Course.add(lblId);
		
	/*ADD COURSE DEATILS ********************************************************************************/
		ADD = new JButton("Add");
		ADD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cont.removeAll();
	         	Cont.add(CourseDetails);
	         	Cont.revalidate();
	         	Cont.repaint();
			}
				
				
		});
		ADD.setBounds(10, 302, 72, 23);
		Course.add(ADD);
		
		btnNewButton_3 = new JButton("Update ");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				Cont.removeAll();
	         	Cont.add(CourseDetails);
	         	Cont.revalidate();
	         	Cont.repaint();
			}
		});
		btnNewButton_3.setBounds(94, 302, 77, 23);
		Course.add(btnNewButton_3);
		/*DELETE COURSE DETAILS************************************************************/
		btnNewButton_2 = new JButton("Delete ");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String ID = textField_2.getText();
				
				    

				    try {
				        pst1 = getConnection().prepareStatement("DELETE FROM Course WHERE ID = ?");
				        pst1.setString(1, ID);

				        int i = pst1.executeUpdate();
				        if (i > 0) {
				            JOptionPane.showMessageDialog( ADD, "Record deleted successfully");
				           
				               textField_2.setText("");
				           
	    					
				        } else {
				            JOptionPane.showMessageDialog(ADD, "Record not found");
				        }
				    } catch (SQLException ex) {
				        ex.printStackTrace();
				    }
				    Load1();
				
			}
		});
		btnNewButton_2.setBounds(10, 336, 84, 23);
		Course.add(btnNewButton_2);
		
		btnNewButton_1 = new JButton("Exit");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
			}
		});
		frame.getContentPane().setLayout(null);
		btnNewButton_1.setForeground(Color.RED);
		btnNewButton_1.setBackground(Color.LIGHT_GRAY);
		btnNewButton_1.setBounds(99, 336, 72, 23);
		Course.add(btnNewButton_1);
		
		Cont = new JPanel();
		Cont.setBounds(165, 0, 509, 370);
		frame.getContentPane().add(Cont);
		Cont.setLayout(new CardLayout(0, 0));
		
		Cont.add(Dash, "name_18315027618700");
		
		Cont.add(CourseDetails, "name_1019033875300");
		
		JLabel lblNewLabel_7_2 = new JLabel("ID");
		lblNewLabel_7_2.setBounds(10, 89, 53, 14);
		
		courseid = new JTextField();
		courseid.setBounds(92, 83, 99, 20);
		courseid.setColumns(10);
		
		coursetitle = new JTextField();
		coursetitle.setBounds(92, 149, 99, 20);
		coursetitle.setColumns(10);
		
		coursemodule = new JTextField();
		coursemodule.setBounds(92, 185, 99, 20);
		coursemodule.setColumns(10);
		
		JLabel lblTutorsDetails_1 = new JLabel("Course Details ");
		lblTutorsDetails_1.setBounds(174, 11, 132, 22);
		lblTutorsDetails_1.setForeground(new Color(255, 128, 0));
		lblTutorsDetails_1.setFont(new Font("Arial Black", Font.BOLD, 15));
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setBounds(10, 121, 79, 14);
		
		JLabel lblNewLabel_2 = new JLabel(" Title:");
		lblNewLabel_2.setBounds(10, 152, 61, 14);
		
		JLabel lblNewLabel_3_2_1 = new JLabel("Module");
		lblNewLabel_3_2_1.setBounds(13, 188, 61, 14);
		
		JLabel lblNewLabel = new JLabel("Years ");
		lblNewLabel.setBounds(10, 230, 46, 14);
		CourseDetails.setLayout(null);
		CourseDetails.add(lblNewLabel_7_2);
		CourseDetails.add(courseid);
		CourseDetails.add(coursetitle);
		CourseDetails.add(coursemodule);
		CourseDetails.add(lblTutorsDetails_1);
		CourseDetails.add(lblNewLabel_1);
		CourseDetails.add(lblNewLabel_2);
		CourseDetails.add(lblNewLabel_3_2_1);
		CourseDetails.add(lblNewLabel);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(201, 44, 298, 315);
		CourseDetails.add(scrollPane_3);
		
		coursetable = new JTable();
		coursetable.setBackground(Color.PINK);
		coursetable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID","Name","Modules","Title","Year"
			}
		));
		scrollPane_3.setViewportView(coursetable);
		
		JComboBox<String> coursename = new JComboBox<String>();
		coursename.setModel(new DefaultComboBoxModel<String>(new String[] {"‍BSc", "BBA", "BIBM"}));
		coursename.setBounds(92, 117, 61, 22);
		CourseDetails.add(coursename);
		
		JComboBox<String> courseyear = new JComboBox<String>();
		courseyear.setModel(new DefaultComboBoxModel<String>(new String[] {"1", "2", "3"}));
		courseyear.setBounds(92, 226, 46, 22);
		CourseDetails.add(courseyear);
		
		/*********************ADD COURSE DETAILS ***************************************************************/
		JButton stuadd_3 = new JButton("Add");
		stuadd_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ID  =  courseid.getText();
				String Name  =  coursename.getSelectedItem().toString();
				String Title  =  coursetitle.getText();
				String Module  =  coursemodule.getText();
				String Year  =  courseyear.getSelectedItem().toString();
				
	                	try {
	    					
	    					pst1 = getConnection().prepareStatement("insert into Course (ID,Name,Title,Module,Year) values (?,?,?,?,?) " );
	    					pst1.setString(1, ID);
	    					pst1.setString(2, Name);
	    					pst1.setString(3, Title);
	    					pst1.setString(4, Module);
	    					pst1.setString(5, Year);
	    					
				
	    					 pst1.executeUpdate();
	    					
	    					 
	    				
	    					 JOptionPane.showMessageDialog(ADD,"User Added");
	    					 courseid.setText("");
	    				     coursename.setSelectedIndex(-1);
	    					 coursetitle.setText("");
	    					 coursemodule.setText("");
	    					 courseyear.setSelectedItem(-1);
	    					 
	    				} catch (SQLException e1) {
	    					//TODO Auto-generated catch block
	    					e1.printStackTrace();
	    				}
	    			
	    			Load1();
			
			}
		});
		stuadd_3.setBounds(10, 302, 68, 23);
		CourseDetails.add(stuadd_3);
		
		/***Update************************************************************************************************/
		JButton stuadd_2_1 = new JButton("Update");
		stuadd_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ID  =  courseid.getText();
				String Name  =  coursename.getSelectedItem().toString();
				String Title  =  coursetitle.getText();
				String Module  =  coursemodule.getText();
				String Year  =  courseyear.getSelectedItem().toString();

				try {
				    pst1 = getConnection().prepareStatement("UPDATE Course SET Name = ?,Title = ?, Module = ?,Year = ? WHERE ID = ?");
				    pst1.setString(1, Name);
				    pst1.setString(2, Title);
				    pst1.setString(3, Module);
				    pst1.setString(4, Year);
				    pst1.setString(5, ID);

				    int i = pst1.executeUpdate();
				    if (i > 0) {
				        JOptionPane.showMessageDialog(ADD, "Record updated successfully");
				        courseid.setText("");
				        coursename.setSelectedIndex(-1);
				        coursetitle.setText("");
				        coursemodule.setText("");
				        courseyear.setSelectedIndex(-1);
				        } else {
				            JOptionPane.showMessageDialog(ADD, "Record not found");
				        }
				    } catch (SQLException ex) {
				        ex.printStackTrace();
				    }
				    Load1();
				}
			
			
		});
		stuadd_2_1.setBounds(10, 336, 86, 23);
		CourseDetails.add(stuadd_2_1);
		
		JButton btnExit_2 = new JButton("Exit");
		btnExit_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cont.removeAll();
	         	Cont.add(Course);
	         	Cont.revalidate();
	         	Cont.repaint();
				
			}
		});
		btnExit_2.setForeground(Color.RED);
		btnExit_2.setBackground(Color.WHITE);
		btnExit_2.setBounds(115, 336, 76, 23);
		CourseDetails.add(btnExit_2);
		
		JLabel lblNewLabel_8 = new JLabel("🔎 Search ");
		lblNewLabel_8.setBounds(10, 51, 79, 14);
		CourseDetails.add(lblNewLabel_8);
		
		coursesearch = new JTextField();
		coursesearch.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
			
			String Searching = coursesearch.getText();
			Search5(Searching);
			}
		});
		coursesearch.setColumns(10);
		coursesearch.setBounds(92, 52, 99, 20);
		CourseDetails.add(coursesearch);

		Cont.add(Course, "name_1019116312500");
		Course.setLayout(null);
		
		JLabel lblCoursesDetails = new JLabel("Courses Details ");
		lblCoursesDetails.setForeground(new Color(255, 128, 0));
		lblCoursesDetails.setFont(new Font("Arial Black", Font.BOLD, 15));
		lblCoursesDetails.setBounds(10, 11, 154, 22);
		Course.add(lblCoursesDetails);
		
		Students = new JPanel();
		Students.setBackground(SystemColor.activeCaption);
		Cont.add(Students, "name_2896803677600");
		Students.setLayout(null);
		/*ADD STUDENT DETAILS**************************************************** */
		stuadd = new JButton("Add");
		stuadd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cont.removeAll();
             	Cont.add(StudentDetails); 
             	Cont.revalidate();
             	Cont.repaint();
             	
			}
				
		});
		stuadd.setBounds(10, 303, 68, 23);
		Students.add(stuadd);
		
		idtext = new JTextField();
		idtext.setColumns(10);
		idtext.setBounds(80, 121, 56, 20);
		Students.add(idtext);
		
		stname = new JTextField();
		stname.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String Searching = stname.getText();
				Search1(Searching);
			}
		});
		stname.setColumns(10);
		stname.setBounds(10, 79, 126, 20);
		Students.add(stname);
		
		JLabel lblNewLabel_3 = new JLabel("Search Student ");
		lblNewLabel_3.setBounds(10, 61, 107, 14);
		Students.add(lblNewLabel_3);
		
		JLabel lblId_1 = new JLabel("ID");
		lblId_1.setBounds(14, 124, 46, 14);
		Students.add(lblId_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(184, 54, 315, 316);
		Students.add(scrollPane);
		
		table_1 = new JTable();
		table_1.setBackground(Color.PINK);
		scrollPane.setViewportView(table_1);
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
					"ID","Name", "Sex", "Address", "DOB", "Email", "Course"
			}
		));
		/*/////////////////////////////////////////////////////////////////////////////////*/
		/*Exit STUDENT DETAILS*/
		
		btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
			}
		});
		btnExit.setForeground(Color.RED);
		btnExit.setBackground(Color.WHITE);
		btnExit.setBounds(98, 336, 76, 23);
		Students.add(btnExit);
		
		JLabel lblStudentDetails = new JLabel("Student Details ");
		lblStudentDetails.setForeground(new Color(255, 128, 0));
		lblStudentDetails.setFont(new Font("Arial Black", Font.BOLD, 15));
		lblStudentDetails.setBounds(10, 11, 154, 22);
		Students.add(lblStudentDetails);
		/**************************************************************************************************/
		/*DELETE STUDENT DETAILS*/
		stuadd_1 = new JButton("Delete");
		stuadd_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			    String ID = idtext.getText();
			   

			    try {
			        pst = getConnection().prepareStatement("DELETE FROM Study WHERE ID = ?");
			        pst.setString(1, ID);

			        int i = pst.executeUpdate();
			        if (i > 0) {
			            JOptionPane.showMessageDialog(ADD, "Record deleted successfully");
			            idtext.setText("");
			            
			        } else {
			            JOptionPane.showMessageDialog(ADD, "Record not found");
			        }
			    } catch (SQLException ex) {
			        ex.printStackTrace();
			    }
			    Load();
			}
			
			
		});
		stuadd_1.setBounds(10, 336, 78, 23);
		Students.add(stuadd_1);
		
		stuadd_2 = new JButton("Update");
		stuadd_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*************************************************************************/
				/**UPDATE STUDENT DETAILS**********/
				Cont.removeAll();
	         	Cont.add(StudentDetails);
	         	Cont.revalidate();
	         	Cont.repaint();
			}

		});
		stuadd_2.setBounds(88, 303, 86, 23);
		Students.add(stuadd_2);
		SpringLayout sl_Dash = new SpringLayout();
		Dash.setLayout(sl_Dash);
		
		JLabel lblNewLabel_6 = new JLabel("DASHBOARD ");
		sl_Dash.putConstraint(SpringLayout.NORTH, lblNewLabel_6, 10, SpringLayout.NORTH, Dash);
		sl_Dash.putConstraint(SpringLayout.WEST, lblNewLabel_6, 0, SpringLayout.WEST, Dash);
		sl_Dash.putConstraint(SpringLayout.SOUTH, lblNewLabel_6, 31, SpringLayout.NORTH, Dash);
		sl_Dash.putConstraint(SpringLayout.EAST, lblNewLabel_6, 157, SpringLayout.WEST, Dash);
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setForeground(new Color(255, 128, 0));
		lblNewLabel_6.setFont(new Font("Arial", Font.BOLD, 19));
		lblNewLabel_6.setBackground(Color.LIGHT_GRAY);
		Dash.add(lblNewLabel_6);
		
		JPanel Notice = new JPanel();
		sl_Dash.putConstraint(SpringLayout.NORTH, Notice, 10, SpringLayout.NORTH, Dash);
		sl_Dash.putConstraint(SpringLayout.WEST, Notice, 365, SpringLayout.WEST, Dash);
		sl_Dash.putConstraint(SpringLayout.SOUTH, Notice, 370, SpringLayout.NORTH, Dash);
		sl_Dash.putConstraint(SpringLayout.EAST, Notice, 509, SpringLayout.WEST, Dash);
		Notice.setBackground(SystemColor.activeCaptionBorder);
		Dash.add(Notice);
		Notice.setLayout(null);
		
		JLabel lblNewLabel_17 = new JLabel("Noticed ");
		lblNewLabel_17.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_17.setForeground(new Color(0, 64, 128));
		lblNewLabel_17.setBounds(35, 11, 70, 25);
		Notice.add(lblNewLabel_17);
		
		JLabel lblNewLabel_4 = new JLabel("Result 🛎 ");
		lblNewLabel_4.setForeground(Color.CYAN);
		lblNewLabel_4.setBounds(21, 47, 84, 28);
		Notice.add(lblNewLabel_4);
		
		JLabel lblNewLabel_4_1 = new JLabel("Holliday *");
		lblNewLabel_4_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_4_1.setBounds(21, 86, 70, 14);
		Notice.add(lblNewLabel_4_1);
		
		JLabel lblNewLabel_4_3 = new JLabel("Sports ⚽ ");
		lblNewLabel_4_3.setForeground(Color.PINK);
		lblNewLabel_4_3.setBounds(21, 123, 70, 14);
		Notice.add(lblNewLabel_4_3);
		
		JLabel lblNewLabel_4_4 = new JLabel("Workshop");
		lblNewLabel_4_4.setForeground(new Color(255, 128, 0));
		lblNewLabel_4_4.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_4_4.setBounds(21, 196, 70, 14);
		Notice.add(lblNewLabel_4_4);
		
		JLabel lblNewLabel_4_5 = new JLabel("Viva");
		lblNewLabel_4_5.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_4_5.setForeground(Color.ORANGE);
		lblNewLabel_4_5.setBounds(21, 254, 46, 25);
		Notice.add(lblNewLabel_4_5);
		
		JLabel lblNewLabel_4_1_1 = new JLabel("Holliday *");
		lblNewLabel_4_1_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_4_1_1.setBounds(21, 159, 70, 14);
		Notice.add(lblNewLabel_4_1_1);
		
		JLabel lblNewLabel_4_1_1_1 = new JLabel("EXAM ");
		lblNewLabel_4_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_4_1_1_1.setBounds(21, 225, 70, 14);
		Notice.add(lblNewLabel_4_1_1_1);
		
		JLabel lblNewLabel_4_1_1_2 = new JLabel("Holliday *");
		lblNewLabel_4_1_1_2.setForeground(Color.MAGENTA);
		lblNewLabel_4_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_4_1_1_2.setBounds(21, 290, 70, 14);
		Notice.add(lblNewLabel_4_1_1_2);
		
		JLabel lblNewLabel_4_6 = new JLabel("Result 🛎 ");
		lblNewLabel_4_6.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_4_6.setForeground(Color.CYAN);
		lblNewLabel_4_6.setBounds(21, 321, 84, 28);
		Notice.add(lblNewLabel_4_6);
		
		JLabel lblNewLabel_5 = new JLabel("Course Management System");
		sl_Dash.putConstraint(SpringLayout.NORTH, lblNewLabel_5, -11, SpringLayout.NORTH, Dash);
		sl_Dash.putConstraint(SpringLayout.WEST, lblNewLabel_5, 10, SpringLayout.WEST, Dash);
		sl_Dash.putConstraint(SpringLayout.SOUTH, lblNewLabel_5, 152, SpringLayout.NORTH, Dash);
		sl_Dash.putConstraint(SpringLayout.EAST, lblNewLabel_5, 355, SpringLayout.WEST, Dash);
		lblNewLabel_5.setForeground(Color.DARK_GRAY);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 22));
		Dash.add(lblNewLabel_5);
		
		JPanel Tutor = new JPanel();
		Tutor.setBackground(new Color(153, 180, 209));
		Cont.add(Tutor, "name_28657400731800");
		Tutor.setLayout(null);
		
		JLabel lblTutorsDetails = new JLabel("Tutors Details ");
		lblTutorsDetails.setForeground(new Color(255, 128, 0));
		lblTutorsDetails.setFont(new Font("Arial Black", Font.BOLD, 15));
		lblTutorsDetails.setBounds(179, 11, 132, 22);
		Tutor.add(lblTutorsDetails);
		
		JLabel lblAddTutorsDetails = new JLabel("Add Tutors Details ");
		lblAddTutorsDetails.setForeground(new Color(64, 0, 128));
		lblAddTutorsDetails.setFont(new Font("Bell MT", Font.BOLD, 14));
		lblAddTutorsDetails.setBounds(10, 39, 132, 22);
		Tutor.add(lblAddTutorsDetails);
		
		JLabel lblNewLabel_7 = new JLabel("ID");
		lblNewLabel_7.setBounds(10, 82, 53, 14);
		Tutor.add(lblNewLabel_7);
		
		idtex = new JTextField();
		idtex.setColumns(10);
		idtex.setBounds(92, 76, 99, 20);
		Tutor.add(idtex);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(10, 110, 53, 14);
		Tutor.add(lblName);
		
		nametext = new JTextField();
		nametext.setColumns(10);
		nametext.setBounds(92, 111, 99, 20);
		Tutor.add(nametext);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Email");
		lblNewLabel_1_1_1.setBounds(10, 148, 53, 14);
		Tutor.add(lblNewLabel_1_1_1);
		
		emailtext = new JTextField();
		emailtext.setColumns(10);
		emailtext.setBounds(92, 142, 99, 20);
		Tutor.add(emailtext);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Phone");
		lblNewLabel_1_1_1_1.setBounds(10, 184, 53, 14);
		Tutor.add(lblNewLabel_1_1_1_1);
		
		phonetext = new JTextField();
		phonetext.setColumns(10);
		phonetext.setBounds(92, 178, 99, 20);
		Tutor.add(phonetext);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Date");
		lblNewLabel_1_1_1_1_1.setBounds(10, 209, 53, 14);
		Tutor.add(lblNewLabel_1_1_1_1_1);
		
		datetext = new JTextField();
		datetext.setColumns(10);
		datetext.setBounds(92, 206, 99, 20);
		Tutor.add(datetext);
		
		btnDelete = new JButton("Delete ");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
		   /*******************************************************************************************/
			/*Delete Tutors Details */
				String ID = textField_2.getText();
		    try {
		        pst3 = getConnection().prepareStatement("DELETE FROM Study WHERE ID = ?");
		        pst3.setString(1, ID);

		        int i = pst3.executeUpdate();
		        if (i > 0) {
		            JOptionPane.showMessageDialog(ADD, "Record deleted successfully");
		            idtext.setText("");
		            stname.setText("");
		            emailtext.setText("");
		            phonetext.setText("");
		            datetext.setText("");
		            
		        } else {
		            JOptionPane.showMessageDialog(ADD, "Record not found");
		        }
		    } catch (SQLException ex) {
		        ex.printStackTrace();
		    }
		    Load3();
		}
			
		});
		btnDelete.setBounds(10, 336, 73, 23);
		Tutor.add(btnDelete);
		/*EXIT FOR TUTOR DETAILS*******************************************************/
		btnExit_1 = new JButton("Exit ");
		btnExit_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
			}
		});
		btnExit_1.setForeground(Color.RED);
		btnExit_1.setBounds(106, 336, 85, 23);
		Tutor.add(btnExit_1);
		/************************************************************************************************************/
		/*ADD TUTOR DETAILS....***/
		btnNewButton_4 = new JButton("ADD");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ID  =  idtex.getText();
				String Name  =  nametext.getText();
				String Email  =  emailtext.getText();
				String Phone  =  phonetext.getText();
				String Date  =  datetext.getText();
				String Title = t11_Box.getSelectedItem().toString();

	                	try {
	    					
	    					pst3 = getConnection().prepareStatement("insert into Tutor (ID,Name,Email,Phone,Date,Title) values (?,?,?,?,?,?) " );
	    					pst3.setString(1, ID);
	    					pst3.setString(2, Name);
	    					pst3.setString(3, Email);
	    					pst3.setString(4, Phone);
	    					pst3.setString(5, Date);
	    					pst3.setString(6, Title);
	    					
	    					
	    					 pst3.executeUpdate();
	    					 System.out.println("OK");
	    					 
	    				
	    					 JOptionPane.showMessageDialog(ADD,"User Added");
	    					 idtex.setText("");
	    					 nametext.setText(" ");
	    					 emailtext.setText("");
	    					 phonetext.setText("");
	    					 datetext.setText("");
	    					 t11_Box.setSelectedIndex(-1);
	    					 
	    				} catch (SQLException e1) {
	    					//TODO Auto-generated catch block
	    					e1.printStackTrace();
	    				}
	    			Load();
	    			
			}
			
		});
		btnNewButton_4.setBounds(10, 297, 73, 23);
		Tutor.add(btnNewButton_4);
		
		btnNewButton_4_1 = new JButton("Update ");
		btnNewButton_4_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*****************************************************************************/
		/*Upadte  Tutors Details  */
			    
			    
				String ID = idtext.getText();
				String Name = stname.getText();
				String Email = emailtext.getText();
				String Phone = phonetext.getText();
				String Date = datetext.getText();
				
				
                    try {
				pst3 = getConnection().prepareStatement("UPDATE Study SET Name = ?,Name = ?, Email = ?,Phone = ?, Date = ? WHERE ID = ?");
				pst3.setString(1, ID);
				pst3.setString(2, Name);
				pst3.setString(3, Email);
				pst3.setString(4, Phone);
				pst3.setString(5, Date);
				
				 pst3.executeUpdate();
				 JOptionPane.showMessageDialog(ADD,"User Update");
				 idtex.setText("");
				 nametext.setText("");
				 emailtext.setText("");
				 phonetext.setText("");
				 datetext.setText("");
			     
				 
			} catch (SQLException e1) {
				//TODO Auto-generated catch block
				e1.printStackTrace();
			}
		   Load();
		

		}

			
		});
		btnNewButton_4_1.setBounds(106, 297, 85, 23);
		Tutor.add(btnNewButton_4_1);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(201, 63, 298, 296);
		Tutor.add(scrollPane_1);
		
		table_3 = new JTable();
		table_3.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
			}
			@Override
			public void keyPressed(KeyEvent e) {
			}
		});
		table_3.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Name", "Email", "Phone", "Date"
			}
		));
		scrollPane_1.setViewportView(table_3);
		
		JLabel lblNewLabel_1_1_1_1_1_1 = new JLabel("Title");
		lblNewLabel_1_1_1_1_1_1.setBounds(10, 245, 53, 14);
		Tutor.add(lblNewLabel_1_1_1_1_1_1);
		
		t11_Box = new JComboBox<String>();
		t11_Box.setModel(new DefaultComboBoxModel<String>(new String[] {"‍AI", "OOP", "NMC"}));
		t11_Box.setBounds(92, 237, 50, 22);
		Tutor.add(t11_Box);
		
		StudentDetails = new JPanel();
		StudentDetails.setBackground(SystemColor.activeCaptionBorder);
		Cont.add(StudentDetails, "name_32105055047600");
		StudentDetails.setLayout(null);
		
		JLabel lblNewLabel_1_3 = new JLabel("First Name");
		lblNewLabel_1_3.setBounds(14, 82, 62, 14);
		StudentDetails.add(lblNewLabel_1_3);
		
		fnametext = new JTextField();
		fnametext.setColumns(10);
		fnametext.setBounds(86, 79, 86, 20);
		StudentDetails.add(fnametext);
		
		JLabel lblNewLabel_2_1 = new JLabel("Last Name");
		lblNewLabel_2_1.setBounds(14, 108, 62, 14);
		StudentDetails.add(lblNewLabel_2_1);
		
		lnametext = new JTextField();
		lnametext.setColumns(10);
		lnametext.setBounds(86, 102, 86, 20);
		StudentDetails.add(lnametext);
		
		JRadioButton maletext = new JRadioButton("Male");
		maletext.setBounds(86, 129, 62, 23);
		StudentDetails.add(maletext);
		
		JRadioButton femaletext = new JRadioButton("Female ");
		femaletext.setBounds(86, 158, 72, 23);
		StudentDetails.add(femaletext);
		
		JLabel lblNewLabel_3_1 = new JLabel("Gender");
		lblNewLabel_3_1.setBounds(14, 133, 42, 48);
		StudentDetails.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_4_2 = new JLabel("Address ");
		lblNewLabel_4_2.setBounds(14, 190, 62, 14);
		StudentDetails.add(lblNewLabel_4_2);
		
		addresstext = new JTextField();
		addresstext.setColumns(10);
		addresstext.setBounds(86, 188, 86, 20);
		StudentDetails.add(addresstext);
		
		JLabel lblNewLabel_5_2 = new JLabel("DOB");
		lblNewLabel_5_2.setBounds(14, 215, 42, 14);
		StudentDetails.add(lblNewLabel_5_2);
		
		dobtext = new JTextField();
		dobtext.setColumns(10);
		dobtext.setBounds(86, 212, 86, 20);
		StudentDetails.add(dobtext);
		
		email1text = new JTextField();
		email1text.setColumns(10);
		email1text.setBounds(86, 237, 86, 20);
		StudentDetails.add(email1text);
		
		JLabel lblNewLabel_6_1 = new JLabel("Email");
		lblNewLabel_6_1.setBounds(14, 240, 42, 14);
		StudentDetails.add(lblNewLabel_6_1);
		
		JLabel lblNewLabel_7_1 = new JLabel("Courses ");
		lblNewLabel_7_1.setBounds(14, 265, 62, 14);
		StudentDetails.add(lblNewLabel_7_1);
		
		JComboBox<String> t_Box = new JComboBox<String>();
		t_Box.setModel(new DefaultComboBoxModel<String>(new String[] {"‍BSc", "BBA", "BIBM"}));
		t_Box.setToolTipText("nnnn");
		t_Box.setBounds(86, 262, 72, 20);
		StudentDetails.add(t_Box);
		
		/*UPDATE FOR STUDENTS DETAILS**********************************************************/
		JButton btnNewButton_4_1_1 = new JButton("Update ");
		btnNewButton_4_1_1.addActionListener(new ActionListener() {
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
					String Email  =  email1text.getText();
					String Course  =  t_Box.getSelectedItem().toString();

				    try {
				        pst = getConnection().prepareStatement("UPDATE Study SET Name = ?, Sex = ?,Address = ?, DOB = ?,Email = ?, Course = ? WHERE ID = ?");
				        pst.setString(1, Name);
				        pst.setString(2, Gender);
    		            pst.setString(3, Address);
    					pst.setString(4, DOB);
    					pst.setString(5, Email);
    					pst.setString(6, Course);
    				    pst.setString(7, ID);
    					

				        int i = pst.executeUpdate();
				        if (i > 0) {
				            JOptionPane.showMessageDialog(ADD, "Record updated successfully");
				             idtxt.setText("");
	    					 fnametext.setText("");
	    					 lnametext.setText("");
	    					 addresstext.setText("");
	    					 dobtext.setText("");
	    					 email1text.setText("");
	    				    
				        } else {
				            JOptionPane.showMessageDialog(ADD, "Record not found");
				        }
				    } catch (SQLException ex) {
				        ex.printStackTrace();
				    }
				    Load();
				}
			
		});
		btnNewButton_4_1_1.setBounds(14, 336, 86, 23);
		StudentDetails.add(btnNewButton_4_1_1);
		/******EXIT UPDATE OF STUDENTS******************************************************************/
		JButton btnExit_1_1 = new JButton("Exit ");
		btnExit_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cont.removeAll();
	         	Cont.add(Students);
	         	Cont.revalidate();
	         	Cont.repaint();
			}
		});
		btnExit_1_1.setForeground(Color.RED);
		btnExit_1_1.setBounds(110, 336, 60, 23);
		StudentDetails.add(btnExit_1_1);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
			}
		});
		scrollPane_2.setBounds(178, 48, 321, 311);
		StudentDetails.add(scrollPane_2);
		
		table_4 = new JTable();
		scrollPane_2.setViewportView(table_4);
		table_4.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID","Name", "Sex", "Address", "DOB", "Email", "Course"
			}
		));
		
		JLabel lblNewLabel_1_3_1 = new JLabel("ID");
		lblNewLabel_1_3_1.setBounds(14, 54, 62, 14);
		StudentDetails.add(lblNewLabel_1_3_1);
		
		idtxt = new JTextField();
		idtxt.setColumns(10);
		idtxt.setBounds(86, 51, 86, 20);
		StudentDetails.add(idtxt);
		
		JLabel lblUpdateStudents = new JLabel("Students Details ");
		lblUpdateStudents.setForeground(new Color(255, 128, 0));
		lblUpdateStudents.setFont(new Font("Arial Black", Font.BOLD, 15));
		lblUpdateStudents.setBounds(14, 11, 229, 22);
		StudentDetails.add(lblUpdateStudents);
		
		JButton btnNewButton = new JButton("Add");
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
					String Email  =  email1text.getText();
					String Course  =  t_Box.getSelectedItem().toString();

				    try {
				        pst = getConnection().prepareStatement("insert into Study (ID,Name,Sex,Address,DOB,Email,Course) values (?,?,?,?,?,?,?) ");
				        pst.setString(1, ID);
 					    pst.setString(2, Name);
				        pst.setString(3, Gender);
 		                pst.setString(4, Address);
 					    pst.setString(5, DOB);
 					    pst.setString(6, Email);
 					    pst.setString(7, Course);
 					

				        int i = pst.executeUpdate();
				        if (i > 0) {
				            JOptionPane.showMessageDialog(ADD, "Record Add successfully");
				             idtxt.setText("");
	    					 fnametext.setText("");
	    					 lnametext.setText("");
	    					 addresstext.setText("");
	    					 dobtext.setText("");
	    					 email1text.setText("");
	    				     t_Box.setSelectedIndex(-1);
				        } else {
				            JOptionPane.showMessageDialog(ADD, "Record not found");
				        }
				    } catch (SQLException ex) {
				        ex.printStackTrace();
				    }
				    Load();
				}
			
		});
		btnNewButton.setBounds(14, 305, 62, 23);
		StudentDetails.add(btnNewButton);
		
		Tutors_info = new Panel();
		Tutors_info.setBackground(SystemColor.activeCaption);
		Cont.add(Tutors_info, "name_42240908475400");
		Tutors_info.setLayout(null);
		
		JLabel lblNewLabel_9 = new JLabel("Search Title");
		lblNewLabel_9.setBounds(20, 69, 81, 14);
		Tutors_info.add(lblNewLabel_9);
		
		JLabel lblNewLabel_9_1 = new JLabel("");
		lblNewLabel_9_1.setBounds(10, 99, 46, 14);
		Tutors_info.add(lblNewLabel_9_1);
		
		/*********SEARCHING FOR TUTOR *******************************************************/
		setutor = new JTextField();
		setutor.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String Searching = setutor.getText();
				Search(Searching);
			}
		});
		setutor.setBounds(120, 66, 76, 20);
		Tutors_info.add(setutor);
		setutor.setColumns(10);
		
		JScrollPane scrollPane_4 = new JScrollPane();
		scrollPane_4.setBounds(234, 66, 265, 281);
		Tutors_info.add(scrollPane_4);
		
		tutortable = new JTable();
		tutortable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Name","Title", "Assistment"
			}
		));
		scrollPane_4.setViewportView(tutortable);
		
		JLabel lblNewLabel_11 = new JLabel("Teacher ");
		lblNewLabel_11.setForeground(new Color(255, 128, 0));
		lblNewLabel_11.setFont(new Font("Arial", Font.BOLD, 17));
		lblNewLabel_11.setBounds(10, 11, 91, 25);
		Tutors_info.add(lblNewLabel_11);
		
		JButton btnNewButton_16 = new JButton("Marks");
		btnNewButton_16.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Mark();
				
			}
		});
		btnNewButton_16.setBounds(410, 28, 89, 23);
		Tutors_info.add(btnNewButton_16);
		
		button = new JButton("Assistement");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cont.removeAll();
	         	Cont.add(ctitle);
	         	Cont.revalidate();
	         	Cont.repaint();
			}
		});
		button.setBounds(261, 28, 122, 23);
		Tutors_info.add(button);
		
		JPanel Admin = new JPanel();
		Admin.setBackground(SystemColor.activeCaption);
		Admin.setForeground(Color.CYAN);
		Cont.add(Admin, "name_63595976062500");
		Admin.setLayout(null);
		
		JLabel lblNewLabel_10 = new JLabel("Searching ");
		lblNewLabel_10.setBounds(24, 80, 61, 17);
		Admin.add(lblNewLabel_10);
		
		seradmin = new JTextField();
		seradmin.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String Searching = seradmin.getText();
				Search4(Searching);
			}
		});
		seradmin.setBounds(115, 80, 86, 17);
		Admin.add(seradmin);
		seradmin.setColumns(10);
		
		JButton btnNewButton_13 = new JButton("Generate  Report");
		btnNewButton_13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
			    String naresh = id_text.getText();
			   // ID1= ID;
			   // IDsetter(ID);
				 try {
					pst = getConnection().prepareStatement("Select * from Marks  inner join study where Marks.ID = ? and study.ID = ? ");
					pst.setString(1, naresh);
					pst.setString(2, naresh);
					
					res = pst.executeQuery();
					if(res.next())
					{
					
						new Result(naresh);
					}
					else
					{
						JOptionPane.showMessageDialog(ADD, "Record not found");
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				 
				 
				 
				 
			}
		});
		btnNewButton_13.setBounds(96, 302, 143, 23);
		Admin.add(btnNewButton_13);
		
		JScrollPane scroll = new JScrollPane();
		scroll.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				//////////////////////////////******************************************************************************
			}
		});
		scroll.setBounds(270, 50, 229, 275);
		Admin.add(scroll);
		
		admintable = new JTable();
		admintable.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String admintable = seradmin.getText();
				Search4(admintable);
			}
		});
		scroll.setViewportView(admintable);
		admintable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Name"
			}
		));
		
		id_text = new JTextField();
		id_text.setBackground(Color.LIGHT_GRAY);
		id_text.setBounds(115, 125, 86, 31);
		Admin.add(id_text);
		id_text.setColumns(10);
		
		JLabel lblNewLabel_18 = new JLabel("ID");
		lblNewLabel_18.setFont(new Font("Arial Black", Font.BOLD, 13));
		lblNewLabel_18.setForeground(Color.BLUE);
		lblNewLabel_18.setBounds(31, 131, 61, 25);
		Admin.add(lblNewLabel_18);
		
		JLabel lblNewLabel_19 = new JLabel("Generate Report ");
		lblNewLabel_19.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_19.setBounds(20, 25, 136, 17);
		Admin.add(lblNewLabel_19);
		
		JButton btnNewButton_14 = new JButton("Exit");
		btnNewButton_14.setForeground(Color.RED);
		btnNewButton_14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cont.removeAll();
	         	Cont.add(Dash);
	         	Cont.revalidate();
	         	Cont.repaint();
			}
		});
		btnNewButton_14.setBounds(410, 336, 89, 23);
		Admin.add(btnNewButton_14);
		
		ctitle = new JPanel();
		ctitle.setBackground(SystemColor.inactiveCaption);
		Cont.add(ctitle, "name_8789868310899");
		ctitle.setLayout(null);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.CYAN);
		panel_3.setBounds(10, 69, 224, 126);
		ctitle.add(panel_3);
		panel_3.setLayout(null);
		
		JButton btnNewButton_5 = new JButton("Concepts and Technology of AI");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				//Ai obj1 = new Ai();
				//obj1.frame.setVisible(true);
				//frame.dispose();
				frame.setVisible(true);
				new Ai();
				//obj1.frame.setVisible(false);
			}
		});
		btnNewButton_5.setBackground(SystemColor.activeCaptionBorder);
		btnNewButton_5.setBounds(10, 11, 204, 106);
		panel_3.add(btnNewButton_5);
		
		JPanel panel_3_1 = new JPanel();
		panel_3_1.setBackground(Color.CYAN);
		panel_3_1.setBounds(263, 69, 236, 126);
		ctitle.add(panel_3_1);
		panel_3_1.setLayout(null);
		
		JButton btnNewButton_6 = new JButton(" Numerical Methods and Concurrency");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(true);
				new Nmc();
			//	frame.setVisible(true);
				//frame.setVisible(false);
			// Nmc obj1 = new Nmc();
			// obj1.frame.setVisible(false);
			}
		});
		btnNewButton_6.setBackground(SystemColor.activeCaptionBorder);
		btnNewButton_6.setBounds(10, 11, 216, 106);
		panel_3_1.add(btnNewButton_6);
		
		JPanel panel_3_1_1 = new JPanel();
		panel_3_1_1.setBackground(Color.CYAN);
		panel_3_1_1.setBounds(78, 227, 251, 132);
		ctitle.add(panel_3_1_1);
		panel_3_1_1.setLayout(null);
		
		JButton btnNewButton_7 = new JButton("Object-Oriented Design and Programming");
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Oop();
			}
		});
		btnNewButton_7.setBackground(SystemColor.activeCaptionBorder);
		btnNewButton_7.setBounds(10, 11, 231, 109);
		panel_3_1_1.add(btnNewButton_7);
		
		JLabel lblNewLabel_12 = new JLabel("Course Titles ");
		lblNewLabel_12.setForeground(new Color(255, 128, 0));
		lblNewLabel_12.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_12.setBackground(new Color(255, 128, 0));
		lblNewLabel_12.setBounds(10, 11, 127, 34);
		ctitle.add(lblNewLabel_12);
		
		JButton btnNewButton_12 = new JButton("Exit");
		btnNewButton_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_12.setBounds(410, 336, 89, 23);
		ctitle.add(btnNewButton_12);
		
		JPanel mainStudent = new JPanel();
		mainStudent.setBackground(SystemColor.activeCaptionBorder);
		Cont.add(mainStudent, "name_11788110825000");
		mainStudent.setLayout(null);
		
		JLabel lblNewLabel_13_1 = new JLabel("Tutor Details");
		lblNewLabel_13_1.setBounds(10, 114, 76, 14);
		mainStudent.add(lblNewLabel_13_1);
		
		JLabel titless = new JLabel("Course Title");
		titless.setBounds(23, 152, 90, 18);
		mainStudent.add(titless);
		
		JComboBox<String> ai = new JComboBox<String>();
		ai.setModel(new DefaultComboBoxModel<String>(new String[] {"AI", "NIC", "OOP"}));
		ai.setBounds(164, 150, 92, 22);
		mainStudent.add(ai);
		
		/****************************************TEACHER DETAILS ACESS******************************************************/
		JButton btnNewButton_10 = new JButton("Click");
		btnNewButton_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String Title = ai.getSelectedItem().toString();
				
				 
				 try {
					pst = getConnection().prepareStatement("Select * from Tutor   where Title = ?");
					pst.setString(1, Title);
					
					
					res = pst.executeQuery();
					if(res.next())
					{
						name.setText(res.getString(2));
						email.setText(res.getString(3));
					
						
					}
					
				
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				 
			
			}
			
		});
		btnNewButton_10.setBounds(10, 336, 89, 23);
		mainStudent.add(btnNewButton_10);
		
		JLabel lblNewLabel_14 = new JLabel("Tutor Name");
		lblNewLabel_14.setBounds(23, 219, 90, 14);
		mainStudent.add(lblNewLabel_14);
		
		name = new JTextField();
		name.setBounds(164, 216, 111, 20);
		mainStudent.add(name);
		name.setColumns(10);
		
		JLabel lblNewLabel_14_1 = new JLabel("Tutor Email");
		lblNewLabel_14_1.setBounds(23, 261, 90, 14);
		mainStudent.add(lblNewLabel_14_1);
		
		email = new JTextField();
		email.setColumns(10);
		email.setBounds(164, 258, 111, 20);
		mainStudent.add(email);
		
		JButton btnNewButton_11 = new JButton("Exit");
		btnNewButton_11.setBounds(410, 336, 89, 23);
		mainStudent.add(btnNewButton_11);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.PINK);
		panel_4.setBounds(0, 0, 509, 113);
		mainStudent.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblNewLabel_15 = new JLabel("ID");
		lblNewLabel_15.setBounds(10, 49, 64, 14);
		panel_4.add(lblNewLabel_15);
		
		JLabel lblNewLabel_13 = new JLabel("Name");
		lblNewLabel_13.setBounds(10, 77, 64, 14);
		panel_4.add(lblNewLabel_13);
		
		JLabel label_1 = new JLabel("1357");
		label_1.setBounds(106, 49, 104, 14);
		panel_4.add(label_1);
		
		JLabel lblNareshSejwal = new JLabel("Naresh Sejwal");
		lblNareshSejwal.setBounds(106, 77, 104, 14);
		panel_4.add(lblNareshSejwal);
		
		JButton btnNewButton_8 = new JButton("Enroll ");
		btnNewButton_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new Enroll();
				frame.setVisible(true);
			}
		});
		btnNewButton_8.setBounds(403, 11, 106, 23);
		panel_4.add(btnNewButton_8);
		
		JButton btnNewButton_9 = new JButton("Assessment ");
		btnNewButton_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cont.removeAll();
	         	Cont.add(ctitle);
	         	Cont.revalidate();
	         	Cont.repaint();
			}
		});
		btnNewButton_9.setBounds(387, 68, 122, 23);
		panel_4.add(btnNewButton_9);
		
		JLabel lblNewLabel_16 = new JLabel("STUDENT");
		lblNewLabel_16.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_16.setForeground(new Color(255, 128, 0));
		lblNewLabel_16.setBounds(10, 11, 76, 18);
		panel_4.add(lblNewLabel_16);
		
		JPanel system = new JPanel();
		system.setBounds(10, 0, 155, 370);
		frame.getContentPane().add(system);
		system.setBackground(new Color(128, 64, 64));
		
		JButton jButton1 = new JButton("Student");
		jButton1.setForeground(new Color(0, 0, 0));
		jButton1.setBackground(SystemColor.activeCaption);
		jButton1.setBounds(18, 145, 108, 23);
		jButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cont.removeAll();
	         	Cont.add(mainStudent);
	         	Cont.revalidate();
	         	Cont.repaint();
         	
				
			}
		});
		
		JButton B_2 = new JButton("Courses");
		B_2.setBackground(SystemColor.activeCaption);
		B_2.setForeground(Color.BLACK);
		B_2.setBounds(18, 172, 108, 23);
		B_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
             	Cont.removeAll();
             	Cont.add(Course); 
             	Cont.revalidate();
             	Cont.repaint();
            
			}
		});
		
		JButton B_3 = new JButton("Tutors-D ");
		B_3.setForeground(Color.BLACK);
		B_3.setBackground(SystemColor.activeCaption);
		B_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cont.removeAll();
				Cont.add(Tutor);
				Cont.revalidate();
				Cont.repaint();
			}
		});
		B_3.setBounds(19, 199, 107, 23);
		
		B_7 = new JButton("Setting");
		B_7.setForeground(Color.BLACK);
		B_7.setBackground(SystemColor.activeCaption);
		B_7.setBounds(19, 308, 107, 23);
		
		JButton B_8 = new JButton("Log Out");
		B_8.setForeground(Color.BLACK);
		B_8.setBackground(SystemColor.activeCaption);
		B_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new login();
				frame.setVisible(false);
			}
		});
		B_8.setBounds(19, 336, 107, 23);
		
		B_4 = new JButton("Admin");
		B_4.setForeground(Color.BLACK);
		B_4.setBackground(SystemColor.activeCaption);
		B_4.setBounds(18, 281, 108, 23);
		B_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cont.removeAll();
             	Cont.add(Admin); 
             	Cont.revalidate();
             	Cont.repaint();
             	Load5();
			}
		});
		
		JButton jButton1_1 = new JButton("Dashboard ");
		jButton1_1.setForeground(Color.BLACK);
		jButton1_1.setBackground(SystemColor.activeCaption);
		jButton1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cont.removeAll();
             	Cont.add(Dash); 
             	Cont.revalidate();
             	Cont.repaint();
			}
		});
		jButton1_1.setBounds(19, 117, 107, 23);
		
		JLabel lblCourseManagementSystem = new JLabel("Naresh Sejwal");
		lblCourseManagementSystem.setBounds(10, -6, 140, 39);
		lblCourseManagementSystem.setHorizontalAlignment(SwingConstants.CENTER);
		lblCourseManagementSystem.setForeground(new Color(255, 128, 0));
		lblCourseManagementSystem.setFont(new Font("Calisto MT", Font.BOLD, 15));
		lblCourseManagementSystem.setBackground(Color.LIGHT_GRAY);
		
		JLabel lblNewLabel_1_2 = new JLabel("Login as:");
		lblNewLabel_1_2.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_1_2.setBounds(10, 54, 67, 23);
		
		loginastxt = new JTextField();
		loginastxt.setFont(new Font("Tahoma", Font.BOLD, 13));
		loginastxt.setBackground(new Color(250, 240, 230));
		loginastxt.setBounds(10, 77, 125, 29);
		loginastxt.setEditable(false);
		loginastxt.setColumns(10);
		system.setLayout(null);
		system.add(lblCourseManagementSystem);
		system.add(B_8);
		system.add(B_7);
		system.add(B_3);
		system.add(B_4);
		system.add(B_2);
		system.add(jButton1);
		system.add(jButton1_1);
		system.add(lblNewLabel_1_2);
		system.add(loginastxt);
		
		jButton1_2 = new JButton("Students");
		jButton1_2.setForeground(Color.BLACK);
		jButton1_2.setBackground(SystemColor.activeCaption);
		jButton1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cont.removeAll();
	         	Cont.add(Students);
	         	Cont.revalidate();
	         	Cont.repaint();
			}
		});
		jButton1_2.setBounds(18, 225, 108, 23);
		system.add(jButton1_2);
		
		B_3_1 = new JButton("Tutors ");
		B_3_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cont.removeAll();
	         	Cont.add(Tutors_info);
	         	Cont.revalidate();
	         	Cont.repaint();
			}
		});
		B_3_1.setForeground(Color.BLACK);
		B_3_1.setBackground(SystemColor.activeCaption);
		B_3_1.setBounds(19, 253, 107, 23);
		system.add(B_3_1);
		
		JLabel lblNewLabel_21 = new JLabel("L5CG2");
		lblNewLabel_21.setForeground(new Color(255, 128, 0));
		lblNewLabel_21.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_21.setBounds(31, 29, 67, 14);
		system.add(lblNewLabel_21);
		frame.setVisible(true);
		
	}
}
