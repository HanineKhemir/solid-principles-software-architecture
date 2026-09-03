package com.directi.training.ocp.exercise_refactored;

/**
 * Abstraction over one kind of allocatable resource. Adding a new kind of
 * resource means adding a new implementation, not editing the allocator.
 */
public interface ResourcePool
{
    int findFreeSlot();

    void markBusy(int slotId);

    void markFree(int slotId);
}
