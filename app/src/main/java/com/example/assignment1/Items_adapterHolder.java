package com.example.assignment1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class Items_adapterHolder extends RecyclerView.Adapter<Items_adapterHolder.ViewHolder> {

    Ebuy_store[] ebuy_store;
    PurchaseFragment context;

    public Items_adapterHolder(Ebuy_store[] ebuy_store, PurchaseFragment fragment){

        this.ebuy_store = ebuy_store;
        this.context = fragment;

        class ViewHolder extends RecyclerView.ViewHolder{

            public ViewHolder(@NonNull View itemView) {
                super(itemView);
            }
        }
    }

    @NonNull
    @Override
    public Items_adapterHolder.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.items_view, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }
    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView textView;
        TextView text_price;
        Button btn_buy;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image_view);
            textView = itemView.findViewById(R.id.text_name);
            text_price = itemView.findViewById(R.id.text_price);
            btn_buy = itemView.findViewById(R.id.cart);

        }
    }

    @Override
    public void onBindViewHolder(@NonNull Items_adapterHolder.ViewHolder holder, int position) {

            final Ebuy_store ebuy_storelist =ebuy_store[position];

                holder.textView.setText(ebuy_storelist.getItem_name());
                holder.imageView.setImageResource(ebuy_storelist.getItem_image());
                holder.text_price.setText(ebuy_storelist.getItem_price());
                holder.btn_buy.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(context.getActivity(), "Item Added to Cart", Toast.LENGTH_SHORT).show();
                    }
                });

    }

    @Override
    public int getItemCount() {
        return ebuy_store.length;
    }


}
