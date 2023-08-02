package com.example.callandsaveprep;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener
{
    Button one,two,three,four,five,six,seven,eight,nine,zero,star,hash,call,save,del;
    EditText pn;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pn=(EditText)findViewById(R.id.disppn);
        pn.setText("");

        one=(Button)findViewById(R.id.bone);
        one.setOnClickListener(this);

        two=(Button)findViewById(R.id.btwo);
        two.setOnClickListener(this);

        three=(Button)findViewById(R.id.bthree);
        three.setOnClickListener(this);

        four=(Button)findViewById(R.id.bfour);
        four.setOnClickListener(this);

        five=(Button)findViewById(R.id.bfive);
        five.setOnClickListener(this);

        six=(Button)findViewById(R.id.bsix);
        six.setOnClickListener(this);

        seven=(Button)findViewById(R.id.bseven);
        seven.setOnClickListener(this);

        eight=(Button)findViewById(R.id.beight);
        eight.setOnClickListener(this);

        nine=(Button)findViewById(R.id.bnine);
        nine.setOnClickListener(this);

        zero=(Button)findViewById(R.id.bzero);
        zero.setOnClickListener(this);

        star=(Button)findViewById(R.id.bstar);
        star.setOnClickListener(this);

        hash=(Button)findViewById(R.id.bhash);
        hash.setOnClickListener(this);

        del=(Button)findViewById(R.id.bdel);
        del.setOnClickListener(this);

        call=(Button)findViewById(R.id.bcall);
        call.setOnClickListener(this);

        save=(Button)findViewById(R.id.bsave);
        save.setOnClickListener(this);
    }

    @Override
    public void onClick(View v)
    {
        if(v.equals(one))
            pn.append("1");
        if(v.equals(two))
            pn.append("2");
        if(v.equals(three))
            pn.append("3");
        if(v.equals(four))
            pn.append("4");
        if(v.equals(five))
            pn.append("5");
        if(v.equals(six))
            pn.append("6");
        if(v.equals(seven))
            pn.append("7");
        if(v.equals(eight))
            pn.append("8");
        if(v.equals(nine))
           pn.append("9");
        if(v.equals(zero))
            pn.append("0");
        if(v.equals(star))
            pn.append("*");
        if(v.equals(hash))
            pn.append("#");
        if(v.equals(save))
        {
            Intent ci=new Intent(ContactsContract.Intents.Insert.ACTION);
            ci.setType(ContactsContract.RawContacts.CONTENT_TYPE);
            ci.putExtra(ContactsContract.Intents.Insert.NAME,"Unknown");
            ci.putExtra(ContactsContract.Intents.Insert.PHONE,pn.getText().toString());
            startActivity(ci);
        }
        if(v.equals(del))
        {
            String data=pn.getText().toString();
            if(data.length()>0)
            {
                pn.setText(data.substring(0,data.length()-1));
            }
            else
            {
                pn.setText("");
            }
        }
        call.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                String data=pn.getText().toString();

                Intent i=new Intent(Intent.ACTION_DIAL);
                i.setData(Uri.parse("tel:"+data));
                startActivity(i);
            }
        });
    }
}