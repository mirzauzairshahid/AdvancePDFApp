// Generated code from Butter Knife. Do not modify!
package pdf.pdftool.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.appcompat.widget.AppCompatCheckBox;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;
import pdf.pdftool.R;

public class MergeFilesAdapter$ViewMergeFilesHolder_ViewBinding implements Unbinder {
  private MergeFilesAdapter.ViewMergeFilesHolder target;

  private View view7f0a0104;

  @UiThread
  public MergeFilesAdapter$ViewMergeFilesHolder_ViewBinding(
      final MergeFilesAdapter.ViewMergeFilesHolder target, View source) {
    this.target = target;

    View view;
    target.mFileName = Utils.findRequiredViewAsType(source, R.id.fileName, "field 'mFileName'", TextView.class);
    target.mEncryptionImage = Utils.findRequiredViewAsType(source, R.id.encryptionImage, "field 'mEncryptionImage'", ImageView.class);
    view = Utils.findRequiredView(source, R.id.itemMerge_checkbox, "field 'mCheckbox' and method 'onCheckboxClick'");
    target.mCheckbox = Utils.castView(view, R.id.itemMerge_checkbox, "field 'mCheckbox'", AppCompatCheckBox.class);
    view7f0a0104 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onCheckboxClick();
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    MergeFilesAdapter.ViewMergeFilesHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mFileName = null;
    target.mEncryptionImage = null;
    target.mCheckbox = null;

    view7f0a0104.setOnClickListener(null);
    view7f0a0104 = null;
  }
}
