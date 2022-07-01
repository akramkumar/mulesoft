package mulesoft;
import java.sql.*;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class Main {
public static void main(String [] args) {
	createtable.createNewTable();
	insert("Hridayam","Pranav Mohanlal","Kalyani Priyadarshan",2022,"Vineeth Sreenivasan");
	insert("KRK","Vijay Sethupathi","Samantha     ",2022,"Vignesh Shivan");
	insert("Beast","Vijay","Pooja Hegde",2022,"Nelson Dilipkumar");
	insert("Don","Sivakarthikeyan","Priyanka Mohan",2022,"Cibi Chakaravarthi");
	insert("VIKRAM","Kamala Hasan","Vijay Sethupathi   ",2022,"Lokesh Kanagaraj");
	select.selectAll();
	select.selectactormovie();
}
private static void insert(String moviename,String leadactor,String actress,Integer yearofrelease,String director) {
	Connection con=Dbconnection.connect();
	PreparedStatement ps=null;
	try {
		String sql="INSERT INTO movies(moviename,leadactor,actress,yearofrelease,director) VALUES(?,?,?,?,?)";
		ps = con.prepareStatement(sql);
		ps.setString(1, moviename);
		ps.setString(2, leadactor);
		ps.setString(3, actress);
		ps.setInt(4,yearofrelease);
		ps.setString(5, director);
		ps.execute();
		System.out.println("Data has been inserted Successfully");
	}catch(SQLException e) {
		System.out.println(e.toString());
	}
}
}
