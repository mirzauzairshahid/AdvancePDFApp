package pdf.pdftool.fragment.texttopdf;

import android.app.Activity;
import androidx.annotation.NonNull;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;

import pdf.pdftool.R;
import pdf.pdftool.interfaces.Enhancer;
import pdf.pdftool.model.EnhancementOptionsEntity;
import pdf.pdftool.model.TextToPDFOptions;
import pdf.pdftool.util.DialogUtils;
import pdf.pdftool.util.StringUtils;

/**
 * An {@link Enhancer} that lets you add and remove passwords
 */
public class PasswordEnhancer implements Enhancer {

    private final Activity mActivity;
    private final EnhancementOptionsEntity mEnhancementOptionsEntity;
    private TextToPdfContract.View mView;
    private final TextToPDFOptions.Builder mBuilder;

    PasswordEnhancer(@NonNull final Activity activity,
                     @NonNull final TextToPdfContract.View view,
                     @NonNull final TextToPDFOptions.Builder builder) {
        mActivity = activity;
        mBuilder = builder;
        mBuilder.setPasswordProtected(false);
        mEnhancementOptionsEntity = new EnhancementOptionsEntity(
                mActivity, R.drawable.ic_set_password, R.string.set_password);
        mView = view;
    }

    @Override
    public void enhance() {
        MaterialDialog.Builder builder = DialogUtils.getInstance().createCustomDialogWithoutContent(mActivity,
                R.string.set_password);
        final MaterialDialog dialog = builder
                .customView(R.layout.custom_dialog, true)
                .neutralText(R.string.remove_dialog)
                .build();

        final View positiveAction = dialog.getActionButton(DialogAction.POSITIVE);
        final View neutralAction = dialog.getActionButton(DialogAction.NEUTRAL);
        final EditText passwordInput = dialog.getCustomView().findViewById(R.id.password);
        passwordInput.setText(mBuilder.getPassword());
        passwordInput.addTextChangedListener(
                new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                    }

                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {
                        positiveAction.setEnabled(s.toString().trim().length() > 0);
                    }

                    @Override
                    public void afterTextChanged(Editable input) {
                    }
                });

        positiveAction.setOnClickListener(v -> {
            if (StringUtils.getInstance().isEmpty(passwordInput.getText())) {
                StringUtils.getInstance().showSnackbar(mActivity, R.string.snackbar_password_cannot_be_blank);
            } else {
                mBuilder.setPassword(passwordInput.getText().toString());
                mBuilder.setPasswordProtected(true);
                onPasswordAdded();
                dialog.dismiss();
            }
        });

        if (StringUtils.getInstance().isNotEmpty(mBuilder.getPassword())) {
            neutralAction.setOnClickListener(v -> {
                mBuilder.setPassword(null);
                onPasswordRemoved();
                mBuilder.setPasswordProtected(false);
                dialog.dismiss();
                StringUtils.getInstance().showSnackbar(mActivity, R.string.password_remove);
            });
        }
        dialog.show();
        positiveAction.setEnabled(false);
    }

    @Override
    public EnhancementOptionsEntity getEnhancementOptionsEntity() {
        return mEnhancementOptionsEntity;
    }

    private void onPasswordAdded() {
        mEnhancementOptionsEntity
                .setImage(mActivity.getResources().getDrawable(R.drawable.baseline_done_24));
        mView.updateView();
    }

    private void onPasswordRemoved() {
        mEnhancementOptionsEntity
                .setImage(mActivity.getResources().getDrawable(R.drawable.ic_add_password));
        mView.updateView();
    }
}
