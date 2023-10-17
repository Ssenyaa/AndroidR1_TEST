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

    private Button[] button = new Button[4];

    private String result = "";

    private String number = "";



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
                onenum.setText("");

                if ((number.length() == 4)) {
                    if (number.charAt(0) != '0') {
                        attempts++;
                        int bulls = getBulls(secretNumber, number);
                        int cows = getCows(secretNumber, number);

                        result += "Popitka #" + attempts + ": -" + number + "- " + bulls + " bick, " + cows + " korovi\n";

                        if (bulls == 4) {
                            result += "\nVi ugadali!\n";
                        }
                        if (attempts == 5) {
                            result += "\nVi proigrali!!!\n";
                        }

                        resultTextView.setText(result);

                        for (int i = 0; i < 4; i++) {
                            button[i].setEnabled(true);
                        }
                    } else {
                        resultTextView.setText("ЧИСЛО НЕ ДОЛЖНО НАЧИНАТЬСЯ С НУЛЯ");
                    }
                }
                else{
                    resultTextView.setText("ЧИСЛО ДОЛЖНО БЫТЬ ЧЕТЫРЕХЗНАЧНЫМ");
                }

                number = "";
            }
        });
    }
    public void clickNumber(View view) {
        int l = number.length();
        if (l < 4){
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
            button[l] = findViewById(view.getId());
            button[l].setEnabled(false);
        }
    };
    private int getBulls(int secretNumber, String guess) {
        int bulls = 0;

        String secretString = String.valueOf(secretNumber);


        for (int i = 0; i < secretString.length(); i++) {
            if (secretString.charAt(i) == guess.charAt(i)) {
                bulls++;
            }
        }

        return bulls;
    }

    private int getCows(int secretNumber, String guess) {
        int cows = 0;

        String secretString = String.valueOf(secretNumber);

        for (int i = 0; i < secretString.length(); i++) {
            if (guess.contains(String.valueOf(secretString.charAt(i))) &&
                    secretString.charAt(i) != guess.charAt(i)) {
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
                (number.charAt(1) == number.charAt(2)) | (number.charAt(1) == number.charAt(3)) | (number.charAt(2) == number.charAt(3)));
        return Integer.parseInt(number);
    }
    public void clickObnulenie(View view) {
        number = "";
        onenum.setText("");
        for (int i=0; i<4; i++){
            button[i].setEnabled(true);
        }
    }
    public void restart(View view) {
        resultTextView.setText("");
        result = "";
        number = "";
        onenum.setText("");
        secretNumber = generateRandomNumber();
        secretNumberTextView = findViewById(R.id.randomTextView);
        secretNumberTextView.setText(Integer.toString(secretNumber));
        attempts = 0;
    }
}


