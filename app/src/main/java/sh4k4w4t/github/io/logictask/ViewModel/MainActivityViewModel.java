package sh4k4w4t.github.io.logictask.ViewModel;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import sh4k4w4t.github.io.logictask.Services.Model.MainModel;
import sh4k4w4t.github.io.logictask.Services.Network.RetrofitAPI;
import sh4k4w4t.github.io.logictask.Services.Network.RetrofitInterface;

public class MainActivityViewModel extends ViewModel {
    MainModel mainModel;
    private final MutableLiveData<MainModel> mainModelMutableLiveData= new MutableLiveData<>();

    public MutableLiveData<MainModel> getMainModelsData(){
        return mainModelMutableLiveData;
    }

    public void allDataGet(Context context){
        RetrofitInterface retrofitInterface= RetrofitAPI.getRetrofitInterface();
        Call<MainModel> calls= retrofitInterface.getMainModelData();
        calls.clone().enqueue(new Callback<MainModel>() {
            @Override
            public void onResponse(@NonNull Call<MainModel> call, @NonNull Response<MainModel> response) {
                if (response.isSuccessful() && response.code()==200){
                    try {
                        mainModel= response.body();
                        if (mainModel!=null){
                            mainModelMutableLiveData.postValue(mainModel);
                        }else {
                            mainModelMutableLiveData.postValue(null);
                        }
                    }catch (Exception e){
                        Log.d("TAG", "onResponse: "+e);
                    }
                }else {
                    Toast.makeText(context.getApplicationContext(), "No data", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(@NonNull Call<MainModel> call, @NonNull Throwable t) {
                Toast.makeText(context.getApplicationContext(), "Network Failed", Toast.LENGTH_SHORT).show();
            }
        });
    }

}