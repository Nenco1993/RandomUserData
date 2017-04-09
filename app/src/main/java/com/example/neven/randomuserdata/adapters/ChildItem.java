package com.example.neven.randomuserdata.adapters;

/**
 * Created by Neven on 9.4.2017..
 */
public class ChildItem extends Item {


    public ChildItem(String picURL) {
        super(picURL);
    }


    @Override
    public int getItemType() {
        return CHILD_ITEM_TYPE;
    }
}
