package com.planetaKino.pages.enums;

public enum Page {
    SHOWTIMES("Showtimes", "/showtimes/"),
    MOVIES("Movies", "/movies/");


    private final String name;
    private final String xpath;

    Page(String name, String xpath){
        this.name=name;
        this.xpath="//header//a[contains(@href,'"+xpath+"')]";
    }

    public static String resolveByName(String name){
        for (Page page:Page.values()) {
            if(page.name.equals(name)){
                return page.xpath;
            }
        }
        return null;
    }


}
