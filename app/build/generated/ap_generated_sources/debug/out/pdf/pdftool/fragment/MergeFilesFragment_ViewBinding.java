// Generated code from Butter Knife. Do not modify!
package pdf.pdftool.fragment;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
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

public class MergeFilesFragment_ViewBinding implements Unbinder {
  private MergeFilesFragment target;

  private View view7f0a012f;

  private View view7f0a01d2;

  private View view7f0a023c;

  @UiThread
  public MergeFilesFragment_ViewBinding(final MergeFilesFragment target, View source) {
    this.target = target;

    View view;
    target.mLottieProgress = Utils.findRequiredViewAsType(source, R.id.lottie_progress, "field 'mLottieProgress'", LottieAnimationView.class);
    view = Utils.findRequiredView(source, R.id.mergebtn, "field 'mergeBtn' and method 'mergeFiles'");
    target.mergeBtn = Utils.castView(view, R.id.mergebtn, "field 'mergeBtn'", MorphingButton.class);
    view7f0a012f = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.mergeFiles(p0);
      }
    });
    target.mRecyclerViewFiles = Utils.findRequiredViewAsType(source, R.id.recyclerViewFiles, "field 'mRecyclerViewFiles'", RecyclerView.class);
    target.mUpArrow = Utils.findRequiredViewAsType(source, R.id.upArrow, "field 'mUpArrow'", ImageView.class);
    target.mDownArrow = Utils.findRequiredViewAsType(source, R.id.downArrow, "field 'mDownArrow'", ImageView.class);
    target.mLayout = Utils.findRequiredViewAsType(source, R.id.layout, "field 'mLayout'", RelativeLayout.class);
    target.layoutBottomSheet = Utils.findRequiredViewAsType(source, R.id.bottom_sheet, "field 'layoutBottomSheet'", LinearLayout.class);
    view = Utils.findRequiredView(source, R.id.selectFiles, "field 'mSelectFiles' and method 'startAddingPDF'");
    target.mSelectFiles = Utils.castView(view, R.id.selectFiles, "field 'mSelectFiles'", Button.class);
    view7f0a01d2 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.startAddingPDF(p0);
      }
    });
    target.mSelectedFiles = Utils.findRequiredViewAsType(source, R.id.selected_files, "field 'mSelectedFiles'", RecyclerView.class);
    target.mEnhancementOptionsRecycleView = Utils.findRequiredViewAsType(source, R.id.enhancement_options_recycle_view, "field 'mEnhancementOptionsRecycleView'", RecyclerView.class);
    view = Utils.findRequiredView(source, R.id.viewFiles, "method 'onViewFilesClick'");
    view7f0a023c = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewFilesClick(p0);
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    MergeFilesFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mLottieProgress = null;
    target.mergeBtn = null;
    target.mRecyclerViewFiles = null;
    target.mUpArrow = null;
    target.mDownArrow = null;
    target.mLayout = null;
    target.layoutBottomSheet = null;
    target.mSelectFiles = null;
    target.mSelectedFiles = null;
    target.mEnhancementOptionsRecycleView = null;

    view7f0a012f.setOnClickListener(null);
    view7f0a012f = null;
    view7f0a01d2.setOnClickListener(null);
    view7f0a01d2 = null;
    view7f0a023c.setOnClickListener(null);
    view7f0a023c = null;
  }
}
