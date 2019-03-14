package kr.co.woobi.imyeon.recyclerviewexam0312;

import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.view.menu.MenuView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    //아이템 추가하기
    public void addItem(MovieModel movieModel, int index) {
        mData.add(index, movieModel);
    }

//
//    public void addItem(MovieModel movieModel) {
//        mData.add(movieModel, 0);
//    }


    // 인터페이스 정의하기
    public interface MyRecyclerViewClickListener {
        void onShowMoiveTitile(int posion);

        void onClick(View v, int position, MovieModel movieModel);

        void onLongClick(int position, MovieModel movieModel);
    }

    //필드
    List<MovieModel> mData;
    private MyRecyclerViewClickListener mListener;
    private Set<Integer> mSelectedPositionSet = new HashSet<>();


    //item 클릭시 배경색 바꾸기
    public void setSeclect(int position) {
        if (mSelectedPositionSet.contains(position)) {
            mSelectedPositionSet.remove(position);
        } else {
            mSelectedPositionSet.add(position);
        }
    }

    // 롱클릭시 아이템 삭제하기
    public void removeItem(int position) {
        mData.remove(position);
    }

    public void removeItem(MovieModel movieModel) {
        mData.remove(movieModel);
    }


    public void setOnClickListener(MyRecyclerViewClickListener listener) {
        mListener = listener;
    }


    //생성자
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
        final MovieModel item = mData.get(i);

        if (mSelectedPositionSet.contains(i)) {
            viewHolder.itemView.setBackgroundColor(Color.DKGRAY);
        } else {
            viewHolder.itemView.setBackgroundColor(Color.WHITE);
        }

        if (i % 2 == 0) {
            viewHolder.itemView.setBackgroundResource(android.R.color.holo_blue_bright);
        }

        viewHolder.mImageMoive.setImageResource(item.getMovieImage());
        viewHolder.mTextTitle.setText(item.getTitle());
        viewHolder.mTextRating.setRating((float) item.getRating());

        if (mListener != null) {
            final int pos = i;
            viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mListener.onShowMoiveTitile(pos);
                    mListener.onClick(v, pos, item);
                }
            });

            viewHolder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    mListener.onLongClick(pos, item);
                    return true;
                }
            });
        }
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
