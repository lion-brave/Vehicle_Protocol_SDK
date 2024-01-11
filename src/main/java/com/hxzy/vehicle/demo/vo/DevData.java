package com.hxzy.vehicle.demo.vo;

import com.hxzy.vehicle.demo.util.CoordinateTransformUtil;
import lombok.Data;
import java.util.Date;

/**
 * @Description: TODO
 * @Author Allen
 * @Date 2023/8/9
 * @Version V1.0
 **/
@Data
public class DevData {

    private Integer id;
    //Site ID
    private Integer stationId;
    /**
     * [Log level]:1/2/3/4 1: Regular data 2: ordinary message 3: Warning 4: error
     */
    private Integer level;
    /**
     * Message: Text data
     */
    private String msg;
    /**
     * Passenger flow starts with SN:3
     */
    private String devSn;
    /**
     * [Timestamp]:unix standard timestamp (seconds)
     */
    private Long timeStamp;
    /**
     * [Longitude] : ddmm.mmmm
     */
    private String lng;
    /**
     * [Latitude] : ddmm.mmmm
     */
    private String lat;
    /**
     * [Speed]: ddd.d (km/h)
     */
    private String speed;
    /**
     * [Location valid value] : A/V A: valid value, V: invalid value
     */
    private String effective;
    /**
     * [Number of entries] : a 32-bit integer
     */
    private Integer inNum;
    /**
     * [Outgoing number] : a 32-bit integer
     */
    private Integer outNum;
    /**
     * [Network] : 01
     */
    private Integer online;

    //Data time
    private Date createTime;

    //Vehicle ID
    private Integer busId;

    public DevData(String msg) throws Exception{
        String[] mss = msg.split(",");
        this.level = Integer.valueOf(mss[0]);
        this.msg = mss[1];
        this.devSn = mss[2];
        this.timeStamp = Long.valueOf(mss[3]);
        this.lng = mss[4];
        this.lat = mss[5];
        double[] googleGps = CoordinateTransformUtil.wgs84togcj02(Double.valueOf(this.lng), Double.valueOf(this.lat));
        this.lng = String.valueOf(googleGps[0]);
        this.lat = String.valueOf(googleGps[1]);

        this.speed = mss[6];
        this.effective = mss[7];
        this.inNum = Integer.valueOf(mss[8]);
        this.outNum = Integer.valueOf(mss[9]);
        this.online = Integer.valueOf(mss[10]);
        this.createTime = new Date(this.timeStamp*1000);
    }

}
