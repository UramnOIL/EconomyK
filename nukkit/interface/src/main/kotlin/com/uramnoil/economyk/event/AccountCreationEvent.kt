package com.uramnoil.economyk.event

import cn.nukkit.IPlayer
import com.uramnoil.economyk.Account

class AccountCreationEvent(player: IPlayer) : AccountEvent() {
	var defaultAmount = 0u;
}