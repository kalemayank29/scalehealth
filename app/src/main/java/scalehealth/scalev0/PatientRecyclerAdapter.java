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

/**
 * Created by mayank on 9/9/17.
 */

public class PatientRecyclerAdapter extends RecyclerView.Adapter<PatientRecyclerAdapter.PatientHolder> {

    private ArrayList<String> patientList;

    public static class PatientHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView patientName;
        private TextView patientAge;
        private TextView patientDiagnosis;
        private final Context context;

        public PatientHolder(View v) {
            super(v);
            context = v.getContext();
            patientName = (TextView) v.findViewById(R.id.patientName);
            patientAge = (TextView) v.findViewById(R.id.patientAge);
            patientDiagnosis = (TextView) v.findViewById(R.id.patientDiagnosis);
            v.setOnClickListener(this);
        }


        @Override
        public void onClick(View v) {
            Intent profileIntent = new Intent(context, PatientProfileActivity.class);
            context.startActivity(profileIntent);
            Log.d("RecyclerView", "CLICK!");
        }

        public void bindPatient(String name) {
            patientName.setText(name);
            patientAge.setText("24 years old female");
            patientDiagnosis.setText("Merkel Cell Carcinoma");

        }
    }


    public PatientRecyclerAdapter(ArrayList<String> patients) {
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
        String patientName = patientList.get(position);
        holder.bindPatient(patientName);

    }

    @Override
    public int getItemCount() {
        return patientList.size();
    }
}
