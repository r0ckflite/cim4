package com.sixthc.ecg.impl;

import java.net.URL;

import javax.xml.namespace.QName;

import org.apache.log4j.Logger;

import com.sixthc.ecg.DeviceInvalidException;
import com.sixthc.ecg.DeviceNotFoundException;
import com.sixthc.ecg.EndDeviceControlsService;
import com.sixthc.ecg.jsonpojo.CreateEndDeviceControls;

import ch.iec.tc57._2011.schema.message.ErrorType;
import ch.iec.tc57._2011.schema.message.ReplyType;
import ch.iec.tc57._2017.executeenddevicecontrols.EndDeviceControlsPort;
import ch.iec.tc57._2017.executeenddevicecontrols.ExecuteEndDeviceControls;
import ch.iec.tc57._2017.executeenddevicecontrols.FaultMessage;

public class EndDeviceControlsServiceImpl implements EndDeviceControlsService {

	final static Logger logger = Logger.getLogger(EndDeviceControlsServiceImpl.class);

	@Override
	public ReplyType get(int mrid) throws DeviceNotFoundException {
		ReplyType reply = new ReplyType();
		reply.setResult("OK");
		
		ErrorType error = new ErrorType();
		error.setCode("0.0");
		reply.getError().add(error);
		
		return reply;
	}

	@Override
	public void update(CreateEndDeviceControls group) throws DeviceInvalidException {
		// TODO Auto-generated method stub

	}

	@Override
	public ReplyType create(CreateEndDeviceControls group) throws DeviceInvalidException {
		logger.debug("create : "
				+ String.valueOf(group.getPayload().getEndDeviceControls().getEndDeviceControl().getMRID()));

		final QName SERVICE_NAME = new QName("http://iec.ch/TC57/2017/ExecuteEndDeviceControls",
				"ExecuteEndDeviceControls");
		URL wsdlURL = ExecuteEndDeviceControls.WSDL_LOCATION;
		
		ExecuteEndDeviceControls ss = new ExecuteEndDeviceControls(wsdlURL, SERVICE_NAME);
		EndDeviceControlsPort port = ss.getEndDeviceControlsPort();

		{
			logger.debug("Invoking createEndDeviceControls...");
			ch.iec.tc57._2011.schema.message.HeaderType _createEndDeviceControls_headerVal = null;
			javax.xml.ws.Holder<ch.iec.tc57._2011.schema.message.HeaderType> _createEndDeviceControls_header = new javax.xml.ws.Holder<ch.iec.tc57._2011.schema.message.HeaderType>(
					_createEndDeviceControls_headerVal);
			ch.iec.tc57._2011.schema.message.RequestType _createEndDeviceControls_request = null;
			ch.iec.tc57._2017.enddevicecontrolsmessage.EndDeviceControlsPayloadType _createEndDeviceControls_payloadVal = null;
			javax.xml.ws.Holder<ch.iec.tc57._2017.enddevicecontrolsmessage.EndDeviceControlsPayloadType> _createEndDeviceControls_payload = new javax.xml.ws.Holder<ch.iec.tc57._2017.enddevicecontrolsmessage.EndDeviceControlsPayloadType>(
					_createEndDeviceControls_payloadVal);
			javax.xml.ws.Holder<ch.iec.tc57._2011.schema.message.ReplyType> _createEndDeviceControls_reply = new javax.xml.ws.Holder<ch.iec.tc57._2011.schema.message.ReplyType>();
			try {
				port.createEndDeviceControls(_createEndDeviceControls_header, _createEndDeviceControls_request,
						_createEndDeviceControls_payload, _createEndDeviceControls_reply);

				logger.debug("createEndDeviceControls._createEndDeviceControls_header="
						+ _createEndDeviceControls_header.value);
				logger.debug("createEndDeviceControls._createEndDeviceControls_payload="
						+ _createEndDeviceControls_payload.value);
				logger.debug("createEndDeviceControls._createEndDeviceControls_reply="
						+ _createEndDeviceControls_reply.value);
				return _createEndDeviceControls_reply.value;
			} catch (FaultMessage e) {
				logger.debug("Expected exception: FaultMessage has occurred.");
				logger.debug(e.toString());
			}
		}
		
		throw new DeviceInvalidException("error occurred");

	}

	@Override
	public void cancel(int mrid) {
		// TODO Auto-generated method stub

	}

	@Override
	public ReplyType getDERGroup(int mrid) throws DeviceNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

}
