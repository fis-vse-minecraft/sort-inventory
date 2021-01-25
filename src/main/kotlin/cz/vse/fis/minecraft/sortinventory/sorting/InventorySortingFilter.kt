package cz.vse.fis.minecraft.sortinventory.sorting

import org.bukkit.inventory.ItemStack

interface InventorySortingFilter {
    fun sort(input: Array<out ItemStack>): Array<out ItemStack>
}