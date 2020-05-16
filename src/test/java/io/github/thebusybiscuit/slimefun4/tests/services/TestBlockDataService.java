package io.github.thebusybiscuit.slimefun4.tests.services;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import be.seeseemelk.mockbukkit.MockBukkit;
import io.github.thebusybiscuit.slimefun4.core.services.BlockDataService;
import me.mrCookieSlime.Slimefun.SlimefunPlugin;

public class TestBlockDataService {

    private static SlimefunPlugin plugin;

    @BeforeAll
    public static void load() {
        MockBukkit.mock();
        plugin = MockBukkit.load(SlimefunPlugin.class);
    }

    @AfterAll
    public static void unload() {
        MockBukkit.unmock();
    }

    @Test
    public void testInitialization() {
        BlockDataService service = new BlockDataService(plugin, "test");
        Assertions.assertEquals(new NamespacedKey(plugin, "test"), service.getKey());
    }

    @Test
    public void testTileEntities() {
        BlockDataService service = new BlockDataService(plugin, "test");

        Assertions.assertFalse(service.isTileEntity(null));
        Assertions.assertFalse(service.isTileEntity(Material.AIR));
        Assertions.assertFalse(service.isTileEntity(Material.DIRT));

        Assertions.assertTrue(service.isTileEntity(Material.CHEST));
        Assertions.assertTrue(service.isTileEntity(Material.ENDER_CHEST));
        Assertions.assertTrue(service.isTileEntity(Material.ENCHANTING_TABLE));
        Assertions.assertTrue(service.isTileEntity(Material.DISPENSER));
        Assertions.assertTrue(service.isTileEntity(Material.FURNACE));
        Assertions.assertTrue(service.isTileEntity(Material.PLAYER_HEAD));
        Assertions.assertTrue(service.isTileEntity(Material.PLAYER_WALL_HEAD));
    }
}