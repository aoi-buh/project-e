package com.example;

public class Main {
	
	public static void main(String[] args)
	{	
		GameLoop loop = new GameLoop(10, 10);
		System.out.println(loop.worldToString());
	}

}
