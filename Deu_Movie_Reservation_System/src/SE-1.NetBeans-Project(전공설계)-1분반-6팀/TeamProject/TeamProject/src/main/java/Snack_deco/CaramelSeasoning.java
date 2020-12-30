
package Snack_deco;

public class CaramelSeasoning extends CondimentDecorater {
    
        private Popcorn popcorn;
    
    public CaramelSeasoning(Popcorn popcorn) {
      this.popcorn = popcorn;
  }
    
    public String getDescription() {
      return popcorn.getDescription() + " + CaramelSeasoning";
  }

    public int cost() {
      return popcorn.cost() + 2000;
  }
}
