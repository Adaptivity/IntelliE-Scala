package de.thatsich.minecraft.common.string


/**
 *
 *
 * @author thatsIch
 * @since 09.07.2014.
 */
trait StringWrapper
{
	protected val wrapped: String
}

object StringWrapper
{
	implicit def wrapperToString(wrapper: StringWrapper): String =
	{
		wrapper.wrapped
	}
}
