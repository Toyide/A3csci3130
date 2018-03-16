package com.acme.a3csci3130;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class CreateContactAcitivity extends Activity {

    private Button submitButton;
    private EditText nameField, emailField, BnumberField,addressField;
    private Spinner BroleSpin,provinceSprin;
    private MyApplicationData appState;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_contact_acitivity);
        //Get the app wide shared variables
        appState = ((MyApplicationData) getApplicationContext());

        submitButton = (Button) findViewById(R.id.submitButton);
        nameField = (EditText) findViewById(R.id.name);
        emailField = (EditText) findViewById(R.id.email);
        BnumberField =(EditText) findViewById(R.id.Bnumber);
        addressField =(EditText) findViewById(R.id.address);

        BroleSpin = (Spinner) findViewById(R.id.Brole);
        List<String> Brole = new ArrayList<String>();
        Brole.add("Select a Business Role");
        Brole.add("Fisher");
        Brole.add("Distributor");
        Brole.add("Processor");
        Brole.add("Fish Monger");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, Brole);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        BroleSpin.setAdapter(dataAdapter);

        provinceSprin = (Spinner) findViewById(R.id.province);
        List<String> prov = new ArrayList<String>();
        prov.add("Select a Province");
        prov.add("AB");
        prov.add("BC");
        prov.add("MB");
        prov.add("NB");
        prov.add("NL");
        prov.add("NS");
        prov.add("NT");
        prov.add("NU");
        prov.add("ON");
        prov.add("PE");
        prov.add("QC");
        prov.add("SK");
        prov.add("YT");
        prov.add("");
        ArrayAdapter<String> dataAdapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, prov);
        dataAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        provinceSprin.setAdapter(dataAdapter2);
    }

    public void submitInfoButton(View v) {
        //each entry needs a unique ID
        String personID = appState.firebaseReference.push().getKey();
        String name = nameField.getText().toString();
        String email = emailField.getText().toString();
        String Bnum= BnumberField.getText().toString();
        String addr=addressField.getText().toString();
        String Br= BroleSpin.getSelectedItem().toString();
        String prove=provinceSprin.getSelectedItem().toString();


        Contact person = new Contact(personID, name, email,Bnum,addr,Br,prove);

        appState.firebaseReference.child(personID).setValue(person);

        finish();

    }
}
