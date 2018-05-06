package com.example.kaherine.parcialintento6;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.Serializable;

public class AddContact extends AppCompatActivity implements Serializable {
    /*private ImageButton Profilepic;
    private EditText Name;
    private EditText Number;
    private EditText Email;
    private int RESULT_LOAD_IMG = 1;
    private FloatingActionButton Upload;
    private ImageButton Insert;
    private Uri ImageUriU;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addcontact);

        Profilepic = findViewById(R.id.add_image);
        Name = findViewById(R.id.name_fill);
        Number = findViewById(R.id.number_fill);
        Email = findViewById(R.id.mail_fill);
        Upload = findViewById(R.id.UploadAdd);
        Insert = findViewById(R.id.InsertNewC);

        ImageUriU = Uri.parse("android.resource://com.example.katherine.ParcialIntento6/" + R.drawable.ic_account_circle_black_36dp);

        Upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
                photoPickerIntent.setType("image/*");
                startActivityForResult(photoPickerIntent, RESULT_LOAD_IMG);
            }
        });
        Insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(),MainActivity.class);
                intent.putExtra("ADDED", new Contact(Name.getText().toString(),
                        Number.getText().toString(),ImageUriU+""
                        ,Email.getText().toString(),false));
                v.getContext().startActivity(intent);
            }
        });
    }*/

}
