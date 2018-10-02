package com.dylanscode.main;

public class GameState
{
	protected static State state;

	protected static enum State
	{
		MENU, CONNECT, SERVER_START, INSTRUCTIONS, LICENSE, GAME, END
	}

	protected static State getState()
	{
		return state;
	}

	protected static void setState(State _state)
	{
		state = _state;
	}
}
