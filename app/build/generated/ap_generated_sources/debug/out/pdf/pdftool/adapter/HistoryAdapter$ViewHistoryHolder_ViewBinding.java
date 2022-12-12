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

public class HistoryAdapter$ViewHistoryHolder_ViewBinding implements Unbinder {
  private HistoryAdapter.ViewHistoryHolder target;

  @UiThread
  public HistoryAdapter$ViewHistoryHolder_ViewBinding(HistoryAdapter.ViewHistoryHolder target,
      View source) {
    this.target = target;

    target.mFilename = Utils.findRequiredViewAsType(source, R.id.fileName, "field 'mFilename'", TextView.class);
    target.mOperationDate = Utils.findRequiredViewAsType(source, R.id.operationDate, "field 'mOperationDate'", TextView.class);
    target.mOperationType = Utils.findRequiredViewAsType(source, R.id.operationType, "field 'mOperationType'", TextView.class);
    target.mOperationImage = Utils.findRequiredViewAsType(source, R.id.operationImage, "field 'mOperationImage'", ImageView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    HistoryAdapter.ViewHistoryHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mFilename = null;
    target.mOperationDate = null;
    target.mOperationType = null;
    target.mOperationImage = null;
  }
}
