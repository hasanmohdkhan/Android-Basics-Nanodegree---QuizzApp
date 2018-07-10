package com.example.hasanzian.quizz;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //Declared variables for Activity
    private RadioButton q1_4, q4_3, q5_3;
    private RadioGroup mRadioGroup_que_1, mRadioGroup_que_4, mRadioGroup_que_5;
    private CheckBox mCheckBox_1, mCheckBox_2, mCheckBox_3, mCheckBox_4;
    private int mark, q3_mark;
    private EditText mEditTextResponse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //hiding keyboard on application start
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        setContentView(R.layout.activity_main);
        //Radio button for Questions (Q1,Q4,Q5)
        q1_4 = findViewById(R.id.que_1_option_4);
        q4_3 = findViewById(R.id.que_4_option_3);
        q5_3 = findViewById(R.id.que_5_option_3);

        //Text View for Questions (Q1.. to Q5)
        TextView mQue_1 = findViewById(R.id.question_1);
        TextView mQue_2 = findViewById(R.id.question_2);
        TextView mQue_3 = findViewById(R.id.question_3);
        TextView mQue_4 = findViewById(R.id.question_4);
        TextView mQue_5 = findViewById(R.id.question_5);

        //Radio Group for answers (Q1,Q4,Q5)
        mRadioGroup_que_1 = findViewById(R.id.radio_group_ques_1);
        mRadioGroup_que_4 = findViewById(R.id.radio_group_ques_4);
        mRadioGroup_que_5 = findViewById(R.id.radio_group_ques_5);

        //CheckBox for question number 2
        mCheckBox_1 = findViewById(R.id.checkbox_1);
        mCheckBox_2 = findViewById(R.id.checkbox_2);
        mCheckBox_3 = findViewById(R.id.checkbox_3);
        mCheckBox_4 = findViewById(R.id.checkbox_4);

        //EditText box for question number Q3
        mEditTextResponse = findViewById(R.id.edit_text_view);

        //Setting up Text view
        mQue_1.setText(getString(R.string.question_1_str));
        mQue_2.setText(getString(R.string.question_2_str));
        mQue_3.setText(getString(R.string.question_3_str));
        mQue_4.setText(getString(R.string.question_4_str));
        mQue_5.setText(getString(R.string.question_5_str));

        //Listener for Edit text box
        mEditTextResponse.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                String string = mEditTextResponse.getText().toString().trim().toLowerCase();
                if (string.equals(getString(R.string.static_binding_str))) {
                    q3_mark = 1;
                } else {
                    q3_mark = 0;
                }
            }
        });
    }


    //processResult is use to process response Enter by user
    public void processResult(View view) {
        boolean b_q1_4 = q1_4.isChecked();
        int q1_mark;
        if (b_q1_4) {
            q1_mark = 1;
        } else {
            q1_mark = 0;
        }
        boolean b_q4_3 = q4_3.isChecked();
        int q4_mark;
        if (b_q4_3) {
            q4_mark = 1;
        } else {
            q4_mark = 0;
        }
        boolean b_q5_3 = q5_3.isChecked();
        int q5_mark;
        if (b_q5_3) {
            q5_mark = 1;
        } else {
            q5_mark = 0;
        }

        int q2_mark;
        if (mCheckBox_1.isChecked() && mCheckBox_2.isChecked() && mCheckBox_3.isChecked() && !mCheckBox_4.isChecked()) {
            q2_mark = 1;
        } else {
            q2_mark = 0;
        }
        mark = q1_mark + q4_mark + q5_mark + q2_mark + q3_mark;

        Toast.makeText(getApplicationContext(), getString(R.string.Result_str_toast_pt1) + mark, Toast.LENGTH_SHORT).show();
    }


    //Reset button method
    public void resetQuestion(View view) {
        mRadioGroup_que_1.clearCheck();
        mRadioGroup_que_4.clearCheck();
        mRadioGroup_que_5.clearCheck();
        mCheckBox_1.setChecked(false);
        mCheckBox_2.setChecked(false);
        mCheckBox_3.setChecked(false);
        mCheckBox_4.setChecked(false);
        mEditTextResponse.setText("");
        mark = 0;
    }


    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(getString(R.string.response_key), mark);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        mark = savedInstanceState.getInt(getString(R.string.response_key), mark);
    }
}










