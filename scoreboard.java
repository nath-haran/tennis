public class scoreboard {
	Score playerA, playerB;

	public void updateWin(String player) {
		if (playerA.getSet() > playerB.getSet() && playerA.getSet() == 2)
			System.out.println("A Wins");
		else if (playerA.getSet() < playerB.getSet() && playerB.getSet() == 2)
			System.out.println("B Wins");

	}

	public void updateSet(String player) {
		int oldSet, newSet;
		if (player == "A") {
			oldSet = playerA.getGame();
			if ((playerA.getGame() == 6 && playerB.getGame() < 5)
					|| (playerA.getGame() > 6 && (playerA.getGame() - playerB.getGame() == 2))) {
				newSet = oldSet + 1;
				playerA.setSet(newSet);
			}

		} else {
			oldSet = playerB.getGame();
			if ((playerB.getGame() == 6 && playerA.getGame() < 5)
					|| (playerB.getGame() > 6 && (playerB.getGame() - playerA.getGame() == 2))) {
				newSet = oldSet + 1;
				playerB.setSet(newSet);
			}

		}
		playerB.setGame(0);
		playerA.setGame(0);
	}

	public void updateGames(String player) {
		int oldGames, newGames;
		if (player == "A") {
			oldGames = playerA.getGame();
			if ((playerA.getPoint() == 40 && playerB.getPoint() < 40)
					|| (playerA.getPoint() - playerB.getPoint() == 20)) {
				newGames = oldGames + 1;
				playerA.setGame(newGames);
			}

		} else {
			oldGames = playerB.getGame();
			if ((playerB.getPoint() == 40 && playerA.getPoint() < 40)
					|| (playerB.getPoint() - playerA.getPoint() == 20)) {
				newGames = oldGames + 1;
				playerB.setGame(newGames);
			}

		}
		playerB.setPoint(0);
		playerA.setPoint(0);
	}

	public void updatePoints(String player) {
		int oldPoints, newPoints;
		if (player == "A") {
			oldPoints = playerA.getPoint();
			if (oldPoints < 30) {
				newPoints = oldPoints + 15;
			} else {
				newPoints = oldPoints + 10;
			}
			playerA.setPoint(newPoints);
		} else

		{
			oldPoints = playerB.getPoint();
			if (oldPoints < 30) {
				newPoints = oldPoints + 15;
			} else {
				newPoints = oldPoints + 10;
			}
			playerB.setPoint(newPoints);
		}

	}

}