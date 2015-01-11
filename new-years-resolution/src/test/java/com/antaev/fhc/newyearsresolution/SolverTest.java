package com.antaev.fhc.newyearsresolution;

import org.junit.Test;

import static com.antaev.fhc.newyearsresolution.Solver.isReachable;
import static com.antaev.fhc.newyearsresolution.Triple.triple;
import static com.google.common.collect.Lists.newArrayList;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SolverTest {
    @Test
    public void simpleInput() {
        assertTrue(
            isReachable(triple(100, 100, 100),
                newArrayList(
                    triple(100, 100, 100)
                )
            )
        );

        assertFalse(
            isReachable(triple(100, 100, 100),
                newArrayList(
                    triple(10, 10, 40),
                    triple(10, 30, 10),
                    triple(10, 60, 50))
            )
        );

        assertTrue(
            isReachable(triple(100, 100, 100),
                newArrayList(
                    triple(40, 70, 30),
                    triple(30, 10, 40),
                    triple(20, 20, 50),
                    triple(10, 50, 90),
                    triple(40, 10, 20)
                )
            )
        );

        assertFalse(
            isReachable(triple(292, 264, 512),
                newArrayList(
                    triple(909, 302, 261),
                    triple(705, 597, 823),
                    triple(291, 51, 126),
                    triple(28, 697, 57),
                    triple(593, 31, 826),
                    triple(311, 256, 57),
                    triple(292, 14, 47),
                    triple(29, 730, 716),
                    triple(12, 529, 146),
                    triple(768, 16, 439),
                    triple(37, 472, 15),
                    triple(350, 192, 34),
                    triple(163, 468, 238),
                    triple(69, 173, 10),
                    triple(203, 72, 690),
                    triple(424, 875, 213),
                    triple(223, 593, 292),
                    triple(151, 46, 10),
                    triple(88, 90, 16),
                    triple(773, 653, 711))
            )
        );

        assertTrue(
            isReachable(triple(991, 827, 352),
                newArrayList(
                    triple(29, 560, 929),
                    triple(139, 681, 102),
                    triple(144, 853, 10),
                    triple(84, 729, 80),
                    triple(218, 20, 67),
                    triple(140, 80, 901),
                    triple(428, 20, 500),
                    triple(520, 970, 128),
                    triple(422, 419, 30),
                    triple(413, 101, 192),
                    triple(467, 448, 501),
                    triple(32, 939, 684),
                    triple(34, 20, 38),
                    triple(251, 317, 132),
                    triple(588, 437, 10),
                    triple(648, 21, 79),
                    triple(391, 25, 14),
                    triple(499, 22, 24),
                    triple(854, 77, 361),
                    triple(405, 25, 20))
            )
        );
    }
}