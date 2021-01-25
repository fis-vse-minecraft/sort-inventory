package cz.vse.fis.minecraft.sortinventory

import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

class SortInventoryCommandExecutor : CommandExecutor {
    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        if (sender is Player) {
            return sortInventoryOfPlayer(sender)
        }

        return false
    }

    private fun sortInventoryOfPlayer(player: Player): Boolean {
        return true
    }
}