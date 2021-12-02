package com.example.myapplication123;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
/* DZ7
1) Реализовать нажатия на всех цифр, на минус, на деление и на умножение остальное не надо.
2) Реализовать логику минуса, умножения и деления калькулятора
4) Скинуть Гит и Апк проекта */

public class MainActivity extends AppCompatActivity {
    private TextView tvResult;
    private Integer firstValue;
    private String operation = "";
    private boolean a = false, p = false, o = false;
    private Button btnResult;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvResult = findViewById(R.id.tv_result);
        btnResult = findViewById(R.id.btnResult);

    }

    @SuppressLint("NonConstantResourceId")
    public void onNumberClick(View view) {
        if (a) {
            tvResult.setText("0");
            a = false;
            btnResult.setVisibility(View.GONE);
        }
        switch (view.getId()) {
            case R.id.btn_clear:
                tvResult.setText("0");
                break;
            case R.id.btn_zero:
                if (!p) {
                    tvResult.setText("0");
                    p = true;
                } else tvResult.append("0");
                if (o) {
                    tvResult.setText("0");
                    o = false;
                }
            case R.id.btn_one:
                if (!p) {
                    tvResult.setText("1");
                    p = true;
                } else tvResult.append("1");
                if (o) {
                    tvResult.setText("1");
                    o = false;
                }
                break;
            case R.id.btn_two:
                if (!p) {
                    tvResult.setText("2");
                    p = true;
                } else tvResult.append("2");
                if (o) {
                    tvResult.setText("2");
                    o = false;
                }
                break;
            case R.id.btn_three:
                if (!p) {
                    tvResult.setText("3");
                    p = true;
                } else tvResult.append("3");
                if (o) {
                    tvResult.setText("3");
                    o = false;
                }
                break;
            case R.id.btn_four:
                if (!p) {
                    tvResult.setText("4");
                    p = true;
                } else tvResult.append("4");
                if (o) {
                    tvResult.setText("4");
                    o = false;
                }
                break;
            case R.id.btn_five:
                if (!p) {
                    tvResult.setText("5");
                    p = true;
                } else tvResult.append("5");
                if (o) {
                    tvResult.setText("5");
                    o = false;
                }
                break;
            case R.id.btn_six:
                if (!p) {
                    tvResult.setText("6");
                    p = true;
                } else tvResult.append("6");
                if (o) {
                    tvResult.setText("6");
                    o = false;
                }
                break;
            case R.id.btn_seven:
                if (!p) {
                    tvResult.setText("7");
                    p = true;
                } else tvResult.append("7");
                if (o) {
                    tvResult.setText("7");
                    o = false;
                }
                break;
            case R.id.btn_eight:
                if (!p) {
                    tvResult.setText("8");
                    p = true;
                } else {
                    tvResult.append("8");
                }
                if (o) {
                    tvResult.setText("8");
                    o = false;
                }
                break;
            case R.id.btn_nine:
                if (!p) {
                    tvResult.setText("9");
                    p = true;
                } else {
                    tvResult.append("9");
                }
                if (o) {
                    tvResult.setText("9");
                    o = false;
                }
                break;
        }
    }

    @SuppressLint({"NonConstantResourceId", "SetTextI18n"})
    public void onOperationClick(View view) {
        o = true;
        switch (view.getId()) {
            case R.id.btn_plus:
                checkDoubleClick(view, "+");
                firstValue = Integer.parseInt(tvResult.getText().toString());
                Integer secondValue;
                tvResult.setText(firstValue.toString());
                break;
            case R.id.btn_X:
                checkDoubleClick(view, "X");
                firstValue = Integer.parseInt(tvResult.getText().toString());
                operation = "X";
                tvResult.setText(firstValue.toString());
                break;
            case R.id.btn_division:
                checkDoubleClick(view, "/");
                firstValue = Integer.parseInt(tvResult.getText().toString());
                operation = "/";
                tvResult.setText(firstValue.toString());
                break;
            case R.id.btn_minus:
                checkDoubleClick(view, "-");
                firstValue = Integer.parseInt(tvResult.getText().toString());
                tvResult.setText(firstValue.toString());
                break;
            case R.id.btn_equal:
                btnResult.setVisibility(View.VISIBLE);
                a = true;
                secondValue = Integer.parseInt(tvResult.getText().toString().replace(firstValue + operation, ""));
                switch (operation) {
                    case "+":
                        tvResult.setText((firstValue + secondValue) + "");
                        break;
                    case "-":
                        tvResult.setText((firstValue - secondValue) + "");
                        break;
                    case "/":
                        tvResult.setText((firstValue / secondValue) + "");
                        break;
                    case "X":
                        tvResult.setText((firstValue * secondValue) + "");
                        break;
                }
                break;
        }
    }

    private void checkDoubleClick(View view, String value) {
        if (operation.equals(value)) {
            operation = "";
            view.setBackgroundColor(getResources().getColor(R.color.orange));
            ((TextView) view).setTextColor(getResources().getColor(R.color.white));
        } else {
            view.setBackgroundColor(getResources().getColor(R.color.white));
            ((TextView) view).setTextColor(getResources().getColor(R.color.orange));
            operation = value;
        }
    }

    public void onPut2Activity(View view) {
        Intent intent = new Intent(MainActivity.this, MainActivity2.class);
        String text = tvResult.getText().toString();
        intent.putExtra("key1", text);
        startActivity(intent);
    }
}
