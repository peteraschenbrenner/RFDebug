package com.rfdebug.rfdebug.server.service;

import com.google.web.bindery.requestfactory.shared.Locator;
import com.googlecode.objectify.util.DAOBase;
import com.rfdebug.rfdebug.server.model.VersionedEntity;

public class VersionedEntityLocator extends Locator<VersionedEntity, Long> {

  @Override
  public VersionedEntity create(Class<? extends VersionedEntity> clazz) {
    try {
      return clazz.newInstance();
    } catch (InstantiationException e) {
      throw new RuntimeException(e);
    } catch (IllegalAccessException e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public VersionedEntity find(Class<? extends VersionedEntity> clazz, Long id) {
    DAOBase daoBase = new DAOBase();
    return daoBase.ofy().find(clazz, id);
  }

  @Override
  public Class<VersionedEntity> getDomainType() {
    // Never called TODO really?
    return null;
  }

  @Override
  public Long getId(VersionedEntity domainObject) {
    return domainObject.getId();
  }

  @Override
  public Class<Long> getIdType() {
    return Long.class;
  }

  @Override
  public Object getVersion(VersionedEntity domainObject) {
    return domainObject.getVersion();
  }
}
