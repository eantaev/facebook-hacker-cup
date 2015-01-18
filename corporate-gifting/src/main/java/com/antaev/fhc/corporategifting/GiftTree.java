package com.antaev.fhc.corporategifting;

import com.gs.collections.api.map.primitive.MutableIntObjectMap;
import com.gs.collections.impl.map.mutable.primitive.IntObjectHashMap;

import java.util.Collection;

import static com.google.common.collect.Lists.newArrayList;

/**
 * Date: 18.01.15
 * Time: 17:24
 *
 * @author Evgeny Antaev
 */
public final class GiftTree {
    private final Node root;

    private GiftTree(Node root) {
        this.root = root;
    }


    public static int optimalCost(int... hierarchy) {
        return buildGiftTree(hierarchy).optimalCost();
    }

    public static GiftTree buildGiftTree(int... hierarchy) {
        MutableIntObjectMap<Node> nodeMap = IntObjectHashMap.newMap();
        Node root = new Node();
        nodeMap.put(1, root);

        for (int k = 1; k < hierarchy.length; k++) {
            int employeeId = k + 1;
            int managerId = hierarchy[k];
            Node employeeNode = nodeMap.getIfAbsentPut(employeeId, Node::new);
            Node managerNode = nodeMap.getIfAbsentPut(managerId, Node::new);
            managerNode.addChild(employeeNode);
        }

        root.preCompute();

        return new GiftTree(root);
    }

    public int optimalCost() {
        return root.optimalCost;
    }

    @Override
    public String toString() {
        return "GiftTree{" +
            "root=" + root +
            '}';
    }

    private static final class Node {
        private int optimalCost;
        private int optimalSelfCost;
        private int secondOptimalCost;

        private Collection<Node> children;

        void addChild(Node child) {
            if (children == null) {
                children = newArrayList();
            }
            children.add(child);
        }

        private int optimalIfParent(int parentCost) {
            return parentCost == optimalSelfCost ? secondOptimalCost : optimalCost;
        }

        void preCompute() {
            if (children == null) { // leaf
                optimalCost = 1;
                optimalSelfCost = 1;
                secondOptimalCost = 2;
                return;
            }

            children.forEach(Node::preCompute);
            optimalCost = Integer.MAX_VALUE;
            secondOptimalCost = Integer.MAX_VALUE;
            for (int selfCost = 1; selfCost < 6; ++selfCost) {
                int cost = selfCost;
                for (Node child : children) {
                    cost += child.optimalIfParent(selfCost);
                }

                if (cost < secondOptimalCost) {
                    secondOptimalCost = cost;
                    if (secondOptimalCost < optimalCost) { // swap
                        int t = secondOptimalCost;
                        secondOptimalCost = optimalCost;
                        optimalCost = t;

                        optimalSelfCost = selfCost;
                    }
                }
            }
        }

        @Override
        public String toString() {
            return "Node{" +
                "optimalCost=" + optimalCost +
                ", optimalSelfCost=" + optimalSelfCost +
                ", secondOptimalCost=" + secondOptimalCost +
                ", children=" + children +
                '}';
        }
    }
}
