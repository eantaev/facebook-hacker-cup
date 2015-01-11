package com.antaev.fhc.lasermaze;

import com.gs.collections.api.map.primitive.CharObjectMap;
import com.gs.collections.api.map.primitive.MutableCharObjectMap;
import com.gs.collections.api.tuple.primitive.IntIntPair;
import com.gs.collections.impl.map.mutable.primitive.CharObjectHashMap;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static com.antaev.fhc.lasermaze.ArrayUtils.copyOf;
import static com.google.common.base.Preconditions.checkElementIndex;
import static com.google.common.collect.Lists.newArrayList;
import static com.gs.collections.impl.tuple.primitive.PrimitiveTuples.pair;

/**
 * Date: 10.01.15
 * Time: 22:52
 *
 * @author Evgeny Antaev
 */
public final class Maze {
    static final int NUM_OF_DIR = 4;
    static final char GOAL = 'G';
    static final char SPACE = '.';
    static final char START = 'S';
    static final char SHOT = '*';

    private final State[] states = new State[NUM_OF_DIR];
    private final Position startPosition;

    public static Maze create(List<String> board) {
        char[][] charBoard = new char[board.size()][];
        for (int row = 0; row < board.size(); row++) {
            charBoard[row] = board.get(row).toCharArray();
        }
        return create(charBoard);
    }

    public static Maze create(String[] board) {
        char[][] charBoard = new char[board.length][];
        for (int row = 0; row < board.length; row++) {
            charBoard[row] = board[row].toCharArray();
        }
        return create(charBoard);
    }

    public static Maze create(char[][] board) {
        return new Maze(board);
    }

    private Maze(char[][] board) {
        int startRow = -1;
        int startCol = -1;
        Collection<IntIntPair> laserLocations = newArrayList();

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                char cell = board[row][col];
                if (isLaser(cell)) {
                    laserLocations.add(pair(row, col));
                } else if (cell == START) {
                    startRow = row;
                    startCol = col;
                }
            }
        }

        for (int turn = 0; turn < NUM_OF_DIR; ++turn) {
            char[][] stateBoard = copyOf(board);
            for (IntIntPair p : laserLocations) {
                int row = p.getOne();
                int col = p.getTwo();
                turnLaser(stateBoard, row, col, turn);
            }
            states[turn] = new State((turn + 1) % NUM_OF_DIR, stateBoard);
        }

        startPosition = new Position(startRow, startCol, states[0]);

    }

    public State state(int turn) {
        return states[turn % NUM_OF_DIR];
    }

    public Position startPosition() {
        return startPosition;
    }

    @Override
    public String toString() {
        return "Maze\n" + Arrays.toString(states);
    }

    public final class State {
        private final int next;
        private final char[][] board;

        State(int next, char[][] board) {
            this.next = next;
            this.board = board;
        }

        public State next() {
            return states[next];
        }

        char cell(int row, int col) {
            checkElementIndex(row, board.length);
            checkElementIndex(col, board[row].length);
            return board[row][col];
        }

        public boolean canGoTo(int row, int col) {
            if (row < 0 || row >= board.length || col < 0 || col >= board[row].length)
                return false;
            char b = board[row][col];
            return b == SPACE || b == GOAL || b == START;
        }

        @Override
        public String toString() {
            return "State{" +
                "next=" + next +
                ", board=\n" + ArrayUtils.toString(board) +
                '}';
        }

        @Override
        public boolean equals(Object o) {
            return this == o || (o instanceof State && next == ((State) o).next);

        }

        @Override
        public int hashCode() {
            return next;
        }

        public char[][] copyBoard() {
            return ArrayUtils.copyOf(board);
        }
    }

    private static void turnLaser(char[][] board, int row, int col, int turns) {
        LaserDirection newDir = LASER_DIRECTIONS.get(board[row][col]).turn(turns);
        board[row][col] = newDir.symbol;
        row += newDir.rowDiff;
        col += newDir.colDiff;
        while (row != -1 && row != board.length
            && col != -1 && col != board[row].length
            && canShootThrough(board[row][col])) {

            board[row][col] = SHOT;
            row += newDir.rowDiff;
            col += newDir.colDiff;

        }
    }

    private static boolean canShootThrough(char c) {
        return c == SPACE || c == START || c == GOAL || c == SHOT;
    }

    public static boolean isLaser(char c) {
        return LASER_DIRECTIONS.containsKey(c);
    }

    private static final CharObjectMap<LaserDirection> LASER_DIRECTIONS;

    static {
        MutableCharObjectMap<LaserDirection> m = CharObjectHashMap.newMap();
        for (LaserDirection ld : LaserDirection.values()) {
            m.put(ld.symbol, ld);
        }
        LASER_DIRECTIONS = m.toImmutable();
    }


    private static enum LaserDirection {
        LEFT('<', 0, -1),
        UP('^', -1, 0),
        RIGHT('>', 0, 1),
        DOWN('v', 1, 0);

        private final char symbol;
        private final int rowDiff;
        private final int colDiff;

        LaserDirection(char symbol, int rowDiff, int colDiff) {
            this.symbol = symbol;
            this.rowDiff = rowDiff;
            this.colDiff = colDiff;
        }

        public LaserDirection turn(int turns) {
            return values()[(ordinal() + turns) % NUM_OF_DIR];
        }
    }
}
