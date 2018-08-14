package edu.bu.met.cs665.entity;

/**
 *  This is an interface is for Game process
 *  build the factory method pattern
 * 
 * @author Shahd Osman
 *
 */
public interface Game {

	/**
	 * this method used to start the game
	 */
	void startGame();

	// Refactoring : change the implementation of play method to getAwinner method
	/**
	 * this method include the play process
	 * 
	 * @param player1
	 * @param player2
	 */
	void getAwinner(GamePlayer player1, GamePlayer player2);
	
	/**
	 * the method called when the game end
	 */
	void GameEnd();
}
