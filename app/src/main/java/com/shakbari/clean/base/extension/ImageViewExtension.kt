package com.shakbari.clean.base.extension

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DecodeFormat
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.bitmap.BitmapTransitionOptions
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.shakbari.clean.R


private var RoundedCorner: Int = 50.toPixel()

fun ImageView.loadUrl(url: String) =
        Glide.with(context)
                .setDefaultRequestOptions(RequestOptions()
                        .placeholder(R.drawable.ic_person)
                        .error(R.drawable.ic_person)
                        .format(DecodeFormat.PREFER_RGB_565)
                        .diskCacheStrategy(DiskCacheStrategy.DATA))
                .load(url)
                .into(this)

fun ImageView.loadUrlWithBitmap(url: String) = Glide.with(context)
        .asBitmap()
        .placeholder(R.drawable.ic_person)
        .error(R.drawable.ic_person)
        .format(DecodeFormat.PREFER_RGB_565)
        .diskCacheStrategy(DiskCacheStrategy.DATA)
        .transition(BitmapTransitionOptions.withCrossFade())
        .load(url)
        .into(this)


fun ImageView.loadAvatar(url: String) = Glide.with(context)
        .asBitmap()
        .placeholder(R.drawable.ic_person)
        .error(R.drawable.ic_person)
        .format(DecodeFormat.PREFER_RGB_565)
        .diskCacheStrategy(DiskCacheStrategy.DATA)
        .transition(BitmapTransitionOptions.withCrossFade())
        .apply(RequestOptions().transform(CenterCrop(), RoundedCorners(RoundedCorner)))
        .load(url)
        .into(this)
