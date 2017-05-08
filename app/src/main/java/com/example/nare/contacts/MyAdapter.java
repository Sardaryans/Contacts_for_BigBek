package com.example.nare.contacts;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;


public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private List<Item_class> listitem;
    private Context context;
    

    public MyAdapter(List<Item_class> listitem, Context context) {
        this.listitem = listitem;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        final Item_class item_class = listitem.get(position);
        holder.img_star_view.setImageResource(item_class.getStar_img());
        holder.img_view.setImageResource(item_class.getImg());
        holder.name_view.setText(item_class.getName());

        holder.name_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    FileOutputStream fos = context.openFileOutput("arxiv",context.MODE_APPEND);
                    String s = ""+position+" ";
                    fos.write(s.getBytes());
                    fos.close();


                } catch (Exception e) {

                }
               context.startActivity(new Intent(context,MainActivity.class));
            }
        });

    }

    @Override
    public int getItemCount() {
        return listitem.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView img_star_view;
        private CircleImageView img_view;
        private TextView name_view;
        public ViewHolder(View itemView) {
            super(itemView);

            img_star_view = (ImageView)itemView.findViewById(R.id.star_img);
            img_view = (CircleImageView) itemView.findViewById(R.id.img);
            name_view = (TextView)itemView.findViewById(R.id.name);
        }
    }
}
