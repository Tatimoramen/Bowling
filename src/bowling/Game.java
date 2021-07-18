package bowling;

import static org.junit.Assert.*;
import org.junit.Test;

public class Game {

	private int[] frame = new int[21];
	private int shot = 0;
	private int score = 0;

	public void playGame(int[] rolls) {
        for (int pins : rolls) {
            roll(pins);
        
        }
    }

	public void roll(int pins) {
		frame[shot++] = pins;
	}
	

	public int score() {
		int total = 0;
		int jugadaIndex = 0;
		for (int jugada = 0; jugada < 10; jugada++) {
			if (frame[jugadaIndex] == 10) {
				// Es Strike, entonces bonus
				total += 10 + frame[jugadaIndex + 1] + frame[jugadaIndex + 2];
				jugadaIndex++;
			} else {
				if (frame[jugadaIndex] + frame[jugadaIndex + 1] == 10)// SPARE
				{
					total += 10 + frame[jugadaIndex + 2];
				} else {
					total += frame[jugadaIndex] + frame[jugadaIndex + 1];
				}
				jugadaIndex += 2;
			}
		}
		return total;

	}

}