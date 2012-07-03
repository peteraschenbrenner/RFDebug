package com.rfdebug.rfdebug.server.model;

import javax.persistence.Id;
import javax.persistence.PrePersist;

public abstract class VersionedEntity {

  @Id
  private Long id;
  private Integer version = 0;

  // required for entityproxy
  public VersionedEntity() {
  };

  @PrePersist
  public void onPersist() {
    this.version++;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long newId) {
    id = newId;
  }

  public Integer getVersion() {
    return version;
  }

  public void setVersion(Integer newVersion) {
    version = newVersion;
  }
}
