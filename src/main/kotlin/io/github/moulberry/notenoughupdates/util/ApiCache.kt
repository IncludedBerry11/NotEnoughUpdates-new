/*
 * Copyright (C) 2023 NotEnoughUpdates contributors
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

package io.github.moulberry.notenoughupdates.util

import io.github.moulberry.notenoughupdates.NotEnoughUpdates
import io.github.moulberry.notenoughupdates.options.customtypes.NEUDebugFlag
import io.github.moulberry.notenoughupdates.util.ApiUtil.Request
import io.github.moulberry.notenoughupdates.util.kotlin.supplyImmediate
import org.apache.http.NameValuePair
import java.nio.file.Files
import java.nio.file.Path
import java.time.Duration
import java.util.*
import java.util.concurrent.CompletableFuture
import java.util.function.Supplier
import kotlin.io.path.deleteIfExists
import kotlin.io.path.readText
import kotlin.io.path.writeText
import kotlin.time.Duration.Companion.hours
import kotlin.time.Duration.Companion.seconds
import kotlin.time.ExperimentalTime
import kotlin.time.TimeSource
import kotlin.time.toKotlinDuration

@OptIn(ExperimentalTime::class)

object ApiCache {
    data class CacheKey(
        val baseUrl: String,
        val requestParameters: List<NameValuePair>,
        val shouldGunzip: Boolean,
    )

    data class CacheResult internal constructor(
        var cacheState: CacheState,
        val firedAt: TimeSource.Monotonic.ValueTimeMark,
    ) {
        constructor(future: CompletableFuture<String>, firedAt: TimeSource.Monotonic.ValueTimeMark) : this(
            CacheState.WaitingForFuture(future),
            firedAt
        ) {
            future.thenAccept { text ->
                synchronized(this) {
                }
            }
        }

        sealed interface CacheState {
            object Disposed : CacheState
            data class WaitingForFuture(val future: CompletableFuture<String>) : CacheState
            data class FileCached(val file: Path) : CacheState
        }

        val isAvailable get() = cacheState is CacheState.FileCached

        /**
         * Should be called when removing / replacing a request from [cachedRequests].
         * Should only be called while holding a lock on [ApiCache].
         * This deletes the disk cache and smashes the internal state for it to be GCd.
         * After calling this method no other method may be called on this object.
         */
        internal fun dispose() {
        }
    }

    private val cacheBaseDir by lazy {
    }
    private val cachedRequests = mutableMapOf<CacheKey, CacheResult>()
    val histogramTotalRequests: MutableMap<String, Int> = mutableMapOf()
    val histogramNonCachedRequests: MutableMap<String, Int> = mutableMapOf()

    private val timeout = 10.seconds
    private val globalMaxCacheAge = 1.hours

    private fun log(message: String) {
        NEUDebugFlag.API_CACHE.log(message)
    }

    private fun traceApiRequest(
        request: Request,
        failReason: String?,
    ) {
    }

    fun clear() {
    }

    private fun evictCache() {
    }

    fun cacheRequest(
        request: Request,
        cacheKey: CacheKey?,
        futureSupplier: Supplier<CompletableFuture<String>>,
        maxAge: Duration?
    ): {
    }
}
