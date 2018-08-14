package edu.bu.met.cs665.entity;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * This class represents a Game Player
 * 
 * @author Sahad Osman
 *
 */
public abstract class GamePlayer {

	//Refactoring: build Template pattern to let each game player follow game steps
	/**
	 * this method used by the player to start playing in the Game
	 */
	void playGame(){
		
		getaPlayer();
		board.DisplyBord();
		playerRound();
		showResult();
		board.DisplyBord();
		
	}

	
	/**
	 * the method display who is the player
	 */
	private void getaPlayer() {
		System.out.println("////////////////////////////////////////////////");
		System.out.println("************* Player "+id+" bord **************");
		
	}


	//Refactoring : move intiBoard() form Board.java to GamePlayer.java class
	/**
	 * this method used to intilize player board
	 */
	public void intiBoard() {
		Board board = new Board();
		this.board= board;
	}

	/**
	 * this method used to print the new Result header
	 */
	private void showResult() {
		
		System.out.println();
		System.out.println("************* Your Updated bord **************");
		System.out.println();
		
	}

	protected int id;
	protected Board board;
	protected static int[] shoot;

	/**
	 * The player constructor
	 * 
	 * @param playerId
	 */
	public GamePlayer(int playerId) {
		this.id = playerId;
		HumanPlayer.shoot = new int[2];
		
		
	}


	/**
	 * Getter method for player Id
	 * @return player Id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Setter method for id
	 * 
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}



	/**
	 * Getter method for Board class
	 * @return board
	 */
	public Board getBoard() {
		return board;
	}

	/**
	 * Setter method for board
	 * 
	 * @param board
	 */
	public void setBoard(Board board) {
		this.board = board;
	}


	/**
	 * Getter method for shooting
	 * 
	 * @return shoot array
	 */
	public static int[] getShoot() {
		return shoot;
	}

	/**
	 * Setter method for shoot
	 * 
	 * @param shoot
	 */
	public void setShoot(int[] shoot) {
		this.shoot = shoot;
	}

	/**
	 * this method used to get the user value to shoot the a ship
	 * 
	 * @param shoot
	 */
	public abstract void shoot(int[] shoot);
	/*public static void shoot(int[] shoot){
        
		while(true) {
		// If the user enter a non integer number it throw an exception
        try {
			Scanner input = new Scanner(System.in);
			
			System.out.print("Enter row number from (1 - 5): ");
			shoot[0] = input.nextInt();
			// array index start with zero the real value is less by 1
			shoot[0]--;
			
			System.out.print("Enter column number from (1 - 5): ");
			shoot[1] = input.nextInt();
			// array index start with zero the real value is less by 1
			shoot[1]--;
			
        }
			catch (InputMismatchException exception) {
			System.out.println("Integers only, please!"); 
			 continue;
		}
        break;
        
		}  
    }*/
	
	/**
	 * this method check if the shoot hit the ship 
	 * @param shoot
	 * @param board
	 * @return
	 */
    public static boolean hit(int[] shoot, Board board){
    
        for(int ship=0 ; ship<board.getShips().length ; ship++){
        	
            if( shoot[0]==board.getShips()[ship][0] &&
            		shoot[1]==board.getShips()[ship][1]){
                System.out.print("You hit a ship ");
                int currentScore = board.getScore();
                currentScore++;
                board.setScore(currentScore);
                return true;
            }
          
        } 
        System.out.println("You miss a ship");
        return false;
    }
      
    /**
     * see if a player win 
     * @param board
     * @return
     */
    public boolean playerWin(Board board) {
        	if(board.getScore() == 3) {
        	return true;
        	} else {
            return false;
        }    
    }
	
    /**
     * each player get a round to guess
     */
    private void playerRound() {
    	System.out.println("Player "+id+" turn :");
    	while(true){
		shoot(shoot);
		if (checkShoot(shoot,board)== true) {
			break;
		}
		}
		updateboard(shoot,board);
    }	
	
    /**
     * check if this shoot was played
     * 
     * @param shoot
     * @param board
     * @return
     */
    private boolean checkShoot(int[] shoot, Board board) {
    	
    	 try {
			if( board.getBoard()[shoot[0]][shoot[1]]== -1){
			     return true;
			 }else {
				 System.out.println("You already shoot this location"
				 		+ " , try again!");
				 return false;
				 
			 }
		}
    	 
    	catch (ArrayIndexOutOfBoundsException exception) {
				// Output expected ArrayIndexOutOfBoundsException.
				System.out.println("Enter number between 1 - 5, please!");
				 return false;
    		}	
  
		
	}

    /**
     * this method see if a shoot hit or miss the ship
     * then update the player board
     * @param shoot
     * @param board
     */
    private static void updateboard(int[] shoot, Board board){
    	int[][] theBoard =board.getBoard();
        if(hit(shoot,board))
        	 theBoard[shoot[0]][shoot[1]]=1;
        else
        	 theBoard[shoot[0]][shoot[1]]=0;
        board.setBoard(theBoard); 
    	
    }
	
}
