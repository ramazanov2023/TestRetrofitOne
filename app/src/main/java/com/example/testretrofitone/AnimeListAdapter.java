package com.example.testretrofitone;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class AnimeListAdapter extends RecyclerView.Adapter<AnimeListAdapter.Holder> {

    Context context;
    List<Anime> body;

    public AnimeListAdapter(Context context, List<Anime> body) {
        this.context = context;
        this.body = body;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.sample_view_anime,parent,false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        Anime singleAnime = body.get(position);
        holder.nameAnime.setText(singleAnime.name);

        String posterUrl = Api.BASE_URL + singleAnime.image.original;
        Picasso.get().load(posterUrl).into(holder.poster);
        holder.poster.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(Api.BASE_URL + singleAnime.url));
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return body.size();
    }

    public class Holder extends RecyclerView.ViewHolder{
        ImageView poster;
        TextView nameAnime;

        public Holder(@NonNull View itemView) {
            super(itemView);
            poster = itemView.findViewById(R.id.poster);
            nameAnime = itemView.findViewById(R.id.name_anime);
        }
    }
}
