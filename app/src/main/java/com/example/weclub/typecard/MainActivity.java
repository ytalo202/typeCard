package com.example.weclub.typecard;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.weclub.typecard.stripe.textwatcher.DigitCardFormatWatcher;

public class MainActivity extends AppCompatActivity {
    Validator validator = new Validator();

    EditText editText;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.txtNum);
        imageView = findViewById(R.id.tarjeta);

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence s, int i, int i1, int i2) {
                Switch(validator.validate0(s.toString()));


                if (validator.validate0(s.toString()) == 3 || validator.validate0(s.toString()) == 2){
                    fourSix();

                    Log.v("6","lol");
                    if (validator.validate0(s.toString()) == 2){
                        int maxLength = 17;
                        editText.setFilters(new InputFilter[] {new InputFilter.LengthFilter(maxLength)});
                    }

                    if (validator.validate0(s.toString()) == 3){
                        int maxLength = 16;
                        editText.setFilters(new InputFilter[] {new InputFilter.LengthFilter(maxLength)});
                    }

                }
                else {
                    four();
                    int maxLength = 19;
                    editText.setFilters(new InputFilter[] {new InputFilter.LengthFilter(maxLength)});
                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    TextWatcher four =  new DigitCardFormatWatcher(editText,4);
    TextWatcher six =  new DigitCardFormatWatcher(editText,6);

    public void fourSix(){
        try {
            editText.removeTextChangedListener(four);
            editText.removeTextChangedListener(six);
        }catch (Exception e){

        }
        editText.addTextChangedListener(six);
    }

    public void Switch(int type){
        switch (type){
            case 0 :{
                imageView.setImageResource(R.drawable.visa);
                break;
            }

            case 1 :{
                imageView.setImageResource(R.drawable.master);
                break;
            }

            case 2 :{
                imageView.setImageResource(R.drawable.american);
                break;
            }

            case 3 :{
                imageView.setImageResource(R.drawable.diners);
                break;
            }

            case 4 :{
                imageView.setImageResource(R.drawable.discover);
                break;
            }

            default:
            {
                imageView.setImageResource(R.drawable.tarjeta);

                break;
            }
        }
    }




    public void four(){
        try {
            editText.removeTextChangedListener(six);
            editText.removeTextChangedListener(four);
        }catch (Exception e){
        }
        editText.addTextChangedListener(four);
    }


}
