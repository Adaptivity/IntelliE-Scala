package de.thatsich.minecraft.intellie.common

import com.google.common.base.Joiner
import java.io.File
import de.thatsich.minecraft.core.config.Config

/**
 *
 *
 * @author thatsIch
 * @since 05.04.2014.
 */
trait TIntelliConfig
{
	private val modName = this.getClass.getSimpleName
	private val configPath = Joiner.on(File.separatorChar).join("config", "AppliedEnergistics2", "IntelliE", this.modName + ".cfg")
	private val config = new Config(this.configPath)

	protected val disableAero = this.config.getBoolean("ChildMods", "disableAppliedAerodynamics", defaultValue = false)
	protected val disableAgro = this.config.getBoolean("ChildMods", "disableAppliedAgricultures", defaultValue = false)
	protected val disableInt = this.config.getBoolean("ChildMods", "disableAppliedIntelligences", defaultValue = false)

	this.config.save()
}