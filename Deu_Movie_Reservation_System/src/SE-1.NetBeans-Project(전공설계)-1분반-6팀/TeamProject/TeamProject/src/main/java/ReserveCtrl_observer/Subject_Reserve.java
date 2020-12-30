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
public interface Subject_Reserve {
    public void add(Observer observer);
    public void delete(Observer observer,int reserveNum);
    public void notifyObserver(String notify);
    public boolean check_reservation(int reserveNum);
}
