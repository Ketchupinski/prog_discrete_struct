import java.util.List;


public class Queens {
    Node<int[][]> root;

    int n;

    public Queens(int N) {
        n = N;
        int[][] board = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                board[i][j] = 0;
            }
        }

        root = new Node<>(board);
        placeQueens(root);
    }

    public boolean placeQueens(Node<int[][]> currentNode) {
        int col = findEmptyCol(currentNode.getData());

        if (col == -1) {
            printQueens(currentNode.getData());
            return true;
        }

        int[][] board = currentNode.getData();

        for (int i = 0; i < n; i++) {
            if (canPlaceQueen(currentNode, i, col)) {
                int[][] newBoard = makeCopy(board);
                newBoard[i][col] = 1;
                Node<int[][]> node = new Node<>(newBoard);
                currentNode.addChild(node);

                if (placeQueens(node)) {
                    return true;
                }

                if (node.getParent() != null) {
                    if (placeQueens(node.getParent())) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean canPlaceQueen(Node<int[][]> node, int row, int col) {
        int[][] board = node.getData();
        int i, j;

            // перевірка рядка
            for (i = 0; i < col; i++)
                if (board[row][i] == 1)
                    return false;

            // перевірка верхньої діагоналі
            for (i = row, j = col; i >= 0 && j >= 0; i--, j--)
                if (board[i][j] == 1)
                    return false;

            // перевірка нижньої діагоналі
            for (i = row, j = col; j >= 0 && i < n; i++, j--)
                if (board[i][j] == 1)
                    return false;

        if (node.getChildren() != null) {
            List<Node<int[][]>> child = node.getChildren();

            for (Node<int[][]> kid : child) {
                if (kid.getData()[row][col] == 1) {
                    return false;
                }
            }
        }
        return true;
    }

    public void printQueens(int[][] solution) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(" " + solution[i][j]);
            }
            System.out.println();
        }
    }

    public int findEmptyCol(int[][] desc) {
        boolean isFind = false;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (desc[j][i] == 1) {
                    isFind = true;
                    break;
                }
            }
            if (!isFind) {
                return i;
            }
            isFind = false;
        }
        return -1;
    }

    public int[][] makeCopy(int[][] m) {
        int[][] x = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                x[i][j] = m[i][j];
            }
        }
        return x;
    }
}