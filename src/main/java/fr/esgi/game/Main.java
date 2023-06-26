package fr.esgi.game;

public class Main {
    public static void main(String[] args) {
        int iteration = 10;
        GameOfLife gameOfLife = new GameOfLife(3);
        String grid = """
                ...
                O.O
                .O.
                """.stripIndent();
        gameOfLife.initialiser(grid);
        gameOfLife.afficherGrille();
        gameOfLife.faireUneIteration();
        gameOfLife.afficherGrille();
    }
}
