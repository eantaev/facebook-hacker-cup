package com.antaev.fhc.lasermaze;

import org.junit.Before;
import org.junit.Test;

import static com.antaev.fhc.lasermaze.Maze.SHOT;
import static com.antaev.fhc.lasermaze.Maze.SPACE;
import static org.junit.Assert.assertEquals;

public class MazeTest {
    private Maze maze;

    @Before
    public void setup() {
        maze = Maze.create(new String[]{
            "...G.",
            ".<.^.",
            ".S...",
            "...#.",
            ".....",
        });
    }

    @Test
    public void mazeStates() {
        Maze.State state0 = maze.state(0);
        assertEquals(SHOT, state0.cell(1, 0));

        Maze.State state1 = maze.state(1);
        assertEquals(SHOT, state1.cell(0, 1));

        Maze.State state2 = maze.state(2);
        assertEquals(SHOT, state2.cell(1, 2));
        assertEquals(SPACE, state2.cell(1, 4));
        assertEquals(SPACE, state2.cell(4, 4));

        Maze.State state3 = maze.state(3);
        assertEquals(SHOT, state3.cell(2, 1));
        assertEquals(SPACE, state3.cell(1, 0));
    }

    @Test
    public void position() {
        Position p = maze.startPosition();
        assertEquals(2, p.row());
        assertEquals(1, p.col());
        assertEquals(maze.state(0), p.mazeState());
    }
}