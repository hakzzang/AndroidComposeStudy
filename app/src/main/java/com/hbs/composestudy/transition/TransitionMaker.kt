package com.hbs.composestudy.transition

import android.graphics.Color
import androidx.interpolator.view.animation.FastOutSlowInInterpolator
import com.google.android.material.transition.platform.MaterialArcMotion
import com.google.android.material.transition.platform.MaterialContainerTransform

object TransitionConfigure{
    const val FADE_IN_ARC_DURATION = 420L
    const val FADE_OUT_ARC_DURATION = 400L
}

sealed class TransitionType{
    object ARC : TransitionType()
    object NONE : TransitionType()
}

object TransitionIntentType{
    const val CHAPTER_ACTIVITY = "CHAPTER_ACTIVITY"
}

interface TransitionMaker {
    fun fadeInMaterialArcMotion() : MaterialContainerTransform
    fun fadeOutMaterialArcMotion() : MaterialContainerTransform
}

class TransitionMakerImpl : TransitionMaker{
    override fun fadeInMaterialArcMotion(): MaterialContainerTransform {
        return MaterialContainerTransform().apply {
            scrimColor = Color.TRANSPARENT
            duration = TransitionConfigure.FADE_IN_ARC_DURATION
            interpolator = FastOutSlowInInterpolator()
            pathMotion = MaterialArcMotion()
            fadeMode = MaterialContainerTransform.FADE_MODE_IN
        }
    }

    override fun fadeOutMaterialArcMotion(): MaterialContainerTransform {
        return MaterialContainerTransform().apply {
            scrimColor = Color.TRANSPARENT
            duration = TransitionConfigure.FADE_OUT_ARC_DURATION
            interpolator = FastOutSlowInInterpolator()
            pathMotion = MaterialArcMotion()
            fadeMode = MaterialContainerTransform.FADE_MODE_OUT
        }
    }
}