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

import io.github.moulberry.notenoughupdates.util.NotificationHandler
import io.github.moulberry.notenoughupdates.util.SBInfo

object TablistTaskQueue {
    private val queue = mutableListOf<TablistTutorial.TabListWidget>()

    private val blacklistedLocations = setOf("dungeon", "kuudra")

    fun addToQueue(task: TablistTutorial.TabListWidget, showNotification: Boolean) {
        if (showNotification && !queueContainsElements() && !blacklistedLocations.contains(SBInfo.getInstance().mode)) {
        }
        if (task !in queue) {
            // see todo in MiningOverlay.java:377
//            Utils.addChatMessage("Adding $task")
            queue.add(task)
        }
    }

    fun removeFromQueue(task: TablistTutorial.TabListWidget) {
        queue.remove(task)
    }

    fun queueContainsElements(): Boolean {
        return queue.isNotEmpty()
    }

    fun getNextQueueItem(): TablistTutorial.TabListWidget? {
        return if (!queueContainsElements()) {
            null
        } else {
            queue.removeLast()
        }
    }
}
