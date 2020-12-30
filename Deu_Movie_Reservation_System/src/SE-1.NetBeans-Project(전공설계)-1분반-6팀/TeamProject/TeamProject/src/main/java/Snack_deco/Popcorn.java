
package Snack_deco;

public abstract class Popcorn {
  String description = "no title";
  
  public Popcorn() {
  }

  public abstract int cost() ;

  public String getDescription() {
      return description;
  }

}
