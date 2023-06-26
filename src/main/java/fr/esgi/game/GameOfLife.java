package fr.esgi.game;


import java.lang.reflect.Array;
import java.util.Arrays;

public class GameOfLife {
    private final int taille;
    private final boolean[][] grille;
    private final boolean[][] grilleSuivante;

    public GameOfLife(int taille) {
        this.taille = taille;
        this.grille = new boolean[taille][taille];
        this.grilleSuivante = new boolean[taille][taille];
    }

    public boolean[][] initialiser(String gridState) {
        String[] lignes = gridState.split("\n");
        for (int i = 0; i < lignes.length; i++) {
            String ligne = lignes[i];
            for (int j = 0; j < ligne.length(); j++) {
                grille[i][j] = ligne.charAt(j) == 'O';
            }
        }
        return grille;
    }

    public boolean[][] afficherGrille() {
        for (int i = 0; i < taille; i++) {
            for (int j = 0; j < taille; j++) {
                System.out.print(grille[i][j] ? "O " : ". ");
            }
            System.out.println();
        }
        System.out.println();
        return grille;
    }

    public boolean[][] faireUneIteration() {
        for (int i = 0; i < taille; i++) {
            for (int j = 0; j < taille; j++) {
                int voisinsVivants = compterVoisinsVivants(i, j);

                if (grille[i][j]) {
                    grilleSuivante[i][j] = voisinsVivants >= 2 && voisinsVivants <= 3;
                } else {
                    grilleSuivante[i][j] = voisinsVivants == 3;
                }
            }
        }
        for (int i = 0; i < taille; i++) {
            grille[i] = Arrays.copyOf(grilleSuivante[i], taille);
        }
        return grille;
    }

    private int compterVoisinsVivants(int x, int y) {
        int count = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                int voisinX = x + i;
                int voisinY = y + j;
                if (voisinX >= 0 && voisinX < taille && voisinY >= 0 && voisinY < taille && grille[voisinX][voisinY]) {
                    count++;
                }
            }
        }
        if (grille[x][y]) {
            count--;
        }
        return count;
    }
}

