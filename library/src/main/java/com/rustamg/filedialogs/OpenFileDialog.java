package com.rustamg.filedialogs;

import java.io.File;


/**
 * Created at 30/01/15 18:58
 *
 * @author rustamg
 */
public class OpenFileDialog extends FileDialog {


    @Override
    protected int getLayoutResourceId() {

        return R.layout.dialog_open_file;
    }

    @Override
    public void onFileSelected(File file) {

        if (file.isFile()) {
            sendResult(file);
        }
        else {
            super.onFileSelected(file);
        }
    }
}
