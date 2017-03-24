package br.unifor.realmtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import io.realm.Realm;

public class SecondActivity extends AppCompatActivity {

    private Realm realm;
    private TextView textViewNameData;
    private TextView textViewAgeData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        textViewNameData = (TextView) findViewById(R.id.textViewNameDataId);
        textViewAgeData = (TextView) findViewById(R.id.textViewAgeDataId);

        Realm.init(this);

        realm = Realm.getDefaultInstance();

        final Person person = realm.where(Person.class).findFirst();

        if(person != null){
            textViewNameData.setText(person.getName());
            textViewAgeData.setText(Integer.toString(person.getAge()));
        }
        else{
            Toast.makeText(this, "Object not recovered from realm", Toast.LENGTH_SHORT).show();
        }


    }
}
