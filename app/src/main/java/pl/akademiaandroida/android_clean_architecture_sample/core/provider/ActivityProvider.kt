package pl.akademiaandroida.android_clean_architecture_sample.core.provider

import android.app.Activity
import android.app.Application
import android.os.Bundle

class ActivityProvider(application: Application) {

    var foregroundActivity: Activity? = null

    init {
        application.registerActivityLifecycleCallbacks(object :
            Application.ActivityLifecycleCallbacks {

            override fun onActivityPaused(activity: Activity) {
                foregroundActivity = null
            }

            override fun onActivityResumed(activity: Activity) {
                foregroundActivity = activity
            }

            override fun onActivityStarted(activity: Activity) {
            }

            override fun onActivityDestroyed(activity: Activity) {
            }

            override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle) {
            }

            override fun onActivityStopped(activity: Activity) {
            }

            override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {
            }
        })
    }
}