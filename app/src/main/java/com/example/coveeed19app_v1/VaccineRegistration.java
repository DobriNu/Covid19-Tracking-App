package com.example.coveeed19app_v1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class VaccineRegistration extends AppCompatActivity {

    //Vars
    EditText vacName, vacCnp, vacPhone, vacEmail, vacCity;
    Button vacButton;

    FirebaseDatabase rootNode;
    DatabaseReference reference, reference2, referenceAB,referenceCJ,referenceTM,referenceAR,referenceSB;
    Spinner spinner, spinner2;
    ValueEventListener listener, listener2, listener3,listener4,listener5,listener6,listener7;
    ArrayAdapter<String> adapter, adapter2,adapterAb;
    ArrayList<String> spinnerDataList, spinnerDataList2, spinnerDataListAB,spinnerDataListCJ,spinnerDataListTM,spinnerDataListAR,spinnerDataListSB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vaccine_registration);

        spinner = (Spinner) findViewById(R.id.spinner);
        spinner2 = (Spinner) findViewById(R.id.spinner2);

        reference = FirebaseDatabase.getInstance().getReference("vaccine-city");
        reference2 = FirebaseDatabase.getInstance().getReference("vaccine-place");

        spinnerDataList = new ArrayList<>();
        adapter = new ArrayAdapter<String>(VaccineRegistration.this,
                android.R.layout.simple_spinner_dropdown_item,spinnerDataList);

        spinner.setAdapter(adapter);



        spinnerDataList2 = new ArrayList<>();
        adapter2 = new ArrayAdapter<String>(VaccineRegistration.this,
                android.R.layout.simple_spinner_dropdown_item, spinnerDataList2);

        spinner2.setAdapter(adapter2);

        spinnerDataListAB = new ArrayList<>();
        adapterAb = new ArrayAdapter<String>(VaccineRegistration.this,
                android.R.layout.simple_spinner_item,spinnerDataListAB);


        spinnerDataListCJ = new ArrayList<>();
        spinnerDataListAR = new ArrayList<>();
        spinnerDataListSB = new ArrayList<>();
        spinnerDataListTM = new ArrayList<>();



        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                if(position==0){

                    adapter2 = new ArrayAdapter<>(getApplicationContext(),R.layout.textview_white,spinnerDataList2);

                }

                if(position==1){

                    adapter2 = new ArrayAdapter<>(getApplicationContext(),R.layout.textview_white,spinnerDataListAB);

                }
                if(position==2){

                    adapter2 = new ArrayAdapter<>(getApplicationContext(),R.layout.textview_white,spinnerDataListAR);

                }
                if(position==3){

                    adapter2 = new ArrayAdapter<>(getApplicationContext(),R.layout.textview_white,spinnerDataListCJ);

                }
                if(position==4){

                    adapter2 = new ArrayAdapter<>(getApplicationContext(),R.layout.textview_white,spinnerDataListSB);

                }
                if(position==5){

                    adapter2 = new ArrayAdapter<>(getApplicationContext(),R.layout.textview_white,spinnerDataListTM);

                }


                spinner2.setAdapter(adapter2);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        retriveData();




        //Hooks
        vacName = findViewById(R.id.vacName);
        vacCnp = findViewById(R.id.vacCnp);
        vacPhone = findViewById(R.id.vacPhone);
        vacEmail = findViewById(R.id.vacEmail);
        vacButton = findViewById(R.id.vacButton);

        //Save data in FireBase on btn click
        vacButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rootNode = FirebaseDatabase.getInstance();
                reference = rootNode.getReference("users");


                //Get all the values
                String name = vacName.getText().toString();
                String cnp = vacCnp.getText().toString();
                String phone = vacPhone.getText().toString();
                String email = vacEmail.getText().toString();
                String city = spinner.getSelectedItem().toString();
                String center = spinner2.getSelectedItem().toString();

                UserHelperClassVac helperClassVac = new UserHelperClassVac(name, cnp, phone, email, city, center);

                reference.child(cnp).setValue(helperClassVac);

                Toast.makeText(VaccineRegistration.this, "Your Registration Was Sent Succesfully!", Toast.LENGTH_SHORT).show();



            }
        });



    }
    public void retriveData(){

        listener  = reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for(DataSnapshot item:snapshot.getChildren()){

                    spinnerDataList.add(item.getValue().toString());


                }
                adapter.notifyDataSetChanged();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        listener2 = reference2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for(DataSnapshot item: snapshot.getChildren()){
                    spinnerDataList2.add(item.getValue().toString());
                }
                adapter2.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        referenceAB = FirebaseDatabase.getInstance().getReference("vaccine-place").child("AB");
        listener3 = referenceAB.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot datas: snapshot.getChildren()){
                    spinnerDataListAB.add(datas.getValue().toString());
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        referenceCJ = FirebaseDatabase.getInstance().getReference("vaccine-place").child("CJ");
        listener4 = referenceCJ.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot datas: snapshot.getChildren()){
                    spinnerDataListCJ.add(datas.getValue().toString());
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        referenceAR = FirebaseDatabase.getInstance().getReference("vaccine-place").child("AR");
        listener5 = referenceAR.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot datas: snapshot.getChildren()){
                    spinnerDataListAR.add(datas.getValue().toString());
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        referenceTM = FirebaseDatabase.getInstance().getReference("vaccine-place").child("TM");
        listener6 = referenceTM.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot datas: snapshot.getChildren()){
                    spinnerDataListTM.add(datas.getValue().toString());
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        referenceSB = FirebaseDatabase.getInstance().getReference("vaccine-place").child("SB");
        listener7 = referenceSB.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot datas: snapshot.getChildren()){
                    spinnerDataListSB.add(datas.getValue().toString());
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}