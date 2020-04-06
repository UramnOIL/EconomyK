package com.uramnoil.economyk

import cn.nukkit.event.player.PlayerAsyncPreLoginEvent
import cn.nukkit.event.player.PlayerJoinEvent
import cn.nukkit.plugin.PluginBase
import cn.nukkit.plugin.service.ServicePriority
import com.uramnoil.economyk.event.AccountCreationEvent
import com.uramnoil.knukkitutils.plugin.on
import com.uramnoil.knukkitutils.plugin.service.register
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class EconomyKPlugin : PluginBase(), CoroutineScope {
    private val job = Job()
    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + job

    private lateinit var service: EconomyService

    override fun onEnable() {
        server.serviceManager.register<EconomyK>(service, this, ServicePriority.NORMAL)

        service = EconomyService()
        service.open()

        on<PlayerJoinEvent> {
            launch {
                if (!service.exists(it.player)) {
                    val event = AccountCreationEvent(it.player)
                    server.pluginManager.callEvent(event)
                    service.new(it.player)
                }
            }
        }
    }

    override fun onDisable() {
        service.save()
        job.isCompleted
    }
}