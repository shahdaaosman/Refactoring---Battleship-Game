package edu.bu.met.cs665;

import edu.bu.met.cs665.entity.Game;
import edu.bu.met.cs665.entity.NewGame;

public class Main {

  /**
   * A main method to run examples. 
   * @param args not used 
   */
  public static void main(String[] args) {

	  //Create a single game object
		Game game = NewGame.getInstance();
		game.startGame();

}
}
