package com.tfs.mkaratusi.mkaratusi.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.tfs.mkaratusi.mkaratusi.R;
import com.tfs.mkaratusi.mkaratusi.pojo.Product;

import java.util.List;

/**
 * Created by Dell on 2/10/2018.
 */

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.MyViewHolder> {

    List<Product> products;

    public ProductAdapter(List<Product> products) {
        this.products = products;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.tp_product_list_row, parent,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        final Product product = products.get(position);
        holder.txtProduct.setText("Product : " + product.getItem());
        holder.txtSpecias.setText("Species : " + product.getSpecie());
        holder.txtQuanity.setText("Quantity : " + product.getQuantity());
        holder.txtUnit.setText("Unit : " + product.getUnitMeasure());

    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView txtProduct, txtSpecias, txtQuanity, txtUnit;
        LinearLayout linearLayout;
        public MyViewHolder(View itemView) {
            super(itemView);
            linearLayout = (LinearLayout) itemView.findViewById(R.id.product_list_row);
            txtProduct = (TextView) itemView.findViewById(R.id.txt_product);
            txtSpecias = (TextView) itemView.findViewById(R.id.txt_species);
            txtQuanity = (TextView) itemView.findViewById(R.id.txt_quanity);
            txtUnit = (TextView) itemView.findViewById(R.id.txt_unit);


        }
    }

}