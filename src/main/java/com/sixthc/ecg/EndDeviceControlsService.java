package com.sixthc.ecg;


import com.sixthc.ecg.jsonpojo.CreateEndDeviceControls;

import ch.iec.tc57._2011.schema.message.ReplyType;



public interface EndDeviceControlsService {

	ReplyType get(int mrid) throws DeviceNotFoundException;

    void update(CreateEndDeviceControls group) throws DeviceInvalidException;

    ReplyType create(CreateEndDeviceControls group) throws DeviceInvalidException,InvalidJSON;

    void cancel(int mrid);
    
    ReplyType getDERGroup(int mrid) throws DeviceNotFoundException;


}
