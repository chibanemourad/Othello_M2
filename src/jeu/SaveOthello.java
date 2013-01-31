package jeu;

import java.io.*;

public class SaveOthello {
	private String fichier;
	private static final int dim = 10;
	private int[][] othello = new int[dim][dim];

	public SaveOthello(String fichier_de_savetage) {
		fichier = fichier_de_savetage;
		for (int j = 1; j < dim - 1; j++) { // intérieur vide
			for (int i = 1; i < dim - 1; i++) {
				othello[i][j] = 0;
			}
		}
		othello[4][5] = 1; // blanc
		othello[5][4] = 1; // blanc
		othello[4][4] = 2; // noir
		othello[5][5] = 2; // noir

	}

	public boolean save() {
		File outFile = new File(fichier);
		try {
			FileOutputStream out = new FileOutputStream(outFile);
			for (int j = 1; j < dim - 1; j++) {
				for (int i = 1; i < dim - 1; i++) {
					out.write(othello[i][j]);
				}
			}
			out.close();
		} catch (IOException e) {
			return false;
		}
		return true;
	}

	public static void main(String[] args) {
		SaveOthello mon_savetage = new SaveOthello("othello_partie_sauvegarde.bin");
		if (mon_savetage.save()) {
			System.out.println("savegarde effectué");
		} else {
			System.out.println("Erreur de sauvegarde");
		}
	}
}