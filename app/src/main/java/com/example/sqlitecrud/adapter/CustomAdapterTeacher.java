package com.example.sqlitecrud.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import com.example.sqlitecrud.R;
import com.example.sqlitecrud.model.TeachersModel;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


public class CustomAdapterTeacher extends BaseAdapter implements Filterable {

    private Context context;
    private ArrayList<TeachersModel> teachersModelArrayList;

    public CustomAdapterTeacher(Context context, ArrayList<TeachersModel> teachersModelArrayList) {

        this.context = context;
        this.teachersModelArrayList = teachersModelArrayList;
    }

    //filter

    @Override
    public Filter getFilter() {
        return filter;
    }

    Filter filter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence charSequence) {

            List<TeachersModel> filteredList = new ArrayList<>();

            if (charSequence.toString().isEmpty()) {
                filteredList.addAll(teachersModelArrayList);
            }
            else {
                for (TeachersModel pendingSearch: teachersModelArrayList) {
                    if (pendingSearch.getName().contains(charSequence.toString().toLowerCase())) {
                        filteredList.add(pendingSearch);
                    }

                    if (pendingSearch.getEmail().contains(charSequence.toString().toLowerCase())) {
                        filteredList.add(pendingSearch);
                    }
                    if (pendingSearch.getCourse().contains(charSequence.toString().toLowerCase())) {
                        filteredList.add(pendingSearch);
                    }
                    if (pendingSearch.getPhone().contains(charSequence.toString().toLowerCase())) {
                        filteredList.add(pendingSearch);
                    }
                }

            }

            FilterResults filterResults = new FilterResults();
            filterResults.values = filteredList;

            return filterResults;
        }

        @Override
        protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
            teachersModelArrayList.clear();
            teachersModelArrayList.addAll((Collection<? extends TeachersModel>) filterResults.values);
            notifyDataSetChanged();
        }
    };
    //end untuk filter


    @Override
    public int getCount() {
        return teachersModelArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return teachersModelArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.model_teachers, null, true);

            holder.tvname = (TextView) convertView.findViewById(R.id.teachers_name);
            holder.tvcourse = (TextView) convertView.findViewById(R.id.teachers_course);
            holder.tvemail = (TextView) convertView.findViewById(R.id.teachers_email);
            holder.tvphone = (TextView) convertView.findViewById(R.id.teachers_phone);

            convertView.setTag(holder);
        }else {
            // the getTag returns the viewHolder object set as a tag to the view
            holder = (ViewHolder)convertView.getTag();
        }

        holder.tvname.setText("Name: "+teachersModelArrayList.get(position).getName());
        holder.tvcourse.setText("Course: "+teachersModelArrayList.get(position).getCourse());
        holder.tvemail.setText("Email: "+teachersModelArrayList.get(position).getEmail());
        holder.tvphone.setText(""+teachersModelArrayList.get(position).getPhone());

        return convertView;
    }

    private class ViewHolder {

        protected TextView tvname, tvcourse, tvemail, tvphone;
    }

}