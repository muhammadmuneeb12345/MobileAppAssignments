package com.example.muhammadzahid.todolistappyoutube;

import android.content.DialogInterface;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button deletebtn;

    DBHelper dbHelper;
    ArrayAdapter<String> adapter;
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dbHelper = new DBHelper(this);
        deletebtn = (Button)findViewById(R.id.deletebtn);
        listView = (ListView)findViewById(R.id.lstTask);
        loadTasklist();
    }
    private void loadTasklist(){
        ArrayList<String> tasklist = dbHelper.getTaskList();
        if(adapter==null){
            adapter = new ArrayAdapter<String>(this,R.layout.row,R.id.tasktitle,tasklist);
            listView.setAdapter(adapter);
        }
        else{
            adapter.clear();
            adapter.addAll(tasklist);
            adapter.notifyDataSetChanged();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main,menu);
        Drawable icon = menu.getItem(0).getIcon();
        icon.mutate();
        icon.setColorFilter(getResources().getColor(android.R.color.white), PorterDuff.Mode.SRC_IN);
        return super.onCreateOptionsMenu(menu);
    }
    public void deleteTask(View view){
        View parent  = (View)view.getParent();
        TextView tasktextview = (TextView)findViewById(R.id.tasktitle);
        String task = String.valueOf(tasktextview.getText());
        dbHelper.deleteTask(task);
        loadTasklist();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_do_task:
                final EditText taskedittask = new EditText(this);
               AlertDialog dialog = new AlertDialog.Builder(this)
                       .setTitle("Add New Task")
                       .setMessage("What do you want to do next ?")
                       .setView(taskedittask)
                       .setPositiveButton("Add", new DialogInterface.OnClickListener() {
                           @Override
                           public void onClick(DialogInterface dialogInterface, int i) {
                               String task = String.valueOf(taskedittask.getText());
                                dbHelper.insertNewTask(task);
                               loadTasklist();
                           }
                       })
                       .setNegativeButton("Cancel",null)
                       .create();
                dialog.show();
                return  true;
        }
        return super.onOptionsItemSelected(item);
    }
}
