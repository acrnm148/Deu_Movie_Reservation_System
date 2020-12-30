/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ReserveCtrl_observer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 강수나
 */
public class ReserveManager implements Subject_Reserve {

    private String num;
    private String name;
    private String theater;
    private String runningtime;
    private String starttime;
    private String price;
    private String location;
    private ArrayList<Observer> observers;

    public ReserveManager() {

        observers = new ArrayList<>();
    }

    @Override
    public void add(Observer observer) {
        observers.add(observer);
        System.out.println("add");
    }

    @Override
    public void delete(Observer observer, int reserveNum) {
        observers.remove(observer);
        System.out.println("delete");

        //DB에서 예매내역 삭제
        CancelReservation(reserveNum);
        System.out.println("예매가 취소되었습니다.");
    }

    @Override
    public void notifyObserver(String notify) {
        for (Observer observer : observers) {
            observer.update(notify);
        }
    }

    //예매내역 출력
    public boolean check_reservation(int reserveNum) {

        LoadReservation(reserveNum);

        if (num != null) {
            System.out.println("<예매 내역>");
            System.out.println("예매번호:" + num);
            System.out.println("영화명:" + name);
            System.out.println("상영관:" + theater);
            System.out.println("상영시간:" + runningtime);
            System.out.println("시작시간:" + starttime);
            System.out.println("좌석:" + location);
            System.out.println("가격:" + price);
            
            return true;
        } else {
            System.out.println("조회되지 않았습니다.");
            return false;
        }
    }

//예매내역 가져오는 메소드
    public void LoadReservation(int reserveNum) {
        Connection con;
        con = null;
        PreparedStatement pstmt = null; // "Statement pstmt = null;"에 비해 미리처리하기 때문에 속도가 더 빠름
        ResultSet rs = null;

        try {  //DB URL 수정해서 쓰세용
            con = DriverManager.getConnection("jdbc:mysql://localhost:3305/movieinfo?serverTimezone=UTC", "root", "0000");
        } catch (SQLException ex) {
            Logger.getLogger(ReserveManager.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

        String sql = "SELECT num, name, theater, runningtime, starttime, price, location"
                + " FROM reservation WHERE num =" + reserveNum;

        try {
            pstmt = con.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                num = rs.getString("num");
                name = rs.getString("name"); // name 필드값을 가져옴
                theater = rs.getString("theater");
                runningtime = rs.getString("runningtime");
                starttime = rs.getString("starttime");
                location = rs.getString("location");
                price = rs.getString("price");
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

    //DB에서 예매내역 삭제하는 메소드
    public void CancelReservation(int reserveNum) {
        Connection con;
        con = null;
        PreparedStatement pstmt = null; // "Statement pstmt = null;"에 비해 미리처리하기 때문에 속도가 더 빠름
        //ResultSet rs = null;
        int deleteCount;

        try {  //DB URL 수정해서 쓰세용
            con = DriverManager.getConnection("jdbc:mysql://localhost:3305/movieinfo?serverTimezone=UTC", "root", "0000");
        } catch (SQLException ex) {
            Logger.getLogger(ReserveManager.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

        String sql = "DELETE FROM reservation WHERE num ='" + reserveNum + "'";

        try {
            pstmt = con.prepareStatement(sql);
            deleteCount = pstmt.executeUpdate();

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
    }

}
