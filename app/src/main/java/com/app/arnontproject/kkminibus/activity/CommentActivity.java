package com.app.arnontproject.kkminibus.activity;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;
import android.view.View;

import com.akexorcist.localizationactivity.ui.LocalizationActivity;
import com.app.arnontproject.kkminibus.R;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;


public class CommentActivity extends LocalizationActivity{


    EditText edtComment,edtNameComment,edtEmailComment;

    Button btnComment;
    TextView txtViewName ,txtViewEmail, txtViewComment,textView;

    Toolbar toolbar;

    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

    DatabaseReference mRootRef = FirebaseDatabase.getInstance().getReference();
    DatabaseReference mUsersRef = mRootRef.child("USERS");
    DatabaseReference mMessagesRef = mRootRef.child("messages");

    private static final String NAME_KEY = "Name";
    private static final String EMAIL_KEY = "Email";
    private static final String COMMENT_KEY = "Comment";

    FirebaseFirestore db;

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

        db = FirebaseFirestore.getInstance();

        txtViewName = findViewById(R.id.txtViewName);
        txtViewEmail = findViewById(R.id.txtViewEmail);


        edtNameComment = findViewById(R.id.edtNameComment);
        edtEmailComment = findViewById(R.id.edtEmailComment);
        edtComment = findViewById(R.id.edtCommentText);
        btnComment = findViewById(R.id.btnComment);
        txtViewComment = findViewById(R.id.txtViewComment);
        textView = findViewById(R.id.textView);

        // Username
        edtNameComment.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {

                if (hasFocus && TextUtils.isEmpty(edtNameComment.getText())) {
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
                if (edtEmailComment.getText().toString().trim().matches(emailPattern)) {
                    startActivity(new Intent(CommentActivity.this, MainActivity.class));
                    Toast.makeText(getApplicationContext(),"valid email address", Toast.LENGTH_SHORT).show();
                    addNewContactRealTimeDatabase();
                    addNewContactCloudFireStore();
                    overridePendingTransition(R.anim.push_in, R.anim.push_in_exit);
                    finish();
                    Log.d("Check", "valid email address");
                } else {
                    Toast.makeText(getApplicationContext(),"Invalid email address", Toast.LENGTH_SHORT).show();
                    Log.d("Check", "Invalid email address");
                }


                if (TextUtils.isEmpty(edtNameComment.getText())) {
                    edtNameComment.setError(getResources().getString(R.string.please_comment));
                }
                if (TextUtils.isEmpty(edtEmailComment.getText())) {
                    edtEmailComment.setError(getResources().getString(R.string.please_comment));
                }
                if (TextUtils.isEmpty(edtComment.getText())) {
                    edtComment.setError(getResources().getString(R.string.please_comment));
                }

            }
        });


    }

    private void addNewContactRealTimeDatabase() {
        //FireBase RealTime Database
        String key = mMessagesRef.push().getKey();
        HashMap<String, Object> postValues = new HashMap<>();
        postValues.put("Email", edtEmailComment.getText().toString().trim());
        postValues.put("Comment", edtComment.getText().toString().trim());

        Map<String, Object> childUpdates = new HashMap<>();
        childUpdates.put("/KK MiniBus/" + "Name: ' " + edtNameComment.getText().toString().trim() + " '/" + key, postValues);

        mRootRef.updateChildren(childUpdates);

    }

    private void addNewContactCloudFireStore() {
        Map<String, Object> newContact = new HashMap<>();
        newContact.put(NAME_KEY, edtNameComment.getText().toString().trim());
        newContact.put(EMAIL_KEY, edtEmailComment.getText().toString().trim());
        newContact.put(COMMENT_KEY, edtComment.getText().toString().trim());

        db.collection("KK MiniBus").add(newContact)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Toast.makeText(CommentActivity.this, "Comment Success", Toast.LENGTH_SHORT);

                        finish();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(CommentActivity.this, "Cannot Comment" + e.toString(), Toast.LENGTH_SHORT);
                        Log.d("Fail Send Data", e.toString());
                    }
                });

    }





    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.pop_out, R.anim.pop_out_exit);
    }
}
