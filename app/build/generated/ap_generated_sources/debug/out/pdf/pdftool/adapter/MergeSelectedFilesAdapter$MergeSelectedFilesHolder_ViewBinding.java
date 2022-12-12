// Generated code from Butter Knife. Do not modify!
package pdf.pdftool.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;
import pdf.pdftool.R;

public class MergeSelectedFilesAdapter$MergeSelectedFilesHolder_ViewBinding implements Unbinder {
  private MergeSelectedFilesAdapter.MergeSelectedFilesHolder target;

  @UiThread
  public MergeSelectedFilesAdapter$MergeSelectedFilesHolder_ViewBinding(
      MergeSelectedFilesAdapter.MergeSelectedFilesHolder target, View source) {
    this.target = target;

    target.mFileName = Utils.findRequiredViewAsType(source, R.id.fileName, "field 'mFileName'", TextView.class);
    target.mViewFile = Utils.findRequiredViewAsType(source, R.id.view_file, "field 'mViewFile'", ImageView.class);
    target.mRemove = Utils.findRequiredViewAsType(source, R.id.remove, "field 'mRemove'", ImageView.class);
    target.mUp = Utils.findRequiredViewAsType(source, R.id.up_file, "field 'mUp'", ImageView.class);
    target.mDown = Utils.findRequiredViewAsType(source, R.id.down_file, "field 'mDown'", ImageView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    MergeSelectedFilesAdapter.MergeSelectedFilesHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mFileName = null;
    target.mViewFile = null;
    target.mRemove = null;
    target.mUp = null;
    target.mDown = null;
  }
}
