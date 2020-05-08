class Solution {
    public void solve(char[][] board) {

        if (board == null || board.length == 0)
            return;

        int rc = board.length; // 行数
        int cc = board[0].length; // 列数
        int islands_count = 0;

        for (int r = 0; r < rc; ++r) {
            for (int c = 0; c < cc; ++c) {

                if (board[r][c] == 'O') {
                    ++islands_count;
                    Queue<Integer> queue = new LinkedList<>();
                    queue.offer(r * cc + c);
                    board[r][c] = 'X';

                    while (!queue.isEmpty()) {
                        int idx = queue.poll();
                        int row = idx / cc;
                        int col = idx % cc;

                        if (row - 1 >= 0 && board[row - 1][col] == 'O') {
                            queue.offer((row - 1) * cc + col);
                            board[row - 1][col] = 'X';
                        }
                        if (row + 1 < rc - 1 && board[row + 1][col] == 'O') {
                            queue.offer((row + 1) * cc + col);
                            board[row + 1][col] = 'X';
                        }
                        if (col - 1 >= 0 && board[row][col - 1] == 'O') {
                            queue.offer(row * cc + col - 1);
                            board[row][col - 1] = 'X';
                        }
                        if (col + 1 < cc -1 && board[row][col + 1] == 'O') {
                            queue.offer(row * cc + col + 1);
                            board[row][col + 1] = 'X';
                        }

                    }

                }

            }

        }
    }
}