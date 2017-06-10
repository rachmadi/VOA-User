package id.ac.mdp.voa.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

import id.ac.mdp.voa.R;

public class LoginActivity extends AppCompatActivity {

    private Button mButtonLogin, mButtonViewPassword;
    private EditText mEditTextUsername, mEditTextPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mButtonLogin = (Button)findViewById(R.id.button_Login);

        mEditTextUsername = (EditText)findViewById(R.id.edit_text_username);
        mEditTextPassword = (EditText)findViewById(R.id.edit_text_password);
        mButtonViewPassword = (Button)findViewById(R.id.button_view_password);
        mButtonViewPassword.setVisibility(View.GONE);

        mButtonViewPassword.setOnTouchListener((new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if(motionEvent.getAction()== MotionEvent.ACTION_UP){
                    // etpassword.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                    mEditTextPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }else if(motionEvent.getAction()==MotionEvent.ACTION_DOWN){
                    // etpassword.setInputType(InputType.TYPE_CLASS_TEXT);
                    mEditTextPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                }
                return true;
            }
        }));

        mButtonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, MainActivity.class));
                finish();
            }
        });

        mEditTextPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(start>0 || count>0){
                    mButtonViewPassword.setVisibility(View.VISIBLE);
                }else{
                    mButtonViewPassword.setVisibility(View.GONE);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }
}
