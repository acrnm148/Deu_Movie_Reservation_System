
package reserve_factory;
//concreteProduct
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

class Theater2Movie3 extends Movie {
//DB에서 영화 정보, 좌석 정보를 가져오는 메소드
    @Override
    public void Load() {
        Connection con;
        con = null;
        PreparedStatement pstmt = null; // "Statement pstmt = null;"에 비해 미리처리하기 때문에 속도가 더 빠름
        ResultSet rs = null;

        try {  //DB URL 수정해서 쓰세용
            con = DriverManager.getConnection("jdbc:mysql://localhost:3305/movieinfo?serverTimezone=UTC", "root", "0000");
        } catch (SQLException ex) {
            Logger.getLogger(Theater2Movie3.class.getName()).log(Level.SEVERE, null, ex);
        }

        String sql = "SELECT name, theater, runningtime, leftseat, totalseat, starttime,"
                + "location, price, state"
                + " FROM movieinfo, seat_t2m3 WHERE id='6' and state = '0'"; //수정

        try {
            pstmt = con.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while (rs.next()) {

                name = rs.getString("name"); // name 필드값을 가져옴
                theater = rs.getString("theater");
                runningtime = rs.getString("runningtime");
                leftseat = rs.getInt("leftseat");
                totalseat = rs.getString("totalseat");
                starttime = rs.getString("starttime");
                location = rs.getString("location");
                price = rs.getString("price");
                //state = rs.getString("state");
                seats.add(location);
                //count++;
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

    //영화 정보 출력 메소드
    @Override
    public void getInfo() {
        Load();

        System.out.println("영화명:" + name);
        System.out.println("상영관:" + theater);
        System.out.println("상영시간:" + runningtime);
        System.out.println("잔여좌석:" + leftseat);
        System.out.println("총좌석:" + totalseat);
        System.out.println("시작시간:" + starttime);
    }

    //좌석 정보 출력 및 선택 메소드
    @Override
    public void selectSeat(int reserveNum) {
        String answer = null;
        Boolean answerstate = true;
        Load();

        //좌석정보
        System.out.println("----SCREEN----");
        System.out.println("[A1] [A2] [A3]");
        System.out.println("[B1] [B2] [B3]");
        System.out.println("[C1] [C2] [C3]");
        System.out.print("선택 가능한 좌석: ");
        for (int i = 0; i < seats.size() / 2; i++) { //반복문으로 출력
            if (i == seats.size() / 2 - 1) {
                System.out.println(seats.get(i));
            } else {
                System.out.print(seats.get(i) + ", ");
            }
        }

        //좌석 입력
        while (answerstate) {
            System.out.print("좌석을 입력해주세요: ");
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            try {
                answer = in.readLine();
            } catch (IOException ioe) {
                System.err.println(ioe);
            }
            if (answer == null) {
                answer = "예매취소";
            }
            for (int i = 0; i < seats.size() / 2; i++) { //반복문으로 출력
                if (answer.equals(seats.get(i))) {
                    answerstate = false;
                }
            }
        }
        check(answer, reserveNum);
        //move();
    }

    //가격확인 후 선택내역
    @Override
    public void check(String answer, int reserveNum) {

        String selectedSeat = null;
        selectedSeat = answer;
        System.out.println(selectedSeat + " 좌석을 선택하셨습니다.");

        System.out.println("---------------------------------");
        System.out.println("영화명:" + name);
        System.out.println("상영관:" + theater);
        System.out.println("상영시간:" + runningtime);
        System.out.println("선택좌석:" + selectedSeat); //필요시 getSelectSeat 만들 것
        System.out.println("가격:" + price);

        //예매내역에 올림
        UploadReservation(selectedSeat, reserveNum);
    }

    //예매내역에 올리는 메소드
    public void UploadReservation(String selectedSeat, int reserveNum) {
        
        Connection con;
        con = null;
        PreparedStatement pstmt = null; // "Statement pstmt = null;"에 비해 미리처리하기 때문에 속도가 더 빠름
        int insertCount;
        //ResultSet rs = null;

        try {  //DB URL 수정해서 쓰세용
            con = DriverManager.getConnection("jdbc:mysql://localhost:3305/movieinfo?serverTimezone=UTC", "root", "0000");
        } catch (SQLException ex) {
            Logger.getLogger(Theater2Movie3.class.getName()).log(Level.SEVERE, null, ex);
        }

        String sql = "INSERT INTO reservation VALUE ("+reserveNum+",'"+name+"','"+theater+"','"+runningtime+"','"+starttime
                +"','"+price+"','"+selectedSeat+"')";
                
        try {
            pstmt = con.prepareStatement(sql);
            insertCount = pstmt.executeUpdate();

            //rs.close();
            pstmt.close();
            con.close();

        } catch (SQLException e) {
            System.out.println("[ERROR]" + e.getMessage());
            e.printStackTrace();

        } catch (Exception e) {
            System.out.println("[ERROR]" + e.getMessage());
            e.printStackTrace();
        }
        //reserveNum++;
    }

    //간식 메뉴 화면으로 이동
    @Override
    public void move() {

        String answer = null;
        System.out.println("간식 메뉴 화면으로 이동합니다.");
            //간식 메뉴 화면으로 이동
            try {
                Snack_deco.SelectPopcorn.work();
            } catch (IOException ex) {
                Logger.getLogger(Theater2Movie3.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
}
