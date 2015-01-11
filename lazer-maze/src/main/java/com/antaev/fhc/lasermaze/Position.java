package com.antaev.fhc.lasermaze;

import java.util.Collection;

import static com.antaev.fhc.lasermaze.Maze.GOAL;
import static com.google.common.collect.Lists.newArrayListWithCapacity;

/**
 * Date: 11.01.15
 * Time: 0:31
 *
 * @author Evgeny Antaev
 */
public final class Position {
    private final int row;
    private final int col;
    private final Maze.State mazeState;

    public Position(int row, int col, Maze.State mazeState) {
        this.row = row;
        this.col = col;
        this.mazeState = mazeState;
    }

    public int row() {
        return row;
    }

    public int col() {
        return col;
    }

    public Maze.State mazeState() {
        return mazeState;
    }

    private Position goTo(int newRow, int newCol) {
        Maze.State nextState = mazeState.next();
        return nextState.canGoTo(newRow, newCol) ? new Position(newRow, newCol, nextState) : null;
    }

    public Collection<Position> adjacentPositions() {
        Collection<Position> moves = newArrayListWithCapacity(4);
        Position p;
        if ((p = goTo(row - 1, col)) != null) moves.add(p);
        if ((p = goTo(row + 1, col)) != null) moves.add(p);
        if ((p = goTo(row, col - 1)) != null) moves.add(p);
        if ((p = goTo(row, col + 1)) != null) moves.add(p);
        return moves;
    }

    public boolean isGoal() {
        return mazeState.cell(row, col) == GOAL;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Position)) return false;

        Position p = (Position) o;

        return col == p.col && row == p.row && mazeState == p.mazeState;

    }

    @Override
    public int hashCode() {
        int result = row;
        result = 31 * result + col;
        result = 31 * result + mazeState.hashCode();
        return result;
    }

    @Override
    public String toString() {
        char[][] board = mazeState.copyBoard();
        board[row][col] = '@';
        return "Pos{\n" + ArrayUtils.toString(board) + '}';
    }
}
