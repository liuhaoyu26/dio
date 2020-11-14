package com.example.dio;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.alterdialog_ui);

        Log.d(TAG, "onCreate: ");

        final TextView textView = findViewById(R.id.textView);
        Button button = findViewById(R.id.button);


        textView.setVisibility(View.INVISIBLE);

        EditText editText = findViewById(R.id.editText);
        editText.setVisibility(View.INVISIBLE);

        button.setText("打开对话框");

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

                /*
                    加载布局文件 实例化成view
                 */
                final View view  = LayoutInflater.from(MainActivity.this).inflate(R.layout.alterdialog_ui,null,false);

                builder.setTitle("自定义对话框")
                        .setView(view)
                        .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                finish();
                            }
                        })
                        .setPositiveButton("确认", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                                EditText editText_name = view.findViewById(R.id.editText);
                                EditText editText_password = view.findViewById(R.id.paswdEdit);
                                final Editable name = editText_name.getText();
                                final Editable password = editText_password.getText();
                                if (name.toString().equals("abc") && password.toString().equals("123")){
                                    Toast.makeText(MainActivity.this,"登录成功",Toast.LENGTH_LONG)
                                            .show();
                                }
                            }
                        })
                        .create().show();

            }
        });



    }





}