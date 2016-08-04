public class scoreboard {
	Score playerA, playerB;
	
	public scoreboard() {
		playerA = new Score();
		playerB = new Score();
	}

	public void updateWin(String player) {
		if (playerA.getSet() > playerB.getSet() && playerA.getSet() == 2)
			System.out.println("A Wins");
		else if (playerA.getSet() < playerB.getSet() && playerB.getSet() == 2)
			System.out.println("B Wins");

	}

	public void updateSet(String player) {
		int oldSet, newSet;
		if (player.compareTo("A")==0) {
			oldSet = playerA.getSet();
			if ((playerA.getGame() == 6 && playerB.getGame() < 5)
					|| (playerA.getGame() > 6 && (playerA.getGame() - playerB.getGame() >= 2))) {
				newSet = oldSet + 1;
				playerA.setSet(newSet);
				playerB.setGame(0);
				playerA.setGame(0);
			}

		} else {
			oldSet = playerB.getSet();
			if ((playerB.getGame() == 6 && playerA.getGame() < 5)
					|| (playerB.getGame() > 6 && (playerB.getGame() - playerA.getGame() >= 2))) {
				newSet = oldSet + 1;
				playerB.setSet(newSet);
				playerB.setGame(0);
				playerA.setGame(0);
			}

		}
		
	}
	

	public void updateGames(String player) {
		int oldGames, newGames;
		if (player.compareTo("A")==0) {
			oldGames = playerA.getGame();
			if ((playerA.getPoint() >= 50)
					&& (playerA.getPoint() - playerB.getPoint() >= 20)) {
				newGames = oldGames + 1;
				playerA.setGame(newGames);
				playerB.setPoint(0);
				playerA.setPoint(0);
				updateSet("A");
			}

		} else {
			oldGames = playerB.getGame();
			if ((playerB.getPoint() >= 50 )
					&& (playerB.getPoint() - playerA.getPoint() >= 20)) {
				newGames = oldGames + 1;
				playerB.setGame(newGames);
				playerB.setPoint(0);
				playerA.setPoint(0);
				updateSet("B");
			}

		}
		
	}

	public void updatePoints(String player) {
		int oldPoints, newPoints;
		if (player.compareTo("A")==0) {
			oldPoints = playerA.getPoint();
			if (oldPoints < 30) {
				newPoints = oldPoints + 15;
			} else {
				newPoints = oldPoints + 10;
			}
			playerA.setPoint(newPoints);
			updateGames("A");
		} else

		{
			oldPoints = playerB.getPoint();
			if (oldPoints < 30) {
				newPoints = oldPoints + 15;
			} else {
				newPoints = oldPoints + 10;
			}
			playerB.setPoint(newPoints);
			updateGames("B");
		}
		
	}
	
	public boolean isDeuce() {
		return (playerA.point == playerB.point && (playerA.point >= 40));
	}
	
	public int getAdvantage() {
		if (Math.abs(playerA.point - playerB.point) == 10 && ((playerA.point >= 40) && (playerB.point >= 40))) {
			if (playerA.point > playerB.point)
				return 1;
			else
				return 2;
		}
		return 0;
	}
	
	public String processPoints(String pts1, String pts2){
		if(isDeuce()){
			pts1 = "D";
			pts2 = "D";
		}
		int FLAG = 0;
		if((FLAG = getAdvantage())>0){
			if(FLAG == 1){
				pts1 = "A";
				pts2 = "-";
			}
			else if(FLAG == 2){
				pts1 = "-";
				pts2 = "A";
			}
		}
		return pts1+ " "+ pts2;
	}
	
	public void printScore() 
	{
		String pts1 = String.valueOf(playerA.point);
		String pts2 = String.valueOf(playerB.point);
		String points = processPoints(pts1, pts2);
		pts1 = points.split(" ")[0];
		pts2 = points.split(" ")[1];
		System.out.println("-----------------------");
		System.out.println("| Player|"+"SET"+"|GAME| PTS|");
		System.out.println("-----------------------");
		System.out.println("|   A   | "+ playerA.set + " |"+" "+playerA.game+"  |"+"  "+pts1+"|");
		System.out.println("-----------------------");
		System.out.println("|   B   | " + playerB.set + " |"+" "+playerB.game+"  |"+"  "+pts2+"|");
		System.out.println("-----------------------");
	}
	
	public void parse(String points) {
		for (char c : points.toCharArray()) {
			updatePoints(String.valueOf(c));
			printScore();
		}
	}
	
	public static void main(String[] args) {
		scoreboard sc = new scoreboard();
		sc.parse("AAABBBAA");
	}

}