import java.util.*;

public class Main {
    public static void main(String[] args) {
        char[][] board = new char[3][3];
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                board[i][j]=' ';
            }
        }
        Scanner sc = new Scanner(System.in);
        char player = 'A';
        boolean gameover = false;
	int count=0;
	System.out.println("Enter position within the board only (0 0, 2 0, 1 2 etc..)");
        while (!gameover){
            ShowBoard(board);
		if(count==9){
				System.out.println("The game is a draw!");
				break;
			}
            System.out.println("Player "+player+" Enter Position:");
            int row,col;
            try {
                row = sc.nextInt();
                col = sc.nextInt();

                if (!(row >= 0 && row <= 2) || !(col >= 0 && col <= 2)) {
                    System.out.println("Invalid input re-enter position:");
                    continue;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input re-enter position:");
                sc.next();
                continue;
            }

            if(board[row][col]==' '){
                board[row][col]=player;
                gameover=Won(board,player);
                if(gameover){
                    ShowBoard(board);
		            System.out.println("Player "+player+" has Won.");
                }
                else {
                    player=(player=='A')?'B':'A';
		            count++;
			
			
                }
            }
            else {
                System.out.println("Invalid Position, Try Again");
            }
		
        }
	
    }

    private static boolean Won(char[][] board, char player) {
        for (int i=0;i<board.length;i++){
            if(board[i][0]==player&&board[i][1]==player&&board[i][2]==player){
                return true;
            }
            if(board[0][i]==player&&board[1][i]==player&&board[2][i]==player) {
                return true;
            }
        }
        if(board[0][0]==player&&board[1][1]==player&&board[2][2]==player){
            return true;
        }
        if(board[0][2]==player&&board[1][1]==player&&board[2][0]==player){
            return true;
        }
        return false;
    }

    private static void ShowBoard(char[][] board) {
        System.out.println(" --- --- ---");
        for(int i=0;i<board.length;i++){
            System.out.print("| ");
            for(int j=0;j<board[i].length;j++){
                System.out.print(board[i][j]+" | ");
            }
            System.out.println();
            System.out.println(" --- --- ---");
        }
    }
}