package com.example.hasanzian.quizz;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //Declared variables for Activity
    private RadioGroup mRadioGroup_que_1, mRadioGroup_que_4, mRadioGroup_que_5;
    private CheckBox mCheckBox_1, mCheckBox_2, mCheckBox_3, mCheckBox_4;
    private int mark = 0;
    private EditText mEditTextResponse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
                String string = mEditTextResponse.getText().toString().toLowerCase();
                if (string.equals(getString(R.string.static_binding_str))) {
                    mark = mark + 1;
                }
            }
        });
    }


    public void processResult(View view) {
        Toast.makeText(getApplicationContext(), getString(R.string.Result_str_toast_pt1) + mark, Toast.LENGTH_LONG).show();
    }

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

    public void questionOne(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        switch (view.getId()) {
            case R.id.option_1:
                if (checked) {
                    Toast.makeText(getApplicationContext(), R.string.toast_str_option_1, Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.option_2:
                if (checked) {
                    Toast.makeText(getApplicationContext(), R.string.toast_str_option_2, Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.option_3:
                if (checked) {
                    Toast.makeText(getApplicationContext(), R.string.toast_str_option_3, Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.option_4:
                if (checked) {
                    mark = mark + 1;
                    Toast.makeText(getApplicationContext(), R.string.toast_str_option_4, Toast.LENGTH_SHORT).show();
                }
                break;

            default:
                Toast.makeText(getApplicationContext(), "Default ", Toast.LENGTH_SHORT).show();

        }

    }

    public void questionTwo(View view) {
        if (mCheckBox_1.isChecked()) {
            Toast.makeText(getApplicationContext(), R.string.que_2_option_1_str, Toast.LENGTH_SHORT).show();
        }
        if (mCheckBox_2.isChecked()) {
            Toast.makeText(getApplicationContext(), R.string.que_2_option_2_str, Toast.LENGTH_SHORT).show();
        }
        if (mCheckBox_3.isChecked()) {
            Toast.makeText(getApplicationContext(), R.string.que_2_option_3_str, Toast.LENGTH_SHORT).show();
        }
        if (mCheckBox_4.isChecked()) {
            Toast.makeText(getApplicationContext(), R.string.que_2_option_4_str, Toast.LENGTH_SHORT).show();
        }
        if (mCheckBox_1.isChecked() && mCheckBox_2.isChecked() && mCheckBox_3.isChecked()) {
            mark = mark + 1;
        }
    }

    public void questionFour(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        switch (view.getId()) {
            case R.id.que_4_option_1:
                if (checked) {
                    Toast.makeText(getApplicationContext(), R.string.que_4_opt_1, Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.que_4_option_2:
                if (checked) {
                    Toast.makeText(getApplicationContext(), R.string.que_4_opt_2, Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.que_4_option_3:
                if (checked) {
                    mark = mark + 1;
                    Toast.makeText(getApplicationContext(), R.string.que_4_opt_3, Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.que_4_option_4:
                if (checked) {
                    Toast.makeText(getApplicationContext(), R.string.que_4_opt_4, Toast.LENGTH_SHORT).show();
                }
                break;
            default:
                Toast.makeText(getApplicationContext(), R.string.default_str_toast, Toast.LENGTH_SHORT).show();

        }


    }

    public void questionFive(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.que_5_option_1:
                if (checked) {
                    Toast.makeText(getApplicationContext(), R.string.que_5_opt_1, Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.que_5_option_2:
                if (checked) {
                    Toast.makeText(getApplicationContext(), R.string.que_5_opt_2, Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.que_5_option_3:
                if (checked) {
                    mark = mark + 1;
                    Toast.makeText(getApplicationContext(), R.string.que_5_opt_3, Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.que_5_option_4:
                if (checked) {
                    Toast.makeText(getApplicationContext(), R.string.que_5_opt_4, Toast.LENGTH_SHORT).show();
                }
                break;
            default:
                Toast.makeText(getApplicationContext(), R.string.default_str_toast, Toast.LENGTH_SHORT).show();
        }
    }
}





