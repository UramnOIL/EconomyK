package com.uramnoil.economyk

import cn.nukkit.IPlayer
import cn.nukkit.Server
import com.uramnoil.economyk.event.AccountUpdateEvent

class Account @ExperimentalUnsignedTypes
internal constructor (val player: IPlayer, amount: UInt) {
	@ExperimentalUnsignedTypes
	var amount: UInt = amount
		set(value) {
			val event = AccountUpdateEvent(this, amount)
			Server.getInstance().pluginManager.callEvent(event)
			field = value
		}
}