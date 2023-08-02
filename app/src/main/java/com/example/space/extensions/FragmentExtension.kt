package com.example.space.extensions

import android.os.Build
import android.view.WindowInsets
import android.view.WindowManager
import androidx.fragment.app.Fragment

fun Fragment.hideStatusBar() {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
        val controller = activity?.window?.insetsController
        controller?.hide(WindowInsets.Type.statusBars())
    } else {
        @Suppress("DEPRECATION")
        activity?.window?.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)
    }
}

fun Fragment.showStatusBar() {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
        val controller = activity?.window?.insetsController
        controller?.show(WindowInsets.Type.statusBars())
    } else {
        @Suppress("DEPRECATION")
        activity?.window?.clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)
    }
}