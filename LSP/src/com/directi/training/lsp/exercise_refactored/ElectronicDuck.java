package com.directi.training.lsp.exercise_refactored;

/**
 * Still a Duck, but it honours the Duck contract: when switched off it
 * simply does nothing instead of throwing. Its power state is exposed
 * through a separate interface so clients that care can use it.
 */
public class ElectronicDuck implements Duck, Switchable
{
    private boolean _on = false;

    @Override
    public void quack()
    {
        if (_on) {
            System.out.println("Electronic duck quack...");
        } else {
            System.out.println("Electronic duck is off, no quack");
        }
    }

    @Override
    public void swim()
    {
        if (_on) {
            System.out.println("Electronic duck swim");
        } else {
            System.out.println("Electronic duck is off, floating still");
        }
    }

    @Override
    public void turnOn()
    {
        _on = true;
    }

    @Override
    public void turnOff()
    {
        _on = false;
    }

    @Override
    public boolean isOn()
    {
        return _on;
    }
}
