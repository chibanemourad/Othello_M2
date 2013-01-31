package jeu;

import java.io.*;

public class Othello2 {
	static final int dim = 10;
	private int[][] othello = new int[dim][dim];
	private final int[][] positions = { { 0, 1 }, { 1, 1 }, { 1, 0 },
			{ 1, -1 }, { 0, -1 }, { -1, -1 }, { -1, 0 }, { -1, 1 } };
	private final int case_vide = 0;
	private final int case_bord = -1;
	public final int pion_blanc = 1;
	public final int pion_noir = 2;

	public Othello2() {
		int i = 0; // position horizontale
		int j = 0; // position verticale
		for (i = 0; i < dim; i++) { // les bords
			othello[i][0] = case_bord;
			othello[i][dim - 1] = case_bord;
			othello[0][i] = case_bord;
			othello[dim - 1][i] = case_bord;
		}
		for (j = 1; j < dim - 1; j++) { // intérieur vide
			for (i = 1; i < dim - 1; i++) {
				othello[i][j] = case_vide;
			}
		}
		othello[4][5] = pion_blanc;
		othello[5][4] = pion_blanc;
		othello[6][4] = pion_blanc;
		othello[4][4] = pion_noir;
		othello[5][5] = pion_noir;
	}

	public void dessine() {
		int i = 1; // position horizontale
		int j = 1; // position verticale
		System.out.println(" 12345678");
		for (j = 1; j < dim - 1; j++) {
			System.out.print(j);
			for (i = 1; i < dim - 1; i++) {
				switch (othello[i][j]) {
				case pion_noir:
					System.out.print("N");
					break;
				case pion_blanc:
					System.out.print("B");
					break;
				default:
					System.out.print(" ");
					break;
				}
			}
			System.out.println();
		}
	}

	public boolean jouable(int pion, int posx, int posy) {
		if (othello[posx][posy] != case_vide)
			return false;
		int pion_inverse = pion_blanc;
		if (pion == pion_blanc)
			pion_inverse = pion_noir;
		int mult = 2;
		int piont;
		for (int dir = 0; dir < 8; dir++) {
			if (othello[posx + positions[dir][0]][posy + positions[dir][1]] == pion_inverse) {
				for (;;) {
					piont = othello[posx + (mult * positions[dir][0])][posy
							+ (mult * positions[dir][1])];
					if (piont == pion)
						return true;
					if (piont != pion_inverse)
						break;
					mult++;
				}
			}
		}
		return false;
	}

	public static void main(String[] args) {
		Othello2 monjeu = new Othello2();
		int x = 0;
		int y = 0;
		boolean resultat = true;
		for (;;) {
			monjeu.dessine();
			System.out.print("Noir joue en x: ");
			try {
				BufferedReader stdin = new BufferedReader(
						new InputStreamReader(System.in));
				x = Integer.parseInt(stdin.readLine());
				if (x == 0)
					break;
				System.out.print("y: ");
				y = Integer.parseInt(stdin.readLine());
				resultat = monjeu.jouable(monjeu.pion_noir, x, y);
			} catch (IOException ioe) {
				System.err.println(ioe);
			}
			System.out.println("Jouable en " + x + ":" + y + " = " + resultat);
			;
		}
		
	}
}
