package com.codetest.karma.myapplication.views;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;

import com.codetest.karma.myapplication.R;
import com.codetest.karma.myapplication.contants.Const;
import com.codetest.karma.myapplication.data.model.Fruit;
import com.codetest.karma.myapplication.interfaces.ipresenter.IBasePresenter;
import com.codetest.karma.myapplication.interfaces.ipresenter.IDetailPresenter;
import com.codetest.karma.myapplication.interfaces.iview.IDetailView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by karma on 25/10/2017.
 */

public class DetailActivity extends BaseActivity implements IDetailView {
    @BindView(R.id.tvFruitType)
    TextView tvFruitType;
    @BindView(R.id.tvFruitPrice)
    TextView tvFruitPrice;
    @BindView(R.id.tvFruitWeight)
    TextView tvFruitWeight;
    private IDetailPresenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_layout);
        ButterKnife.bind(this);
        initiateView(getIntent().getExtras());
    }

    private void initiateView(Bundle bundle) {
        if (bundle == null)
            return;
        Fruit fruit = bundle.getParcelable(Const.FRUIT_DETAIL_KEY);
        if (fruit == null)
            return;
        tvFruitType.setText(fruit.getType());
        tvFruitPrice.setText(fruit.getPrice());
        tvFruitWeight.setText(fruit.getWeight());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onPresenterAttachSuccess(IBasePresenter presenter) {
        this.presenter = (IDetailPresenter) presenter;
    }
}
