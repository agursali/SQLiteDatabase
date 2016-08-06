package com.example.amol.myapplication;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.AvoidXfermode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{

    EditText t,t2,t3;
    Button b,b2,b3,b4;
    SQLiteDatabase db;
    String id,name,mono;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        t=(EditText)findViewById(R.id.editText);
        t2=(EditText)findViewById(R.id.editText2);
        t3=(EditText)findViewById(R.id.editText3);
        b=(Button)findViewById(R.id.button);
        b2=(Button)findViewById(R.id.button2);
        b3=(Button)findViewById(R.id.button3);
        b4=(Button)findViewById(R.id.button4);


        db=openOrCreateDatabase("Amol",MODE_PRIVATE,null);
        db.execSQL("create table if not exists emp(id varchar,name varchar,mono varchar)");
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                id=t.getText().toString();
                name=t2.getText().toString();
                mono=t3.getText().toString();
                db.execSQL("insert into emp values(id,name,mono)");
                Toast.makeText(MainActivity.this, "Record Inserted Successfully", Toast.LENGTH_SHORT).show();

            }
        });
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                id=t.getText().toString();
                name=t2.getText().toString();
                mono=t3.getText().toString();
                db.execSQL("insert into emp values('"+id+"','"+name+"','"+mono+"')");
                Toast.makeText(MainActivity.this, "Record Inserted Successfully", Toast.LENGTH_SHORT).show();

            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                id=t.getText().toString();
                name=t2.getText().toString();
                mono=t3.getText().toString();
                db.execSQL("update emp set name='"+name+"',mono='"+mono+"' where id='"+id+"' ");
                Toast.makeText(MainActivity.this, "Record Updated Successfully", Toast.LENGTH_SHORT).show();

            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                id=t.getText().toString();
                db.execSQL("delete from emp where id='"+id+"' ");
                Toast.makeText(MainActivity.this, "Record Updated Successfully", Toast.LENGTH_SHORT).show();

            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {

                Cursor c=db.rawQuery("select * from emp where id='"+id+"'",null);
                if(c.moveToFirst())
                {
                    t2.setText(c.getString(1));
                    t3.setText(c.getString(2));
                }
                else
                {
                    Toast.makeText(MainActivity.this, "Record is not in Database", Toast.LENGTH_SHORT).show();
                }


            }
        });





    }
}
