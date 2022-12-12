// Generated code from Butter Knife. Do not modify!
package pdf.pdftool.fragment;

import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;
import pdf.pdftool.R;

public class ViewFilesFragment_ViewBinding implements Unbinder {
  private ViewFilesFragment target;

  private View view7f0a00e4;

  private View view7f0a018e;

  @UiThread
  public ViewFilesFragment_ViewBinding(final ViewFilesFragment target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.getStarted, "field 'getStarted' and method 'loadHome'");
    target.getStarted = Utils.castView(view, R.id.getStarted, "field 'getStarted'", Button.class);
    view7f0a00e4 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.loadHome();
      }
    });
    target.mViewFilesListRecyclerView = Utils.findRequiredViewAsType(source, R.id.filesRecyclerView, "field 'mViewFilesListRecyclerView'", RecyclerView.class);
    target.mSwipeView = Utils.findRequiredViewAsType(source, R.id.swipe, "field 'mSwipeView'", SwipeRefreshLayout.class);
    target.emptyView = Utils.findRequiredViewAsType(source, R.id.emptyStatusView, "field 'emptyView'", ConstraintLayout.class);
    target.noPermissionsLayout = Utils.findRequiredViewAsType(source, R.id.no_permissions_view, "field 'noPermissionsLayout'", RelativeLayout.class);
    view = Utils.findRequiredView(source, R.id.provide_permissions, "method 'providePermissions'");
    view7f0a018e = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.providePermissions();
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    ViewFilesFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.getStarted = null;
    target.mViewFilesListRecyclerView = null;
    target.mSwipeView = null;
    target.emptyView = null;
    target.noPermissionsLayout = null;

    view7f0a00e4.setOnClickListener(null);
    view7f0a00e4 = null;
    view7f0a018e.setOnClickListener(null);
    view7f0a018e = null;
  }
}
