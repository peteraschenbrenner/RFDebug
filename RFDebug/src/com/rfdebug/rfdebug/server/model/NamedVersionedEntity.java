package com.rfdebug.rfdebug.server.model;

public abstract class NamedVersionedEntity extends VersionedEntity {

  private String displayName;
  private String technicalName;

  // required for objectify
  public NamedVersionedEntity() {
  };

  public NamedVersionedEntity(String displayName, String technicalName) {
    this.displayName = displayName;
    this.technicalName = technicalName;
  };

  public String getDisplayName() {
    return displayName;
  }

  public void setDisplayName(String displayName) {
    this.displayName = displayName;
  }

  public String getTechnicalName() {
    return technicalName;
  }

  public void setTechnicalName(String technicalName) {
    this.technicalName = technicalName;
  }
}
