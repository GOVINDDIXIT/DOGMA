package com.example.govind.techie;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class LogOut extends AppCompatActivity {

    private Button mLogOutButton;
    private Button LinkToBlogBtn;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_out);
        LinkToBlogBtn = findViewById(R.id.linktoBlogBtn);
        LinkToBlogBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                openWebPage(getResources().getString(R.string.Website));
            }
        });

        mAuth=FirebaseAuth.getInstance();
       mAuthListener = new FirebaseAuth.AuthStateListener() {
           @Override
           public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
               if(firebaseAuth.getCurrentUser()==null){
                   startActivity(new Intent(LogOut.this,Login.class));
               }
           }
       };

        mLogOutButton=findViewById(R.id.LogOutBtn);
        mLogOutButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                mAuth.signOut();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
    }
    public void openWebPage(String url) {
        Toast.makeText(LogOut.this, "Wait a while....", Toast.LENGTH_SHORT).show();
        Intent implicit = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(implicit);
    }
}
