package moe.plushie.armourers_workshop.compatibility.fabric;

import com.mojang.brigadier.CommandDispatcher;
import moe.plushie.armourers_workshop.compatibility.fabric.v1618.FabricCommonExt_V1618;
import moe.plushie.armourers_workshop.compatibility.v1618.CommonNativeExt_V1618;
import moe.plushie.armourers_workshop.init.platform.fabric.provider.FabricCommonNativeProvider;
import net.fabricmc.fabric.api.command.v1.CommandRegistrationCallback;
import net.minecraft.commands.CommandSourceStack;

import java.util.function.Consumer;

public class AbstractFabricCommonNativeImpl implements FabricCommonNativeProvider, CommonNativeExt_V1618, FabricCommonExt_V1618 {

    @Override
    public void willRegisterCommand(Consumer<CommandDispatcher<CommandSourceStack>> consumer) {
        CommandRegistrationCallback.EVENT.register((dispatcher, dedicated) -> consumer.accept(dispatcher));
    }
}
