package com.example.sqlitecrud.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sqlitecrud.R;
import com.example.sqlitecrud.model.Memory;

import java.util.ArrayList;

public class UpdateHistoryAdapter /*extends BaseAdapter*/ {

//    private Context context;
//    private ArrayList<Memory> memoryArrayList;
//
//    public UpdateHistoryAdapter(Context context, ArrayList<Memory> memoryArrayList) {
//        this.context = context;
//        this.memoryArrayList = memoryArrayList;
//    }
//
//    @Override
//    public int getCount() {
//        return memoryArrayList.size();
//    }
//
//    @Override
//    public Object getItem(int position) {
//        return memoryArrayList.get(position);
//    }
//
//    @Override
//    public long getItemId(int position) {
//        return 0;
//    }
//
//    @Override
//    public View getView(int position, View convertView, ViewGroup parent) {
//        CustomAdapterTeacher.ViewHolder holder;
//
//        if (convertView == null) {
//            holder = new CustomAdapterTeacher.ViewHolder();
//            LayoutInflater inflater = (LayoutInflater) context
//                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//            convertView = inflater.inflate(R.layout.model_teachers, null, true);
//
//            holder.tvname = (TextView) convertView.findViewById(R.id.teachers_name);
//            holder.tvcourse = (TextView) convertView.findViewById(R.id.teachers_course);
//            holder.tvemail = (TextView) convertView.findViewById(R.id.teachers_email);
//            holder.tvphone = (TextView) convertView.findViewById(R.id.teachers_phone);
//
//            convertView.setTag(holder);
//        }else {
//            // the getTag returns the viewHolder object set as a tag to the view
//            holder = (CustomAdapterTeacher.ViewHolder)convertView.getTag();
//        }
//
//        holder.tvname.setText("Name: "+teachersModelArrayList.get(position).getName());
//        holder.tvcourse.setText("Course: "+teachersModelArrayList.get(position).getCourse());
//        holder.tvemail.setText("Email: "+teachersModelArrayList.get(position).getEmail());
//        holder.tvphone.setText(""+teachersModelArrayList.get(position).getPhone());
//
//        return convertView;
//    }
//
//    private class ViewHolder {
//
//        protected TextView titleTextView;
//        protected ImageView imageView;
//    }

}
