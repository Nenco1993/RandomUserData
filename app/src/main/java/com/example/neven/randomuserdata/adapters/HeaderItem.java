package com.example.neven.randomuserdata.adapters;

/**
 * Created by Neven on 9.4.2017..
 */
public class HeaderItem extends Item {

    public HeaderItem(String title) {
        super(title);
    }

    @Override
    public int getItemType() {
        return HEADER_ITEM_TYPE;
    }
}
