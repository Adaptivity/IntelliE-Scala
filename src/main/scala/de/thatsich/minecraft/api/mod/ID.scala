package de.thatsich.minecraft.api.mod

/**
 *
 *
 * @author thatsIch
 * @since 09.07.2014.
 */
trait ID extends StringWrapper
{
	val id: String = this.wrapped
}