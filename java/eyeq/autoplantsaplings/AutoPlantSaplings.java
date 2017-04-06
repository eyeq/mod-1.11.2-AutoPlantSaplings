package eyeq.autoplantsaplings;

import eyeq.autoplantsaplings.event.AutoPlantSaplingsEventHandler;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import static eyeq.autoplantsaplings.AutoPlantSaplings.MOD_ID;

@Mod(modid = MOD_ID, version = "1.0", dependencies = "after:eyeq_util")
public class AutoPlantSaplings {
    public static final String MOD_ID = "eyeq_autoplantsaplings";

    @Mod.Instance(MOD_ID)
    public static AutoPlantSaplings instance;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(new AutoPlantSaplingsEventHandler());
    }
}
