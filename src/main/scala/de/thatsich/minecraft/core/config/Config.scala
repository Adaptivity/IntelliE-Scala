package de.thatsich.minecraft.core.config

import java.io.File
import net.minecraftforge.common.config.Configuration

/**
 *
 *
 * @author thatsIch
 * @since 04.04.2014.
 */
class Config( val configPath: String )
	extends IConfig
{
	private val config = new Configuration( new File( this.configPath ) )

	def save( ): Unit =
	{
		if( this.config.hasChanged )
		{
			this.config.save( )
		}
	}

	def getBoolean( category: String, key: String, defaultValue: Boolean ): Boolean =
	{
		this.config.get( category, key, defaultValue ).getBoolean( defaultValue )
	}

	def getBooleanList( category: String, key: String, defaultValue: Array[ Boolean ] ): Array[ Boolean ] =
	{
		this.config.get( category, key, defaultValue ).getBooleanList
	}

	def getDouble( category: String, key: String, defaultValue: Double ): Double =
	{
		this.config.get( category, key, defaultValue ).getDouble( defaultValue )
	}

	def getDoubleList( category: String, key: String, defaultValue: Array[ Double ] ): Array[ Double ] =
	{
		this.config.get( category, key, defaultValue ).getDoubleList
	}

	def getInt( category: String, key: String, defaultValue: Int ): Int =
	{
		this.config.get( category, key, defaultValue ).getInt
	}

	def getIntList( category: String, key: String, defaultValue: Array[ Int ] ): Array[ Int ] =
	{
		this.config.get( category, key, defaultValue ).getIntList
	}

	def getString( category: String, key: String, defaultValue: String ): String =
	{
		this.config.get( category, key, defaultValue ).getString
	}

	def getStringList( category: String, key: String, defaultValue: Array[ String ] ): Array[ String ] =
	{
		this.config.get( category, key, defaultValue ).getStringList
	}
}
