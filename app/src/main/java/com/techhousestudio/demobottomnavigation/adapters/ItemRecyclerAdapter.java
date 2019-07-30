package com.techhousestudio.demobottomnavigation.adapters;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.techhousestudio.demobottomnavigation.R;
import com.techhousestudio.demobottomnavigation.InsertItemActivity;
import com.techhousestudio.demobottomnavigation.UpdateItem;
import com.techhousestudio.demobottomnavigation.models.Item;

import java.util.List;

public class ItemRecyclerAdapter extends RecyclerView.Adapter<ItemRecyclerAdapter.ArticleViewHolder> {
    private Context context;
    private List<Item> items;
    private int[] colors = {Color.RED, Color.GREEN, Color.BLACK, Color.GRAY, Color.CYAN};

    public ItemRecyclerAdapter(Context context) {
        this.context = context;

    }

    public void setItems(List<Item> items) {
        this.items = items;
        notifyDataSetChanged();
    }

    public List<Item> getItems() {
        return items;
    }

    @NonNull
    @Override

    public ItemRecyclerAdapter.ArticleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ArticleViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_article_row, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull final ItemRecyclerAdapter.ArticleViewHolder holder, int position) {
        Item item = items.get(position);
        holder.tvTitle.setText(item.title);
        holder.tvContent.setText(item.content);
        //@SuppressLint("SimpleDateFormat") SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
//        String currentDateandTime = "Date : " + sdf.format(item.create_at);
      // holder.tvDate.setText(currentDateandTime);
       // holder.btnLike.setText(item.likeCount > 1 ? item.likeCount + " Likes" : item.likeCount + " Like");
       final int random = (int) (Math.random() * 5 + 0);

        //holder.viewLine.setBackgroundColor(colors[random]);
        holder.tvTitle.setTextColor(colors[random]);

        holder.tvContent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(context, UpdateItem.class);
                intent.putExtra("id",item.id);
                intent.putExtra("title",holder.tvTitle.getText());
                intent.putExtra("content",holder.tvContent.getText());
                //intent.putExtra("date",holder.tvDate.getText());
                context.startActivity(intent);
            }
        });
/*        holder.btnLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                holder.btnLike.setText(random > 1 ? random + " Likes" : random + " Like");
            }
        });*/
    }

    @Override
    public int getItemCount() {
        if(items!= null)
            return items.size();
        return 0;
    }

    class ArticleViewHolder extends RecyclerView.ViewHolder {
        TextView tvTitle, tvContent;
        //Button btnLike;
        //View viewLine;

        ArticleViewHolder(@NonNull View itemView) {
            super(itemView);
            //viewLine = itemView.findViewById(R.id.view_line);
            tvContent = itemView.findViewById(R.id.tvContent);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            /*btnLike = itemView.findViewById(R.id.btnLike);
            tvDate = itemView.findViewById(R.id.tvDate);*/
        }
    }
}
