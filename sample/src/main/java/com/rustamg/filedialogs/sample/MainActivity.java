package com.rustamg.filedialogs.sample;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.rustamg.filedialogs.FileDialog;
import com.rustamg.filedialogs.OpenFileDialog;
import com.rustamg.filedialogs.SaveFileDialog;

import java.io.File;

import butterknife.ButterKnife;
import butterknife.InjectView;


public class MainActivity extends ActionBarActivity
        implements View.OnClickListener, FileDialog.OnFileSelectedListener {

    @InjectView(R.id.et_extension)
    protected EditText mExtensionText;
    @InjectView(R.id.btn_test_open_dialog)
    protected Button mOpenFileButton;
    @InjectView(R.id.btn_test_save_dialog)
    protected Button mSaveFileButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.inject(this);

        mOpenFileButton.setOnClickListener(this);
        mSaveFileButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.btn_test_open_dialog: {
                showFileDialog(new OpenFileDialog(), OpenFileDialog.class.getName());
                break;
            }
            case R.id.btn_test_save_dialog: {
                showFileDialog(new SaveFileDialog(), SaveFileDialog.class.getName());
                break;
            }
        }
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
