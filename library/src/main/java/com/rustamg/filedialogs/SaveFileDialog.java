package com.rustamg.filedialogs;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.rengwuxian.materialedittext.MaterialEditText;

import java.io.File;

import butterknife.InjectView;


/**
 * Created at 31/01/15 12:07
 *
 * @author rustamg
 */
public class SaveFileDialog extends FileDialog implements Toolbar.OnMenuItemClickListener {

    @InjectView(R.id.et_filename)
    protected MaterialEditText mFileNameText;

    @Override
    protected int getLayoutResourceId() {

        return R.layout.dialog_save_file;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);

        mToolbar.inflateMenu(R.menu.dialog_save);
        mToolbar.setOnMenuItemClickListener(this);

        mFileNameText.addValidator(new FileNameValidator(getString(R.string.error_invalid_file_name),
                getString(R.string.error_empty_field)));
    }

    @Override
    public void onFileSelected(final File file) {

        if (file.isFile()) {

            confirmOverwrite(file);
        }
        else {
            super.onFileSelected(file);
        }
    }

    private void confirmOverwrite(final File file) {

        new AlertDialog.Builder(getActivity())
                .setMessage(R.string.confirm_overwrite_file)
                .setPositiveButton(R.string.label_button_overwrite, new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        sendResult(file);
                    }
                })
                .setNegativeButton(R.string.label_button_cancel, null)
                .create().show();
    }


    @Override
    public boolean onMenuItemClick(MenuItem menuItem) {

        if (menuItem.getItemId() == R.id.menu_apply && mFileNameText.validate()) {

            File result = new File(mCurrentDir, mFileNameText.getText() + (mExtension != null ? mExtension : ""));

            if (result.exists()) {
                confirmOverwrite(result);
            }
            else {
                sendResult(result);
            }
        }

        return false;
    }
}
