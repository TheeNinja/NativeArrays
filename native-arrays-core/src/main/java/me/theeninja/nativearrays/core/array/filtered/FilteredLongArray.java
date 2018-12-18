package me.theeninja.nativearrays.core.array.filtered;

import me.theeninja.nativearrays.core.array.unfiltered.UnfilteredDoubleArray;
import me.theeninja.nativearrays.core.consumers.pair.IndexLongPairConsumer;
import me.theeninja.nativearrays.core.array.LongArray;
import me.theeninja.nativearrays.core.comparator.LongComparator;
import me.theeninja.nativearrays.core.array.unfiltered.UnfilteredLongArray;

import java.util.function.LongBinaryOperator;
import java.util.function.LongConsumer;
import java.util.function.LongPredicate;
import java.util.function.LongUnaryOperator;

public class FilteredLongArray extends LongArray<FilteredLongArray, UnfilteredLongArray> {
    public FilteredLongArray(long size) {
        super(size);
    }

    @Override
    public native String toString();

    @Override
    public native FilteredLongArray iFilter(LongPredicate predicate);

    @Override
    public native UnfilteredLongArray rFilter(LongPredicate predicate);

    @Override
    public native int get(long index);

    @Override
    public native void set(long index, long value);

    @Override
    public native long count(long value);

    @Override
    public native void fill(long value);

    @Override
    public native int reduce(LongBinaryOperator reducer);

    @Override
    public native UnfilteredLongArray rMap(LongUnaryOperator mapper);

    @Override
    public native void iMap(LongUnaryOperator mapper);

    @Override
    public native void sort();

    @Override
    public native void sort(LongComparator comparator);

    @Override
    public native long[] toJavaArray();

    @Override
    public native void intoJavaArray(long[] javaArray);

    @Override
    public native void forEachValue(LongConsumer intConsumer);

    @Override
    public native void forEachIndexValuePair(IndexLongPairConsumer indexValuePairConsumer);

    @Override
    public native void copyInto(UnfilteredLongArray nativeArray, long offset, long newSize);

    @Override
    public native UnfilteredLongArray copy();
}