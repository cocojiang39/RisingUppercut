package love.marblegate.risinguppercut.network;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.network.NetworkRegistry;
import net.minecraftforge.fml.network.simple.SimpleChannel;


public class Networking {
    public static SimpleChannel INSTANCE;
    public static final String VERSION = "1.0";
    private static int ID = 0;

    public static int nextID() {
        return ID++;
    }

    public static void registerMessage() {
        INSTANCE = NetworkRegistry.newSimpleChannel(
                new ResourceLocation("rising_uppercut", "mod_networking"),
                () -> VERSION,
                (version) -> version.equals(VERSION),
                (version) -> version.equals(VERSION)
        );
        INSTANCE.registerMessage(
                nextID(),
                PacketRocketPunch.class,
                PacketRocketPunch::toBytes,
                PacketRocketPunch::new,
                PacketRocketPunch::handle
        );
    }
}
