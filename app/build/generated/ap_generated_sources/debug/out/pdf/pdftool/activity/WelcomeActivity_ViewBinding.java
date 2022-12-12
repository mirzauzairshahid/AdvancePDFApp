// Generated code from Butter Knife. Do not modify!
package pdf.pdftool.activity;

import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.viewpager.widget.ViewPager;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;
import pdf.pdftool.R;

public class WelcomeActivity_ViewBinding implements Unbinder {
  private WelcomeActivity target;

  private View view7f0a0065;

  @UiThread
  public WelcomeActivity_ViewBinding(WelcomeActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public WelcomeActivity_ViewBinding(final WelcomeActivity target, View source) {
    this.target = target;

    View view;
    target.mViewPager = Utils.findRequiredViewAsType(source, R.id.view_pager, "field 'mViewPager'", ViewPager.class);
    target.mDotsLayout = Utils.findRequiredViewAsType(source, R.id.layoutDots, "field 'mDotsLayout'", LinearLayout.class);
    view = Utils.findRequiredView(source, R.id.btn_skip, "field 'mBtnSkip' and method 'openMainActivity'");
    target.mBtnSkip = Utils.castView(view, R.id.btn_skip, "field 'mBtnSkip'", Button.class);
    view7f0a0065 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.openMainActivity();
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    WelcomeActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mViewPager = null;
    target.mDotsLayout = null;
    target.mBtnSkip = null;

    view7f0a0065.setOnClickListener(null);
    view7f0a0065 = null;
  }
}
