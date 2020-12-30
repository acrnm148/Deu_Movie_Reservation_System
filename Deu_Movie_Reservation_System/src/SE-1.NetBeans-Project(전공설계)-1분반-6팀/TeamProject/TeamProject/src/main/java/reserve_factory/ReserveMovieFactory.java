
package reserve_factory;
//concreteCreator

public class ReserveMovieFactory extends MovieFactory {

   //@Override
    public Movie reserveMovie(String name) {
        if(name.equals("1")) return new Theater1Movie1();
        else if(name.equals("2")) return new Theater1Movie2();
        else if(name.equals("3")) return new Theater1Movie3();
        else if(name.equals("4")) return new Theater2Movie1();
        else if(name.equals("5")) return new Theater2Movie2();
        else if(name.equals("6")) return new Theater2Movie3();
        
        else return null;
    }

}
