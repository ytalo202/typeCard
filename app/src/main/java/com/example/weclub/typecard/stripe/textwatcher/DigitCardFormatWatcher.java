package com.example.weclub.typecard.stripe.textwatcher;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.widget.EditText;

public class DigitCardFormatWatcher implements TextWatcher {

    private static final char space = '-';
    EditText editText;
    int type;

    public DigitCardFormatWatcher(EditText editText, int type) {
        this.editText = editText;
        this.type = type;
    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
    }

    @Override
    public void afterTextChanged(Editable s) {

        if (type == 4) {
            if (s.length() > 0 && (s.length() % 5) == 0) {
                final char c = s.charAt(s.length() - 1);
                if (space == c) {
                    s.delete(s.length() - 1, s.length());
                }
            }
            if (s.length() > 0 && (s.length() % 5) == 0) {
                char c = s.charAt(s.length() - 1);
                if (Character.isDigit(c) && TextUtils.split(s.toString(), String.valueOf(space)).length <= 3) {
                    s.insert(s.length() - 1, String.valueOf(space));
                }
            }

        } else {
            char c3 = 0;
            if (s.length() > 0 && (s.length() % 5) == 0) {
                final char c = s.charAt(s.length() - 1);
                if (space == c) {
                    s.delete(s.length() - 1, s.length());
                }
            }
            try {
                c3 = s.charAt(s.length() - 1);
            } catch (Exception e) {
            }
            if (space == c3) {
                try {
                    s.delete(s.length() - 1, s.length());
                } catch (Exception e) {
                }
            }
            if (s.length() <= 5) {
                if (s.length() > 0 && (s.length() % 5) == 0) {
                    char c1 = s.charAt(s.length() - 1);
                    if (Character.isDigit(c1) && TextUtils.split(s.toString(), String.valueOf(space)).length <= 3) {
                        s.insert(s.length() - 1, String.valueOf(space));
                    }
                }
            }
            if (s.length() <= 12) {
                if (s.length() > 5 && (s.length() % 12) == 0) {
                    s.insert(s.length() - 1, String.valueOf(space));
                }
            }
        }
    }
}