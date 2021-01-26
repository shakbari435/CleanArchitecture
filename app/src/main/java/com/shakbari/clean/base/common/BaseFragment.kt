package com.shakbari.clean.base.common

import android.graphics.Bitmap
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.RequestBuilder
import com.bumptech.glide.RequestManager
import javax.inject.Inject

abstract class BaseFragment:Fragment() {
    abstract fun layoutId(): Int
    @Inject
    lateinit var glide: RequestManager
    @Inject
    lateinit var glideWithBitmap: RequestBuilder<Bitmap>

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View =
            inflater.inflate(layoutId(), container, false)


}