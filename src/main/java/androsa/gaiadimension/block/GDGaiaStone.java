package androsa.gaiadimension.block;

import androsa.gaiadimension.registry.GDTabs;
import androsa.gaiadimension.registry.ModelRegisterCallback;
import net.minecraft.block.Block;
import net.minecraft.block.BlockStone;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.util.IStringSerializable;

import java.util.Locale;

public class GDGaiaStone extends Block implements ModelRegisterCallback {

    public GDGaiaStone() {
        super(Material.ROCK);

        this.setHardness(2.0F);
        this.setResistance(15.0F);
        this.setCreativeTab(GDTabs.tabBlock);
    }
}
