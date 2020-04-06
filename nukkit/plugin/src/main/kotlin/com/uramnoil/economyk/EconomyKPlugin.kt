package com.uramnoil.economyk

import cn.nukkit.plugin.PluginBase
import cn.nukkit.plugin.service.ServicePriority
import com.uramnoil.knukkitutils.plugin.service.register

class EconomyKPlugin : PluginBase() {
    override fun onEnable() {
        server.serviceManager.register<EconomyK>(EconomyService(), this, ServicePriority.NORMAL)
    }
}
