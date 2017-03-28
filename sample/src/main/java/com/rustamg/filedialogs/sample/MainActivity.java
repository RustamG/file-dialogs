package com.rustamg.filedialogs.sample;

import android.Manifest;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.rustamg.filedialogs.FileDialog;
import com.rustamg.filedialogs.OpenFileDialog;
import com.rustamg.filedialogs.SaveFileDialog;
import com.tbruyelle.rxpermissions.RxPermissions;

import java.io.File;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import rx.functions.Action1;


public class MainActivity extends AppCompatActivity implements FileDialog.OnFileSelectedListener {

    @InjectView(R.id.et_extension)
    protected EditText mExtensionText;
    @InjectView(R.id.btn_test_open_dialog)
    protected Button mOpenFileButton;
    @InjectView(R.id.btn_test_save_dialog)
    protected Button mSaveFileButton;

    private boolean mStoragePermissionGranted;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.inject(this);

        requestStoragePermissions();
    }

    private void requestStoragePermissions() {

        new RxPermissions(this)
                .request(Manifest.permission.READ_EXTERNAL_STORAGE)
                .subscribe(new Action1<Boolean>() {

                    @Override
                    public void call(Boolean granted) {

                        mStoragePermissionGranted = granted;
                    }
                });
    }

    @OnClick(R.id.btn_test_open_dialog)
    protected void onOpenDialogClick() {

        if (mStoragePermissionGranted) {
            showFileDialog(new OpenFileDialog(), OpenFileDialog.class.getName());
        }
        else {
            showPermissionError();
        }
    }

    @OnClick(R.id.btn_test_save_dialog)
    protected void onSaveDialogClick() {

        if (mStoragePermissionGranted) {
            showFileDialog(new SaveFileDialog(), SaveFileDialog.class.getName());
        }
        else {
            showPermissionError();
        }
    }

    private void showPermissionError() {

        Toast.makeText(this, "Storage permission is not granted", Toast.LENGTH_LONG).show();
    }

    private void showFileDialog(FileDialog dialog, String tag) {

        Bundle args = new Bundle();
        args.putString(FileDialog.EXTENSION, mExtensionText.getText().toString());
        dialog.setArguments(args);
        dialog.setStyle(DialogFragment.STYLE_NO_TITLE, R.style.Theme_Sample);
        dialog.show(getSupportFragmentManager(), tag);
    }

    @Override
    public void onFileSelected(FileDialog dialog, File file) {

        Toast.makeText(this, getString(R.string.toast_file_selected, file.getName()), Toast.LENGTH_LONG).show();
    }
}
