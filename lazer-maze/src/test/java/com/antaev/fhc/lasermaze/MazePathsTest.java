package com.antaev.fhc.lasermaze;

import com.google.common.base.Charsets;
import org.junit.Test;

import java.io.IOException;

import static com.antaev.fhc.lasermaze.MazePaths.findOptimalPathLength;
import static com.google.common.io.Resources.getResource;
import static com.google.common.io.Resources.readLines;
import static org.junit.Assert.assertEquals;

public class MazePathsTest {
    @Test
    public void test() {
        assertEquals(6, findOptimalPathLength(Maze.create(new String[]{
            "...G.",
            ".<.^.",
            ".S...",
            "...#.",
            ".....",
        })));
    }

    @Test
    public void smallInput() {
        assertEquals(6, findOptimalPathLength(Maze.create(new String[]{
            "##^##",
            "S...G"
        })));
        assertEquals(4, findOptimalPathLength(Maze.create(new String[]{
            "##v##",
            "S...G"
        })));
        assertEquals(3, findOptimalPathLength(Maze.create(new String[]{
            "S..G<"
        })));
        assertEquals(-1, findOptimalPathLength(Maze.create(new String[]{
            "S...G<"
        })));
        assertEquals(8, findOptimalPathLength(Maze.create(new String[]{
            "S....",
            ".....",
            ".>v..",
            ".^<..",
            "....G"
        })));
    }

    @Test
    public void bigInput() throws IOException {
        int pathLength = findOptimalPathLength(
            Maze.create(
                readLines(
                    getResource("large_input_82x99.txt"),
                    Charsets.UTF_8)
            )
        );

        System.out.println(pathLength);
    }
}