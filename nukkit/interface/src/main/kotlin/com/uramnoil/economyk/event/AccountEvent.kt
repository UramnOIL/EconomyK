package com.uramnoil.economyk.event

import cn.nukkit.event.Event
import com.uramnoil.economyk.Account

abstract class AccountEvent(val account: Account) : Event()