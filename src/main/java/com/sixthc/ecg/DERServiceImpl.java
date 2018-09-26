package com.sixthc.ecg;

import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.BindingProvider;

import org.apache.log4j.Logger;

import com.sixthc.cim.der.CimDERGroupRequestServerSoap;
import com.sixthc.cim.der.CimDERRequestPort;
import com.sixthc.ecg.jsonpojo.CreateDerGroup;
import com.sixthc.ecg.jsonpojo.Der1DERGroup;
import com.sixthc.ecg.jsonpojo.Der1DERGroups;

import camelinaction.OrderInvalidException;
import camelinaction.OrderNotFoundException;
import ch.iec.tc57._2011.dergroupmessage.DERGroupResponseMessageType;

public class DERServiceImpl implements DERService {

	final static Logger logger = Logger.getLogger(DERServiceImpl.class);

	@Override
	public CreateDerGroup getDER(int mrid) throws OrderNotFoundException {

		logger.debug("getDER : " + mrid);

		Der1DERGroup der1 = new Der1DERGroup();

		CreateDerGroup group = new CreateDerGroup();

		der1.setDer1MRID(String.valueOf(mrid));
		der1.setComment("test get der");
		der1.setDer1Name("der1");

		group.setDer1DERGroups(new Der1DERGroups());

		group.getDer1DERGroups().setDer1DERGroup(der1);

		return group;
	}

	@Override
	public void updateDER(CreateDerGroup group) throws OrderInvalidException {
		// TODO Auto-generated method stub

	}

	@Override
	public String createDER(CreateDerGroup group) throws OrderInvalidException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void cancelOrder(int mrid) {
		// TODO Auto-generated method stub

	}

	@Override
	public DERGroupResponseMessageType getDERGroup(int mrid) throws OrderNotFoundException {

		logger.debug("getDERGroup : " + mrid);

		final QName SERVICE_NAME = new QName("http://sixthc.com/cim/DER", "cimDERRequest_Port");
		URL wsdlURL = CimDERRequestPort.WSDL_LOCATION;
		String address = "http://localhost:8088/mockDER";
		
		logger.debug("wsdl url : " + wsdlURL);

		logger.debug("a");
		CimDERRequestPort ss = new CimDERRequestPort(wsdlURL, SERVICE_NAME);
		CimDERGroupRequestServerSoap port = ss.getCimDERGroupRequestServerSoap();

		logger.debug("b");
		BindingProvider provider = (BindingProvider) port;
		provider.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, address);

		logger.debug("c");
		System.out.println("Invoking createDERGroup...");
		com.sixthc.cim.request.RequestDERGroupsRequest _createDERGroup_message = null;
		DERGroupResponseMessageType _createDERGroup__return = port.createDERGroup(_createDERGroup_message);
		System.out.println("createDERGroup.result=" + _createDERGroup__return);

		logger.debug("d");
		return _createDERGroup__return;

		/*
		 * DERGroupEventMessageType message = new DERGroupEventMessageType();
		 * 
		 * // load up faux header HeaderType header = new HeaderType();
		 * header.setComment("test"); header.setNoun("nouny");
		 * 
		 * // load up faux der group payload DERGroupPayloadType payload = new
		 * DERGroupPayloadType(); DERGroup dg = new DERGroup();
		 * 
		 * dg.setComment("dergroup"); ; dg.setDescription("description");
		 * dg.setMRID(String.valueOf(mrid)); DERGroups groups = new DERGroups();
		 * groups.getDERGroup().add(dg);
		 * 
		 * payload.setDERGroups(groups);
		 * 
		 * message.setHeader(header); message.setPayload(payload);
		 * 
		 * return message;
		 */
	}

}
