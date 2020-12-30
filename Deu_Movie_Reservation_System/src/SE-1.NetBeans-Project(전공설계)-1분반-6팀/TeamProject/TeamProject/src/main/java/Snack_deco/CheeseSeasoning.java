
package Snack_deco;

public class CheeseSeasoning extends CondimentDecorater {
    
    private Popcorn popcorn;
    
  public CheeseSeasoning(Popcorn popcorn) {
      this.popcorn = popcorn;
  }
  
  public String getDescription() {
      return popcorn.getDescription() + " + CheeseSeasoning";
  }

  public int cost() {
      return popcorn.cost() + 2500;
  }

}
