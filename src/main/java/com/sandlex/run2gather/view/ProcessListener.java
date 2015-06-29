package com.sandlex.run2gather.view;

/**
 * author: Alexey Peskov
 */
public interface ProcessListener {

    void welcome();

    void dashboard();

    void authorize();

    void saveUserAndActivities();

    void onCompleteAuthorization();
}
