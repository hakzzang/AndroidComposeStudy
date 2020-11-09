package com.hbs.composestudy.transition

import android.app.Activity
import android.view.View
import com.google.android.material.color.MaterialColors
import com.google.android.material.transition.platform.MaterialContainerTransformSharedElementCallback
import com.hbs.composestudy.R


interface TransitionPlayer {
    fun playReadyMotion(activity: Activity)
    fun playArcMotion(activity: Activity, rootView: View, transitionName:String)

}

class TransitionPlayerImpl : TransitionPlayer {
    private val transitionMaker: TransitionMaker = TransitionMakerImpl()

    override fun playReadyMotion(activity: Activity) {
        val window = activity.window

    }

    override fun playArcMotion(activity: Activity, rootView: View, transitionName:String) {
        val enterTransition = transitionMaker.fadeInMaterialArcMotion()
        val returnTransition = transitionMaker.fadeOutMaterialArcMotion()

        val window = activity.window
        rootView.transitionName = transitionName

        enterTransition.addTarget(rootView)
        enterTransition.setAllContainerColors(
            MaterialColors.getColor(
                rootView, R.attr.colorSurface
            )
        )
        returnTransition.addTarget(rootView)
        returnTransition.setAllContainerColors(
            MaterialColors.getColor(
                rootView, R.attr.colorSurface
            )
        )

        activity.setEnterSharedElementCallback(MaterialContainerTransformSharedElementCallback())
        activity.setExitSharedElementCallback(MaterialContainerTransformSharedElementCallback())

        window.sharedElementsUseOverlay = false
        window.sharedElementEnterTransition = enterTransition
        window.sharedElementReturnTransition = returnTransition
    }
}