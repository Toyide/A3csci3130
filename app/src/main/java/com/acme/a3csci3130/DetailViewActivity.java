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

public class DetailViewActivity extends Activity {

    private EditText nameField, emailField, BnumberField,addressField;
    private Spinner BroleSpin,provinceSprin;
    private MyApplicationData app;
    Contact receivedPersonInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_view);
        receivedPersonInfo = (Contact)getIntent().getSerializableExtra("Contact");

        app = ((MyApplicationData) getApplicationContext());

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
        BroleSpin.setSelection(dataAdapter.getPosition(receivedPersonInfo.brole));

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
        provinceSprin.setSelection(dataAdapter2.getPosition(receivedPersonInfo.province));

        if(receivedPersonInfo != null){
            nameField.setText(receivedPersonInfo.name);
            emailField.setText(receivedPersonInfo.email);
            BnumberField.setText(receivedPersonInfo.bnumber);
            addressField.setText(receivedPersonInfo.address);
        }
    }

    public void updateContact(View v){
        String userId = receivedPersonInfo.uid;
        String name = nameField.getText().toString();
        String email = emailField.getText().toString();
        String bnum = BnumberField.getText().toString();
        String addr = addressField.getText().toString();
        String brole = BroleSpin.getSelectedItem().toString();
        String prov = provinceSprin.getSelectedItem().toString();

        String ar[] = {name,email,bnum,addr,brole,prov};
        String names[] = {"name","email","bnumber","address","brole","province"};

        for (int i=0; i<6; i++){
            app.firebaseReference.child(userId).child(names[i]).setValue(ar[i]);
        }
    }

    public void eraseContact(View v)
    {
        String userId = receivedPersonInfo.uid;
        app.firebaseReference.child(userId).removeValue();
    }
}
