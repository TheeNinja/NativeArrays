package me.theeninja.nativearrays.jmh;

import me.theeninja.nativearrays.core.array.unfiltered.UnfilteredIntArray;

public class IntArrayBenchmark {
    private static final int VALUE_TO_COUNT = 0;

    // @Benchmark
    public void measureJavaArrayCount(JavaArrayOperation javaArrayOperation) {
        long count = 0;

        int[] ints = javaArrayOperation.newValue();

        for (int index = 0; index < ints.length; index++) {
            final int currentValue = ints[index];

            if (currentValue == VALUE_TO_COUNT) {
                count++;
            }

            count++;
        }

        javaArrayOperation.setResult(count);
    }

    // @Benchmark
    public void measureNativeArrayCount(NativeArrayOperation nativeArrayOperation) {
        try (final UnfilteredIntArray ints = nativeArrayOperation.newValue()) {
            final long count = ints.count(VALUE_TO_COUNT);

            nativeArrayOperation.setResult(count);
        }
    }
}
