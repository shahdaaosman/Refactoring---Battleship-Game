package edu.bu.met.cs665.entity;

import java.util.Random;

/**
 * This class represents 
 * 
 * @author Sahad Osman
 *
 */
public class Board {

	protected int bordId;
	protected int[][] board;
	protected int[][] ships;
	protected int score;
	

	public Board() {
		//this.bordId = bordId;
		this.board = new int[5][5];
		this.ships = new int [3][2];
		this.score=0;
		intializbord(board);
		setShipsRandomly(ships);
	}

	public void intializbord(int[][] board) {
		for (int row = 0; row < 5; row++)
			for (int column = 0; column < 5; column++)
				board[row][column] = -1;
        
	}

	public void DisplyBord() {
		
		
		System.out.println();
		System.out.println("\t1 \t2 \t3 \t4 \t5");
		System.out.println();

		  for(int row=0 ; row < 5 ; row++ ){
	            System.out.print((row+1)+"");
	            for(int column=0 ; column < 5 ; column++ ){
	                if(board[row][column]==-1){
	                    System.out.print("\t"+"~");
	                }else if(board[row][column]==0){
	                    System.out.print("\t"+"*");
	                }else if(board[row][column]==1){
	                    System.out.print("\t"+"X");
	                }
	                
	            }
	            System.out.println();
	        }
		


	}

	public void setShipsRandomly(int [][] ships) {
		 Random random = new Random();
	       //create random ships location 
	        for(int ship=0 ; ship < 3 ; ship++){
	            ships[ship][0]=random.nextInt(5);
	            ships[ship][1]=random.nextInt(5);
	        
	        
	            //let's check if that shot was already tried 
	            //if it was, just finish the do...while when a new pair was randomly selected
	            for(int last=0 ; last < ship ; last++){
	                if( (ships[ship][0] == ships[last][0])&&(ships[ship][1] == ships[last][1]) )
	                    do{
	                        ships[ship][0]=random.nextInt(5);
	                        ships[ship][1]=random.nextInt(5);
	                    }while( (ships[ship][0] == ships[last][0])&&(ships[ship][1] == ships[last][1]) );
	            }
	        }
	        }



	public int[][] getBoard() {
		return board;
	}

	public void setBoard(int[][] board) {
		this.board = board;
	}

	public int[][] getShips() {
		return ships;
	}

	public void setShips(int[][] ships) {
		this.ships = ships;
	}

	public int getBordId() {
		return bordId;
	}

	public void setBordId(int bordId) {
		this.bordId = bordId;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
		
	
	}


