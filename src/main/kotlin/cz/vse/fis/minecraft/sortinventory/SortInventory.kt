package cz.vse.fis.minecraft.sortinventory

import cz.vse.fis.minecraft.sortinventory.listeners.ExplodingEggsListener
import org.bukkit.plugin.java.JavaPlugin

class SortInventory : JavaPlugin() {
    override fun onEnable() {
        getCommand("sort-inventory")
            ?.setExecutor(SortInventoryCommandExecutor())

        server.pluginManager.registerEvents(ExplodingEggsListener(this), this)
    }
}