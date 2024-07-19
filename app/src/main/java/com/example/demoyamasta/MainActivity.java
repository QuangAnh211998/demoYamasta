package com.example.demoyamasta;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.google.firebase.analytics.FirebaseAnalytics;

public class MainActivity extends AppCompatActivity {
    private EditText mEdtEmail;
    private EditText mEditPassword;
    private Button mBtnSignIn;
    private Button mBtnSignUp;
    private FirebaseAnalytics mFirebaseAnalytics;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);

        mEdtEmail = findViewById(R.id.edt_email);
        mEditPassword = findViewById(R.id.edt_password);
        mBtnSignIn = findViewById(R.id.btn_sign_in);
        mBtnSignUp = findViewById(R.id.btn_sign_up);

        mBtnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendEvent("Fuji");

                Intent intent = new Intent(getApplicationContext(), Home.class);
                startActivity(intent);
            }
        });

        mBtnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendEvent("Fansipan");

                Toast.makeText(getApplicationContext(), "Mời bạn đăng ký", Toast.LENGTH_LONG).show();
            }
        });
    }

    public void sendEvent(String label) {
        System.out.println("----------------start-------------------");
        Bundle bundle = new Bundle();
        bundle.putString("category", "メニュー");
        bundle.putString("label", label);
        bundle.putString("screenName", "チェックイン画面");
        mFirebaseAnalytics.logEvent("チェックイン", bundle);
        System.out.println("----------------end-------------------");
    }
}
