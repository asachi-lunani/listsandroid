package com.ndickers.lists;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    ListView myList;
    BaseAdapter adapter;
    ArrayList<Account> arrayList =new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myList =findViewById(R.id.MyList);
        adapter=new BaseAdapter() {
            @Override
            public int getCount() {
                return arrayList.size();
            }

            @Override
            public Object getItem(int position) {
                return arrayList.get(position);
            }

            @Override
            public long getItemId(int position) {
                return position;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
               View v =getLayoutInflater().inflate(R.layout.list_item, null, true);
                TextView txtNames=v.findViewById(R.id.textViewNames);
                TextView txtAccNumber =v.findViewById(R.id.textViewAccNumber);
                TextView txtBalance =v.findViewById(R.id.textViewBalance);

                Account x=arrayList.get(position);
                txtNames.setText(x.getName());
                txtAccNumber.setText(x.getAccNumber());

                Locale locale = new Locale("en", "KE");
                NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(locale);
                String balance=currencyFormatter.format(x.getBalance());


                txtBalance.setText(balance);
               return v;
            }
        };
        myList.setAdapter(adapter);

        myList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Account k =arrayList.get(position);

                Toast.makeText(MainActivity.this, k.getName(), Toast.LENGTH_SHORT).show();
            }
        });

        Account ac1 =new Account("Jade","ACC001",12000);
        Account ac2 =new Account("Sayee","ACC002",12000);
        Account ac3 =new Account("Jolie","ACC003",12000);
        Account ac4=new Account("Jestae","ACC004",12000);
        Account ac5 =new Account("Jeremy","ACC005",12000);
        Account ac6 =new Account("Jaden","ACC006",12000);
        Account ac7 =new Account("Marion","ACC007",12000);
        Account ac8 =new Account("Dearra","ACC008",12000);
        Account ac9=new Account("Bestie","ACC009",12000);
        Account ac10 =new Account("Asachi","ACC010",12000);

        arrayList.add(ac1);
        arrayList.add(ac2);
        arrayList.add(ac3);
        arrayList.add(ac4);
        arrayList.add(ac5);
        arrayList.add(ac6);
        arrayList.add(ac7);
        arrayList.add(ac8);
        arrayList.add(ac9);
        arrayList.add(ac10);

        //refresh on data change
        adapter.notifyDataSetChanged();
        //format 12000000 12,000,000
        //1200 1,200
        //267000 267000

    }
}
