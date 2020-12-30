
package movieList_strategy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Movie3 implements Movie_Strategy {
        String name = null;
        String theater = null;
        String runningtime = null;
        String leftseat = null;
        String totalseat = null;
        String starttime = null;
        
    @Override
    public void showInfo() {
        Connection con;
        con = null;
	PreparedStatement pstmt = null; // "Statement pstmt = null;"에 비해 미리처리하기 때문에 속도가 더 빠름
	ResultSet rs = null;
        
       try {  //DB URL 수정해서 쓰세용
           con = DriverManager.getConnection("jdbc:mysql://localhost:3305/movieinfo?serverTimezone=UTC","root","0000");
       } catch (SQLException ex) {
           Logger.getLogger(Movie3.class.getName()).log(Level.SEVERE, null, ex);
       }
                
	String sql = "SELECT name, theater, runningtime, leftseat, totalseat, starttime,"
                        + "location, price, state"
                        + " FROM movieinfo, seat_t1m3 WHERE id='3' and state = '0'"; //수정
                
	try {
                	pstmt = con.prepareStatement(sql);
		rs = pstmt.executeQuery();
                        
			while (rs.next()) {
                                
                                name = rs.getString("name"); // name 필드값을 가져옴
                                theater = rs.getString("theater");
                                runningtime = rs.getString("runningtime");
                                leftseat = rs.getString("leftseat");
                                totalseat = rs.getString("totalseat");
                                starttime = rs.getString("starttime");                         
			}
                        
                        //출력
                        System.out.println("---------------");
                        System.out.println("영화명:"+name);
                        System.out.println("상영관:"+theater);
                        System.out.println("상영시간:"+runningtime);
                        System.out.println("잔여좌석:"+leftseat);
                        System.out.println("총좌석:"+totalseat);
                        System.out.println("시작시간:"+starttime);
                        
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
