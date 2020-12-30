package movieList_strategy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import reserve_factory.Theater1Movie1;

/**
 *
 * @author 배민정
 */
public class Movietest {

    public static String work() {
        String answer = null;
        boolean state = true;
        System.out.println("영화를 선택해주세요.");
        int count = LoadName();
        answer = choiceMovie(count);
        
            if (answer.equals("1")) {
                Movie_Context Movie1 = new Movie_Context(new Movie1());
                Movie1.show();
                //state = false;
            } else if (answer.equals("2")) {
                Movie_Context Movie2 = new Movie_Context(new Movie2());
                Movie2.show();
                //state = false;
            } else if (answer.equals("3")) {
                Movie_Context Movie3 = new Movie_Context(new Movie3());
                Movie3.show();
                //state = false;
            } else if (answer.equals("4")) {
                Movie_Context Movie4 = new Movie_Context(new Movie4());
                Movie4.show();
                //state = false;
            } else if (answer.equals("5")) {
                Movie_Context Movie5 = new Movie_Context(new Movie5());
                Movie5.show();
                //state = false;
            } else if (answer.equals("6")) {
                Movie_Context Movie6 = new Movie_Context(new Movie6());
                Movie6.show();
                //state = false;
            } else {
                System.out.println("다시 선택해주세요.");
                answer = null;
            }
        return answer;
    }

    public static int LoadName() {
        int count = 0;
        String id = null;
        String name = null;
        String theater = null;
        String runningtime = null;
        String leftseat = null;
        String totalseat = null;
        String starttime = null;

        Connection con;
        con = null;
        PreparedStatement pstmt = null; // "Statement pstmt = null;"에 비해 미리처리하기 때문에 속도가 더 빠름
        ResultSet rs = null;

        try {  //DB URL 수정해서 쓰세용
            con = DriverManager.getConnection("jdbc:mysql://localhost:3305/movieinfo?serverTimezone=UTC", "root", "0000");
        } catch (SQLException ex) {
            Logger.getLogger(Theater1Movie1.class.getName()).log(Level.SEVERE, null, ex);
        }

        String sql = "SELECT * FROM movieinfo"; //수정

        try {
            pstmt = con.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while (rs.next()) {

                id = rs.getString("id");
                name = rs.getString("name"); // name 필드값을 가져옴
                theater = rs.getString("theater");
                runningtime = rs.getString("runningtime");
                leftseat = rs.getString("leftseat");
                totalseat = rs.getString("totalseat");
                starttime = rs.getString("starttime");
                System.out.println(id + ". " + name + " / 상영관:" + theater + " / 상영시간:" + runningtime
                        + " / 잔여좌석:" + leftseat + " / 총좌석" + totalseat + " / 시작시간" + starttime);
                count++;
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
        return count;
    }

    public static String choiceMovie(int count) {
        String answer = null;
        boolean state = true;
        System.out.println("입력:");

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        try {
            answer = in.readLine();
        } catch (IOException ioe) {
            System.err.print(ioe);
        }
        return answer;
    }
}
