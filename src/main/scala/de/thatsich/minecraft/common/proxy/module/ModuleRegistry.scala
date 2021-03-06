package de.thatsich.minecraft.common.proxy.module


import appeng.api.recipes.ICraftHandler
import de.thatsich.minecraft.common.log.Log
import de.thatsich.minecraft.common.proxy.module.registry.{BlockRegistry, CraftHandlerRegistry, EntityRegistry, FakeItemRegistry, GuiRegistry, ItemRegistry, RecipeRegistry, TileEntityRegistry}
import de.thatsich.minecraft.common.util.string.ID
import de.thatsich.minecraft.common.{Definitions, Module, Modules, Recipe}
import net.minecraft.block.Block
import net.minecraft.entity.Entity
import net.minecraft.item.Item
import net.minecraft.tileentity.TileEntity

import scala.collection._


/**
 *
 *
 * @author thatsIch
 * @since 02.09.2014.
 */
class ModuleRegistry(modules: Modules, modid: ID, log: Log)
{
	val blocks = mutable.ArrayBuffer[Block]()
	val crafts = mutable.ArrayBuffer[Class[_ <: ICraftHandler]]()
	val entities = mutable.ArrayBuffer[Entity]()
	val fakes = mutable.ArrayBuffer[Item]()
	val guis = mutable.ArrayBuffer[BlockGuiHandler]()
	val items = mutable.ArrayBuffer[Item]()
	val recipes = mutable.ArrayBuffer[Recipe]()
	val tiles = mutable.ArrayBuffer[Class[_ <: TileEntity]]()

	this.modules.vectorized.foreach(this.addModule)

	val blockRegistry = new BlockRegistry(this.blocks, this.log)
	val craftRegistry = new CraftHandlerRegistry(this.crafts, this.log)
	val entityRegistry = new EntityRegistry(this.entities, this.log)
	val fakeRegistry = new FakeItemRegistry(this.fakes, this.modid, this.log)
	val guiRegistry = new GuiRegistry(this.guis, this.log)
	val itemRegistry = new ItemRegistry(this.items, this.modid, this.log)
	val recipeRegistry = new RecipeRegistry(this.recipes, this.log)
	val tileRegistry = new TileEntityRegistry(this.tiles, this.log)

	private def addModule(module: Module): Unit =
	{
		val definitions: Definitions = module.definitions

		this.blocks ++= definitions.blocks
		this.crafts ++= definitions.crafthandlers
		this.entities ++= definitions.entites
		this.fakes ++= definitions.fakes
		this.guis ++= definitions.guis
		this.items ++= definitions.items
		this.recipes ++= definitions.recipes
		this.tiles ++= definitions.tiles

		definitions.modules.foreach(this.addModule)
	}
}
