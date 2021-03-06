package de.thatsich.minecraft.intellie.applied.aerodynamics.proxy.module.suite.common.item


import cpw.mods.fml.client.registry.ClientRegistry
import cpw.mods.fml.common.eventhandler.SubscribeEvent
import cpw.mods.fml.common.gameevent.InputEvent
import cpw.mods.fml.relauncher.{Side, SideOnly}
import net.minecraft.client.settings.KeyBinding
import org.lwjgl.input.Keyboard


object KeyHandler
{
	private final val FLY_KEY: Int = Keyboard.KEY_G
	private final val BINDING: KeyBinding = new KeyBinding("description", KeyHandler.FLY_KEY, "FLY_KEY.category")
}

/**
 *
 *
 * @author thatsIch
 * @since 07.04.2014.
 */
class KeyHandler
{
	ClientRegistry.registerKeyBinding(KeyHandler.BINDING)

	@SideOnly(Side.CLIENT)
	@SubscribeEvent
	def onKeyInput(event: InputEvent.KeyInputEvent): Unit =
	{
		if (KeyHandler.BINDING.isPressed)
		{
			System.out.println("PRESSED")
		}
	}
}
