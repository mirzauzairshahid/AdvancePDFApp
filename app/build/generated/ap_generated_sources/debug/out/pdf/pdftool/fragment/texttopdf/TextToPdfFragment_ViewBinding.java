// Generated code from Butter Knife. Do not modify!
package pdf.pdftool.fragment.texttopdf;

import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.dd.morphingbutton.MorphingButton;
import java.lang.IllegalStateException;
import java.lang.Override;
import pdf.pdftool.R;

public class TextToPdfFragment_ViewBinding implements Unbinder {
  private TextToPdfFragment target;

  private View view7f0a01d1;

  private View view7f0a008f;

  @UiThread
  public TextToPdfFragment_ViewBinding(final TextToPdfFragment target, View source) {
    this.target = target;

    View view;
    target.mTextEnhancementOptionsRecycleView = Utils.findRequiredViewAsType(source, R.id.enhancement_options_recycle_view_text, "field 'mTextEnhancementOptionsRecycleView'", RecyclerView.class);
    view = Utils.findRequiredView(source, R.id.selectFile, "field 'mSelectFile' and method 'selectTextFile'");
    target.mSelectFile = Utils.castView(view, R.id.selectFile, "field 'mSelectFile'", MorphingButton.class);
    view7f0a01d1 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.selectTextFile();
      }
    });
    view = Utils.findRequiredView(source, R.id.createtextpdf, "field 'mCreateTextPdf' and method 'openCreateTextPdf'");
    target.mCreateTextPdf = Utils.castView(view, R.id.createtextpdf, "field 'mCreateTextPdf'", MorphingButton.class);
    view7f0a008f = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.openCreateTextPdf();
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    TextToPdfFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mTextEnhancementOptionsRecycleView = null;
    target.mSelectFile = null;
    target.mCreateTextPdf = null;

    view7f0a01d1.setOnClickListener(null);
    view7f0a01d1 = null;
    view7f0a008f.setOnClickListener(null);
    view7f0a008f = null;
  }
}
