
package reserve_factory;
//Product

import java.util.ArrayList;


public abstract class Movie {
  protected String name;
  protected String theater;
  protected String runningtime;
  protected int leftseat;
  protected String totalseat;
  protected String starttime;
  protected String location;
  protected String price;
  protected String state;
  protected int reserveNum;
  protected ArrayList<String> seats = new ArrayList<String>();
  
  public abstract void Load() ;  //DB에서 영화 정보, 좌석 정보를 가져오는 메소드
  public abstract void getInfo() ;  //영화 정보 출력 메소드
  public abstract void selectSeat(int reserveNum) ;  //좌석 정보 출력 및 선택 메소드
  public abstract void check(String answer, int reserveNum) ;  //가격확인 후 선택내역
  public abstract void move() ;  //간식 메뉴 화면/결제 화면으로 이동
}
