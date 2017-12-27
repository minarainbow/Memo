package com.example.user.memo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText mMemoEdit = null;
    TextFileManager mTextFileManager = new TextFileManager(this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mMemoEdit=(EditText) findViewById(R.id.memo_edit);
    }

    public void onClick(View view) {
        switch(view.getId()) {
            case R.id.load_btn: {
                String memoData = mTextFileManager.load();
                mMemoEdit.setText(memoData);
                Toast.makeText(this, "Successfully loaded", Toast.LENGTH_LONG).show();
                break;
            }
            case R.id.save_btn: {
                String memoData = mMemoEdit.getText().toString();
                mTextFileManager.save(memoData);
                mMemoEdit.setText("");
                Toast.makeText(this, "Successfully saved", Toast.LENGTH_LONG).show();
                break;
            }
            case R.id.delete_btn: {
                mTextFileManager.delete();
                mMemoEdit.setText("");
                Toast.makeText(this, "Successfully deleted", Toast.LENGTH_LONG).show();
                break;
            }
        }
    }
}

