package com.gabrielmarcos.fingerprintauth

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v4.hardware.fingerprint.FingerprintManagerCompat
import com.gabrielmarcos.fingerprintauth.utils.FingerprintDialogUtils
import kotlinx.android.synthetic.main.activity_main.*

/**
 * Created by Gabriel Marcos on 05/10/2018.
 */
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fab.setOnClickListener { view ->
            val manager = FingerprintManagerCompat.from(this)

            if (manager.isHardwareDetected && manager.hasEnrolledFingerprints()) {
                showFingerprintAuth()
            } else {
                Snackbar.make(view, "Fingerprint authentication is not supported.", Snackbar.LENGTH_SHORT).show()
            }
        }
    }

    private fun showFingerprintAuth() {
        val dialog = FingerprintDialogUtils.newInstance(
                "Sign In",
                "Confirm fingerprint to continue."
        )
        dialog.show(supportFragmentManager, FingerprintDialogUtils.FRAGMENT_TAG)
    }
}
