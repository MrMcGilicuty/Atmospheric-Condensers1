package com.MrMc.atmospheric_condensers.init.screen;

import com.MrMc.atmospheric_condensers.AtmosphericCondensers;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.network.IContainerFactory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModMenuTypes {
    public static final DeferredRegister<MenuType<?>> MENUS =
            DeferredRegister.create(ForgeRegistries.CONTAINERS, AtmosphericCondensers.MOD_ID);

    public static final RegistryObject<MenuType<TransistorFactoryMenu>> TRANSISTOR_FACTORY_MENU =
            registerMenuType(TransistorFactoryMenu::new, "transistor_factory_menu");

    public static final RegistryObject<MenuType<CircuitPressMenu>> CIRCUIT_PRESS_MENU =
            registerMenuType(CircuitPressMenu::new, "circuit_press_menu");

    public static final RegistryObject<MenuType<CondenserHousingMenu>> CONDENSER_HOUSING_MENU =
            registerMenuType(CondenserHousingMenu::new, "condenser_housing_menu");

    private static <T extends AbstractContainerMenu>RegistryObject<MenuType<T>> registerMenuType(IContainerFactory<T> factory, String name) {
        return MENUS.register(name, () -> IForgeMenuType.create(factory));
    }

    public static void register(IEventBus eventBus) {
        MENUS.register(eventBus);
    }
}
