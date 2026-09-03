package com.directi.training.ocp.exercise_refactored;

public class SpaceSlotPool implements ResourcePool
{
    @Override
    public int findFreeSlot()
    {
        return 0;
    }

    @Override
    public void markBusy(int slotId)
    {
    }

    @Override
    public void markFree(int slotId)
    {
    }
}
