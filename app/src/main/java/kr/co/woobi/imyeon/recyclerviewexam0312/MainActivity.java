package kr.co.woobi.imyeon.recyclerviewexam0312;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<MovieModel> movie= new ArrayList<>();


        movie.add(new MovieModel(R.drawable.image22,"공조" , 4));
        movie.add(new MovieModel(R.drawable.image33,"더킹" , 3));
        movie.add(new MovieModel(R.drawable.image44,"레지던트이블" , 2.5));
        movie.add(new MovieModel(R.drawable.image55,"럭키" , 5));
        movie.add(new MovieModel(R.drawable.image66,"아수라" , 3));
        movie.add(new MovieModel(R.drawable.image22,"공조" , 3));
        movie.add(new MovieModel(R.drawable.image33,"더킹" , 3));
        movie.add(new MovieModel(R.drawable.image44,"레지던트이블" , 2.9));
        movie.add(new MovieModel(R.drawable.image55,"럭키" , 4.5));
        movie.add(new MovieModel(R.drawable.image66,"아수라" , 3));

        RecyclerView recyclerView=findViewById(R.id.recycle_movielist);
        RecyclerViewAdapter adapter=new RecyclerViewAdapter(movie);
        recyclerView.setAdapter(adapter);
    }
}
