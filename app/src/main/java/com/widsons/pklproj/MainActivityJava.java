package com.widsons.pklproj;

import android.Manifest;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;
import com.widsons.pklproj.model.Catatan;
import com.widsons.pklproj.model.ListResource;
import com.widsons.pklproj.model.ListUserResponse;
import com.widsons.pklproj.model.Siswa;
import com.widsons.pklproj.model.User;
import com.widsons.pklproj.model.UserDataResponse;
import com.widsons.pklproj.remote.ApiService;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created on : December/13/2018
 * Author     : Muhammad Fahmi Hidayah
 * Company    : PiXilApps
 * Project    : PklProj
 */
public class MainActivityJava extends AppCompatActivity {

    String jsonData = "[\n" +
            "{\n" +
            "\"nama\": \"Edward Murray\",\n" +
            "\"umur\": 16,\n" +
            "\"type\": 1,\n" +
            "\"address\": \"600 Kristopher Falls Apt. 551\\nNew Kevin, IN 92565\",\n" +
            "\"bio\": \"Offer check society to vote. Need woman quite. Own seven condition late less should.\\nStation learn table throw.\\nDevelopment take investment both score. Offer deep edge through rather enter.\"\n" +
            "},\n" +
            "{\n" +
            "\"nama\": \"Michael Fox\",\n" +
            "\"umur\": 13,\n" +
            "\"type\": 0,\n" +
            "\"address\": \"302 Cindy Landing Suite 915\\nPort Jasonshire, MI 99878\",\n" +
            "\"bio\": \"Magazine old question home them growth. Cultural along environment middle price.\"\n" +
            "},\n" +
            "{\n" +
            "\"nama\": \"Kyle Mcmillan\",\n" +
            "\"umur\": 17,\n" +
            "\"type\": 0,\n" +
            "\"address\": \"32246 Jones Lakes Apt. 289\\nSouth Randall, NV 52815\",\n" +
            "\"bio\": \"Article yeah occur effect. Hit rule research serious. Contain arrive indicate development kind option.\\nService coach understand age. Manager must food specific career range series spring.\"\n" +
            "},\n" +
            "{\n" +
            "\"nama\": \"Natalie Braun\",\n" +
            "\"umur\": 19,\n" +
            "\"type\": 0,\n" +
            "\"address\": \"0153 Natalie Parks Apt. 635\\nSouth Jonathan, ME 50194\",\n" +
            "\"bio\": \"Hotel mention person institution wish loss similar bank. Doctor where feel exactly dark idea.\\nBeautiful coach claim rock read city fine. Drop apply social this miss.\"\n" +
            "},\n" +
            "{\n" +
            "\"nama\": \"Jason Jackson\",\n" +
            "\"umur\": 14,\n" +
            "\"type\": 1,\n" +
            "\"address\": \"86697 Linda Canyon\\nLake Davidborough, MN 45033\",\n" +
            "\"bio\": \"Medical operation especially minute travel share. Tonight contain itself affect. Brother building shoulder none role important.\"\n" +
            "},\n" +
            "{\n" +
            "\"nama\": \"Gerald Moyer\",\n" +
            "\"umur\": 20,\n" +
            "\"type\": 0,\n" +
            "\"address\": \"1087 Adams Parkways\\nSouth Jonathan, IN 10915\",\n" +
            "\"bio\": \"Part gas seat less. Morning program run include. Feeling choice full thank suggest wonder them.\\nUse improve reduce pattern painting. Establish magazine light.\"\n" +
            "},\n" +
            "{\n" +
            "\"nama\": \"Lindsay Wagner\",\n" +
            "\"umur\": 19,\n" +
            "\"type\": 0,\n" +
            "\"address\": \"1820 Wilkins Shore\\nNorth Charlesmouth, AR 65371\",\n" +
            "\"bio\": \"Laugh cost once lawyer two seem. Deep campaign production fear. Like however picture still each anyone.\\nInteresting defense line. Stop evening pressure ready expert happen. Mission family card happy.\"\n" +
            "},\n" +
            "{\n" +
            "\"nama\": \"Ellen Roberts\",\n" +
            "\"umur\": 17,\n" +
            "\"type\": 0,\n" +
            "\"address\": \"79166 Johnson Isle Apt. 224\\nKathleenfurt, ID 01698\",\n" +
            "\"bio\": \"Policy child difference property long situation than. Garden government suddenly easy watch law. Especially job pass national recent.\"\n" +
            "},\n" +
            "{\n" +
            "\"nama\": \"Crystal Ruiz\",\n" +
            "\"umur\": 20,\n" +
            "\"type\": 1,\n" +
            "\"address\": \"9629 Stark Knoll\\nJamiehaven, ID 88805\",\n" +
            "\"bio\": \"Reflect religious kind month artist sense seven who. Billion street view accept area special reason. Big clear threat.\"\n" +
            "},\n" +
            "{\n" +
            "\"nama\": \"Monica Sexton\",\n" +
            "\"umur\": 11,\n" +
            "\"type\": 1,\n" +
            "\"address\": \"2871 Brent Neck\\nWest Timothytown, UT 95224\",\n" +
            "\"bio\": \"Deal president dream image past hit. Treat surface yourself themselves improve.\\nNear forget hotel determine young kid. Myself rest while soon story medical at firm.\"\n" +
            "},\n" +
            "{\n" +
            "\"nama\": \"Regina Bolton\",\n" +
            "\"umur\": 19,\n" +
            "\"type\": 0,\n" +
            "\"address\": \"63647 Hicks Springs Apt. 688\\nKyleland, SD 64499\",\n" +
            "\"bio\": \"Like most tax. Image rest message plan plan energy. Truth same when bed seek interesting strategy.\\nPoint may benefit lawyer perhaps hotel. Each close item road. Common half learn same create style.\"\n" +
            "},\n" +
            "{\n" +
            "\"nama\": \"Daniel Brooks\",\n" +
            "\"umur\": 15,\n" +
            "\"type\": 1,\n" +
            "\"address\": \"77976 Heather Forks\\nNorth Tinaborough, DC 93685\",\n" +
            "\"bio\": \"Evidence involve my bag return instead. Section store forget perform choose through. Whole production approach.\\nOnto age federal. Tv can make social. Attack page yeah above.\"\n" +
            "},\n" +
            "{\n" +
            "\"nama\": \"Kimberly Chapman\",\n" +
            "\"umur\": 15,\n" +
            "\"type\": 0,\n" +
            "\"address\": \"37193 Hall Lane\\nRichardside, TN 25447\",\n" +
            "\"bio\": \"Work size since present call maybe research run. Magazine anyone imagine. From month tree during form. Country policy drug little.\"\n" +
            "},\n" +
            "{\n" +
            "\"nama\": \"Jonathan Martinez\",\n" +
            "\"umur\": 16,\n" +
            "\"type\": 1,\n" +
            "\"address\": \"Unit 1549 Box 0217\\nDPO AE 02534\",\n" +
            "\"bio\": \"Lose view his rather catch director ten. Worry while her chance fill ball. Plan enough high during actually. Product close space throw.\"\n" +
            "},\n" +
            "{\n" +
            "\"nama\": \"Tamara Morgan\",\n" +
            "\"umur\": 17,\n" +
            "\"type\": 1,\n" +
            "\"address\": \"14546 Patton Shoal\\nCollinsfurt, ME 63761\",\n" +
            "\"bio\": \"Production safe per dinner season arm world. Catch degree performance type role rest. Someone hear eat president personal second.\"\n" +
            "},\n" +
            "{\n" +
            "\"nama\": \"Ryan Martinez\",\n" +
            "\"umur\": 10,\n" +
            "\"type\": 1,\n" +
            "\"address\": \"8371 Clark Squares\\nWest Lauraland, WV 89710\",\n" +
            "\"bio\": \"Office fall school exactly necessary. Card guy new. Discussion travel seven above none nation defense animal.\"\n" +
            "},\n" +
            "{\n" +
            "\"nama\": \"Frank Green\",\n" +
            "\"umur\": 10,\n" +
            "\"type\": 0,\n" +
            "\"address\": \"386 Krueger Corners Suite 093\\nNorth Maria, RI 17942\",\n" +
            "\"bio\": \"Share determine road. Rise south various red even fear guy.\\nSo most relate democratic lawyer. Officer type outside southern matter past should. Sport cold hand network.\"\n" +
            "},\n" +
            "{\n" +
            "\"nama\": \"David Hudson\",\n" +
            "\"umur\": 18,\n" +
            "\"type\": 1,\n" +
            "\"address\": \"8590 Lloyd Key Apt. 416\\nEast Carlosville, UT 60706\",\n" +
            "\"bio\": \"Wind force well wish thus two. Why probably operation sing experience during. Design art maintain page make condition. Matter expert marriage data heavy billion city.\"\n" +
            "},\n" +
            "{\n" +
            "\"nama\": \"Debbie Freeman\",\n" +
            "\"umur\": 16,\n" +
            "\"type\": 1,\n" +
            "\"address\": \"18676 Nelson Vista Suite 106\\nSouth Beth, ID 59811\",\n" +
            "\"bio\": \"Performance edge he finally personal serious discussion let. Side industry soon industry onto out. Night wear ability plan subject.\"\n" +
            "},\n" +
            "{\n" +
            "\"nama\": \"Deborah King\",\n" +
            "\"umur\": 17,\n" +
            "\"type\": 0,\n" +
            "\"address\": \"872 Lambert Grove\\nNew Paulchester, WV 31120\",\n" +
            "\"bio\": \"However at book meet work. Level material lawyer close step hard. Go agent radio wind provide.\\nOff lay present news point. Walk security together ball idea.\"\n" +
            "}\n" +
            "]";

    String [] emails = {"fahmi@gmail.com", "doni@gmail.com"};
    String [] phones = {"1231231525", "23434343"};
    String [] nama = {"fahmi", "34353"};

    ArrayList<User> users;
    int [] umur = {12};
    ArrayAdapterCustom adapterString;

    UserDataAdapter userDataAdapter;

    // 1. Buat subclass dari typeToken
    class ArraySiswaTypeToken extends TypeToken<ArrayList<Siswa>> {

    }


    public String fileName = "data.txt";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        final ListView listView = findViewById(R.id.list_view);

        Dexter.withActivity(MainActivityJava.this)
                .withPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE)
                .withListener(new PermissionListener() {
                    @Override
                    public void onPermissionGranted(PermissionGrantedResponse response) {
                        EditText editText = findViewById(R.id.edit_text_message);
                        editText.setText(readFromExternal());
                    }

                    @Override
                    public void onPermissionDenied(PermissionDeniedResponse response) {
                        Toast.makeText(MainActivityJava.this, "Permision ditolak data tidak ditampilkan", Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onPermissionRationaleShouldBeShown(PermissionRequest permission, PermissionToken token) {
                        token.continuePermissionRequest();
                    }
                })
                .check();


        findViewById(R.id.button_save_storage).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dexter.withActivity(MainActivityJava.this)
                        .withPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE)
                        .withListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted(PermissionGrantedResponse response) {
                                EditText editText = findViewById(R.id.edit_text_message);
                                writeToExternal(editText.getText().toString());
                            }

                            @Override
                            public void onPermissionDenied(PermissionDeniedResponse response) {
                                Toast.makeText(MainActivityJava.this, "Permission ditolak data tidak disimpan", Toast.LENGTH_LONG).show();
                            }

                            @Override
                            public void onPermissionRationaleShouldBeShown(PermissionRequest permission, PermissionToken token) {
                                token.continuePermissionRequest();
                            }
                        })
                        .check();
            }
        });


        callApi();

//        usingPrint();
//        usingBufferedReader();
//        // 2. Buat object type Token sub class nya
//        ArraySiswaTypeToken arraySiswaTypeToken = new ArraySiswaTypeToken();
//
//        // 3. extrtact menggunakan method .getType()
//        ArrayList<Siswa> siswas = new GsonBuilder().create().fromJson(jsonData, arraySiswaTypeToken.getType());
//
//        Toast.makeText(this, "Jumlah siswa yang di ekstrak dari json adalah " + siswas.size(),  Toast.LENGTH_LONG).show();
//         // ------
//        users = new ArrayList<>();
//        users.add(new User("fahmi", "fahmi@gmail.com", "092309232"));
//        users.add(new User("doni", "doni@gmail.com", "224756565"));
//        User user = new User();
//
//        user.setNama("abc");
//        user.setPhone("123");
//        user.setEmail("abc@gmail.com");
//        users.add(user);
//
//
//
//       adapterString = new ArrayAdapterCustom(this, -1, siswas);
//        // ------
//        listView.setAdapter(adapterString);
//
////        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
////            @Override
////            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
////
////
////            }
////        });
//
//        ToggleButton toggleButton = findViewById(R.id.toggle_button_delete);
//        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                adapterString.setEditMode(isChecked);
//            }
//        });

    }


    private void testWriteFile() {
        String fileName = "fahmi.txt";
        String name = "test";
        FileOutputStream outputStream;

        try {
            outputStream = openFileOutput(fileName, Context.MODE_PRIVATE);
            outputStream.write(name.getBytes());
            outputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void testReadFile() {
        String fileName = "fahmi.txt";
        FileInputStream inputStream;

        try {
            inputStream = openFileInput(fileName);
            int c = inputStream.read();
            String all = "";
            while (c == -1) {
                all += Character.toString((char)c);
                c = inputStream.read();
            }
            inputStream.close();
            System.out.println("all data " + all );
        }
        catch (Exception ex) {

        }
    }





    private void usingPrint() {
        String fileName = "fahmi.txt";
        String name = "test";
        FileOutputStream outputStream;

        try {
            outputStream = openFileOutput(fileName, Context.MODE_PRIVATE);
            PrintWriter printWriter = new PrintWriter(outputStream);
            printWriter.println("Assalamualaikum\n");
            printWriter.println("Bro\n");
            printWriter.println("fahmi\n");
            printWriter.close();
        }
        catch (Exception ex) {

        }
    }


    private void usingBufferedReader() {
        String fileName = "fahmi.txt";
        FileInputStream inputStream;

        try {
            inputStream = openFileInput(fileName);
            String all = "";
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String line = bufferedReader.readLine();
            while (line != null){
                all += line;
                line = bufferedReader.readLine();
            }
            bufferedReader.close();
            System.out.println("all data " + all );
        }
        catch (Exception ex) {

        }
    }


    public void writeToExternal(String data) {
        File dirExternal = Environment.getExternalStorageDirectory();
        File fileToWrite = new File(dirExternal, fileName);
        try {
            FileWriter fileWriter = new FileWriter(fileToWrite);
            fileWriter.write(data);
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String readFromExternal(){
        String value = "";
        File dirExternal = Environment.getExternalStorageDirectory();
        File fileToRead = new File(dirExternal, fileName);
        try {
            FileReader fileReader = new FileReader(fileToRead);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = bufferedReader.readLine();
            while (line != null) {
                value = value + line + "\n";
                line = bufferedReader.readLine();
            }
            value = value.substring(0, value.length() - 1);
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return value;
    }




    private void writeTextToExternalStorage(String data) {
        File fie = Environment.getExternalStorageDirectory();
        File fileTarget = new File(fie, fileName);
        try {
            FileWriter fileWriter = new FileWriter(fileTarget);
            fileWriter.write(data);
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private String readTextFromExternalStorage() {

        File fie = Environment.getExternalStorageDirectory();
        File fileTarget = new File(fie, fileName);
        String allText = "";
        try {
            FileReader fileReader = new FileReader(fileTarget);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line = bufferedReader.readLine();
            while (line != null) {
                allText += line;
                line = bufferedReader.readLine();
            }
            bufferedReader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return allText;
    }

    private void readJson(String jsonString) {
        ArrayList<Catatan> catatans = new GsonBuilder().create().fromJson(jsonString, new TypeToken<ArrayList<Catatan>>(){}.getType());

    }
    private void convertToJson(ArrayList<Catatan> catatans){
        String json = new GsonBuilder().create().toJson(catatans);
    }


    public void callApi() {
        // operasi 1
        MainApplication mainApplication = (MainApplication) getApplication();
        mainApplication.getApiService().requestUserDetail("2")
                .enqueue(new Callback<UserDataResponse>() {
                    @Override
                    public void onResponse(Call<UserDataResponse> call, Response<UserDataResponse> response) {
                        Toast.makeText(MainActivityJava.this, "first name adalah " + response.body().getData().getFirstName(), Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onFailure(Call<UserDataResponse> call, Throwable t) {

                    }
                });
        // operasi 2

        mainApplication.getApiService().getResource(1)
                .enqueue(new Callback<ListResource>() {
                    @Override
                    public void onResponse(Call<ListResource> call, Response<ListResource> response) {
                        Toast.makeText(MainActivityJava.this, "Jumlah data adalah " + response.body().getData().size(), Toast.LENGTH_LONG).show();
//                        userDataAdapter =
//                                new UserDataAdapter(MainActivityJava.this,
//                                        android.R.layout.simple_list_item_1,
//                                        response.body().getData().size());
                    }

                    @Override
                    public void onFailure(Call<ListResource> call, Throwable t) {
                        System.out.println("error is " + t.getMessage());
                    }
                });

    }


}
