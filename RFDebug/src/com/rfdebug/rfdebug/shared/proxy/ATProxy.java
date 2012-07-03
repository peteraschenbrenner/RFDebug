package com.rfdebug.rfdebug.shared.proxy;

import java.util.List;

import com.google.web.bindery.requestfactory.shared.EntityProxy;
import com.google.web.bindery.requestfactory.shared.EntityProxyId;
import com.google.web.bindery.requestfactory.shared.ProxyFor;
import com.rfdebug.rfdebug.server.model.AT;
import com.rfdebug.rfdebug.server.service.VersionedEntityLocator;

@ProxyFor(value = AT.class, locator = VersionedEntityLocator.class)
public interface ATProxy extends EntityProxy, AbstractNamedVersionedEntity {

  EntityProxyId<ATProxy> stableId();

  List<VTProxy> getVts();

  void setVts(List<VTProxy> vts);
}
