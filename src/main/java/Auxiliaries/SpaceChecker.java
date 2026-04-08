package Auxiliaries;

public class SpaceChecker {
	public static boolean check(String s){
		int x = s.length() - (s.replace(" ", "").length());
		return x != 3 ;
	}

}
