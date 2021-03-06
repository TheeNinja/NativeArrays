<h1> NativeArrays </h1>

<code>NativeArrays</code> provides arrays implemented through the JNI, exposed through Java.

These are specialized underlying array implementation for each primitive e.g. <code>IntArray</code>. These
specializations prevent performance penalities invovled with autoboxing/unboxing.

These arrays allow for bulk-operations to be performed without compromising performance (as these
bulk opoerations minimize the overhead involved in communications through the JNI-Java link)

The implemented arrays also provide support for underlying array sizes up to the maximum value of an unsigned long. The API integrates nicely with the existing Java API for unsigned longs.  

The implementation as a whole extensively uses generics to ensure type safety of these native arrays.
