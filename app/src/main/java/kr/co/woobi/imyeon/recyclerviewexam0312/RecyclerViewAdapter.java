package kr.co.woobi.imyeon.recyclerviewexam0312;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    List<MovieModel> mData;

    public RecyclerViewAdapter(List<MovieModel> mData) {
        this.mData = mData;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_movielist, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        if(i%2==0){
            viewHolder.itemView.setBackgroundResource(android.R.color.holo_blue_bright);
        }
      MovieModel item=mData.get(i);
      viewHolder.mImageMoive.setImageResource(item.getMovieImage());
      viewHolder.mTextTitle.setText(item.getTitle());
      viewHolder.mTextRating.setRating((float) item.getRating());
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView mImageMoive;
        TextView mTextTitle;
        RatingBar mTextRating;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mImageMoive = itemView.findViewById(R.id.image_movie);
            mTextTitle = itemView.findViewById(R.id.text_movieTile);
            mTextRating = itemView.findViewById(R.id.text_rating);

        }
    }
}
