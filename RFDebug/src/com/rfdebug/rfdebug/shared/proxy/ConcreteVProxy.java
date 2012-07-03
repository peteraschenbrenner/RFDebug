package com.rfdebug.rfdebug.shared.proxy;

import com.google.web.bindery.requestfactory.shared.ProxyFor;
import com.rfdebug.rfdebug.server.model.ConcreteV;
import com.rfdebug.rfdebug.server.service.VersionedEntityLocator;

@ProxyFor(value = ConcreteV.class, locator = VersionedEntityLocator.class)
public interface ConcreteVProxy extends AbstractVProxy {

  String getConcreteStuff();

  void setConcreteStuff(String concreteStuff);
}
