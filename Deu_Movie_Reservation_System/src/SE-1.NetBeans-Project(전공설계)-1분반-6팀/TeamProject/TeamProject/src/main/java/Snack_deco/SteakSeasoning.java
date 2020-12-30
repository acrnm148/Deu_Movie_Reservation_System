
package Snack_deco;

public class SteakSeasoning extends CondimentDecorater {
  
    private Popcorn popcorn;
    private int count;
    
    public SteakSeasoning(Popcorn popcorn) {
        this.popcorn = popcorn;
        
  }
    
    public String getDescription() {
        return popcorn.getDescription() + " + SteakSeasoning";
  }

  public int cost() {
      return popcorn.cost() + 3500;
  }
}
