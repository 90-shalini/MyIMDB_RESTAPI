package org.trainings.rest.MyIMDBUtilities;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class MovieService {

	private Connection con = new DBConnection().getConnection();
	
	public String getMovieDetail(int id){
		String title = null;
		ResultSet rs = null;
		try {
			String query = "Select * from film WHERE id="+id+";";
			Statement stmt = con.createStatement();
			rs = stmt.executeQuery(query);
			while(rs.next()){
				title = rs.getString("title");
			}
			if(rs !=null)
				rs.close();

			return title; 

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return title;



	}



}
