package com.uramnoil.economyk

import cn.nukkit.event.player.PlayerJoinEvent
import cn.nukkit.plugin.PluginBase
import cn.nukkit.plugin.service.ServicePriority
import com.uramnoil.economyk.event.AccountCreationEvent
import com.uramnoil.knukkitutils.plugin.on
import com.uramnoil.knukkitutils.plugin.service.register
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class EconomyKPlugin : PluginBase() {
	private lateinit var service: EconomyService

	override fun onEnable() {
		server.serviceManager.register<EconomyK>(service, this, ServicePriority.NORMAL)

		service = EconomyService()
		service.open()

		on<PlayerJoinEvent> {
			service.launch {
				val a = it.player.getMoneyAsync().await()
				if (!service.exists(it.player)) {
					val event = AccountCreationEvent(it.player)
					server.pluginManager.callEvent(event)
					service.create(it.player, event.defaultAmount)
				}
			}
		}
	}

	override fun onDisable() {
		service.close()
	}
}