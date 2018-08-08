package edu.bu.met.cs665.entity;

import java.util.Scanner;

/**
 * This class represents 
 * 
 * @author Sahad Osman
 *
 */
public abstract class GamePlayer {

	void playGame(){
		
		getaPlayer();
		board.DisplyBord();
		playerRound();
		showResult();
		board.DisplyBord();
		
	}


	private void getaPlayer() {
		System.out.println("////////////////////////////////////////////////");
		System.out.println("************* Player "+id+" bord **************");
		
	}



	public void intiBoard() {
		Board board = new Board();
		this.board= board;
	}

	private void showResult() {
		
		System.out.println("************* Your Updated bord **************");
		System.out.println();
		
	}

	protected int id;
	protected Board board;
	protected static int[] shoot;

	
	public GamePlayer(int playerId) {
		this.id = playerId;
		Player.shoot = new int[2];
		
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}



	public Board getBoard() {
		return board;
	}

	public void setBoard(Board board) {
		this.board = board;
	}


	public static int[] getShoot() {
		return shoot;
	}

	public void setShoot(int[] shoot) {
		this.shoot = shoot;
	}


	public static void shoot(int[] shoot){
		
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter row number from (1 - 5): ");
        shoot[0] = input.nextInt();
        shoot[0]--;
        
        System.out.print("Enter column number from (1 - 5): ");
        shoot[1] = input.nextInt();
        shoot[1]--;
        

        
    }
	
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
        
    public boolean playerWin(Board board) {
        	if(board.getScore() == 3) {
        	return true;
        	} else {
            return false;
        }    
    }
	
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
	
    private boolean checkShoot(int[] shoot, Board board) {
    	 if( board.getBoard()[shoot[0]][shoot[1]]== -1){
             return true;
         }else {
        	 System.out.println("You already shoot this location"
        	 		+ " , try again!");
        	 return false;
        	 
         }
		
	}

	public static void updateboard(int[] shoot, Board board){
    	int[][] theBoard =board.getBoard();
        if(hit(shoot,board))
        	 theBoard[shoot[0]][shoot[1]]=1;
        else
        	 theBoard[shoot[0]][shoot[1]]=0;
        board.setBoard(theBoard); 
    	
    }
	
}
