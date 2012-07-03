package com.rfdebug.rfdebug.shared.proxy;

public interface AbstractNamedVersionedEntity extends AbstractVersionedEntity {

  String getDisplayName();

  void setDisplayName(String displayName);

  String getTechnicalName();

  void setTechnicalName(String technicalName);
}
