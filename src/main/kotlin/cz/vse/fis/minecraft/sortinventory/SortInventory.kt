package cz.vse.fis.minecraft.sortinventory

import org.bukkit.Material
import org.bukkit.command.Command
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack
import org.bukkit.plugin.java.JavaPlugin

class SortInventory : JavaPlugin() {
    override fun onEnable() {
        getCommand("sort-inventory")?.setExecutor(this)
    }

    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        if (sender is Player) {
            return sortInventoryOfPlayer(sender)
        }

        return false
    }

    private fun sortInventoryOfPlayer(player: Player): Boolean {
        player.inventory.addItem(ItemStack(Material.DIAMOND, 64))

        return true
    }
}