package kr.co.woobi.imyeon.recyclerviewexam0312;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<MovieModel> movie = new ArrayList<>();
    private RecyclerView mRecyclerView;
    private RecyclerViewAdapter mAdapter;
    List<Integer> addImage=new ArrayList<>();
    int mRandomImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        movie.add(new MovieModel(R.drawable.image22, "공조", 4));
        movie.add(new MovieModel(R.drawable.image33, "더킹", 3));
        movie.add(new MovieModel(R.drawable.image44, "레지던트이블", 2.5));
        movie.add(new MovieModel(R.drawable.image55, "럭키", 5));
        movie.add(new MovieModel(R.drawable.image66, "아수라", 3));
        movie.add(new MovieModel(R.drawable.image22, "공조", 3));
        movie.add(new MovieModel(R.drawable.image33, "더킹", 3));
        movie.add(new MovieModel(R.drawable.image44, "레지던트이블", 2.9));
        movie.add(new MovieModel(R.drawable.image55, "럭키", 4.5));
        movie.add(new MovieModel(R.drawable.image66, "아수라", 3));

        addImage.add(R.drawable.image11);
        addImage.add(R.drawable.image22);
        addImage.add(R.drawable.image33);
        addImage.add(R.drawable.image44);
        addImage.add(R.drawable.image55);
        addImage.add(R.drawable.image66);

        mRecyclerView = findViewById(R.id.recycle_movielist);
        mAdapter = new RecyclerViewAdapter(movie);
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.setOnClickListener(new RecyclerViewAdapter.MyRecyclerViewClickListener() {
            @Override
            public void onShowMoiveTitile(int position) {
                MovieModel movieModel = movie.get(position);
                String title = movieModel.getTitle();
                Toast.makeText(MainActivity.this, title, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onClick(View v, int position, MovieModel movieModel) {
                mAdapter.setSeclect(position);
                mAdapter.notifyItemChanged(position);
            }

            @Override
            public void onLongClick(int position, MovieModel movieModel) {
                mAdapter.removeItem(movieModel);
                mAdapter.notifyItemRemoved(position);

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        mRandomImage= addImage.get((int) (Math.random()*5));
        double randomRating= Math.random()*5;
        switch (item.getItemId()) {
            case R.id.action_add:
                mAdapter.addItem(new MovieModel(mRandomImage, "추가한 영화", randomRating), 0);
                mAdapter.notifyItemInserted(0);
                mRecyclerView.smoothScrollToPosition(0);
//                mRecyclerView.smoothScrollToPosition(mAdapter.getItemCount() - 1);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}