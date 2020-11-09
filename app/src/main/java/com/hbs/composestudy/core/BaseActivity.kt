package com.hbs.composestudy.core

import android.app.ActivityOptions
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.Window
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.Composable
import androidx.core.view.doOnPreDraw
import com.google.android.material.transition.platform.MaterialContainerTransformSharedElementCallback
import com.hbs.composestudy.databinding.BaseActivityBinding
import com.hbs.composestudy.transition.TransitionPlayer
import com.hbs.composestudy.transition.TransitionPlayerImpl
import com.hbs.composestudy.transition.TransitionType

abstract class BaseActivity : AppCompatActivity() {
    lateinit var binding : BaseActivityBinding

    private val transitionPlayerImpl: TransitionPlayer = TransitionPlayerImpl()
    @Composable
    abstract fun bindingCompose()
    abstract fun bindTransitionType(): TransitionType

    private fun isUseTransition(): Boolean {
        return bindTransitionType() != TransitionType.NONE
    }

    private fun preTransitionLogic(){
        if (!isUseTransition()) {
            return
        }
        window.requestFeature(Window.FEATURE_ACTIVITY_TRANSITIONS)
        window.sharedElementsUseOverlay = false
        setExitSharedElementCallback(MaterialContainerTransformSharedElementCallback())
    }

    private fun bindLayout(){
        binding = BaseActivityBinding.inflate(LayoutInflater.from(this))
    }

    private fun transitionLogic() {
        if (!isUseTransition()) {
            return
        }
        val transitionName = intent.getStringExtra("TransitionName")?:"NONE"
        when (bindTransitionType()) {
            TransitionType.ARC -> {
                transitionPlayerImpl.playArcMotion(this, binding.root, transitionName)
            }
            TransitionType.NONE -> {

            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        postponeEnterTransition()
        preTransitionLogic()
        bindLayout()
        transitionLogic()

        super.onCreate(savedInstanceState)
        val rootView = binding.root
        setContentView(rootView)
        rootView.doOnPreDraw {
            startPostponedEnterTransition()
        }
        binding.lifecycleOwner = this
        binding.composeView.setContent {
            bindingCompose()
        }

    }

    fun startActivityWithTransition(view: View, intent: Intent, transitionName: String){
        val options = ActivityOptions.makeSceneTransitionAnimation(
            this,
            view,
            transitionName
        )
        startActivity(intent, options.toBundle())
    }
}