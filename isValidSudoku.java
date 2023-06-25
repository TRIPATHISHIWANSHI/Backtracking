class Solution {
    public boolean isValidSudoku(char[][] board) {
    
        // Check rows
        for (int i = 0; i < 9; i++) {
            Set<Character> seen = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                char digit = board[i][j];
                if (digit != '.' && seen.contains(digit)) {
                    return false;
                }
                seen.add(digit);
            }
        }

        // Check columns
        for (int j = 0; j < 9; j++) {
            Set<Character> seen = new HashSet<>();
            for (int i = 0; i < 9; i++) {
                char digit = board[i][j];
                if (digit != '.' && seen.contains(digit)) {
                    return false;
                }
                seen.add(digit);
            }
        }

        // Check sub-boxes
        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                Set<Character> seen = new HashSet<>();
                for (int k = 0; k < 9; k++) {
                    int row = i + k / 3;
                    int col = j + k % 3;
                    char digit = board[row][col];
                    if (digit != '.' && seen.contains(digit)) {
                        return false;
                    }
                    seen.add(digit);
                }
            }
        }

        // If we get here, the board is valid
        return true;
    }

}
