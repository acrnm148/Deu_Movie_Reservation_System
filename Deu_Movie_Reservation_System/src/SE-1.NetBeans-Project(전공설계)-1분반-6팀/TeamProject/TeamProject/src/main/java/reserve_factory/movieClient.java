/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reserve_factory;


/**
 *
 * @author 강수나
 */
public class movieClient {
    
    public static void work(String name, int reserveNum) {
        // TODO code application logic here
        MovieFactory mf = new ReserveMovieFactory();
        String reservedName = name;
        
        Movie reservedMovie = mf.reserveMovie(reservedName);
         
        reservedMovie.getInfo();
        reservedMovie.selectSeat(reserveNum);
        reservedMovie.move();
    }
}
