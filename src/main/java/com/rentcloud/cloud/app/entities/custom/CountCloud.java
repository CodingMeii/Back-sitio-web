/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rentcloud.cloud.app.entities.custom;

import com.rentcloud.cloud.app.entities.Cloud;

/**
 *
 * @author RYZEN
 */
public class CountCloud {
    private Long total;
    private Cloud cloud;

    public CountCloud() {
    }

    public CountCloud(Long total, Cloud cloud) {
        this.total = total;
        this.cloud = cloud;
    }

    public Long getTotal() {
        return total;
    }

    public Cloud getCloud() {
        return cloud;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public void setCloud(Cloud cloud) {
        this.cloud = cloud;
    }
}
