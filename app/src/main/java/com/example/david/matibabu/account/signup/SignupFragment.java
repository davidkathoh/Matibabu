package com.example.david.matibabu.account.signup;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.david.matibabu.R;
import com.example.david.matibabu.home.HomeActivity;
import com.example.david.matibabu.presenter.SignUpInterace;
import com.example.david.matibabu.presenter.SignUpPresenter;
import com.example.david.matibabu.addpatient.PatientActivity;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;
import com.google.firebase.database.FirebaseDatabase;

import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;


public class SignupFragment extends Fragment  implements SignupContract.View {
    private Spinner sp_province;
    private Spinner sp_zone;
    private EditText sp_type;
    private EditText edt_minArret;
    private EditText edt_hopitalName;
    private EditText edt_hopitalAddress;
    private EditText edt_hopitalResponsableName;
    private EditText edt_hopitalResponsableNumber;
    private Button btnSave;
    private PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallbacks;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthStateListener;



    ProgressDialog mProgressDialog;
    SignupContract.Presenter presenter;



    public SignupFragment() {

    }

    public static SignupFragment newInstance() {
        SignupFragment signupFragment = new SignupFragment();
        return signupFragment;
    }

    @Override
    public void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthStateListener);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_signup, container, false);

        mAuth = FirebaseAuth.getInstance();
      sp_province =  view.findViewById(R.id.sp_province);
      sp_zone = view.findViewById(R.id.sp_zone_sante);

      edt_minArret = view.findViewById(R.id.edt_hopital_arrete);
      edt_hopitalName = view.findViewById(R.id.edt_hopital_name);
      edt_hopitalAddress = view.findViewById(R.id.edt_hopital_address);
      edt_hopitalResponsableName =view.findViewById(R.id.edt_responsable_name);
      edt_hopitalResponsableNumber = view.findViewById(R.id.edt_responsable_num);
      sp_type = view.findViewById(R.id.sp_structure);
      btnSave = view.findViewById(R.id.btn_save);

     sp_province.setAdapter(new ArrayAdapter<>(getContext(),android.R.layout.simple_list_item_1,
             getResources().getStringArray(R.array.list_province)));
        sp_zone.setAdapter(new ArrayAdapter<>(getContext(),android.R.layout.simple_list_item_1,
             getResources().getStringArray(R.array.nk_list_zone_sante)));


    btnSave.setOnClickListener(v -> {
   // numberAuth(edt_hopitalResponsableNumber.getText().toString());
//            Intent i = new Intent(getContext(), PatientActivity.class);
//           startActivity(i);
        sinup();

    });

    mAuthStateListener = (firebaseAuth) ->{
        if (firebaseAuth.getCurrentUser()!= null){
            startActivity(new Intent(getActivity(),HomeActivity.class));

        }else {
////

            //Task<AuthResult> resultTask = mAuth.signInAnonymously();
            //resultTask.addOnSuccessListener(authResult -> {
                //update user info
//              mProgressDialog.hide();
               // startActivity(new Intent(getActivity(), HomeActivity.class));
            //});
        }

    };


        return view;

    }



    @Override
    public void setPresenter(SignupContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void showLoadingIndicator() {

    }

    @Override
    public void showErrorMessage() {

    }

    @Override
    public void openActivity() {

    }

    @Override
    public void saveHospitalInfo() {
        presenter.registerHospital(
                sp_province.getSelectedItem().toString(),
                sp_zone.getSelectedItem().toString(),
                sp_type.getText().toString(),
                edt_minArret.getText().toString(),
                edt_hopitalName.getText().toString(),
                edt_hopitalAddress.getText().toString(),
                edt_hopitalResponsableName.getText().toString(),
                edt_hopitalResponsableNumber.getText().toString()
        );
    }

    public void sinup(){
        if (validate()) {
            mProgressDialog = new ProgressDialog(getActivity());
            mProgressDialog.setMessage("Enregistrement en cour...");
            mProgressDialog.setIndeterminate(true);
            mProgressDialog.show();

            Task<AuthResult> resultTask = mAuth.signInAnonymously();
            resultTask.addOnSuccessListener(authResult -> {
                saveHospitalInfo();
                mProgressDialog.hide();
                startActivity(new Intent(getActivity(), HomeActivity.class));
            });
        }else {

        }




    }

    public boolean validate(){
        boolean valid = true;
            String arrete = edt_minArret.getText().toString();
            String nomHopital = edt_hopitalName.getText().toString();
            String addressHop = edt_hopitalAddress.getText().toString();
            String nomResponsable = edt_hopitalResponsableName.getText().toString();
            String numeroResponsable = edt_hopitalResponsableNumber.getText().toString();
            if (arrete.isEmpty()){
                //set the error message
                edt_minArret.setError("arrete ministeriel");
                valid = false;
            }else {
                // set error message to null
            }
        if (nomHopital.isEmpty()){
           edt_hopitalName.setError("Nom de l'hopital");
            valid = false;
        }else {
            // set error message to null
        }
        if (addressHop.isEmpty()){
            edt_hopitalAddress.setError("Addresse hopital");
            valid = false;
        }else {
            // set error message to null
        }
        if (nomResponsable.isEmpty()){
           edt_hopitalResponsableName.setError("Nom du responsable");
            valid = false;
        }else {
            // set error message to null
        }
        if (numeroResponsable.isEmpty()){
            //set the error message
            edt_hopitalResponsableNumber.setError("Numero du responsable");
            valid = false;
        }else {
            // set error message to null
        }



        return valid;
    }
    public void numberAuth(String phone) {
    }


}
