package jeu;
import java.io.*;
public class Othello_1 {

	/**
	 * @param args
	 */
	static final int dim = 10;
	int[][] othello = new int[dim][dim];

	public Othello_1() {
		int i = 0; // position Horizontale
		int j = 0; // position Verticale
		/*cases des bord à -1 pour vérifier si le déplacement est permis ou non */
		for (i = 0; i < dim; i++) {
			othello[i][0] = -1;
			othello[i][dim - 1] = -1;
			othello[0][i] = -1;
			othello[dim - 1][i] = -1;
		}
		/*case interieur du plateau initier à 0 pour dire que c'est vide*/
		for (j = 1; j < dim - 1; j++) {
			for (i = 1; i < dim - 1; i++) {
				othello[i][j] = 0;
			}
		}
		
		/*initialisation des pions avant le début de la partie */
		othello[4][5]=1;//1 pour pion noir joueur 1;
		othello[5][4]=1;
		othello[4][4]=2;
		othello[5][5]=2;
		
//		for (j = 0; j < dim; j++) {
//			System.out.println("");
//			for (i = 0; i < dim; i++) {
//				System.out.print(othello[i][j] = 0);
//			}
//		}
	}
	public void test_1(){
		int i=0;//position horizontale 
		int j=0;//position verticale 
		for (j = 0; j < dim; j++) {
			for (i = 0; i < dim; i++) {
				if (othello[j][i]>=0) System.out.print(" ");
				System.out.print(othello[j][i]);
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Othello_1 jouer = new Othello_1();
		jouer.test_1();
	}

}
