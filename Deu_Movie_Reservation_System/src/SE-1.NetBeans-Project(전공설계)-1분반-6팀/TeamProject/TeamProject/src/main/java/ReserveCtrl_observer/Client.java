/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ReserveCtrl_observer;

/**
 *
 * @author 강수나
 */
public class Client implements Observer{
    
    @Override
    public void update(String lecture_notify) {
        System.out.print("알림! ");
        System.out.println(lecture_notify);
    }
     
}
