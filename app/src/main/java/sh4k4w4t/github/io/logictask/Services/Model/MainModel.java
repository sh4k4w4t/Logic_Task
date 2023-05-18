package sh4k4w4t.github.io.logictask.Services.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MainModel {
    @SerializedName("resultset")
    @Expose
    private Resultset resultset;

    public Resultset getResultset() {
        return resultset;
    }

    public void setResultset(Resultset resultset) {
        this.resultset = resultset;
    }

}