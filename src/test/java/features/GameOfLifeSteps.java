package features;

import fr.esgi.game.GameOfLife;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class GameOfLifeSteps {
    private GameOfLife game;
    private boolean[][] grid;

    @Given("a grid of size {int}")
    public void createGrid(int size) {
        game = new GameOfLife(size);
    }

    @Given("the grid is initialized with the following state:")
    public void initializeGrid(String gridState) {
        grid = game.initialiser(gridState);
    }

    @When("I perform an iteration")
    public void performIteration() {
        grid = game.faireUneIteration();
    }

    @Then("the grid would become:")
    public void assertGridUpdated(String expectedGridState) {
        boolean[][] expectedGrid = convertGridState(expectedGridState);
        Assert.assertArrayEquals(expectedGrid, grid);
    }

    private boolean[][] convertGridState(String gridState) {
        String[] lignes = gridState.stripIndent().split("\n");
        boolean[][] grille = new boolean[lignes.length][lignes.length];
        for (int i = 0; i < lignes.length; i++) {
            String ligne = lignes[i];
            for (int j = 0; j < ligne.length(); j++) {
                grille[i][j] = ligne.charAt(j) == 'O';
            }
        }
        return grille;
    }
}
