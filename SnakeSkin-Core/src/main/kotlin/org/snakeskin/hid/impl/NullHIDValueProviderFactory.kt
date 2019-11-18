package org.snakeskin.hid.impl

import org.snakeskin.hid.IHIDValueProviderFactory
import org.snakeskin.hid.provider.IAxisValueProvider
import org.snakeskin.hid.provider.IButtonValueProvider
import org.snakeskin.hid.provider.IHatValueProvider

object NullHIDValueProviderFactory : IHIDValueProviderFactory {
    override fun createAxisValueProvider(id: Int): IAxisValueProvider {
        //no-op
        return NullAxisValueProvider
    }

    override fun createButtonValueProvider(id: Int): IButtonValueProvider {
        //no-op
        return NullButtonValueProvider
    }

    override fun createHatValueProvider(id: Int): IHatValueProvider {
        //no-op
        return NullHatValueProvider
    }

}