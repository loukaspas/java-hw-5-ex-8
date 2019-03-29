import java.util.Scanner;

public class TTT {

	private Scanner player;
	private char[] board;
	private int numOfPlays;
	private char currentPlayer;
	
	public TTT(Scanner player) {
		this.board = new char[9];
		this.player = player;
		for (int i = 0; i < this.board.length; i++) {
			this.board[i] = (char) (i + '1');
		}
		this.numOfPlays = 0;
		this.currentPlayer = 'O';
	}
	
	public void display() {
		System.out.println();
		System.out.println("\t " + this.board[0] + " | " + this.board[1] + " | " + this.board[2]);
		System.out.println("\t---+---+---");
		System.out.println("\t " + this.board[3] + " | " + this.board[4] + " | " + this.board[5]);
		System.out.println("\t---+---+---");
		System.out.println("\t " + this.board[6] + " | " + this.board[7] + " | " + this.board[8]);
		System.out.println();
	}
	
	public void play() {
		int position;
		do {
			display();
			System.out.print(this.currentPlayer + ", choose position to play: ");
			position = this.player.nextInt();
		} while (position < 1 || position > 9 
				|| this.board[position - 1] == 'X'
				|| this.board[position - 1] == 'O');
		
		this.board[position - 1] = this.currentPlayer;
		this.numOfPlays++;
	}
	
	public void changeCurrentPlayer() {
		if (this.currentPlayer == 'X') {
			this.currentPlayer = 'O';
		} else {
			this.currentPlayer = 'X';
		}
	}
	
	public boolean checkWin() {
		if      (this.board[0] == 'X' && this.board[1]=='X' && this.board[2]=='X' || this.board[0] == 'O' && this.board[1]=='O' && this.board[2]=='O') { return true; }
		else if (this.board[3] == 'X' && this.board[4]=='X' && this.board[5]=='X' || this.board[3] == 'O' && this.board[4]=='O' && this.board[5]=='O') { return true; }
		else if (this.board[6] == 'X' && this.board[7]=='X' && this.board[8]=='X' || this.board[6] == 'O' && this.board[7]=='O' && this.board[8]=='O') { return true; }

		if      (this.board[0] == 'X' && this.board[3]=='X' && this.board[6]=='X' || this.board[0] == 'O' && this.board[3]=='O' && this.board[6]=='O') { return true; }
		else if (this.board[1] == 'X' && this.board[4]=='X' && this.board[7]=='X' || this.board[1] == 'O' && this.board[4]=='O' && this.board[7]=='O') { return true; }
		else if (this.board[2] == 'X' && this.board[5]=='X' && this.board[8]=='X' || this.board[2] == 'O' && this.board[5]=='O' && this.board[8]=='O') { return true; }

		if      (this.board[0] == 'X' && this.board[4]=='X' && this.board[8]=='X' || this.board[0] == 'O' && this.board[4]=='O' && this.board[8]=='O') { return true; }
		else if (this.board[2] == 'X' && this.board[4]=='X' && this.board[6]=='X' || this.board[2] == 'O' && this.board[4]=='O' && this.board[6]=='O') { return true; }
		
		return false;
	}
	
	public boolean checkTie() {
		return (this.numOfPlays == 9);
	}
	
	public static void main(String[] args) {

		Scanner player = new Scanner(System.in);
		TTT board = new TTT(player);
		
		System.out.println("Simple Tic Tac Toe game.");
		
		while (!board.checkWin() && !board.checkTie()) {
			board.changeCurrentPlayer();
			board.play();
		}
		
		board.display();
		if (board.checkWin()) {
			System.out.println("Congatulations " + board.currentPlayer + "! You win!");
		} else if (board.checkTie()) {
			System.out.println("It's a tie!");
		}
		
		board.player.close();
		
	}

}
