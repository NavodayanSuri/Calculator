package com.example.surendrasingh.calculator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {


    private static final char ADDITION  = '+';
    private static final char SUBRACTION='-';
    private static final char DIVISION='/';
    private static final char MULTIPLY='*';


    private char CURRENT_ACTION;

     Button one,two,three,four,five,six,seven,eight,nine,zero,dot,multiply,division,addition,sub,cut,eq;
     EditText edit;
     TextView text;

     private DecimalFormat decimalFormat;

     private double ValueOne=Double.NaN;
     private double ValueTwo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        one=(Button)findViewById(R.id.one);
        two=(Button)findViewById(R.id.two);
        three=(Button)findViewById(R.id.three);
        four=(Button)findViewById(R.id.four);
        five=(Button)findViewById(R.id.five);
        six=(Button)findViewById(R.id.six);
        seven=(Button)findViewById(R.id.seven);
        eight=(Button)findViewById(R.id.eight);
        nine=(Button)findViewById(R.id.nine);
        dot=(Button)findViewById(R.id.dot);
        zero=(Button)findViewById(R.id.zero);
        addition=(Button)findViewById(R.id.plus);
        sub=(Button)findViewById(R.id.sub);
        cut=(Button)findViewById(R.id.cut);
        multiply=(Button)findViewById(R.id.mul);
        eq=(Button)findViewById(R.id.equal);
        division=(Button)findViewById(R.id.div);
        edit=(EditText)findViewById(R.id.edit);
        text=(TextView)findViewById(R.id.info);
        decimalFormat=new DecimalFormat("#.########");

        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edit.setText(edit.getText()+"1");
            }
        });

        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edit.setText(edit.getText()+"2");
            }
        });

        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edit.setText(edit.getText()+"3");
            }
        });

        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edit.setText(edit.getText()+"4");
            }
        });
        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edit.setText(edit.getText()+"5");
            }
        });

        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edit.setText(edit.getText()+"6");
            }
        });

        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edit.setText(edit.getText()+"7");
            }
        });

        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edit.setText(edit.getText()+"8");
            }
        });
        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edit.setText(edit.getText()+"9");
            }
        });

        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edit.setText(edit.getText()+"0");
            }
        });
        dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edit.setText(edit.getText()+".");
            }
        });

        addition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CURRENT_ACTION=ADDITION;
                computeCalculation();


                text.setText(decimalFormat.format(ValueOne)+"+");
                edit.setText(null);
            }
        });
        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                computeCalculation();
                CURRENT_ACTION=SUBRACTION;

                text.setText(decimalFormat.format(ValueOne)+"-");
                edit.setText(null);
            }
        });
        division.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                computeCalculation();
                CURRENT_ACTION=DIVISION;

                text.setText(decimalFormat.format(ValueOne)+"/");
                edit.setText(null);
            }
        });
        multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                computeCalculation();
                CURRENT_ACTION=MULTIPLY;

                text.setText(decimalFormat.format(ValueOne)+"*");
                edit.setText(null);
            }
        });
        eq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                computeCalculation();

                text.setText(text.getText().toString()+ decimalFormat.format(ValueTwo)+"="+decimalFormat.format(ValueOne));
                ValueOne=Double.NaN;

                CURRENT_ACTION='0';
            }
        });

        cut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(edit.getText().length()>0){
                    CharSequence currenttext=edit.getText();
                    edit.setText(currenttext.subSequence(0,currenttext.length()-1));
                }

                else{
                    ValueOne=Double.NaN;
                    ValueTwo=Double.NaN;
                    edit.setText("");
                    text.setText("");

                }

            }
        });

    }

    private  void computeCalculation()

    {
        if (!Double.isNaN(ValueOne)) {
            ValueTwo = Double.parseDouble(edit.getText().toString());
            edit.setText(null);


            if (CURRENT_ACTION == ADDITION)
                ValueOne = this.ValueOne + ValueTwo;

            else if (CURRENT_ACTION == SUBRACTION)
                ValueOne = this.ValueOne - ValueTwo;

            else if (CURRENT_ACTION == MULTIPLY)
                ValueOne = this.ValueOne * ValueTwo;
            else if (CURRENT_ACTION == DIVISION)
                ValueOne = this.ValueOne / ValueTwo;
        } else {
            try {
                ValueOne = Double.parseDouble(edit.getText().toString());
            } catch (Exception e) {}
        }
    }}