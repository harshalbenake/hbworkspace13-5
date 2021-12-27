package com.elitetechnologies.mcq;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.wefika.horizontalpicker.HorizontalPicker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity implements HorizontalPicker.OnItemSelected, HorizontalPicker.OnItemClicked {
        ArrayList<String> questionArrayList=new ArrayList<>();
    ArrayList<String> optionsArrayList=new ArrayList<>();
    int index=0;
    private TextView mtv_question;
    private RadioGroup mrg_options;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        HorizontalPicker hp_horizontalpicker = (HorizontalPicker) findViewById(R.id.hp_horizontalpicker);
        hp_horizontalpicker.setOnItemClickedListener(this);
        hp_horizontalpicker.setOnItemSelectedListener(this);

        mrg_options = (RadioGroup) findViewById(R.id.rg_options);

        mtv_question = (TextView) findViewById(R.id.tv_question);
        Button btn_next = (Button) findViewById(R.id.btn_next);
        Button btn_previous = (Button) findViewById(R.id.btn_previous);

        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(index<questionArrayList.size()-1) {
                    index=index + 1;
                    setQuestionAndOptions(index);
                }
            }
        });

        btn_previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(index>0) {
                    index=index - 1;
                    setQuestionAndOptions(index);
                }
            }
        });

        addData();
    }

    private void addData() {
        questionArrayList.add("Question 1");
        questionArrayList.add("Question 2");
        questionArrayList.add("Question 3");
        questionArrayList.add("Question 4");
        questionArrayList.add("Question 5");
        questionArrayList.add("Question 6");
        questionArrayList.add("Question 7");
        questionArrayList.add("Question 8");
        questionArrayList.add("Question 9");
        questionArrayList.add("Question 10");

        optionsArrayList.add("Option 11,Option 12,Option 13,Option 14");
        optionsArrayList.add("Option 21,Option 22,Option 23,Option 24");
        optionsArrayList.add("Option 31,Option 32,Option 33,Option 34");
        optionsArrayList.add("Option 41,Option 42,Option 43,Option 44");
        optionsArrayList.add("Option 51,Option 52,Option 53,Option 54");
        optionsArrayList.add("Option 61,Option 62,Option 63,Option 64");
        optionsArrayList.add("Option 71,Option 72,Option 73,Option 74");
        optionsArrayList.add("Option 81,Option 82,Option 83,Option 84");
        optionsArrayList.add("Option 91,Option 92,Option 93,Option 94");
        optionsArrayList.add("Option 101,Option 102,Option 103,Option 104");

       setQuestionAndOptions(index);
    }

    private void setQuestionAndOptions(int index) {
        String strQues = questionArrayList.get(index);
        mtv_question.setText(strQues);

        List<String> optionList = Arrays.asList(optionsArrayList.get(index).split("\\s*,\\s*"));

        List<String> radioItemList = new ArrayList<String>();
        radioItemList.addAll(optionList);

        final RadioButton[] rb = new RadioButton[radioItemList.size()];
        mrg_options.removeAllViews();
        for (int i = 0; i < radioItemList.size(); i++) {
            rb[i] = new RadioButton(MainActivity.this);
            rb[i].setText(radioItemList.get(i));
            mrg_options.addView(rb[i], i);
        }
    }


    @Override
    public void onItemSelected(int index)    {
        setQuestionAndOptions(index);
    }

    @Override
    public void onItemClicked(int index) {
        Toast.makeText(this, "Item clicked", Toast.LENGTH_SHORT).show();
    }
}