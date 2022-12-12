// Generated code from Butter Knife. Do not modify!
package pdf.pdftool.fragment;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.airbnb.lottie.LottieAnimationView;
import java.lang.IllegalStateException;
import java.lang.Override;
import pdf.pdftool.R;
import pdf.pdftool.customviews.MyCardView;

public class FavouritesFragment_ViewBinding implements Unbinder {
  private FavouritesFragment target;

  private View view7f0a00c7;

  @UiThread
  public FavouritesFragment_ViewBinding(final FavouritesFragment target, View source) {
    this.target = target;

    View view;
    target.pref_img_to_pdf = Utils.findRequiredViewAsType(source, R.id.images_to_pdf_fav, "field 'pref_img_to_pdf'", MyCardView.class);
    target.pref_text_to_pdf = Utils.findRequiredViewAsType(source, R.id.text_to_pdf_fav, "field 'pref_text_to_pdf'", MyCardView.class);
    target.pref_qr_barcode = Utils.findRequiredViewAsType(source, R.id.qr_barcode_to_pdf_fav, "field 'pref_qr_barcode'", MyCardView.class);
    target.pref_view_files = Utils.findRequiredViewAsType(source, R.id.view_files_fav, "field 'pref_view_files'", MyCardView.class);
    target.pref_history = Utils.findRequiredViewAsType(source, R.id.view_history_fav, "field 'pref_history'", MyCardView.class);
    target.pref_add_password = Utils.findRequiredViewAsType(source, R.id.add_password_fav, "field 'pref_add_password'", MyCardView.class);
    target.pref_rem_pass = Utils.findRequiredViewAsType(source, R.id.remove_password_fav, "field 'pref_rem_pass'", MyCardView.class);
    target.pref_rot_pages = Utils.findRequiredViewAsType(source, R.id.rotate_pages_fav, "field 'pref_rot_pages'", MyCardView.class);
    target.pref_add_watermark = Utils.findRequiredViewAsType(source, R.id.add_watermark_fav, "field 'pref_add_watermark'", MyCardView.class);
    target.pref_add_images = Utils.findRequiredViewAsType(source, R.id.add_images_fav, "field 'pref_add_images'", MyCardView.class);
    target.pref_merge_pdf = Utils.findRequiredViewAsType(source, R.id.merge_pdf_fav, "field 'pref_merge_pdf'", MyCardView.class);
    target.pref_split_pdf = Utils.findRequiredViewAsType(source, R.id.split_pdf_fav, "field 'pref_split_pdf'", MyCardView.class);
    target.pref_invert_pdf = Utils.findRequiredViewAsType(source, R.id.invert_pdf_fav, "field 'pref_invert_pdf'", MyCardView.class);
    target.pref_compress = Utils.findRequiredViewAsType(source, R.id.compress_pdf_fav, "field 'pref_compress'", MyCardView.class);
    target.pref_rem_dup_pages = Utils.findRequiredViewAsType(source, R.id.remove_duplicates_pages_pdf_fav, "field 'pref_rem_dup_pages'", MyCardView.class);
    target.pref_remove_pages = Utils.findRequiredViewAsType(source, R.id.remove_pages_fav, "field 'pref_remove_pages'", MyCardView.class);
    target.pref_reorder_pages = Utils.findRequiredViewAsType(source, R.id.rearrange_pages_fav, "field 'pref_reorder_pages'", MyCardView.class);
    target.pref_extract_img = Utils.findRequiredViewAsType(source, R.id.extract_images_fav, "field 'pref_extract_img'", MyCardView.class);
    target.pref_pdf_to_img = Utils.findRequiredViewAsType(source, R.id.pdf_to_images_fav, "field 'pref_pdf_to_img'", MyCardView.class);
    target.pref_extract_txt = Utils.findRequiredViewAsType(source, R.id.extract_text_fav, "field 'pref_extract_txt'", MyCardView.class);
    target.pref_excel_to_pdf = Utils.findRequiredViewAsType(source, R.id.excel_to_pdf_fav, "field 'pref_excel_to_pdf'", MyCardView.class);
    target.pref_add_text = Utils.findRequiredViewAsType(source, R.id.add_text_fav, "field 'pref_add_text'", MyCardView.class);
    target.favouritesAnimation = Utils.findRequiredViewAsType(source, R.id.favourites, "field 'favouritesAnimation'", LottieAnimationView.class);
    target.favouritesText = Utils.findRequiredViewAsType(source, R.id.favourites_text, "field 'favouritesText'", TextView.class);
    target.pref_zip_to_pdf = Utils.findRequiredViewAsType(source, R.id.zip_to_pdf_fav, "field 'pref_zip_to_pdf'", MyCardView.class);
    view = Utils.findRequiredView(source, R.id.fav_add_fab, "method 'onAddFavouriteButtonClicked'");
    view7f0a00c7 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onAddFavouriteButtonClicked();
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    FavouritesFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.pref_img_to_pdf = null;
    target.pref_text_to_pdf = null;
    target.pref_qr_barcode = null;
    target.pref_view_files = null;
    target.pref_history = null;
    target.pref_add_password = null;
    target.pref_rem_pass = null;
    target.pref_rot_pages = null;
    target.pref_add_watermark = null;
    target.pref_add_images = null;
    target.pref_merge_pdf = null;
    target.pref_split_pdf = null;
    target.pref_invert_pdf = null;
    target.pref_compress = null;
    target.pref_rem_dup_pages = null;
    target.pref_remove_pages = null;
    target.pref_reorder_pages = null;
    target.pref_extract_img = null;
    target.pref_pdf_to_img = null;
    target.pref_extract_txt = null;
    target.pref_excel_to_pdf = null;
    target.pref_add_text = null;
    target.favouritesAnimation = null;
    target.favouritesText = null;
    target.pref_zip_to_pdf = null;

    view7f0a00c7.setOnClickListener(null);
    view7f0a00c7 = null;
  }
}
