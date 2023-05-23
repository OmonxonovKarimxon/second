package com.company.mapper;

public interface VideoLikeInfo {

    // id,video(id,name, ,channel(id,name),duration),preview_attach(id,url)
    Integer getId();

    String getVideoId();

    String getVideoPreview();

    String getChannelId();


    String getChannelName();

}
