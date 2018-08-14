package edu.bu.met.cs665.entity;

/**
 * This class represents a New Game
 * 
 * @author Sahad Osman
 *
 */
public class NewGame implements Game{

	/**
	 * build the singleton pattern
	 */
	private NewGame () {
		
	}
	
    /**
     * 
     * this class represent the Singleton holder
     *
     */
    private static class SingletonHolder {
        private static final NewGame INSTANCE = new NewGame();
    }

	/**
	 * this return the game object
	 * @return
	 */
	public static NewGame getInstance() {
		 return SingletonHolder.INSTANCE;
	}
	
	/**
	 * this method used to start the game
	 */
	@Override
	public void startGame() {
		
		
		gameRules();
		
		//Refactoring : add Gameplayer super class for player to extend player type
		GamePlayer player1 = new HumanPlayer(1);
		player1.intiBoard();
		GamePlayer player2 = new ComputerPlayer(2);
		player2.intiBoard();
		getAwinner(player1,player2);
		player1.playGame();
		player2.playGame();
		
		
	}

	/**
	 * this method display the game rules
	 */
	private void gameRules() {
		System.out.println("+++++++++++++++++++ Battleship GAME RULES ++++++++++++++++++");
		System.out.println("+++  There are two player                                +++");
		System.out.println("+++  There are Three ships with one location each        +++");
		System.out.println("+++  The ships are placed in 5*5 grid randomly           +++");
		System.out.println("+++  Each player has a turn to guess a ship location      +++");
		System.out.println("+++  The player who shoots three ships firt WIN the game +++");
		System.out.println("++++++++++++++++++++ GAME STARTED HAVE fUN +++++++++++++++++");
		System.out.println();
		
	}

	/**
	 * this method include the play process
	 */
	@Override
	public void getAwinner(GamePlayer player1, GamePlayer player2) {
		//play if no one win
		while(!(player1.playerWin(player1.board) ||
				player2.playerWin(player2.board))) {
			
			
			/* Refactoring : Extract method by include all playing steps in playGame 
			method and remove duplicated code */
			 
			//player one turn
			player1.playGame();
			
			//check if player 1 win
			if (player1.playerWin(player1.board)== true) {
				System.out.println("-------- Player 1 WIN ----------");
				break;
			}
			//Refactoring: Encapsulate a set of attributes and methods of a class
			
			//Refactoring : Extract method by include all playing steps in playGame method
			// player 2 turn 
			player2.playGame();

			//check if player 1 win
			if (player2.playerWin(player2.board)== true) {
				System.out.println("-------- Player 2 WIN ----------");
				break;
			}
		}
		GameEnd();
	}

	/**
	 * the method called when the game end
	 */
	@Override
	public void GameEnd() {
		
		System.out.println("---------- Game over ------------");
		
	}


}
