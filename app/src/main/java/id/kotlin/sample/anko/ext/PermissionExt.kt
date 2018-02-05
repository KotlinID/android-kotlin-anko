package id.kotlin.sample.anko.ext

import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import android.support.v4.content.ContextCompat

internal fun Context.hasSelfPermissions(permissions: Array<String>): Boolean {
    when {
        Build.VERSION.SDK_INT >= Build.VERSION_CODES.M -> return true
    }
    permissions.filter { ContextCompat.checkSelfPermission(this, it) != PackageManager.PERMISSION_GRANTED }.forEach { return false }

    return true
}