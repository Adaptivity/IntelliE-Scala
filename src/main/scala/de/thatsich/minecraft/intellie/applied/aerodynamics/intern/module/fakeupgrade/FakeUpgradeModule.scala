package de.thatsich.minecraft.intellie.applied.aerodynamics.intern.module.fakeupgrade


import de.thatsich.minecraft.common.log.Log
import de.thatsich.minecraft.common.module.BaseModule
import de.thatsich.minecraft.common.string.id.ID
import de.thatsich.minecraft.intellie.applied.aerodynamics.intern.module.fakeupgrade.item.fake.{ChargeSpeedItem, CurrentEnergyStorage, DamageVsEntites, EnergyCostItem, MaxEnergyStorage, MiningLevel, MiningSpeed}


/**
 *
 *
 * @author thatsIch
 * @since 12.08.2014.
 */
class FakeUpgradeModule(log: Log, modid: ID) extends BaseModule(
	items = Vector(
		new EnergyCostItem(modid, log),
		new ChargeSpeedItem(modid, log),
		new CurrentEnergyStorage(modid, log),
		new DamageVsEntites(modid, log),
		new MaxEnergyStorage(modid, log),
		new MiningLevel(modid, log),
		new MiningSpeed(modid, log)
	)
)