// Generated code from Butter Knife. Do not modify!
package pdf.pdftool.adapter;

import android.view.View;
import android.widget.Button;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;
import pdf.pdftool.R;

public class BrushItemAdapter$BrushItemViewHolder_ViewBinding implements Unbinder {
  private BrushItemAdapter.BrushItemViewHolder target;

  @UiThread
  public BrushItemAdapter$BrushItemViewHolder_ViewBinding(
      BrushItemAdapter.BrushItemViewHolder target, View source) {
    this.target = target;

    target.doodleButton = Utils.findRequiredViewAsType(source, R.id.doodle_color, "field 'doodleButton'", Button.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    BrushItemAdapter.BrushItemViewHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.doodleButton = null;
  }
}
