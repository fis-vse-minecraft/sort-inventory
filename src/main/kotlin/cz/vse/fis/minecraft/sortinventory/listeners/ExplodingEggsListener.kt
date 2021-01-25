package cz.vse.fis.minecraft.sortinventory.listeners

import org.bukkit.*
import org.bukkit.block.Block
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerEggThrowEvent
import org.bukkit.plugin.java.JavaPlugin
import org.bukkit.util.Vector
import kotlin.random.Random

class ExplodingEggsListener(private val plugin: JavaPlugin) : Listener {
    @EventHandler
    fun onPlayerEggThrowEvent(event: PlayerEggThrowEvent) {
        val origin = event.egg.location
        val world = event.egg.world
        val radius = 5
        val blocks = blocksInRadius(origin.block, radius)
            .filter { it.location.distance(origin) < 2 + Random.nextInt(6) }

        val floating = blocks.map {
            val block = world.spawnFallingBlock(
                it.location,
                it.blockData
            )

            block.setGravity(false)
            block.velocity = Vector(
                block.location.x - origin.x,
                block.location.y - origin.y,
                block.location.z - origin.z
            ).multiply(-0.1F)

            block
        }

        blocks.forEach { it.type = Material.AIR }

        world.spawnParticle(Particle.REVERSE_PORTAL, origin, 400, 1.0, 1.0, 1.0)
        world.playSound(origin, Sound.ENTITY_ENDERMAN_TELEPORT, 1F, 1F)

        Bukkit
            .getScheduler()
            .scheduleSyncDelayedTask(plugin, { floating.forEach { it.remove() } }, 10)
    }

    private fun blocksInRadius(block: Block, radius: Int): List<Block> {
        if (radius <= 0) return listOf(block)

        val blocks = mutableListOf<Block>()

        for (x in block.x - radius .. block.x + radius) {
            for (y in block.y - radius .. block.y + radius) {
                for (z in block.z - radius .. block.z + radius) {
                    blocks += block.world.getBlockAt(x, y, z)
                }
            }
        }

        return blocks
    }
}