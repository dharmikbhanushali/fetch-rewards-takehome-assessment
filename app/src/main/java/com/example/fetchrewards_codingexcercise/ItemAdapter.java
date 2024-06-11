package com.example.fetchrewards_codingexcercise;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemViewHolder>{

    //reference to the list we are using
    private List<Item> items;

    //creating a constructor and initializing the items list
    public ItemAdapter(List<Item> items){
        this.items = items;
    }


    //inflating the layout for an item and creating a view holder
    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view, parent, false);
        return new ItemViewHolder(view);

    }

    //binding data to the view holder
    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position){
        Item item = items.get(position);
        holder.listIdTextView.setText("List ID: " + item.getListId());
        holder.nameTextView.setText("Name:" + item.getName());
    }

    //get items
    @Override
    public int getItemCount(){
        return items.size();
    }

    //view holder class
    public static class ItemViewHolder extends RecyclerView.ViewHolder{
        TextView listIdTextView;
        TextView nameTextView;

        //initializing text views
        public ItemViewHolder(@NonNull View itemView){
        super(itemView);
        listIdTextView = itemView.findViewById(R.id.listIdTextView);
        nameTextView = itemView.findViewById(R.id.nameTextView);
    }

}
}
