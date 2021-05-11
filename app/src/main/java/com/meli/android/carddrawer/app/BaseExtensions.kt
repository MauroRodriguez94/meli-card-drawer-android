package com.meli.android.carddrawer.app

import com.meli.android.carddrawer.model.CardDrawerSource
import com.meli.android.carddrawer.model.CardUI
import com.meli.android.carddrawer.model.GenericPaymentMethod
import com.meli.android.carddrawer.model.PaymentCard

internal fun CardDrawerSource.process(
    customMethodBlock: (genericPaymentMethod: GenericPaymentMethod) -> Unit = {},
    paymentCardBlock: (cardUI: CardUI) -> Unit = {}
) {
    when(this) {
        is GenericPaymentMethod -> customMethodBlock(this)
        is PaymentCard -> paymentCardBlock(cardUI)
    }
}