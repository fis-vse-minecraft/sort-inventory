package cz.vse.fis.minecraft.sortinventory

import org.bukkit.command.Command
import org.bukkit.command.CommandSender
import org.bukkit.plugin.java.JavaPlugin

class SortInventory : JavaPlugin() {
    override fun onEnable() {
    }

    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        println(command)
        sender.sendMessage("It works!")
        return true
    }
}