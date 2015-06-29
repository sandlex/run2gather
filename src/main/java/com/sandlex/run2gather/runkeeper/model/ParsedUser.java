package com.sandlex.run2gather.runkeeper.model;

/**
 * author: Alexey Peskov
 */
public class ParsedUser extends AbstractModelClass implements Requestable {

    private Integer userID;

    public ParsedUser() {
    }

    public ParsedUser(Integer userID) {
        this.userID = userID;
    }

    @Override
    public String getURI() {
        return "http://api.runkeeper.com/user";
    }

    @Override
    public String getAccept() {
        return "application/vnd.com.runkeeper.User+json";
    }

    public Integer getUserID() {
        return userID;
    }

}
