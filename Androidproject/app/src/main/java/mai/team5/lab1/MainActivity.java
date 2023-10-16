package mai.team5.lab1;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    private TextView onenum;
    private TextView resultTextView;
    private Button checkButton;
    private int secretNumber;
    private int attempts;
    private TextView secretNumberTextView;

    private String result = "";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        onenum = findViewById(R.id.onenum);
        resultTextView = findViewById(R.id.resultTextView);
        checkButton = findViewById(R.id.checkButton);


        secretNumberTextView = findViewById(R.id.randomTextView);
        int secretNumber = generateRandomNumber();
        secretNumberTextView.setText(Integer.toString(secretNumber));

        attempts = 0;
        checkButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String guessString = onenum.getText().toString();
                onenum.setText("");
                if ((guessString.length() == 4) & (guessString.charAt(0)!=0)){
                    int guess = Integer.parseInt(guessString);
                    attempts++;
                    int bulls = getBulls(secretNumber, guess);
                    int cows = getCows(secretNumber, guess);

                    result += "Popitka #" + attempts + ": -" + guess + "- " + bulls + " bick, " + cows + " korovi\n";

                    if (bulls == 4) {
                        result += "\nVi ugadali!\n";
                    }
                    if (attempts == 5) {
                        result += "\nVi proigrali!!!\n";
                    }

                    resultTextView.setText(result);
                }
            }
        });
    }
    public void clickNumber(View view) {
        String number = onenum.getText().toString();
        if (view.getId() == R.id.cn0) {
            number = number + "0";
        } else if (view.getId() == R.id.cn1) {
            number = number + "1";
        } else if (view.getId() == R.id.cn2) {
            number = number + "2";
        } else if (view.getId() == R.id.cn3) {
            number = number + "3";
        } else if (view.getId() == R.id.cn4) {
            number = number + "4";
        } else if (view.getId() == R.id.cn5) {
            number = number + "5";
        } else if (view.getId() == R.id.cn6) {
            number = number + "6";
        } else if (view.getId() == R.id.cn7) {
            number = number + "7";
        } else if (view.getId() == R.id.cn8) {
            number = number + "8";
        } else if (view.getId() == R.id.cn9) {
            number = number + "9";
        }
        onenum.setText(number);
    };
    private int getBulls(int secretNumber, int guess) {
        int bulls = 0;

        String secretString = String.valueOf(secretNumber);
        String guessString = String.valueOf(guess);

        for (int i = 0; i < secretString.length(); i++) {
            if (secretString.charAt(i) == guessString.charAt(i)) {
                bulls++;
            }
        }

        return bulls;
    }

    private int getCows(int secretNumber, int guess) {
        int cows = 0;

        String secretString = String.valueOf(secretNumber);
        String guessString = String.valueOf(guess);

        for (int i = 0; i < secretString.length(); i++) {
            if (guessString.contains(String.valueOf(secretString.charAt(i))) &&
                    secretString.charAt(i) != guessString.charAt(i)) {
                cows++;
            }
        }

        return cows;
    }

    private int generateRandomNumber() {
        String number = "";
        do{
            number = Integer.toString((int) (Math.random() * 10000));
        }while ((number.charAt(0) == number.charAt(1)) | (number.charAt(0) == number.charAt(2)) | (number.charAt(0) == number.charAt(3)) |
                (number.charAt(1) == number.charAt(2)) | (number.charAt(1) == number.charAt(2)) | (number.charAt(2) == number.charAt(3)));
        return Integer.parseInt(number);
    }
    public void clickObnulenie(View view) {
        onenum.setText("");
    }
}


