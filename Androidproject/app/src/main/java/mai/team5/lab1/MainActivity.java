package mai.team5.lab1;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import java.util.Random;


public class MainActivity extends AppCompatActivity {
    private TextView randomTextView;
    Boolean isNew = true;
    EditText onenum;
    EditText twonum;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        onenum = findViewById(R.id.onenum);

        randomTextView = findViewById(R.id.textView);
        int randomNumber = generateRandomNumber(1000, 9999);
        randomTextView.setText(String.valueOf(randomNumber));

    }

    private int generateRandomNumber(int min, int max) {
        Random random = new Random();
        return random.nextInt((max - min) + 1) + min;
    }

    public void clickNumber(View view) {
        if(isNew)
            onenum.setText("");
        isNew=false;
        String number1 = onenum.getText().toString();
        if (view.getId() == R.id.cn0) {
            number1 = number1 + "0";
        } else if (view.getId() == R.id.cn1) {
            number1 = number1 + "1";
        } else if (view.getId() == R.id.cn2) {
            number1 = number1 + "2";
        } else if (view.getId() == R.id.cn3) {
            number1 = number1 + "3";
        } else if (view.getId() == R.id.cn4) {
            number1 = number1 + "4";
        } else if (view.getId() == R.id.cn5) {
            number1 = number1 + "5";
        } else if (view.getId() == R.id.cn6) {
            number1 = number1 + "6";
        } else if (view.getId() == R.id.cn7) {
            number1 = number1 + "7";
        } else if (view.getId() == R.id.cn8) {
            number1 = number1 + "8";
        } else if (view.getId() == R.id.cn9) {
            number1 = number1 + "9";
        }
        onenum.setText(number1);

        String number2 = twonum.getText().toString();
        if (view.getId() == R.id.cn0) {
            number2 = number2 + "0";
        } else if (view.getId() == R.id.cn1) {
            number2 = 2 + "1";
        } else if (view.getId() == R.id.cn2) {
            number2 = number2 + "2";
        } else if (view.getId() == R.id.cn3) {
            number2 = number2 + "3";
        } else if (view.getId() == R.id.cn4) {
            number2 = number2 + "4";
        } else if (view.getId() == R.id.cn5) {
            number2 = number2 + "5";
        } else if (view.getId() == R.id.cn6) {
            number2 = number2 + "6";
        } else if (view.getId() == R.id.cn7) {
            number2 = number2 + "7";
        } else if (view.getId() == R.id.cn8) {
            number2 = number2 + "8";
        } else if (view.getId() == R.id.cn9) {
            number2 = number2 + "9";
        }
        twonum.setText(number2);
    }
}