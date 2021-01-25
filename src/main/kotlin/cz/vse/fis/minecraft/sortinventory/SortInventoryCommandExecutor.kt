package cz.vse.fis.minecraft.sortinventory

import cz.vse.fis.minecraft.sortinventory.sorting.DefaultSortingFilter
import cz.vse.fis.minecraft.sortinventory.sorting.InventorySortingFilter
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

class SortInventoryCommandExecutor : CommandExecutor {

    private val filters: Map<String, InventorySortingFilter> = mapOf()

    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        if (sender is Player) {
            return sortInventoryOfPlayer(sender, args)
        }

        return false
    }

    private fun sortInventoryOfPlayer(player: Player, args: Array<out String>): Boolean {
        val name = args.firstOrNull() ?: "default"
        val filter = filters.getOrDefault(name, DefaultSortingFilter())

        val inventory = player.inventory.contents
        val sorted = filter.sort(inventory)

        player.inventory.contents = sorted
        return true
    }
}