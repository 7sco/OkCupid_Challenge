package com.example.franciscoandrade.okcupidchallenge.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Photo {
    @Expose
    @SerializedName("thumb_paths")
    private ThumbPaths thumbPaths;
    @Expose
    @SerializedName("caption")
    private String caption;
    @Expose
    @SerializedName("crop_rect")
    private CropRect cropRect;
    @Expose
    @SerializedName("id")
    private String id;
    @Expose
    @SerializedName("ordinal")
    private int ordinal;
    @Expose
    @SerializedName("original_size")
    private OriginalSize originalSize;
    @Expose
    @SerializedName("base_path")
    private String basePath;
    @Expose
    @SerializedName("full_paths")
    private FullPaths fullPaths;

    public ThumbPaths getThumbPaths() {
        return thumbPaths;
    }

    public String getCaption() {
        return caption;
    }

    public CropRect getCropRect() {
        return cropRect;
    }

    public String getId() {
        return id;
    }

    public int getOrdinal() {
        return ordinal;
    }

    public OriginalSize getOriginalSize() {
        return originalSize;
    }

    public String getBasePath() {
        return basePath;
    }

    public FullPaths getFullPaths() {
        return fullPaths;
    }
}
