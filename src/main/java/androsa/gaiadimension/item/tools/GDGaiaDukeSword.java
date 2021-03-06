package androsa.gaiadimension.item.tools;

import androsa.gaiadimension.registry.GDTabs;
import androsa.gaiadimension.registry.ModelRegisterCallback;
import com.google.common.collect.Multimap;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nonnull;
import java.util.List;

public class GDGaiaDukeSword extends ItemSword implements ModelRegisterCallback {

    public GDGaiaDukeSword(Item.ToolMaterial material) {
        super(material);
        this.setCreativeTab(GDTabs.tabTool);
        this.setMaxStackSize(1);
    }

    @Override
    @Nonnull
    public EnumRarity getRarity(ItemStack stack) {
        return EnumRarity.RARE;
    }

    @Override
    @Nonnull
    public String getItemStackDisplayName(ItemStack par1ItemStack) {

        return TextFormatting.BLUE + super.getItemStackDisplayName(par1ItemStack);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, World world, List<String> tooltips, ITooltipFlag flags) {
        super.addInformation(stack, world, tooltips, flags);
        tooltips.add(I18n.format(getTranslationKey() + ".tooltip"));
    }

    //TODO: Deals extra damage to Gaian mobs
    //TODO: [FUTURE] Can be used to unlock Unknown Stage 4 Final Boss Structure

    //We will need this in order to make the weapon slow
    @Override
    @Nonnull
    public Multimap<String, AttributeModifier> getItemAttributeModifiers(EntityEquipmentSlot equipmentSlot) {
        Multimap<String, AttributeModifier> multimap = super.getItemAttributeModifiers(equipmentSlot);

        if (equipmentSlot == EntityEquipmentSlot.MAINHAND) {
            multimap.removeAll(SharedMonsterAttributes.ATTACK_SPEED.getName()); //This is not our speed anymore

            multimap.put(SharedMonsterAttributes.ATTACK_SPEED.getName(), new AttributeModifier(ATTACK_SPEED_MODIFIER, "Weapon modifier", -3, 0)); //Speed is set to 1; 0.6 less than normal
        }

        return multimap;
    }
}
