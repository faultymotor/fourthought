package com.vayelcrau.fourthought.game;

import lib.Values;

import java.util.ArrayList;

public class Game {
    private Board board;
    private Values turn;

    private static Game instance;
    public static Game getInstance() {
        if (instance == null)
            instance = new Game();
        return instance;
    }

    private Game() {
        board = new Board();
        turn = Values.RED;
    }

    public void place(Values player, int col) {
        if (player != turn || board.colIsFull(col)) return;
        board.place(turn, col);
        if (board.checkForWin(turn)) {
            turn = Values.NONE;
        } else {
            turn = turn.next();
        }
    }

    public Values getTurn() {
        return turn;
    }
    public Board getBoard() {
        return board;
    }
}