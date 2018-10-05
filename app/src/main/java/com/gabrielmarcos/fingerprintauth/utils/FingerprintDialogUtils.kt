package com.gabrielmarcos.fingerprintauth.utils

import android.os.Bundle
import com.gabrielmarcos.fingerprintauth.FingerprintDialog

/**
 * Created by Gabriel Marcos on 05/10/2018.
 */
class FingerprintDialogUtils {
    companion object {
        val FRAGMENT_TAG: String = FingerprintDialog::class.java.simpleName

        const val ARG_TITLE = "ArgTitle"
        const val ARG_SUBTITLE = "ArgSubtitle"
        const val DEFAULT_KEY_NAME = "default_key"

        fun newInstance(title: String, subtitle: String): FingerprintDialog {
            val args = Bundle()
            args.putString(ARG_TITLE, title)
            args.putString(ARG_SUBTITLE, subtitle)

            val fragment = FingerprintDialog()
            fragment.arguments = args

            return fragment
        }
    }
}