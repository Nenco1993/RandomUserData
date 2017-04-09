package com.example.neven.randomuserdata.adapters;

/**
 * Created by Neven on 9.4.2017..
 */
public abstract class Item {

    public static final int HEADER_ITEM_TYPE = 0;
    public static final int CHILD_ITEM_TYPE = 1;
    private String titleOrPicURL;

    public Item(String titleOrPicURL) {
        this.titleOrPicURL = titleOrPicURL;
    }

    public String getTitleOrPicURL() {
        return titleOrPicURL;
    }

    public abstract int getItemType();


}
