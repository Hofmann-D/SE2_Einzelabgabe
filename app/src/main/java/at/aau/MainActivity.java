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
    static String answer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("NetzwerkTest");

        tv = findViewById(R.id.matrikelnummer);
        tv2 = findViewById(R.id.labelServerMessage);
        btn1 = findViewById(R.id.btn);


    }

    public void send(View v){
        ConnectionSocket connectionSocket = new ConnectionSocket();
        connectionSocket.execute(tv.getText().toString());
    }

}
