package com.example.andrew.elucidat.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.AppCompatSpinner;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.andrew.elucidat.R;
import com.example.andrew.elucidat.classes.Tutors;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class registerFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child("Tutors");



    public registerFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment registerFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static registerFragment newInstance(String param1, String param2) {
        registerFragment fragment = new registerFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_register, container, false);
        final EditText Tutor_state,Tutor_name,Tutor_phno;
        final AppCompatSpinner Tutor_nativelang;
        final Context context = view.getContext();
        Tutor_name =(EditText)view.findViewById(R.id.tutor_name);
        Tutor_phno=(EditText)view.findViewById(R.id.tutor_phno);
        Tutor_state=(EditText)view.findViewById(R.id.tutor_state);
        Tutor_nativelang=(AppCompatSpinner)view.findViewById(R.id.tutor_nativelang);
        Tutor_nativelang.setSelection(0);
        Button Reg_ok,Reg_cancel;
        Reg_ok=(Button)view.findViewById(R.id.reg_ok);
        Reg_cancel=(Button)view.findViewById(R.id.reg_cancel);
        Reg_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name="",phno="",state="",nativelang;
                name=Tutor_name.getText().toString();
                phno=Tutor_phno.getText().toString();
                state=Tutor_state.getText().toString();
                nativelang=Tutor_nativelang.getSelectedItem().toString();
                if((!name.isEmpty())&&(!phno.isEmpty())&&(!state.isEmpty()))
                {
                    final Tutors tutors = new Tutors(name,phno,state,nativelang);
                    reference.push().setValue(tutors).addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void aVoid) {
                            Toast.makeText(context,"sucess in firebase",Toast.LENGTH_SHORT);
                            Log.d("sucess","sssssssssssssssssssssssssssssssssssssssssssssshhhhhhhhhhhhhhhhhhuuuuuuuuuuuuu");
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(context,"failure in firebase",Toast.LENGTH_SHORT);
                            Log.e("failure","faiiiiiiiiiiiiiiiiiiiiiiilllllllllll");

                        }
                    });

                }
                else
                {
                    Toast.makeText(context,"please fill all the fields",Toast.LENGTH_SHORT);
                    Log.e("tffg","888888888888888888888888888888888888888");
                }



            }
        });

        return view;



    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}
