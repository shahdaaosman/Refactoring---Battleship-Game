package edu.bu.met.cs665.entity;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * This class represents on type of a game player 
 * there can be a different type of player
 * Human player .. computer player .. etc
 * 
 * @author Sahad Osman
 *
 */
public class HumanPlayer extends GamePlayer{
	//Refactoring : rename Player class to HumanPlayer
	
	/**
	 * the player constructor
	 * 
	 * @param playerId
	 */
	public HumanPlayer(int playerId) {
		super(playerId);
		
	}

	//Refactoring: each game player have different shoot method
	@Override
	public void shoot(int[] shoot) {
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
		
	}
	
	

}