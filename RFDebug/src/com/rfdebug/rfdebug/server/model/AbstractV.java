package com.rfdebug.rfdebug.server.model;

import javax.persistence.Transient;

import com.googlecode.objectify.Key;
import com.googlecode.objectify.annotation.Cached;
import com.googlecode.objectify.annotation.Entity;

@Cached(expirationSeconds = 600)
@Entity
public abstract class AbstractV extends VersionedEntity {

  @Transient
  private VT vt;
  private Key<VT> vtKey;

  // required for objectify
  public AbstractV() {
  };

  protected AbstractV(VT vt) {
    this.vt = vt;
  }

  public VT getVt() {
    return vt;
  }

  public void setVt(VT vt) {
    this.vt = vt;
  }

  public Key<VT> getVtKey() {
    return vtKey;
  }

  public void setVtKey(Key<VT> vtKey) {
    this.vtKey = vtKey;
  }
}
