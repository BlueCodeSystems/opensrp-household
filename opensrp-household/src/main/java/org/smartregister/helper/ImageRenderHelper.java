package org.smartregister.helper;

import android.content.Context;
import android.widget.ImageView;

/**
 * Minimal shim for ImageRenderHelper to keep module compiling under updated dependencies.
 * If an upstream implementation is available on the classpath, prefer that.
 */
public class ImageRenderHelper {

    private final Context context;

    public ImageRenderHelper(Context context) {
        this.context = context;
    }

    public void refreshProfileImage(String baseEntityId, ImageView imageView, int placeholderResId) {
        // Fallback behavior: set placeholder; real image loading handled by upstream libs in original projects.
        if (imageView != null) {
            imageView.setImageResource(placeholderResId);
        }
    }
}

