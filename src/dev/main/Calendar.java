package dev.main;

public class Calendar {
	private int absolute_time_from_start_game;
	public Calendar(int seconds){
		absolute_time_from_start_game=seconds;
	}
	
	public static String show_datetime_in_game(int seconds){
		int days=seconds/(60*12);
		return ""+days+". dzieñ";
	}
}
