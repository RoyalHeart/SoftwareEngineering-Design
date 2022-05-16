public class Tournament {
    public static void main(String[] args) throws Exception {
        Player player1 = new Player("player1");
        Player player2 = new Player("player2");
        Player player3 = new Player("player3");
        Player player4 = new Player("player4");
        Player player5 = new Player("player5");
        Player player6 = new Player("player6");
        Player player7 = new Player("player7");
        Player player8 = new Player("player8");

        TournamentInterface game1 = new Game(player1, player2, 2, 4);
        TournamentInterface game2 = new Game(player3, player4, 1, 3);
        TournamentInterface game3 = new Game(player5, player6, 0, 5);
        TournamentInterface game4 = new Game(player7, player8, 6, 2);

        TournamentInterface gameBranch1 = new GameBranch(game1, game2, 0, 1);
        TournamentInterface gameBranch2 = new GameBranch(game3, game4, 2, 0);
        TournamentInterface gameBranch3 = new GameBranch(gameBranch1, gameBranch2, 3, 2);

        TournamentInterface tournament = gameBranch3;
        tournament.displayAllPlayer();
    }
}

class Player {
    String name;

    public Player(String name) {
        this.name = name;
    }
}

class Game implements TournamentInterface {
    private Player player1;
    private Player player2;
    private int point1;
    private int point2;

    public Game(Player player1, Player player2, int point1, int point2) {
        this.player1 = player1;
        this.player2 = player2;
        this.point1 = point1;
        this.point2 = point2;
    }

    public void showWinner() {
        if (point1 > point2) {
            System.out.println(player1.name + " is winner");
        } else
            System.out.println(player2.name + " is winner");
    }

    public Player getWinner() {
        if (point1 > point2) {
            return player1;
        } else
            return player2;
    }

    public void displayAllPlayer() {
        System.out.println(player1.name + " " + point1);
        System.out.println(player2.name + " " + point2);
    }
}

class GameBranch implements TournamentInterface {
    private TournamentInterface tournament1;
    private TournamentInterface tournament2;
    private Player player1;
    private Player player2;
    private int point1;
    private int point2;

    public Player getWinner() {
        if (point1 > point2) {
            return player1;
        } else
            return player2;
    }

    public GameBranch(TournamentInterface game1, TournamentInterface game2, int point1, int point2) {
        this.tournament1 = game1;
        this.tournament2 = game2;
        this.point1 = point1;
        this.point2 = point2;
        player1 = game1.getWinner();
        player2 = game2.getWinner();
    }

    public void displayAllPlayer() {
        System.out.println(player1.name + " " + point1);
        System.out.println(player2.name + " " + point2);
        tournament1.displayAllPlayer();
        tournament2.displayAllPlayer();
    }

}

interface TournamentInterface {
    public void displayAllPlayer();

    public Player getWinner();
}
