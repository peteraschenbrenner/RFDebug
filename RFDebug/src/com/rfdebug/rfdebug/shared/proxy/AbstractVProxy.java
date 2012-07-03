package com.rfdebug.rfdebug.shared.proxy;

import com.google.web.bindery.requestfactory.shared.EntityProxy;
import com.google.web.bindery.requestfactory.shared.EntityProxyId;
import com.google.web.bindery.requestfactory.shared.ProxyFor;
import com.rfdebug.rfdebug.server.model.AbstractV;
import com.rfdebug.rfdebug.server.service.VersionedEntityLocator;

@ProxyFor(value = AbstractV.class, locator = VersionedEntityLocator.class)
public interface AbstractVProxy extends EntityProxy, AbstractVersionedEntity {

  EntityProxyId<AbstractVProxy> stableId();

  VTProxy getVt();

  void setVt(VTProxy vt);
}
