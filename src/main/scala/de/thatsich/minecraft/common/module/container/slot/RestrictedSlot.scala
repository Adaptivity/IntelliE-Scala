package de.thatsich.minecraft.common.module.container.slot


import net.minecraft.entity.player.EntityPlayer
import net.minecraft.inventory.IInventory


/**
 *
 *
 * @author thatsIch
 * @since 09.08.2014.
 */
class RestrictedSlot(player: EntityPlayer, inv: IInventory, id: Int, x: Int, y: Int) extends AdvancedSlot(player, inv, id, x, y)