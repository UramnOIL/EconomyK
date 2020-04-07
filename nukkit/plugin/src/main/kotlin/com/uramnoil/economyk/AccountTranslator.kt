package com.uramnoil.economyk

object AccountTranslator{

	operator fun invoke(account: Account): com.uramnoil.economyk.core.Account {

	}

	operator fun invoke(account: com.uramnoil.economyk.core.Account): Account {

	}
}