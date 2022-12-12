package pdf.pdftool.util;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;

import java.util.ArrayList;

import pdf.pdftool.R;
import pdf.pdftool.model.EnhancementOptionsEntity;
import pdf.pdftool.model.ImageToPDFOptions;

public class ImageEnhancementOptionsUtils {

    public ImageEnhancementOptionsUtils() {
    }

    /**
     * Singleton Implementation
     */
    private static class SingletonHolder {
        private static final ImageEnhancementOptionsUtils INSTANCE = new ImageEnhancementOptionsUtils();
    }

    public static ImageEnhancementOptionsUtils getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public ArrayList<EnhancementOptionsEntity> getEnhancementOptions(Context context,
                                                                     ImageToPDFOptions pdfOptions) {
        ArrayList<EnhancementOptionsEntity> options = new ArrayList<>();
        int passwordIcon = R.drawable.ic_protect;
        if (pdfOptions.isPasswordProtected())
            passwordIcon = R.drawable.baseline_done_24;

        options.add(new EnhancementOptionsEntity(
                context, passwordIcon, R.string.password_protect_pdf_text));

        options.add(new EnhancementOptionsEntity(
                context, R.drawable.ic_rotate_page, R.string.edit_images_text));

        options.add(new EnhancementOptionsEntity(
                context, R.drawable.ic_image_compression,
                String.format(context.getResources().getString(R.string.compress_image),
                        pdfOptions.getQualityString())));

        options.add(new EnhancementOptionsEntity(
                context, R.drawable.ic_filter_image, R.string.filter_images_Text));

        options.add(new EnhancementOptionsEntity(
                context, R.drawable.ic_image_size, R.string.set_page_size_text));

        options.add(new EnhancementOptionsEntity(
                context, R.drawable.ic_image_scale_type, R.string.image_scale_type));

        options.add(new EnhancementOptionsEntity(
                context, R.drawable.ic_page_preview, R.string.preview_image_to_pdf));

        options.add(new EnhancementOptionsEntity(
                context, R.drawable.ic_page_border_width,
                String.format(context.getResources().getString(R.string.border_dialog_title),
                        pdfOptions.getBorderWidth())));

        options.add(new EnhancementOptionsEntity(
                context, R.drawable.ic_rearrange_page, R.string.rearrange_images));

        Drawable iconGrayScale = context.getResources().getDrawable(R.drawable.ic_photo_filter_black_24dp);
        iconGrayScale.setColorFilter(Color.GRAY, android.graphics.PorterDuff.Mode.SRC_IN);

        options.add(new EnhancementOptionsEntity(
                iconGrayScale,
                context.getResources().getString(R.string.grayscale_images)));

        options.add(new EnhancementOptionsEntity(
                context, R.drawable.ic_page_margin, R.string.add_margins));

        options.add(new EnhancementOptionsEntity(
                context, R.drawable.ic_page_number, R.string.show_pg_num));

        options.add(new EnhancementOptionsEntity(
                context, R.drawable.ic_add_watermark, R.string.add_watermark));

        options.add(new EnhancementOptionsEntity(
                context, R.drawable.ic_color_fill, R.string.page_color));

        return options;
    }
}
