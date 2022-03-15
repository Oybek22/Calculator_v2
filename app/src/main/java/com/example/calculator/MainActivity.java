package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import org.w3c.dom.EntityReference;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radios);
        TextView res = findViewById(R.id.res);
        EditText text = findViewById(R.id.value);
        EditText base = findViewById(R.id.base);
        ToggleButton toggleButton = findViewById(R.id.toggleButton);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup arg0, int id) {

                String str;

                switch (id) {
                    case R.id.sin:
                        try {
                            toggleButton.setEnabled(true);
                            Float value = Float.parseFloat(text.getText().toString());

                            if (toggleButton.isChecked()) {
                                str = Double.toString(Math.sin(value));
                                res.setText(str);
                            } else {
                                str = Double.toString(Math.toDegrees(Math.sin(value)));
                                res.setText(str);
                            }
                        } catch (Exception e) {
                            Toast toast = Toast.makeText(getApplicationContext(), "Введите корректное значение", Toast.LENGTH_SHORT);
                            toast.show();
                            res.setText("");
                        }
                        break;
                    case R.id.cos:
                        try {
                            toggleButton.setEnabled(true);
                            Float value = Float.parseFloat(text.getText().toString());

                            if (toggleButton.isChecked()) {
                                str = Double.toString(Math.cos(value));
                                res.setText(str);
                            } else {
                                str = Double.toString(Math.toDegrees(Math.cos(value)));
                                res.setText(str);
                            }
                        } catch (Exception e) {
                            Toast toast = Toast.makeText(getApplicationContext(), "Введите корректное значение", Toast.LENGTH_SHORT);
                            toast.show();
                            res.setText("");
                        }
                        break;
                    case R.id.tg:
                        try {
                            toggleButton.setEnabled(true);
                            Float value = Float.parseFloat(text.getText().toString());

                            if (toggleButton.isChecked()) {
                                str = Double.toString(Math.tan(value));
                                res.setText(str);
                            } else {
                                str = Double.toString(Math.toDegrees(Math.tan(value)));
                                res.setText(str);
                            }
                        } catch (Exception e) {
                            Toast toast = Toast.makeText(getApplicationContext(), "Введите корректное значение", Toast.LENGTH_SHORT);
                            toast.show();
                            res.setText("");
                        }
                        break;
                    case R.id.ctg:
                        try {
                            toggleButton.setEnabled(true);
                            Float value = Float.parseFloat(text.getText().toString());

                            if (toggleButton.isChecked()) {
                                str = Double.toString(1.0 / Math.tan(value));
                                res.setText(str);
                            } else {
                                str = Double.toString(Math.toDegrees(1.0 / Math.tan(value)));
                                res.setText(str);
                            }
                        } catch (Exception e) {
                            Toast toast = Toast.makeText(getApplicationContext(), "Введите корректное значение", Toast.LENGTH_SHORT);
                            toast.show();
                            res.setText("");
                        }
                        break;
                    case R.id.ln:
                        try {
                            toggleButton.setEnabled(false);
                            Float value = Float.parseFloat(text.getText().toString());

                            str = Double.toString(Math.log(value));
                            res.setText(str);
                        } catch (Exception e) {
                            Toast toast = Toast.makeText(getApplicationContext(), "Введите корректное значение", Toast.LENGTH_SHORT);
                            toast.show();
                            res.setText("");
                        }
                        break;
                    case R.id.lg:
                        try {
                            toggleButton.setEnabled(false);
                            Float value = Float.parseFloat(text.getText().toString());

                            str = Double.toString(Math.log10(value));
                            res.setText(str);
                        } catch (Exception e) {
                            Toast toast = Toast.makeText(getApplicationContext(), "Введите корректное значение", Toast.LENGTH_SHORT);
                            toast.show();
                            res.setText("");
                        }
                        break;
                    case R.id.log:
                        try {
                            toggleButton.setEnabled(false);
                            Float basevalue = Float.parseFloat(base.getText().toString());
                            Float value = Float.parseFloat(text.getText().toString());

                            str = Double.toString(Math.log(value) / Math.log(basevalue)); //log
                            res.setText(str);
                        } catch (RuntimeException e) {
                            Toast toast = Toast.makeText(getApplicationContext(), "Введите корректное значение", Toast.LENGTH_SHORT);
                            toast.show();
                            res.setText("");
                        }
                        break;
                }
            }
        });

        toggleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    if (toggleButton.isChecked()) {
                        Double aDouble = Math.toRadians(Double.parseDouble(res.getText().toString()));
                        res.setText(Double.toString(aDouble));
                    } else {
                        Double aDouble = Math.toDegrees(Double.parseDouble(res.getText().toString()));
                        res.setText(Double.toString(aDouble));
                    }
                } catch (Exception e) {
                    Toast toast = Toast.makeText(getApplicationContext(), "Ошибка, попробуйте еще раз", Toast.LENGTH_SHORT);
                    toast.show();
                    res.setText("");
                }
            }
        });
    }
}
