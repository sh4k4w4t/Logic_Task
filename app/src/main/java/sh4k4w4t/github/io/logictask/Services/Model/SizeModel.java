package sh4k4w4t.github.io.logictask.Services.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SizeModel {

    @SerializedName("po_break_down_id")
    @Expose
    private Integer poBreakDownId;
    @SerializedName("color_size_breakdown_id")
    @Expose
    private Integer colorSizeBreakdownId;
    @SerializedName("colour_id")
    @Expose
    private Integer colourId;
    @SerializedName("colour_name")
    @Expose
    private String colourName;
    @SerializedName("size_id")
    @Expose
    private Integer sizeId;
    @SerializedName("size_name")
    @Expose
    private String sizeName;
    @SerializedName("input_qnty")
    @Expose
    private Integer inputQnty;
    @SerializedName("output_qnty")
    @Expose
    private Integer outputQnty;
    @SerializedName("good")
    @Expose
    private Integer good;
    @SerializedName("reject")
    @Expose
    private Integer reject;
    @SerializedName("alter")
    @Expose
    private Integer alter;
    @SerializedName("spot")
    @Expose
    private Integer spot;
    @SerializedName("rectified")
    @Expose
    private Integer rectified;

    public SizeModel(Integer poBreakDownId, Integer colorSizeBreakdownId, Integer colourId, String colourName, Integer sizeId, String sizeName, Integer inputQnty, Integer outputQnty, Integer good, Integer reject, Integer alter, Integer spot, Integer rectified) {
        this.poBreakDownId = poBreakDownId;
        this.colorSizeBreakdownId = colorSizeBreakdownId;
        this.colourId = colourId;
        this.colourName = colourName;
        this.sizeId = sizeId;
        this.sizeName = sizeName;
        this.inputQnty = inputQnty;
        this.outputQnty = outputQnty;
        this.good = good;
        this.reject = reject;
        this.alter = alter;
        this.spot = spot;
        this.rectified = rectified;
    }

    public Integer getPoBreakDownId() {
        return poBreakDownId;
    }

    public void setPoBreakDownId(Integer poBreakDownId) {
        this.poBreakDownId = poBreakDownId;
    }

    public Integer getColorSizeBreakdownId() {
        return colorSizeBreakdownId;
    }

    public void setColorSizeBreakdownId(Integer colorSizeBreakdownId) {
        this.colorSizeBreakdownId = colorSizeBreakdownId;
    }

    public Integer getColourId() {
        return colourId;
    }

    public void setColourId(Integer colourId) {
        this.colourId = colourId;
    }

    public String getColourName() {
        return colourName;
    }

    public void setColourName(String colourName) {
        this.colourName = colourName;
    }

    public Integer getSizeId() {
        return sizeId;
    }

    public void setSizeId(Integer sizeId) {
        this.sizeId = sizeId;
    }

    public String getSizeName() {
        return sizeName;
    }

    public void setSizeName(String sizeName) {
        this.sizeName = sizeName;
    }

    public Integer getInputQnty() {
        return inputQnty;
    }

    public void setInputQnty(Integer inputQnty) {
        this.inputQnty = inputQnty;
    }

    public Integer getOutputQnty() {
        return outputQnty;
    }

    public void setOutputQnty(Integer outputQnty) {
        this.outputQnty = outputQnty;
    }

    public Integer getGood() {
        return good;
    }

    public void setGood(Integer good) {
        this.good = good;
    }

    public Integer getReject() {
        return reject;
    }

    public void setReject(Integer reject) {
        this.reject = reject;
    }

    public Integer getAlter() {
        return alter;
    }

    public void setAlter(Integer alter) {
        this.alter = alter;
    }

    public Integer getSpot() {
        return spot;
    }

    public void setSpot(Integer spot) {
        this.spot = spot;
    }

    public Integer getRectified() {
        return rectified;
    }

    public void setRectified(Integer rectified) {
        this.rectified = rectified;
    }

}
