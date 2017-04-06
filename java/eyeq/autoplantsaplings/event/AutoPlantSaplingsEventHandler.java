package eyeq.autoplantsaplings.event;

import eyeq.util.oredict.UOreDictionary;
import net.minecraft.block.Block;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.item.ItemExpireEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class AutoPlantSaplingsEventHandler {
    @SubscribeEvent
    public void onEntityItemExpire(ItemExpireEvent event) {
        EntityItem entity = event.getEntityItem();
        World world = entity.getEntityWorld();
        if(world.isRemote) {
            return;
        }
        ItemStack itemStack = entity.getEntityItem();
        if(itemStack.getCount() < 1) {
            return;
        }
        if(!UOreDictionary.contains(itemStack, UOreDictionary.OREDICT_SAPLING)) {
            return;
        }
        Block sapling = Block.getBlockFromItem(itemStack.getItem());
        BlockPos pos = entity.getPosition();
        if(sapling.canPlaceBlockAt(world, pos)) {
            itemStack.shrink(-1);
            world.setBlockState(pos, sapling.getStateFromMeta(itemStack.getMetadata()));
        }
    }
}
