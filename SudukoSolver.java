package backtracking;

public class SudukoSolver {
	public static void main(String[] args) {
		
	}
	
	static boolean solve(int[][] board) {
		int n = board.length;
		int row = -1;
		int col = -1;
		
		boolean emptyLeft = true;
		for (int i = 0; i < n; i ++) {
			for (int j = 0; j < n; j++) {
				if (board[i][j] == 0) {
					row = i;
					col = j;
					emptyLeft = false;
					break;
				}
			}
			
			if (emptyLeft == false) {
				break;
			}
		}
		if (emptyLeft == true) {
			return true;
		}
		
		for (int number = 1; number <= 9; number++) {
			if (isSafe(board, row, col, number)) {
				board[row][col] = number;
				if (solve(board)) {
					display(board);
					return true;
				}
				else {
					board[row][col] = 0;
				}
			}
		}
		return false;
	}
	
	
	
	private static void display(int[][] board) {
		for (int[] row : board) {
			for (int num : row) {
				System.out.println(num + " ");
			}
			System.out.println();
		}
		
	}

	static boolean isSafe(int[][] board, int row, int col, int num) {
		for (int i = 0; i < board.length; i++) {
			if (board[row][col] == num) {
				return false;
			}
		}
		
		for (int[] nums : board) {
			if (nums[col] == num) {
				return false;
			}
		}
		
		int sqrt = (int)Math.sqrt(board.length);
		int start = row - row % sqrt;
		int end = col - col % sqrt;
		
		for (int r = start; r < start + sqrt; r++) {
			for (int c = end; c < col + sqrt; c++) {
				if (board[r][c] == num) {
					return false;
				}
			}
		}
		return true;
	}
}
