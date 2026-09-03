package com.directi.training.dip.exercise_refactored;

import java.io.IOException;
import java.util.Base64;

/**
 * High-level policy: read, encode, write. It knows nothing about files,
 * URLs or databases; those are injected as abstractions.
 */
public class EncodingModule
{
    private final DataSource _source;
    private final DataSink _sink;

    public EncodingModule(DataSource source, DataSink sink)
    {
        _source = source;
        _sink = sink;
    }

    public void encode() throws IOException
    {
        String input = _source.read();
        String encoded = Base64.getEncoder().encodeToString(input.getBytes());
        _sink.write(encoded);
    }
}
