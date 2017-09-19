package scalehealth.scalev0;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import scalehealth.scalev0.models.Patient;

/**
 * Created by mayank on 9/9/17.
 */

public class PatientRecyclerAdapter extends RecyclerView.Adapter<PatientRecyclerAdapter.PatientHolder> {

    private ArrayList<Patient> patientList;

    public static class PatientHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView patientName;
        private TextView patientAge;
        private TextView patientSex;
        private final Context context;


        public PatientHolder(View v) {
            super(v);
            context = v.getContext();
            patientName = (TextView) v.findViewById(R.id.patientName);
            patientAge = (TextView) v.findViewById(R.id.patientAge);
            patientSex = (TextView) v.findViewById(R.id.patientSex);
            v.setOnClickListener(this);
        }


        @Override
        public void onClick(View v) {
           // int itemPosition = getChildLayoutPosition(v);

            Intent profileIntent = new Intent(context, PatientProfileActivity.class);
            context.startActivity(profileIntent);
            Log.d("RecyclerView", "CLICK!");
        }

        public void bindPatient(Patient patient) {
            patientName.setText(patient.getName());
            if(patient.isSex() == 0) patientSex.setText("Male");
            else {
                patientSex.setText("Female");
            }
            patientAge.setText(Integer.toString(patient.getAge()));
            //patientDiagnosis.setText("Merkel Cell Carcinoma");

        }
    }


    public PatientRecyclerAdapter(ArrayList<Patient> patients) {
        patientList = patients;
    }

    @Override
    public PatientRecyclerAdapter.PatientHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflatedView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_patient, parent, false);
        return new PatientHolder(inflatedView);

    }

    @Override
    public void onBindViewHolder(PatientRecyclerAdapter.PatientHolder holder, int position) {
        Patient patient = patientList.get(position);
        holder.bindPatient(patient);

    }

    @Override
    public int getItemCount() {
        return patientList.size();
    }


}
