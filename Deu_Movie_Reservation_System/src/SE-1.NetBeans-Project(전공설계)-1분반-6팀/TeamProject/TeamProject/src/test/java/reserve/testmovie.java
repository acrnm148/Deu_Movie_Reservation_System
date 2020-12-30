/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reserve;

import java.sql.*;

public class testmovie {
    public static void main(String[] args) throws SQLException{
        Connection con = null;
		PreparedStatement pstmt = null;
		// "Statement pstmt = null;"에 비해 미리처리하기 때문에 빠르게 처리
		ResultSet rs = null;
                 con = DriverManager.getConnection("jdbc:mysql://localhost:3305/movieinfo?serverTimezone=UTC","root","0000");
		String sql = "SELECT name FROM movieinfo";

		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				
                                String name = rs.getString("name"); // id 필드값을 가져옴
                                System.out.println(name);
				
			}

			rs.close();
			pstmt.close();
			con.close();

		} catch (SQLException e) {
			System.out.println("[ERROR]" + e.getMessage());
			e.printStackTrace();

		} catch (Exception e) {
			System.out.println("[ERROR]" + e.getMessage());
			e.printStackTrace();
		}

    }
}

  