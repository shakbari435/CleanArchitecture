package com.shakbari.clean.di

import android.content.Context
import android.graphics.Bitmap
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestBuilder
import com.bumptech.glide.RequestManager
import com.bumptech.glide.load.DecodeFormat
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.bitmap.BitmapTransitionOptions.withCrossFade
import com.bumptech.glide.request.RequestOptions
import com.shakbari.clean.R
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object GlideModule {


    @Singleton
    @Provides
    fun provideGlideInstance(
            @ApplicationContext context: Context
    ): RequestManager {
        return Glide.with(context)
                .setDefaultRequestOptions(
                        RequestOptions()
                                .placeholder(R.drawable.ic_person)
                                .error(R.drawable.ic_person)
                                .format(DecodeFormat.PREFER_RGB_565)
                                .diskCacheStrategy(DiskCacheStrategy.DATA)
                )
    }

    @Singleton
    @Provides
    fun provideGlideBitmap(
            @ApplicationContext context: Context
    ): RequestBuilder<Bitmap> = Glide.with(context)
            .asBitmap()
            .placeholder(R.drawable.ic_person)
            .error(R.drawable.ic_person)
            .format(DecodeFormat.PREFER_RGB_565)
            .diskCacheStrategy(DiskCacheStrategy.DATA)
            .transition(withCrossFade())



}