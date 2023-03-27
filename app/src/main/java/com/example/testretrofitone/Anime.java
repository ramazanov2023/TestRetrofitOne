package com.example.testretrofitone;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Anime {

    @SerializedName("id")
    @Expose
    public Integer id;
    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("russian")
    @Expose
    public String russian;
    @SerializedName("image")
    @Expose
    public Image image;
    @SerializedName("url")
    @Expose
    public String url;
    @SerializedName("kind")
    @Expose
    public String kind;
    @SerializedName("score")
    @Expose
    public String score;
    @SerializedName("status")
    @Expose
    public String status;
    @SerializedName("episodes")
    @Expose
    public Integer episodes;
    @SerializedName("episodes_aired")
    @Expose
    public Integer episodesAired;
    @SerializedName("aired_on")
    @Expose
    public String airedOn;
    @SerializedName("released_on")
    @Expose
    public String releasedOn;
    @SerializedName("rating")
    @Expose
    public String rating;

    @SerializedName("duration")
    @Expose
    public Integer duration;
    @SerializedName("description")
    @Expose
    public String description;

    @SerializedName("description_source")
    @Expose
    public Object descriptionSource;
    @SerializedName("franchise")
    @Expose
    public String franchise;

    @SerializedName("anons")
    @Expose
    public Boolean anons;
    @SerializedName("ongoing")
    @Expose
    public Boolean ongoing;
    @SerializedName("thread_id")
    @Expose
    public Integer threadId;
    @SerializedName("topic_id")
    @Expose
    public Integer topicId;
    @SerializedName("myanimelist_id")
    @Expose
    public Integer myanimelistId;
    @SerializedName("rates_scores_stats")
    @Expose
    public List<RatesScoresStat> ratesScoresStats;
    @SerializedName("rates_statuses_stats")
    @Expose
    public List<RatesStatusesStat> ratesStatusesStats;

    @SerializedName("licensors")
    @Expose
    public List<String> licensors;
    @SerializedName("genres")
    @Expose
    public List<Genre> genres;
    @SerializedName("studios")
    @Expose
    public List<Studio> studios;
    @SerializedName("videos")
    @Expose
    public List<Video> videos;
    @SerializedName("screenshots")
    @Expose
    public List<Screenshot> screenshots;
    @SerializedName("user_rate")
    @Expose
    public Object userRate;


    public class Genre {

        @SerializedName("id")
        @Expose
        public Integer id;
        @SerializedName("name")
        @Expose
        public String name;
        @SerializedName("russian")
        @Expose
        public String russian;
        @SerializedName("kind")
        @Expose
        public String kind;

    }

    public class Image {

        @SerializedName("original")
        @Expose
        public String original;
        @SerializedName("preview")
        @Expose
        public String preview;
        @SerializedName("x96")
        @Expose
        public String x96;
        @SerializedName("x48")
        @Expose
        public String x48;

    }

    public class RatesScoresStat {

        @SerializedName("name")
        @Expose
        public Integer name;
        @SerializedName("value")
        @Expose
        public Integer value;

    }

    public class RatesStatusesStat {

        @SerializedName("name")
        @Expose
        public String name;
        @SerializedName("value")
        @Expose
        public Integer value;

    }

    public class Screenshot {

        @SerializedName("original")
        @Expose
        public String original;
        @SerializedName("preview")
        @Expose
        public String preview;

    }

    public class Studio {

        @SerializedName("id")
        @Expose
        public Integer id;
        @SerializedName("name")
        @Expose
        public String name;
        @SerializedName("filtered_name")
        @Expose
        public String filteredName;
        @SerializedName("real")
        @Expose
        public Boolean real;
        @SerializedName("image")
        @Expose
        public String image;

    }

    public class Video {

        @SerializedName("id")
        @Expose
        public Integer id;
        @SerializedName("url")
        @Expose
        public String url;
        @SerializedName("image_url")
        @Expose
        public String imageUrl;
        @SerializedName("player_url")
        @Expose
        public String playerUrl;
        @SerializedName("name")
        @Expose
        public String name;
        @SerializedName("kind")
        @Expose
        public String kind;
        @SerializedName("hosting")
        @Expose
        public String hosting;

    }
}
