package com.example.katherine.lab_asynctask_recyclerview;


import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class RvAdapter extends RecyclerView.Adapter<RvAdapter.PersonViewHolder> {
    List<Person> persons;
    Context context;
    RvAdapter(List<Person> persons, Context context) {
        this.persons = persons;
        this.context = context;
    }

    @Override
    public int getItemCount() {
        return persons.size();
    }
    @Override
    public PersonViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.contenido, viewGroup, false);
        PersonViewHolder pvh = new PersonViewHolder(v);
        return pvh;
    }

    public static class PersonViewHolder extends RecyclerView.ViewHolder {
        CardView cv;
        TextView personName;
        TextView personAge;
        ImageView personPhoto;

        PersonViewHolder(View itemView) {
            super(itemView);
            cv = (CardView)itemView.findViewById(R.id.cv);
            personName = (TextView)itemView.findViewById(R.id.titletxt);
            personAge = (TextView)itemView.findViewById(R.id.desctxt);
            personPhoto = (ImageView)itemView.findViewById(R.id.logo);
        }

    }
    @Override
    public void onBindViewHolder(PersonViewHolder personViewHolder, int i) {
        personViewHolder.personName.setText(persons.get(i).name);
        personViewHolder.personAge.setText(persons.get(i).age);
        Bitmap originalBitmap = persons.get(i).photoId;
        RoundedBitmapDrawable roundedDrawable =
                RoundedBitmapDrawableFactory.create(context.getResources(),
                        originalBitmap);
        roundedDrawable.setCornerRadius(originalBitmap.getHeight());
        personViewHolder.personPhoto.setImageDrawable(roundedDrawable);
    }
    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

}
