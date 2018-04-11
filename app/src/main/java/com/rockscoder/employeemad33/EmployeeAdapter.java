package com.rockscoder.employeemad33;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class EmployeeAdapter extends ArrayAdapter<Employee> {
    private Context context;
    private List<Employee> employeeList;

    public EmployeeAdapter(@NonNull Context context, @NonNull List<Employee> employeeList) {
        super(context, R.layout.employee_row, employeeList);
        this.context = context;
        this.employeeList = employeeList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(R.layout.employee_row,parent,false);

        TextView textViewName = convertView.findViewById(R.id.rowEmpName);
        TextView textViewAge = convertView.findViewById(R.id.rowEmpAge);
        TextView textViewMobile = convertView.findViewById(R.id.rowEmpMobile);

        textViewName.setText(employeeList.get(position).getEmpName());
        textViewAge.setText(employeeList.get(position).getEmpAge());
        textViewMobile.setText(employeeList.get(position).getEmpPhone());

        return convertView;
    }
}
