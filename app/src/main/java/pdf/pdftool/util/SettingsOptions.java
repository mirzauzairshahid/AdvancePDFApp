package pdf.pdftool.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.itextpdf.text.Font;

import java.util.ArrayList;

import pdf.pdftool.R;
import pdf.pdftool.model.EnhancementOptionsEntity;

import static pdf.pdftool.util.Constants.DEFAULT_COMPRESSION;

public class SettingsOptions {

    public static ArrayList<EnhancementOptionsEntity> getEnhancementOptions(Context context) {
        ArrayList<EnhancementOptionsEntity> options = new ArrayList<>();
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);

        options.add(new EnhancementOptionsEntity(
                context, R.drawable.ic_image_compression,
                String.format(context.getString(R.string.image_compression_value_default),
                        sharedPreferences.getInt(DEFAULT_COMPRESSION, 30))));

        options.add(new EnhancementOptionsEntity(
                context, R.drawable.ic_image_size,
                String.format(context.getString(R.string.page_size_value_def),
                        sharedPreferences.getString(Constants.DEFAULT_PAGE_SIZE_TEXT,
                                Constants.DEFAULT_PAGE_SIZE))));

        options.add(new EnhancementOptionsEntity(
                context, R.drawable.ic_text_size,
                String.format(context.getString(R.string.font_size_value_def),
                        sharedPreferences.getInt(Constants.DEFAULT_FONT_SIZE_TEXT,
                                Constants.DEFAULT_FONT_SIZE))));

        Font.FontFamily fontFamily = Font.FontFamily.valueOf(
                sharedPreferences.getString(Constants.DEFAULT_FONT_FAMILY_TEXT,
                        Constants.DEFAULT_FONT_FAMILY));

        options.add(new EnhancementOptionsEntity(
                context, R.drawable.ic_extract_text,
                String.format(context.getString(R.string.font_family_value_def),
                        fontFamily.name())));

        options.add(new EnhancementOptionsEntity(
                context, R.drawable.ic_theme_value,
                String.format(context.getString(R.string.theme_value_def),
                        sharedPreferences.getString(Constants.DEFAULT_THEME_TEXT,
                                Constants.DEFAULT_THEME))));

        options.add(new EnhancementOptionsEntity(context,
                R.drawable.ic_page_margin, R.string.image_scale_type));

        options.add(new EnhancementOptionsEntity(context,
                R.drawable.ic_set_password, R.string.change_master_pwd));

        options.add(new EnhancementOptionsEntity(context,
                R.drawable.ic_page_number, R.string.show_pg_num));

        return options;
    }

}
