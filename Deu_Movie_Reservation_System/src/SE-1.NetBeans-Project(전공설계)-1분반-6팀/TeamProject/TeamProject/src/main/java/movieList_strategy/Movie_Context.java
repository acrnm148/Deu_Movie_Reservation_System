
package movieList_strategy;

import java.util.ArrayList;


public class Movie_Context {
  private Movie_Strategy movie_strategy;
  
  public Movie_Context(Movie_Strategy movie_strategy){
      this.movie_strategy = movie_strategy;
  }

  public void show(){
      movie_strategy.showInfo();
  }
  
  //public void 
}
