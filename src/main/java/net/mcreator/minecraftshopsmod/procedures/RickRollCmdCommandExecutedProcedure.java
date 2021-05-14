package net.mcreator.minecraftshopsmod.procedures;

@MinecraftShopsModModElements.ModElement.Tag
public class RickRollCmdCommandExecutedProcedure extends MinecraftShopsModModElements.ModElement {

	public RickRollCmdCommandExecutedProcedure(MinecraftShopsModModElements instance) {
		super(instance, 15);

	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				MinecraftShopsModMod.LOGGER.warn("Failed to load dependency entity for procedure RickRollCmdCommandExecuted!");
			return;
		}

		Entity entity = (Entity) dependencies.get("entity");

		{
			Entity _ent = entity;
			if (!_ent.world.isRemote && _ent.world.getServer() != null) {
				_ent.world.getServer().getCommandManager().handleCommand(_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
						"/say Never gonna give you up");
			}
		}

	}

}
