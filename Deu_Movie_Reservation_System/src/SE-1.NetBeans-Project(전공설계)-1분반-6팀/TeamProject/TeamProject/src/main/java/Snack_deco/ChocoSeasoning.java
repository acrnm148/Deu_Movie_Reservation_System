
package Snack_deco;

public class ChocoSeasoning extends CondimentDecorater {
    private Popcorn popcorn;
    
  public ChocoSeasoning(Popcorn popcorn) {
      this.popcorn = popcorn;
  }
    
  public String getDescription() {
      return popcorn.getDescription() + " + ChocoSeasoning";
  }

  public int cost() {
      return popcorn.cost() + 3000;
  }

}
