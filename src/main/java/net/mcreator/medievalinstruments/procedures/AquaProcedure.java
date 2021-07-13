package net.mcreator.medievalinstruments.procedures;

import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.medievalinstruments.item.AkuamarinringItem;
import net.mcreator.medievalinstruments.MedievalInstrumentsModElements;
import net.mcreator.medievalinstruments.MedievalInstrumentsMod;

import java.util.Map;

@MedievalInstrumentsModElements.ModElement.Tag
public class AquaProcedure extends MedievalInstrumentsModElements.ModElement {
	public AquaProcedure(MedievalInstrumentsModElements instance) {
		super(instance, 19);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("sourceentity") == null) {
			if (!dependencies.containsKey("sourceentity"))
				MedievalInstrumentsMod.LOGGER.warn("Failed to load dependency sourceentity for procedure Aqua!");
			return;
		}
		Entity sourceentity = (Entity) dependencies.get("sourceentity");
		if (((sourceentity instanceof PlayerEntity)
				? ((PlayerEntity) sourceentity).inventory.hasItemStack(new ItemStack(AkuamarinringItem.block, (int) (1)))
				: false)) {
			if (sourceentity instanceof LivingEntity)
				((LivingEntity) sourceentity).addPotionEffect(new EffectInstance(Effects.WATER_BREATHING, (int) 60, (int) 60, (false), (true)));
		}
	}
}
