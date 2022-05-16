package Structural;

public class CompositeClient {
    public static void main(String[] args) {
        Player p1 = new Player("Tom");
        Player p2 = new Player("Max");
        Player p3 = new Player("Anna");
        Player p4 = new Player("Rich");
        TournamentComposite tournamentComposite = new TournamentComposite(p1, p4);
        TournamentLeaf leaf1 = new TournamentLeaf(p1, p2);
        TournamentLeaf leaf2 = new TournamentLeaf(p3, p4);
        tournamentComposite.setLeft(leaf1);
        tournamentComposite.setRight(leaf2);
        tournamentComposite.display();

    }
}

interface Tournament {
    public void display();
}

class Player {
    String name;

    Player(String name) {
        this.name = name;
    }
}

class TournamentComposite implements Tournament {
    Tournament left;
    Tournament right;
    Player p1;
    Player p2;

    TournamentComposite(Player p1, Player p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    public void setLeft(Tournament left) {
        this.left = left;
    }

    public void setRight(Tournament right) {
        this.right = right;
    }

    @Override
    public void display() {
        System.out.println("Player 1: " + p1.name);
        System.out.println("Player 2: " + p2.name);
        left.display();
        right.display();
    }
}

class TournamentLeaf implements Tournament {
    Player p1;
    Player p2;

    TournamentLeaf(Player p1, Player p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    @Override
    public void display() {
        System.out.println("Player 1: " + p1.name);
        System.out.println("Player 2: " + p2.name);
    }
}