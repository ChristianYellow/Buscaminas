package com.cvblogin.com.miness;

import android.content.ContentValues;
import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Random;

public class MainActivity extends AppCompatActivity {


    private Button record, reiniciar;
    Button b11, b12, b13, b14, b15, b16, b17, b18, b21, b22, b23, b24, b25, b26, b27, b28, b31, b32, b33, b34, b35, b36, b37, b38, b41, b42, b43, b44, b45, b46, b47, b48, b51, b52, b53, b54, b55, b56, b57, b58, b61, b62, b63, b64, b65, b66, b67, b68, b71, b72, b73, b74, b75, b76, b77, b78, b81, b82, b83, b84, b85, b86, b87, b88;
    int[][] grid;
    private int restantes = 54;
    Chronometer crono;
    boolean isruntime = false;
    public String max = "99:99";

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inicializarBotones();
        inicializarGrid();
        reiniciar = (Button) findViewById(R.id.reiniciar);
        record = (Button) findViewById(R.id.puntajes);
        crono = (Chronometer) findViewById(R.id.cronometro);

        SQLiteDatabase bd = openOrCreateDatabase("banco01",MODE_PRIVATE, null);
        bd.execSQL("" +
                "" +
                "CREATE TABLE IF NOT EXISTS RANKING\n" +
                "(\n" +
                "id VARCHAR,\n" +
                "min INT, \n"+
                "seg INT\n"+
                ");");
        bd.close();

        reiniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inicializarBotones();
                inicializarGrid();
                crono.stop();
                isruntime=false;
                crono = (Chronometer) findViewById(R.id.cronometro);
                crono.setBase(SystemClock.elapsedRealtime());
                restantes=54;
            }
        });

        record.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SQLiteDatabase bd = openOrCreateDatabase("banco01",MODE_PRIVATE, null);
                Cursor cursor = bd.rawQuery("SELECT * FROM RANKING", null);
                cursor.moveToFirst();

                String inf = "";
                if(cursor.moveToFirst() && cursor.getCount() >= 1){
                    do{
                        String id = cursor.getString(
                                cursor.getColumnIndex("id"));
                        int min = cursor.getInt(cursor.getColumnIndex("min"));
                        int seg = cursor.getInt(cursor.getColumnIndex("seg"));
                        inf+=id+"\t\t"+min+":"+seg+'\n';
                    } while (cursor.moveToNext());
                }
                    cursor.close();

                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("Partidas jugagas")
                        .setMessage("RECORD: "+max+'\n'+'\n'+'\n'+inf)
                        .setCancelable(true)
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        }).show();
            }
        });

    }

    public void inicializarBotones() {
        b11 = (Button) findViewById(R.id.b11);
        b12 = (Button) findViewById(R.id.b12);
        b13 = (Button) findViewById(R.id.b13);
        b14 = (Button) findViewById(R.id.b14);
        b15 = (Button) findViewById(R.id.b15);
        b16 = (Button) findViewById(R.id.b16);
        b17 = (Button) findViewById(R.id.b17);
        b18 = (Button) findViewById(R.id.b18);
        b21 = (Button) findViewById(R.id.b21);
        b22 = (Button) findViewById(R.id.b22);
        b23 = (Button) findViewById(R.id.b23);
        b24 = (Button) findViewById(R.id.b24);
        b25 = (Button) findViewById(R.id.b25);
        b26 = (Button) findViewById(R.id.b26);
        b27 = (Button) findViewById(R.id.b27);
        b28 = (Button) findViewById(R.id.b28);
        b31 = (Button) findViewById(R.id.b31);
        b32 = (Button) findViewById(R.id.b32);
        b33 = (Button) findViewById(R.id.b33);
        b34 = (Button) findViewById(R.id.b34);
        b35 = (Button) findViewById(R.id.b35);
        b36 = (Button) findViewById(R.id.b36);
        b37 = (Button) findViewById(R.id.b37);
        b38 = (Button) findViewById(R.id.b38);
        b41 = (Button) findViewById(R.id.b41);
        b42 = (Button) findViewById(R.id.b42);
        b43 = (Button) findViewById(R.id.b43);
        b44 = (Button) findViewById(R.id.b44);
        b45 = (Button) findViewById(R.id.b45);
        b46 = (Button) findViewById(R.id.b46);
        b47 = (Button) findViewById(R.id.b47);
        b48 = (Button) findViewById(R.id.b48);
        b51 = (Button) findViewById(R.id.b51);
        b52 = (Button) findViewById(R.id.b52);
        b53 = (Button) findViewById(R.id.b53);
        b54 = (Button) findViewById(R.id.b54);
        b55 = (Button) findViewById(R.id.b55);
        b56 = (Button) findViewById(R.id.b56);
        b57 = (Button) findViewById(R.id.b57);
        b58 = (Button) findViewById(R.id.b58);
        b61 = (Button) findViewById(R.id.b61);
        b62 = (Button) findViewById(R.id.b62);
        b63 = (Button) findViewById(R.id.b63);
        b64 = (Button) findViewById(R.id.b64);
        b65 = (Button) findViewById(R.id.b65);
        b66 = (Button) findViewById(R.id.b66);
        b67 = (Button) findViewById(R.id.b67);
        b68 = (Button) findViewById(R.id.b68);
        b71 = (Button) findViewById(R.id.b71);
        b72 = (Button) findViewById(R.id.b72);
        b73 = (Button) findViewById(R.id.b73);
        b74 = (Button) findViewById(R.id.b74);
        b75 = (Button) findViewById(R.id.b75);
        b76 = (Button) findViewById(R.id.b76);
        b77 = (Button) findViewById(R.id.b77);
        b78 = (Button) findViewById(R.id.b78);
        b81 = (Button) findViewById(R.id.b81);
        b82 = (Button) findViewById(R.id.b82);
        b83 = (Button) findViewById(R.id.b83);
        b84 = (Button) findViewById(R.id.b84);
        b85 = (Button) findViewById(R.id.b85);
        b86 = (Button) findViewById(R.id.b86);
        b87 = (Button) findViewById(R.id.b87);
        b88 = (Button) findViewById(R.id.b88);

        b11.setEnabled(true);
        b12.setEnabled(true);
        b13.setEnabled(true);
        b14.setEnabled(true);
        b15.setEnabled(true);
        b16.setEnabled(true);
        b17.setEnabled(true);
        b18.setEnabled(true);
        b21.setEnabled(true);
        b22.setEnabled(true);
        b23.setEnabled(true);
        b24.setEnabled(true);
        b25.setEnabled(true);
        b26.setEnabled(true);
        b27.setEnabled(true);
        b28.setEnabled(true);
        b31.setEnabled(true);
        b32.setEnabled(true);
        b33.setEnabled(true);
        b34.setEnabled(true);
        b35.setEnabled(true);
        b36.setEnabled(true);
        b37.setEnabled(true);
        b38.setEnabled(true);
        b41.setEnabled(true);
        b42.setEnabled(true);
        b43.setEnabled(true);
        b44.setEnabled(true);
        b45.setEnabled(true);
        b46.setEnabled(true);
        b47.setEnabled(true);
        b48.setEnabled(true);
        b51.setEnabled(true);
        b52.setEnabled(true);
        b53.setEnabled(true);
        b54.setEnabled(true);
        b55.setEnabled(true);
        b56.setEnabled(true);
        b57.setEnabled(true);
        b58.setEnabled(true);
        b61.setEnabled(true);
        b62.setEnabled(true);
        b63.setEnabled(true);
        b64.setEnabled(true);
        b65.setEnabled(true);
        b66.setEnabled(true);
        b67.setEnabled(true);
        b68.setEnabled(true);
        b71.setEnabled(true);
        b72.setEnabled(true);
        b73.setEnabled(true);
        b74.setEnabled(true);
        b75.setEnabled(true);
        b76.setEnabled(true);
        b77.setEnabled(true);
        b78.setEnabled(true);
        b81.setEnabled(true);
        b82.setEnabled(true);
        b83.setEnabled(true);
        b84.setEnabled(true);
        b85.setEnabled(true);
        b86.setEnabled(true);
        b87.setEnabled(true);
        b88.setEnabled(true);

        b11.setText("");
        b12.setText("");
        b13.setText("");
        b14.setText("");
        b15.setText("");
        b16.setText("");
        b17.setText("");
        b18.setText("");
        b21.setText("");
        b22.setText("");
        b23.setText("");
        b24.setText("");
        b25.setText("");
        b26.setText("");
        b27.setText("");
        b28.setText("");
        b31.setText("");
        b32.setText("");
        b33.setText("");
        b34.setText("");
        b35.setText("");
        b36.setText("");
        b37.setText("");
        b38.setText("");
        b41.setText("");
        b42.setText("");
        b43.setText("");
        b44.setText("");
        b45.setText("");
        b46.setText("");
        b47.setText("");
        b48.setText("");
        b51.setText("");
        b52.setText("");
        b53.setText("");
        b54.setText("");
        b55.setText("");
        b56.setText("");
        b57.setText("");
        b58.setText("");
        b61.setText("");
        b62.setText("");
        b63.setText("");
        b64.setText("");
        b65.setText("");
        b66.setText("");
        b67.setText("");
        b68.setText("");
        b71.setText("");
        b72.setText("");
        b73.setText("");
        b74.setText("");
        b75.setText("");
        b76.setText("");
        b77.setText("");
        b78.setText("");
        b81.setText("");
        b82.setText("");
        b83.setText("");
        b84.setText("");
        b85.setText("");
        b86.setText("");
        b87.setText("");
        b88.setText("");

        b11.setTextColor(Color.BLACK);
        b12.setTextColor(Color.BLACK);
        b13.setTextColor(Color.BLACK);
        b14.setTextColor(Color.BLACK);
        b15.setTextColor(Color.BLACK);
        b16.setTextColor(Color.BLACK);
        b17.setTextColor(Color.BLACK);
        b18.setTextColor(Color.BLACK);
        b21.setTextColor(Color.BLACK);
        b22.setTextColor(Color.BLACK);
        b23.setTextColor(Color.BLACK);
        b24.setTextColor(Color.BLACK);
        b25.setTextColor(Color.BLACK);
        b26.setTextColor(Color.BLACK);
        b27.setTextColor(Color.BLACK);
        b28.setTextColor(Color.BLACK);
        b31.setTextColor(Color.BLACK);
        b32.setTextColor(Color.BLACK);
        b33.setTextColor(Color.BLACK);
        b34.setTextColor(Color.BLACK);
        b35.setTextColor(Color.BLACK);
        b36.setTextColor(Color.BLACK);
        b37.setTextColor(Color.BLACK);
        b38.setTextColor(Color.BLACK);
        b41.setTextColor(Color.BLACK);
        b42.setTextColor(Color.BLACK);
        b43.setTextColor(Color.BLACK);
        b44.setTextColor(Color.BLACK);
        b45.setTextColor(Color.BLACK);
        b46.setTextColor(Color.BLACK);
        b47.setTextColor(Color.BLACK);
        b48.setTextColor(Color.BLACK);
        b51.setTextColor(Color.BLACK);
        b52.setTextColor(Color.BLACK);
        b53.setTextColor(Color.BLACK);
        b54.setTextColor(Color.BLACK);
        b55.setTextColor(Color.BLACK);
        b56.setTextColor(Color.BLACK);
        b57.setTextColor(Color.BLACK);
        b58.setTextColor(Color.BLACK);
        b61.setTextColor(Color.BLACK);
        b62.setTextColor(Color.BLACK);
        b63.setTextColor(Color.BLACK);
        b64.setTextColor(Color.BLACK);
        b65.setTextColor(Color.BLACK);
        b66.setTextColor(Color.BLACK);
        b67.setTextColor(Color.BLACK);
        b68.setTextColor(Color.BLACK);
        b71.setTextColor(Color.BLACK);
        b72.setTextColor(Color.BLACK);
        b73.setTextColor(Color.BLACK);
        b74.setTextColor(Color.BLACK);
        b75.setTextColor(Color.BLACK);
        b76.setTextColor(Color.BLACK);
        b77.setTextColor(Color.BLACK);
        b78.setTextColor(Color.BLACK);
        b81.setTextColor(Color.BLACK);
        b82.setTextColor(Color.BLACK);
        b83.setTextColor(Color.BLACK);
        b84.setTextColor(Color.BLACK);
        b85.setTextColor(Color.BLACK);
        b86.setTextColor(Color.BLACK);
        b87.setTextColor(Color.BLACK);
        b88.setTextColor(Color.BLACK);

    }

    public void inicializarGrid() {
        restantes=54;
        grid = new int[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                grid[i][j] = 0;
            }
        }

        Random rd = new Random();
        for (int i = 0; i < 10; i++) {
            int x, y;
            x = rd.nextInt(8);
            y = rd.nextInt(8);
            if (grid[x][y] == 9) {
                i--;
            }
            grid[x][y] = 9;
        }

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (grid[i][j] == 9) {
                    try {
                        if (grid[i - 1][j - 1] != 9) grid[i - 1][j - 1]++;
                    } catch (Exception e) {
                    }
                    try {
                        if (grid[i - 1][j] != 9) grid[i - 1][j]++;
                    } catch (Exception e) {
                    }
                    try {
                        if (grid[i - 1][j + 1] != 9) grid[i - 1][j + 1]++;
                    } catch (Exception e) {
                    }
                    try {
                        if (grid[i][j - 1] != 9) grid[i][j - 1]++;
                    } catch (Exception e) {
                    }
                    try {
                        if (grid[i][j + 1] != 9) grid[i][j + 1]++;
                    } catch (Exception e) {
                    }
                    try {
                        if (grid[i + 1][j - 1] != 9) grid[i + 1][j - 1]++;
                    } catch (Exception e) {
                    }
                    try {
                        if (grid[i + 1][j] != 9) grid[i + 1][j]++;
                    } catch (Exception e) {
                    }
                    try {
                        if (grid[i + 1][j + 1] != 9) grid[i + 1][j + 1]++;
                    } catch (Exception e) {
                    }
                }
            }
        }
        for (int i = 0 ; i < 8; i++) {
            for (int j = 0; j< 8; j++) {
                System.out.print(" "+grid[i][j]+" ");
            }
            System.out.println();
        }
    }

    public void clickB(View v) {
        if(!isruntime) {
            crono.setBase(SystemClock.elapsedRealtime());
            crono.start();
            isruntime=true;
        }
        switch (v.getId()) {
            case R.id.b11:
                b11.setEnabled(false);
                b11.setText("" + grid[0][0]);
                verificar(0, 0);
                break;
            case R.id.b12:
                b12.setEnabled(false);
                b12.setText("" + grid[0][1]);
                verificar(0, 1);
                break;
            case R.id.b13:
                b13.setEnabled(false);
                b13.setText("" + grid[0][2]);
                verificar(0, 2);
                break;
            case R.id.b14:
                b14.setEnabled(false);
                b14.setText("" + grid[0][3]);
                verificar(0, 3);
                break;
            case R.id.b15:
                b15.setEnabled(false);
                b15.setText("" + grid[0][4]);
                verificar(0, 4);
                break;
            case R.id.b16:
                b16.setEnabled(false);
                b16.setText("" + grid[0][5]);
                verificar(0, 5);
                break;
            case R.id.b17:
                b17.setEnabled(false);
                b17.setText("" + grid[0][6]);
                verificar(0, 6);
                break;
            case R.id.b18:
                b18.setEnabled(false);
                b18.setText("" + grid[0][7]);
                verificar(0, 7);
                break;
            case R.id.b21:
                b21.setEnabled(false);
                b21.setText("" + grid[1][0]);
                verificar(1, 0);
                break;
            case R.id.b22:
                b22.setEnabled(false);
                b22.setText("" + grid[1][1]);
                verificar(1, 1);
                break;
            case R.id.b23:
                b23.setEnabled(false);
                b23.setText("" + grid[1][2]);
                verificar(1, 2);
                break;
            case R.id.b24:
                b24.setEnabled(false);
                b24.setText("" + grid[1][3]);
                verificar(1, 3);
                break;
            case R.id.b25:
                b25.setEnabled(false);
                b25.setText("" + grid[1][4]);
                verificar(1, 4);
                break;
            case R.id.b26:
                b26.setEnabled(false);
                b26.setText("" + grid[1][5]);
                verificar(1, 5);
                break;
            case R.id.b27:
                b27.setEnabled(false);
                b27.setText("" + grid[1][6]);
                verificar(1, 6);
                break;
            case R.id.b28:
                b28.setEnabled(false);
                b28.setText("" + grid[1][7]);
                verificar(1, 7);
                break;
            case R.id.b31:
                b31.setEnabled(false);
                b31.setText("" + grid[2][0]);
                verificar(2, 0);
                break;
            case R.id.b32:
                b32.setEnabled(false);
                b32.setText("" + grid[2][1]);
                verificar(2, 1);
                break;
            case R.id.b33:
                b33.setEnabled(false);
                b33.setText("" + grid[2][2]);
                verificar(2, 2);
                break;
            case R.id.b34:
                b34.setEnabled(false);
                b34.setText("" + grid[2][3]);
                verificar(2, 3);
                break;
            case R.id.b35:
                b35.setEnabled(false);
                b35.setText("" + grid[2][4]);
                verificar(2, 4);
                break;
            case R.id.b36:
                b36.setEnabled(false);
                b36.setText("" + grid[2][5]);
                verificar(2, 5);
                break;
            case R.id.b37:
                b37.setEnabled(false);
                b37.setText("" + grid[2][6]);
                verificar(2, 6);
                break;
            case R.id.b38:
                b38.setEnabled(false);
                b38.setText("" + grid[2][7]);
                verificar(2, 7);
                break;
            case R.id.b41:
                b41.setEnabled(false);
                b41.setText("" + grid[3][0]);
                verificar(3, 0);
                break;
            case R.id.b42:
                b42.setEnabled(false);
                b42.setText("" + grid[3][1]);
                verificar(3, 1);
                break;
            case R.id.b43:
                b43.setEnabled(false);
                b43.setText("" + grid[3][2]);
                verificar(3, 2);
                break;
            case R.id.b44:
                b44.setEnabled(false);
                b44.setText("" + grid[3][3]);
                verificar(3,3);
                break;
            case R.id.b45:
                b45.setEnabled(false);
                b45.setText("" + grid[3][4]);
                verificar(3,4);
                break;
            case R.id.b46:
                b46.setEnabled(false);
                b46.setText("" + grid[3][5]);
                verificar(3,5);
                break;
            case R.id.b47:
                b47.setEnabled(false);
                b47.setText("" + grid[3][6]);
                verificar(3,6);
                break;
            case R.id.b48:
                b48.setEnabled(false);
                b48.setText("" + grid[3][7]);
                verificar(3,7);
                break;
            case R.id.b51:
                b51.setEnabled(false);
                b51.setText("" + grid[4][0]);
                verificar(4,0);
                break;
            case R.id.b52:
                b52.setEnabled(false);
                b52.setText("" + grid[4][1]);
                verificar(4,1);
                break;
            case R.id.b53:
                b53.setEnabled(false);
                b53.setText("" + grid[4][2]);
                verificar(4,2);
                break;
            case R.id.b54:
                b54.setEnabled(false);
                b54.setText("" + grid[4][3]);
                verificar(4,3);
                break;
            case R.id.b55:
                b55.setEnabled(false);
                b55.setText("" + grid[4][4]);
                verificar(4,4);
                break;
            case R.id.b56:
                b56.setEnabled(false);
                b56.setText("" + grid[4][5]);
                verificar(4,5);
                break;
            case R.id.b57:
                b57.setEnabled(false);
                b57.setText("" + grid[4][6]);
                verificar(4,6);
                break;
            case R.id.b58:
                b58.setEnabled(false);
                b58.setText("" + grid[4][7]);
                verificar(4,7);
                break;
            case R.id.b61:
                b61.setEnabled(false);
                b61.setText("" + grid[5][0]);
                verificar(5,0);
                break;
            case R.id.b62:
                b62.setEnabled(false);
                b62.setText("" + grid[5][1]);
                verificar(5,1);
                break;
            case R.id.b63:
                b63.setEnabled(false);
                b63.setText("" + grid[5][2]);
                verificar(5,2);
                break;
            case R.id.b64:
                b64.setEnabled(false);
                b64.setText("" + grid[5][3]);
                verificar(5,3);
                break;
            case R.id.b65:
                b65.setEnabled(false);
                b65.setText("" + grid[5][4]);
                verificar(5,4);
                break;
            case R.id.b66:
                b66.setEnabled(false);
                b66.setText("" + grid[5][5]);
                verificar(5,5);
                break;
            case R.id.b67:
                b67.setEnabled(false);
                b67.setText("" + grid[5][6]);
                verificar(5,6);
                break;
            case R.id.b68:
                b68.setEnabled(false);
                b68.setText("" + grid[5][7]);
                verificar(5,7);
                break;
            case R.id.b71:
                b71.setEnabled(false);
                b71.setText("" + grid[6][0]);
                verificar(6,0);
                break;
            case R.id.b72:
                b72.setEnabled(false);
                b72.setText("" + grid[6][1]);
                verificar(6,1);
                break;
            case R.id.b73:
                b73.setEnabled(false);
                b73.setText("" + grid[6][2]);
                verificar(6,2);
                break;
            case R.id.b74:
                b74.setEnabled(false);
                b74.setText("" + grid[6][3]);
                verificar(6,3);
                break;
            case R.id.b75:
                b75.setEnabled(false);
                b75.setText("" + grid[6][4]);
                verificar(6,4);
                break;
            case R.id.b76:
                b76.setEnabled(false);
                b76.setText("" + grid[6][5]);
                verificar(6,5);
                break;
            case R.id.b77:
                b77.setEnabled(false);
                b77.setText("" + grid[6][6]);
                verificar(6,6);
                break;
            case R.id.b78:
                b78.setEnabled(false);
                b78.setText("" + grid[6][7]);
                verificar(6,7);
                break;
            case R.id.b81:
                b81.setEnabled(false);
                b81.setText("" + grid[7][0]);
                verificar(7,0);
                break;
            case R.id.b82:
                b82.setEnabled(false);
                b82.setText("" + grid[7][1]);
                verificar(7,1);
                break;
            case R.id.b83:
                b83.setEnabled(false);
                b83.setText("" + grid[7][2]);
                verificar(7,2);
                break;
            case R.id.b84:
                b84.setEnabled(false);
                b84.setText("" + grid[7][3]);
                verificar(7,3);
                break;
            case R.id.b85:
                b85.setEnabled(false);
                b85.setText("" + grid[7][4]);
                verificar(7,4);
                break;
            case R.id.b86:
                b86.setEnabled(false);
                b86.setText("" + grid[7][5]);
                verificar(7,5);
                break;
            case R.id.b87:
                b87.setEnabled(false);
                b87.setText("" + grid[7][6]);
                verificar(7,6);
                break;
            case R.id.b88:
                b88.setEnabled(false);
                b88.setText("" + grid[7][7]);
                verificar(7,7);
                break;
        }

        //Toast.makeText(getApplicationContext(), ""+n, Toast.LENGTH_SHORT).show();
    }

    public void verificar(int x, int y) {
        restantes--;
        if(restantes==0){
            crono.stop();
            isruntime=false;

            max = menorTiempo(max, (String) crono.getText());

            String time = (String) crono.getText();
            int m = Integer.parseInt(time.substring(0, time.indexOf(":")));
            int s = Integer.parseInt(time.substring(time.indexOf(":") + 1, time.length()));

            SQLiteDatabase db= openOrCreateDatabase("banco01",MODE_PRIVATE, null);
            ContentValues cvalues = new ContentValues();
            cvalues.put("id", getDateTime());
            cvalues.put("min", m);
            cvalues.put("seg", s);
            db.insert("RANKING", null, cvalues);
            db.close();

            new AlertDialog.Builder(MainActivity.this)
                    .setTitle("¡Ganaste!")
                    .setMessage("Buen trabajo\n¿Crees poder repetirlo?")
                    .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            reiniciar.callOnClick();
                        }
                    })
                    .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            record.callOnClick();
                        }
                    })
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .show();

        } else if (grid[x][y] == 9) {
            crono.stop();
            isruntime=false;
            new AlertDialog.Builder(MainActivity.this)
                    .setTitle("¡Perdiste!")
                    .setMessage("Suerte para la proxima\n¿Quieres intentar de nuevo?")
                    .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            reiniciar.callOnClick();
                        }
                    })
                    .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            mostrarTodo();
                        }
                    })
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .show();

        }
        if (grid[x][y] == 0) {
            clickAlrededor(x, y);
        }

    }

    public void clickAlrededor(int x, int y) {
        try {
            //if (grid[x - 1][y - 1] == 0) {  clickAlrededor(x-1, y-1);}
            Button aux = buscaBoton(x-1, y-1);
            aux.setText(""+grid[x - 1][y - 1]);
            if(aux.isEnabled()){
                restantes--;}
            aux.setEnabled(false);
        } catch (Exception e) {
        }
        try {
            //if (grid[x - 1][y] ==0){clickAlrededor(x-1, y);}
            Button aux = buscaBoton(x-1, y);
            aux.setText(""+grid[x - 1][y]);
            if(aux.isEnabled()){
                restantes--;}
            aux.setEnabled(false);
        } catch (Exception e) {
        }
        try {
            //if (grid[x - 1][y + 1] == 0) {clickAlrededor(x-1, y+1);}
            Button aux = buscaBoton(x-1, y+1);
            aux.setText(""+grid[x - 1][y + 1]);
            if(aux.isEnabled()){
                restantes--;}
            aux.setEnabled(false);
        } catch (Exception e) {
        }
        try {
            //if (grid[x][y - 1] == 0) {clickAlrededor(x, y-1); }
            Button aux = buscaBoton(x, y-1);
            aux.setText(""+grid[x][y-1]);
            if(aux.isEnabled()){
                restantes--;}
            aux.setEnabled(false);
        } catch (Exception e) {
        }
        try {
            //if (grid[x][y + 1]== 0) {clickAlrededor(x, y+1); }
            Button aux = buscaBoton(x, y+1);
            aux.setText(""+grid[x][y+1]);
            if(aux.isEnabled()){
                restantes--;}
            aux.setEnabled(false);
        } catch (Exception e) {
        }
        try {
            //if (grid[x + 1][y - 1] == 0) {clickAlrededor(x+1, y-1);}
            Button aux =buscaBoton(x+1, y-1);
            aux.setText(""+grid[x + 1][y - 1]);
            if(aux.isEnabled()){
                restantes--;}
            aux.setEnabled(false);
        } catch (Exception e) {
        }
        try {
            //if (grid[x + 1][y] == 0) {clickAlrededor(x+1, y); }
            Button aux = buscaBoton(x+1, y);
            aux.setText(""+grid[x + 1][y]);
            if(aux.isEnabled()){
                restantes--;}
            aux.setEnabled(false);
        } catch (Exception e) {
        }
        try {
            //if (grid[x + 1][y + 1] == 0) {clickAlrededor(x+1, y+1); }
            Button aux = buscaBoton(x+1, y+1);
            aux.setText(""+grid[x + 1][y + 1]);
            if(aux.isEnabled()){
                restantes--;}
            aux.setEnabled(false);
        } catch (Exception e) {
        }
    }

    public Button buscaBoton(int x, int y) {
       switch (x) {
            case (0):
                if (y == 0) return b11;
                if (y == 1) return b12;
                if (y == 2) return b13;
                if (y == 3) return b14;
                if (y == 4) return b15;
                if (y == 5) return b16;
                if (y == 6) return b17;
                if (y == 7) return b18;
                break;
            case (1):
                if (y == 0) return b21;
                if (y == 1) return b22;
                if (y == 2) return b23;
                if (y == 3) return b24;
                if (y == 4) return b25;
                if (y == 5) return b26;
                if (y == 6) return b27;
                if (y == 7) return b28;
                break;
            case (2):
                if (y == 0) return b31;
                if (y == 1) return b32;
                if (y == 2) return b33;
                if (y == 3) return b34;
                if (y == 4) return b35;
                if (y == 5) return b36;
                if (y == 6) return b37;
                if (y == 7) return b38;
                break;
            case (3):
                if (y == 0) return b41;
                if (y == 1) return b42;
                if (y == 2) return b43;
                if (y == 3) return b44;
                if (y == 4) return b45;
                if (y == 5) return b46;
                if (y == 6) return b47;
                if (y == 7) return b48;

                break;
            case (4):
                if (y == 0) return b51;
                if (y == 1) return b52;
                if (y == 2) return b53;
                if (y == 3) return b54;
                if (y == 4) return b55;
                if (y == 5) return b56;
                if (y == 6) return b57;
                if (y == 7) return b58;

                break;
            case (5):
                if (y == 0) return b61;
                if (y == 1) return b62;
                if (y == 2) return b63;
                if (y == 3) return b64;
                if (y == 4) return b65;
                if (y == 5) return b66;
                if (y == 6) return b67;
                if (y == 7) return b68;

                break;
            case (6):
                if (y == 0) return b71;
                if (y == 1) return b72;
                if (y == 2) return b73;
                if (y == 3) return b74;
                if (y == 4) return b75;
                if (y == 5) return b76;
                if (y == 6) return b77;
                if (y == 7) return b78;

                break;

            case (7):
                if (y == 0) return b81;
                if (y == 1) return b82;
                if (y == 2) return b83;
                if (y == 3) return b84;
                if (y == 4) return b85;
                if (y == 5) return b86;
                if (y == 6) return b87;
                if (y == 7) return b88;
                break;

        }
        return null;
    }

    public String menorTiempo(String a, String b) {
        int amin = Integer.parseInt(a.substring(0, a.indexOf(":")));
        int aseg = Integer.parseInt(a.substring(a.indexOf(":")+1, a.length()));
        int bmin = Integer.parseInt(b.substring(0, b.indexOf(":") ));
        int bseg = Integer.parseInt(b.substring(b.indexOf(":")+1, b.length()));
        if(amin > bmin) {
            return b;
        }else if (amin == bmin) {
            if(aseg >= bseg)
                return b;
            else
                return a;
        }else {
            return a;
        }
    }

    public void mostrarTodo() {
        b11.setEnabled(false);
        b11.setText(""+grid[0][0]);
        if (grid[0][0]==9) b11.setTextColor(Color.RED);
        b12.setEnabled(false);
        b12.setText(""+grid[0][1]);
        if (grid[0][1]==9) b12.setTextColor(Color.RED);
        b13.setEnabled(false);
        b13.setText(""+grid[0][2]);
        if (grid[0][2]==9) b13.setTextColor(Color.RED);
        b14.setEnabled(false);
        b14.setText(""+grid[0][3]);
        if (grid[0][3]==9) b14.setTextColor(Color.RED);
        b15.setEnabled(false);
        b15.setText(""+grid[0][4]);
        if (grid[0][4]==9) b15.setTextColor(Color.RED);
        b16.setEnabled(false);
        b16.setText(""+grid[0][5]);
        if (grid[0][5]==9) b16.setTextColor(Color.RED);
        b17.setEnabled(false);
        b17.setText(""+grid[0][6]);
        if (grid[0][6]==9) b17.setTextColor(Color.RED);
        b18.setEnabled(false);
        b18.setText(""+grid[0][7]);
        if (grid[0][7]==9) b18.setTextColor(Color.RED);
        b21.setEnabled(false);
        b21.setText(""+grid[1][0]);
        if (grid[1][0]==9) b21.setTextColor(Color.RED);
        b22.setEnabled(false);
        b22.setText(""+grid[1][1]);
        if (grid[1][1]==9) b22.setTextColor(Color.RED);
        b23.setEnabled(false);
        b23.setText(""+grid[1][2]);
        if (grid[1][2]==9) b23.setTextColor(Color.RED);
        b24.setEnabled(false);
        b24.setText(""+grid[1][3]);
        if (grid[1][3]==9) b24.setTextColor(Color.RED);
        b25.setEnabled(false);
        b25.setText(""+grid[1][4]);
        if (grid[1][4]==9) b25.setTextColor(Color.RED);
        b26.setEnabled(false);
        b26.setText(""+grid[1][5]);
        if (grid[1][5]==9) b26.setTextColor(Color.RED);
        b27.setEnabled(false);
        b27.setText(""+grid[1][6]);
        if (grid[1][6]==9) b27.setTextColor(Color.RED);
        b28.setEnabled(false);
        b28.setText(""+grid[1][7]);
        if (grid[1][7]==9) b28.setTextColor(Color.RED);
        b31.setEnabled(false);
        b31.setText(""+grid[2][0]);
        if (grid[2][0]==9) b31.setTextColor(Color.RED);
        b32.setEnabled(false);
        b32.setText(""+grid[2][1]);
        if (grid[2][1]==9) b32.setTextColor(Color.RED);
        b33.setEnabled(false);
        b33.setText(""+grid[2][2]);
        if (grid[2][2]==9) b33.setTextColor(Color.RED);
        b34.setEnabled(false);
        b34.setText(""+grid[2][3]);
        if (grid[2][3]==9) b34.setTextColor(Color.RED);
        b35.setEnabled(false);
        b35.setText(""+grid[2][4]);
        if (grid[2][4]==9) b35.setTextColor(Color.RED);
        b36.setEnabled(false);
        b36.setText(""+grid[2][5]);
        if (grid[2][5]==9) b36.setTextColor(Color.RED);
        b37.setEnabled(false);
        b37.setText(""+grid[2][6]);
        if (grid[2][6]==9) b37.setTextColor(Color.RED);
        b38.setEnabled(false);
        b38.setText(""+grid[2][7]);
        if (grid[2][7]==9) b38.setTextColor(Color.RED);
        b41.setEnabled(false);
        b41.setText(""+grid[3][0]);
        if (grid[3][0]==9) b41.setTextColor(Color.RED);
        b42.setEnabled(false);
        b42.setText(""+grid[3][1]);
        if (grid[3][1]==9) b42.setTextColor(Color.RED);
        b43.setEnabled(false);
        b43.setText(""+grid[3][2]);
        if (grid[3][2]==9) b43.setTextColor(Color.RED);
        b44.setEnabled(false);
        b44.setText(""+grid[3][3]);
        if (grid[3][3]==9) b44.setTextColor(Color.RED);
        b45.setEnabled(false);
        b45.setText(""+grid[3][4]);
        if (grid[3][4]==9) b45.setTextColor(Color.RED);
        b46.setEnabled(false);
        b46.setText(""+grid[3][5]);
        if (grid[3][5]==9) b46.setTextColor(Color.RED);
        b47.setEnabled(false);
        b47.setText(""+grid[3][6]);
        if (grid[3][6]==9) b47.setTextColor(Color.RED);
        b48.setEnabled(false);
        b48.setText(""+grid[3][7]);
        if (grid[3][7]==9) b48.setTextColor(Color.RED);
        b51.setEnabled(false);
        b51.setText(""+grid[4][0]);
        if (grid[4][0]==9) b51.setTextColor(Color.RED);
        b52.setEnabled(false);
        b52.setText(""+grid[4][1]);
        if (grid[4][1]==9) b52.setTextColor(Color.RED);
        b53.setEnabled(false);
        b53.setText(""+grid[4][2]);
        if (grid[4][2]==9) b53.setTextColor(Color.RED);
        b54.setEnabled(false);
        b54.setText(""+grid[4][3]);
        if (grid[4][3]==9) b54.setTextColor(Color.RED);
        b55.setEnabled(false);
        b55.setText(""+grid[4][4]);
        if (grid[4][4]==9) b55.setTextColor(Color.RED);
        b56.setEnabled(false);
        b56.setText(""+grid[4][5]);
        if (grid[4][5]==9) b56.setTextColor(Color.RED);
        b57.setEnabled(false);
        b57.setText(""+grid[4][6]);
        if (grid[4][6]==9) b57.setTextColor(Color.RED);
        b58.setEnabled(false);
        b58.setText(""+grid[4][7]);
        if (grid[4][7]==9) b58.setTextColor(Color.RED);
        b61.setEnabled(false);
        b61.setText(""+grid[5][0]);
        if (grid[5][0]==9) b61.setTextColor(Color.RED);
        b62.setEnabled(false);
        b62.setText(""+grid[5][1]);
        if (grid[5][1]==9) b62.setTextColor(Color.RED);
        b63.setEnabled(false);
        b63.setText(""+grid[5][2]);
        if (grid[5][2]==9) b63.setTextColor(Color.RED);
        b64.setEnabled(false);
        b64.setText(""+grid[5][3]);
        if (grid[5][3]==9) b64.setTextColor(Color.RED);
        b65.setEnabled(false);
        b65.setText(""+grid[5][4]);
        if (grid[5][4]==9) b65.setTextColor(Color.RED);
        b66.setEnabled(false);
        b66.setText(""+grid[5][5]);
        if (grid[5][5]==9) b66.setTextColor(Color.RED);
        b67.setEnabled(false);
        b67.setText(""+grid[5][6]);
        if (grid[5][6]==9) b67.setTextColor(Color.RED);
        b68.setEnabled(false);
        b68.setText(""+grid[5][7]);
        if (grid[5][7]==9) b68.setTextColor(Color.RED);
        b71.setEnabled(false);
        b71.setText(""+grid[6][0]);
        if (grid[6][0]==9) b71.setTextColor(Color.RED);
        b72.setEnabled(false);
        b72.setText(""+grid[6][1]);
        if (grid[6][1]==9) b72.setTextColor(Color.RED);
        b73.setEnabled(false);
        b73.setText(""+grid[6][2]);
        if (grid[6][2]==9) b73.setTextColor(Color.RED);
        b74.setEnabled(false);
        b74.setText(""+grid[6][3]);
        if (grid[6][3]==9) b74.setTextColor(Color.RED);
        b75.setEnabled(false);
        b75.setText(""+grid[6][4]);
        if (grid[6][4]==9) b75.setTextColor(Color.RED);
        b76.setEnabled(false);
        b76.setText(""+grid[6][5]);
        if (grid[6][5]==9) b76.setTextColor(Color.RED);
        b77.setEnabled(false);
        b77.setText(""+grid[6][6]);
        if (grid[6][6]==9) b77.setTextColor(Color.RED);
        b78.setEnabled(false);
        b78.setText(""+grid[6][7]);
        if (grid[6][7]==9) b78.setTextColor(Color.RED);
        b81.setEnabled(false);
        b81.setText(""+grid[7][0]);
        if (grid[7][0]==9) b81.setTextColor(Color.RED);
        b82.setEnabled(false);
        b82.setText(""+grid[7][1]);
        if (grid[7][1]==9) b82.setTextColor(Color.RED);
        b83.setEnabled(false);
        b83.setText(""+grid[7][2]);
        if (grid[7][2]==9) b83.setTextColor(Color.RED);
        b84.setEnabled(false);
        b84.setText(""+grid[7][3]);
        if (grid[7][3]==9) b84.setTextColor(Color.RED);
        b85.setEnabled(false);
        b85.setText(""+grid[7][4]);
        if (grid[7][4]==9) b85.setTextColor(Color.RED);
        b86.setEnabled(false);
        b86.setText(""+grid[7][5]);
        if (grid[7][5]==9) b86.setTextColor(Color.RED);
        b87.setEnabled(false);
        b87.setText(""+grid[7][6]);
        if (grid[7][6]==9) b87.setTextColor(Color.RED);
        b88.setEnabled(false);
        b88.setText(""+grid[7][7]);
        if (grid[7][7]==9) b88.setTextColor(Color.RED);

    }

    private static String getDateTime() {
        SimpleDateFormat dateFormat = new SimpleDateFormat(
                "yyyy/MM/dd HH:mm:ss", Locale.getDefault());
        Date date = new Date();
        return dateFormat.format(date);
    }
}