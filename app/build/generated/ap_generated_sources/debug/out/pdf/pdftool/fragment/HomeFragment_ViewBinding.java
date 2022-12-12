// Generated code from Butter Knife. Do not modify!
package pdf.pdftool.fragment;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;
import pdf.pdftool.R;
import pdf.pdftool.customviews.MyCardView;

public class HomeFragment_ViewBinding implements Unbinder {
  private HomeFragment target;

  @UiThread
  public HomeFragment_ViewBinding(HomeFragment target, View source) {
    this.target = target;

    target.imagesToPdf = Utils.findRequiredViewAsType(source, R.id.images_to_pdf, "field 'imagesToPdf'", MyCardView.class);
    target.qrbarcodeToPdf = Utils.findRequiredViewAsType(source, R.id.qr_barcode_to_pdf, "field 'qrbarcodeToPdf'", MyCardView.class);
    target.textToPdf = Utils.findRequiredViewAsType(source, R.id.text_to_pdf, "field 'textToPdf'", MyCardView.class);
    target.viewFiles = Utils.findRequiredViewAsType(source, R.id.view_files, "field 'viewFiles'", MyCardView.class);
    target.viewHistory = Utils.findRequiredViewAsType(source, R.id.view_history, "field 'viewHistory'", MyCardView.class);
    target.splitPdf = Utils.findRequiredViewAsType(source, R.id.split_pdf, "field 'splitPdf'", MyCardView.class);
    target.mergePdf = Utils.findRequiredViewAsType(source, R.id.merge_pdf, "field 'mergePdf'", MyCardView.class);
    target.compressPdf = Utils.findRequiredViewAsType(source, R.id.compress_pdf, "field 'compressPdf'", MyCardView.class);
    target.removePages = Utils.findRequiredViewAsType(source, R.id.remove_pages, "field 'removePages'", MyCardView.class);
    target.rearrangePages = Utils.findRequiredViewAsType(source, R.id.rearrange_pages, "field 'rearrangePages'", MyCardView.class);
    target.extractImages = Utils.findRequiredViewAsType(source, R.id.extract_images, "field 'extractImages'", MyCardView.class);
    target.mPdfToImages = Utils.findRequiredViewAsType(source, R.id.pdf_to_images, "field 'mPdfToImages'", MyCardView.class);
    target.addPassword = Utils.findRequiredViewAsType(source, R.id.add_password, "field 'addPassword'", MyCardView.class);
    target.removePassword = Utils.findRequiredViewAsType(source, R.id.remove_password, "field 'removePassword'", MyCardView.class);
    target.rotatePdf = Utils.findRequiredViewAsType(source, R.id.rotate_pages, "field 'rotatePdf'", MyCardView.class);
    target.addWatermark = Utils.findRequiredViewAsType(source, R.id.add_watermark, "field 'addWatermark'", MyCardView.class);
    target.addImages = Utils.findRequiredViewAsType(source, R.id.add_images, "field 'addImages'", MyCardView.class);
    target.removeDuplicatePages = Utils.findRequiredViewAsType(source, R.id.remove_duplicates_pages_pdf, "field 'removeDuplicatePages'", MyCardView.class);
    target.invertPdf = Utils.findRequiredViewAsType(source, R.id.invert_pdf, "field 'invertPdf'", MyCardView.class);
    target.zipToPdf = Utils.findRequiredViewAsType(source, R.id.zip_to_pdf, "field 'zipToPdf'", MyCardView.class);
    target.excelToPdf = Utils.findRequiredViewAsType(source, R.id.excel_to_pdf, "field 'excelToPdf'", MyCardView.class);
    target.extractText = Utils.findRequiredViewAsType(source, R.id.extract_text, "field 'extractText'", MyCardView.class);
    target.addText = Utils.findRequiredViewAsType(source, R.id.add_text, "field 'addText'", MyCardView.class);
    target.recentList = Utils.findRequiredViewAsType(source, R.id.recent_list, "field 'recentList'", RecyclerView.class);
    target.recentLabel = Utils.findRequiredView(source, R.id.recent_lbl, "field 'recentLabel'");
    target.recentLayout = Utils.findRequiredViewAsType(source, R.id.recent_list_lay, "field 'recentLayout'", ViewGroup.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    HomeFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.imagesToPdf = null;
    target.qrbarcodeToPdf = null;
    target.textToPdf = null;
    target.viewFiles = null;
    target.viewHistory = null;
    target.splitPdf = null;
    target.mergePdf = null;
    target.compressPdf = null;
    target.removePages = null;
    target.rearrangePages = null;
    target.extractImages = null;
    target.mPdfToImages = null;
    target.addPassword = null;
    target.removePassword = null;
    target.rotatePdf = null;
    target.addWatermark = null;
    target.addImages = null;
    target.removeDuplicatePages = null;
    target.invertPdf = null;
    target.zipToPdf = null;
    target.excelToPdf = null;
    target.extractText = null;
    target.addText = null;
    target.recentList = null;
    target.recentLabel = null;
    target.recentLayout = null;
  }
}
