package com.example.mycalculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

        private TextView tvResult;
        private Calculator calculator = new Calculator(); // Instance of the calculator logic class
        private String input = "";
        private char currentOperation;
        private double value1 = Double.NaN;
        private double value2;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            // Initialize TextView
            tvResult = findViewById(R.id.tv_result);

            // Initialize buttons
            Button btnClear = findViewById(R.id.btn_clear);
            Button btnDivide = findViewById(R.id.btn_divide);
            Button btnMultiply = findViewById(R.id.btn_multiply);
            Button btnSubtract = findViewById(R.id.btn_subtract);
            Button btnAdd = findViewById(R.id.btn_add);
            Button btnEquals = findViewById(R.id.btn_equals);
            Button btnDot = findViewById(R.id.btn_dot);

            // Setup number buttons
            Button btn0 = findViewById(R.id.btn_0);
            Button btn1 = findViewById(R.id.btn_1);
            Button btn2 = findViewById(R.id.btn_2);
            Button btn3 = findViewById(R.id.btn_3);
            Button btn4 = findViewById(R.id.btn_4);
            Button btn5 = findViewById(R.id.btn_5);
            Button btn6 = findViewById(R.id.btn_6);
            Button btn7 = findViewById(R.id.btn_7);
            Button btn8 = findViewById(R.id.btn_8);
            Button btn9 = findViewById(R.id.btn_9);

            // Add listeners to the number buttons
            View.OnClickListener numberClickListener = v -> {
                Button button = (Button) v;
                input += button.getText().toString();
                tvResult.setText(input);
            };

            btn0.setOnClickListener(numberClickListener);
            btn1.setOnClickListener(numberClickListener);
            btn2.setOnClickListener(numberClickListener);
            btn3.setOnClickListener(numberClickListener);
            btn4.setOnClickListener(numberClickListener);
            btn5.setOnClickListener(numberClickListener);
            btn6.setOnClickListener(numberClickListener);
            btn7.setOnClickListener(numberClickListener);
            btn8.setOnClickListener(numberClickListener);
            btn9.setOnClickListener(numberClickListener);

            // Clear button listener
            btnClear.setOnClickListener(v -> {
                input = "";
                value1 = Double.NaN;
                value2 = Double.NaN;
                tvResult.setText("0");
            });

            // Dot button listener
            btnDot.setOnClickListener(v -> {
                input += ".";
                tvResult.setText(input);
            });

            // Operation buttons listeners
            btnAdd.setOnClickListener(v -> performOperation('+'));
            btnSubtract.setOnClickListener(v -> performOperation('-'));
            btnMultiply.setOnClickListener(v -> performOperation('*'));
            btnDivide.setOnClickListener(v -> performOperation('/'));

            // Equals button listener
            btnEquals.setOnClickListener(v -> {
                if (!input.isEmpty()) {
                    value2 = Double.parseDouble(input);
                    double result = 0;
                    switch (currentOperation) {
                        case '+':
                            result = calculator.add(value1, value2);
                            break;
                        case '-':
                            result = calculator.subtract(value1, value2);
                            break;
                        case '*':
                            result = calculator.multiply(value1, value2);
                            break;
                        case '/':
                            result = calculator.divide(value1, value2);
                            break;
                    }
                    tvResult.setText(String.valueOf(result));
                    input = "";
                }
            });
        }

        // Method to perform operations
        private void performOperation(char operation) {
            if (!input.isEmpty()) {
                value1 = Double.parseDouble(input);
                input = "";
            }
            currentOperation = operation;
        }
    }
