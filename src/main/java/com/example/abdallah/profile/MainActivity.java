package com.example.abdallah.profile;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.Spanned;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText f_name, l_name, email, phone, city , oldpassword , newpassword;
    private Button update ;
    private String blockCharacterSet = "~#^|$%&*!:;.,><[]{}%'/";
    private InputFilter filter = new InputFilter() {

        @Override
        public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {

            if (source != null && blockCharacterSet.contains(("" + source))) {
                return "";
            }
            return null;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        update = (Button) findViewById(R.id.button_update_personal_info);
        update();
    }

    public void update() {
        f_name = (EditText) findViewById(R.id.edit_user_fname);
        l_name = (EditText) findViewById(R.id.edit_user_lname);
        email = (EditText) findViewById(R.id.edit_user_email);
        phone = (EditText) findViewById(R.id.edit_user_phone);
        city = (EditText) findViewById(R.id.edit_user_city);
        oldpassword = (EditText) findViewById(R.id.edit_user_old_password);
        newpassword = (EditText) findViewById(R.id.edit_user_new_password);
        f_name.setFilters(new InputFilter[]{filter});
        l_name.setFilters(new InputFilter[]{filter});
        oldpassword.setFilters(new InputFilter[]{filter});
        newpassword.setFilters(new InputFilter[]{filter});
        city.setFilters(new InputFilter[]{filter});


        update.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Context context = getApplicationContext();
                        int duration = Toast.LENGTH_SHORT;
                        if (f_name.getText().toString().trim().length() == 0) {
                            Toast.makeText(context, "Please Enter Your First Name Correctly .", duration).show();
                        } else if (l_name.getText().toString().trim().length() == 0) {
                            Toast.makeText(context, "Please Enter Your Last Name Correctly .", duration).show();
                        } else if (email.getText().toString().trim().length() == 0) {
                            Toast.makeText(context, "Please Enter Your Email .", duration).show();
                        }else if (oldpassword.getText().toString().trim().length() != 0) {
                            if ( oldpassword.getText().toString() != newpassword.getText().toString() ){
                                Toast.makeText(context, "sorry not match password .", duration).show();
                            }
                        }else if (phone.getText().toString().trim().length() == 0) {
                            Toast.makeText(context, "Please Enter Your Phone .", duration).show();
                        }


                    }
                }
        );
    }

}



