// Generated code from Butter Knife. Do not modify!
package pdf.pdftool.fragment;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.airbnb.lottie.LottieAnimationView;
import com.dd.morphingbutton.MorphingButton;
import java.lang.IllegalStateException;
import java.lang.Override;
import pdf.pdftool.R;

public class PdfToImageFragment_ViewBinding implements Unbinder {
  private PdfToImageFragment target;

  private View view7f0a01d1;

  private View view7f0a008b;

  private View view7f0a023e;

  private View view7f0a01de;

  private View view7f0a023c;

  private View view7f0a023d;

  @UiThread
  public PdfToImageFragment_ViewBinding(final PdfToImageFragment target, View source) {
    this.target = target;

    View view;
    target.mLottieProgress = Utils.findRequiredViewAsType(source, R.id.lottie_progress, "field 'mLottieProgress'", LottieAnimationView.class);
    target.mLayoutBottomSheet = Utils.findRequiredViewAsType(source, R.id.bottom_sheet, "field 'mLayoutBottomSheet'", LinearLayout.class);
    target.mUpArrow = Utils.findRequiredViewAsType(source, R.id.upArrow, "field 'mUpArrow'", ImageView.class);
    view = Utils.findRequiredView(source, R.id.selectFile, "field 'mSelectFileButton' and method 'showFileChooser'");
    target.mSelectFileButton = Utils.castView(view, R.id.selectFile, "field 'mSelectFileButton'", MorphingButton.class);
    view7f0a01d1 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.showFileChooser();
      }
    });
    view = Utils.findRequiredView(source, R.id.createImages, "field 'mCreateImagesButton' and method 'parse'");
    target.mCreateImagesButton = Utils.castView(view, R.id.createImages, "field 'mCreateImagesButton'", MorphingButton.class);
    view7f0a008b = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.parse();
      }
    });
    target.mCreatedImages = Utils.findRequiredViewAsType(source, R.id.created_images, "field 'mCreatedImages'", RecyclerView.class);
    target.mCreateImagesSuccessText = Utils.findRequiredViewAsType(source, R.id.pdfToImagesText, "field 'mCreateImagesSuccessText'", TextView.class);
    target.options = Utils.findRequiredViewAsType(source, R.id.options, "field 'options'", LinearLayout.class);
    target.mLayout = Utils.findRequiredViewAsType(source, R.id.layout, "field 'mLayout'", RelativeLayout.class);
    target.mRecyclerViewFiles = Utils.findRequiredViewAsType(source, R.id.recyclerViewFiles, "field 'mRecyclerViewFiles'", RecyclerView.class);
    view = Utils.findRequiredView(source, R.id.viewImagesInGallery, "method 'onImagesInGalleryClick'");
    view7f0a023e = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onImagesInGalleryClick();
      }
    });
    view = Utils.findRequiredView(source, R.id.shareImages, "method 'onShareFilesClick'");
    view7f0a01de = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onShareFilesClick();
      }
    });
    view = Utils.findRequiredView(source, R.id.viewFiles, "method 'onViewFilesClick'");
    view7f0a023c = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewFilesClick();
      }
    });
    view = Utils.findRequiredView(source, R.id.viewImages, "method 'onViewImagesClicked'");
    view7f0a023d = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewImagesClicked();
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    PdfToImageFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mLottieProgress = null;
    target.mLayoutBottomSheet = null;
    target.mUpArrow = null;
    target.mSelectFileButton = null;
    target.mCreateImagesButton = null;
    target.mCreatedImages = null;
    target.mCreateImagesSuccessText = null;
    target.options = null;
    target.mLayout = null;
    target.mRecyclerViewFiles = null;

    view7f0a01d1.setOnClickListener(null);
    view7f0a01d1 = null;
    view7f0a008b.setOnClickListener(null);
    view7f0a008b = null;
    view7f0a023e.setOnClickListener(null);
    view7f0a023e = null;
    view7f0a01de.setOnClickListener(null);
    view7f0a01de = null;
    view7f0a023c.setOnClickListener(null);
    view7f0a023c = null;
    view7f0a023d.setOnClickListener(null);
    view7f0a023d = null;
  }
}
