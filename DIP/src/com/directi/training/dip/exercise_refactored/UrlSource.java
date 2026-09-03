package com.directi.training.dip.exercise_refactored;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class UrlSource implements DataSource
{
    private final URL _url;

    public UrlSource(String protocol, String host, String file) throws IOException
    {
        _url = new URL(protocol, host, file);
    }

    @Override
    public String read() throws IOException
    {
        StringBuilder content = new StringBuilder();
        try (InputStream in = _url.openStream();
             InputStreamReader reader = new InputStreamReader(in)) {
            int c;
            while ((c = reader.read()) != -1) {
                content.append((char) c);
            }
        }
        return content.toString();
    }
}
