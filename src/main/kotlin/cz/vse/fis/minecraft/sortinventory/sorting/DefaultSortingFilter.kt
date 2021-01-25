package cz.vse.fis.minecraft.sortinventory.sorting

import org.bukkit.inventory.ItemStack

class DefaultSortingFilter : InventorySortingFilter {
    override fun sort(input: Array<out ItemStack>): Array<out ItemStack> =
       input.reversed().toTypedArray()
}