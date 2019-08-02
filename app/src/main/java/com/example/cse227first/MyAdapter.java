package com.example.cse227first;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    @NonNull
            Context context;
    ArrayList<PersonData> al;
    MyAdapter(Context context, ArrayList<PersonData> al)
    {
        this.context=context;
        this.al=al;

    }
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater li = LayoutInflater.from(context);
        View v=li.inflate(R.layout.mylayout,viewGroup,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i)
    {
        PersonData p=al.get(i);
        myViewHolder.tvname.setText(p.getName());
        myViewHolder.tvreg.setText(""+p.getImgId());

    }

    @Override
    public int getItemCount() {
        return al.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

         TextView tvname,tvreg;
         ImageView img;
         LinearLayout l1;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tvname=itemView.findViewById(R.id.text1);
            tvreg=itemView.findViewById(R.id.text2);
            img=itemView.findViewById(R.id.img);
            img.setVisibility(View.INVISIBLE);
            l1=itemView.findViewById(R.id.ll);
            l1.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v)
                {
                    img.setVisibility(View.VISIBLE);
                    img.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            delete(getAdapterPosition());
                        }
                    });
                    return true;
                }
            });


        }
    }

    private void delete(int adapterPosition) {
        PersonData p = al.get(adapterPosition);
        al.remove(p);
        notifyDataSetChanged();
    }
}
