// Generated code from Butter Knife. Do not modify!
package pdf.pdftool.activity;

import android.view.View;
import android.widget.Button;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;
import pdf.pdftool.R;

public class RearrangePdfPages_ViewBinding implements Unbinder {
  private RearrangePdfPages target;

  @UiThread
  public RearrangePdfPages_ViewBinding(RearrangePdfPages target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public RearrangePdfPages_ViewBinding(RearrangePdfPages target, View source) {
    this.target = target;

    target.mRecyclerView = Utils.findRequiredViewAsType(source, R.id.recyclerView, "field 'mRecyclerView'", RecyclerView.class);
    target.sortButton = Utils.findRequiredViewAsType(source, R.id.sort, "field 'sortButton'", Button.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    RearrangePdfPages target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mRecyclerView = null;
    target.sortButton = null;
  }
}
