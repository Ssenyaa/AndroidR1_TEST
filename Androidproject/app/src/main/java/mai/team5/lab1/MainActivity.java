package mai.team5.lab1;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {
    private TextView onenum;
    private TextView resultTextView;
    private Button checkButton;
    private int secretNumber;
    private int attempts;
    private TextView secretNumberTextView;

    private final Button[] button = new Button[4];

    private String result = "";

    private String number = "";
    private Button start;
    private Button buAC;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        onenum = findViewById(R.id.onenum);
        resultTextView = findViewById(R.id.resultTextView);
        checkButton = findViewById(R.id.checkButton);
        start =  findViewById(R.id.start);
        buAC = findViewById(R.id.buAC);



        secretNumberTextView = findViewById(R.id.randomTextView);
        secretNumber = generateRandomNumber();
        secretNumberTextView.setText(Integer.toString(secretNumber));
        start.setEnabled(false);
        buAC.setEnabled(false);
        checkButton.setEnabled(false);
        attempts = 0;

        checkButton.setOnClickListener(view -> {
            onenum.setText("");
            if ((number.length() == 4)) {
                if (number.charAt(0) != '0') {
                    attempts++;
                    int bulls = getBulls(secretNumber, number);
                    int cows = getCows(secretNumber, number);

                    result += "Popitka #" + attempts + ": -" + number + "- " + bulls + " bick, " + cows + " korovi\n";
                    buAC.setEnabled(false);
                    if (bulls == 4) {
                        result += "\nVi ugadali!\n";
                        start.setEnabled(true);
                        checkButton.setEnabled(false);
                    }
                    if (attempts == 5) {
                        result += "\nVi proigrali!!!\n";
                        start.setEnabled(true);
                        checkButton.setEnabled(false);
                    }


                    resultTextView.setText(result);

                    for (int i = 0; i < 4; i++) {
                        button[i].setEnabled(true);
                    }

                }

                else {
                    for (int i=0; i<4; i++){
                        button[i].setEnabled(true);
                    }
                    number = "";
                    onenum.setText("");
                    resultTextView.setText("ЧИСЛО НЕ ДОЛЖНО НАЧИНАТЬСЯ С НУЛЯ");
                }
            }
            else{
                for (int i=0; i<4; i++){
                    button[i].setEnabled(true);
                }
                number = "";
                onenum.setText("");
                resultTextView.setText("ЧИСЛО ДОЛЖНО БЫТЬ ЧЕТЫРЕХЗНАЧНЫМ");
            }

            number = "";
        });
    }
    public void clickNumber(View view) {
        int l = number.length();
        checkButton.setEnabled(l != 0);
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
        if (l < 3){
            buAC.setEnabled(false);
            checkButton.setEnabled(false);
        }
        else {
            buAC.setEnabled(true);
            checkButton.setEnabled(true);
        }


    }
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
        int number;
        boolean isUniqueDigits;

        do {
            number = (int) (Math.random() * 10000);
            isUniqueDigits = checkUniqueDigits(number);
        } while (!isUniqueDigits);

        return number;
    }

    private boolean checkUniqueDigits(int number) {
        int[] digits = new int[10];

        while (number > 0) {
            int digit = number % 10;
            digits[digit]++;

            if (digits[digit] > 1) {
                return false;
            }

            number /= 10;
        }

        return true;
    }
    public void clickObnulenie(View view) {
        number = "";
        onenum.setText("");
        for (int i=0; i<4; i++){
            button[i].setEnabled(true);
        }
    }
    @SuppressLint("SetTextI18n")
    public void restart(View view) {
        resultTextView.setText("");
        result = "";
        number = "";
        onenum.setText("");
        attempts = 0;
        secretNumber = generateRandomNumber();
        secretNumberTextView.setText(Integer.toString(secretNumber));
        checkButton.setEnabled(false);
        start.setEnabled(false);
        buAC.setEnabled(false);
        checkButton.setEnabled(false);


    }
}




