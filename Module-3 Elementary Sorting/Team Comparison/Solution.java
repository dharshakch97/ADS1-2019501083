class Solution{
	public Team[] sort(Team[] teams){
		// your code goes here
		for (int i = 0; i < teams.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < teams.length; j++) {
				/* Using compareTo method for comparing two team
				and arranging them in leaderboard by considering wins, losses, and draws*/
                if (teams[j].compareTo(teams[min]) == 1)
                    min = j;
                    // System.out.println(min);
            }
            // break;
            Team t = teams[min];
            teams[min] = teams[i];
            teams[i] = t;
        }
		return teams;
	}
}
class Team implements Comparable<Team> {
	String teamName;
	int noOfWins;
	int noOfLosses;
	int noOfDraws;
	Team(String name, int wins, int losses, int draws){
		teamName = name;
		noOfDraws = draws;
		noOfWins = wins;
		noOfLosses = losses;
	}

	public String toString(){
		//return all the attributes as a string but appending with ", "
		// return teamName + ", " + noOfWins + ", " + noOfLosses + ", " + noOfDraws;
		return "";
	}
	/**
	 * @param t Teams Compare teams based on no. of wins, losses, and draws
	 */
	public int compareTo(Team t) {
		if (this.noOfWins > t.noOfWins)
			return 1;
		else if (this.noOfWins < t.noOfWins)
			return -1;
		else {
			if (this.noOfLosses < t.noOfLosses)
				return 1;
			else if (this.noOfLosses > t.noOfLosses)
				return -1;
			else {
				if (this.noOfDraws > t.noOfDraws)
					return 1;
				else if (this.noOfDraws < t.noOfDraws)
					return -1;
			}
		}
		return 0;
	}
}