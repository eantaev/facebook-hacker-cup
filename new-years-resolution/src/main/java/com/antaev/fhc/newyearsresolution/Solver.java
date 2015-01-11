package com.antaev.fhc.newyearsresolution;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;

import java.util.List;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Date: 11.01.15
 * Time: 18:50
 *
 * @author Evgeny Antaev
 */
public class Solver {
    private final List<Triple> foods;

    private final Table<Triple, Integer, Boolean> memo = HashBasedTable.create();

    public static boolean isReachable(Triple capacity, List<Triple> foods) {
        return new Solver(foods).isReachable(capacity);
    }

    public Solver(List<Triple> foods) {
        this.foods = checkNotNull(foods);
    }

    public boolean isReachable(Triple capacity) {
        return isReachable(capacity, foods.size() - 1);
    }

    private boolean isReachable(Triple capacity, Integer item) {
        if (!capacity.isValid()) return false;
        if (capacity.isZero()) return true;
        if (item == -1) return false;

        Boolean ret = memo.get(capacity, item);
        if (ret == null)
            ret = isReachable(capacity, item - 1) || isReachable(capacity.subtract(foods.get(item)), item - 1);
        return ret;
    }
}
