package at.aau;

import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ConnectionSocket extends AsyncTask<String, Void, Void> {

    Socket s;
    DataOutputStream out;
    BufferedReader in;

    @Override
    protected Void doInBackground(String... voids) {
        String inFromUser = voids[0];
        //System.out.println("Debug Message");

        try {
            s = new Socket("se2-isys.aau.at", 53212);
            out = new DataOutputStream(s.getOutputStream());
            in = new BufferedReader(new InputStreamReader(s.getInputStream()));

            out.writeBytes(inFromUser + "\n");

            String answer = in.readLine();
            MainActivity.answer = answer;

            out.flush();
            out.close();
            s.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
