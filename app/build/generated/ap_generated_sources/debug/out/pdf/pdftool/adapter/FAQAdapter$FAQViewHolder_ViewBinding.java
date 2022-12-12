// Generated code from Butter Knife. Do not modify!
package pdf.pdftool.adapter;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.constraintlayout.widget.ConstraintLayout;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;
import pdf.pdftool.R;

public class FAQAdapter$FAQViewHolder_ViewBinding implements Unbinder {
  private FAQAdapter.FAQViewHolder target;

  @UiThread
  public FAQAdapter$FAQViewHolder_ViewBinding(FAQAdapter.FAQViewHolder target, View source) {
    this.target = target;

    target.question = Utils.findRequiredViewAsType(source, R.id.question, "field 'question'", TextView.class);
    target.answer = Utils.findRequiredViewAsType(source, R.id.answer, "field 'answer'", TextView.class);
    target.expandableView = Utils.findRequiredViewAsType(source, R.id.expandable_view, "field 'expandableView'", ConstraintLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    FAQAdapter.FAQViewHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.question = null;
    target.answer = null;
    target.expandableView = null;
  }
}
