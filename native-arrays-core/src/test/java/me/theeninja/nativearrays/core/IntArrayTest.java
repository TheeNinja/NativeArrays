package me.theeninja.nativearrays.core;

import me.theeninja.nativearrays.core.array.IntArray;
import me.theeninja.nativearrays.core.array.unfiltered.UnfilteredIntArray;
import org.junit.jupiter.api.Test;

import java.util.function.IntBinaryOperator;

import static org.junit.jupiter.api.Assertions.*;

public class IntArrayTest {
    private final UnfilteredIntArray intArray = IntArray.fromJavaArray(1, 0, 1);

    private static final int INT_ARRAY_SIZE = 3;

    @Test
    void testGetAndSet() {
        final int observedValue = getIntArray().get(1);

        assertEquals(0, observedValue);
    }

    @Test
    void testSearchForwards() {
        final long observedIndex = getIntArray().searchForwards(1);

        assertEquals(0, observedIndex);
    }

    @Test
    void testSearchBackwards() {
        final long observedIndex = getIntArray().searchBackwards(1);

        assertEquals(2, observedIndex);
    }

    @Test
    void testCount() {
        final long count = getIntArray().count(1);

        assertEquals(2, count);
    }

    @Test
    void testContains() {
        final boolean contains1 = getIntArray().contains(1);

        assertTrue(contains1);

        final boolean contains2 = getIntArray().contains(2);

        assertFalse(contains2);
    }

    private static boolean areEqual(IntArray first, IntArray second) {
        if (first.getSize() != second.getSize()) {
            return false;
        }

        for (int index = 0; index < first.getSize(); index++) {
            final int firstValue = first.get(index);
            final int secondValue = second.get(index);

            if (firstValue != secondValue) {
                return false;
            }
        }

        return true;
    }

    private final UnfilteredIntArray unsortedintArray = IntArray.fromJavaArray(3, 2, 1);
    private final UnfilteredIntArray sortedIntArray = IntArray.fromJavaArray(1, 2, 3);

    @Test
    void testSort() {
        IntBinaryOperator intArraySorter = PrimitiveComparators.forNoOverflowSignedInt(PrimitiveComparators.Order.ASCENDING);

        getUnsortedIntArray().sort(intArraySorter);

        final boolean areEqual = areEqual(getUnsortedIntArray(), getSortedIntArray());

        assertTrue(areEqual);

    }

    private static final int FILL_VALUE = 3;

    @Test
    void testFill() {
        IntArray intArray = IntArray.fromJavaArray(1, 2, 3);

        intArray.fill(FILL_VALUE);

        for (int index = 0; index < intArray.getSize(); index++) {
            final int observedValue = intArray.get(index);

            assertEquals(FILL_VALUE, observedValue);
        }
    }

    @Test
    void testFromJavaArray() {
        final IntArray intArray = IntArray.fromJavaArray(1, 0, 1);

        for (int index = 0; index < INT_ARRAY_SIZE; index++) {
            final int expectedValue = getIntArray().get(index);
            final int observedValue = intArray.get(index);

            assertEquals(expectedValue, observedValue);
        }
    }

    private static void assertIntJavaArraysEquals(IntArray intArray, int[] javaArray) {
        for (int index = 0; index < INT_ARRAY_SIZE; index++) {
            final int expectedValue = intArray.get(index);
            final int observedValue = javaArray[index];

            assertEquals(expectedValue, observedValue);
        }
    }

    @Test
    void testToJavaArray() {
        final int[] javaArray = getIntArray().toJavaArray();

        assertEquals(INT_ARRAY_SIZE, javaArray.length);
        assertIntJavaArraysEquals(getIntArray(), javaArray);
    }

    @Test
    void testIntoJavaArray() {
        final int[] javaArray = new int[INT_ARRAY_SIZE];

        getIntArray().intoJavaArray(javaArray);

        assertIntJavaArraysEquals(getIntArray(), javaArray);
    }

    private static int getAndIncrrement(int[] number) {
        return number[0]++;
    }

    @Test
    void testForEachValue() {
        int[] mutableIndex = new int[1];

        getIntArray().forEachValue(observedValue -> {
            final int index = getAndIncrrement(mutableIndex);

            final int expectedValue = getIntArray().get(index);

            assertEquals(expectedValue, observedValue);
        });
    }

    @Test
    void testForEachIndexValuePair() {
        int[] mutableIndex = new int[1];

        getIntArray().forEachIndexValuePair((observedIndex, observedValue) -> {
            final int expectedIndex = getAndIncrrement(mutableIndex);

            assertEquals(expectedIndex, observedIndex);

            final int expectedValue = getIntArray().get(observedIndex);

            assertEquals(expectedValue, observedValue);
        });
    }

    @Test
    void testCopy() {
        IntArray copiedIntArray = getIntArray().copy();

        for (int index = 0; index < INT_ARRAY_SIZE; index++) {
            final int expectedValue = getIntArray().get(index);
            final int observedValue = copiedIntArray.get(index);

            assertEquals(expectedValue, observedValue);
        }
    }

    @Test
    void testSize() {
        assertEquals(getIntArray().getSize(), INT_ARRAY_SIZE);
    }

    private final UnfilteredIntArray firstEqualArray = IntArray.fromJavaArray(4, 5, 6);
    private final UnfilteredIntArray secondEqualArray = IntArray.fromJavaArray(4, 5, 6);
    private final UnfilteredIntArray unEqualArray = IntArray.fromJavaArray(4, 5, 7);

    @Test
    void testEquals() {
        final boolean equalArraysEqual = areEqual(getFirstEqualArray(), getSecondEqualArray());

        assertTrue(equalArraysEqual);

        final boolean unequalArraysEqual = areEqual(getFirstEqualArray(), getUnEqualArray());

        assertFalse(unequalArraysEqual);
    }

    @Test
    void testToString() {
        final String representation = getIntArray().toString();

        assertEquals(representation, "[1, 0, 1]");
    }

    private UnfilteredIntArray getIntArray() {
        return intArray;
    }

    private UnfilteredIntArray getUnsortedIntArray() {
        return unsortedintArray;
    }

    private UnfilteredIntArray getSortedIntArray() {
        return sortedIntArray;
    }

    private UnfilteredIntArray getFirstEqualArray() {
        return firstEqualArray;
    }

    private UnfilteredIntArray getSecondEqualArray() {
        return secondEqualArray;
    }

    private UnfilteredIntArray getUnEqualArray() {
        return unEqualArray;
    }
}