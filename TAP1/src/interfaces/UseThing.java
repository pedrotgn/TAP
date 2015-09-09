package interfaces;

public class UseThing {

	public static void main(String[] args) {
		Thing c = new Thing();
		sing(c);
		dance(c);

		Musician music;
		Bop dance;

		music = c;
		dance = c;

		System.out.println(music.sing());
		System.out.println(dance.dance());

		music = (Musician) dance;
		System.out.println(music.sing());
	}

	public static void sing(Musician m) {
		System.out.println(m.sing());
	}

	public static void dance(Bop b) {
		System.out.println(b.dance());
	}

}
