package com.chinachino.regex;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    EditText regex_tx, text;
    Button run;
    List<Integer> starts,ends;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        run = findViewById(R.id.button_run);
        regex_tx = findViewById(R.id.regex_text);
        text = findViewById(R.id.text);
        run.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                starts=new ArrayList<>();
                ends=new ArrayList<>();
                Pattern pattern = Pattern.compile(regex_tx.getText().toString());
                Matcher m = pattern.matcher(text.getText().toString());
                while (m.find()) {
                    starts.add(m.start());
                    ends.add(m.end());
                }
                for (int i=0;i<starts.size();++i)
                   text.setSelection(starts.get(i),ends.get(i));
            }
        });

    }
}
