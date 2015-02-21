package com.rustamg.filedialogs;
import java.io.File;
import java.io.FileFilter;


public class ExtensionFilter implements FileFilter {


    private final String mExtension;

    public ExtensionFilter(String extension) {

        mExtension = extension.toLowerCase().replaceAll("\\.", "");
    }

    @Override
    public boolean accept(File file) {

        return file.isDirectory() || file.getName().toLowerCase().endsWith(mExtension);
    }
}
