package de.thatsich.minecraft.intellie.applied.aerodynamics.intern.module.bench


import de.thatsich.minecraft.common.module.container.slot.OutputSlot
import net.minecraft.entity.player.{EntityPlayer, InventoryPlayer}
import net.minecraft.inventory.{Container, Slot}
import net.minecraft.item.ItemStack


/**
 *
 *
 * @author thatsIch
 * @since 06.08.2014.
 */
class WorkbenchContainer(player: InventoryPlayer, private val workbench: WorkbenchTileEntity) extends Container
{
	// Hotbar
	for (slotIndex <- 0 to 8)
	{
		this.addSlotToContainer(new Slot(player, slotIndex, 8 + 18 * slotIndex, 152))
	}

	// Bag
	for (row <- 0 to 2; col <- 0 to 8)
	{
		this.addSlotToContainer(new Slot(player, col + row * 9 + 9, 8 + 18 * col, 94 + row * 18))
	}

	// Workbench
	this.addSlotToContainer(new ArmorDissemblerSlot(workbench, 0, 39, 40))
	this.addSlotToContainer(new UpgradeSlot(workbench, 1, 59, 40))
	this.addSlotToContainer(new OutputSlot(workbench, 2, 110, 40))

	def canInteractWith(player: EntityPlayer): Boolean = workbench.isUseableByPlayer(player)

	override def transferStackInSlot(player: EntityPlayer, slotIndex: Int): ItemStack =
	{
		val slot: Slot = this.getSlot(slotIndex)

		// check if slot really exists and has something in it
		if (slot != null && slot.getHasStack)
		{
			val stackInSlot: ItemStack = slot.getStack
			val result = stackInSlot.copy

			println(slotIndex)

			// armor tool slot
			if (slotIndex >= 36)
			{
				if (!this.mergeItemStack(stackInSlot, 0, 35, false))
				{
					return null
				}
			}
			// in player inventory
			else if (slotIndex > 36)
			{
				println("player inventory")
			}

			//
			//			if (slotIndex == 2)
			//			{
			//				if (!this.mergeItemStack(stackInSlot, 3, 39, true))
			//				{
			//					return null
			//				}
			//				slot.onSlotChange(stackInSlot, result)
			//			}
			//			else if (slotIndex != 1 && slotIndex != 0)
			//			{
			//				if (FurnaceRecipes.smelting.getSmeltingResult(stackInSlot) != null)
			//				{
			//					if (!this.mergeItemStack(stackInSlot, 0, 1, false))
			//					{
			//						return null
			//					}
			//				}
			//				else if (TileEntityFurnace.isItemFuel(stackInSlot))
			//				{
			//					if (!this.mergeItemStack(stackInSlot, 1, 2, false))
			//					{
			//						return null
			//					}
			//				}
			//				else if (slotIndex >= 3 && slotIndex < 30)
			//				{
			//					if (!this.mergeItemStack(stackInSlot, 30, 39, false))
			//					{
			//						return null
			//					}
			//				}
			//				else if (slotIndex >= 30 && slotIndex < 39 && !this.mergeItemStack(stackInSlot, 3, 30, false))
			//				{
			//					return null
			//				}
			//			}
			//			else if (!this.mergeItemStack(stackInSlot, 3, 39, false))
			//			{
			//				return null
			//			}
			//			if (stackInSlot.stackSize == 0)
			//			{
			//				slot.putStack(null.asInstanceOf[ItemStack])
			//			}
			//			else
			//			{
			//				slot.onSlotChanged()
			//			}
			//			if (stackInSlot.stackSize == result.stackSize)
			//			{
			//				return null
			//			}
			//			slot.onPickupFromSlot(player, stackInSlot)
			if (stackInSlot.stackSize == 0)
			{
				slot.putStack(null)
			}
			else
			{
				slot.onSlotChanged()
			}

			if (stackInSlot.stackSize == result.stackSize)
			{
				return null
			}
			slot.onPickupFromSlot(player, stackInSlot)
		}

		null
	}

	//	override def transferStackInSlot(player: EntityPlayer, slotClicked: Int): ItemStack =
	//	{
	//		var itemstack: ItemStack = null
	//		//This gets the slot that the player right clicked from.
	//		val slot = this.getSlot(slotClicked)
	//
	//		if (slot != null && slot.getHasStack)
	//		{
	//			val itemstack1: ItemStack = slot.getStack
	//			itemstack = itemstack1.copy()
	//
	//			//This is the cooked item slot, slot 0 is the raw item,
	//			//slot 1 is the fuel and slot 2 is where to cooked item goes.
	//			if (slotClicked == 2)
	//			{
	//				//This function is trying to send it to slots 3 all the way to 39 (Which is the players inventory)
	//				//par4 is true, that means it will try to put it in the players hot-bar (All the ay at the bottom).
	//				if (!this.mergeItemStack(itemstack1, 3, 39, true))
	//				{
	//					//If that doesn't work, return null...
	//					return null
	//				}
	//
	//				//Declare the slot changed for the server and client...
	//				slot.onSlotChange(itemstack1, itemstack)
	//			}
	//			//This means if the slot clicked isn't the raw slot, or not the fuel slot (meaning it's the inventory slot)
	//			else if (slotClicked != 1 && slotClicked != 0)
	//			{
	//				//This means if it could be cooked in a furnace
	//				if (FurnaceRecipes.smelting().getSmeltingResult(itemstack1) != null)
	//				{
	//					//This is trying to put it in the first (raw) slot.
	//					if (!this.mergeItemStack(itemstack1, 0, 1, false))
	//					{
	//						//If that doesn't work, return null...
	//						return null
	//					}
	//				}
	//				//This means if it is fuel for the furnace
	//				else if (TileEntityFurnace.isItemFuel(itemstack1))
	//				{
	//					//This is trying to put it in the second (fuel) slot.
	//					if (!this.mergeItemStack(itemstack1, 1, 2, false))
	//					{
	//						//If that doesn't work, return null...
	//						return null
	//					}
	//				}
	//				//If it's not fuel, and can't be cooked, but it's in the inventory, not the hot-bar
	//				else if (slotClicked >= 3 && slotClicked < 30)
	//				{
	//					//Just re place it in the inventory, not the hot-bar
	//					if (!this.mergeItemStack(itemstack1, 30, 39, false))
	//					{
	//						//If that doesn't work, return null...
	//						return null
	//					}
	//				}
	//				//If it's not fuel, and can't be cooked and it's in the hot-bar
	//				else if (slotClicked >= 30 && slotClicked < 39)
	//				{
	//					//Try to place it in the inventory, not the hot-bar
	//					if (!this.mergeItemStack(itemstack1, 3, 30, false))
	//					{
	//						//If that doesn't work, return null...
	//						return null
	//					}
	//				}
	//			}
	//			//If all else fails, try to put it somewhere in the inventory...
	//			else if (!this.mergeItemStack(itemstack1, 3, 39, false))
	//			{
	//				//If that doesn't work, return null...
	//				return null
	//			}
	//
	//			//If it's stack size is 0, set it to null...
	//			if (itemstack1.stackSize == 0)
	//			{
	//				slot.putStack(null)
	//			}
	//			else
	//			{
	//				slot.onSlotChanged()
	//			}
	//
	//			//If the stack sizes are equal, meaning the whole stack was transferred over, set it to null
	//			if (itemstack1.stackSize == itemstack.stackSize)
	//			{
	//				return null
	//			}
	//
	//			slot.onPickupFromSlot(player, itemstack1)
	//		}
	//
	//		//Return it when it's all done!
	//		itemstack
	//	}
}
