package com.directi.training.dip.exercise_refactored;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileSource implements DataSource
{
    private final String _path;

    public FileSource(String path)
    {
        _path = path;
    }

    @Override
    public String read() throws IOException
    {
        return new String(Files.readAllBytes(Paths.get(_path)), StandardCharsets.UTF_8);
    }
}
