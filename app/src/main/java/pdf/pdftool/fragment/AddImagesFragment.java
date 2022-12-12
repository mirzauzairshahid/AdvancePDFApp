package pdf.pdftool.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import androidx.annotation.NonNull;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.afollestad.materialdialogs.MaterialDialog;
import com.airbnb.lottie.LottieAnimationView;
import com.dd.morphingbutton.MorphingButton;
import com.zhihu.matisse.Matisse;
import com.zhihu.matisse.MimeType;
import com.zhihu.matisse.engine.impl.PicassoEngine;
import com.zhihu.matisse.internal.entity.CaptureStrategy;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import pdf.pdftool.R;
import pdf.pdftool.adapter.MergeFilesAdapter;
import pdf.pdftool.interfaces.BottomSheetPopulate;
import pdf.pdftool.interfaces.OnBackPressedInterface;
import pdf.pdftool.util.BottomSheetCallback;
import pdf.pdftool.util.BottomSheetUtils;
import pdf.pdftool.util.CommonCodeUtils;
import pdf.pdftool.util.DialogUtils;
import pdf.pdftool.util.FileUriUtils;
import pdf.pdftool.util.FileUtils;
import pdf.pdftool.util.MorphButtonUtility;
import pdf.pdftool.util.PDFUtils;
import pdf.pdftool.util.PermissionsUtils;
import pdf.pdftool.util.StringUtils;

import static pdf.pdftool.util.Constants.ADD_IMAGES;
import static pdf.pdftool.util.Constants.AUTHORITY_APP;
import static pdf.pdftool.util.Constants.BUNDLE_DATA;
import static pdf.pdftool.util.Constants.READ_WRITE_CAMERA_PERMISSIONS;

public class AddImagesFragment extends Fragment implements BottomSheetPopulate,
        MergeFilesAdapter.OnClickListener, OnBackPressedInterface {

    private Activity mActivity;
    private String mPath;
    private MorphButtonUtility mMorphButtonUtility;
    private FileUtils mFileUtils;
    private BottomSheetUtils mBottomSheetUtils;
    private PDFUtils mPDFUtils;
    private static final int INTENT_REQUEST_PICK_FILE_CODE = 10;
    private static final int INTENT_REQUEST_GET_IMAGES = 13;
    private String mOperation;
    private static final int REQUEST_PERMISSIONS_CODE = 124;
    private static final ArrayList<String> mImagesUri = new ArrayList<>();
    private boolean mPermissionGranted = false;
    private BottomSheetBehavior mSheetBehavior;

    @BindView(R.id.lottie_progress)
    LottieAnimationView mLottieProgress;
    @BindView(R.id.selectFile)
    MorphingButton selectFileButton;
    @BindView(R.id.pdfCreate)
    MorphingButton mCreatePdf;
    @BindView(R.id.addImages)
    MorphingButton addImages;
    @BindView(R.id.bottom_sheet)
    LinearLayout layoutBottomSheet;
    @BindView(R.id.upArrow)
    ImageView mUpArrow;
    @BindView(R.id.layout)
    RelativeLayout mLayout;
    @BindView(R.id.recyclerViewFiles)
    RecyclerView mRecyclerViewFiles;
    @BindView(R.id.tvNoOfImages)
    TextView mNoOfImages;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_add_images, container, false);
        ButterKnife.bind(this, rootView);
        mPermissionGranted = PermissionsUtils.getInstance()
                .checkRuntimePermissions(this, READ_WRITE_CAMERA_PERMISSIONS);
        mSheetBehavior = BottomSheetBehavior.from(layoutBottomSheet);
        mSheetBehavior.setBottomSheetCallback(new BottomSheetCallback(mUpArrow, isAdded()));
        mOperation = getArguments().getString(BUNDLE_DATA);
        mLottieProgress.setVisibility(View.VISIBLE);
        mBottomSheetUtils.populateBottomSheetWithPDFs(this);

        resetValues();
        return rootView;
    }

    /**
     * Displays file chooser intent
     */
    @OnClick(R.id.selectFile)
    public void showFileChooser() {
        startActivityForResult(mFileUtils.getFileChooser(),
                INTENT_REQUEST_PICK_FILE_CODE);
    }

    /**
     * Called after Matisse Activity is called
     *
     * @param requestCode REQUEST Code for opening Matisse Activity
     * @param resultCode  result code of the process
     * @param data        Data of the image selected
     */
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode != Activity.RESULT_OK || data == null)
            return;

        switch (requestCode) {

            case INTENT_REQUEST_GET_IMAGES:
                mImagesUri.clear();
                mImagesUri.addAll(Matisse.obtainPathResult(data));

                if (mImagesUri.size() > 0) {
                    mNoOfImages.setText(String.format(mActivity.getResources()
                            .getString(R.string.images_selected), mImagesUri.size()));
                    mNoOfImages.setVisibility(View.VISIBLE);
                    StringUtils.getInstance().showSnackbar(mActivity, R.string.snackbar_images_added);
                    mCreatePdf.setEnabled(true);
                } else {
                    mNoOfImages.setVisibility(View.GONE);
                }

                mMorphButtonUtility.morphToSquare(mCreatePdf, mMorphButtonUtility.integer());
                break;

            case INTENT_REQUEST_PICK_FILE_CODE:
                setTextAndActivateButtons(FileUriUtils.getInstance().getFilePath(data.getData()));
                break;
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (grantResults.length < 1)
            return;
        if (requestCode == REQUEST_PERMISSIONS_CODE) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                mPermissionGranted = true;
                selectImages();
                StringUtils.getInstance().showSnackbar(mActivity, R.string.snackbar_permissions_given);
            } else
                StringUtils.getInstance().showSnackbar(mActivity, R.string.snackbar_insufficient_permissions);
        }
    }

    @OnClick(R.id.pdfCreate)
    public void parse() {
        StringUtils.getInstance().hideKeyboard(mActivity);
        if (mOperation.equals(ADD_IMAGES))
            getFileName();
    }

    private void getFileName() {
        MaterialDialog.Builder builder = DialogUtils.getInstance().createCustomDialog(mActivity,
                R.string.creating_pdf, R.string.enter_file_name);
        builder.input(getString(R.string.example), null, (dialog, input) -> {
            if (StringUtils.getInstance().isEmpty(input)) {
                StringUtils.getInstance().showSnackbar(mActivity, R.string.snackbar_name_not_blank);
            } else {
                final String filename = input.toString();
                FileUtils utils = new FileUtils(mActivity);
                if (!utils.isFileExist(filename + getString(R.string.pdf_ext))) {
                    this.addImagesToPdf(filename);
                } else {
                    MaterialDialog.Builder builder2 = DialogUtils.getInstance().createOverwriteDialog(mActivity);
                    builder2.onPositive((dialog2, which) ->
                            this.addImagesToPdf(filename)).onNegative((dialog1, which) -> getFileName()).show();
                }
            }
        }).show();
    }

    /**
     * Adds images to existing PDF
     *
     * @param output - path of output PDF
     */
    private void addImagesToPdf(String output) {
        int index = mPath.lastIndexOf("/");
        String outputPath = mPath.replace(mPath.substring(index + 1),
                output + mActivity.getString(R.string.pdf_ext));

        if (mImagesUri.size() > 0) {
            MaterialDialog progressDialog = DialogUtils.getInstance().createAnimationDialog(mActivity);
            progressDialog.show();
            mPDFUtils.addImagesToPdf(mPath, outputPath, mImagesUri);
            mMorphButtonUtility.morphToSuccess(mCreatePdf);
            resetValues();
            progressDialog.dismiss();
        } else {
            StringUtils.getInstance().showSnackbar(mActivity, R.string.no_images_selected);
        }
    }

    private void resetValues() {
        mPath = null;
        mImagesUri.clear();
        mMorphButtonUtility.initializeButton(selectFileButton, mCreatePdf);
        mMorphButtonUtility.initializeButton(selectFileButton, addImages);
        mNoOfImages.setVisibility(View.GONE);
    }

    /**
     * Adding Images to PDF
     */
    @OnClick(R.id.addImages)
    void startAddingImages() {
        if (mPermissionGranted)
            selectImages();
        else {
            PermissionsUtils.getInstance().requestRuntimePermissions(this,
                    READ_WRITE_CAMERA_PERMISSIONS,
                    REQUEST_PERMISSIONS_CODE);
        }
    }

    /**
     * Opens Matisse activity to select Images
     */
    private void selectImages() {
        Matisse.from(this)
                .choose(MimeType.ofImage(), false)
                .countable(true)
                .capture(true)
                .captureStrategy(new CaptureStrategy(true, AUTHORITY_APP))
                .maxSelectable(1000)
                .imageEngine(new PicassoEngine())
                .forResult(INTENT_REQUEST_GET_IMAGES);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mActivity = (Activity) context;
        mMorphButtonUtility = new MorphButtonUtility(mActivity);
        mFileUtils = new FileUtils(mActivity);
        mPDFUtils = new PDFUtils(mActivity);
        mBottomSheetUtils = new BottomSheetUtils(mActivity);
    }

    @Override
    public void onItemClick(String path) {
        mSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
        setTextAndActivateButtons(path);
    }

    private void setTextAndActivateButtons(String path) {
        mPath = path;
        mMorphButtonUtility.setTextAndActivateButtons(path,
                selectFileButton, addImages);

    }

    @Override
    public void onPopulate(ArrayList<String> paths) {
        CommonCodeUtils.getInstance().populateUtil(mActivity, paths,
                this, mLayout, mLottieProgress, mRecyclerViewFiles);
    }

    @Override
    public void closeBottomSheet() {
        CommonCodeUtils.getInstance().closeBottomSheetUtil(mSheetBehavior);
    }

    @Override
    public boolean checkSheetBehaviour() {
        return CommonCodeUtils.getInstance().checkSheetBehaviourUtil(mSheetBehavior);
    }
}
