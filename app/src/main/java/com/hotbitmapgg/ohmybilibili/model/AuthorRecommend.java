package com.hotbitmapgg.ohmybilibili.model;

import java.util.List;

/**
 * Created by hcc on 16/3/13.
 */
public class AuthorRecommend
{

    public int code;

    public List<AuthorData> list;


    public class AuthorData
    {

        public int aid;

        public int click;

        public String cover;

        public int favorites;

        public int review;

        public String title;

        public int video_review;
    }
}