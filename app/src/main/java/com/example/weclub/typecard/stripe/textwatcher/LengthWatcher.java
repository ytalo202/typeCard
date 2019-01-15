package com.example.weclub.typecard.stripe.textwatcher;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

public class LengthWatcher implements TextWatcher {

        int count;
        EditText next;

        public LengthWatcher(int count, EditText next) {
            this.count = count;
            this.next = next;
        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        @Override
        public void afterTextChanged(Editable s) {
            if (s.length() >= count) {
                next.requestFocus();
            }
        }
    }