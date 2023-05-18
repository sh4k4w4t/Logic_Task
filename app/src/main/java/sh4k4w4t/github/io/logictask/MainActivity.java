package sh4k4w4t.github.io.logictask;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import sh4k4w4t.github.io.logictask.Services.Model.MainModel;
import sh4k4w4t.github.io.logictask.Services.Model.PoIdModel;
import sh4k4w4t.github.io.logictask.Services.Model.SizeModel;
import sh4k4w4t.github.io.logictask.View.SizeAdapter;
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

        mainActivityViewModel.getMainModelsData().observe(MainActivity.this, new Observer<MainModel>() {
            @Override
            public void onChanged(MainModel mainModel) {
                List<SizeModel> sizeModelList= new ArrayList<>();
                List<PoIdModel> poIdModelList= new ArrayList<>();
                Set<String> hash_set= new HashSet<>();

                if (mainModel!=null){
                    sizeModelList= mainModel.getResultset().getSize();
                    poIdModelList= mainModel.getResultset().getPoIds();
                    for (SizeModel sizeModel: sizeModelList){
                        hash_set.add(sizeModel.getSizeName());
                    }
                    Log.d(TAG, "sizemodel list: "+sizeModelList.size());
                    Log.d(TAG, "poID model list: "+poIdModelList.size());
                    List<String> allSizesList = new ArrayList<>(hash_set);
                    Log.d(TAG, "All Size list: "+allSizesList.size());
                    Log.d(TAG, "All size items: "+allSizesList);

                    sizeAdapter = new SizeAdapter(MainActivity.this,allSizesList,sizeModelList,poIdModelList,binding);
                    binding.recyclerviewForSize.setLayoutManager(new LinearLayoutManager(MainActivity.this,LinearLayoutManager.HORIZONTAL,false));
                    binding.recyclerviewForSize.setAdapter(sizeAdapter);

                }else {
                    Toast.makeText(MainActivity.this, "Erro 1", Toast.LENGTH_SHORT).show();
                }
            }
        });
        mainActivityViewModel.allDataGet(MainActivity.this);
    }
}