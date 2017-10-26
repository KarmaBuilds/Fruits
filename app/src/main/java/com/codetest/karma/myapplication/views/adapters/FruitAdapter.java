package com.codetest.karma.myapplication.views.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.codetest.karma.myapplication.R;
import com.codetest.karma.myapplication.data.model.Fruit;
import com.codetest.karma.myapplication.interfaces.listeners.FruitItemClickListener;
import com.codetest.karma.myapplication.interfaces.listeners.OnFruitDetailSelected;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by karma on 26/10/2017.
 */

public class FruitAdapter extends RecyclerView.Adapter<FruitAdapter.VH> {
    private final Context context;
    private List<Fruit> fruitList;
    private OnFruitDetailSelected detailSelected;

    public FruitAdapter(Context context, List<Fruit> fruitList) {
        this.context = context;
        this.fruitList = fruitList;
    }

    @Override
    public VH onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context)
                .inflate(R.layout.card_fruit_layout, parent, false);
        return new VH(view);
    }

    @Override
    public void onBindViewHolder(VH holder, int position) {
        final Fruit fruit = fruitList.get(position);
        holder.tvFruitType.setText(fruit.getType());
        holder.setItemClickListener((view, position1) -> {
            if (detailSelected == null)
                return;
            detailSelected.onFruitDetailSelected(fruitList.get(position1));
        });
    }

    @Override
    public int getItemCount() {
        return fruitList == null ? 0 : fruitList.size();
    }

    public void setFruitList(List<Fruit> fruitList) {
        this.fruitList = fruitList;
        notifyDataSetChanged();
    }

    public void setDetailSelected(OnFruitDetailSelected detailSelected) {
        this.detailSelected = detailSelected;
    }

    public class VH extends RecyclerView.ViewHolder implements View.OnClickListener {
        @BindView(R.id.tvFruitType)
        TextView tvFruitType;
        FruitItemClickListener itemClickListener;

        public VH(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(this);
        }

        public void setItemClickListener(FruitItemClickListener itemClickListener) {
            this.itemClickListener = itemClickListener;
        }

        @Override
        public void onClick(View v) {
            itemClickListener.onFruitClick(v, getLayoutPosition());
        }
    }
}
