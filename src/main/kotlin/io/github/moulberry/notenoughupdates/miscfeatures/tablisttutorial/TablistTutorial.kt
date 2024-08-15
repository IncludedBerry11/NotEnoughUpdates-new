/*
 * Copyright (C) 2024 NotEnoughUpdates contributors
 *
 * This file is part of NotEnoughUpdates.
 *
 * NotEnoughUpdates is free software: you can redistribute it
 * and/or modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation, either
 * version 3 of the License, or (at your option) any later version.
 *
 * NotEnoughUpdates is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with NotEnoughUpdates. If not, see <https://www.gnu.org/licenses/>.
 */

package io.github.moulberry.notenoughupdates.miscfeatures.tablisttutorial

import com.mojang.brigadier.arguments.StringArgumentType.string
import io.github.moulberry.notenoughupdates.NotEnoughUpdates
import io.github.moulberry.notenoughupdates.autosubscribe.NEUAutoSubscribe
import io.github.moulberry.notenoughupdates.core.util.StringUtils
import io.github.moulberry.notenoughupdates.core.util.render.RenderUtils
import io.github.moulberry.notenoughupdates.events.RegisterBrigadierCommandEvent
import io.github.moulberry.notenoughupdates.mixins.AccessorGlStateManager
import io.github.moulberry.notenoughupdates.mixins.AccessorGuiContainer
import io.github.moulberry.notenoughupdates.util.ItemUtils
import io.github.moulberry.notenoughupdates.util.StateManagerUtils
import io.github.moulberry.notenoughupdates.util.brigadier.thenArgument
import io.github.moulberry.notenoughupdates.util.brigadier.thenExecute
import io.github.moulberry.notenoughupdates.util.brigadier.withHelp
import io.github.moulberry.notenoughupdates.util.stripControlCodes
import net.minecraft.client.Minecraft
import net.minecraft.client.gui.inventory.GuiChest
import net.minecraft.client.gui.inventory.GuiContainer
import net.minecraft.client.renderer.GlStateManager
import net.minecraft.inventory.ContainerChest
import net.minecraft.inventory.Slot
import net.minecraft.util.ResourceLocation
import net.minecraftforge.client.event.GuiScreenEvent
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent

@NEUAutoSubscribe
object TablistTutorial {
    data class TabListWidget(
        var regionName: String,
        val widgetName: TablistAPI.WidgetNames,
    )

    private object Arrow {
    }

    var activeTask: TabListWidget? = null

    @SubscribeEvent
    fun onGuiPostRender(event: GuiScreenEvent.DrawScreenEvent.Post) {
    }

    data class WidgetStatus(
        val widgetName: String,
        val enabled: Boolean,
        val slot: Slot,
    )

    fun findWidgets(chestInventory: ContainerChest): List<WidgetStatus> {
        return null
    }

    private fun drawEnableEffect(gui: GuiChest, chestInventory: ContainerChest, task: TabListWidget) {
    }

    /*{
        id: "minecraft:skull",
        Count: 1b,
        tag: {
            overrideMeta: 1b,
            HideFlags: 254,
            SkullOwner: {
                Id: "474a0574-24e5-4949-bf61-f8d06120815e",
                hypixelPopulated: 1b,
                Properties: {
                    textures: [{
                        Value: "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYzljODg4MWU0MjkxNWE5ZDI5YmI2MWExNmZiMjZkMDU5OTEzMjA0ZDI2NWRmNWI0MzliM2Q3OTJhY2Q1NiJ9fX0="
                    }]
                },
                Name: "§474a0574-24e5-4949-bf61-f8d06120815e"
            },
            display: {
                Lore: ["§7§3⬛               §3§lInfo", "§7§8⬛§f§b§lArea: §7Private Island", "§7§8⬛§f Server: §8mini4C", "§7§8⬛§f Gems: §a0", "§7§8⬛§f Crystals: §d3", "§7§8⬛§f", "§7§8⬛§f§b§lMinions§f: 27§7/§r28", "§7§8⬛§f 7x Ice VII §7[§aACTIVE§7]", "§7§8⬛§f 1x Acacia XI §7[§aACTIVE§7]", "§7§8⬛§f 1x Cave Spider XI §7[§aACTIVE§7]", "§7§8⬛§f 1x Cow XI §7[§aACTIVE§7]", "§7§8⬛§f 1x Creeper X §7[§aACTIVE§7]", "§7§8⬛§f 1x Fishing X §7[§aACTIVE§7]", "§7§8⬛§f 1x Ice XI §7[§aACTIVE§7]", "§7§8⬛§f 1x Iron XI §7[§aACTIVE§7]", "§7§8⬛§f 1x Jungle XI §7[§aACTIVE§7]", "§7§8⬛§f 1x Melon XI §7[§aACTIVE§7]", "§7§8⬛§f 1x Obsidian XI §7[§aACTIVE§7]", "§7§8⬛§f 1x Pig XI §7[§aACTIVE§7]", "§7§8⬛§f ... and 10 more."],
                Name: "§aPrivate Island Widgets Preview"
            },
            AttributeModifiers: []
        },
        Damage: 3s
    }*/
    fun drawPriorityClick(gui: GuiChest, chestInventory: ContainerChest, widget: WidgetStatus) {
    }

    fun getRegionName(label: String): String? {
        return null
    }

    private fun drawSelectAreaArrow(gui: GuiChest, inventory: ContainerChest, task: TabListWidget) {
    }

    @SubscribeEvent
    fun onCommands(event: RegisterBrigadierCommandEvent) {
    }
}
