package de.thatsich.minecraft.common.module.registry


import scala.util.hashing.MurmurHash3


/**
 * A hasher for blocks with guis
 * Uses the Murmur3 implementation of Scala
 *
 * @author thatsIch
 * @since 13.08.2014.
 */
trait BlockGuiHasher
{
	protected def hash(key: String): Int =
	{
		MurmurHash3.stringHash(key)
	}
}
