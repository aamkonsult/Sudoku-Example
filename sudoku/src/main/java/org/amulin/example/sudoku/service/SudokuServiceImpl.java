package org.amulin.example.sudoku.service;

import java.io.File;

import org.amulin.example.sudoku.model.BoardResult;
import org.amulin.example.sudoku.model.MoveRequest;
import org.amulin.example.sudoku.model.MoveResult;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Charsets;
import com.google.common.io.Files;

@Service("sudokuService")
public class SudokuServiceImpl implements SudokuService {

    /* 
     * Method to get Sudoku board
     * The board is read as JSON string from file "board.json"
     */
    public BoardResult getBoard(String boardFile) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            String board = Files.toString(new File(boardFile), Charsets.UTF_8);
            return mapper.readValue(board, BoardResult.class);
        } catch (Exception e) {
            return null;
        }
    }


    /*
     * Method to check correctness of request Check if Sudoku board is of right
     * size, 9x9 Check if the values of board are allowed, between 0 and 9 Check
     * if move values are allowed, between 0 and 9
     */
    public boolean isAllowedRequest(MoveRequest request) {

        if (request.getSudokuBoard() == null) {
            return false;
        }

        int[][] board = request.getSudokuBoard();

        if (!isRightSizeBoard(board)) {
            return false;
        }

        if (!isRightValuesBoard(board)) {
            return false;
        }

        if (!isCorrectValuesRequest(request.getMoveRow(),
                                    request.getMoveColumn(), request.getMoveValue())) {
            return false;
        }

        return true;
    }

    /*
     * Method to validate the request Check if the column is valid Check if the
     * row is valid Check if the block is valid Update board Check if the game
     * is over
     */
    public MoveResult validateMove(MoveRequest request) {

        int column = validateRow(request.getSudokuBoard(),
                                 request.getMoveRow(), request.getMoveColumn(),
                                 request.getMoveValue());
        if (column > -1) {
            return new MoveResult(false, request.getMoveRow(), column);
        }

        int row = validateColumn(request.getSudokuBoard(),
                                 request.getMoveRow(), request.getMoveColumn(),
                                 request.getMoveValue());
        if (row > -1) {
            return new MoveResult(false, row, request.getMoveColumn());
        }

        int[] block = validateBlock(request.getSudokuBoard(),
                                    request.getMoveRow(), request.getMoveColumn(),
                                    request.getMoveValue());
        if (block[0] != -1 && block[1] != -1) {
            return new MoveResult(false, block[0], block[1]);
        }

        int[][] board = updateBoard(request.getSudokuBoard(),
                                    request.getMoveRow(), request.getMoveColumn(),
                                    request.getMoveValue());

        if (isGameOver(board)) {
            return new MoveResult(board, true, true);
        } else {
            return new MoveResult(board, true, false);
        }

    }


    // Different checkers, will be refactored to separate class
    boolean isCorrectValuesRequest(int row, int column, int value) {
        if ((row >= 0) && (row < 9)) {
            if ((column >= 0) && (column < 9)) {
                if ((value > 0) && (value < 10)) {
                    return true;
                }
            }
        }
        return false;
    }

    boolean isRightSizeBoard(int[][] board) {

        if (board.length != 9) {
            return false;
        }

        for (int i = 0; i < 9; i++) {
            if (board[i].length != 9) {
                return false;
            }
        }

        return true;
    }

    boolean isRightValuesBoard(int[][] board) {

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if ((board[i][j] < 0) || (board[i][j] > 9)) {
                    return false;
                }
            }
        }

        return true;
    }


    // Different validators, will be refactored to separate class
    int validateColumn(int[][] board, int row, int column, int value) {
        for (int i = 0; i < 9; i++) {
            if (row != i && board[i][column] == value) {
                return i;
            }
        }

        return -1;
    }

    int validateRow(int[][] board, int row, int column, int value) {
        for (int j = 0; j < 9; j++) {
            if (column != j && board[row][j] == value) {
                return j;
            }
        }

        return -1;
    }

    int[] validateBlock(int[][] board, int row, int column, int value) {
        int[] cell = {-1, -1};
        for (int i = (row / 3) * 3; i < (row / 3) * 3 + 3; i++) {
            for (int j = (column / 3) * 3; j < (column / 3) * 3 + 3; j++) {
                if (row != i && column != j && board[i][j] == value) {
                    cell[0] = i;
                    cell[1] = j;
                }
            }
        }

        return cell;
    }

    boolean isGameOver(int[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    int[][] updateBoard(int[][] board, int row, int column, int value) {
        board[row][column] = value;
        return board;
    }

}
