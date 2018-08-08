package edu.bu.met.cs665.entity;

/**
 * This class represents a New Game
 * 
 * @author Sahad Osman
 *
 */
public class NewGame implements Game{

	//build the singleton pattern
	private NewGame () {
		
	}
	
    private static class SingletonHolder {
        private static final NewGame INSTANCE = new NewGame();
    }

	public static NewGame getInstance() {
		 return SingletonHolder.INSTANCE;
	}
	
	@Override
	public void startGame() {
		
	
		gameRules();
		GamePlayer player1 = new Player(1);
		player1.intiBoard();
		GamePlayer player2 = new Player(2);
		player2.intiBoard();
		getAwinner(player1,player2);
		player1.playGame();
		player2.playGame();
		
		
	}

	private void gameRules() {
		System.out.println("+++++++++++++++++++ Battleship GAME RULES ++++++++++++++++++");
		System.out.println("+++  There are two player                                +++");
		System.out.println("+++  There are Three ships with one location each        +++");
		System.out.println("+++  The ships are placed in 5*5 grid randomly           +++");
		System.out.println("+++  Each player has a turn to gess a ship location      +++");
		System.out.println("+++  The player who shoots three ships firt WIN the game +++");
		System.out.println("++++++++++++++++++++ GAME STARTED HAVE fUN +++++++++++++++++");
		System.out.println();
		
	}

	@Override
	public void getAwinner(GamePlayer player1, GamePlayer player2) {
		//play if no one win
		while(!(player1.playerWin(player1.board) ||
				player2.playerWin(player2.board))) {
			//player one turn
			player1.playGame();
			
			//check if player 1 win
			if (player1.playerWin(player1.board)== true) {
				System.out.println("-------- Player 1 WIN ----------");
				break;
			}
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

	@Override
	public void GameEnd() {
		
		System.out.println("---------- Game over ------------");
		
	}


}
