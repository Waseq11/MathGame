package com.example.finalproject_1913864;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.icu.text.DecimalFormat;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn0,btnClear,btnQuit,btnGenerate,btnEquals,btnShowAll,btnDecimal,btnSubtract;
    EditText txtResult;
    TextView txtgeneratedRandomOperation;

    private boolean validationEnabled = false; //to show validation
    private static final DecimalFormat decimalFormat = new DecimalFormat("0.00"); //For 2 decimal places
    Operation generatedRandomOperation;

    private String stringAnswer="", stringPercentage = "";
    private int questionCounts = 0, correctAnswers = 0, incorrectAnswers = 0;
    private Double correctAnswerPercentage, incorrrectAnswerPercentage;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialize();

        //Buttons (0-9)
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtResult.setText(txtResult.getText().toString() + "1");
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtResult.setText(txtResult.getText().toString() + "2");
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtResult.setText(txtResult.getText().toString() + "3");
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtResult.setText(txtResult.getText().toString() + "4");
            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtResult.setText(txtResult.getText().toString() + "5");
            }
        });

        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtResult.setText(txtResult.getText().toString() + "6");
            }
        });

        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtResult.setText(txtResult.getText().toString() + "7");
            }
        });

        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtResult.setText(txtResult.getText().toString() + "8");
            }
        });

        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtResult.setText(txtResult.getText().toString() + "9");
            }
        });

        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtResult.setText(txtResult.getText().toString() + "0");
            }
        });

        //Buttons (Clear,Quit and Generate)
        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtResult.setText(null);
            }
        });

        btnQuit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.exit(0);
            }
        });

        btnGenerate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                generatedRandomOperation = MathsGeneratedOperationsClass.GenerateOperations();
                txtgeneratedRandomOperation.setText(String.valueOf(generatedRandomOperation));
                validationEnabled = true;
            }
        });

        //Buttons (" . " and " - " )
        btnDecimal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtResult.setText(txtResult.getText().toString() + ".");
            }
        });

        btnSubtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtResult.setText(txtResult.getText().toString() + "-");
            }
        });
        }

    private void initialize() {

        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);
        btn0 = findViewById(R.id.btn0);

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);
        btn0.setOnClickListener(this);

        btnClear = findViewById(R.id.btnClear);
        btnQuit = findViewById(R.id.btnQuit);
        btnGenerate = findViewById(R.id.btnGenerate);
        btnEquals = findViewById(R.id.btnEquals);
        btnShowAll = findViewById(R.id.btnShowAll);
        btnDecimal = findViewById(R.id.btnDecimal);
        btnSubtract = findViewById(R.id.btnSubtract);
        txtResult = findViewById(R.id.txtResult);
        txtgeneratedRandomOperation = findViewById(R.id.txtGeneratedOperation);

        btnClear.setOnClickListener(this);
        btnQuit.setOnClickListener(this);
        btnGenerate.setOnClickListener(this);
        btnEquals.setOnClickListener(this);
        btnShowAll.setOnClickListener(this);
        btnDecimal.setOnClickListener(this);
        btnSubtract.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.btnEquals: {
                if (validationEnabled == true) {
                    btnEqualsClicked();
                } else {
                    Toast.makeText(this, "You cannot do that yet!", Toast.LENGTH_SHORT).show();
                }

                break;
            }
            case R.id.btnShowAll: {
                if (stringAnswer != null && stringAnswer != "" && !stringAnswer.trim().isEmpty()) {
                    ShowAll();
                } else {
                    Toast.makeText(this, "You cannot do that yet!", Toast.LENGTH_SHORT).show();
                }
                break;
            }
        }


    }

    private void ShowAll() {
        correctAnswerPercentage = Double.valueOf((correctAnswers * 100) / questionCounts);
        incorrrectAnswerPercentage = Double.valueOf((incorrectAnswers * 100) / questionCounts);
        stringPercentage = "\n" + correctAnswerPercentage + "%" + " Correct Answer \n"
                                + incorrrectAnswerPercentage + "%" + " Incorrect Answer";

        Intent intent = new Intent(this, ResultActivity.class);
        intent.putExtra("stringAnswer", stringAnswer);
        intent.putExtra("stringPercentage", stringPercentage);
        startActivity(intent);
    }

    private void ValidateOperation() {
        Double leftNumber = new Double(generatedRandomOperation.getLeftVal());
        Double rightNumber = new Double(generatedRandomOperation.getRightVal());
        Operator operator = generatedRandomOperation.getOperator();

        if (txtResult.getText().toString() != null && txtResult.getText().toString() != "" && !txtResult.getText().toString().trim().isEmpty()) {
            switch (operator.toString()) {
                case "subtract": {
                    Double answer = leftNumber - rightNumber;
                    Double systemAnswer = Double.valueOf(decimalFormat.format(answer));
                    Double userAnswer = Double.valueOf(txtResult.getText().toString());
                    SaveOperationInHistory(systemAnswer, userAnswer);
                    break;
                }

                case "addition": {
                    Double answer = leftNumber + rightNumber;
                    Double systemAnswer = Double.valueOf(decimalFormat.format(answer));
                    Double userAnswer = Double.valueOf(txtResult.getText().toString());
                    SaveOperationInHistory(systemAnswer, userAnswer);
                    break;
                }

                case "multiplication": {
                    Double answer = leftNumber * rightNumber;
                    Double systemAnswer = Double.valueOf(decimalFormat.format(answer));
                    Double userAnswer = Double.valueOf(txtResult.getText().toString());
                    SaveOperationInHistory(systemAnswer, userAnswer);
                    break;
                }

                case "division": {
                    Double answer = leftNumber / rightNumber;
                    Double systemAnswer = Double.valueOf(decimalFormat.format(answer));
                    Double userAnswer = Double.valueOf(txtResult.getText().toString());
                    SaveOperationInHistory(systemAnswer, userAnswer);
                    break;
                }

            }
        } else {
            Toast.makeText(this, "Please input number", Toast.LENGTH_SHORT).show();

        }

    }

    private void SaveOperationInHistory(Double systemAnswer, Double userAnswer) {

        validationEnabled = false;
        txtgeneratedRandomOperation.setText(null);
        txtResult.setText(null);

        if (Double.compare(systemAnswer, userAnswer) == 0) {
            stringAnswer += String.valueOf(generatedRandomOperation) + " = " + userAnswer + "\n"
                    + "Correct Answer\n"
                    + "---------------------------------------------------------\n";
            correctAnswers++;
        } else {
            stringAnswer += String.valueOf(generatedRandomOperation) + " = " + userAnswer + "\n"
                    + "Incorrect Answer\n"
                    + "Correct Answer: " + systemAnswer + "\n"
                    + "---------------------------------------------------------\n";
            incorrectAnswers++;
        }
        questionCounts++;
    }

    private void btnEqualsClicked() {
        ValidateOperation();
    }
}
