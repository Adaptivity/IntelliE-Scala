package de.thatsich.minecraft.intellie.applied.aerodynamics.intern.module.dissembler


import appeng.api.config.AccessRestriction
import appeng.api.implementations.items.IAEItemPowerStorage
import net.minecraft.item.ItemStack


/**
 *
 *
 * @author thatsIch
 * @since 31.07.2014.
 */
private[dissembler] trait AEPowerStorage extends IAEItemPowerStorage
                                                 with NBTAccess
                                                 with DissemblerConfigAccess
{
	private final val internalCurrentPower = "internalCurrentPower"
	private final val internalMaxPower = "internalMaxPower"

	def addAEMaxPower(is: ItemStack, amt: Double): Double =
	{
		val max: Double = this.getAEMaxPower(is)
		this.setAEMaxPower(is, max + amt)

		max + amt
	}

	def injectAEPower(is: ItemStack, amt: Double): Double =
	{
		val currentStorage = this.getAECurrentPower(is)
		val maxStorage = this.getAEMaxPower(is)
		val newStorage = Math.min(maxStorage, currentStorage + this.chargePerTick)
		val diff = maxStorage - newStorage
		this.setAECurrentPower(is, newStorage)

		diff
	}

	def getAEMaxPower(is: ItemStack): Double =
	{
		val tag = this.getNBTData(is)
		val maxStorage = tag.getDouble(this.internalMaxPower)

		maxStorage
	}

	def setAEMaxPower(is: ItemStack, value: Double): Unit =
	{
		val tag = this.getNBTData(is)
		tag.setDouble(this.internalMaxPower, value)
	}

	def getPowerFlow(is: ItemStack): AccessRestriction = AccessRestriction.WRITE

	def extractAEPower(is: ItemStack, amt: Double): Double =
	{
		val currentStorage = this.getAECurrentPower(is)
		val newStorage = Math.max(0.0, currentStorage - amt)
		this.setAECurrentPower(is, newStorage)

		newStorage
	}

	def getAECurrentPower(is: ItemStack): Double =
	{
		val tag = this.getNBTData(is)
		val currentStorage = tag.getDouble(this.internalCurrentPower)

		currentStorage
	}

	private def setAECurrentPower(is: ItemStack, value: Double): Unit =
	{
		val tag = this.getNBTData(is)
		tag.setDouble(this.internalCurrentPower, value)
	}
}
