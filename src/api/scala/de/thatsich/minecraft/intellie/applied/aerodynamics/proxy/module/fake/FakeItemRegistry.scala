package de.thatsich.minecraft.intellie.applied.aerodynamics.proxy.module.fake


/**
 * 
 *
 * @author thatsIch
 * @since 08.09.2014.
 */
trait FakeItemRegistry
{
	def fakes: Set[FakeItem]

	def addFake(fake: FakeItem): Unit
}