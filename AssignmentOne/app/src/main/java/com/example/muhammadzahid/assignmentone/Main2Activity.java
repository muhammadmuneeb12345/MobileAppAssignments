package com.example.muhammadzahid.assignmentone;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;

import java.sql.Driver;
import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity {
    ListView listView;
    ListView listView1;
    ListView listView2;
    ListView listView3;
    GridView dgv;


    String [] info = new String[]{"Block I House No : B-27 ","North Nazimabad Karachi","Cell. No: 0322-2457318","E-Mail: muneebnaeemsheikh99@gmail.com"};
    String[] aim = new String[]{"AIMS & OBJECTIVES"};
    String[] aimans = new String[]{"To work in a dynamic organization where I can elevate my professional skills and abilities and utilize those for securing benefits for the organization and my own self."};
    String [] skills = new String[]{"C#","Asp.Net MVC-4","MSSQL","Bash Scripting","JAVA","HTML5","CSS3","JAVASCRIPT","MS Office"};




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        show();
        infofor();
        showinfo();
        showinfoans();
        fillgridview();
        showskills();

    }
    public  void show()
    {
        Intent intent = getIntent();
    }
    public void infofor(){
        listView = (ListView)findViewById(R.id.listView);
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this,R.layout.next,info);
        listView.setAdapter(adapter1);

    }
    public void showinfo(){
        listView1 = (ListView)findViewById(R.id.listView2);
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this,R.layout.next,aim);
        listView1.setAdapter(adapter1);
    }
    public void showinfoans(){
        listView2 = (ListView)findViewById(R.id.listView3);
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this,R.layout.next,aimans);
        listView2.setAdapter(adapter1);
    }
    public void fillgridview()
    {
        dgv = (GridView)findViewById(R.id.gridView);
        List<String> values = new ArrayList<String>();
        values.add("BS(CS)");values.add("Institute:");values.add("PAF-KIET (Pak Air Force Karachi Institute of Economics and  Technology)");values.add(" ");values.add("Subjects:");
        values.add("DP, NP, DS , DBMS , OOAD");values.add(" ");values.add("Year of Passing:");values.add("In Progress");
        values.add("HSC. (Pre-Engineering)");values.add("Institute:");values.add("Govt. Jinnah College North Nazimabad");values.add(" ");values.add("Subjects:");values.add("Maths , Physics , Chemistry");values.add(" ");values.add("Year of Passing:");values.add("2014 with B-Grade");
        values.add("tMatric.(Science)");values.add("Institute:");values.add("Little Folk's School Block R");values.add("");values.add("Subjects:");values.add("Maths , Physics , Chemistry");values.add("");values.add("Year of Passing:");values.add("2012 with B+ Grade ");
        dgv.setAdapter(new ArrayAdapter<String>(this,R.layout.next,values));
    }
    public void showskills()
    {
        listView3 = (ListView)findViewById(R.id.listView4);
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this,R.layout.next,skills);
        listView3.setAdapter(adapter1);
    }
}


