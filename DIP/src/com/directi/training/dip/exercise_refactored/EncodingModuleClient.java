package com.directi.training.dip.exercise_refactored;

import java.io.IOException;

/** Composition root: the only place that knows the concrete classes. */
public class EncodingModuleClient
{
    public static void main(String[] args) throws IOException
    {
        DataSource inputFile = new FileSource("DIP/src/com/directi/training/dip/exercise_refactored/beforeEncryption.txt");
        DataSink outputFile = new FileSink("DIP/src/com/directi/training/dip/exercise_refactored/afterEncryption.txt");
        new EncodingModule(inputFile, outputFile).encode();

        DataSource web = new UrlSource("http", "myfirstappwith.appspot.com", "/index.html");
        DataSink database = new DatabaseSink(new MyDatabase());
        new EncodingModule(web, database).encode();
    }
}
