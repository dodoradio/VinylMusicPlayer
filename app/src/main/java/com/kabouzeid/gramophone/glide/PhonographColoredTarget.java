package com.kabouzeid.gramophone.glide;

import android.content.Context;
import android.graphics.drawable.Drawable;

import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.kabouzeid.gramophone.R;
import com.kabouzeid.gramophone.glide.palette.BitmapPaletteWrapper;
import com.kabouzeid.gramophone.util.ColorUtil;

/**
 * @author Karim Abou Zeid (kabouzeid)
 */
public abstract class PhonographColoredTarget extends SimpleTarget<BitmapPaletteWrapper> {
    private Context context;

    public PhonographColoredTarget(Context context) {
        super();
        init(context);
    }

    public PhonographColoredTarget(Context context, int width, int height) {
        super(width, height);
        init(context);
    }

    private void init(Context context) {
        this.context = context;
    }

    @Override
    public void onLoadFailed(Exception e, Drawable errorDrawable) {
        super.onLoadFailed(e, errorDrawable);
        onColorReady(getDefaultBarColor());
    }

    @Override
    public void onResourceReady(BitmapPaletteWrapper resource, GlideAnimation<? super BitmapPaletteWrapper> glideAnimation) {
        onColorReady(ColorUtil.getColor(resource.getPalette(), getDefaultBarColor()));
    }

    private int getDefaultBarColor() {
        return ColorUtil.resolveColor(context, R.attr.default_bar_color);
    }

    public abstract void onColorReady(int color);
}