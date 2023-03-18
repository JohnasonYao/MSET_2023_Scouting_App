package com.example.mset2023scoutingapp;
import androidx.appcompat.app.AppCompatActivity;
import java.util.List;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.CheckBox;
import android.widget.Toast;
import android.widget.ToggleButton;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.Locale;
import javax.net.ssl.HttpsURLConnection;



public class MainActivity extends AppCompatActivity {
    private String firstName = "N/a";
    private String lastName = "N/a";
    private int match = 0;
    private int team = 0;
    private boolean mobility;
    private boolean autoEngaged;
    private boolean autoNotEngaged;
    private boolean autoNotDocked;
    private String autoDockStatus;
    private boolean engaged;
    private boolean notEngaged;
    private boolean notDocked;
    private String teleDockStatus;
    private boolean broke;
    private int totalScore;
    private int autoScore;
    private int teleScore;
    private int autoThirdRow;
    private int autoSecondRow;
    private int autoFirstRow;
    private String autoRaw;
    private int teleThirdRow;
    private int teleSecondRow;
    private int teleFirstRow;
    private String teleRaw;
    private String comments;
    private int linksScored;
    private int cycleTime;
    private int timeStopped;
    private int placementsMissed;
    private int defenceRating = 0;

    private EditText first;
    private EditText last;
    private EditText matchNumber;
    private EditText teamNumber;
    private EditText Comments;
    private CheckBox Mobility;
    private CheckBox AutoNotEngaged;
    private CheckBox AutoEngaged;
    private CheckBox TeleNotEngaged;
    private CheckBox TeleEngaged;
    private CheckBox robotBroke;
    private Button submit;
    private Button plus;
    private Button minus;
    private TextView links;
    private Button pluss;
    private Button minuss;
    private Button stopped;
    private Button upload;
    private TextView missedCount;
    private EditText defence;
    private EditText driver;
    String id= "1K1Aro1oflQZnmGBwDe1uzijedfr5qqkGu1Qq0OAf1Tc";
    ArrayList<ArrayList<String>> data = new ArrayList<ArrayList<String>>();

    private ToggleButton three_1;
    private ToggleButton three_2;
    private ToggleButton three_3;
    private ToggleButton three_4;
    private ToggleButton three_5;
    private ToggleButton three_6;
    private ToggleButton three_7;
    private ToggleButton three_8;
    private ToggleButton three_9;
    private ToggleButton two_1;
    private ToggleButton two_2;
    private ToggleButton two_3;
    private ToggleButton two_4;
    private ToggleButton two_5;
    private ToggleButton two_6;
    private ToggleButton two_7;
    private ToggleButton two_8;
    private ToggleButton two_9;
    private ToggleButton one_1;
    private ToggleButton one_2;
    private ToggleButton one_3;
    private ToggleButton one_4;
    private ToggleButton one_5;
    private ToggleButton one_6;
    private ToggleButton one_7;
    private ToggleButton one_8;
    private ToggleButton one_9;

    private boolean[][] scoreList = new boolean[3][9];


    private static final long autoTimerMilli = 15000;
    private TextView autoCountdown;
    private Button autoStartStop;
    private Button autoReset;
    private Boolean autoRun = false;
    private CountDownTimer autoCount;
    private long autoTimeLeft = autoTimerMilli;

    private static final long teleTimerMilli = 135000;
    private TextView teleCountdown;
    private Button teleStartStop;
    private Button teleReset;
    private Boolean teleRun = false;
    private CountDownTimer teleCount;
    private long teleTimeLeft = teleTimerMilli;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        three_1 = findViewById(R.id.three_1);
        three_2 = findViewById(R.id.three_2);
        three_3 = findViewById(R.id.three_3);
        three_4 = findViewById(R.id.three_4);
        three_5 = findViewById(R.id.three_5);
        three_6 = findViewById(R.id.three_6);
        three_7 = findViewById(R.id.three_7);
        three_8 = findViewById(R.id.three_8);
        three_9 = findViewById(R.id.three_9);
        two_1 = findViewById(R.id.two_1);
        two_2 = findViewById(R.id.two_2);
        two_3 = findViewById(R.id.two_3);
        two_4 = findViewById(R.id.two_4);
        two_5 = findViewById(R.id.two_5);
        two_6 = findViewById(R.id.two_6);
        two_7 = findViewById(R.id.two_7);
        two_8 = findViewById(R.id.two_8);
        two_9 = findViewById(R.id.two_9);
        one_1 = findViewById(R.id.one_1);
        one_2 = findViewById(R.id.one_2);
        one_3 = findViewById(R.id.one_3);
        one_4 = findViewById(R.id.one_4);
        one_5 = findViewById(R.id.one_5);
        one_6 = findViewById(R.id.one_6);
        one_7 = findViewById(R.id.one_7);
        one_8 = findViewById(R.id.one_8);
        one_9 = findViewById(R.id.one_9);

        scoreList[0][0] = three_1.isChecked();
        scoreList[0][1] = three_2.isChecked();
        scoreList[0][2] = three_3.isChecked();
        scoreList[0][3] = three_4.isChecked();
        scoreList[0][4] = three_5.isChecked();
        scoreList[0][5] = three_6.isChecked();
        scoreList[0][6] = three_7.isChecked();
        scoreList[0][7] = three_8.isChecked();
        scoreList[0][8] = three_9.isChecked();
        scoreList[1][0] = two_1.isChecked();
        scoreList[1][1] = two_2.isChecked();
        scoreList[1][2] = two_3.isChecked();
        scoreList[1][3] = two_4.isChecked();
        scoreList[1][4] = two_5.isChecked();
        scoreList[1][5] = two_6.isChecked();
        scoreList[1][6] = two_7.isChecked();
        scoreList[1][7] = two_8.isChecked();
        scoreList[1][8] = two_9.isChecked();
        scoreList[2][0] = one_1.isChecked();
        scoreList[2][1] = one_2.isChecked();
        scoreList[2][2] = one_3.isChecked();
        scoreList[2][3] = one_4.isChecked();
        scoreList[2][4] = one_5.isChecked();
        scoreList[2][5] = one_6.isChecked();
        scoreList[2][6] = one_7.isChecked();
        scoreList[2][7] = one_8.isChecked();
        scoreList[2][8] = one_9.isChecked();

        //boolean[][] scoreList = {{three_1.isChecked(), three_2.isChecked(), three_3.isChecked(), three_4.isChecked(), three_5.isChecked(), three_6.isChecked(), three_7.isChecked(), three_8.isChecked(), three_9.isChecked()},
        //{two_1.isChecked(), two_2.isChecked(), two_3.isChecked(), two_4.isChecked(), two_5.isChecked(), two_6.isChecked(), two_7.isChecked(), two_8.isChecked(), two_9.isChecked()},
        //{one_1.isChecked(), one_2.isChecked(), one_3.isChecked(), one_4.isChecked(), one_5.isChecked(), one_6.isChecked(), one_7.isChecked(), one_8.isChecked(), one_9.isChecked()}};
        System.out.println(scoreList.length);
        System.out.println(scoreList[0].length);

        first = findViewById(R.id.first);
        last = findViewById(R.id.last);
        matchNumber = findViewById(R.id.matchNumber);
        teamNumber = findViewById(R.id.team);
        Comments = findViewById(R.id.comments);
        defence = findViewById(R.id.rating);
        driver = findViewById(R.id.Driver);

        Mobility = findViewById(R.id.checkBox4);
        AutoNotEngaged = findViewById(R.id.checkBox5);
        AutoEngaged = findViewById(R.id.checkBox6);
        TeleNotEngaged = findViewById(R.id.checkBox7);
        TeleEngaged = findViewById(R.id.checkBox9);
        robotBroke = findViewById(R.id.checkBox10);

        submit = findViewById(R.id.submit);
        upload = findViewById(R.id.button2);
        plus = findViewById(R.id.plus);
        minus = findViewById(R.id.minus);
        links = findViewById(R.id.textView9);
        pluss = findViewById(R.id.plusMissed);
        minuss = findViewById(R.id.minusMissed);
        stopped = findViewById(R.id.button);
        missedCount = findViewById(R.id.textView11);
        System.out.println("myButton = " + minuss);
        autoCountdown = findViewById(R.id.autoCountdown);
        autoStartStop = findViewById(R.id.autoStartStop);
        autoReset = findViewById(R.id.autoReset);

        //defineButtons();

        upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new SendRequest().execute();
                first.setText("");
                last.setText("");
            }
        });

        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                linksScored++;
                updateLinks();
            }
        });

        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                linksScored--;
                updateLinks();
            }
        });

        pluss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                placementsMissed++;
                updatePlace();
            }
        });

        minuss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                placementsMissed--;
                updatePlace();
            }
        });

        stopped.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                timeStopped = (int) (teleTimeLeft / 1000);
                stopped.setText(timeStopped + " Seconds");
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ArrayList<String> list = new ArrayList<String>();
                firstName = first.getText().toString();
                lastName = last.getText().toString();
                //match = Integer.parseInt(matchNumber.getText().toString());
                //team = Integer.parseInt(teamNumber.getText().toString());
                mobility = Mobility.isChecked();
                if (AutoEngaged.isChecked()) {
                    autoDockStatus = "Engaged";
                } else if (AutoNotEngaged.isChecked()) {
                    autoDockStatus = "Not engaged";
                } else {
                    autoDockStatus = "Not Docked";
                }
                if (TeleEngaged.isChecked()) {
                    teleDockStatus = "Engaged";
                } else if (TeleNotEngaged.isChecked()) {
                    teleDockStatus = "Not engaged";
                } else {
                    teleDockStatus = "Not Docked";
                }
                if (mobility) {
                    autoScore = autoScore + 3;
                }
                if (autoEngaged) {
                    autoScore = autoScore + 12;
                }
                if (autoNotEngaged) {
                    autoScore = autoScore + 8;
                }
                if (autoEngaged) {
                    teleScore = teleScore + 10;
                }
                if (autoNotEngaged) {
                    teleScore = teleScore + 6;
                }
                autoRaw = autoFirstRow + ":" + autoSecondRow + ":" + autoThirdRow;
                teleRaw = teleFirstRow + ":" + teleSecondRow + ":" + teleThirdRow;
                broke = robotBroke.isChecked();
                totalScore = autoScore + teleScore;
                comments = Comments.getText().toString();
                cycleTime = (teleFirstRow + teleSecondRow + teleThirdRow) / (timeStopped - (int)(teleTimerMilli));
                //defenceRating = Integer.parseInt(defence.getText().toString());

                list.add(firstName);
                list.add(lastName);
                list.add(matchNumber.getText().toString() + "");
                list.add(teamNumber.getText().toString() + "");
                list.add(String.valueOf(mobility));
                list.add(autoDockStatus);
                list.add(autoScore + "");
                list.add(autoRaw);
                list.add(teleDockStatus);
                list.add(teleScore + "");
                list.add(teleRaw);
                list.add(linksScored + "");
                list.add(cycleTime + "");
                list.add(totalScore + "");
                list.add(defence.getText().toString() + "");
                list.add(driver.getText().toString() + "");
                list.add(String.valueOf(broke));
                list.add(comments);

                data.add(new ArrayList<>(list));
                System.out.println(list);
                list.clear();

                reset();
                System.out.println(data);
            }
        });

        autoStartStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (autoRun) {
                    pauseAuto();
                } else {
                    startAuto();
                }
            }
        });

        autoReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetAuto();
            }
        });

        updateAuto();

        teleCountdown = findViewById(R.id.teleCountdown);
        teleStartStop = findViewById(R.id.teleStartStop);
        teleReset = findViewById(R.id.teleReset);

        teleStartStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (teleRun) {
                    pauseTele();
                } else {
                    startTele();
                }
            }
        });

        teleReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetTele();
            }
        });

        updateTele();

    }

    public class SendRequest extends AsyncTask<String, Void, String> {


        protected void onPreExecute(){}

        protected String doInBackground(String... arg0) {

            try{

                URL url = new URL("https://script.google.com/macros/s/AKfycbyDfWM-8sB9FYcO17o0o_fDI8mF9NIM83HhI2LEPKyVgCJtyuKP9GEU6D5lZen57cdC/exec");
                // https://script.google.com/macros/s/AKfycbyuAu6jWNYMiWt9X5yp63-hypxQPlg5JS8NimN6GEGmdKZcIFh0/exec
                JSONObject postDataParams = new JSONObject();

                //int i;
                //for(i=1;i<=70;i++)


                //    String usn = Integer.toString(i);

                String[] issa = new String[data.size()];
                String[] words = new String[] {"one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten"};


                for(int i=0; i<data.size(); i++){
                    String join = String.join(",", data.get(i)); // "John,Jane,James"
                    issa[i] = join;
                }


                for(int i=0; i<issa.length; i++){
                    postDataParams.put(words[i], issa[i]);
                }



                /*if(data.size() == 1) {
                    postDataParams.put("one", issa[0]);
                }else if(data.size() == 2){
                    postDataParams.put("one", issa[0]);
                    postDataParams.put("two",issa[1]);
                }else if(data.size() == 3){
                    postDataParams.put("one", issa[0]);
                    postDataParams.put("two",issa[1]);
                    postDataParams.put("three",issa[2]);
                }else if(data.size() == 4){
                    postDataParams.put("one", issa[0]);
                    postDataParams.put("two",issa[1]);
                    postDataParams.put("three",issa[2]);
                    postDataParams.put("four",issa[3]);
                }else if(data.size() == 5){
                    postDataParams.put("one", issa[0]);
                    postDataParams.put("two",issa[1]);
                    postDataParams.put("three",issa[2]);
                    postDataParams.put("four",issa[3]);
                    postDataParams.put("five",issa[4]);
                }else{
                    postDataParams.put("one", issa[0]);
                    postDataParams.put("two",issa[1]);
                    postDataParams.put("three",issa[2]);
                    postDataParams.put("four",issa[3]);
                    postDataParams.put("five",issa[4]);
                    postDataParams.put("six",issa[5]);
                    System.out.println(1);
                }*/


               /* postDataParams.put("name",firstName);
                postDataParams.put("lastName",lastName);
                postDataParams.put("matchNumber",matchNumber.getText().toString());
                postDataParams.put("teamNumber",teamNumber.getText().toString());
                postDataParams.put("mobility",mobility);
                postDataParams.put("autoDockStatus",autoDockStatus);
                postDataParams.put("autoScore",autoScore);
                postDataParams.put("autoRaw",autoRaw);
                postDataParams.put("teleDockStatus",teleDockStatus);
                postDataParams.put("teleScore",teleScore);
                postDataParams.put("teleRaw",teleRaw);
                postDataParams.put("linksScored",linksScored);
                postDataParams.put("linksScored",linksScored);
                postDataParams.put("totalScore",totalScore);
                postDataParams.put("broke",broke);
                postDataParams.put("comments",comments);
                postDataParams.put("cycleTime",cycleTime);
                postDataParams.put("defenceRating",defenceRating);
                postDataParams.put("id",id);*/


                Log.e("params",postDataParams.toString());

                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setReadTimeout(15000 /* milliseconds */);
                conn.setConnectTimeout(15000 /* milliseconds */);
                conn.setRequestMethod("POST");
                conn.setDoInput(true);
                conn.setDoOutput(true);

                OutputStream os = conn.getOutputStream();
                BufferedWriter writer = new BufferedWriter(
                        new OutputStreamWriter(os, "UTF-8"));
                writer.write(getPostDataString(postDataParams));

                writer.flush();
                writer.close();
                os.close();

                int responseCode=conn.getResponseCode();

                if (responseCode == HttpsURLConnection.HTTP_OK) {

                    BufferedReader in=new BufferedReader(new InputStreamReader(conn.getInputStream()));
                    StringBuffer sb = new StringBuffer("");
                    String line="";

                    while((line = in.readLine()) != null) {

                        sb.append(line);
                        break;
                    }

                    in.close();
                    return sb.toString();

                }
                else {
                    return new String("false : "+responseCode);
                }
            }
            catch(Exception e){
                return new String("Exception: " + e.getMessage());
            }
        }

        @Override
        protected void onPostExecute(String result) {
            Toast.makeText(getApplicationContext(), result,
                    Toast.LENGTH_LONG).show();

        }
    }

    public String getPostDataString(JSONObject params) throws Exception {

        StringBuilder result = new StringBuilder();
        boolean first = true;

        Iterator<String> itr = params.keys();

        while(itr.hasNext()){

            String key= itr.next();
            Object value = params.get(key);

            if (first)
                first = false;
            else
                result.append("&");

            result.append(URLEncoder.encode(key, "UTF-8"));
            result.append("=");
            result.append(URLEncoder.encode(value.toString(), "UTF-8"));

        }
        return result.toString();
    }

    private void updateLinks() {
        links.setText(linksScored + "");
    }

    private void updatePlace() {
        missedCount.setText(placementsMissed + "");
    }

    private void startAuto() {
        autoCount = new CountDownTimer(autoTimeLeft, 10) {
            @Override
            public void onTick(long x) {
                autoTimeLeft = x;
                updateAuto();
            }

            @Override
            public void onFinish() {
                autoRun = false;
                autoTimeLeft = 0;
                autoStartStop.setText("Start");
                autoStartStop.setVisibility(View.INVISIBLE);
                autoReset.setVisibility(View.VISIBLE);
                autoFirstRow = autoScored()[0];
                autoSecondRow = autoScored()[1];
                autoThirdRow = autoScored()[2];
                autoScore = autoScored()[3];
                System.out.println(autoTimeLeft);
            }
        }.start();
        autoRun = true;
        autoStartStop.setText("Stop");
        autoReset.setVisibility(View.INVISIBLE);
    }

    private void updateAuto() {
        int seconds = (int) autoTimeLeft / 1000;
        int centiSec = (int) (autoTimeLeft % 1000) / 10;

        String timeLeft = String.format(Locale.getDefault(), "%02d:%02d", seconds, centiSec);
        autoCountdown.setText(timeLeft);
    }

    private void pauseAuto() {
        autoCount.cancel();
        autoRun = false;
        autoStartStop.setText("Start");
        autoReset.setVisibility(View.VISIBLE);
    }

    public void resetAuto() {
        autoTimeLeft = autoTimerMilli;
        updateAuto();
        autoReset.setVisibility(View.INVISIBLE);
        autoStartStop.setVisibility(View.VISIBLE);
    }


    private void pauseTele() {
        teleCount.cancel();
        teleRun = false;
        teleStartStop.setText("Start");
        teleReset.setVisibility(View.VISIBLE);
    }

    public void resetTele() {
        teleTimeLeft = teleTimerMilli;
        updateTele();
        teleReset.setVisibility(View.INVISIBLE);
        teleStartStop.setVisibility(View.VISIBLE);
    }

    private void startTele() {
        teleCount = new CountDownTimer(teleTimeLeft, 100) {
            @Override
            public void onTick(long x) {
                teleTimeLeft = x;
                updateTele();
            }

            @Override
            public void onFinish() {
                teleRun = false;
                teleStartStop.setText("Start");
                teleStartStop.setVisibility(View.INVISIBLE);
                teleReset.setVisibility(View.VISIBLE);
                teleFirstRow = teleScored()[0];
                teleSecondRow = teleScored()[1];
                teleThirdRow = teleScored()[2];
                teleScore = teleScored()[3];
            }
        }.start();
        teleRun = true;
        teleStartStop.setText("Stop");
        teleReset.setVisibility(View.INVISIBLE);
    }

    private void updateTele() {
        int min = (int) (teleTimeLeft / 1000) / 60;
        int sec = (int) (teleTimeLeft / 1000) % 60;

        String timeLeft = String.format(Locale.getDefault(), "%02d:%02d", min, sec);
        teleCountdown.setText(timeLeft);
    }

    private int[] autoScored() {
        int first = 0;
        int second = 0;
        int third = 0;
        int additional = 0;
        updateScores();
        for (int i = 0; i < scoreList.length; i++) {
            int count = 0;

            for (int j = 0; j < scoreList[1].length; j++) {
                if (scoreList[i][j]) {
                    count++;
                }
            }

            if (i == 0) {
                third = count;
            } else if (i == 1) {
                second = count;
            } else {
                first = count;
            }
        }


        int[] scores = new int[]{first, second, third, first * 2 + second * 4 + third * 6 + additional};
        return scores;
    }

    private int[] teleScored() {
        int first = 0;
        int second = 0;
        int third = 0;
        int additional = 0;
        updateScores();
        for (int i = 0; i < scoreList.length; i++) {
            int count = 0;

            for (int j = 0; j < scoreList[1].length; j++) {
                if (scoreList[i][j]) {
                    count++;
                }
            }

            if (i == 0) {
                third = count - autoThirdRow;
            } else if (i == 1) {
                second = count - autoSecondRow;
            } else {
                first = count - autoFirstRow;
            }
        }



        int[] scores = new int[]{first, second, third, first * 2 + second * 3 + third * 5 + additional};
        return scores;
    }

    private void updateScores(){
        scoreList[0][0] = three_1.isChecked();
        scoreList[0][1] = three_2.isChecked();
        scoreList[0][2] = three_3.isChecked();
        scoreList[0][3] = three_4.isChecked();
        scoreList[0][4] = three_5.isChecked();
        scoreList[0][5] = three_6.isChecked();
        scoreList[0][6] = three_7.isChecked();
        scoreList[0][7] = three_8.isChecked();
        scoreList[0][8] = three_9.isChecked();
        scoreList[1][0] = two_1.isChecked();
        scoreList[1][1] = two_2.isChecked();
        scoreList[1][2] = two_3.isChecked();
        scoreList[1][3] = two_4.isChecked();
        scoreList[1][4] = two_5.isChecked();
        scoreList[1][5] = two_6.isChecked();
        scoreList[1][6] = two_7.isChecked();
        scoreList[1][7] = two_8.isChecked();
        scoreList[1][8] = two_9.isChecked();
        scoreList[2][0] = one_1.isChecked();
        scoreList[2][1] = one_2.isChecked();
        scoreList[2][2] = one_3.isChecked();
        scoreList[2][3] = one_4.isChecked();
        scoreList[2][4] = one_5.isChecked();
        scoreList[2][5] = one_6.isChecked();
        scoreList[2][6] = one_7.isChecked();
        scoreList[2][7] = one_8.isChecked();
        scoreList[2][8] = one_9.isChecked();
    }

    private void reset(){
        three_1.setChecked(false);
        three_2.setChecked(false);
        three_3.setChecked(false);
        three_4.setChecked(false);
        three_5.setChecked(false);
        three_6.setChecked(false);
        three_7.setChecked(false);
        three_8.setChecked(false);
        three_9.setChecked(false);
        two_1.setChecked(false);
        two_2.setChecked(false);
        two_3.setChecked(false);
        two_4.setChecked(false);
        two_5.setChecked(false);
        two_6.setChecked(false);
        two_7.setChecked(false);
        two_8.setChecked(false);
        two_9.setChecked(false);
        one_1.setChecked(false);
        one_2.setChecked(false);
        one_3.setChecked(false);
        one_4.setChecked(false);
        one_5.setChecked(false);
        one_6.setChecked(false);
        one_7.setChecked(false);
        one_8.setChecked(false);
        one_9.setChecked(false);


        matchNumber.setText("");
        teamNumber.setText("");
        Comments.setText("");
        defence.setText("");
        driver.setText("");

        Mobility.setChecked(false);
        AutoEngaged.setChecked(false);
        AutoNotEngaged.setChecked(false);
        TeleEngaged.setChecked(false);
        TeleNotEngaged.setChecked(false);
        robotBroke.setChecked(false);

        linksScored = 0;
        updateLinks();
        placementsMissed = 0;
        updatePlace();
        timeStopped = 0;
        stopped.setText("STARTED DOCKING");
        cycleTime = 0;

        resetAuto();
        resetTele();
    }
}

