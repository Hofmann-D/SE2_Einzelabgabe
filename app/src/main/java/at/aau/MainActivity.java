package at.aau;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText tv;
    TextView tv2;
    Button btn1;
    Button btn2;
    static String answer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("NetzwerkTest");

        tv = findViewById(R.id.matrikelnummer);
        tv2 = findViewById(R.id.labelServerMessage);
        btn1 = findViewById(R.id.btn);
        btn2 = findViewById(R.id.btn2);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                send(v);
                //....................................................
                //wait till method is finished.
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //....................................................
                tv2.setText(answer);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String number = tv.getText().toString();
                int result = multiply(number);
                tv2.setText("" + result);
            }
        });

    }

    private int multiply(String number) {
        //01655954

        int result = 1;
        for (int i = 0; i < number.length(); i++) {
            int temp = Integer.parseInt(number.substring(i, (i + 1)));
            if (i != 0) {
                //ignore leading 0
                if (temp % 2 == 0) {
                    System.out.println("Even Number: " + temp);
                    result *= temp;
                }
            }
        }
        return result;
    }

    public void send(View v) {
        ConnectionSocket connectionSocket = new ConnectionSocket();
        connectionSocket.execute(tv.getText().toString());
    }

}
