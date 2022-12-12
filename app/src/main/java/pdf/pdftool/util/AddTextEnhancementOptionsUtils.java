package pdf.pdftool.util;

import android.content.Context;

import com.itextpdf.text.Font;

import java.util.ArrayList;

import pdf.pdftool.R;
import pdf.pdftool.model.EnhancementOptionsEntity;

public class AddTextEnhancementOptionsUtils {

    private AddTextEnhancementOptionsUtils() {

    }

    public ArrayList<EnhancementOptionsEntity> getEnhancementOptions(Context context,
                                                                     String fontTitle,
                                                                     Font.FontFamily fontFamily) {
        ArrayList<EnhancementOptionsEntity> options = new ArrayList<>();

        options.add(new EnhancementOptionsEntity(
                context.getResources().getDrawable(R.drawable.ic_text_size),
                fontTitle));
        options.add(new EnhancementOptionsEntity(
                context, R.drawable.ic_extract_text,
                String.format(context.getString(R.string.default_font_family_text), fontFamily.name())));
        return options;
    }

    private static class SingletonHolder {
        static final AddTextEnhancementOptionsUtils INSTANCE = new AddTextEnhancementOptionsUtils();
    }

    public static AddTextEnhancementOptionsUtils getInstance() {
        return SingletonHolder.INSTANCE;
    }

}
