package me.theeninja.nativearrays.core.array.unfiltered;

import me.theeninja.nativearrays.core.array.LongArray;
import me.theeninja.nativearrays.core.array.LongArray;
import me.theeninja.nativearrays.core.array.filtered.FilteredLongArray;
import me.theeninja.nativearrays.core.array.filtered.FilteredLongArray;
import me.theeninja.nativearrays.core.consumers.pair.IndexLongPairConsumer;

import java.util.function.LongBinaryOperator;
import java.util.function.LongConsumer;
import java.util.function.LongPredicate;
import java.util.function.LongUnaryOperator;

public class UnfilteredLongArray extends LongArray<
    FilteredLongArray,
    UnfilteredLongArray
> implements  UnfilteredCollection<
    LongArray<
        FilteredLongArray, 
        UnfilteredLongArray
    >,
    FilteredLongArray, 
    UnfilteredLongArray
>{
    @Override
    public native FilteredLongArray iFilter(LongPredicate predicate);

    @Override
    public native String toString();

    public UnfilteredLongArray(long size) {
        super(size);
    }

    @Override
    public native int get(long index);

    @Override
    public native void set(long index, long value);

    @Override
    public native void fill(long value);

    @Override
    public native int reduce(LongBinaryOperator reducer);

    @Override
    public native UnfilteredLongArray rFilter(LongPredicate predicate);

    @Override
    public native UnfilteredLongArray rMap(LongUnaryOperator mapper);

    @Override
    public native void iMap(LongUnaryOperator mapper);

    @Override
    public native void sort(LongBinaryOperator comparator, long startIndex, long endIndex);

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
}
