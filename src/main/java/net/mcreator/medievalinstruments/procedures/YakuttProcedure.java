package net.mcreator.medievalinstruments.procedures;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.IWorld;
import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.medievalinstruments.item.YakutringItem;
import net.mcreator.medievalinstruments.MedievalInstrumentsModElements;
import net.mcreator.medievalinstruments.MedievalInstrumentsMod;

import java.util.Map;
import java.util.HashMap;

@MedievalInstrumentsModElements.ModElement.Tag
public class YakuttProcedure extends MedievalInstrumentsModElements.ModElement {
	public YakuttProcedure(MedievalInstrumentsModElements instance) {
		super(instance, 20);
		MinecraftForge.EVENT_BUS.register(this);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				MedievalInstrumentsMod.LOGGER.warn("Failed to load dependency entity for procedure Yakutt!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (((entity instanceof PlayerEntity)
				? ((PlayerEntity) entity).inventory.hasItemStack(new ItemStack(YakutringItem.block, (int) (1)))
				: false)) {
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.INSTANT_HEALTH, (int) 5, (int) 10, (false), (true)));
		}
	}

	@SubscribeEvent
	public void onRightClickItem(PlayerInteractEvent.RightClickItem event) {
		PlayerEntity entity = event.getPlayer();
		if (event.getHand() != entity.getActiveHand()) {
			return;
		}
		double i = event.getPos().getX();
		double j = event.getPos().getY();
		double k = event.getPos().getZ();
		IWorld world = event.getWorld();
		Map<String, Object> dependencies = new HashMap<>();
		dependencies.put("x", i);
		dependencies.put("y", j);
		dependencies.put("z", k);
		dependencies.put("world", world);
		dependencies.put("entity", entity);
		dependencies.put("event", event);
		this.executeProcedure(dependencies);
	}
}
