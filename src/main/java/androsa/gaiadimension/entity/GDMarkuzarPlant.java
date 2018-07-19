package androsa.gaiadimension.entity;

import androsa.gaiadimension.registry.GDBiomes;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.MoverType;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.passive.IAnimals;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class GDMarkuzarPlant extends EntityCreature implements IAnimals {

    public GDMarkuzarPlant(World world) {
        super(world);

        this.setSize(0.6F, 2.0F);
    }

    @Override
    protected final void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(40.0D);
        this.getEntityAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).setBaseValue(1.0D); //How far should this go?
    }

    @Override
    public void knockBack(Entity entity, float distance, double x, double y)
    {
    }

    @Override
    public void move(MoverType type, double x, double y, double z)
    {
        if (type == MoverType.PISTON)
        {
            super.move(type, x, y, z);
        }
    }


    @Override
    public boolean getCanSpawnHere() {
        return world.getBiome(new BlockPos(this)) == GDBiomes.green_agate_jungle;
    }
}
