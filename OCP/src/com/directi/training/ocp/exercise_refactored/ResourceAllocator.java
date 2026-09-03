package com.directi.training.ocp.exercise_refactored;

/**
 * Closed for modification: it never needs to know which concrete pools
 * exist. Open for extension: any new ResourcePool works out of the box.
 */
public class ResourceAllocator
{
    public static final int INVALID_RESOURCE_ID = -1;

    public int allocate(ResourcePool pool)
    {
        if (pool == null) {
            System.out.println("ERROR: Attempted to allocate invalid resource");
            return INVALID_RESOURCE_ID;
        }
        int slotId = pool.findFreeSlot();
        pool.markBusy(slotId);
        return slotId;
    }

    public void free(ResourcePool pool, int slotId)
    {
        if (pool == null) {
            System.out.println("ERROR: attempted to free invalid resource");
            return;
        }
        pool.markFree(slotId);
    }
}
