package br.unifor.realmtest;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import io.realm.Realm;

public class MainActivity extends AppCompatActivity{

    private Realm realm;
    private EditText editTextName;
    private EditText editTextAge;
    private Button buttonPersistData;
    private long id = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextName = (EditText) findViewById(R.id.editTextNameId);
        editTextAge = (EditText) findViewById(R.id.editTextAgeId);
        buttonPersistData = (Button) findViewById(R.id.buttonPersistDataId);

        Realm.init(this);

        realm = Realm.getDefaultInstance();

        buttonPersistData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(editTextName.length() != 0 && editTextAge.length() != 0){

                    //persistDataModeOne();

                    persistDataModeTwo();

                    startActivity(new Intent(MainActivity.this, SecondActivity.class));
                }
                else{
                    Toast.makeText(MainActivity.this, "Dados inválidos", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        realm.close();
    }

    public void persistDataModeOne(){

        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                Person person = realm.createObject(Person.class);
                person.setId(id++);
                person.setName(editTextName.getText().toString());
                person.setAge(Integer.parseInt(editTextAge.getText().toString()));
            }
        });
    }

    public void persistDataModeTwo(){

        Person person = new Person(id, editTextName.getText().toString(), Integer.parseInt(editTextAge.getText().toString()));

        realm.beginTransaction();
        realm.insert(person);
        realm.commitTransaction();
    }


}
