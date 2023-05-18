package sh4k4w4t.github.io.logictask.Services.Network;

import retrofit2.Call;
import retrofit2.http.GET;
import sh4k4w4t.github.io.logictask.Services.Model.MainModel;

public interface RetrofitInterface {

    @GET("api/Android/style_wise_operation_list?JOB_NO_MST=MFG-23-00269&ITEM_NUMBER_ID=179&COUNTRY_ID=10&STYLE_NUMBER=SF-123&LINE_ID=595&USER_ID=374")
    Call<MainModel> getMainModelData();
}