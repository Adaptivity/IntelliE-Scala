package de.thatsich.minecraft.intellie.applied.aerodynamics.intern.functional.dissembler

import cpw.mods.fml.common.eventhandler.{EventPriority, SubscribeEvent}
import net.minecraftforge.client.event.MouseEvent
import net.minecraftforge.common.MinecraftForge

/**
 *
 *
 * @author thatsIch
 * @since 29.07.2014.
 */
trait ListensToMouse
{
	MinecraftForge.EVENT_BUS.register( this )

	var notInUse = true

	/**
	 * set notInUse to true if right mouse button is released
	 *
	 * @param event mouse event
	 */
	@SubscribeEvent( priority = EventPriority.LOWEST )
	def onMouseEvent( event: MouseEvent ): Unit =
	{
		if( event.button != -1 && !event.buttonstate )
		{
			this.notInUse = true
		}
	}
}
