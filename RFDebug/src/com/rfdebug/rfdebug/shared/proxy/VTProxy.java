package com.rfdebug.rfdebug.shared.proxy;

import com.google.web.bindery.requestfactory.shared.EntityProxy;
import com.google.web.bindery.requestfactory.shared.EntityProxyId;
import com.google.web.bindery.requestfactory.shared.ProxyFor;
import com.rfdebug.rfdebug.server.model.VT;
import com.rfdebug.rfdebug.server.service.VersionedEntityLocator;

@ProxyFor(value = VT.class, locator = VersionedEntityLocator.class)
public interface VTProxy extends EntityProxy, AbstractNamedVersionedEntity {

  EntityProxyId<VTProxy> stableId();
}
