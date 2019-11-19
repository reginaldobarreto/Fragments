package br.com.barrsoft.fragments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import br.com.barrsoft.fragments.fragments.AFragment;
import br.com.barrsoft.fragments.fragments.BFragment;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.buttonA)
    Button buttonA;
    @BindView(R.id.buttonB)
    Button buttonB;
    FrameLayout frameLayout;
    private AFragment aFragment;
    private BFragment bFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        aFragment = new AFragment();
        bFragment = new BFragment();


        loadFragment(aFragment);
    }

    private void loadFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frameConteudo, fragment);
        transaction.commit();
    }

    @OnClick(R.id.buttonA)
    public void setActionButtonA(View view){
        loadFragment(aFragment);

    }

    @OnClick(R.id.buttonB)
    public void setActionButtonB(View view){
        loadFragment(bFragment);

    }

}