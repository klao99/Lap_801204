package th.ac.su.ict.amornchanok.multipleactivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int[] images = {R.drawable.jh, R.drawable.jh, R.drawable.jh, R.drawable.jh};

    String[] version = {"Jaehyun", "Jay", "Jeffry", "Yuno"};

    String[] versionNumber = {"13600111", "13600222", "13600333", "13600444"};

    ListView lView;

    th.ac.su.ict.amornchanok.multipleactivity.ListAdapter lAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lView = (ListView) findViewById(R.id.androidList);
        lAdapter = new th.ac.su.ict.amornchanok.multipleactivity.ListAdapter(MainActivity.this, version, versionNumber, images);
        lView.setAdapter(lAdapter);

        lView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

//                Toast.makeText(MainActivity.this, version[i]+" "+versionNumber[i], Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(MainActivity.this,Main2Activity.class);
                startActivity(intent);



            }
        });

    }
}