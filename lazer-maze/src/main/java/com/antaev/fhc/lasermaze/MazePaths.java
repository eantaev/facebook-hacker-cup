package com.antaev.fhc.lasermaze;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Set;

import static com.google.common.collect.Sets.newHashSet;

/**
 * Date: 11.01.15
 * Time: 15:10
 *
 * @author Evgeny Antaev
 */
public final class MazePaths {
    public static int findOptimalPathLength(Maze maze) {
        return findOptimalPathLength(maze.startPosition());
    }

    public static int findOptimalPathLength(Position start) {
        Set<Position> visited = newHashSet();
        Queue<Position> qA = new ArrayDeque<>();
        Queue<Position> qB = new ArrayDeque<>();
        qA.add(start);

        int depth = 0;
        while (!qA.isEmpty()) {
            while (!qA.isEmpty()) {
                Position pos = qA.poll();
                if (!visited.contains(pos)) {

                    if (pos.isGoal())
                        return depth;

                    visited.add(pos);
                    for (Position move : pos.adjacentPositions())
                        if (!visited.contains(move))
                            qB.add(move);
                }
            }
            ++depth;
            Queue<Position> t = qA;
            qA = qB;
            qB = t;
        }

        return -1;
    }

    private MazePaths() {
        throw new UnsupportedOperationException();
    }
}
