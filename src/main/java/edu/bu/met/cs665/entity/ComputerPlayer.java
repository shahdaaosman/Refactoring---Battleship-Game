package edu.bu.met.cs665.entity;

import java.util.Random;

public class ComputerPlayer  extends GamePlayer{

	public ComputerPlayer(int playerId) {
		super(playerId);
		// TODO Auto-generated constructor stub
	}

	//Refactoring: each game player have different shoot method
	@Override
	public void shoot(int[] shoot) {
		 Random random = new Random();
	       //create random ships location 
		 shoot[0]=random.nextInt(5);
		 shoot[1]=random.nextInt(5);
		
	}

}
