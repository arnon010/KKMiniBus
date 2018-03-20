package com.app.arnont.kkminibus.activity;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
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

    Toolbar toolbar;


    private static final String TAG = "AddEventFragment";

    String strName;
    String strEmail;
    String strComment;

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

        edtNameComment = findViewById(R.id.edtNameComment);
        edtEmailComment = findViewById(R.id.edtEmailComment);
        edtComment = findViewById(R.id.edtComment);
        btnComment = findViewById(R.id.btnComment);

        strName = edtNameComment.getText().toString().trim();
        strEmail = edtEmailComment.getText().toString().trim();
        strComment = edtComment.getText().toString().trim();

        btnComment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addNewContact();
            }
        });


    }

    private void addNewContact() {
        String key = mMessagesRef.push().getKey();
        HashMap<String, Object> postValues = new HashMap<>();
        postValues.put("Email", strEmail);
        postValues.put("Comment", strComment);

        Map<String, Object> childUpdates = new HashMap<>();
        childUpdates.put("/user-messages/" + strName + "/" + key, postValues);

        mRootRef.updateChildren(childUpdates);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.pop_out, R.anim.pop_out_exit);
    }
}
