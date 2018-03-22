package com.app.arnont.kkminibus.activity;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toolbar;
import android.view.View;

import com.akexorcist.localizationactivity.ui.LocalizationActivity;
import com.app.arnont.kkminibus.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;


public class CommentActivity extends LocalizationActivity{


    EditText edtComment,edtNameComment,edtEmailComment;

    Button btnComment;
    TextView txtViewName ,txtViewEmail, txtViewComment;

    Toolbar toolbar;

    DatabaseReference mRootRef = FirebaseDatabase.getInstance().getReference();
    DatabaseReference mUsersRef = mRootRef.child("USERS");
    DatabaseReference mMessagesRef = mRootRef.child("messages");

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment);

        toolbar = findViewById(R.id.toolbarComment);
        toolbar.setTitle(R.string.comment_toolbar);
        setActionBar(toolbar);
        getSupportActionBar().hide();
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        txtViewName = findViewById(R.id.txtViewName);
        txtViewEmail = findViewById(R.id.txtViewEmail);


        edtNameComment = findViewById(R.id.edtNameComment);
        edtEmailComment = findViewById(R.id.edtEmailComment);
        edtComment = findViewById(R.id.edtCommentText);
        btnComment = findViewById(R.id.btnComment);
        txtViewComment = findViewById(R.id.txtViewComment);

        // Username
        edtNameComment.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {

                if (hasFocus) {
                    new Handler().postDelayed(new Runnable() {

                        @Override
                        public void run() {
                            // Show white background behind floating label
                            txtViewName.setVisibility(View.VISIBLE);
                        }
                    }, 100);
                } else {
                    // Required to show/hide white background behind floating label during focus change
                    if (edtNameComment.getText().length() > 0)
                        txtViewName.setVisibility(View.VISIBLE);
                    else
                        txtViewName.setVisibility(View.INVISIBLE);
                }
            }
        });

        // Password
        edtEmailComment.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {

                if (hasFocus) {
                    new Handler().postDelayed(new Runnable() {

                        @Override
                        public void run() {
                            // Show white background behind floating label
                            txtViewEmail.setVisibility(View.VISIBLE);
                        }
                    }, 100);
                } else {
                    // Required to show/hide white background behind floating label during focus change
                    if (edtEmailComment.getText().length() > 0)
                        txtViewEmail.setVisibility(View.VISIBLE);
                    else
                        txtViewEmail.setVisibility(View.INVISIBLE);
                }
            }
        });
        // Username
        edtComment.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {

                if (hasFocus) {
                    new Handler().postDelayed(new Runnable() {

                        @Override
                        public void run() {
                            // Show white background behind floating label
                            txtViewComment.setVisibility(View.VISIBLE);
                        }
                    }, 100);
                } else {
                    // Required to show/hide white background behind floating label during focus change
                    if (edtComment.getText().length() > 0)
                        txtViewComment.setVisibility(View.VISIBLE);
                    else
                        txtViewComment.setVisibility(View.INVISIBLE);
                }
            }
        });

        btnComment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addNewContact();
                startActivity(new Intent(CommentActivity.this, MainActivity.class));
                overridePendingTransition(R.anim.push_in, R.anim.push_in_exit);
                finish();
            }
        });


    }

    private void addNewContact() {
        String key = mMessagesRef.push().getKey();
        HashMap<String, Object> postValues = new HashMap<>();
        postValues.put("Email", edtEmailComment.getText().toString().trim());
        postValues.put("Comment", edtComment.getText().toString().trim());

        Map<String, Object> childUpdates = new HashMap<>();
        childUpdates.put("/user-messages/" + "Name: ' " + edtNameComment.getText().toString().trim() + " '/" + key, postValues);

        mRootRef.updateChildren(childUpdates);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.pop_out, R.anim.pop_out_exit);
    }
}
