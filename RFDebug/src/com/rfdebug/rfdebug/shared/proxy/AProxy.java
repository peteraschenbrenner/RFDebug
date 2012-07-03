package com.rfdebug.rfdebug.shared.proxy;

import java.util.List;

import com.google.web.bindery.requestfactory.shared.EntityProxy;
import com.google.web.bindery.requestfactory.shared.EntityProxyId;
import com.google.web.bindery.requestfactory.shared.ProxyFor;
import com.rfdebug.rfdebug.server.model.A;
import com.rfdebug.rfdebug.server.service.VersionedEntityLocator;

@ProxyFor(value = A.class, locator = VersionedEntityLocator.class)
public interface AProxy extends EntityProxy, AbstractVersionedEntity {

  EntityProxyId<AProxy> stableId();

  ATProxy getAt();

  void setAt(ATProxy at);

  List<AbstractVProxy> getVs();

  void setVs(List<AbstractVProxy> Vs);
}
