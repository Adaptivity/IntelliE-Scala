package de.thatsich.minecraft.common.module


import appeng.api.recipes.ICraftHandler
import de.thatsich.minecraft.common.log.Log
import de.thatsich.minecraft.common.module.gui.BlockGuiHandler
import de.thatsich.minecraft.common.module.recipe.Recipe
import de.thatsich.minecraft.common.module.registry.{BlockRegistry, CraftHandlerRegistry, EntityRegistry, GuiRegistry, ItemRegistry, RecipeRegistry, TileEntityRegistry}
import net.minecraft.block.Block
import net.minecraft.entity.Entity
import net.minecraft.item.Item
import net.minecraft.tileentity.TileEntity


/**
 *
 *
 * @author thatsIch
 * @since 02.09.2014.
 */
class ModuleRegistry(registrable: Seq[Module], log: Log)
{
	private val blocks = Seq[Block]()
	private val crafts = Seq[Class[_ <: ICraftHandler]]()
	private val entities = Seq[Entity]()
	private val guis = Seq[BlockGuiHandler]()
	private val items = Seq[Item]()
	private val recipes = Seq[Recipe]()
	private val tiles = Seq[Class[_ <: TileEntity]]()

	this.registrable.foreach(this.addModule)

	val blockRegistry = new BlockRegistry(this.blocks, this.log)
	val craftRegistry = new CraftHandlerRegistry(this.crafts, this.log)
	val entityRegistry = new EntityRegistry(this.entities, this.log)
	val guiRegistry = new GuiRegistry(this.guis, this.log)
	val itemRegistry = new ItemRegistry(this.items, this.log)
	val recipeRegistry = new RecipeRegistry(this.recipes, this.log)
	val tileRegistry = new TileEntityRegistry(this.tiles, this.log)

	private def addModule(module: Module): Unit =
	{
		this.blocks ++ module.blocks
		this.items ++ module.items
		this.guis ++ module.guis
		this.recipes ++ module.recipes
		this.tiles ++ module.tiles
		this.crafts ++ module.crafthandlers
		this.entities ++ module.entites

		module.modules.foreach(this.addModule)
	}
}