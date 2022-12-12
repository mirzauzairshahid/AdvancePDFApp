// Generated code from Butter Knife. Do not modify!
package pdf.pdftool.fragment;

import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;
import pdf.pdftool.R;

public class HistoryFragment_ViewBinding implements Unbinder {
  private HistoryFragment target;

  private View view7f0a00e4;

  @UiThread
  public HistoryFragment_ViewBinding(final HistoryFragment target, View source) {
    this.target = target;

    View view;
    target.mEmptyStatusLayout = Utils.findRequiredViewAsType(source, R.id.emptyStatusView, "field 'mEmptyStatusLayout'", ConstraintLayout.class);
    target.mHistoryRecyclerView = Utils.findRequiredViewAsType(source, R.id.historyRecyclerView, "field 'mHistoryRecyclerView'", RecyclerView.class);
    view = Utils.findRequiredView(source, R.id.getStarted, "method 'loadHome'");
    view7f0a00e4 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.loadHome();
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    HistoryFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mEmptyStatusLayout = null;
    target.mHistoryRecyclerView = null;

    view7f0a00e4.setOnClickListener(null);
    view7f0a00e4 = null;
  }
}
