package th.ac.su.ict.chutikarn.todolist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private ArrayList<String> toDoItems;
    private ArrayAdapter<String> arrayAdapter;
    private Button btnAdd;
    private EditText textInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); //Inflate

        listView = findViewById(R.id.ListView);
        btnAdd = findViewById(R.id.btnAdd);
        textInput = findViewById(R.id.textInput);

        toDoItems = new ArrayList<>();//instantiate
        arrayAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,toDoItems);
        listView.setAdapter(arrayAdapter);


//        for(int l=0; l<=10; l++){
//            String item = "Hello" + l;
//            toDoItems.add(item);
//        }

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addItem(textInput.getText().toString());
                hideKeyboard(v);

            }
        });

        textInput.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if(keyCode == KeyEvent.KEYCODE_ENTER && event.getAction()==KeyEvent.ACTION_DOWN){
                    //Log.d("key listener","key pressed");
                    addItem(textInput.getText().toString());
                    hideKeyboard(v);

                    }


                return false;
            }
        });




    } //  @Override


    private void hideKeyboard(View vie){
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(vie.getWindowToken(),0);
    }

    private void addItem(String item) {

        //toDoItems.add("Hello");

        String message = textInput.getText().toString();

        if (TextUtils.isEmpty(message) == false) {

            toDoItems.add(0, textInput.getText().toString());
            arrayAdapter.notifyDataSetChanged(); //ทำให้โชว์ขึ้นมา\
            textInput.setText("");

            // toDoItems.add(textInput.getText().toString());

        }
    }
}

