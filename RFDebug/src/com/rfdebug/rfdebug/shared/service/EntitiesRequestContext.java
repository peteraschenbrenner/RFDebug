package com.rfdebug.rfdebug.shared.service;

import java.util.List;

import com.google.web.bindery.requestfactory.shared.Request;
import com.google.web.bindery.requestfactory.shared.RequestContext;
import com.google.web.bindery.requestfactory.shared.Service;
import com.rfdebug.rfdebug.server.service.DAOServiceLocator;
import com.rfdebug.rfdebug.server.service.EntitiesDAO;
import com.rfdebug.rfdebug.shared.proxy.AProxy;
import com.rfdebug.rfdebug.shared.proxy.ATProxy;
import com.rfdebug.rfdebug.shared.proxy.AbstractVProxy;
import com.rfdebug.rfdebug.shared.proxy.ConcreteVProxy;
import com.rfdebug.rfdebug.shared.proxy.VTProxy;

@Service(value = EntitiesDAO.class, locator = DAOServiceLocator.class)
public interface EntitiesRequestContext extends RequestContext {

  // dummy methods to ensure that the entities are loaded
  Request<Void> todo(AProxy a);

  Request<Void> todo(AbstractVProxy abstractV);

  Request<Void> todo(ConcreteVProxy concreteV);

  Request<Void> todo(ATProxy at);

  Request<Void> todo(VTProxy stringBOPvtropertyValue);

  // used methods
  Request<Void> resetServerData();

  Request<List<AProxy>> loadAllAs();

  Request<List<AProxy>> createAs(List<AProxy> createdAs);
}
