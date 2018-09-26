package com.sixthc.ecg;

import com.sixthc.ecg.jsonpojo.CreateDerGroup;

import camelinaction.OrderInvalidException;
import camelinaction.OrderNotFoundException;
import ch.iec.tc57._2011.dergroupmessage.DERGroupResponseMessageType;

public interface DERService {

	CreateDerGroup getDER(int mrid) throws OrderNotFoundException;

    void updateDER(CreateDerGroup group) throws OrderInvalidException;

    String createDER(CreateDerGroup group) throws OrderInvalidException;

    void cancelOrder(int mrid);
    
    DERGroupResponseMessageType getDERGroup(int mrid) throws OrderNotFoundException;


}
