package de.thatsich.minecraft.intellie.common

import appeng.api.recipes.ICraftHandler
import de.thatsich.minecraft.intellie.common.module.BlockGuiHandler
import net.minecraft.block.Block
import net.minecraft.entity.Entity
import net.minecraft.item.{Item, ItemStack}
import net.minecraft.tileentity.TileEntity


/**
 *
 *
 * @author thatsIch
 * @since 23.04.2014.
 */
trait Definitions
{
	val blocks: Seq[Block]
	val crafthandlers: Seq[Class[_ <: ICraftHandler]]
	val entites: Seq[Entity]
	val fakes: Seq[ItemStack]
	val guis: Seq[BlockGuiHandler]
	val items: Seq[Item]
	val modules: Seq[Module]
	val recipes: Seq[Recipe]
	val tiles: Seq[Class[_ <: TileEntity]]
}