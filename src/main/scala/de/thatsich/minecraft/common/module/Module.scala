package de.thatsich.minecraft.common.module


import appeng.api.recipes.ICraftHandler
import de.thatsich.minecraft.common.module.gui.BlockGuiHandler
import de.thatsich.minecraft.common.module.recipe.Recipe
import net.minecraft.block.Block
import net.minecraft.entity.Entity
import net.minecraft.item.Item
import net.minecraft.tileentity.TileEntity


/**
 *
 *
 * @author thatsIch
 * @since 23.04.2014.
 */
trait Module
{
	val blocks: Seq[Block]
	val crafthandlers: Seq[Class[_ <: ICraftHandler]]
	val entites: Seq[Entity]
	val fakes: Seq[Item]
	val guis: Seq[BlockGuiHandler]
	val items: Seq[Item]
	val modules: Seq[Module]
	val recipes: Seq[Recipe]
	val tiles: Seq[Class[_ <: TileEntity]]
}