package de.thatsich.intellie.common.registries;

import cpw.mods.fml.common.registry.GameRegistry;
import de.thatsich.intellie.common.module.block.ABlock;
import de.thatsich.intellie.common.module.block.IBlock;
import de.thatsich.intellie.common.util.logging.ILog;
import net.minecraftforge.common.config.Configuration;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.Collection;
import java.util.LinkedList;


/**
 Handles the registration of blocks and their names.
 This class is used by the framework and does not need
 to be instantiated or used in any way.
 */
@Singleton
public class BlockRegistry implements IRegistry
{
	private final Collection<IBlock> blocks;
	private final ILog log;

	/**
	 CTOR

	 @param log Logger
	 */
	@Inject
	public BlockRegistry ( final ILog log )
	{
		this.log = log;
		this.blocks = new LinkedList<>();
	}

	/**
	 Adds a new block to be registered and named.
	 Is getting called automatically by the module class

	 @param block new to be added block.
	 */
	public void addBlock ( final IBlock block )
	{
		this.blocks.add( block );
		this.log.debug( "Added Block %s", block );
	}

	public void loadConfig ( final Configuration config )
	{
		this.log.info( "Loaded Configuration %s", config );
	}

	@Override
	public void register ()
	{
		for ( IBlock block : this.blocks )
		{
			ABlock concreteBlock = (ABlock) block;
			final String unlocalizedName = concreteBlock.getUnlocalizedName();
			GameRegistry.registerBlock( concreteBlock, unlocalizedName );
			this.log.debug( "Registered block with %s, %s", block, unlocalizedName );
		}
		this.log.info( "Finished registering Blocks and BlockContainer." );
	}
}
