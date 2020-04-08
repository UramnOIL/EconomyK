package com.uramnoil.economyk

import cn.nukkit.event.player.PlayerJoinEvent
import cn.nukkit.plugin.PluginBase
import cn.nukkit.plugin.service.ServicePriority
import com.uramnoil.economyk.event.AccountCreationEvent
import com.uramnoil.knukkitutils.plugin.on
import com.uramnoil.knukkitutils.plugin.service.register

class EconomyKPlugin : PluginBase() {
	private lateinit var service: EconomyKService

	@ExperimentalUnsignedTypes
	override fun onEnable() {
		server.serviceManager.register<EconomyK>(service, this, ServicePriority.NORMAL)

		service = EconomyKService()
		service.open()

		on<PlayerJoinEvent> {
			service.transaction {
				if (service.existsAsync(it.player).await()) {
					val event = AccountCreationEvent(it.player)
					server.pluginManager.callEvent(event)
					service.createAsync(it.player, event.defaultAmount)
				}
			}
		}
	}

	override fun onDisable() {
		service.close()
	}
}