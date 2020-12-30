/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package startmenu_state;

/**
 *
 * @author bubble
 */
public class Person {
   private MovieState movieState;
   
   public Person(){
       movieState = new Ticket();
   }
   public void setState(MovieState movieState){
       this.movieState = movieState;
   }
   public String getState(){
       return movieState.getState();
   }
}
