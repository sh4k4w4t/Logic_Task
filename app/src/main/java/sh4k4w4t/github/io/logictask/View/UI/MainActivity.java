package sh4k4w4t.github.io.logictask.View.UI;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import sh4k4w4t.github.io.logictask.Services.Model.MainModel;
import sh4k4w4t.github.io.logictask.Services.Model.PoIdModel;
import sh4k4w4t.github.io.logictask.Services.Model.SizeModel;
import sh4k4w4t.github.io.logictask.View.Adapter.SizeAdapter;
import sh4k4w4t.github.io.logictask.ViewModel.MainActivityViewModel;
import sh4k4w4t.github.io.logictask.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    MainActivityViewModel mainActivityViewModel;
    ActivityMainBinding binding;
    SizeAdapter sizeAdapter;
    private static final String TAG="MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        mainActivityViewModel= new ViewModelProvider(MainActivity.this).get(MainActivityViewModel.class);

        mainActivityViewModel.getMainModelsData().observe(MainActivity.this, mainModel -> {
            List<SizeModel> sizeModelList= new ArrayList<>();
            List<PoIdModel> poIdModelList= new ArrayList<>();

            if (mainModel!=null){
                sizeModelList= mainModel.getResultset().getSize();
                poIdModelList= mainModel.getResultset().getPoIds();
                Log.d(TAG, "sizemodel list: "+sizeModelList.size());
                Log.d(TAG, "poID model list: "+poIdModelList.size());

                sizeAdapter = new SizeAdapter(MainActivity.this,sizeModelList,poIdModelList,binding);
//                    binding.recyclerviewForSize.setLayoutManager(new LinearLayoutManager(MainActivity.this,LinearLayoutManager.VERTICAL,false));
                binding.recyclerviewForSize.setLayoutManager(new GridLayoutManager(MainActivity.this,sizeModelList.size()));
                binding.recyclerviewForSize.setAdapter(sizeAdapter);

            }else {
                Toast.makeText(MainActivity.this, "Erro 1", Toast.LENGTH_SHORT).show();
            }
        });
        mainActivityViewModel.allDataGet(MainActivity.this);
    }
}