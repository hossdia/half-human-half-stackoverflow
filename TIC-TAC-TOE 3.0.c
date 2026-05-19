#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <ctype.h>

#define SIZE 3
#define EMPTY ' '

char PLAYER, AI;
int playerTurn;
int difficulty; // 0 = Easy, 1 = Medium, 2 = Hard

void printBoard(char board[SIZE][SIZE]) {
    printf("\n    0   1   2\n");
    printf("  -------------\n");
    for (int i = 0; i < SIZE; i++) {
        printf("%d |", i);
        for (int j = 0; j < SIZE; j++) {
            printf(" %c |", board[i][j]);
        }
        printf("\n  -------------\n");
    }
    printf("\n");
}

void printBlankGuideBoard() {
    char tempBoard[SIZE][SIZE] = {
        {EMPTY, EMPTY, EMPTY},
        {EMPTY, EMPTY, EMPTY},
        {EMPTY, EMPTY, EMPTY}
    };
    printf("\nTIC-TAC-TOE GRID GUIDE:\n");
    printBoard(tempBoard);
    printf("To make a move, enter row and column numbers (e.g., 0 1 for middle-left).\n\n");
}

int isMovesLeft(char board[SIZE][SIZE]) {
    for (int i = 0; i < SIZE; i++)
        for (int j = 0; j < SIZE; j++)
            if (board[i][j] == EMPTY)
                return 1;
    return 0;
}

int checkWin(char board[SIZE][SIZE]) {
    for (int i = 0; i < SIZE; i++) {
        if (board[i][0] != EMPTY && board[i][0] == board[i][1] && board[i][1] == board[i][2])
            return (board[i][0] == PLAYER) ? 1 : -1;
        if (board[0][i] != EMPTY && board[0][i] == board[1][i] && board[1][i] == board[2][i])
            return (board[0][i] == PLAYER) ? 1 : -1;
    }
    if (board[0][0] != EMPTY && board[0][0] == board[1][1] && board[1][1] == board[2][2])
        return (board[0][0] == PLAYER) ? 1 : -1;
    if (board[0][2] != EMPTY && board[0][2] == board[1][1] && board[1][1] == board[2][0])
        return (board[0][2] == PLAYER) ? 1 : -1;
    return 0;
}

int minimax(char board[SIZE][SIZE], int depth, int isMaximizing, int maxDepth) {
    int score = checkWin(board);
    if (score == 1) return -10 + depth;
    if (score == -1) return 10 - depth;
    if (!isMovesLeft(board) || (maxDepth != -1 && depth >= maxDepth)) return 0;

    if (isMaximizing) {
        int best = -1000;
        for (int i = 0; i < SIZE; i++)
            for (int j = 0; j < SIZE; j++)
                if (board[i][j] == EMPTY) {
                    board[i][j] = AI;
                    int val = minimax(board, depth + 1, 0, maxDepth);
                    best = (val > best) ? val : best;
                    board[i][j] = EMPTY;
                }
        return best;
    } else {
        int best = 1000;
        for (int i = 0; i < SIZE; i++)
            for (int j = 0; j < SIZE; j++)
                if (board[i][j] == EMPTY) {
                    board[i][j] = PLAYER;
                    int val = minimax(board, depth + 1, 1, maxDepth);
                    best = (val < best) ? val : best;
                    board[i][j] = EMPTY;
                }
        return best;
    }
}

void getAIMove(char board[SIZE][SIZE]) {
    int bestRow = -1, bestCol = -1;

    if (difficulty == 0) {
        // Easy: random move
        int moves[9][2], count = 0;
        for (int i = 0; i < SIZE; i++)
            for (int j = 0; j < SIZE; j++)
                if (board[i][j] == EMPTY)
                    moves[count][0] = i, moves[count++][1] = j;
        int choice = rand() % count;
        bestRow = moves[choice][0];
        bestCol = moves[choice][1];
    } else {
        int maxDepth = (difficulty == 1) ? 2 : -1; // Medium depth-limited
        int bestVal = -1000;
        for (int i = 0; i < SIZE; i++)
            for (int j = 0; j < SIZE; j++)
                if (board[i][j] == EMPTY) {
                    board[i][j] = AI;
                    int moveVal = minimax(board, 0, 0, maxDepth);
                    board[i][j] = EMPTY;

                    if (moveVal > bestVal) {
                        bestRow = i;
                        bestCol = j;
                        bestVal = moveVal;
                    }
                }
    }

    board[bestRow][bestCol] = AI;
    printf("AI placed %c at position (%d, %d)\n", AI, bestRow, bestCol);
}

void getPlayerMove(char board[SIZE][SIZE]) {
    int row, col;
    while (1) {
        printf("Enter your move (row and column 0-2): ");
        if (scanf("%d %d", &row, &col) != 2) {
            printf("Invalid input. Please enter numbers.\n");
            while (getchar() != '\n'); // Clear input buffer
            continue;
        }
        if (row >= 0 && row < SIZE && col >= 0 && col < SIZE && board[row][col] == EMPTY) {
            board[row][col] = PLAYER;
            break;
        } else {
            printf("Invalid move. Try again.\n");
        }
    }
}

void chooseSymbolAndTurn() {
    char symbol;
    while (1) {
        printf("Choose your symbol (X or O): ");
        scanf(" %c", &symbol);
        symbol = toupper(symbol);
        if (symbol == 'X' || symbol == 'O') {
            PLAYER = symbol;
            AI = (symbol == 'X') ? 'O' : 'X';
            break;
        } else {
            printf("Invalid input. Try again.\n");
        }
    }

    while (1) {
        printf("Do you want to go first? (1 = Yes, 0 = No): ");
        if (scanf("%d", &playerTurn) == 1 && (playerTurn == 0 || playerTurn == 1)) {
            break;
        } else {
            printf("Invalid input. Enter 1 or 0.\n");
            while (getchar() != '\n'); // Clear buffer
        }
    }

    while (1) {
        printf("Choose difficulty (0 = Easy, 1 = Medium, 2 = Hard): ");
        if (scanf("%d", &difficulty) == 1 && (difficulty >= 0 && difficulty <= 2)) {
            break;
        } else {
            printf("Invalid input. Enter 0, 1, or 2.\n");
            while (getchar() != '\n');
        }
    }
}

int main() {
    srand(time(0));

    char board[SIZE][SIZE] = {
        {EMPTY, EMPTY, EMPTY},
        {EMPTY, EMPTY, EMPTY},
        {EMPTY, EMPTY, EMPTY}
    };

    printBlankGuideBoard();
    chooseSymbolAndTurn();

    while (1) {
        printBoard(board);

        if (playerTurn) {
            getPlayerMove(board);
        } else {
            getAIMove(board);
        }

        int result = checkWin(board);
        if (result == 1) {
            printBoard(board);
            printf("You win!\n");
            break;
        } else if (result == -1) {
            printBoard(board);
            printf("AI wins!\n");
            break;
        } else if (!isMovesLeft(board)) {
            printBoard(board);
            printf("It's a draw!\n");
            break;
        }

        playerTurn = !playerTurn; // Switch turns
    }

    return 0;
}