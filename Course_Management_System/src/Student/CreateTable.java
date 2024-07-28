package Student;

import java.sql.DriverManager;
import java.sql.Statement;

public class CreateTable {
	String url = "jdbc:mysql://localhost:3306/Student";
    String username = "root";
    String password = "9563";
	
    void checkConnection(){
        try{
            //load the driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            //create the connection
            
            
			java.sql.Connection connect = DriverManager.getConnection(url,username,password);	
			Statement statement = connect.createStatement();
			
			String queryString2 = "Create table data(Username varchar(250), Email varchar(250),Password varchar(250),PhoneNumber int, SelectUsermode varchar(250))";
		    String queryString4 = "Create table Study(ID int  primary key, Name varchar(250),Mobile int, Course varchar(250))";
			//String queryString5 = "Create table Course(ID int  primary key, Code varchar(250),Title varchar(250), Module varchar(250),Information varchar(250))";
			String queryString6 = "Create table Tutor(ID int  primary key, Name varchar(250),Email varchar(255) , Phone int , Date varchar(250),Title varchar (250))";
			String queryString7 = "Create table Study(ID int  primary key, Name varchar(250),Sex varchar(50), Address varchar(250),DOB varchar(250),Email varchar(250), Course varchar(250))";
			String queryString8 = "Create table Course(ID int primary key, Name varchar(250),Title varchar(250), Module varchar(250),Year varchar(250))";
			String queryString9 = "Create table Studentinfo(ID int  , Name varchar(250),Sex varchar(50), Address varchar(250),DOB varchar(250),Email varchar(250), Course varchar(250))";
		    String queryString10 = "Create table TaskAI (ID int  , Week int ,Que varchar(50), Ans varchar(250))";
		    String queryString11 = "Create table Marks(ID int , Name varchar(250),Course varchar(250),AI int,  OOP int ,NMC int)";
			String queryString12 = "Create table Assistments(ID int, Name varchar(250),Title varchar(250), Assistment varchar(250),Week int)";
			
			
			statement.execute(queryString2);
			statement.execute(queryString4);
			//statement.execute(queryString5);
			statement.execute(queryString6);
			statement.execute(queryString7);
			statement.execute(queryString8);
			statement.execute(queryString9);
			statement.execute(queryString10);
			statement.execute(queryString11);
			statement.execute(queryString12);
			
			
			
			System.out.println("Create table successfully!");
			connect.close();
            		
        }catch (Exception exp){
            System.out.println(exp);
        }
    }
	public static void main(String[] args) {
		new CreateTable().checkConnection();

	}

}

