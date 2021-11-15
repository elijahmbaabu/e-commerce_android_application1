package com.example.assignment1;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterFragment extends Fragment {

    EditText f_name, u_id, u_add, u_town;
    Button btn_register;
    CheckBox lady, man;
    FirebaseDatabase rooStore;
    DatabaseReference reference;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_register,container, false);
        f_name =  view.findViewById(R.id.user_name);
        u_id = view.findViewById(R.id.user_id);
        u_add = view.findViewById(R.id.user_address);
        u_town = view.findViewById(R.id.town);
        lady = view.findViewById(R.id.female);
        man = view.findViewById(R.id.male);

        btn_register = view.findViewById(R.id.btn_register);


        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                customer_details();
                inflater.inflate(R.layout.fragment_purchase, container, false);

            }
        });
        return view;
    }

    private void customer_details() {
        rooStore = FirebaseDatabase.getInstance();

        reference = rooStore.getReference("Customers");

        String name = f_name.getText().toString();
        String id_no = u_id.getText().toString();
        String address = u_add.getText().toString();
        String town = u_town.getText().toString();
        String f_gender = lady.getText().toString();
        String gender = man.getText().toString();

        if (!name.isEmpty() && !id_no.isEmpty() && !address.isEmpty() && !town.isEmpty()){
            Toast.makeText(getActivity(), "Customer Registered Successfully", Toast.LENGTH_SHORT).show();
        } else{
            Toast.makeText(getActivity(), "Please Enter all the required details!", Toast.LENGTH_SHORT).show();
        }


        DBhelper dBhelper = new DBhelper(name, id_no, address, town, gender,f_gender);

        reference.child(id_no).setValue(dBhelper);
    }
}