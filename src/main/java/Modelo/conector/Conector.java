package Modelo.conector;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conector {
	    
	    private final static String URL = "repaso_caba";
	    private final static String USR = "root";
	    private final static String PASSWD = "";
	    private final static String HOST = "localhost";
	    
	    private Connection con;
	 
	 public void conectar() {
	     
	        try {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            con = DriverManager.getConnection("jdbc:mysql://" + HOST + "/" + URL, USR, PASSWD);
	        } catch (Exception e) {
	            System.out.println(e);
	    }
	 }

	public  Connection getCon() {
		return con;
	}

	public void setCon(Connection con) {
		this.con = con;
	}

	 
	 
}
