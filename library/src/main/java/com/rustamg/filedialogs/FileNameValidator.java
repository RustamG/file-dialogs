package com.rustamg.filedialogs;
import android.support.annotation.NonNull;

import com.rengwuxian.materialedittext.validation.METValidator;
import com.rustamg.filedialogs.utils.TextUtils;


/**
 * Created at 31/01/15 13:29
 *
 * @author rustamg
 */
public class FileNameValidator extends METValidator {

    private final String mEmptyMessage;
    private final String mInvalidMessage;

    public FileNameValidator(String invalidMessage, String emptyMessage) {

        super(emptyMessage);

        mInvalidMessage = invalidMessage;
        mEmptyMessage = emptyMessage;
    }

    @Override
    public boolean isValid(@NonNull CharSequence charSequence, boolean isEmpty) {

        if (isEmpty || TextUtils.isEmpty(charSequence.toString())) {
            errorMessage = mEmptyMessage;
            return false;
        }

        if (charSequence.toString().matches("^[^A-Za-z_\\-\\s0-9\\.]+$")) {
            errorMessage = mInvalidMessage;
            return false;
        }

        return true;
    }
}
