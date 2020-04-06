package com.uramnoil.economyk

import cn.nukkit.IPlayer
import cn.nukkit.Player
import cn.nukkit.Server
import com.uramnoil.knukkitutils.plugin.service.getProvider

val IPlayer.money: Account
	get() = Server.getInstance().serviceManager.getProvider<EconomyK>().provider.get(this)