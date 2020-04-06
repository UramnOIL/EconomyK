package com.uramnoil.economyk.event

import com.uramnoil.economyk.Account

class AccountUpdateEvent(account: Account, val old: UInt) : AccountEvent(account)