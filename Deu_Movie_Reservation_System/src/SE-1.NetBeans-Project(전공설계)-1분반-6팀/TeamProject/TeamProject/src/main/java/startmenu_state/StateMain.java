/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package startmenu_state;

import static Snack_deco.SelectPopcorn.popcornPrice;
import java.util.Scanner;

/**
 *
 * @author bubble
 */
public class StateMain {

    /**
     * @param args the command line arguments
     */
    public static int work() {
        
        // TODO code application logic here
        
            System.out.println();
            System.out.println("--------시작메뉴---------");
            System.out.println("1. 예매 2. 영화조회 3. 예매취소");

            Person person = new Person();

            int state = 0;
            Scanner scan = new Scanner(System.in);
            state = scan.nextInt();
            String stateString = "";

            switch (state) {
                case 1: //예매
                    //Person person = new Person();
                    System.out.println(person.getState());
                    break;
                case 2: //조회
                    person.setState(new search());
                    System.out.println(person.getState());
                    break;
                case 3: //취소
                    person.setState(new cancel());
                    System.out.println(person.getState());
                    break;
                default:
                    break;
            }
            System.out.println(stateString);

            return state;
    }
}
