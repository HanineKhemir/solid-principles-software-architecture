package com.directi.training.dip.exercise_refactored;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileSink implements DataSink
{
    private final String _path;

    public FileSink(String path)
    {
        _path = path;
    }

    @Override
    public void write(String data) throws IOException
    {
        Files.write(Paths.get(_path), data.getBytes(StandardCharsets.UTF_8));
    }
}
