package de.thatsich.minecraft.core.module.block

import net.minecraft.block.ITileEntityProvider
import net.minecraft.item.ItemBlock

/**
 *
 *
 * @author thatsIch
 * @since 07.04.2014.
 */
trait IBlockContainer extends IBlock with ITileEntityProvider
{
	def getItemBlockClass: Class[ _ <: ItemBlock ]
}