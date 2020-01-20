package com.example.collinsyaimok0497;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {

    private RecyclerView categorieList;
    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mDatabase= FirebaseDatabase.getInstance().getReference().child("pretparken");
        mDatabase.keepSynced(true);

        categorieList=(RecyclerView)findViewById(R.id.recycleview);
        categorieList.setHasFixedSize(true);
        categorieList.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    protected void onStart() {
        super.onStart();
        final Intent intNext = new Intent(this, PretparkDetail.class);

        FirebaseRecyclerAdapter<PretPark,CategorieViewHolder>firebaseRecyclerAdapter= new FirebaseRecyclerAdapter<PretPark, CategorieViewHolder>
                (PretPark.class,R.layout.pretpark_row,CategorieViewHolder.class,mDatabase) {
            @Override
            protected void populateViewHolder(CategorieViewHolder viewHolder, PretPark model, int position){
                viewHolder.setTitle(model.getTitle());
                viewHolder.setDesc(model.getDesc());
                viewHolder.setImage(getApplicationContext(),model.getImage());
                viewHolder.itemView.setTag(model.getImage());

                viewHolder.itemView.setOnClickListener(
                        new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                intNext.putExtra("categorie", v.getTag().toString());
                                startActivity(intNext);
                            }
                        }
                );
            }
        };
        categorieList.setAdapter(firebaseRecyclerAdapter);
    }

    public static class CategorieViewHolder extends RecyclerView.ViewHolder {
        View mView;

        public CategorieViewHolder(View itemView){
            super(itemView);
            mView=itemView;
        }

        public void setTitle(String title){
            TextView categorie_title=(TextView)mView.findViewById(R.id.categorie_title);
            categorie_title.setText(title);
        }

        public void setDesc(String desc){
            TextView categorie_desc=(TextView)mView.findViewById(R.id.categorie_desc);
            categorie_desc.setText(desc);
        }

        public void setImage(Context ctx,String image){
            ImageView categorie_image=(ImageView)mView.findViewById(R.id.categorie_image);
            Picasso.get().load(image).into(categorie_image);
        }
    }
}