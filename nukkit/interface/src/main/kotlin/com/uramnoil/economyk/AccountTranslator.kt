package com.uramnoil.economyk

import cn.nukkit.Server
import com.uramnoil.economyk.core.Account as CoreAccount

object AccountTranslator{

	@ExperimentalUnsignedTypes
	operator fun invoke(account: Account) = CoreAccount(account.player.uniqueId, account.amount)

	operator fun invoke(account: CoreAccount) = Account(
		Server.getInstance().getOfflinePlayer(account.id),
		account.amount
	)
}