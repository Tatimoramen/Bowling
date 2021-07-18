package bowling;

public class Main {
	public static void main(String[] args) {
		Game game = new Game();
		game.roll(10);
		game.roll(3);
		game.roll(4);
		System.out.print(game.score());
	}

}
