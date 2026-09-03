package com.directi.training.dip.exercise_refactored;

/** Adapts the existing MyDatabase to the DataSink abstraction. */
public class DatabaseSink implements DataSink
{
    private final MyDatabase _database;

    public DatabaseSink(MyDatabase database)
    {
        _database = database;
    }

    @Override
    public void write(String data)
    {
        _database.write(data);
    }
}
