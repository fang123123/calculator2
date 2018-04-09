package com.example.fangjie.calculator;

import android.nfc.Tag;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CalculatorActivity extends AppCompatActivity {
    /*数字*/
    private Button[] NumButtons = new Button[10];
    /*运算符*/
    private Button[] OpButtons = new Button[11];
    /*操作符*/
    private Button[] Op1Buttons = new Button[2];
    /*=键*/
    private Button OutButton;
    /*输入框*/
    private EditText Edit_input;
    /*输出框*/
    private EditText Edit_output;
    /*数据栈*/
    private double num[] = new double[100];
    private int top_num = -1;
    /*操作栈*/
    private char oper[][] = new char[50][2];
    private int top_oper = -1;

    private String Input_string = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        /*数字 0 1 2 3 4 5 6 7 8 9 */
        NumButtons[0] = (Button) findViewById(R.id.button17);
        NumButtons[1] = (Button) findViewById(R.id.button13);
        NumButtons[2] = (Button) findViewById(R.id.button14);
        NumButtons[3] = (Button) findViewById(R.id.button15);
        NumButtons[4] = (Button) findViewById(R.id.button9);
        NumButtons[5] = (Button) findViewById(R.id.button10);
        NumButtons[6] = (Button) findViewById(R.id.button11);
        NumButtons[7] = (Button) findViewById(R.id.button5);
        NumButtons[8] = (Button) findViewById(R.id.button6);
        NumButtons[9] = (Button) findViewById(R.id.button7);
        /*运算符 ( ) / * + - sin cos ^ */
        OpButtons[0] = (Button) findViewById(R.id.button2);
        OpButtons[1] = (Button) findViewById(R.id.button3);
        OpButtons[2] = (Button) findViewById(R.id.button8);
        OpButtons[3] = (Button) findViewById(R.id.button12);
        OpButtons[4] = (Button) findViewById(R.id.button16);
        OpButtons[5] = (Button) findViewById(R.id.button19);
        OpButtons[6] = (Button) findViewById(R.id.button20);
        OpButtons[7] = (Button) findViewById(R.id.button21);
        OpButtons[8] = (Button) findViewById(R.id.button22);
        /*十、转换*/
        OpButtons[9] = (Button) findViewById(R.id.button24);
        OpButtons[10] = (Button) findViewById(R.id.button25);
        /*操作符 C CE */
        Op1Buttons[0] = (Button) findViewById(R.id.button1);
        Op1Buttons[1] = (Button) findViewById(R.id.button4);
        /*输出符 = */
        OutButton = (Button) findViewById(R.id.button18);
        /*输入框*/
        Edit_input = (EditText) findViewById(R.id.edit_input);
        /*输出框*/
        Edit_output = (EditText) findViewById(R.id.edit_output);
        // 禁止EditText从键盘输入
        Edit_input.setKeyListener(null);
        Edit_output.setKeyListener(null);

        NumButtons[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Edit_input.setText(Edit_input.getText() + "0");
                Input_string += "0";
            }
        });
        NumButtons[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Edit_input.setText(Edit_input.getText() + "1");
                Input_string += "1";
            }
        });
        NumButtons[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Edit_input.setText(Edit_input.getText() + "2");
                Input_string += "2";
            }
        });
        NumButtons[3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Edit_input.setText(Edit_input.getText() + "3");
                Input_string += "3";
            }
        });
        NumButtons[4].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Edit_input.setText(Edit_input.getText() + "4");
                Input_string += "4";
            }
        });
        NumButtons[5].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Edit_input.setText(Edit_input.getText() + "5");
                Input_string += "5";
            }
        });
        NumButtons[6].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Edit_input.setText(Edit_input.getText() + "6");
                Input_string += "6";
            }
        });
        NumButtons[7].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Edit_input.setText(Edit_input.getText() + "7");
                Input_string += "7";
            }
        });
        NumButtons[8].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Edit_input.setText(Edit_input.getText() + "8");
                Input_string += "8";
            }
        });
        NumButtons[9].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Edit_input.setText(Edit_input.getText() + "9");
                Input_string += "9";
            }
        });
        OpButtons[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Edit_input.setText(Edit_input.getText() + "(");
                Input_string += "(";
            }
        });
        OpButtons[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Edit_input.setText(Edit_input.getText() + ")");
                Input_string += ")";
            }
        });
        OpButtons[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Edit_input.setText(Edit_input.getText() + "/");
                Input_string += "/";
            }
        });
        OpButtons[3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Edit_input.setText(Edit_input.getText() + "*");
                Input_string += "*";
            }
        });
        OpButtons[4].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Edit_input.setText(Edit_input.getText() + "+");
                Input_string += "+";
            }
        });
        OpButtons[5].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Edit_input.setText(Edit_input.getText() + "-");
                Input_string += "-";
            }
        });
        OpButtons[6].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Edit_input.setText(Edit_input.getText() + "sin");
                Input_string += "s";
            }
        });
        OpButtons[7].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Edit_input.setText(Edit_input.getText() + "cos");
                Input_string += "c";
            }
        });
        OpButtons[8].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Edit_input.setText(Edit_input.getText() + "^");
                Input_string += "^";
            }
        });
        OpButtons[9].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    int[] Num=new int[100];
                    int index=0;
                    String str="";
                    int num=Integer.valueOf(Input_string);
                    while(num>0)
                    {
                        Num[index++]=num%2;
                        num=num/2;
                    }
                    for(int i=index-1;i>=0;i--)
                    {
                        str=str+String.valueOf(Num[i]);
                    }
                    Edit_output.setText(str);
                }catch (Exception e){
                    Edit_output.setText("输入类型错误");
                }
            }
        });
        OpButtons[10].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    int num=0;
                    String str="";
                    for(int i=Input_string.length()-1;i>=0;i--)
                    {
                        if(Input_string.charAt(i)=='1')
                        {
                            num=num*2+1;
                        }
                        else
                            num=num*2;
                    }
                    str=String.valueOf(num);
                    Edit_output.setText(str);
                }catch (Exception e){
                    Edit_output.setText("输入类型错误");
                }
            }
        });
        Op1Buttons[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*清空输入、输出框内容*/
                Edit_input.setText("");
                Edit_output.setText("");
                Input_string = "";
                /*清空栈*/
                top_num = -1;
                top_oper = -1;

            }
        });
        Op1Buttons[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*将输入框的内容赋值给字符串str1*/
                String str = Edit_input.getText().toString();
                /*若输入框不为空，则减去最后字符串*/
                if (!str.equals("")) {
                    if (Input_string.charAt(Input_string.length() - 1) == 's' || Input_string.charAt(Input_string.length() - 1) == 'c')
                        Edit_input.setText(str.substring(0, str.length() - 3));
                    else
                        Edit_input.setText(str.substring(0, str.length() - 1));
                    Input_string = Input_string.substring(0, Input_string.length() - 1);
                }
                /*清空栈*/
                top_num = -1;
                top_oper = -1;
            }
        });
        OutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (int i = 0; i < Input_string.length(); i++) {
                    int Num = 0;//获取数字
                    int f = 0;//标志是否遇到数字
                    int t = 0;
                    //判断是否为数字
                    while (i < Input_string.length() && Input_string.charAt(i) >= '0' && Input_string.charAt(i) <= '9') {
                        f = 1;
                        Num = Input_string.charAt(i) - '0' + Num * 10;
                        i++;
                    }
                    Log.d( "aaa", "tag1 "+top_num+top_oper);
                    if (f == 1) {
                        while(top_oper >= 0) {
                            Log.d( "aaa", "tag2 "+top_num+top_oper);
                            if (oper[top_oper][0]=='s') {
                                if(t==0)
                                    num[++top_num] = Math.sin(Num * Math.PI / 180);
                                else
                                    num[top_num] = Math.sin(Num * Math.PI / 180);
                                top_oper--;
                                t = 1;
                            }else if (oper[top_oper][0]=='c') {
                                if(t==0)
                                    num[++top_num] = Math.cos(Num * Math.PI / 180);
                                else
                                    num[top_num] = Math.cos(Num * Math.PI / 180);
                                top_oper--;
                                t = 1;
                            } else if (oper[top_oper][0] == '^') {
                                num[top_num] = Math.pow(num[top_num], Num);
                                top_oper--;
                                t = 1;
                            }else
                                break;
                        }
                        Log.d( "aaa", "tag4 "+top_num+top_oper);
                        if (t == 0) {
                            num[++top_num] = Num;
                            Log.d( "aaa", "tag5 "+top_num+top_oper);
                        }
                    }
                    /*sinx cosx */
                    if (i < Input_string.length() && (Input_string.charAt(i) == 's' || Input_string.charAt(i) == 'c' || Input_string.charAt(i) == '^')) {
                        top_oper++;
                        oper[top_oper][0] = Input_string.charAt(i);
                        oper[top_oper][1] = 3;
                        continue;
                    }
                    if (i < Input_string.length()) {
                        if (Input_string.charAt(i) == '(') {
                            oper[++top_oper][0] = Input_string.charAt(i);
                            oper[top_oper][1] = 0;
                        } else if (Input_string.charAt(i) == '+' || Input_string.charAt(i) == '-' || Input_string.charAt(i) == ')') {
                            while (top_oper >= 0 && oper[top_oper][1] > 0) {
                                if (oper[top_oper][0] == '+') {
                                    num[top_num - 1] = num[top_num - 1] + num[top_num];
                                } else if (oper[top_oper][0] == '-') {
                                    num[top_num - 1] = num[top_num - 1] - num[top_num];
                                } else if (oper[top_oper][0] == '*') {
                                    num[top_num - 1] = num[top_num - 1] * num[top_num];
                                } else if (oper[top_oper][0] == '/') {
                                    num[top_num - 1] = num[top_num - 1] / num[top_num];
                                }
                                top_num--;
                                top_oper--;
                            }
                            if (Input_string.charAt(i) == ')') {
                                top_oper--;
                            } else {
                                oper[++top_oper][0] = Input_string.charAt(i);
                                oper[top_oper][1] = 1;
                            }
                        } else {
                            while (top_oper >= 0 && oper[top_oper][1] > 1) {
                                if (oper[top_oper][0] == '*') {
                                    num[top_num - 1] = num[top_num - 1] * num[top_num];
                                } else if (oper[top_oper][0] == '/') {
                                    num[top_num - 1] = num[top_num - 1] / num[top_num];
                                }
                                top_num--;
                                top_oper--;
                            }
                            oper[++top_oper][0] = Input_string.charAt(i);
                            oper[top_oper][1] = 2;
                            Log.d( "aaa", "t4"+top_num+top_oper);
                        }
                    }
                }
                while (top_oper >= 0) {
                    Log.d( "aaa", "t"+top_num+top_oper);
                    if (oper[top_oper][0] == '*') {
                        num[top_num - 1] = num[top_num - 1] * num[top_num];
                    } else if (oper[top_oper][0] == '/') {
                        num[top_num - 1] = num[top_num - 1] / num[top_num];
                    } else if (oper[top_oper][0] == '+') {
                        num[top_num - 1] = num[top_num - 1] + num[top_num];
                    } else if (oper[top_oper][0] == '-') {
                        num[top_num - 1] = num[top_num - 1] - num[top_num];
                    }
                    top_oper--;
                    top_num--;
                }
                Edit_output.setText(String.valueOf(num[0]));
            }
        });
    }
}