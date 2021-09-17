package com.pdst.personalnotebook.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.pdst.personalnotebook.R;

public class ActivityLockScreen extends AppCompatActivity {

    EditText edtText;
    Button one,two,three,four,five,six,seven,eight,nine,zero,back,submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lock_screen);
        edtText = findViewById(R.id.edtText);
        one = findViewById(R.id.button1);
        two = findViewById(R.id.button2);
        three = findViewById(R.id.button3);
        four = findViewById(R.id.button4);
        five = findViewById(R.id.button5);
        six = findViewById(R.id.button6);
        seven = findViewById(R.id.button7);
        eight = findViewById(R.id.button8);
        nine = findViewById(R.id.button9);
        zero = findViewById(R.id.button0);
        back = findViewById(R.id.button10);
        submit = findViewById(R.id.button12);
    }
    public void one(View view) {
        String text = new String(edtText.getText().toString());
        int len = text.length();
        if(len>=4){
            Toast.makeText(getApplicationContext(), "Maximum number of digits exceeded !", Toast.LENGTH_SHORT).show();
        }
        else{
            edtText.setText(text+"1");
        }
    }

    public void two(View view) {
        String text = new String(edtText.getText().toString());
        int len = text.length();
        if(len>=4){
            Toast.makeText(getApplicationContext(), "Maximum number of digits exceeded !", Toast.LENGTH_SHORT).show();
        }
        else{
            edtText.setText(text+"2");
        }
    }

    public void three(View view) {
        String text = new String(edtText.getText().toString());
        int len = text.length();
        if(len>=4){
            Toast.makeText(getApplicationContext(), "Maximum number of digits exceeded !", Toast.LENGTH_SHORT).show();
        }
        else{
            edtText.setText(text+"3");
        }
    }

    public void four(View view) {
        String text = new String(edtText.getText().toString());
        int len = text.length();
        if(len>=4){
            Toast.makeText(getApplicationContext(), "Maximum number of digits exceeded !", Toast.LENGTH_SHORT).show();
        }
        else{
            edtText.setText(text+"4");
        }
    }

    public void five(View view) {
        String text = new String(edtText.getText().toString());
        int len = text.length();
        if(len>=4){
            Toast.makeText(getApplicationContext(), "Maximum number of digits exceeded !", Toast.LENGTH_SHORT).show();
        }
        else{
            edtText.setText(text+"5");
        }
    }

    public void six(View view) {
        String text = new String(edtText.getText().toString());
        int len = text.length();
        if(len>=4){
            Toast.makeText(getApplicationContext(), "Maximum number of digits exceeded !", Toast.LENGTH_SHORT).show();
        }
        else{
            edtText.setText(text+"6");
        }
    }

    public void seven(View view) {
        String text = new String(edtText.getText().toString());
        int len = text.length();
        if(len>=4){
            Toast.makeText(getApplicationContext(), "Maximum number of digits exceeded !", Toast.LENGTH_SHORT).show();
        }
        else{
            edtText.setText(text+"7");
        }
    }

    public void eight(View view) {
        String text = new String(edtText.getText().toString());
        int len = text.length();
        if(len>=4){
            Toast.makeText(getApplicationContext(), "Maximum number of digits exceeded !", Toast.LENGTH_SHORT).show();
        }
        else{
            edtText.setText(text+"8");
        }
    }

    public void nine(View view) {
        String text = new String(edtText.getText().toString());
        int len = text.length();
        if(len>=4){
            Toast.makeText(getApplicationContext(), "Maximum number of digits exceeded !", Toast.LENGTH_SHORT).show();
        }
        else{
            edtText.setText(text+"9");
        }
    }

    public void zero(View view) {
        String text = new String(edtText.getText().toString());
        int len = text.length();
        if(len>=4){
            Toast.makeText(getApplicationContext(), "Maximum number of digits exceeded !", Toast.LENGTH_SHORT).show();
        }
        else{
            edtText.setText(text+"0");
        }
    }

    public void back(View view) {
        String text = new String(edtText.getText().toString());
        String newText;
        int len = text.length();
        if(len>0){
            newText = text.substring(0, len-1);
            edtText.setText(""+newText);
        }
        else{
            Toast.makeText(getApplicationContext(), "Empty PIN !", Toast.LENGTH_SHORT).show();
        }
    }

    public void submit(View view) {
        String text = new String(edtText.getText().toString());
        int len=text.length();
        String pin = new String("1234");
        if(len>0){
            if(pin.equals(text)){
                Toast.makeText(getApplicationContext(), "Welcome Sir !", Toast.LENGTH_SHORT).show();
                edtText.setText("");
            }
            else{
                edtText.setText("");
                Toast.makeText(getApplicationContext(), "Wrong pin ! Try again sir.", Toast.LENGTH_SHORT).show();
            }
        }
        else{
            Toast.makeText(getApplicationContext(), "Empty PIN !", Toast.LENGTH_SHORT).show();
        }

    }

    public void previous(View view) {
        Intent in = new Intent(ActivityLockScreen.this,ActivityHome.class);
        startActivity(in);
    }
}