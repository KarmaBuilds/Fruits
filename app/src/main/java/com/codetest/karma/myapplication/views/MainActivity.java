package com.codetest.karma.myapplication.views;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.codetest.karma.myapplication.R;
import com.codetest.karma.myapplication.contants.Const;
import com.codetest.karma.myapplication.data.model.Fruit;
import com.codetest.karma.myapplication.interfaces.ipresenter.IBasePresenter;
import com.codetest.karma.myapplication.interfaces.ipresenter.IMainPresenter;
import com.codetest.karma.myapplication.interfaces.iview.IMainView;
import com.codetest.karma.myapplication.views.adapters.FruitAdapter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity implements IMainView {
    @BindView(R.id.rcFruitList)
    RecyclerView rcFruitList;
    private IMainPresenter presenter;
    private FruitAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        presenter.fetchFruits();
    }

    @Override
    public void onFruitListFetchSuccess(List<Fruit> fruitList) {
        if (adapter != null) {
            adapter.setFruitList(fruitList);
            return;
        }
        adapter = new FruitAdapter(this, fruitList);
        adapter.setDetailSelected(fruit -> startFruitDetailActivity(fruit));
        rcFruitList.setLayoutManager(new LinearLayoutManager(this));
        rcFruitList.setAdapter(adapter);
    }

    @Override
    public void showError(String error) {
        Snackbar.make(rcFruitList, error, Snackbar.LENGTH_LONG).show();
    }


    @Override
    public void onPresenterAttachSuccess(IBasePresenter basePresenter) {
        this.presenter = (IMainPresenter) basePresenter;
    }

    private void startFruitDetailActivity(Fruit fruit) {
        Intent detailIntent = new Intent(this, DetailActivity.class);
        Bundle bundle = new Bundle();
        bundle.putParcelable(Const.FRUIT_DETAIL_KEY, fruit);
        detailIntent.putExtras(bundle);
        startActivity(detailIntent);
    }
}
