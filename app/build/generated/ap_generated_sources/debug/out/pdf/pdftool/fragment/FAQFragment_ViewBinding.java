// Generated code from Butter Knife. Do not modify!
package pdf.pdftool.fragment;

import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;
import pdf.pdftool.R;

public class FAQFragment_ViewBinding implements Unbinder {
  private FAQFragment target;

  @UiThread
  public FAQFragment_ViewBinding(FAQFragment target, View source) {
    this.target = target;

    target.mFAQRecyclerView = Utils.findRequiredViewAsType(source, R.id.recycler_view_faq, "field 'mFAQRecyclerView'", RecyclerView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    FAQFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mFAQRecyclerView = null;
  }
}
