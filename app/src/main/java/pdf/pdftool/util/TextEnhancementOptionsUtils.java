package pdf.pdftool.util;

import android.content.Context;

import com.itextpdf.text.Font;

import java.util.ArrayList;

import pdf.pdftool.R;
import pdf.pdftool.model.EnhancementOptionsEntity;

public class TextEnhancementOptionsUtils {

    private static class SingletonHolder {
        static final TextEnhancementOptionsUtils INSTANCE = new TextEnhancementOptionsUtils();
    }

    public static TextEnhancementOptionsUtils getInstance() {
        return TextEnhancementOptionsUtils.SingletonHolder.INSTANCE;
    }

    public ArrayList<EnhancementOptionsEntity> getEnhancementOptions(Context context,
                                                                            String fontTitle,
                                                                            Font.FontFamily fontFamily) {
        ArrayList<EnhancementOptionsEntity> options = new ArrayList<>();

        options.add(new EnhancementOptionsEntity(
                context.getResources().getDrawable(R.drawable.ic_font_black_24dp),
                fontTitle));
        options.add(new EnhancementOptionsEntity(
                context, R.drawable.ic_font_family,
                String.format(context.getString(R.string.default_font_family_text), fontFamily.name())));
        options.add(new EnhancementOptionsEntity(
                context, R.drawable.ic_image_size, R.string.set_page_size_text));
        options.add(new EnhancementOptionsEntity(
                context, R.drawable.ic_set_password, R.string.set_password));
        options.add(new EnhancementOptionsEntity(
                context, R.drawable.ic_font_color, R.string.font_color));
        options.add(new EnhancementOptionsEntity(
                context, R.drawable.ic_color_fill, R.string.page_color));
        return options;
    }
}
